/**
 * 
 */
package com.impetus.action;

import org.apache.log4j.Logger;

import com.impetus.services.MyConstant;
import com.impetus.services.mail.EmailAlert;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author prachi.singh
 * 
 */
public class FeedbackAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private String email;
	private String mobile;
	private String text;
	private int type;
	private static Logger logger = Logger.getLogger(LoginAction.class);

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param mobile
	 *            the mobile to set
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	/**
	 * @return the mobile
	 */
	public String getMobile() {
		return mobile;
	}

	/**
	 * @param type
	 *            the type to set
	 */
	public void setType(int type) {
		this.type = type;
	}

	/**
	 * @return the type
	 */
	public int getType() {
		return type;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getText() {
		return text;
	}

	public String execute()
	{

		logger.info("entering execute of :Feedback action");
		String sub = null;
		if (type == 0) {
			sub = "General Feedback";
		} else if (type == 1) {
			sub = "Technical Issue";
		} else if (type == 2) {
			sub = "Product Suggestion";
		}

		String body = ("Feedback from  " + name + "\n" + email + "\n" + mobile
				+ "\n" + "is as follows " + "--------->>" + "\n" + text);

		String to = "prachi.singh1689@gmail.com";

		EmailAlert.dispatchEmail(to, sub, body);

		addActionMessage(" Thanks for your FeedBack ");
		return MyConstant.SUCCESS;
	}

}
