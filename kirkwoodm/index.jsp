<%
String title = "Durham College";
%>
<%@ include file="./header.jsp" %>
<%
String message = "";
%>
	<center>
	<h1><em><font color="red">Welcome to Durham College</font></em></h1>
	</center>
	<p> </p>
	
	<center><br>If you are a Durham College Student or Faculty Member, please log in.
	<table align="center">
		<tr>
			<td><%= message %></td>
		</tr>
	<tr>
		<td width="100" align="Center">
			<a href="login.jsp">
			<strong><font size="+1">Log In</font></strong></a>
		</td>
	</tr>
	<tr>
		<td width="100" align="Center">
			<a href="register.jsp">
			<strong><font size="+1">Register</font></strong></a>
		</td>
	</tr>
	
	</table>
	<%@ include file="./footer.jsp" %>