package com.impetus.POJO;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * The Class XMLStockMaster.It has Various attributes of XmlStockMaster, and related
 * behaviour. The<code>XmlStockMaster</code> is a POJO Class that is mapped with
 * Table : xml_stock_master in database.
 * 
 * @author Prachi.Singh
 */
@Entity
@Table(name = "xml_stock_master")
public class XMLStockMaster {

	/** The xml_id. */
	private Integer xml_id;

	/** The name. */
	private String name;

	/** The price. */
	private Float price;

	/** The time. */
	private Timestamp time;

	/** The stock. */
	private StockMaster stock;

	/**
	 * Getter methods to obtain values of private data members of POJO Class.
	 * Setter methods to set private data member value of Model Object.
	 */

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
	 * Gets the xml_id.
	 * 
	 * @return the xml_id
	 */
	@Id
	@GeneratedValue
	@Column(name = "xml_stock_id")
	public Integer getXml_id() {
		return xml_id;
	}

	/**
	 * Sets the xml_id.
	 * 
	 * @param xml_id
	 *            the new xml_id
	 */
	public void setXml_id(Integer xml_id) {
		this.xml_id = xml_id;
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
	 * Gets the time.
	 * 
	 * @return the time
	 */
	@Column(name = "time")
	public Timestamp getTime() {
		return time;
	}

	/**
	 * Sets the time.
	 * 
	 * @param time
	 *            the new time
	 */
	public void setTime(Timestamp time) {
		this.time = time;
	}

}
