package com.impetus.services.charts;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import com.impetus.POJO.HibernateUtil;
import com.impetus.POJO.XMLStockMaster;
import com.impetus.services.MyException;
import com.opensymphony.xwork2.ActionSupport;

/**
 * The Class ShowChartAction. this class is used to retrieve data for select
 * duration from the Xml xtock master table . It extends ActionSupport in order
 * to provide Action support messages.
 * 
 * @author Prachi.Singh
 * 
 */
public class ShowChartAction extends ActionSupport {
	private static Logger logger = Logger.getLogger(ShowChartAction.class);

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The stock_id. */
	private int stock_id;

	/** The start date. */
	private String startDate;

	/** The end date. */
	private String endDate;

	/** The stockpricelist. */
	public List<XMLStockMaster> stockpricelist = null;

	/**
	 * Sets the stock_id.
	 * 
	 * @param stock_id
	 *            the stock_id to set
	 */
	public void setStock_id(int stock_id) {
		this.stock_id = stock_id;
	}

	/**
	 * Gets the stock_id.
	 * 
	 * @return the stock_id
	 */
	public int getStock_id() {
		return stock_id;
	}

	/**
	 * Sets the start date.
	 * 
	 * @param startDate
	 *            the startDate to set
	 */
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	/**
	 * Gets the start date.
	 * 
	 * @return the startDate
	 */
	public String getStartDate() {
		return startDate;
	}

	/**
	 * Sets the end date.
	 * 
	 * @param endDate
	 *            the endDate to set
	 */
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	/**
	 * Gets the end date.
	 * 
	 * @return the endDate
	 */
	public String getEndDate() {
		return endDate;
	}

	/**
	 * Sets the session.
	 * 
	 * @param map
	 *            the new session
	 */
	public void setSession(@SuppressWarnings("rawtypes") Map map) {
	}

	/**
	 * Sets the servlet request.
	 * 
	 * @param arg0
	 *            the new servlet request
	 */
	public void setServletRequest(HttpServletRequest arg0) {

	}

	/**
	 * Execute method ShowChartAction class. Checks start date and end date for
	 * chart duration If start date is null then makechart(stockid) is called If
	 * startdate and end date are not null then makechart with these two
	 * attributes is called
	 * 
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 * @return success
	 */
	@Override
	public String execute() {
		logger.info("entering  execute method of show chart action");
		if (startDate == null) {
			stockpricelist = makechart(stock_id);

		} else {
			stockpricelist = makechart(startDate, endDate, stock_id);
		}

		MakeGraphSession makechart = new MakeGraphSession();
		makechart.todayChart(stockpricelist,startDate,endDate);
		return SUCCESS;
	}

	/**
	 * Makechart. This method retrieves whole data from the xml stock master
	 * table for the specified stock id
	 * 
	 * @param stock_id
	 *            the stock_id for which graph is required
	 * @return the stockpricelist
	 */
	@SuppressWarnings("unchecked")
	private List<XMLStockMaster> makechart(int stock_id) {

		try {
			logger.info("entering  make chart method of show chart action class with only stock id");

			Session session = HibernateUtil.getSessionFactory().openSession();

			Query query = session
					.createQuery("from XMLStockMaster where stock.stock_id =:stId ");
			query.setParameter("stId", stock_id);
			stockpricelist = (List<XMLStockMaster>) (query.list());

			if (stockpricelist.isEmpty() == false) {
				logger.info("list is not empty");
			}
			
			session.getTransaction().commit();
			return stockpricelist;
		} 
		catch (HibernateException e) {
			logger.error(e.getMessage());
			
		}
	return stockpricelist;

	}

	/**
	 * Makechart. This method retrieves whole data between the specified start
	 * date and end date from the xml stock master table for the specified stock
	 * id
	 * @param starttime
	 *            is the startdate
	 * @param endtime
	 *            is the enddate
	 * @param stockid1
	 *            is the id for which graph is to be shown
	 * @return the stockpricelist
	 */
	@SuppressWarnings("unchecked")
	private List<XMLStockMaster> makechart(String starttime, String endtime,
			int stockid1) {
		logger.info("entering  make chart method(3 parameters) of show chart action class");

		try {
			logger.info("evrythng");
			Session session = HibernateUtil.getSessionFactory().openSession();

			Query query = session
					.createQuery("from XMLStockMaster where stock_id=? and time > ? and time < ?");
			query.setInteger(0, stockid1);
			query.setString(1, starttime);
			query.setString(2, endtime);

			stockpricelist = query.list();

			Iterator<XMLStockMaster> i = stockpricelist.listIterator();

			while (i.hasNext()) {
				XMLStockMaster s = (XMLStockMaster) i.next();
				logger.info("Price " + s.getPrice());
				logger.info("time" + s.getTime());
			}

			if (stockpricelist.isEmpty() == false) {
				logger.info("in dao list is not empty");
			}
			session.getTransaction().commit();
			

			return stockpricelist;
		} 
		catch (HibernateException e) 
		{
			logger.error(e.getMessage());
			
			
		}

		return stockpricelist;

	}

}
