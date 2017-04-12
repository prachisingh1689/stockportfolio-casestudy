package com.impetus.services.charts;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import com.impetus.POJO.HibernateUtil;
import com.impetus.POJO.StockMaster;
import com.impetus.POJO.XMLStockMaster;
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

	/** The stockId. */
	private int stockId;
	
	private String symbol;
	
	private String name;

	/** The start date. */
	private String startDate;

	/** The end date. */
	private String endDate;

	/** The stockpricelist. */
	private List<XMLStockMaster> stockpricelist = null;
	private List<StockMaster> namelist= null;
	/**
	 * Sets the stockId.
	 * 
	 * @param stockId
	 *            the stockId to set
	 */
	public void setStockId(int stockId) {
		this.stockId = stockId;
	}

	/**
	 * Gets the stockId.
	 * 
	 * @return the stockId
	 */
	public int getStockId() {
		return stockId;
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
	@SuppressWarnings("unchecked")
	@Override
	public String execute() {
		logger.info("entering  execute method of show chart action");
		
		if (startDate == null) {
			stockpricelist = makechart(getStockId());

		} 
		else {
			
			stockpricelist = makechart(  getStartDate(),getEndDate(),getStockId());
		}
		int stockId=getStockId();
		Session session = null;
		logger.info("---->"+ stockId);
		try
		{
			session = HibernateUtil.getSessionFactory().openSession();
			session.getTransaction().begin();
			Query query = session.createQuery("from StockMaster where stock_id=?");	
			query.setParameter(0, stockId);
			namelist= (List<StockMaster>)(query.list());
			for (StockMaster s : namelist) 
			{
				symbol=s.getSymbol();
				name = s.getName();
			}
			
			session.getTransaction().commit();	
		}
		catch (HibernateException e)
		{
			logger.error(e.getMessage());
			session.getTransaction().rollback();
		}
		
		
		
		MakeGraphSession makechart = new MakeGraphSession();
		makechart.todayChart(stockpricelist,startDate,endDate,symbol,name);
		return SUCCESS;
	}

	/**
	 * Makechart. This method retrieves whole data from the xml stock master
	 * table for the specified stock id
	 * 
	 * @param stockId
	 *            the stockId for which graph is required
	 * @return the stockpricelist
	 */
	@SuppressWarnings("unchecked")
	private List<XMLStockMaster> makechart(int stockId) {
		Session session = null;
		try {
			logger.info("entering  make chart method of show chart action class with only stock id:"+stockId);

			session = HibernateUtil.getSessionFactory().openSession();
			session.getTransaction().begin();
			Query query = session
					.createQuery("from XMLStockMaster where stock_id=?");
			query.setParameter(0, stockId);
			stockpricelist = (List<XMLStockMaster>) (query.list());
			logger.info("============================>"+stockpricelist.size());
			if (stockpricelist.isEmpty() == false) {
				logger.info("list is not empty");
			}
			
			session.getTransaction().commit();
		} 
		catch (HibernateException e) {
			logger.error("exception while executing makechart");
			logger.error(e.getMessage());
			logger.error(e.getLocalizedMessage());
			session.getTransaction().rollback();
			
		}finally {
			session.close();
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
			int stockid) {
		logger.info("entering  make chart method(3 parameters) of show chart action class");
		logger.info("show stock id:"+stockid);
		logger.info("start date :"+starttime);
		logger.info("end date :"+endtime);
		
		Session session = null;
		

		try {
			logger.info("everything");
			session = HibernateUtil.getSessionFactory().openSession();
			session.getTransaction().begin();
			
			Query query = session
					.createQuery("from XMLStockMaster where stock_id=? and time>? and time<?");
			query.setInteger(0, stockid);
			query.setString(1, starttime);
			query.setString(2, endtime);

			stockpricelist = query.list();
			logger.info("======================================>"+stockpricelist.size());
		
			if (stockpricelist.isEmpty() == false) {
				logger.info("in dao list is not empty");
			}
			session.getTransaction().commit();
		
		} 
		catch (HibernateException e) 
		{
			logger.error(e.getMessage());
			session.getTransaction().rollback();
		}finally{
			session.close();
		}

		return stockpricelist;

	}

}
