package com.impetus.action;

import org.apache.struts2.StrutsTestCase;
import com.opensymphony.xwork2.ActionProxy;

public class LoginActionTest extends StrutsTestCase {

	public void testExecute() throws Exception {
		request.setParameter("user.username", "prachi");
		request.setParameter("user.password", "12345678");// emailid and
															// password match
		ActionProxy proxy = getActionProxy("/login");
		assertEquals("success", proxy.execute());

		request.setParameter("user.username", "prachi");
		request.setParameter("user.password", "12345");// emailid and password
														// dont match
		ActionProxy proxy1 = getActionProxy("/login");
		assertEquals("error", proxy1.execute());

	}

}
