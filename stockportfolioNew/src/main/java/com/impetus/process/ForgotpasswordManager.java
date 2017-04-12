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
import com.impetus.services.MyException;
import com.opensymphony.xwork2.ActionContext;

/**
 * The Class ForgotpasswordManager. Middle tier which lies between UserMaster
 * Pojo Class and User_Master table.
 * <P>
 * Provides various attributes and behaviour required to perform transaction
 * with User_Master table. It is used for user authentication and authorisation
 * 
 * @author Prachi.Singh
 */
public class ForgotpasswordManager {

	/** The logger. */
	private static Logger logger = Logger.getLogger(AddStockAction.class);
	private static ForgotpasswordManager forgotpasswordManager=null;
	private ForgotpasswordManager()
	{
		
	}
	public static ForgotpasswordManager getForgotpasswordManagerInstance()
	{
		if(forgotpasswordManager==null)
		{
			forgotpasswordManager=new ForgotpasswordManager();
			return forgotpasswordManager;
		}
		else 
			return forgotpasswordManager;
		
	}
	/**
	 * Compare. this method compares the input email id for authentication to
	 * send password.
	 * 
	 * @param email
	 *            the email id that is compared for authentication
	 * @return the user master object
	 */
	public UserMaster compare(String email) {
		logger.info("entering compare method method in :forgot password");

		Session session = null;

		List<UserMaster> user = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.getTransaction().begin();
			logger.warn("Forgot password compare called");
			Query query = session.createQuery("from UserMaster where email='"
					+ email + "'");
			logger.info("size of query:" + query.list().size());
			user = query.list();

			for (UserMaster c : user) {

				Map<String, Object> loginSession = ActionContext.getContext()
						.getSession();
				logger.info(c.getId());
				loginSession.put("user_id", c.getId());
				loginSession.put("username", c.getUsername());
				loginSession.put("password", c.getPassword());

				return c;
			}
		} catch (HibernateException e) {
			logger.warn("hibernate exception inside :forgot password ");
			logger.error(e.getMessage());
			session.getTransaction().rollback();
			throw new MyException("Hibernate exception",e);
		}

		session.getTransaction().commit();
		logger.info("transaction successfully committed");
		return null;
	}
}
