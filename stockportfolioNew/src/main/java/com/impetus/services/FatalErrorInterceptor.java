package com.impetus.services;

/**
 * 
 */

import org.apache.log4j.Logger;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.interceptor.Interceptor;

/**
 * @author prachi.singh
 * 
 */
public class FatalErrorInterceptor extends ActionSupport implements Interceptor {

	private static final long serialVersionUID = 1L;
	private static final Logger LOGGER = Logger
			.getLogger(FatalErrorInterceptor.class);

	public String intercept(final ActionInvocation invocation)
	{

		try {

			return invocation.invoke();

		} catch (Exception e) {

			LOGGER.error("exception caught while executing action", e);
			addActionError(getText("errors.fatal"));
			return "fatal";

		}

	}

	public void destroy() {

	}

	public void init() {

	}

}
