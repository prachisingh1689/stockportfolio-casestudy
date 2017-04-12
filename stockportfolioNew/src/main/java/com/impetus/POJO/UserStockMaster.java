package com.impetus.POJO;

import java.io.Serializable;
import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * The Class UserStockMaster.It has Various attributes of UserStockMaster, and related
 * behaviour. The<code>UserStockMaster</code> is a POJO Class that is mapped
 * with Table : user_stock_master in database.
 * 
 * @author Prachi.Singh
 */
@Entity
@Table(name = "user_stock_master")
public class UserStockMaster implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The userstockid. */
	private int userstockid;

	/** The purchase. */
	private Timestamp purchase;

	/** The price. */
	private Float price;

	/** The user. */
	private UserMaster user;

	/** The stock. */
	private StockMaster stock;

	/** The change. */
	private Float change;

	/**
	 * Getter methods to obtain values of private data members of POJO Class.
	 * Setter methods to set private data member value of Model Object.
	 */

	/**
	 * Gets the user.
	 * 
	 * @return the user
	 */
	@ManyToOne
	@JoinColumn(name = "user_id")
	public UserMaster getUser() {
		return user;
	}

	/**
	 * Sets the user.
	 * 
	 * @param user
	 *            the new user
	 */
	public void setUser(UserMaster user) {
		this.user = user;
	}

	/**
	 * Gets the stock.
	 * 
	 * @return the stock
	 */
	@ManyToOne
	@JoinColumn(name = "stock_id")
	public StockMaster getStock() {
		return stock;
	}

	/**
	 * Sets the stock.
	 * 
	 * @param stock
	 *            the new stock
	 */
	public void setStock(StockMaster stock) {
		this.stock = stock;
	}

	/**
	 * Gets the userstockid.
	 * 
	 * @return the userstockid
	 */
	@Id
	@GeneratedValue
	@Column(name = "user_stock_id")
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
	 * Instantiates a new user stock master.
	 */
	public UserStockMaster() {

	}

	/**
	 * Instantiates a new user stock master.
	 * 
	 * @param purchase
	 *            the purchase
	 */
	public UserStockMaster(Timestamp purchase) {
		this.purchase = purchase;
	}

	/**
	 * Instantiates a new user stock master.
	 * 
	 * @param stock
	 *            the stock
	 * @param user
	 *            the user
	 * @param price
	 *            the price
	 * @param purchase
	 *            the purchase
	 */
	public UserStockMaster(StockMaster stock, UserMaster user, Float price,
			Timestamp purchase) {
		this.stock = stock;
		this.user = user;
		this.price = price;
		this.purchase = purchase;
	}

	/**
	 * Gets the purchase.
	 * 
	 * @return the purchase
	 */
	@Column(name = "purchase")
	public Timestamp getPurchase() {
		return purchase;
	}

	/**
	 * Sets the purchase.
	 * 
	 * @param purchase
	 *            the new purchase
	 */
	public void setPurchase(Timestamp purchase) {
		this.purchase = purchase;
	}

	/**
	 * Gets the price.
	 * 
	 * @return the price
	 */
	@Column(name = "price")
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
	 * Gets the change.
	 * 
	 * @return the change
	 */
	@Column(name = "deflection")
	public Float getChange() {
		return change;
	}

	/**
	 * Sets the change.
	 * 
	 * @param change
	 *            the new change
	 */
	public void setChange(Float change) {
		this.change = change;
	}

}
