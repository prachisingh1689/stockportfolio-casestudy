<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<div style="float: inherit;">
		<s:form action="ChangePassword.action" method="post">
							
							<s:password name="newpassword" label="newpassword" size="20"
								placeholder="newpassword" />

							<s:submit value="Submit" align="center" />
						</s:form>
	</div>


</body>
</html>