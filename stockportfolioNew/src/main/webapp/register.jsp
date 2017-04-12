<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Registration Page</title>

<meta name="keywords"
	content="web design, Corporate Green, Free XHTML/CSS Template, 2-column layout" />
<meta name="description"
	content="Corporate Green, Free XHTML/CSS Template, 2-column layout" />
<link href="templatemo_style.css" rel="stylesheet" type="text/css" />

<script language="javascript" type="text/javascript">
	function clearText(field) 
	{
		if (field.defaultValue == field.value)
			field.value = '';
		else if (field.value == '')
			field.value = field.defaultValue;
	}
</script>
<script src="Scripts/DateTimePicker.js" type="text/javascript"></script>
<sx:head />
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
				Register Here 
				</font>
			</h2>

		</div>
		<!-- end of templatemo_banner_bar -->
		<div id="templatemo_menu">
			<ul>
				<li><a href="login.jsp" class="current">Home</a></li>
				<li><a href="BROWSE_4_new_user">Stocks</a></li>
				<li><a href="http://www.impetus.com">About Us</a></li>
				<li><a href="contact_us.jsp">Contact Us</a></li>
				
			</ul>
		</div>
		<!-- end of menu -->

		<div id="templatemo_content_wrapper">

			<div id="templatemo_content">

				<div id="main_column">

					<div class="section_w590">
						<h3 align="center">Welcome to Registration Page</h3>
						<ul>
						<li>Fields with asterisk (<font color="red">*</font>) are mandatory. </li>
						<li>Mobile number should be from 8 to 10 digits.</li>
						</ul>
						<div class="cleaner"></div>
					</div>
					<div class="cleaner_h30"></div>
					<div class="cleaner"></div>
				</div>
				<!-- end of main column -->


				<div align="center">
					<div class="divider"></div>
					<div class="footer_box m_right" >
						<div class="footer_bottom" ></div>
						<h5>REGISTER</h5>

						<div class="footer_box_content" align="center" style="font-weight: bold; width: 90%; f">
							<div style="float:inherit;">
							<s:form action="add" method="post" validate="true">
							

								<s:textfield name="user.firstname" label="FirstName"
									required="true" placeholder="firstname"/>
									<br>
								<s:textfield name="user.lastname" label="LastName" placeholder="lastname" required="true"/>
								
								<s:textfield name="user.username" label="Username"
									required="true" placeholder="username"/>
								
								<s:textfield name="user.email" label="Email_Id" required="true" placeholder="Email_id"/>
								
								<s:password name="user.password" label="Password"
									required="true" placeholder="password"/>
								
								
								
									
								<s:textfield name="user.dob" id="Text2" readonly="true"
									onclick="javascript:NewCssCal ('Text2','yyyyMMdd')"
									label="Birth Date"  
									tooltip="use claendar" placeholder="use calender" />
									
																	
									
								<s:textfield name="user.mobile" label="Mobile" placeholder="mobile"/>

								<s:submit value="Submit" align="center" />
								</s:form></div>
<s:actionerror />
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
				Copyright © 2012 <a href="http://www.impetus.com">Impetus
					Infotech India Pvt. Ltd.</a> 
					<br/> 
					Designed by <a href="mailto:prachi.singh@impetus.co.in">
					Prachi Singh </a>

			</div>
			<!-- end of footer -->
		</div>
		<!-- end of footer_wrapper -->
	</div>
	<!-- end of container -->
</body>


</html>