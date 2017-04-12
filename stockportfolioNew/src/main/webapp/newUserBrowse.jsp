<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="refresh" content="300" />

<title>STOCK DETAILS</title>

<meta name="keywords"
	content="web design, Corporate Green, Free XHTML/CSS Template, 2-column layout" />
<meta name="description"
	content="Corporate Green, Free XHTML/CSS Template, 2-column layout" />
<link href="templatemo_style.css" rel="stylesheet" type="text/css" />

<script language="javascript" type="text/javascript">
	function clearText(field) {
		if (field.defaultValue == field.value)
			field.value = '';
		else if (field.value == '')
			field.value = field.defaultValue;
	}
	window.history.forward();


</script>
</head>


<body>
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

			<h2>Stock Updates</h2>

		</div>
		<!-- end of templatemo_banner_bar -->
		<div id="templatemo_menu">
			<ul>
				<li><a href="login.jsp" class="current">Home</a>
				</li>
				<li><a href="register.jsp">Register</a>
				</li>
				<li><a href="login.jsp">Login</a>
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



						<div align="right">

							<s:form action="searchstock4_newuser">
								<u style="margin-right: 90px;">
								SEARCH STOCK
								</u>

								<!-- <h4>Enter ticker symbol here</h4> -->

								<s:textfield name="symbol" size="35"
									placeholder="Enter company name or Ticker symbol" />
								<br />
								<s:submit value="Submit" align="center" />
							</s:form>
							<!-- <font color="yellow" style="">(To Add these stocks to your
								Portfolio first Login)</font> -->
						</div>


						<a href="login.jsp"><img
							src="<s:url value="/images/back.png"/>" height="50" width="50"
							align="left" />
						</a><br />Back <br />
						<%-- <div align="left">
							<a href="BROWSE_4_new_user" title="Refresh">
		<img src="<s:url value="/images/Refresh.png"/>" height="40"
								width="40" align="left" title="Refresh" />	
								</a>
								<br />Refresh</div> --%>

						<!-- <div align="center">
							<u style="color: green; width: 10px;"><h3>Current Stock
									Prices</h3>
							</u>
						</div> -->
						<font color="red">*</font><font color="yellow" style="">(To Add these stocks to your
								Portfolio first Login)</font>
						<div align="center">
							<br />
							<s:if test="%{stockList.size() == 0}">
								<div style="font-size: 30px; color: gray; font-weight: bolder; font-style: italic; margin: 0 0 0 10%;  box-shadow:gray -0.4em -0.4em em "">
									No Result Found
									</div>
								</s:if>
								<s:elseif test="%{stockList == null }">
								<div style="font-size: 30px; color: gray; font-weight: bolder; font-style: italic; margin: 0 0 0 10%;  box-shadow:gray -0.4em -0.4em em "">
									Internal Server Error
									</div>
								</s:elseif>
								<s:else>
								
							<table border="10px" width="800">
								<tr align="center" style="font-size: medium;" bgcolor="">
									<th>S.No.</th>
									<th>Company</th>
									<th>Symbol</th>
									<th>Current Price</th>
									<th>View Graph</th>

								</tr>
								<s:iterator value="stockList">
									<tr>
										<td align="center"><s:property value="stockId" />
										</td>
										<td align="center"><s:property value="name" />
										</td>
										<td align="center"><s:property value="symbol" />
										</td>

										<s:iterator value="xmlstockList" var="xmlList"
											status="xmlListStatus">
											<s:if test="#xmlListStatus.last==true">
												<td align="center"><s:property value="price" />
												</td>

												<td align="center"><a
													href="New_user_chart.action?stockId= <s:property value="stock.stockId"/>"><img
														src="<s:url value="/images/graph.jpg"/>" height="30"
														width="50" /> </a>
												</td>
											</s:if>
										</s:iterator>
									</tr>
								</s:iterator>

							</table>
							</s:else>
						</div>

						<div class="cleaner"></div>
					</div>
					<div class="cleaner_h30"></div>
					<div class="cleaner"></div>
				</div>
				<!-- end of main column -->



				<div class="divider"></div>



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

