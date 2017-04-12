package com.impetus.POJO;

import java.io.Serializable;
import java.util.ArrayList;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * The Class UserMaster.It has Various attributes of UserMaster, and related behaviour.
 * The<code>UserMaster</code> is a POJO Class that is mapped with Table :
 * User_Master in database.
 * 
 * @author Prachi.Singh
 */
@Entity
@Table(name = "user_master")
public class UserMaster implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** The id. */
	private int id;

	/** The firstname. */
	private String firstname;

	/** The lastname. */
	private String lastname;

	/** The dob. */
	private String dob;

	/** The username. */
	private String username;

	/** The password. */
	private String password;

	/** The email. */
	private String email;

	/** The mobile. */
	private Long mobile;

	/** The stock list. */
	private List<StockMaster> stockList = new ArrayList<StockMaster>();

	/** The user list. */
	private List<UserStockMaster> userList = new ArrayList<UserStockMaster>();

	/**
	 * Getter methods to obtain values of private data members of POJO Class.
	 * Setter methods to set private data member value of Model Object.
	 */

	/**
	 * Gets the stock list.
	 * 
	 * @return the stock list
	 */
	@ManyToMany
	@JoinTable(name = "user_stock_join", joinColumns = { @JoinColumn(name = "userList") }, inverseJoinColumns = { @JoinColumn(name = "stockList") })
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
	 * Gets the user list.
	 * 
	 * @return the user list
	 */
	@OneToMany(targetEntity = UserStockMaster.class, mappedBy = "user", cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
	public List<UserStockMaster> getUserList() {
		return userList;
	}

	/**
	 * Sets the user list.
	 * 
	 * @param userList
	 *            the new user list
	 */
	public void setUserList(List<UserStockMaster> userList) {
		this.userList = userList;
	}

	/**
	 * Gets the id.
	 * 
	 * @return the id
	 */
	@Id
	@GeneratedValue
	@Column(name = "user_id")
	public int getId() {
		return id;
	}

	/**
	 * Sets the id.
	 * 
	 * @param id
	 *            the new id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Gets the firstname.
	 * 
	 * @return the firstname
	 */
	@Column(name = "first_name")
	public String getFirstname() {
		return firstname;
	}

	/**
	 * Sets the firstname.
	 * 
	 * @param firstname
	 *            the new firstname
	 */
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	/**
	 * Gets the lastname.
	 * 
	 * @return the lastname
	 */
	@Column(name = "last_name")
	public String getLastname() {
		return lastname;
	}

	/**
	 * Sets the lastname.
	 * 
	 * @param lastname
	 *            the new lastname
	 */
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	/**
	 * Gets the dob.
	 * 
	 * @return the dob
	 */
	@Column(name = "dob")
	public String getDob() {
		return dob;
	}

	/**
	 * Sets the dob.
	 * 
	 * @param dob
	 *            the new dob
	 */
	public void setDob(String dob) {
		this.dob = dob;
	}

	/**
	 * Gets the username.
	 * 
	 * @return the username
	 */
	@Column(name = "username")
	public String getUsername() {
		return username;
	}

	/**
	 * Sets the username.
	 * 
	 * @param username
	 *            the new username
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * Gets the password.
	 * 
	 * @return the password
	 */
	@Column(name = "password")
	public String getPassword() {
		return password;
	}

	/**
	 * Sets the password.
	 * 
	 * @param password
	 *            the new password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Gets the email.
	 * 
	 * @return the email
	 */
	@Column(name = "alt_email")
	public String getEmail() {
		return email;
	}

	/**
	 * Sets the email.
	 * 
	 * @param email
	 *            the new email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Gets the mobile.
	 * 
	 * @return the mobile
	 */
	@Column(name = "mobile_no")
	public Long getMobile() {
		return mobile;
	}

	/**
	 * Sets the mobile.
	 * 
	 * @param mobile
	 *            the new mobile
	 */
	public void setMobile(Long mobile) {
		this.mobile = mobile;
	}

	/**
	 * Instantiates a new user master.
	 */
	public UserMaster() {
	}

	/**
	 * Instantiates a new user master.
	 * 
	 * @param id
	 *            the id
	 * @param password
	 *            the password
	 * @param email
	 *            the email
	 */
	public UserMaster(int id, String password, String email) {
		this.id = id;
		this.password = password;
		this.email = email;
	}

	/**
	 * Instantiates a new user master.
	 * 
	 * @param id
	 *            the id
	 * @param username
	 *            the username
	 * @param dob
	 *            the dob
	 * @param firstname
	 *            the firstname
	 * @param lastname
	 *            the lastname
	 * @param password
	 *            the password
	 * @param email
	 *            the email
	 * @param mobile
	 *            the mobile
	 */
	public UserMaster(int id, String username, String dob, String firstname,
			String lastname, String password, String email, Long mobile) {
		this.id = id;
		this.password = password;
		this.email = email;
		this.mobile = mobile;
		this.dob = dob;
		this.firstname = firstname;
		this.lastname = lastname;
		this.username = username;

	}

}
