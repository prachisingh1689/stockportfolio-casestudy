package com.impetus.services.charts;

import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;

import com.impetus.services.MyConstant;
import com.opensymphony.xwork2.ActionSupport;

/**
 * The Class DisplayCharts. this class is used to create charts .It extends
 * ActionSupport in order to provide Action support messages.
 * 
 * @author Prachi.Singh
 * 
 */
@SuppressWarnings("serial")
public class DisplayCharts extends ActionSupport implements
		ServletResponseAware {
	private static Logger logger = Logger.getLogger(DisplayCharts.class);

	/** The res. */
	private HttpServletResponse res = null;

	/**
	 * Execute method of Display charts class It creates chart using jfree api
	 * 
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */
	public String execute() {
		logger.info("entering  execute method of display chart class");
		logger.info("in display charts");
		HttpSession ses = ServletActionContext.getRequest().getSession();
		JFreeChart chart = (JFreeChart) ses.getAttribute("chart");

		try {
			OutputStream out = res.getOutputStream();
			ChartUtilities.writeChartAsPNG(out, chart, MyConstant.SIXHUNDRED, MyConstant.FIVEHUNDRED);
			logger.info("chart shown on jsp");
		} catch (IOException e) {
			
			logger.error(e.getMessage());
			
		}

		return "success";
	}

	/** 
	 * @see
	 * org.apache.struts2.interceptor.ServletResponseAware#setServletResponse
	 * (javax.servlet.http.HttpServletResponse)
	 */
	public void setServletResponse(HttpServletResponse arg0) {
		res = arg0;
	}
}