package com.impetus.services;

import org.apache.log4j.Logger;
import org.hibernate.Session;

import com.impetus.POJO.HibernateUtil;
import com.impetus.POJO.XMLStockMaster;

;

/**
 * The Class StockSaxManager. Middle tier which lies between XmlStockMaster Pojo
 * Class and Xml_Stock_Master table.
 * <P>
 * Provides various attributes and behaviour required to perform transaction
 * with xml_Stock_Master table
 * 
 * @author Prachi.Singh
 * 
 */
public class StockSaxManager extends HibernateUtil {

	private static Logger logger = Logger.getLogger(StockSaxManager.class);

	/**
	 * Add method. Saves data into Xml_Stock_master table
	 * 
	 * @param stock
	 *            the stock is the object of xml stock master.it passes data
	 *            read from xml file
	 * @return the xML stock master object
	 */
	public synchronized XMLStockMaster add(XMLStockMaster stock) {
		logger.info("entering  add method of StockSaxManager");
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.save(stock);
		session.getTransaction().commit();
		return stock;
	}
}
