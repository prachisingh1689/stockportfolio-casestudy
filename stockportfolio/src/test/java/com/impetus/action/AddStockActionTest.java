package com.impetus.action;

import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.StrutsTestCase;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionProxy;

public class AddStockActionTest extends StrutsTestCase

{
	AddStockAction add = new AddStockAction();

	public void testExecute() throws Exception {
		request.setParameter("stock_id", "2");
		request.setParameter("price", "1230.00");
		ActionProxy proxy = getActionProxy("/addstock");
		Map<String, Object> session = new HashMap<String, Object>();
		session.put("user_id", 23);

		ActionContext.getContext().setSession(session);
		assertEquals("success", proxy.execute());

	}

	public void testdelete() throws Exception {

		request.setParameter("userstockid", "39");
		ActionProxy proxy = getActionProxy("/dltstock");
		Map<String, Object> session = new HashMap<String, Object>();
		session.put("user_id", 2);
		ActionContext.getContext().setSession(session);
		assertEquals("success", proxy.execute());

	}

	public void testshow() throws Exception {
		ActionProxy proxy = getActionProxy("/portfolio");
		Map<String, Object> session = new HashMap<String, Object>();
		session.put("user_id", 23);
		ActionContext.getContext().setSession(session);
		assertEquals("success", proxy.execute());
	}

}
