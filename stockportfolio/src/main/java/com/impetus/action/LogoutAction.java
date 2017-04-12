package com.impetus.action;

import java.util.Map;

import org.apache.log4j.Logger;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * The Class LogoutAction. <code>LogoutAction</code> is an Action class that
 * provides attributes and method to initiate logout process. It extends
 * ActionSupport in order to provide Action support messages.
 * 
 * @author Prachi.Singh
 */

public class LogoutAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/** The logger. */
	private static Logger logger = Logger.getLogger(LogoutAction.class);

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */

	/**
	 * Execute() method of LogoutAction class. this method is used to initiate
	 * logout process of user. It simply clears the current user session.
	 * 
	 * @return SUCCESS if user is logged out successfully
	 */
	public String execute() {
		logger.info("entering execute of :logout action");
		Map<String, Object> session = ActionContext.getContext().getSession();

		session.clear();

		return SUCCESS;
	}
}
