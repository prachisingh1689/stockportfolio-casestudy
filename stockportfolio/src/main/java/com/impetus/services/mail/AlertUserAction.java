package com.impetus.services.mail;

import org.apache.log4j.Logger;

import com.opensymphony.xwork2.ActionSupport;

/**
 * The Class AlertUserAction.The <code>AlertUserAction</code> is an Action class
 * that provides attributes and method to initiate alert(change) addition in
 * user portfolio. It extends ActionSupport in order to provide Action support
 * messages.
 * 
 * @author Prachi.Singh
 */
public class AlertUserAction extends ActionSupport {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The change. */
	private Float change;

	/** The userstockid. */
	private int userstockid;

	/** The alert manager. */
	private AlertManager alertManager = new AlertManager();

	/**
	 * The logger. Log4j Instance to maintain logs of activities
	 */
	private static Logger logger = Logger.getLogger(AlertUserAction.class);

	/**
	 * Instantiates a new alert user action. default constructor
	 * 
	 * @param userstockid
	 *            the userstockid
	 * @param change
	 *            the change
	 */
	public AlertUserAction(int userstockid, Float change) {
		this.userstockid = userstockid;
		this.change = change;
	}

	/**
	 * Instantiates a new alert user action.
	 */
	public AlertUserAction() {
		super();
	}

	/**
	 * Getter methods to obtain values of private data members of POJO Class.
	 * Setter methods to set private data member value of Model Object.
	 */
	/**
	 * Gets the userstockid.
	 * 
	 * @return the userstockid
	 */
	public synchronized int getUserstockid() {
		return userstockid;
	}

	/**
	 * Sets the userstockid.
	 * 
	 * @param userstockid
	 *            the new userstockid
	 */
	public synchronized void setUserstockid(int userstockid) {
		this.userstockid = userstockid;
	}

	/**
	 * Gets the change.
	 * 
	 * @return the change
	 */
	public Float getChange() {
		return change;
	}

	/**
	 * Sets the change.
	 * 
	 * @param change
	 *            the new change
	 */
	public void setChange(Float change) {
		this.change = change;
	}

	/**
	 * Alert. This method calls add method of alertManager and sets the change
	 * value to the respective user stock id.
	 * 
	 * @return the success
	 */
	public String alert() {
		logger.info("entering compare method in :alert method of alert user action");
		logger.info(getUserstockid());
		String result = null;
		result = alertManager.add(change, userstockid);
		logger.info("ch----" + change);
		addActionMessage("EMAIL WILL BE SENT ON SET DEFLECTION");

		if (result == "success") {
			return SUCCESS;
		}
		return SUCCESS;
	}
}
