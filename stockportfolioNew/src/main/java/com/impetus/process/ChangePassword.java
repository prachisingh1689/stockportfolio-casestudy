/**
 * 
 */
package com.impetus.process;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.impetus.POJO.HibernateUtil;
import com.impetus.POJO.UserMaster;
import com.impetus.services.MyConstant;


/**
 * @author prachi.singh
 *
 */
public class ChangePassword 
{

	/**
	 * The logger. Log4j Instance to maintain logs of activities happens through
	 * ChangePassword class.
	 */
	private static Logger logger = Logger.getLogger(ChangePassword.class);
	private static ChangePassword changePassword= null;
	private ChangePassword()
	{
		
	}
	public static ChangePassword getChangePasswordInstance()
	{
		if(changePassword==null)
		{		
			changePassword=new ChangePassword();
			return changePassword;
		}
		else
			return changePassword;
		
	}
	

	/**
	 * changePassword. This method changes password from the user_master table
	 * corresponding to the given user id
	 * @param id
	 *            the user id
	 * @param newpassword
	 * 			  the new password to be reset
	 * @return SUCCESS
	 */
	public String changePassword(int id,String newpassword)
	{	
		logger.info("entering changePassword method in :ChangePassword manager");
		Session session = null;
		
		try
		{session= HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		UserMaster user = (UserMaster) session.load(UserMaster.class,id);

		if(user!= null)
		{
			user.setPassword(newpassword);
			session.save(user);
		}
		}
		catch(HibernateException e)
		{
			logger.error(e.getMessage());
			session.getTransaction().rollback();
		}
		session.getTransaction().commit();
		logger.info("transaction successfully committed");
		return MyConstant.SUCCESS;		

	}
}
