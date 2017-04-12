package com.impetus.action;

import org.apache.struts2.StrutsTestCase;

import com.opensymphony.xwork2.ActionProxy;

public class SearchStockActionTest extends StrutsTestCase

{
	public void testExecute() throws Exception {

		request.setParameter("symbol", "i");
		ActionProxy proxy = getActionProxy("/searchstock");
		assertEquals("success", proxy.execute());

	}

	public void testBrowse_allStock() throws Exception {

		ActionProxy proxy = getActionProxy("/BROWSE_ALL");
		assertEquals("success", proxy.execute());

	}

}
