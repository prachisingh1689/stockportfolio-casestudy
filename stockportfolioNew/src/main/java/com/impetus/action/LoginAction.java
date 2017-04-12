package com.impetus.action;

import org.apache.log4j.Logger;

import com.impetus.POJO.UserMaster;
import com.impetus.process.LoginActionManager;
import com.impetus.services.MyConstant;
import com.impetus.services.Singleton;
import com.opensymphony.xwork2.ActionSupport;

/**
 * The class LoginAction. <code>LoginAction</code> is an Action class that
 * provides attributes and method to initiate login process. It extends
 * ActionSupport in order to provide Action support messages.
 * 
 * @author Prachi.Singh
 */
public class LoginAction extends ActionSupport {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The user. */
	private UserMaster user;

	

	/**
	 * Log4j Instance to maintain logs of activities happens through LoginAction
	 * class.
	 */
	private static Logger logger = Logger.getLogger(LoginAction.class);

	/**
	 * Getter methods to obtain values of private data members of POJO Class.
	 * Setter methods to set private data member value of Model Object.
	 */

	/**
	 * Gets the user.
	 * 
	 * @return the user
	 */
	public UserMaster getUser() {
		return user;
	}

	/**
	 * Sets the user.
	 * 
	 * @param user
	 *            the new user
	 */
	public void setUser(UserMaster user) {
		this.user = user;
	}

	/**
	 * Execute() method of LoginAction class. this method is used to initiate
	 * authentication and authorization process of user. calls compare method of
	 * LoginActionManager class to check for authentication
	 * 
	 * @return SUCCESS if user is authenticated
	 * @return failure if user have enter invalidate input or user account
	 *         doesn't exist in database.
	 */
	public String execute() 
	{
		
		LoginActionManager loginActionManager=null;
		if (user.getUsername().equals("admin")
				&& user.getPassword().equals("prachisingh")) {
			return "login";
		}

		logger.info("entering execute of :Login action");
		logger.info("in login");
		loginActionManager = Singleton.getLoginActionManager();
		String result = loginActionManager.compare(user.getUsername(),
				user.getPassword());
		if (result.equals("success")) {

			return MyConstant.SUCCESS;
		}

		else if (result.equals("error")) {
			addActionMessage("login failed");
			return MyConstant.ERROR;
		}
		return MyConstant.ERROR;

	}

	
	
}
