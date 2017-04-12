package com.impetus.services.charts;

import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.StrutsTestCase;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionProxy;

public class ShowChartActionTest extends StrutsTestCase

{

	public void testExecute() throws Exception {

		request.setParameter("stockId", "2");
		request.setParameter("startDate", "2012-10-09 12:02:30");
		request.setParameter("endDate", "2012-10-10 12:02:30");

		ActionProxy proxy = getActionProxy("/chart");
		Map<String, Object> session = new HashMap<String, Object>();
		session.put("user_id", 23);
		ActionContext.getContext().setSession(session);
		assertEquals("success", proxy.execute());
	}
}
