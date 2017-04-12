package com.impetus.action;

import org.apache.struts2.StrutsTestCase;

import com.opensymphony.xwork2.ActionProxy;

public class ForgotpasswordActionTest extends StrutsTestCase {
	public void testExecute() throws Exception {
		request.setParameter("email", "prmail.com");// password sent to the
													// emailid
		ActionProxy proxy = getActionProxy("/forgot_password");
		assertEquals("res", "error", proxy.execute());

		
		 /*request.setParameter("email", "prachi.singh1689@gmail.com");//invalid emailid 
		 ActionProxy proxy1=getActionProxy("/forgot_password");
		 assertEquals("result","success", proxy1.execute());*/
		
	}

}
