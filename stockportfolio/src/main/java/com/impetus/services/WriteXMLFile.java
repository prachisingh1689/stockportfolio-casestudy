package com.impetus.services;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Random;

import org.apache.log4j.Logger;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

/**
 * The Class WriteXMLFile. It is used for updation of stock prices
 * 
 * @author Prachi.Singh
 */
public class WriteXMLFile {

	/**
	 * The logger. Log4j Instance to maintain logs of activities happens through
	 * WriteXMLFile class.
	 */
	private static Logger logger = Logger.getLogger(WriteXMLFile.class);

	/**
	 * Update. This method updates the stock price each time it is read from the
	 * xml file using random function.
	 */
	@SuppressWarnings("rawtypes")
	public void update() {
		logger.info("entering update method of WriteXMLFile");

		try {

			SAXBuilder builder = new SAXBuilder();
			File xmlFile = new File("d:\\StockDetail.xml");

			Document doc = (Document) builder.build(xmlFile);
			Element rootNode = doc.getRootElement();
			List list = rootNode.getChildren("stock");

			for (int i = 0; i < list.size(); i++) {

				Random random = new Random();
				int randomInt = random.nextInt(100) + 1200;

				Element node = (Element) list.get(i);
				node.getChild("price").setText(String.valueOf(randomInt));
				;

			}

			XMLOutputter xmlOutput = new XMLOutputter();

			xmlOutput.setFormat(Format.getPrettyFormat());
			xmlOutput.output(doc, new FileWriter("d:\\StockDetail.xml"));

			logger.info("File updated!");

		} catch (IOException io) {
			logger.error(io.getMessage());
			throw new MyException("Hibernate exception",io);
		} catch (JDOMException e) {
			logger.error(e.getMessage());
			throw new MyException("Hibernate exception",e);
		}

	}

}
