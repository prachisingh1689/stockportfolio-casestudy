<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>AboutUs</title>

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

			<h2>About Us</h2>

		</div>
		<!-- end of templatemo_banner_bar -->
		<div id="templatemo_menu">
			<ul>
				<li><a href="login.jsp" class="current">Home</a></li>
				<!-- <li><a href="#">News</a>
				</li> -->
				<li><a href="register.jsp">Register</a></li>
				<li><a href="BROWSE_4_new_user">Browse all</a></li>
				
				<li><a href="contact_us.jsp">Contact Us</a></li>
			</ul>
		</div>
		<!-- end of menu -->
		<div id="templatemo_content_wrapper">

			<div id="templatemo_content">

				<div id="main_column">

					<div class="section_w590">

						<br />

						<div align="left"
							box-shadow: #585858 0em 0em 1.5em 1em; border-radius: 10px; width: 850px; margin: 2% auto;">
							<br />
								<h5><u>Stock Portfolio</u></h5>
							
							<br/> <!--  content -->
								
							<div style="float: left; width: 115px;">Built by :</div>
							<div style="float: left;" >Connecture Team </div>
							<div style="clear: both;"></div>
							<br />
							
							<div style="float: left; width: 115px;">Supervisor:</div>
							<div style="float: left;">Mr.Gagan Marwah</div>
							<div style="clear: both;"></div>
							<br />
							
							<div style="float: left; width: 115px;">Project Guide :</div>
							<div style="float: left;">Mr. Sandeep Tripathi</div>
							<div style="clear: both;"></div>
							<br />
							
							<div style="float: left; width: 115px;">Developer :</div>
							<div style="float: left;">Prachi Singh </div>
							<div style="clear: both;"></div>
							<br />
							
							<div style="float: left; width: 115px;">Developer Id :</div>
							<div style="float: left;">IIPL-2442</div>
							<div style="clear: both;"></div>
							<br />
							
												
							<div style="float: left; width: 115px;">Email us : </div>
							<div style="float: left;">
								<a href="mailto:prachi.singh@impetus.co.in" class="email">prachi.singh@impetus.co.in</a>
							</div>
							<div style="clear: both;"></div>
							<br />
							
							<div style="float: left; width: 115px;">More about us at : </div>
							<div style="float: left;">
								<a href="http://www.impetus.com">Impetus site</a>
							</div>
							<div style="clear: both;"></div>
							<br />
							
									
						</div>
						</div>

						<div class="cleaner"></div>
					</div>
					<div class="cleaner_h30"></div>
					<div class="cleaner"></div>
				</div>
				<!-- end of main column -->
			<!-- end of content -->
			<!-- end of templatmeo_content_wrapper -->

		<div id="templatemo_footer_bar_wrapper">
			<div id="templatemo_footer_bar">
				Copyright © 2024 <a href="http://www.impetus.com">Impetus
					Infotech India Pvt. Ltd.</a> <br /> Designed by <a href="mailto:prachi.singh@impetus.co.in">
					Prachi Singh </a>

			</div>
			<!-- end of footer -->
		</div>
		<!-- end of footer_wrapper -->
	</div>
	<!-- end of container -->
	<s:actionmessage />
</div>
</body>
</html>


