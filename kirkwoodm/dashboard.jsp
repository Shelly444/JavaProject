<%
String title = "Durham College";
%>
<%@ include file="./header.jsp" %>
<%
String message = "";
String grades = (Student)session.getAttribute("marks");
String courseCode = (Student)session.getAttribute("programCode");
String gpa = (Student)session.getAttribute("gpa");
%>

<!--If logged in -->
<% if (((User) session.getAttribute("aUser") == null)){ %>
					
	<a href="login.jsp">Login</a>|
	<a href="register.jsp">Register</a>
<% } else { %>
	<a href="./Logout.jsp">Log Out</a>				<a href="./changePassword.jsp">Change Password </a> <a href="./Update.jsp">Update Information</a>
	<table>
		<tr>
		<th> Course Code </th>
		<th> Grade </th>
		<th> GPA </th>
	</tr>
	<tr>
		<td></td>
		<td></td>
		<td></td>
	</tr>
	</table>
<% } %>

<%@ include file="./footer.jsp" %>