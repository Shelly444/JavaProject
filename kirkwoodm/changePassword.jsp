<%@ page import = "kirkwoodm.*" %>
<%   String errorMessage = (String)session.getAttribute("errors"); 
	String password = (String)session.getAttribute("password");
	if(errorMessage == null)
		errorMessage="";
	if(password == null)
		password = "";
%>
<%
String title = "Change Password";
%>
<%@ include file="./header.jsp" %>

<% Student aStudent = (Student)session.getAttribute("student"); %>
<form name="PasswordChange" method="post" action="./Login" >
		<!-- action="http://localhost:81/Bradshaw/LoginServlet" > -->
		<table border=0 bgcolor="lightgoldenrodyellow" cellpadding=10 >
		<tr><td colspan="2" align="center"><%= errorMessage %></td></tr>
		<tr>
			<td><strong>Current Password</strong></td>
			<td><input type="password" name="currentPassword" value="" size=40></td>
		</tr>
		<tr>
			<td><strong>New Password</strong></td>
			<td><input type= "Password" name="newPassword" value="" size="40"></td>
		</tr>
		<tr>
			<td><strong>Confirm Password</strong></td>
			<td><input type= "password" name="confirmPassword" value="" size="40"></td>
		</tr>
		</table>
		<table border=0 cellspacing=15 >
		<tr>
			<td><input type="submit" value = "Update Password"></td>
			<td><input type="reset" value = "Clear"></td>
		</tr>
		</table>
	</form>
<%@ include file="./footer.jsp" %>