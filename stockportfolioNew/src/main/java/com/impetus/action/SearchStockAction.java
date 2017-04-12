package com.impetus.action;

import java.util.List;

import org.apache.log4j.Logger;

import com.impetus.POJO.StockMaster;
import com.impetus.process.SearchStockManager;
import com.impetus.services.MyConstant;
import com.impetus.services.Singleton;
import com.opensymphony.xwork2.ActionSupport;

/**
 * The Class SearchStockAction. <code>SearchStockAction</code> is an Action
 * class that provides attributes and method to initiate search process. It
 * extends ActionSupport in order to provide Action support messages.
 * 
 * @author Prachi.Singh
 */

public class SearchStockAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** The link controller. */
	private SearchStockManager searchStockManager=Singleton.getSearchStockManager();

	/** The symbol. */
	private String symbol;

	/** The stock list. */
	private List<StockMaster> stockList;

	/** The logger. */
	private static Logger logger = Logger.getLogger(SearchStockAction.class);

	/**
	 * Gets the stock list.
	 * 
	 * @return the stock list
	 */
	public List<StockMaster> getStockList() {
		return stockList;
	}

	/**
	 * Sets the stock list.
	 * 
	 * @param stockList
	 *            the new stock list
	 */
	public void setStockList(List<StockMaster> stockList) {
		this.stockList = stockList;
	}

	/**
	 * Gets the symbol.
	 * 
	 * @return the symbol
	 */
	public String getSymbol() {
		return symbol;
	}

	/**
	 * Sets the symbol.
	 * 
	 * @param symbol
	 *            the new symbol
	 */
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	
	/**
	 * BrowseAllStock.. this method is used to initiate searching process of
	 * all stocks from stock master table. It retrieves a list of all stock
	 * details by calling all_stocks method of SearchStockManager class
	 * 
	 * @return SUCCESS
	 */

	public String browseAllStock() {
		this.stockList = searchStockManager.allStocks();
		return MyConstant.SUCCESS;
	}

	/**
	 * 
	 * 
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */
	/**
	 * Execute() method of SearchStockAction class. this method is used to
	 * initiate searching process of stocks from stock master table for a given
	 * string input. It retrieves a detail list of matching stock names by
	 * calling dosearch method of SearchStockManager class
	 * 
	 * @return SUCCESS
	 * 
	 */
	public String execute() {

		logger.info("entering execute of : Search Stock");
		this.stockList = searchStockManager.dosearch(getSymbol());

		return MyConstant.SUCCESS;
	}

}
