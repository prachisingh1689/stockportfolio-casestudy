
package com.impetus.services;

import com.impetus.process.AddStockManager;
import com.impetus.process.ChangePassword;
import com.impetus.process.ForgotpasswordManager;
import com.impetus.process.LoginActionManager;
import com.impetus.process.SearchStockManager;
import com.impetus.process.UserManager;
import com.impetus.services.mail.AlertManager;


/**
 * The Class Singleton.
 * It is used to implement singleton design pattern in project.
 *
 * @author prachi.singh
 */
public final class Singleton 
{

	
	/** The search stock manager. *//*
	static SearchStockManager searchStockManager = new SearchStockManager();
	
	*//** The change password. *//*
	static ChangePassword changePassword= new ChangePassword();
	
	*//** The forgotpassword manager. *//*
	static ForgotpasswordManager forgotpasswordManager= new ForgotpasswordManager();
	
	*//** The login action manager. *//*
	static LoginActionManager loginActionManager= new LoginActionManager();
	
	*//** The user manager. *//*
	static UserManager userManager= new UserManager();
	
	*//** The stock sax manager. *//*
	static StockSaxManager stockSaxManager= new StockSaxManager();
	
	*//** The alert manager. *//*
	static AlertManager alertManager= new AlertManager();
*/
	/**
	 * Gets the adds the stock manager.
	 *
	 * @return the adds the stock manager
	 */
	public static AddStockManager getAddStockManager()
	{
		return AddStockManager.getAddStockManagerInstance();
	}

	/**
	 * Gets the search stock manager.
	 *
	 * @return the search stock manager
	 */
	public static SearchStockManager getSearchStockManager()
	{
		return SearchStockManager.getSearchStockManagerInstance();

	}
	
	/**
	 * Gets the change password.
	 *
	 * @return the change password
	 */
	public static ChangePassword getChangePassword()
	{
		return ChangePassword.getChangePasswordInstance();
	}
	
	/**
	 * Gets the forgotpassword manager.
	 *
	 * @return the forgotpassword manager
	 */
	public static ForgotpasswordManager getForgotpasswordManager()
	{
		return ForgotpasswordManager.getForgotpasswordManagerInstance();
	}
	
	/**
	 * Gets the login action manager.
	 *
	 * @return the login action manager
	 */
	public static LoginActionManager getLoginActionManager()
	{
		return LoginActionManager.getLoginActionManagerInstance();
	}
	
	/**
	 * Gets the user manager.
	 *
	 * @return the user manager
	 */
	public static UserManager getUserManager()
	{
		return UserManager.getUserManagerInstance();
	}
	
	/**
	 * Gets the stock sax manager.
	 *
	 * @return the stock sax manager
	 */
	public static StockSaxManager getStockSaxManager()
	{
		return StockSaxManager.getstockSaxManagerInstance();
	}
	
	/**
	 * Gets the alert manager.
	 *
	 * @return the alert manager
	 */
	public static AlertManager getAlertManager()
	{
		return AlertManager.getAlertManagerInstance();
	}

}
