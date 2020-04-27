<%
String title = "Update Info";
%>
<%@ include file="./header.jsp" %>
<%String login = (Student)session.getAttribute("login");
	String password = (Student)session.getAttribute("password");
	String firstName = (Student)session.getAttribute("firstName");
	String lastName = (Student)session.getAttribute("lastName");
	String email = (Student)session.getAttribute("email");
	String programCode = (Student)session.getAttribute("programCode");
	String programDescription = (Student)session.getAttribute("programDescription");
	String year = (Student)session.getAttribute("year");
	%>
	<% if (((Student) session.getAttribute("aStudent") == null)){ %>
					
	<a href="login.jsp">Login</a>|
	<a href="register.jsp">Register</a>
<%}%>

<center>
	
	<h2>Please Update</h2>
	<p>Enter your personal information below.
	   </p>
<form name="Input" method="post" action=".\Users\miche\Documents\Tomcat8.0\webapps\kirkwoodm\WEB-INF\web.xml\Update" >
		 
		<table border=0 cellpadding=10 >
		<tr><td colspan="2" align="center"></td></tr>
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
			<td><input type="submit" value = "Update"></td>
			<td><input type="reset" value = "Clear"></td>
		</tr>
		</table>
	</form>
<%@ include file="./footer.jsp" %>