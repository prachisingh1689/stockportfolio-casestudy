package com.impetus.process;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import com.impetus.POJO.HibernateUtil;
import com.impetus.POJO.UserMaster;
import com.impetus.action.AddStockAction;
import com.opensymphony.xwork2.ActionContext;

/**
 * The Class LoginActionManager. Middle tier which lies between UserMaster Pojo
 * Class and User_Master table.
 * <P>
 * Provides various attributes and behaviour required to perform transaction
 * with user_master table It is used for user authentication and authorisation
 * 
 * @author Prachi.Singh
 */
public class LoginActionManager extends HibernateUtil {

	/** The logger. */
	private static Logger logger = Logger.getLogger(AddStockAction.class);

	/**
	 * Compare. This method compares user details entered with the database for
	 * login authentication and authorisation.
	 * 
	 * @param username
	 *            the username
	 * @param password
	 *            the password
	 * @return the success if user is authorised.
	 * @return the input if there is mismatch of user credentials
	 * @return the error in case of hibernate exception
	 */
	public String compare(String username, String password) {
		logger.info("entering compare method in :login action manager");
		logger.info(username + password);
		Session session = null;
		String result;

		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.getTransaction().begin();
			logger.info("compare called");
			logger.info("user:" + username + "  pass:" + password);
			Query query = session
					.createQuery("from UserMaster c where username=? and password=?");
			query.setString(0, username);
			query.setString(1, password);
			logger.info("size of query:" + query.list().size());
			List<UserMaster> user = query.list();
			for (UserMaster c : user) {

				Map<String, Object> loginSession = ActionContext.getContext()
						.getSession();
				logger.info(c.getId());
				loginSession.put("user_id", c.getId());
				loginSession.put("username", c.getUsername());
				loginSession.put("firstname", c.getFirstname());
				loginSession.put("lastname", c.getLastname());
			}
			if (query.list().size() == 1) {
				result = "success";
			} else {

				result = "input";
			}

		} catch (HibernateException e) {
			logger.warn("hibernate exception inside : login action manager ");
			logger.error(e.getMessage());
			session.getTransaction().rollback();
			result = "error";
		}

		session.getTransaction().commit();
		logger.info("transaction successfully committed");
		return result;

	}
}
