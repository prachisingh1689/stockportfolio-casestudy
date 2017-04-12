package com.impetus.action;

import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.StrutsTestCase;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionProxy;

public class AlertUserActionTest extends StrutsTestCase

{

	public void testalert() throws Exception {

		request.setParameter("userstockid", "56");
		request.setParameter("change", "2");
		ActionProxy proxy = getActionProxy("/alert");

		Map<String, Object> session = new HashMap<String, Object>();
		session.put("user_id", 23);
		ActionContext.getContext().setSession(session);

		assertEquals("success", proxy.execute());
	}

}
