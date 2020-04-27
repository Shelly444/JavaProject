<%
String title = "Register";
%>
<%@ include file="./header.jsp" %>
<%String login = (String)session.getAttribute("login");
	String password = (String)session.getAttribute("password");
	String firstName = (String)session.getAttribute("firstName");
	String lastName = (String)session.getAttribute("lastName");
	String email = (String)session.getAttribute("email");
	String programCode = (String)session.getAttribute("programCode");
	String programDescription = (String)session.getAttribute("programDescription");
	String year = (String)session.getAttribute("year");
	
%>
<!--if (((User) session.getAttribute("aUser") != null)){
		redirect("./login.jsp");
}-->
<center>
	
	<h2>Please Register</h2>
	<p>Enter your personal information below.
	   </p>
	   <a href="login.jsp">Login</a>
<form name="Input" method="post" action=".\Users\miche\Documents\Tomcat8.0\webapps\kirkwoodm\WEB-INF\classes\webd4201\kirkwoodm\RegisterServlet" >
		<!-- action="http://localhost:81/Bradshaw/LoginServlet" > -->
		 
		<table border=0 cellpadding=10 >
		<tr><td colspan="2" align="center"></td></tr>
		<tr>
			<td><strong>Login Id</strong></td>
			<td><input type="number" name="id" value="<%= login %>" size=20></td>
		</tr>
		<tr>
			<td><strong>Password</strong></td>
			<td><input type= "password" name="password" value="<%= password %>" size="40"></td>
		</tr>
		<tr>
			<td><strong>First Name</strong></td>
			<td><input type= "text" name="firstName" value="<%= firstName %>" size="30"></td>
		</tr>
		<tr>
			<td><strong>Last Name</strong></td>
			<td><input type= "text" name="lastName" value="<%= lastName %>" size="40"></td>
		</tr>
		<tr>
			<td><strong>Email Address</strong></td>
			<td><input type= "email" name="email" value="<%= email %>" size="40"></td>
		</tr>
		<tr>
			<td><strong>Program Code</strong></td>
			<td><input type= "text" name="programCode" value="<%= programCode %>" size="10"></td>
		</tr>
		<tr>
			<td><strong>Program Description</strong></td>
			<td><input type= "text" name="programDescription" value="<%= programDescription %>" size="100"></td>
		</tr>
		<tr>
			<td><strong>Year</strong></td>
			<td><input type= "number" name="year" value="<%= year %>" size="1"></td>
		</tr>
		
		</table>
		<table border=0 cellspacing=15 >
		<tr>
			<td><input type="submit" value = "Register"></td>
			<td><input type="reset" value = "Clear"></td>
		</tr>
		</table>
	</form>
<%@ include file="./footer.jsp" %>