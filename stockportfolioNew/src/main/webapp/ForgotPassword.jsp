<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Forgot Password</title>

<meta name="keywords"
	content="web design, Corporate Green, Free XHTML/CSS Template, 2-column layout" />
<meta name="description"
	content="Corporate Green, Free XHTML/CSS Template, 2-column layout" />
<link href="templatemo_style.css" rel="stylesheet" type="text/css" />

<link rel="stylesheet" type="text/css" href="css/common.css" />
<link rel="stylesheet" type="text/css" href="css/style4.css" />
<style>

 
 
</style>

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

			<h2>Welcome to STOCKPORTFOLIO</h2>
			

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
				<li><a href="BROWSE_4_new_user">Browse all</a>
				</li>
				<li><a href="http://www.impetus.com">About Us</a>
				</li>
				<li><a href="contact_us.jsp" class="rollover">Contact Us</a>
				</li>

			</ul>
		</div>
		<!-- end of menu -->

		<div id="templatemo_content_wrapper">

			<div id="templatemo_content">

			<div id="main_column">
					<!-- <div align="center" style="border: 10px;border-color: white;"> -->
					<div class="section_w590">

						<br />
						<div align="center" style="border: medium; border-color: black;">

							<s:form action="forgot_password">
								<h3>FORGOT PASSWORD</h3>
								<br />
								<br />
								<font size="4px">Enter your Registered Email_id</font>
								<br />
								<s:textfield name="email" label="Email Id" size="30" placeholder="Email Id"/>
								<br />
								<s:submit value="Submit" align="center" />
							</s:form>
						</div>

						<div style="color: red; font-size: 20px; font-style: italic;">
							<s:actionerror />
						</div>
						<div style="color: green; font-size: 20px; font-style: italic;">
							<s:actionmessage />
						</div>
						<div class="cleaner"></div>

				

<div class="cleaner_h30"></div>
					<div class="cleaner"></div>




					</div>
					<br /> <br /> <br /> <br /> <br /> <br /> <br /> <br /> <br />
					<br /> <br /> <br /> <br /> <br /> <br /> <br />
					<div class="cleaner_h30"></div>
					<div class="cleaner"></div>
				</div>
				<!-- end of main column -->

<div id="side_column">

					<div class="side_column_box">
						<h5>Options</h5>
						<div class="news_section">


			<ul class="ch-grid">
					
					
					<li>
						<div class="ch-item ch-img-3">
							<div class="ch-info-wrap">
								<div class="ch-info">
									<div class="ch-info-front ch-img-3"></div>
									<div class="ch-info-back">
										<h3>Performance analysis- View Graphs</h3>
										<p> <div class="button_01" align="center">
								<a href="BROWSE_4_new_user">Browse stocks</a>
							</div> </p>
									</div>
								</div>
							</div>
						</div>
					</li>
					<li>
						<div class="ch-item ch-img-2">
							<div class="ch-info-wrap">
								<div class="ch-info">
									<div class="ch-info-front ch-img-2"></div>
									<div class="ch-info-back">
										<h3>Login Again- With your password</h3>
										
										<p><div class="button_01" align="center">
								<a href="login.jsp">Login</a></div></p>
									</div>
								</div>
							</div>
						</div>
					</li>
				</ul>
						
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
				Copyright © 2012 <a href="http://www.impetus.com">Impetus
					Infotech India Pvt. Ltd.</a> <br/> Designed by <a href="mailto:prachi.singh@impetus.co.in">
						Prachi Singh </a> <br/> <!-- <div class="button_01" align="center">
							<a href="#">Admin Login</a>
						</div> -->
			</div>
			<!-- end of footer -->
		</div>
		<!-- end of footer_wrapper -->
	</div>
	<!-- end of container -->
	<s:actionerror />
	<s:actionmessage />

</body>
</html>