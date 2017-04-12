package com.impetus.POJO;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

/**
 * The Class HibernateUtil.
 */
@SuppressWarnings("deprecation")
public class HibernateUtil {

	/** The Constant sessionFactory. */
	private static final SessionFactory sessionFactory = buildSessionFactory();
	/** The logger. */
	private static Logger logger = Logger.getLogger(HibernateUtil.class);

	/**
	 * Builds the session factory.
	 * 
	 * @return the session factory
	 */
	private static SessionFactory buildSessionFactory() {
		try {
			// Create the SessionFactory from hibernate.cfg.xml
			return new AnnotationConfiguration().configure()
					.buildSessionFactory();
		} catch (Exception ex) {
			logger.warn("Initial SessionFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	/**
	 * Gets the session factory.
	 * 
	 * @return the session factory
	 */
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}
