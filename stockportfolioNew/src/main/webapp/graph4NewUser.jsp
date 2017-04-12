<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="refresh" content="300"/>

<title>GRAPH</title>

<meta name="keywords"
	content="web design, Corporate Green, Free XHTML/CSS Template, 2-column layout" />
<meta name="description"
	content="Corporate Green, Free XHTML/CSS Template, 2-column layout" />
<link href="templatemo_style.css" rel="stylesheet" type="text/css" />
<style type="text/css">
.yearGraph .form {
	display: none;
}

.dayGraph .form {
	display: none;
}

.Graph .form {
	display: none;
}
</style>
<script language="javascript" type="text/javascript">
function clearText(field) {
	if (field.defaultValue == field.value)
		field.value = '';
	else if (field.value == '')
		field.value = field.defaultValue;
}

 date = document.getElementById("Text1").value;
var enddate = document.getElementById("Text").value;
if (startdate == "" && enddate == "") {
	alert("empty intervals");
} 
else {

	window.location = "New_user_chart.action?stockId=" + id + "&&startDate="
			+ startdate + " 00:00:00&&endDate=" + enddate + " 23:59:59";
}




function mypromptBox(id) {
	var year = document.getElementById("year").value;

	window.location = "New_user_chart.action?stockId=" + id + "&&startDate=" + year
			+ "-01-01 00:00:00&&endDate=" + year + "-12-31 23:59:59";
}
function setDate(id) {
	var date = document.getElementById("Text2").value;
	if (date == "") {
		alert("empty value");
	} else {

		window.location = "New_user_chart.action?stockId=" + id + "&&startDate="
				+ date + " 00:00:00&&endDate=" + date + " 23:59:59";
	}
}

function compareDates(startDate, endDate) {
	var currentDate=getCurrentDate();
	function parseDate(input) {
	var parts = input.match(/(\d+)/g);
	return new Date(parts[0], parts[1]-1, parts[2]); // months are 0-based
	}
	if (parseDate(endDate) < parseDate(startDate)) {
	return "true";
	}
	/* else if ((parseDate(startDate)>parseDate(currentDate))||(parseDate(endDateDate)>parseDate(currentDate)))
	{
	return "true";	
	} */

	}

function getCurrentDate()
	{
	var d=new Date();
	dd=d.getDate();
	mm=d.getMonth()+1;
	yyyy = d.getFullYear();
	var currentDate=yyyy+"-"+mm+"-"+dd;
	return currentDate;
	}



function setInterval(id) {
	var startdate = document.getElementById("Text1").value;
	var enddate = document.getElementById("Text").value;
	
	
	var currentDate=getCurrentDate();
	if(startdate == "" && enddate == "")
	{
	alert("empty intervals");
	}else if(enddate == ""){
	var enddate=getCurrentDate();
	window.location ="New_user_chart.action?stockId="+id+"&&startDate="+startdate+" 00:00:00&&endDate="+enddate+" 23:59:59";
	}else if(startdate == "" ){
	startdate="2012-10-01";
	window.location ="New_user_chart.action?stockId="+id+"&&startDate="+startdate+" 00:00:00&&endDate="+enddate+" 23:59:59";
	}else if( compareDates(startdate, currentDate)|| compareDates(enddate, currentDate)|| compareDates(startdate,enddate))
	{
	alert("Invalid Dates !!!!");
	}

	
	else {

		window.location = "New_user_chart.action?stockId=" + id + "&&startDate="
				+ startdate + " 00:00:00&&endDate=" + enddate + " 23:59:59";
	}
}

</script>
<script src="Scripts/DateTimePicker.js" type="text/javascript"></script>
</head>
<body >
	<div id="templatemo_container">
		<div id="templatemo_site_title_bar">
			<div id="site_title">
				<h1>
					<a href="#">Stock Portfolio<span></span> </a>
				</h1>
			</div>
			<div id="top_menu">
				<div class="home_menu">
					<a href="login.jsp"></a>
				</div>
				<div class="contact_us">
					<a href="contact_us.jsp"></a>
				</div>
			</div>

		</div>
		<!-- templatemo_site_title_bar -->

		<div id="templatemo_banner_bar">

			<h2>
				Welcome to Performance Charts 
			</h2>
		</div>
		<!-- end of templatemo_banner_bar -->
		<div id="templatemo_menu">
			<ul>
				<li><a href="login.jsp" class="current">Home</a>
				</li>
				<li><a href="register.jsp">Register</a>
				</li>
				<li><a href="BROWSE_4_new_user">Browse all</a>
				</li>
				<li><a href="http://www.impetus.com">About Us</a>
				</li>
				<li><a href="contact_us.jsp">Contact Us</a>
				</li>
			</ul>
		</div>
		<!-- end of menu -->
		<div id="templatemo_content_wrapper">

			<div id="templatemo_content">

				<div id="main_column">

					<div class="section_w590">

						<br />

						
						<br /> <h3>Performance graph</h3>
						<a href="BROWSE_4_new_user.action"><img
							src="<s:url value="/images/back.png"/>" height="50" width="50" align="left"/></a><br />Back
							
							
						<div align="left">
						<br />
						<br />
							<img alt="" src="<s:url action="displayNew.action"/>" />
						</div>



						<div class="cleaner"></div>
					</div>
					<div class="cleaner_h30"></div>
					<div class="cleaner"></div>
				</div>
				<!-- end of main column -->



				<!-- <div class="divider"></div> -->
				<div id="side_column">

					<div class="side_column_box">
						<h3>Select Duration</h3>
						<div class="news_section">

							

							<div>
								<form action="">
									<h5>Yearly Graph</h5> <br /> Select Year :<select
										id="year">
										<option value="2011"></option>
										<option value="2012">2012</option>
									</select> 
									<br/>
									<input type="button" value="Click" align="center"
										onclick="mypromptBox('<s:property value="stockId" />');" />
								</form>



								<br />
								<form action="">
									<h5>Day Graph</h5>
									<br /> Select Date : <input type="text" name="datepicker"
										id="Text2" readonly="true"
										onclick="javascript:NewCssCal ('Text2','yyyyMMdd')" /> <input
										type="button" value="Click" align="center"
										onclick="setDate('<s:property value="stockId" />');" />
								</form>

								<br />
								<form action="">
									<h5>Graph</h5> <br /> Start date : <input type="text"
										id="Text1" readonly="true"
										onclick="javascript:NewCssCal ('Text1','yyyyMMdd')" />
										 <br />
									<br /> End date : <input type="text" id="Text" readonly="true"
										onclick="javascript:NewCssCal ('Text','yyyyMMdd')" />
										 <br />
									<input type="button" value="Click" align="center"
										onclick="setInterval('<s:property value="stockId" />');" />
								</form>
							</div>
						</div>
					</div>
				</div>
				<!-- end of side column -->


				<div class="cleaner"></div>
			</div>
			<!-- end of content -->

			<div class="cleaner"></div>
		</div>
		<!-- end of templatmeo_content_wrapper -->

		<div id="templatemo_footer_bar_wrapper">
			<div id="templatemo_footer_bar">
				Copyright © 2012 <a href="http://www.impetus.com">Impetus
					Infotech India Pvt. Ltd.</a> <br /> Designed by <a href="mailto:prachi.singh@impetus.co.in">
					Prachi Singh </a>

			</div>
			<!-- end of footer -->
		</div>
		<!-- end of footer_wrapper -->
	</div>
	<!-- end of container -->
</body>
</html>