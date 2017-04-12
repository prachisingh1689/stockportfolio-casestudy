package com.impetus.action;

import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.StrutsTestCase;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionProxy;

public class LogoutActionTest extends StrutsTestCase {

	public void testExecute() throws Exception {

		ActionProxy proxy = getActionProxy("/logout");
		Map<String, Object> session = new HashMap<String, Object>();
		session.put("user_id", "11");
		session.put("username", "");
		System.out.println("hiee");
		ActionContext.getContext().setSession(session);
		assertEquals("success", proxy.execute());
	}

}
