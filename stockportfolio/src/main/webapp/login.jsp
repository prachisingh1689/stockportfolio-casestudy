<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Stock Portfolio</title>

<meta name="keywords"
	content="web design, Corporate Green, Free XHTML/CSS Template, 2-column layout" />
<meta name="description"
	content="Corporate Green, Free XHTML/CSS Template, 2-column layout" />
<link href="templatemo_style.css" rel="stylesheet" type="text/css" />

<link rel="stylesheet" type="text/css" href="css/style4.css" />
<link rel="stylesheet" type="text/css" href="css/common.css" />


<script type='text/javascript' src='jquery-1.3.2.js'></script>
<script type="text/javascript">
	function clearText(field) {
		if (field.defaultValue == field.value)
			field.value = '';
		else if (field.value == '')
			field.value = field.defaultValue;
	}

	function getAlert(url) {
		var email = prompt("Please enter your registered Email_id");
		url += "email=" + email;
		alert(url);
		//+"\n"+"YOUR PASSWORD WILL BE SENT TO YOUR EMAIL_ID");
		$.get(url, function(data, textStatus) { //alert("Done, with the following status: " + textStatus + ". Here is the response: " + data);
		});
	}
	
</script>
<sx:head />
</head>
<body>
<%
response.setHeader("cache-control", "no-cache, no-store, must-revalidate");
response.setHeader("pragma", "no-cache");
response.setDateHeader("expires", 0);
response.setHeader("Cache-Type", "private");
%>

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

			<h2>Stock Portfolio</h2>
			<p>Manage, Track and get email alerts</p>


		</div>
		<!-- end of templatemo_banner_bar -->

		<div id="templatemo_menu">
			<ul>
				<li><a href="login.jsp" class="current">Home</a>
				</li>
				<li><a href="BROWSE_4_new_user">Browse all</a>
				</li>
				<li><a href="http://www.impetus.com">About Us</a>
				</li>
				<li><a href="contact_us.jsp">Contact Us</a>
				</li>
				<li><a href="Feedback.jsp">Feedback</a>
				</li>
			</ul>
		</div>
		<!-- end of menu -->

		<div id="templatemo_content_wrapper">

			<div id="templatemo_content">

				<div id="main_column">

					<div class="section_w590">
						<h3>Welcome to our WEBSITE!</h3>

						<img class="image_wrapper fl_image"
							src="images/templatemo_image_04.jpg" alt="image" />

						<p>

							<a href="login.jsp">StockPortfolio</a> is an online stock
							portfolio analysis system that gives you and your advisors easy
							access to your most up-to-date performance figures performance
							review, current stats anytime you need it, from anywhere in the
							world. We are like web analytics for investing.

						</p>
						<p>With PortfolioManager you will have a full control over
							your virtual portfolio. You will be able to track its performance
							in real time, manage your assets, get full statistics of your
							portfolio's performance and its technical indicators</p>
						<p>
							<h4>"ONE STOCK CAN CHANGE A PERSON'S LIFE !"</h4>
						</p>
						<ul>
							<li>We recommend those potential Multi baggers.<br />Join
								us and profit from investing in the right stocks at right time.
							</li>
						</ul>
						<div class="button_01" align="center">
							<a href="register.jsp">Subscribe Now</a>
						</div>
						<br />
<div><h4>Mail Alerts</h4></div>
						<ul>
							<li>Track your investments even when on the move.</li>
							<li>Trigger
								alerts via mail on price, percentage change in stock prices.</li>
						</ul>

						<div class="cleaner"></div>
					</div>

					<div class="cleaner_h30"></div>


					<div class="cleaner"></div>
				</div>
				<!-- end of main column -->


				<div id="side_column">
					<div class="side_column_box">
						<h5>Stock News</h5>

						<div class="news_section">
							<img class="image_wrapper" height="140" width="270"
								src="images/index2.jpg" alt="image" />
							<h4>Browse for Stock Market updates like---></h4>
							<ul>
								<li>Performance Charts</li>
								<li>Current Stock market Prices</li>
								<li>Stocks in market</li>
							</ul>

							Click below for above information

						</div>


						<div class="button_01">
							<a href="BROWSE_4_new_user">Stocks Updates</a>
						</div>
			     	</div>
			     </div>
				<!-- end of side column -->


				<div class="divider"></div>
				<div class="footer_box m_right">
					<div class="footer_bottom"></div>


					<h5>Login</h5>

					<div class="footer_box_content">
						<p>
							<img src="<s:url value="/images/login.png"/>" height="70"
								width="80" align="center"/> Login to create Portfolio
						</p>
						<div class="cleaner_h10"></div>
						<s:actionerror />
						<s:form action="login.action" method="post">
							<s:textfield name="user.username" label="Username" size="20"
								placeholder="username" />
								<br/>
							<s:password name="user.password" label="Password" size="20"
								placeholder="password" />

							<s:submit value="Submit" align="center" />
						</s:form>
						<!-- <div class="button_01"><a href="login.action">Submit</a></div>   -->
					</div>
				</div>

				<div class="footer_box m_right">
					<div class="footer_bottom"></div>



					<h5>Register</h5>

					<div class="footer_box_content">
						<div class="cleaner_h10"></div>
						<div align="center">
						<img src="<s:url value="/images/add.png"/>" height="70" width="70" align="center"/>
						</div>
						<ul class="list_01">
							<li>New user ??</li>
							<li>Not registered till now??</li>
						</ul>
						<div class="button_01" align="center">
							<a href="register.jsp">SignUp</a>
						</div>
					</div>

				</div>




				<div class="footer_box">
					<div class="footer_bottom"></div>
					<h5>Forgot password</h5>
					<div class="footer_box_content">
						<p align="center">Forgot password ??</p>
						<div align="center">
						<img src="<s:url value="/images/email.png"/>" height="60"
							width="70" align="center"/>
						</div>
						<ul>
							<li>To receive password on your registered Email_id----></li>
						</ul>
							<!-- <div class="button_01">
								<a href='javascript:getAlert("forgot_password.action?")'>Click
									Here</a>
							</div> -->
							<br/>
							<div class="button_01" align="center">
								<a href="ForgotPassword.jsp">Click
									Here</a>
							</div>

							
						

						<s:actionerror />
						<s:actionmessage />

						<%-- <div style="color: red; font-size: 20;font-style: italic; text-align: center;"><s:actionerror /> </div>--%>
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
					Infotech India Pvt. Ltd.</a> <br> Designed by <a href="mailto:prachi.singh@impetus.co.in">
						Prachi Singh </a> <br> <!-- <div class="button_01" align="center">
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