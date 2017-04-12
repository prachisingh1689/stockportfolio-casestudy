package com.impetus.action;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import com.impetus.POJO.StockMaster;
import com.impetus.POJO.UserMaster;
import com.impetus.POJO.UserStockMaster;
import com.impetus.process.AddStockManager;
import com.impetus.process.SearchStockManager;
import com.impetus.services.MyConstant;
import com.impetus.services.Singleton;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * The Class AddStockAction.The <code>AddStockAction</code> is an Action class
 * that provides attributes and method to initiate stock addition in user
 * portfolio. It extends ActionSupport in order to provide Action support
 * messages
 * 
 * @author Prachi.Singh
 */
public class AddStockAction extends ActionSupport {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	private List<StockMaster> stockList;

	/** The stockId. */
	private int stockId;

	/** The addstock manager. */
	private AddStockManager addstockManager = Singleton.getAddStockManager();

	/** The portfolio list. */
	private List<UserStockMaster> portfolioList;

	/** The userstockid. */
	private int userstockid;

	/** The price. */
	private Float price;

	/** The logger. */
	private static Logger logger = Logger.getLogger(AddStockAction.class);

	/**
	 * @param stockList
	 *            the stockList to set
	 */
	public void setStockList(List<StockMaster> stockList) {
		this.stockList = stockList;
	}

	/**
	 * @return the stockList
	 */
	public List<StockMaster> getStockList() {
		return stockList;
	}

	/**
	 * Getter methods to obtain values of private data members of POJO Class.
	 * Setter methods to set private data member value of Model Object.
	 */
	/**
	 * Gets the price.
	 * 
	 * @return the price
	 */
	public Float getPrice() {
		return price;
	}

	/**
	 * Sets the price.
	 * 
	 * @param price
	 *            the new price
	 */
	public void setPrice(Float price) {
		this.price = price;
	}

	/**
	 * Gets the userstockid.
	 * 
	 * @return the userstockid
	 */
	public int getUserstockid() {
		return userstockid;
	}

	/**
	 * Sets the userstockid.
	 * 
	 * @param userstockid
	 *            the new userstockid
	 */
	public void setUserstockid(int userstockid) {
		this.userstockid = userstockid;
	}

	/**
	 * Gets the portfolio list.
	 * 
	 * @return the portfolio list
	 */
	public List<UserStockMaster> getPortfolioList() {
		return portfolioList;
	}

	/**
	 * Sets the portfolio list.
	 * 
	 * @param portfolioList
	 *            the new portfolio list
	 */
	public void setPortfolioList(List<UserStockMaster> portfolioList) {
		this.portfolioList = portfolioList;
	}

	/**
	 * Instantiates a new adds the stock action.
	 */
	/*public AddStockAction() {
		addstockManager = Singleton.getAddStockManager();
	}*/

	/**
	 * Gets the stockId.
	 * 
	 * @return the stockId
	 */
	public int getStockId() {
		return stockId;
	}

	/**
	 * Sets the stockId.
	 * 
	 * @param stockId
	 *            the new stockId
	 */
	public void setStockId(int stockId) {
		this.stockId = stockId;
	}

	/**
	 * Show. this method is used to initiate searching process of all stocks for
	 * a given user id. It retrieves a list of all stock details from
	 * AddStockManager class class to retrieve the user credentials for updation
	 * 
	 * @return the success
	 */
	public String show() {
		this.portfolioList = addstockManager.list();
		logger.info(portfolioList);
		return MyConstant.SUCCESS;
	}

	/**
	 * Execute() method of AddStockAction class. this method is used to initiate
	 * stock addition into user portfolio This method is calling addtoportfolio
	 * method of AddStockManager class to retrieve the user credentials for
	 * updation
	 * 
	 * @return SUCCESS if user is added
	 */
	public String execute() {

		logger.info("entering execute of :");
		UserStockMaster userstock = new UserStockMaster();
		StockMaster stock = new StockMaster();
		userstock.setUser(new UserMaster());
		userstock.getUser().setId(
				(Integer) ActionContext.getContext().getSession()
						.get("user_id"));
		userstock.setStock(stock);
		userstock.getStock().setStockId(getStockId());
		userstock.setPrice(userstock.getStock().getPrice());

		userstock.setPrice(getPrice());
		userstock.setPurchase(new Timestamp(new Date().getTime()));
		
		
		addstockManager.addtoportfolio(userstock);
		stockList = (Singleton.getSearchStockManager()).allStocks();
		
		
		addActionError(" Stock has been added..To View the added stocks go to your Portfolio");
		return MyConstant.SUCCESS;
	}

	/**
	 * Delete.this method is used to initiate stock deletion from user portfolio
	 * This method is calling delete method of AddStockManager class to retrieve
	 * the user credentials for updation
	 * @return the success on deletion of stock
	 */
	public String delete() {
		logger.info("entering execute of :delete method in : add stock action");
		addstockManager.delete(getUserstockid());
		this.portfolioList = addstockManager.list();
		addActionError("Stock has been deleted successfully");
		return MyConstant.SUCCESS;
	}

}
