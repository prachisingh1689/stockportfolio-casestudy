package com.impetus.services.mail;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import com.impetus.POJO.HibernateUtil;
import com.impetus.POJO.UserStockMaster;
import com.impetus.POJO.XMLStockMaster;

/**
 * The Class Variation_thread_manager. Middle tier which lies between
 * UserStockMaster Pojo Class and User_Stock_Master table.
 * <P>
 * Provides various attributes and behaviour required to perform transaction
 * with User_Stock_Master table such as retrieval,submission and updation of
 * User portfolio change for email alerts.
 * 
 * @author prachi.singh
 * 
 */
public class VariationThreadManager extends HibernateUtil {

	private static Logger logger = Logger
			.getLogger(VariationThreadManager.class);

	/**
	 * Check change. This method checks the variation of current price from the
	 * added price and returns variation to actin class.
	 * 
	 * @param xmlstockList
	 *            the xmlstock list that has current price
	 * @param addedPrice
	 *            the added price at the time of stock purchase
	 * @return variation
	 */
	public synchronized Float checkChange(List<XMLStockMaster> xmlstockList,
			Float addedPrice) {
		logger.info("entering check change method of variation thread manager");
		Float variation = 0.0f;
		int xmlid = 0;
		;
		Float currentPrice = 0.0f;
		for (XMLStockMaster xml : xmlstockList) {
			if (xmlid < xml.getXml_id()) {
				currentPrice = xml.getPrice();
				logger.info(xml.getTime());
			}
		}
		variation = ((currentPrice - addedPrice) / addedPrice) * 100;
		return variation;

	}

	/**
	 * Gets the details.
	 * 
	 * @param userstockid
	 *            the userstockid
	 * @return the details
	 */
	@SuppressWarnings("unchecked")
	public synchronized List<UserStockMaster> getDetails(int userstockid) {
		logger.info("entering get details method of variation thread manager");
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		List<UserStockMaster> userstockList = null;
		try {

			userstockList = (List<UserStockMaster>) session.createQuery(
					"from UserStockMaster where userstockid='" + userstockid
							+ "'").list();
		} catch (HibernateException e) {
			logger.warn("hibernate exception inside :catch block: variation thread manager ");
			logger.error(e.getMessage());

			session.getTransaction().rollback();
		}
		session.getTransaction().commit();
		logger.info("transaction successfully committed");
		logger.info(userstockList);
		return userstockList;
	}

	/**
	 * Gets the change.
	 * 
	 * @return the change
	 */
	@SuppressWarnings("unchecked")
	public List<UserStockMaster> getchange() {
		logger.info("entering get change method in :variation thread manager");
		ArrayList<UserStockMaster> stockalertlist = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		try {
			Query query = session.createQuery("from AlertMaster");
			stockalertlist = (ArrayList<UserStockMaster>) query.list();
		} catch (HibernateException e) {
			logger.warn("hibernate exception inside :catch block: variation thread manager ");
			logger.error(e.getMessage());

			session.getTransaction().rollback();
		}

		session.getTransaction().commit();
		logger.info("transaction successfully committed");

		return stockalertlist;
	}

	/**
	 * getmailinglist Gets the mailing list for users where change is not null
	 * 
	 * @return the userstocklist
	 */
	@SuppressWarnings("unchecked")
	public synchronized List<UserStockMaster> getMailingList() {
		logger.info("entering get mailing list method in :variation thread manager");
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		List<UserStockMaster> userstockList = null;

		try {

			userstockList = (List<UserStockMaster>) session.createQuery(
					"from UserStockMaster where change is not null").list();
		} catch (HibernateException e) {
			logger.warn("hibernate exception inside :catch block: variation thread manager ");
			logger.error(e.getMessage());

			session.getTransaction().rollback();
		}
		session.getTransaction().commit();
		logger.info("transaction successfully committed");
		logger.info(userstockList);
		return userstockList;
	}

	/**
	 * Delete alert. deletes alert when email is dispatched for the specified
	 * userstockid
	 * 
	 * @param userstockid
	 *            the userstockid
	 */
	public synchronized void deleteAlert(int userstockid) {
		logger.info("entering delete alert method in :variation thread manager");
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		UserStockMaster stock = (UserStockMaster) session.load(
				UserStockMaster.class, userstockid);
		logger.info(stock + "--------------------------");
		stock.setChange(null);
		session.save(stock);
		session.getTransaction().commit();
		logger.info("transaction successfully committed");

	}
}
