package com.impetus.process;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import com.impetus.POJO.HibernateUtil;
import com.impetus.POJO.StockMaster;
import com.impetus.action.AddStockAction;
import com.impetus.services.MyException;

/**
 * The Class SearchStockManager. Middle tier which lies between StockMaster Pojo
 * Class and Stock_Master table.
 * <P>
 * Provides various attributes and behaviour required to perform transaction
 * with Stock_Master table such as retrieval of stock details required
 * 
 * @author Prachi.Singh
 * 
 */
public class SearchStockManager{

	/** The logger. */
	private static Logger logger = Logger.getLogger(AddStockAction.class);
	private static SearchStockManager searchStockManager=null;
	private SearchStockManager()
	{
		
	}
	public static SearchStockManager getSearchStockManagerInstance()
	{
		if(searchStockManager==null)
		{
			searchStockManager=new SearchStockManager();
			return searchStockManager;
		}
		else
		{
			return searchStockManager;
		}
	}
	/**
	 * Dosearch. Retrieve stocks. This Method is used to retrieves stocks
	 * corresponding to the ticker symbol.
	 * 
	 * 
	 * @return stockList - list containing rows correspond to the symbol.
	 */
	public List<StockMaster> dosearch(String inputText) {
		logger.info("entering doSearch method in :Search stock manager");
		List<StockMaster> stocklist = null;
		Session session = null;
		String inputText1 = "%" + inputText.trim() + "%";
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.getTransaction().begin();
			logger.info("dosearch called");
			Query query = session
					.createQuery("from StockMaster where symbol like ? or name like ?");
			query.setString(0, inputText1);
			query.setString(1, inputText1);
			stocklist = query.list();
			session.getTransaction().commit();
			

		} catch (HibernateException e) {
			logger.warn("hibernate exception inside :catch block of search stock manager ");
			logger.error(e.getMessage());
			session.getTransaction().rollback();
			throw new MyException("Hibernate exception",e);

		}

		/*session.getTransaction().commit();
		logger.info("transaction successfully committed");*/
		finally
		{
			session.close();
			
		}
		logger.info("transaction successfully committed");
		return stocklist;
	}

	/**
	 * All_stocks. This method is used to retrieve all the stock data present in
	 * StockMaster table.
	 * 
	 * @return stockList- list of StockMaster Object
	 */
	public List<StockMaster> allStocks() {
		logger.info("entering all_stocks method in :Search stock manager");
		List<StockMaster> stocklist = null;
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.getTransaction().begin();
			logger.info("browse all called");
			Query query = session.createQuery("from StockMaster");
			stocklist = query.list();
			session.getTransaction().commit();
		} catch (HibernateException e) {
			logger.warn("hibernate exception inside : catch block of search stock manager ");
			logger.error(e.getMessage());

			session.getTransaction().rollback();
		}finally {
			session.close();
		}

		
		logger.info("transaction successfully committed");
		return stocklist;

	}

}
