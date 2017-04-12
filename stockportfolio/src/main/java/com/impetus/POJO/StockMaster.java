package com.impetus.POJO;

import java.io.Serializable;
import java.util.ArrayList;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * The Class StockMaster.It has Various attributes of StockMaster, and related
 * behaviour. The<code>StockMaster</code> is a POJO Class that is mapped with
 * Table : Stock_Master in database.
 * 
 * @author Prachi.Singh
 */
@Entity
@Table(name = "stock_master")
public class StockMaster implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The stock_id. */
	private int stock_id;

	/** The name. */
	private String name;

	/** The symbol. */
	private String symbol;

	/** The price. */
	private Float price;

	/** The user list. */
	private List<UserMaster> userList = new ArrayList<UserMaster>();

	/** The xmlstock list. */
	private List<XMLStockMaster> xmlstockList = new ArrayList<XMLStockMaster>();

	/**
	 * Getter methods to obtain values of private data members of POJO Class.
	 * Setter methods to set private data member value of Model Object.
	 */

	/**
	 * Gets the xmlstock list.
	 * 
	 * @return the xmlstock list
	 */
	@OneToMany(targetEntity = XMLStockMaster.class, mappedBy = "stock", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	public List<XMLStockMaster> getXmlstockList() {
		return xmlstockList;
	}

	/**
	 * Sets the xmlstock list.
	 * 
	 * @param xmlstockList
	 *            the new xmlstock list
	 */
	public void setXmlstockList(List<XMLStockMaster> xmlstockList) {
		this.xmlstockList = xmlstockList;
	}

	/**
	 * Gets the user list.
	 * 
	 * @return the user list
	 */
	@ManyToMany
	@JoinTable(name = "user_stock_join", joinColumns = { @JoinColumn(name = "stockList") }, inverseJoinColumns = { @JoinColumn(name = "userList") })
	public List<UserMaster> getUserList() {
		return userList;
	}

	/**
	 * Sets the user list.
	 * 
	 * @param userList
	 *            the new user list
	 */
	public void setUserList(List<UserMaster> userList) {
		this.userList = userList;
	}

	/**
	 * Gets the stock_id.
	 * 
	 * @return the stock_id
	 */
	@Id
	@GeneratedValue
	@Column(name = "stock_id")
	public int getStock_id() {
		return stock_id;
	}

	/**
	 * Sets the stock_id.
	 * 
	 * @param stock_id
	 *            the new stock_id
	 */
	public void setStock_id(int stock_id) {
		this.stock_id = stock_id;
	}

	/**
	 * Gets the name.
	 * 
	 * @return the name
	 */
	@Column(name = "name")
	public String getName() {
		return name;
	}

	/**
	 * Sets the name.
	 * 
	 * @param name
	 *            the new name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the symbol.
	 * 
	 * @return the symbol
	 */
	@Column(name = "symbol")
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

}
