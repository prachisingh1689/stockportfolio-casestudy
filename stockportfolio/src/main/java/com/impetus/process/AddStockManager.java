package com.impetus.process;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import com.impetus.POJO.HibernateUtil;
import com.impetus.POJO.UserStockMaster;
import com.impetus.action.AddStockAction;
import com.impetus.services.MyException;
import com.opensymphony.xwork2.ActionContext;

/**
 * The Class AddStockManager. Middle tier which lies between UserStockMaster
 * Pojo Class and User_Stock_Master table.
 * <P>
 * Provides various attributes and behaviour required to perform transaction
 * with User_Stock_Master table such as retrieval,submission and updation of
 * User portfolio Details .
 * 
 * @author Prachi.Singh
 * 
 */
public class AddStockManager extends HibernateUtil {

	/**
	 * The logger.
	 * Log4j Instance to maintain logs of activities happens through
	 * AddStockManager class.
	 */
	private static Logger logger = Logger.getLogger(AddStockAction.class);

	/**
	 * Addtoportfolio. This method adds the stock to user_stock_master table
	 * corresponding to the given user stock id.
	 * 
	 * @param userstock
	 *            the userstock
	 */
	public void addtoportfolio(UserStockMaster userstock) {
		logger.info("entering add_to_portfolio method in :add stock manager");
		Session session = null;
		session = HibernateUtil.getSessionFactory().openSession();
		session.getTransaction().begin();
		session.save(userstock);
		session.getTransaction().commit();

	}

	/**
	 * Delete. This method deletes stock from the user_stock_master table
	 * corresponding to the given user stock id and stock id.
	 * 
	 * @param id
	 *            the userstock id
	 * @return the object of user stock master
	 */
	public UserStockMaster delete(int id) {
		logger.info("entering delete method in :add stock manager");
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		UserStockMaster stock = (UserStockMaster) session.load(
				UserStockMaster.class, id);
		if (null != stock) {
			/* session.delete(stock); */
			Query query = session
					.createQuery("delete from UserStockMaster where id=?");
			query.setInteger(0, stock.getUserstockid());
			query.executeUpdate();
		}
		
		session.getTransaction().commit();
		logger.info("deleted successfully");
		logger.info("transaction successfully committed-entry deleted");
		return stock;
	}

	/**
	 * List. This method retrieves all stocks from the user_stock_master table.
	 * 
	 * @return the userstocklist.
	 */
	@SuppressWarnings("unchecked")
	public List<UserStockMaster> list() {
		logger.info("entering list method in :add stock manager");

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		List<UserStockMaster> userstocklist = null;
		int id = (Integer) ActionContext.getContext().getSession()
				.get("user_id");
		logger.info(id);
		try {
			
			userstocklist = (List<UserStockMaster>) session.createQuery(
					"from UserStockMaster where user.id = '" + id + "'").list();

		} catch (HibernateException e) {
			logger.warn("hibernate exception inside :catch block :add stock manager ");
			logger.error(e.getMessage());
			session.getTransaction().rollback();
			throw new MyException("Hibernate exception",e);
		}
		session.getTransaction().commit();
		logger.info(userstocklist);
		logger.info("transaction successfully committed");
		return userstocklist;
	}
}