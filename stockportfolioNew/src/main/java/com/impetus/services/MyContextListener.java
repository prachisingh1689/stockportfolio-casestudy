package com.impetus.services;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.log4j.Logger;

import com.impetus.services.mail.VariationThreadAction;

/**
 * this class extends ServletContextListener therefore, its instance will be
 * created as soon as context get loaded in memory. It is used to run those jobs
 * which are required to run with context.
 * 
 * @author prachi.singh
 * 
 */
public class MyContextListener implements ServletContextListener {
	/**
	 * Log4j Instance to maintain logs of activities happens through
	 * MyContextListener class.
	 */
	private static Logger logger = Logger.getLogger(MyContextListener.class);

	/**
	 * @see javax.servlet.ServletContextListener#contextDestroyed(javax.servlet.ServletContextEvent)
	 *      this method has been override to get initial log and initial job.
	 **/
	public void contextInitialized(ServletContextEvent arg0) 
	{
		logger.info("MyContextListener Initialized");
		VariationThreadAction vta = new VariationThreadAction();
		vta.variationThread();
		ReadXMLFile xmlfile = new ReadXMLFile();
		xmlfile.xmlreadThread();

	}

	/**
	 * @see javax.servlet.ServletContextListener#contextDestroyed(javax.servlet.ServletContextEvent)
	 *      this method has been override to get final log.
	 **/
	public void contextDestroyed(ServletContextEvent arg0) {
		logger.info("MyContextListener destroyed");

	}

}
