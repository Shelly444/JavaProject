/**
 * 
 */
package webd4201.kirkwoodm;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author miche
 *
 */
public class RegisterServlet extends HttpServlet{
	
	public void doPost(HttpServletRequest request,
            HttpServletResponse response) 
	throws ServletException, IOException

	{
		try
		{ 
		 //connect to database
		Connection c = DatabaseConnect.initialize();
		Student.initialize(c);
		HttpSession session = request.getSession(true);
		String login = new String();
		String password = new String();
		String firstName = new String();
		String lastName = new String();
		String email = new String();
		String userType = new String();
		String enabled = new String();
		Date enrolDate = new Date();
		Date lastAccess = new Date();
		Date today = new Date();
		String programCode = new String();
		String programDescription = new String();
		String year = new String();
		try 
		{   // retrieve data from DB
		login = request.getParameter("id");//this is the name of the text input box on the form
		password = request.getParameter("password");
		firstName = request.getParameter("firstName");
		lastName = request.getParameter("lastName");
		email = request.getParameter("email");
		userType = "s";
		enabled = "true";
		programCode = request.getParameter("programCode");
		programDescription = request.getParameter("programDescription");
		year = request.getParameter("year");
		
		Student aStudent = Student.create(); //attempt to find the Student, this could cause a NotFoundException
		User aUser = User.create(); //if the Student was found and retrieved from the db
		//put the found Student onto the session
		session.setAttribute("student", aStudent);
		//empty out any errors if there were some
		session.setAttribute("errors", "");

		// redirect the user to a JSP
		response.sendRedirect("./login.jsp");
		}catch( NotFoundException nfe)
		{
		//new code == way better, if I do say so myself
		//sending errors to the page thru the session
		StringBuffer errorBuffer = new StringBuffer();
		errorBuffer.append("<strong>Your sign in information is not valid.<br/>");
		errorBuffer.append("Please try again.</strong>");
		if(!User.isExistingLogin(login)){
		    session.setAttribute("login", login);
			session.setAttribute("password", password);
			session.setAttribute("firstName", firstName);
			session.setAttribute("lastName", lastName);
			session.setAttribute("email", email);
			session.setAttribute("s", userType);
			session.setAttribute("true", enabled);
			session.setAttribute("programCode", programCode);
			session.setAttribute("programDescription", programDescription);
			session.setAttribute("year", year);
			session.setAttribute("enrolDate", today);
			session.setAttribute("lastAccess", today);
		}
		else
		{
		  errorBuffer.append("Invalid registration.</strong>");
		  
		}
		session.setAttribute("errors", errorBuffer.toString());
		response.sendRedirect("./register.jsp");

		//for the first deliverable you will have to check if there was a problem
		//with just the password, or login id and password
		//this will require a special method e.g. public static boolean isExistingLogin(String arg);
		}
		}    
		catch (Exception e) //not connected
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
		 */
		public void doGet(HttpServletRequest request,
		            HttpServletResponse response)
		                    throws ServletException, IOException {
		doPost(request, response);
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

