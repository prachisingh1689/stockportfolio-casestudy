package com.impetus.services;

/**
 *
 */

import java.util.Map;

import org.apache.log4j.Logger;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

/**
 * This Class is to validate whether user session is alive or not and do the
 * works as per the session.
 * 
 * @author prachi.singh
 */
public class LoginInterceptor implements Interceptor {

	/** serial version unique ID to ensure serialization compatibility. */
	private static final long serialVersionUID = 1L;

	/** The logger is to log different type of activities. */
	private Logger logger = Logger.getLogger(getClass());

	/**
	 * This method runs every time before action is called. If user session is
	 * not active then it will redirect to login
	 * 
	 * @param invocation
	 *            the invocation to invoke
	 * @return success if session is alive, login otherwise
	 */
	public final String intercept(final ActionInvocation invocation) {
		Map<String, Object> mapSession = ActionContext.getContext()
				.getSession();
		if (mapSession.containsKey("user_id")) {
			try {
				return invocation.invoke();
			} catch (Exception e) {
				//logger.info("exception:Interceptor runs");
				//throw new MyException("exception:Interceptor runs",e);
			return "loginIntercept";
			}
		} else {
			logger.info("Interceptor runs");
			return "loginIntercept";
		}
	}

	public void destroy() {

	}

	public void init() {

	}
}
