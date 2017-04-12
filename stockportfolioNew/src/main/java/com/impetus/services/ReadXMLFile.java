package com.impetus.services;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.log4j.Logger;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

import com.impetus.POJO.StockMaster;
import com.impetus.POJO.XMLStockMaster;

/**
 * The Class ReadXMLFile. This class reads an xml file and updates it every 5
 * mins.
 * 
 * @author Prachi.Singh
 */
public class ReadXMLFile implements Runnable {

	/**
	 * The logger. Log4j Instance to maintain logs of activities happens through
	 * ReadXMLFile class.
	 */
	private static Logger logger = Logger.getLogger(ReadXMLFile.class);

	/**
	 * Instantiates a new read xml file.
	 */
	public ReadXMLFile() {
		super();
	}

	/**
	 * Run method . It reads and updates from Xml file. Uses Sax Parser for Xml
	 * parsing
	 * 
	 * @see java.lang.Runnable#run()
	 **/
	public void run() {
		logger.info("entering  run method of xml read file");
		while (true) {
			SAXBuilder builder = new SAXBuilder();

			File xmlFile = new File("d:\\StockDetail.xml");
			StockSaxManager stockSaxManager = Singleton.getStockSaxManager();
			try {

				Document document = (Document) builder.build(xmlFile);
				Element rootNode = document.getRootElement();
				@SuppressWarnings("rawtypes")
				List list = rootNode.getChildren("stock");
				XMLStockMaster lateststock = new XMLStockMaster();
				StockMaster stock = new StockMaster();
				for (int i = 0; i < list.size(); i++) {

					Element node = (Element) list.get(i);
					stock.setStockId(Integer.parseInt(node
							.getChildText("stockid")));
					lateststock.setStock(stock);
					lateststock.setName(node.getChildText("name"));
					lateststock.setPrice(Float.parseFloat(node.getChildText("price")));
					stockSaxManager.add(lateststock);
					stock = new StockMaster();
					lateststock = new XMLStockMaster();

				}

			} catch (IOException io) {
				logger.info(io.getMessage());
				throw new MyException("Hibernate exception",io);
				
			} catch (JDOMException jdomex) {
				logger.info(jdomex.getMessage());
				throw new MyException("Hibernate exception",jdomex);
			}

			try {
				WriteXMLFile update = new WriteXMLFile();
				update.update();

				Thread.sleep(MyConstant.THREELAKH);
			} catch (InterruptedException e) {
				
				logger.error(e.getMessage());
				throw new MyException("Hibernate exception",e);
			}

		}

	}

	/**
	 * Xmlread thread. this method starts a thread named "read"
	 */
	public void xmlreadThread()
	{
		logger.info("entering  xmlreadThread method action");
		ReadXMLFile read = new ReadXMLFile();
		Thread readxml = new Thread(read, "Parsing");
		readxml.start();

	}
}