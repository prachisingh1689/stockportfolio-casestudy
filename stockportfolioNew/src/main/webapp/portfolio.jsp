<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

<meta http-equiv="refresh" content="300" />

<title>Portfolio</title>

<meta name="keywords"
	content="web design, Corporate Green, Free XHTML/CSS Template, 2-column layout" />
<meta name="description"
	content="Corporate Green, Free XHTML/CSS Template, 2-column layout" />
<link href="templatemo_style.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css"
	href="http://cdn.webrupee.com/font"></link>
<link rel="stylesheet" type="text/css" href="css/common.css" />
<link rel="stylesheet" type="text/css" href="css/style4.css" />
<script type='text/javascript' src='jquery-1.3.2.js'></script>
<script type="text/javascript">
	function clearText(field) {
		if (field.defaultValue == field.value)
			field.value = '';
		else if (field.value == '')
			field.value = field.defaultValue;
	}
	
    function getChangePassword(url)
    {
    	
    var newpassword = prompt("Please enter the new password "); 
    if (newpassword == "") 
	    {
				
				alert(" Please enter a value");
	} 
	    else if(newpassword == null)
	    	{
	    	
	    	}
		
 	else if (newpassword.length > 7 && newpassword.length <= 16) 
		{
 			
 		url += "&newpassword=" + newpassword;
 		 $.get(url, function(data, textStatus) {
 			 if(textStatus == "success"){
 			 alert("Your password has been reset");}
 			 });
 	
			}
	else 
		{
				alert("Invalid password..The value should be from 8 to 16.");
			}
	
        }
    
    
	function getAlert(url) {
		var change = prompt("Please enter %CHANGE for setting alert");

		if (!isNaN(change) && change > 0 && change <= 100 && change != null
				&& change != "") {

			//if((parseFloat(change) || parseInt(change)) && (!isNaN(change) && change>0 && change<=100 && change!=null && change!="")){
			url += "&change=" + change;
			//alert(url + "\n" + "EMAIL WILL BE SENT ON SET DEFLECTION");
		} 
			else if (change == null) {

		}

		else if (change == "") {

			alert(" Please enter a value");

		}

		else {

			alert("The value should be either integer or float from 1 to 100.Please enter again. Invalid number");

		}
		$.get(url, function(data, textStatus) { //alert("Done, with the following status: " + textStatus + ". Here is the response: " + data);
			window.location.reload();});
	}
</script>
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

				<h2>
					Login Successful, Welcome <font color="red" size="6"><s:property
							value="#session.firstname" /> <s:property
							value="#session.lastname" /> </font>
				</h2>

			</div>
			<!-- end of templatemo_banner_bar -->
			<div id="templatemo_menu">
				<ul>
					<li><a href="welcome.jsp" class="current">Home</a></li>
					<li><a href="BROWSE_ALL">Add</a></li>
					<li><a href="BROWSE_ALL">Search</a></li>
					<li><a href="BROWSE_ALL">Browse</a></li>
					<li><a href="logout">Logout</a></li>

				</ul>
			</div>
			<!-- end of menu -->
			<div id="templatemo_content_wrapper">

				<div id="templatemo_content">

					<div class="button_01" align="right">
						<a
							href='javascript:getChangePassword("ChangePassword.action?user_id=<s:property value="#session.user_id"/>")'>
							Reset Password</a>
					</div>

					<div id="main_column">


						<div class="section_w590">
							<h5>Added Stocks</h5>
							<br />

							<div style="color: red; font-weight: bold; font-size: 15px;">
								<s:actionerror />
							</div>
							<div style="color: yellow; font-weight: bold; font-size: 15px;">
								<s:actionmessage />
							</div>
							<div align="center">
								<s:if test="%{portfolioList.size() == 0}">
									<div style="font-size: 30px; color: yellow; font-weight: bold;">
										You have no stocks in your portfolio</div>
								</s:if>
								<s:else>
									<s:set var="userstocks" value="%{portfolioList.size()}"></s:set>
									<br />
									<div align="left">
										<font color="aqua" size="4px"> <s:property
												value="#session.firstname" /> <s:property
												value="#session.lastname" /> ----> <u>Currently you
												have <font color="yellow" size="5px"><s:property
														value="#userstocks" /> </font> stocks in your portfolio </u> </font> <br />
										<br />
									</div>
									<table border="10px" width="925px">
										<tr align="center" style="font-size: medium;" bgcolor="">
											<th>Company</th>
											<th>Symbol</th>
											<th>Stock Prices</th>
											<th>Current Price</th>
											<th>Change</th>
											<th>Change %</th>
											<th>Email Alert</th>
											<th>View Graph</th>
											<th>Delete stock<img
												src="<s:url value="/images/trash_can.png"/>" height="40"
												width="50" /></th>

										</tr>
										<s:iterator value="portfolioList" var="pl">
											<tr>
												<td align="center"><s:property value="stock.name" />
												</td>
												<td align="center"><s:property value="stock.symbol" />

												</td>
												<td align="center"><strong><span
														class="WebRupee">Rs </span> </strong> <s:property value="price" />
												</td>
												<s:iterator value="stock.xmlstockList" var="xmlList"
													status="xmlListStatus">
													<s:if test="#xmlListStatus.last==true">
														<td align="center"><strong><span
																class="WebRupee">Rs </span> </strong> <s:property value="price" />
														</td>

														<s:set var="change" value="%{#xmlList.price - #pl.price }"></s:set>
														<s:set var="changePercent"
															value="%{#change * 100 / #pl.price}"></s:set>
														<s:set var="changePercent1"
															value="%{((#changePercent * 100) % 10000)/100}" />
														<s:if test="#change > 0">
															<td style="color: green;" align="center"><s:property
																	value="#change" />
															</td>
															<td style="color: green;" align="center"><s:property
																	value="#changePercent1" /></td>
														</s:if>
														<s:else>
															<td style="color: red;" align="center"><s:property
																	value="#change" />
															</td>
															<td style="color: red;" align="center"><s:property
																	value="#changePercent1" /></td>
														</s:else>
													</s:if>
												</s:iterator>


												<s:if test="change != null">

													<td id="alert" align="center"><a
														href='javascript:getAlert("alert.action?userstockid=<s:property value="userstockid"/>")'><s:property
																value="change" /> </a>
													</td>
												</s:if>
												<s:else>
													<td id="alert" align="center"><a
														href='javascript:getAlert("alert.action?userstockid=<s:property value="userstockid"/>")'>Set
															Alert?</a>
													</td>
												</s:else>
												<td align="center"><a
													href="chart.action?stockId= <s:property value="stock.stockId"/>"><img
														src="<s:url value="/images/graph2.jpg"/>" height="40"
														width="50" /> </a>
												</td>
												<td align="center"><a
													href="dltstock.action?userstockid= <s:property value="userstockid"/>">
														<img src="<s:url value="/images/red-cross.jpg"/>"
														height="40" width="40" /> </a>
												</td>
											</tr>
										</s:iterator>
									</table>
								</s:else>
							</div>
							<br /> <br /> <br /> <br /> <br /> <br />
							<div class="cleaner"></div>
						</div>
						<div class="cleaner_h30"></div>
						<div class="cleaner"></div>
					</div>
					<!-- end of main column -->



					<!-- <div class="divider"></div> -->







					<div class="cleaner"></div>
				</div>
				<!-- end of content -->

				<div class="cleaner"></div>
			</div>
			<!-- end of templatmeo_content_wrapper -->

			<div id="templatemo_footer_bar_wrapper">
				<div id="templatemo_footer_bar">
					Copyright © 2012 <a href="http://www.impetus.com">Impetus
						Infotech India Pvt. Ltd.</a> <br /> Designed by <a
						href="mailto:prachi.singh@impetus.co.in"> Prachi Singh </a> <br />
					<!-- end of footer_wrapper -->
				</div>
	</s:if>
	<s:else>
		<%
			String redirectURL = "/login.jsp";
				response.sendRedirect(redirectURL);
		%>
	</s:else>
	<!-- end of container -->
</body>


</html>


