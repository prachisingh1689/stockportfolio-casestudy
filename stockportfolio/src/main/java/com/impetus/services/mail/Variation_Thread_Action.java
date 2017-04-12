package com.impetus.services.mail;

import java.util.List;

import org.apache.log4j.Logger;

import com.impetus.POJO.UserStockMaster;
import com.opensymphony.xwork2.ActionSupport;

/**
 * The Class variation_thread_Action. Is used to dispatch emails when variation
 * exceeds the change set by the user
 * 
 * @author prachi.singh
 */
public class Variation_Thread_Action extends ActionSupport implements Runnable {

	/** The logger. */
	private static Logger logger = Logger
			.getLogger(Variation_Thread_Action.class);

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The change manager. */
	private VariationThreadManager changeManager = new VariationThreadManager();

	/**
	 * Run method of thread that dispatches email if variation exceeds change
	 * set by the user. Calls checkchange method of variation_thread_manager
	 * class. dispatches mail by calling dispatchemail method of email alert
	 * class. calls delete method of variation_thread_manager to delete change
	 * set.
	 * 
	 * @see java.lang.Runnable#run()
	 */
	@SuppressWarnings({ "static-access", "deprecation" })
	public void run() {
		logger.info("entering run method in :variation thread action");
		while (true) {
			List<UserStockMaster> mailingList = changeManager.getMailingList();

			Float positiveVar = 0.0f;
			Float negativeVar = 0.0f;
			Float variation = 0.0f;
			String firstname = null;
			String lastname = null;
			String email = null;
			String stock = null;
			Float change = null;

			for (UserStockMaster u : mailingList) {
				firstname = u.getUser().getFirstname();
				lastname = u.getUser().getLastname();
				email = u.getUser().getEmail();
				stock = u.getStock().getName();

				variation = changeManager.checkChange(u.getStock()
						.getXmlstockList(), u.getPrice());
				logger.info("thread" + firstname + lastname + email + stock
						+ variation);

				change = u.getChange();

				if (variation > 0.0f) {
					logger.info("Positive variation");
					positiveVar = variation;
				} else {
					logger.info("Negative variation");
					negativeVar = Math.abs(variation.floatValue());
				}

				if (positiveVar >= change || negativeVar >= change) {
					logger.info("comparing change");
					String body = "Hello Mr/Mrs "
							+ firstname
							+ lastname
							+ "\n This mail is to notify you about the following details:\n"
							+ "Stock Name : "
							+ stock
							+ "\n"
							+ "Current Variation : "
							+ variation
							+ "\n"
							+ "Please take the necessary action.\n"
							+ "Thanks and Regards,\n Stockportfoliodb Admin\n This is the system generated mail.Please do not reply on this Email";
					String to = email;
					String sub = "Stock Variation Notification";
					EmailAlert.dispatchEmail(to, sub, body);
					changeManager.deleteAlert(u.getUserstockid());
					Thread.currentThread().stop();
				}
			}
			try {
				Thread.currentThread().sleep(60000 * 5);
			} catch (InterruptedException e) {
				logger.error(e.getMessage());

			}

		}

	}

	/**
	 * Variation thread. This method Initiates Variation thread
	 */
	public void VariationThread()

	{
		logger.info("entering main method of variation thread action");
		Variation_Thread_Action variationThread = new Variation_Thread_Action();
		Thread alertThread = new Thread(variationThread, "Alert Thread");
		alertThread.start();
	}
}
