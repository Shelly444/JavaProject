/**
 * 
 */
package webd4201.kirkwoodm;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * @author Michelle Kirkwood
 *@since March 11 2019
 *The page where the user goes to change their password.
 */
public class ChangePasswordServlet extends HttpServlet
{
    public void doPost(HttpServletRequest request,
                            HttpServletResponse response )
                                throws ServletException, IOException
    {
    	final int MINIMUM_PASSWORD_LENGTH = 8;
    	final int MAXIMUM_PASSWORD_LENGTH = 40;
    	try
    	{ 
    	 //connect to database
    	Connection c = DatabaseConnect.initialize();
    	Student.initialize(c);
    	HttpSession session = request.getSession(true);
    	
    	try 
    	{ /* 	retrieve the customer attribute from the session
    			and cast it to an object of type Customer */

                Student aStudent = (Student) request.getSession(false).getAttribute( "student");
                // get the name and address values from the HTML page
                String currentPassword = request.getParameter("currentPassword");
                
                String newPassword = request.getParameter("newPassword");
                
                String confirmPassword = request.getParameter("confirmPassword");
                
                
                /* if name or address from HTML page does not match
                        info in DB, update DB */
                if (!currentPassword.equals(aStudent.getPassword()))
                {
                	response.sendRedirect("./passwordChange.jsp");
                	session.setAttribute("errors", "Wrong password");
                }
                else if (newPassword != confirmPassword)
                {
                	response.sendRedirect("./passwordChange.jsp");
                	session.setAttribute("errors", "The confirmation does not match");
                }
                else if (confirmPassword.length() < MINIMUM_PASSWORD_LENGTH || confirmPassword.length() > MAXIMUM_PASSWORD_LENGTH)
                {
                	response.sendRedirect("./passwordChange.jsp");
                	session.setAttribute("errors", "The password must be at least 8 characters and no more than 40 characters.");	
                }
                else if (currentPassword.equals(aStudent.getPassword()) && newPassword.equals(confirmPassword))
                {
                	aStudent.setPassword(confirmPassword);
                    
                    aStudent.update();
                    
                    response.sendRedirect("./index.jsp");
                    session.setAttribute("message", "Your password has been updated.");
                }
    	}catch (Exception e)
    	{  }
    	}catch (Exception e)
    	{ }
    }
}
