package com.impetus.action;

import org.apache.struts2.StrutsTestCase;

import com.opensymphony.xwork2.ActionProxy;

public class UserActionTest extends StrutsTestCase {
	public void testadd() throws Exception {

		request.setParameter("user.firstname", "prachi");
		request.setParameter("user.lastname", "singh");
		request.setParameter("user.username", "singh");
		request.setParameter("user.email", "stockportfoliodb@gmail.com");
		request.setParameter("user.password", "12345678");
		request.setParameter("user.dob", "12-02-2012");
		request.setParameter("user.mobile", "9999789789");
		ActionProxy proxy = getActionProxy("/add");
		assertEquals("success", proxy.execute());

	}

}
