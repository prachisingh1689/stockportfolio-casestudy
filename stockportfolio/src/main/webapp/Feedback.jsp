<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Feedback page</title>

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

			<h2>We appreciate your feedback</h2>

		</div>
		<!-- end of templatemo_banner_bar -->
		<div id="templatemo_menu">
			<ul>
				<li><a href="login.jsp" class="current">Home</a></li>
				<!-- <li><a href="#">News</a>
				</li> -->
				<li><a href="register.jsp">Register</a></li>
				<li><a href="BROWSE_4_new_user">Browse all</a></li>
				<li><a href="http://www.impetus.com">About Us</a></li>
				<li><a href="contact_us.jsp">Contact Us</a></li>
			</ul>
		</div>
		<!-- end of menu -->
		<div id="templatemo_content_wrapper">

			<div id="templatemo_content">

				<div id="main_column">

					<div class="section_w590">

						<br />

						<div >
							<h5>Feedback</h5>
							<div align="left" style="font-size:20px; color:yellow; ">
							<ul>
							 <li>For any queries and issues share your Feedback with us below. </li>
							 <li>We will revert back to you as soon as possible</li>
							 </ul>
							 </div>
							<div>
							<div style="color: green; font-size:13px;font-style: italic; text-align: center;"><s:actionmessage /> </div>
								<s:form style="text-align: left" method="post" action="Feedback.action">
										<div
										style="width: 0px; height: 0px; position: absolute; left: -100px; top: -100px; overflow: hidden">
										<input type="hidden" name="id2_hf_0" id="id2_hf_0" />
									</div>
									<fieldset>
											<div>
											<div >Name</div>
											 <input type="text" name="name" />
											</div>		
													
											<div >
												<div >E-mail_ID</div>
												<input type="text" name="email" />
											</div>
											
											<div>
												<div> Mobile No</div>
												<input type="text" name="mobile"/>
											
											</div>
											
											<div >
												<div >Subject</div>
												
													<select name="type">
														<option selected="selected" value="0">General Feedback</option>
														<option value="1">Technical Issue</option>
														<option value="2">Product Suggestion</option>
													</select>
												
											</div>
											
											 <br/> 
											<div>
												<div >Feedback</div>
												<textarea type="text" name="text" rows="10" cols="50"></textarea>
											</div>
											<s:submit value="Submit" />
									</fieldset>	
								</s:form>
								
								
														
								
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
					Copyright © 2024 <a href="http://www.impetus.com">Impetus
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


