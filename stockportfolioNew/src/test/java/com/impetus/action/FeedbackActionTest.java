package com.impetus.action;

import org.apache.struts2.StrutsTestCase;

import com.opensymphony.xwork2.ActionProxy;

public class FeedbackActionTest extends StrutsTestCase {

	public void testExecute() throws Exception {
		request.setParameter("name", "prachi");
		request.setParameter("email", "prmail.com");
		request.setParameter("mobile", "1234567890");
		request.setParameter("text", "hi admin");
		request.setParameter("type", "2");

		ActionProxy proxy = getActionProxy("/Feedback");
		assertEquals("res", "success", proxy.execute());

	}
}
