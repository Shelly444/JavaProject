
<%@ page import = "kirkwoodm.*" %>
<%   String errorMessage = (String)session.getAttribute("errors"); 
	String login = (String)session.getAttribute("login");
	String password = (String)session.getAttribute("password");
	if(errorMessage == null)
		errorMessage="";
	if(login == null)
		login = "";
%>
<%
String title = "Login";
%>
<%@ include file="./header.jsp" %>

	<center>
	
	<h2>Please log in</h2>
	<p>Enter your login information below.<br>
	   If you are not a Student or Faculty member, please return to the
	   <a href="index.jsp">Durham College</a> home page.</p>
	<p>
	   If you want to become a Student or Faculty member on our system, please <a href="register.jsp">register</a>.</p>
	<form name="Input" method="post" action=".\Users\miche\Documents\Tomcat8.0\webapps\kirkwoodm\WEB-INF\classes\webd4201\kirkwoodm\LoginServlet" >
		<!-- action="http://localhost:81/Bradshaw/LoginServlet" > -->
		<table border=0 cellpadding=10 >
		<tr><td colspan="2" align="center"></td></tr>
		<tr>
			<td><strong>Login Id</strong></td>
			<td><input type="number" name="id" value="" size=20></td>
		</tr>
		<tr>
			<td><strong>Password</strong></td>
			<td><input type= "password" name="password" value="" size="40"></td>
		</tr>
		</table>
		<table border=0 cellspacing=15 >
		<tr>
			<td><input type="submit" value = "Log In"></td>
			<td><input type="reset" value = "Clear"></td>
		</tr>
		</table>
	</form>
	Please wait after pressing <strong>Log in</strong>
	while we retrieve your records from our database.<br>
	<em>(This may take a few moments)</em>
	</center>
<%@ include file="./footer.jsp" %>