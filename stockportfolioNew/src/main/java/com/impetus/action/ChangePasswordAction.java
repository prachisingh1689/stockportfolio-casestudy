/**
 * 
 */
package com.impetus.action;

import org.apache.log4j.Logger;

import com.impetus.process.ChangePassword;
import com.impetus.services.MyConstant;
import com.impetus.services.Singleton;
//import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * The Class ChangePasswordAction.. the <code>ChangePasswordAction</code> is an Action class
 * that provides attributes and method to initiate password change in user
 * portfolio. It extends ActionSupport in order to provide Action support
 * messages
 * 
 * @author Prachi.Singh
 */
public class ChangePasswordAction extends ActionSupport

{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/** The logger. */
	private static Logger logger = Logger.getLogger(ChangePasswordAction.class);
	private ChangePassword changePasswordmanager=Singleton.getChangePassword();
	private int user_id;
	private String newpassword;
	/**
	 * @return the newpassword
	 */
	public String getNewpassword() {
		return newpassword;
	}
	/**
	 * @param newpassword the newpassword to set
	 */
	public void setNewpassword(String newpassword) {
		this.newpassword = newpassword;
	}
	/**
	 * @param user_id the user_id to set
	 */
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	/**
	 * @return the user_id
	 */
	public int getUser_id() {
		return user_id;
	}
	
	
	/**
	 * Execute() method of ChangePasswordAction class. this method is used to initiate
	 * change pasword of user portfolio This method is calling changePassword
	 * method of ChangePassword manager class to update the user credentials.
	 * 
	 * @return SUCCESS if user is added
	 */
	public String execute()
	{ 	logger.info("Entering execute method of ChangePasswordAction");
		logger.info("new password-------------------------->>>>>>>>>>"+ newpassword);
		System.out.println("changepassword called");
		
		logger.info("userid----------------------->>>>>>>>>"+ user_id);
		changePasswordmanager.changePassword(user_id, newpassword);
		addActionError("Your password has been changed");
		logger.info("in change password action again");
		return MyConstant.SUCCESS;
	}
	
	
}
