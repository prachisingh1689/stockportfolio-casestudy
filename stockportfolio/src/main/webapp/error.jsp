<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Error page</title>

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


<body>
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
				ERROR PAGE
			</h2>

		</div>
		<!-- end of templatemo_banner_bar -->
		<div id="templatemo_menu">
			<ul>
				<li><a href="login.jsp" class="current">Home</a>
				</li>
				<!-- <li><a href="#">News</a>
				</li> -->
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
						
						<div align="center">
						
		<img src="<s:url value="/images/error.png"/>" height="200" width="200"/>
		<br /> <br/>
		<h2>Error occured</h2>
		<br/><br/>
		<h4>THIS  COMBINATION  OF  USERNAME  &  PASSWORD  DOES  NOT  MATCH</h4>
	</div>
	<div align="center"><a href="login.jsp">LOGIN AGAIN</a></div>

	<s:actionmessage />
						
				
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
				Copyright © 2024 <a href="http://www.impetus.com">Impetus
					Infotech India Pvt. Ltd.</a> <br /> Designed by <a href="mailto:prachi.singh@impetus.co.in"> Prachi
					Singh </a>

			</div>
			<!-- end of footer -->
		</div>
		<!-- end of footer_wrapper -->
	</div>
	<!-- end of container -->
	<s:actionmessage />
</body>
</html>


<%-- 
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Error page</title>
</head>
<body>
	<div align="center">
		<img src="<s:url value="/images/error.png"/>" height="200" width="200">
		<h2>Error occured</h2>
		<br>
		<h2>THIS COMBINATION OF USERNAME and PASSWORD DONT MATCH</h2>
	</div>
	<div align="center"><a href="login.jsp">LOGIN AGAIN</a></div>

	<s:actionmessage />
</body>
</html>
 --%>