package com.impetus.services.charts;

import org.apache.struts2.StrutsTestCase;

import com.opensymphony.xwork2.ActionProxy;

public class ShowChartActionTest extends StrutsTestCase

{

	public void testExecute() throws Exception {

		request.setParameter("stock_id", "2");
		request.setParameter("startDate", "9-10-2012 12:02:30");
		request.setParameter("endDate", "10-10-2012 12:02:30");

		ActionProxy proxy = getActionProxy("/chart");

		assertEquals("success", proxy.execute());
	}

}
