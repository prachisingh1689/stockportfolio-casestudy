<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Login Successful</title>

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

	
</script>
</head>

<body >
<%
response.setHeader("cache-control", "no-cache, no-store, must-revalidate");
response.setHeader("pragma", "no-cache");
response.setDateHeader("expires", 0);
response.setHeader("Cache-Type", "private");
%>

<s:if test="%{#session['user_id']!= null}">

	<div id="templatemo_container">
		<div id="templatemo_site_title_bar">
			<div id="site_title">
				<h1>
					<a href="#">Stock Portfolio<span></span>
					</a>
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
				<!-- <li><a href="#">News</a></li> -->
				<li><a href="BROWSE_ALL">Browse all</a></li>
				<li><a href="portfolio">Portfolio</a></li>
				<li><a href="logout.action">Logout</a></li>
			</ul>
		</div>
		<!-- end of menu -->

		<div id="templatemo_content_wrapper">

			<div id="templatemo_content">

				<div id="main_column">

					<div class="section_w590">
						<h3>Welcome</h3>
						<div class="cleaner"></div>
					</div>

					<div class="cleaner_h30"></div>


					<div class="cleaner"></div>
				</div>
				<!-- end of main column -->





				<div class="divider"></div>
				<div class="footer_box m_right">
					<div class="footer_bottom"></div>


					<h5>VIEW PORTFOLIO</h5>

					<div class="footer_box_content">
						<p>Submit to view Portfolio</p>
						<div class="button_01">
							<a href="portfolio">Submit</a>
						</div>

					</div>

				</div>

				<div class="footer_box m_right">
					<div class="footer_bottom"></div>



					<h5>ADD STOCK</h5>

					<div class="footer_box_content">

						<div class="cleaner_h10"></div>
						<ul class="list_01">
							<li>See all stocks</li>
							<li>Stock Prices</li>
							<li>Variation graphs</li>
						</ul>
						<div class="button_01">
							<a href="BROWSE_ALL">Add/ Search stocks</a>
						</div>
					</div>

				</div>

				<div class="footer_box">
					<div class="footer_bottom"></div>

					<h5>SEARCH STOCK</h5>



					<div class="footer_box_content">
						<p>Search Stock ??</p>
						<div class="button_01">
							<a href="BROWSE_ALL">Click Here</a>
						</div>
					</div>

				</div>

				<div class="cleaner"></div>
			</div>
			<!-- end of content -->

			<div class="cleaner"></div>
		</div>
		<!-- end of templatmeo_content_wrapper -->

		<div id="templatemo_footer_bar_wrapper">
			<div id="templatemo_footer_bar">
				Copyright © 2024 <a href="http://www.impetus.com">Impetus
					Infotech India Pvt. Ltd.</a> <br /> Designed by <a href="mailto:prachi.singh@impetus.co.in">
					Prachi Singh </a> <br />


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