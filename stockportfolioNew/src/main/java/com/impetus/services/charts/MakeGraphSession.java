package com.impetus.services.charts;




import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.data.time.Minute;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import com.impetus.POJO.XMLStockMaster;

import org.apache.log4j.Logger;

/**
 * The Class MakeGraphSession. To input data into session
 * 
 * @author Prachi.Singh
 */
public class MakeGraphSession {
	
	private static Logger logger = Logger.getLogger(MakeGraphSession.class);

	/**
	 * Today chart. This method sets the data into session
	 * 
	 * @param stockpricelist
	 *            the stockpricelist
	 */
	public void todayChart(List<XMLStockMaster> stockpricelist,String startDate,String endDate,String symbol,String name) 
	{
		logger.info("entering  todayChart method of makegraph session class");
		String timeSeriesVar =null;
		String title=null;
		
		
		title= "GRAPH for "+name+" ("+symbol+") ";
		if(startDate==null && endDate== null)
		{
			timeSeriesVar ="Full Time Interval";	
		}
		else
		{
		timeSeriesVar ="Time Interval From:" + startDate + " To:" + endDate;
		}
		TimeSeries timeseries = new TimeSeries("", Minute.class);
		for (XMLStockMaster s : stockpricelist) {
			timeseries.addOrUpdate(new Minute(new Date(s.getTime().getTime())),
					s.getPrice());
		}
		TimeSeriesCollection dataset = new TimeSeriesCollection();
		dataset.addSeries(timeseries);
		JFreeChart chart = ChartFactory.createTimeSeriesChart(title, // Title
				timeSeriesVar, // X-Axis label
				"Price", // Y-Axis label
				dataset, // Dataset
				true, // Show legend
				true, // tooltips
				false // url
				);
		HttpSession ses = ServletActionContext.getRequest().getSession();
		ses.setAttribute("chart", chart);
		
	}
}
