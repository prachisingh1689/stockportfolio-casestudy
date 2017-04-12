package com.impetus.action;

import org.apache.log4j.Logger;

import com.impetus.POJO.UserMaster;
import com.impetus.process.Forgot_passwordManager;
import com.impetus.services.mail.EmailAlert;

import com.opensymphony.xwork2.ActionSupport;

/**
 * The Class Forgot_passwordAction.The <code>Forgot_passwordAction</code> is a
 * Action class that provides attributes and method to send password on
 * registered email id. It extends ActionSupport in order to provide Action
 * support messages.
 * 
 * @author Prachi.Singh
 */

public class Forgot_passwordAction extends ActionSupport {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The linkcontroller. */
	private Forgot_passwordManager linkcontroller;

	/** The user. */
	private UserMaster user;

	/** The email. */
	private String email;

	/** The logger. */
	private static Logger logger = Logger
			.getLogger(Forgot_passwordAction.class);

	/**
	 * Getter methods to obtain values of private data members of POJO Class.
	 * Setter methods to set private data member value of Model Object.
	 */
	/**
	 * Gets the email.
	 * 
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Sets the email.
	 * 
	 * @param email
	 *            the new email
	 */
	public void setEmail(String email) {
		this.email = email;
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
	 * Gets the user.
	 * 
	 * @return the user
	 */
	public UserMaster getUser() {
		return user;
	}

	/**
	 * Execute() method of Forgot_passwordAction class. this method is used to
	 * to send password on registered email id. cals compare method of
	 * Forgot_passwordManager class to check if email id is registered or not.
	 * 
	 * @return SUCCESS if email is dispatched
	 * @return failure if user have enter invalid email id or user account
	 *         doesn't exist in database.
	 */
	public String execute() {
		logger.info("entering execute of :forgot password");

		linkcontroller = new Forgot_passwordManager();

		UserMaster user = new UserMaster();
		user = linkcontroller.compare(email);
		if (user == null) {
			logger.warn("invalid email");
			addActionError("Invalid Email_Id");
			return "error";

		} else {
			String name = user.getUsername();
			String password = user.getPassword();
			String body = "Hi " + name + "\n" + "your password is " + password;
			String sub = "your password";
			EmailAlert.dispatchEmail(email, sub, body);
			addActionMessage("Password is sent, Check your Email_id & login to continue");
			return "success";

		}
	}

}
