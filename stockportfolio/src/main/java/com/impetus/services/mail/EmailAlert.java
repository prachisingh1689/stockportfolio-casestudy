package com.impetus.services.mail;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.log4j.Logger;

/**
 * The Class EmailAlert. The <code>EmailAlert</code> is a class to send email to
 * a user.
 * 
 * @author Prachi.Singh
 */
public class EmailAlert {

	private static Logger logger = Logger.getLogger(EmailAlert.class);
	private static String adminEmail = "stockportfoliodb@gmail.com";
	private static String adminPassword = "prachisingh";

	/**
	 * dispatchEmail This method is used to send email alerts to users It
	 * retrieves details from Variation thread action class.
	 * 
	 */

	public static synchronized void dispatchEmail(String to, String sub,
			String body) {

		logger.info("entering dispatch emAIL method in :EMAIL Alert manager");
		logger.info(to + sub + body);
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

		Session esession = Session.getInstance(props, new Authenticator() {

			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(adminEmail, adminPassword);
			}
		});

		try {
			Message message = new MimeMessage(esession);
			message.setFrom(new InternetAddress("stockportfoliodb@gmail.com"));
			message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse(to));
			logger.info("Sending message");
			message.setSubject(sub);

			message.setText(body);
			Transport.send(message);
			logger.info("Email sent successfully ");
			logger.info("done");

		} catch (MessagingException e) {
			logger.warn("messaging exception inside :catch block:of email alert ");
			throw new RuntimeException(e);
		}
	}

}
