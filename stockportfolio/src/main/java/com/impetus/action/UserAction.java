package com.impetus.action;

import org.apache.log4j.Logger;

import com.impetus.POJO.UserMaster;
import com.impetus.process.UserManager;
import com.opensymphony.xwork2.ActionSupport;

/**
 * The Class UserAction.The <code>UserAction</code> is a Action class that
 * provides attributes and method to initiate registration process. It extends
 * ActionSupport in order to provide Action support messages.
 * 
 * @author Prachi.Singh
 */
public class UserAction extends ActionSupport {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The logger. */
	private static Logger logger = Logger.getLogger(UserAction.class);

	/** The user. */
	private UserMaster user;

	/** The user manager. */
	private UserManager userManager = new UserManager();

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

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */
	/**
	 * Execute() method of UserAction class. this method is used to initiate
	 * registration process of user. calls addtotable method of usermanager
	 * class.
	 * 
	 * @return SUCCESS if user is registered
	 * 
	 */
	public String execute() {
		logger.info(user + "-----------------" + user.getFirstname());
		if (user.getFirstname().equals("")) {
			addActionError(getText("register empty"));
			return INPUT;
		} else {
			logger.info("in execute of : user_action");
			logger.warn("debug message is add");
			logger.info("IN ADD ACTION");
			userManager.addtoTable(getUser());
			return SUCCESS;
		}

	}

	public void validate() {
		super.validate();

		String mobile = Long.toString(user.getMobile());
		if (mobile.length() > 0) {
			if ((mobile.length() > 11) || (mobile.length() < 8)
					|| (mobile.matches("^[0-9]"))) {
				addFieldError("user.mobile", "Invalid mobile number");
			}
		}
	}

}