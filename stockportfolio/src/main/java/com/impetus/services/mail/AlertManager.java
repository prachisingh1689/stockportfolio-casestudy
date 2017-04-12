package com.impetus.services.mail;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.impetus.POJO.HibernateUtil;
import com.impetus.POJO.UserStockMaster;
import com.impetus.action.AddStockAction;

/**
 * The Class AlertManager. Middle tier which lies between UserStockMaster Pojo
 * Class and User_Stock_Master table.
 * <P>
 * Provides various attributes and behaviour required to perform transaction
 * with User_Stock_Master table. such as retrieval,submission and updation of
 * User portfolio Details .
 * 
 * @author Prachi.Singh
 */
public class AlertManager extends HibernateUtil {

	/**
	 * The logger. Log4j Instance to maintain logs of activities happens through
	 * AlertManager class.
	 */
	private static Logger logger = Logger.getLogger(AddStockAction.class);

	/**
	 * Add method. Adds the Change(value of alert set by user) to the
	 * corresponding userstockid in user_stock_master table
	 * 
	 * @param change
	 *            is the deflection for alert set by the user
	 * @param userstockid
	 *            the userstockid for which the alert is to be set
	 * @return success if change added successfully
	 */
	public String add(float change, int userstockid) {
		logger.info("entering add method in :alert manager");
		Session session = null;
		logger.info("In AlertManager");
		logger.info("change----" + change);
		logger.info("userstockid---" + userstockid);
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			UserStockMaster userstock = (UserStockMaster) session.load(
					UserStockMaster.class, userstockid);
			if (null != userstock)

			{
				userstock.setChange(change);
				session.save(userstock);
			}
		} catch (HibernateException e) {
			logger.warn("hibernate exception inside :catch block: alert manager ");
			logger.error(e.getMessage());

			session.getTransaction().rollback();
		}
		session.getTransaction().commit();
		logger.info("transaction successfully committed");
		return "success";
	}

}
