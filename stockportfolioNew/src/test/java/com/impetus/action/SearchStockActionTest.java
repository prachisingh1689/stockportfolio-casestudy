package com.impetus.action;

import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.StrutsTestCase;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionProxy;

public class SearchStockActionTest extends StrutsTestCase

{
	public void testExecute() throws Exception {

		request.setParameter("symbol", "i");
		ActionProxy proxy = getActionProxy("/searchstock");
		
		Map<String, Object> session = new HashMap<String, Object>();
		session.put("user_id", 23);
		session.put("username", "prachi");
		session.put("firstname", "prachi");
		session.put("lastname", "singh");
		ActionContext.getContext().setSession(session);
		assertEquals("success", proxy.execute());
		

	}

	public void testBrowse_allStock() throws Exception {

		ActionProxy proxy = getActionProxy("/BROWSE_ALL");
		Map<String, Object> session = new HashMap<String, Object>();
		session.put("user_id", 23);
		session.put("username", "prachi");
		session.put("firstname", "prachi");
		session.put("lastname", "singh");
		ActionContext.getContext().setSession(session);
		assertEquals("success", proxy.execute());

	}

}
