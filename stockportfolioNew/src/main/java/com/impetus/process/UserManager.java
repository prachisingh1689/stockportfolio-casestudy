package com.impetus.process;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.impetus.POJO.HibernateUtil;
import com.impetus.POJO.UserMaster;
import com.impetus.action.AddStockAction;
import com.impetus.services.MyException;

/**
 * The Class UserManager. Middle tier which lies between UserMaster Pojo Class
 * and User_Master table.
 * <P>
 * Provides various attributes and behaviour required to perform transaction
 * with User_Master table such as retrieval,submission and updation of User
 * Details .
 * 
 * @author Prachi.Singh
 * 
 */
public class UserManager{

	/** The logger. */
	private static Logger logger = Logger.getLogger(AddStockAction.class);
	private static UserManager userManager=null;
	private UserManager()
	{
		
	}
	public static UserManager getUserManagerInstance()
	{
		if(userManager==null)
		{
			userManager=new UserManager();
			return userManager;
		}
		else
			return userManager;
	}

	/**
	 * Addto table method used for registration. This method adds a new user to
	 * user_master table
	 * 
	 * @param user
	 *            the user
	 */
	public void addtoTable(UserMaster user) {
		logger.info("entering addtotable method in :user manager");
		logger.info("in addtotable");
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.getTransaction().begin();
			session.save(user);
			session.getTransaction().commit();
			logger.info("transaction successfully committed");
		} catch (HibernateException e) {
			logger.warn("hibernate exception inside :catch block :add stock manager ");
			logger.error(e.getMessage());
			session.getTransaction().rollback();
			throw new MyException("Hibernate exception",e);
		}
	}
}
