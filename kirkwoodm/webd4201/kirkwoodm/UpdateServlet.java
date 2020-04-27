/**
 * 
 */
package webd4201.kirkwoodm;

import java.io.*;
import java.sql.Connection;

import javax.servlet.*;
import javax.servlet.http.*;

import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author michelle
 *Update Servlet Updates the Students information
 */
public class UpdateServlet extends HttpServlet {
		/***
		 * Posting object to servlet
		 */
		public void doPost(HttpServletRequest request,
	            HttpServletResponse response )
	                throws ServletException, IOException
	{
			try
			{ 
			 //connect to database
			Connection c = DatabaseConnect.initialize();
			Student.initialize(c);
			HttpSession session = request.getSession(true);
	try 
	{ /* 	retrieve the Student attribute from the session
	and cast it to an object of type Student */
	/***
	 * Get Student object from session
	 */
	Student aStudent = (Student) request.getSession(false).getAttribute( "student");
	// get the personal values from the HTML page
	String firstName = request.getParameter("firstName").trim();
	String lastName = request.getParameter("lastName").trim();
	String email = request.getParameter("email").trim();
	String programCode = request.getParameter("programCode").trim();
	String programDescription = request.getParameter("programDescription").trim();
	String year = request.getParameter("year").trim();
	
	/* if values from HTML page does not match
	    info in DB, update DB */
	boolean anyErrors = false;
	StringBuffer errorBuffer = new StringBuffer();
	if(firstName.length() == 0)
	{
		anyErrors = true;
		errorBuffer.append("<h3 class=\"error\">You must enter a first name.</h3>\n");
		response.sendRedirect("./Update.jsp");
	}
	else if(lastName.length() == 0)
	{
		anyErrors = true;
		errorBuffer.append("<h3 class=\"error\">You must enter a last name.</h3>\n");
		response.sendRedirect("./Update.jsp");
	}
	else if(email.length() == 0)
	{
		anyErrors = true;
		errorBuffer.append("<h3 class=\"error\">You must enter a email Address.</h3>\n");
		response.sendRedirect("./Update.jsp");
	}
	else if(programCode.length() > 4)
	{
		anyErrors = true;
		errorBuffer.append("<h3 class=\"error\">programCode must be 4 characters or less.</h3>\n");
		response.sendRedirect("./Update.jsp");
	}
	else if (!firstName.equals(aStudent.getFirstName()) ||
	                      !lastName.equals(aStudent.getLastName()) ||
	                      !email.equals(aStudent.getEmailAddress()) ||
	                      !programCode.equals(aStudent.getProgramCode()) ||
	                      !programDescription.equals(aStudent.getProgramDescription()) ||
	                      !year.equals(aStudent.getYear())) 
	{
	aStudent.setFirstName(firstName);
	aStudent.setLastName(lastName);
	aStudent.setEmailAddress(email);
	aStudent.setProgramCode(programCode);
	aStudent.setProgramDescription(programDescription);
	aStudent.setYear(Integer.parseInt(year));
	aStudent.update();
	}
	// invoke the dashboard.jsp program
	response.sendRedirect("./dashboard.jsp");
	}catch (NotFoundException e)
	{	} //do nothing
			}catch (Exception e) //not connected
			{
				System.out.println(e);
				String line1="<h2>A network error has occurred!</h2>";
				String line2="<p>Please notify your system " +
				                                    "administrator and check log. "+e.toString()+"</p>";
				formatErrorPage(line1, line2,response);
				}
	}
		/***
		 * 
		 * @param first
		 * @param second
		 * @param response
		 * @throws IOException
		 */
		public void formatErrorPage( String first, String second,
				HttpServletResponse response) throws IOException
				{
				PrintWriter output = response.getWriter();
				response.setContentType( "text/html" );
				output.println(first);
				output.println(second);
				output.close();
				}
}
