<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="refresh" content="300" />

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
	} else {

		window.location = "chart.action?stock_id=" + id + "&&startDate="
				+ startdate + " 00:00:00&&endDate=" + enddate + " 23:59:59";
	}

	function mypromptBox(id) {
		var year = document.getElementById("year").value;

		window.location = "chart.action?stock_id=" + id + "&&startDate=" + year
				+ "-01-01 00:00:00&&endDate=" + year + "-12-31 23:59:59";
	}
	function setDate(id) {
		var date = document.getElementById("Text2").value;
		if (date == "") {
			alert("empty value");
		} else {

			window.location = "chart.action?stock_id=" + id + "&&startDate="
					+ date + " 00:00:00&&endDate=" + date + " 23:59:59";
		}
	}
	function setInterval(id) {
		var startdate = document.getElementById("Text1").value;
		var enddate = document.getElementById("Text").value;
		if (startdate == "" && enddate == "") {
			alert("empty intervals");
		} else {

			window.location = "chart.action?stock_id=" + id + "&&startDate="
					+ startdate + " 00:00:00&&endDate=" + enddate + " 23:59:59";
		}
	}
	
</script>
<script src="Scripts/DateTimePicker.js" type="text/javascript"></script>
</head>
<body>
	<%
		response.setHeader("cache-control",
				"no-cache, no-store, must-revalidate");
		response.setHeader("pragma", "no-cache");
		response.setDateHeader("expires", 0);
		response.setHeader("Cache-Type", "private");
	%>

	<s:if test="%{#session['user_id']!= null}">

		<div id="templatemo_container">
			<div id="templatemo_site_title_bar">
				<div id="site_title">
					<h1>
						<a href="#">Stock Portfolio<span></span> </a>
					</h1>
				</div>
				<div id="top_menu">
					<div class="home_menu">
						<a href="welcome.jsp"></a>
					</div>
				</div>

			</div>
			<!-- templatemo_site_title_bar -->

			<div id="templatemo_banner_bar">

				<h2>Welcome to Performance Charts</h2>

			</div>
			<!-- end of templatemo_banner_bar -->
			<div id="templatemo_menu">
				<ul>
					<li><a href="welcome.jsp" class="current">Home</a>
					</li>
					<li><a href="BROWSE_ALL">Browse all</a>
					</li>
					<li><a href="portfolio">Portfolio</a>
					</li>
					<li><a href="logout">Logout</a>
					</li>
				</ul>
			</div>
			<!-- end of menu -->
			<div id="templatemo_content_wrapper">

				<div id="templatemo_content">

					<div id="main_column">

						<div class="section_w590">

							<br /> <br /> <br />
							<div align="center">
								<img alt="" src="<s:url action="display.action"/>" />
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
										<h5>Yearly Graph</h5>
										<br /> Select Year :<select id="year">
											<option value="2011">2011</option>
											<option value="2012">2012</option>
										</select> <br /> <input type="button" value="Click" align="center"
											onclick="mypromptBox('<s:property value="stock_id" />');" />
									</form>



									<br />
									<form action="">
										<h5>Day Graph</h5>
										<br /> Select Date : <input type="text" name="datepicker"
											id="Text2" readonly="true"
											onclick="javascript:NewCssCal ('Text2','yyyyMMdd')" /> <input
											type="button" value="Click" align="center"
											onclick="setDate('<s:property value="stock_id" />');" />
									</form>

									<br />
									<form action="">
										<h5>Graph</h5>
										<br /> Start date : <input type="text" id="Text1"
											readonly="true"
											onclick="javascript:NewCssCal ('Text1','yyyyMMdd')" /> <br />
										<br /> End date : <input type="text" id="Text"
											readonly="true"
											onclick="javascript:NewCssCal ('Text','yyyyMMdd')" /> <br />
										<input type="button" value="Click" align="center"
											onclick="setInterval('<s:property value="stock_id" />');" />
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
					Copyright © 2024 <a href="http://www.impetus.com">Impetus
						Infotech India Pvt. Ltd.</a> <br /> Designed by <a
						href="mailto:prachi.singh@impetus.co.in"> Prachi Singh </a>

				</div>
				<!-- end of footer -->
			</div>
			<!-- end of footer_wrapper -->
		</div>
		<!-- end of container -->
	</s:if>
	<s:else>
		<%
			String redirectURL = "login.jsp";
				response.sendRedirect(redirectURL);
		%>
	</s:else>


</body>
</html>








