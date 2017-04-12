package com.impetus.process;

import org.apache.log4j.Logger;
import org.hibernate.Session;

import com.impetus.POJO.HibernateUtil;
import com.impetus.POJO.UserMaster;
import com.impetus.action.AddStockAction;

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
public class UserManager extends HibernateUtil {

	/** The logger. */
	private static Logger logger = Logger.getLogger(AddStockAction.class);

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
		session = HibernateUtil.getSessionFactory().openSession();
		session.getTransaction().begin();
		session.save(user);
		session.getTransaction().commit();
		logger.info("transaction successfully committed");
	}
}
