/**
 * 
 */
package webd4201.kirkwoodm;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.util.Date;

/***
 * @author michelle
 *User Connection to database and website
 */
public class UserDA {
	
	static Vector<User> users = new Vector<User>();	// contains customer references
	static User aUser;
	
	// declare variables for the database connection
	static Connection aConnection;
	static Statement aStatement;

	// declare static variables for all Customer instance attribute values
	static long id;
	static String password;
	static String firstName;
	static String lastName;
	static String emailAddress;
	static Date lastAccess;
	static Date enrolDate;
	static boolean enabled;
	static String type;
	
/***
 * 
 * @param c
 */
	// establish the database connection
	public static void initialize(Connection c)
	{
            try {
                aConnection=c;
                aStatement=aConnection.createStatement();
            }
            catch (SQLException e)
            { System.out.println(e);	}
	}
/***
 * 
 */
	// close the database connection
	public static void terminate()
	{
            try
            { 	// close the statement
                aStatement.close();
            }
            catch (SQLException e)
            { System.out.println(e);	}
	}
	/***
	 * 
	 * @param id
	 * @return
	 * @throws NotFoundException
	 */

	public static User retrieve(long id) throws NotFoundException
	{ // retrieve Customer and Boat data
		aUser = null;
		// define the SQL query statement using the phone number key
		String sqlQuery = "SELECT users.id, password, firstName, lastName, emailAddress, lastAccess, enrolDate, enabled, type FROM users WHERE users.id = ?"; //" + id;

                //System.out.println(sqlQuery);
	 	// execute the SQL query statement
		try
 		{
					PreparedStatement ps = aConnection.prepareStatement(sqlQuery);
					ps.setLong(1, id);
                    ResultSet rs = ps.executeQuery();
                    // next method sets cursor & returns true if there is data
                    boolean gotIt = rs.next();
                    if (gotIt)
                    {	// extract the data
			id = rs.getLong("users.id");
			password = rs.getString("password");
			firstName = rs.getString("firstName");
			lastName = rs.getString("lastName");
			emailAddress = rs.getString("emailAddress");
			lastAccess = rs.getDate("lastAccess");
			enrolDate = rs.getDate("enrolDate");
			enabled = rs.getBoolean("enabled");
			type = rs.getString("type");
			
                    } else	// nothing was retrieved
                    {throw (new NotFoundException("Problem retrieving User record, id number " + id +" does not exist in the system."));}
                    rs.close();
	   	}catch (SQLException e)
		{ System.out.println(e);}
                
		return aUser;
	}
/***
 * 
 * @return
 */
	public static Vector<User> retrieveAll()
        {   // retrieve Customers and their boats
            // define the SQL query statement for get all
            String sqlQuery = "SELECT users.id, password, firstName, lastName, emailAddress, lastAccess, enrolDate, enabled, type FROM users WHERE users.id = ?";
            try
            {   // execute the SQL query statement
            	
                ResultSet rs = aStatement.executeQuery(sqlQuery);
                boolean moreData = rs.next();
                
                while (moreData)
                {	// extract the data
                	id = rs.getLong(1);
        			password = rs.getString(2);
        			firstName = rs.getString(3);
        			lastName = rs.getString(4);
        			emailAddress = rs.getString(5);
        			lastAccess = rs.getDate(6);
        			enrolDate = rs.getDate(7);
        			enabled = rs.getBoolean(8);
        			type = rs.getString(9);
        			
        			
                    users.addElement(aUser);
                    moreData = rs.next();
                }
                rs.close();
            }
            catch (SQLException e)
                    { System.out.println(e);}
            return users;
	}
	/***
	 * 
	 * @param aUser
	 * @return
	 * @throws DuplicateException
	 */

	public static boolean create(User aUser) throws DuplicateException
	{	
		boolean inserted = false; //insertion success flag
		// retrieve the customer attribute values
		id = aUser.getId();
		password = aUser.getPassword();
		firstName = aUser.getFirstName();
		lastName = aUser.getLastName();
		emailAddress = aUser.getEmailAddress();
		lastAccess = aUser.getLastAccess();
		enrolDate = aUser.getEnrolDate();
		enabled = aUser.isEnabled();
		type = aUser.getType();
		
		// create the SQL insert statement using attribute values
		String sqlInsertUser = "INSERT INTO users (id, password, firstName, lastName, emailAddress, lastAccess, enrolDate, enabled, type) VALUES (100222222, 'password', 'Robert', 'McReady', 'bob.mcready@dcmail.ca', '2016-03-07', '2015-09-03', true, 's')";
		// see if this customer already exists in the database
		try
		{
			retrieve(id);
			throw (new DuplicateException("Problem with creating User record, id number " + id +" already exists in the system."));
		}
		// if NotFoundException, add customer to database
		catch(NotFoundException e)
		{
			try
 			{  // execute the SQL update statement
	    		inserted = aStatement.execute(sqlInsertUser);
	    		
			}
			catch (SQLException ee)
				{ System.out.println(ee);	}
		}
		return inserted;
	}
	/***
	 * 
	 */

	public static int delete(User aUser) throws NotFoundException
	{	
		int records = 0;
		// retrieve the phone no (key)
		id = aUser.getId();
		// create the SQL delete statement
		String sqlDeleteUser = "DELETE FROM users WHERE id = ?";
		
		// see if this customer already exists in the database
		try
		{
			User.retrieve(id);  //used to determine if record exists for the passed Customer
    		// if found, execute the SQL update statement
    		records = aStatement.executeUpdate(sqlDeleteUser);
    		
		}catch(NotFoundException e)
		{
			throw new NotFoundException("User with id " + id 
					+ " cannot be deleted, does not exist.");
		}catch (SQLException e)
			{ System.out.println(e);	}
		return records;
	}
	/***
	 * 
	 * @param aUser
	 * @return
	 * @throws NotFoundException
	 */

	public static int update(User aUser) throws NotFoundException
	{	
		int records = 0;  //records updated in method
		
		// retrieve the customer argument attribute values
		id = aUser.getId();
		password = aUser.getPassword();
		firstName = aUser.getFirstName();
		lastName = aUser.getLastName();
		emailAddress = aUser.getEmailAddress();
		lastAccess = aUser.getLastAccess();
		enrolDate = aUser.getEnrolDate();
		enabled = aUser.isEnabled();
		type = aUser.getType();

		// define the SQL query statement using the phone number key
		String sqlUpdateUser = "UPDATE users SET password='newpassword', firstName= 'Robert', lastName='McReady', emailAddress='bob.mcready@dcmail.ca', lastAccess='2016-03-10', enrolDate='2015-09-03', type='s', enabled=true WHERE id = ?";
		// see if this customer exists in the database
		// NotFoundException is thrown by find method
		try
		{
                    User.retrieve(id); 
                    //determine if there is a Customer record to be updated
                    // if found, execute the SQL update statement
                    PreparedStatement ps = aConnection.prepareStatement(sqlUpdateUser);
					ps.setLong(1, id);
					ps.setString(1, password);
					ps.setString(1, firstName);
					ps.setString(1, lastName);
					ps.setString(1, emailAddress);
					ps.setDate(1, lastAccess);
					ps.setDate(1, enrolDate);
					ps.setBoolean(1, enabled);
					ps.setString(1, type);
                    int rs = ps.executeUpdate();
                    records = aStatement.executeUpdate(sqlUpdateUser);
                    
		}catch(NotFoundException e)
		{
			throw new NotFoundException("User with id number " + id 
					+ " cannot be updated, does not exist in the system.");
		}catch (SQLException e)
		{ System.out.println(e);}
		return records;
	}
	/***
	 * 
	 * @param id
	 * @param password
	 * @return
	 * @throws NotFoundException
	 */
	public static User authenticate(long id, String password) throws NotFoundException
	{
		String sqlQuery = "SELECT  * " +
				" FROM users " +
				" WHERE id= '" + id +"' AND password= '" + password +"'";
		//System.out.println(sqlQuery);
		boolean exists = true;                  
		// execute the SQL query statement
		try
		{
		ResultSet rs = aStatement.executeQuery(sqlQuery);
		exists = rs.next();
		}catch (SQLException e)
		{ 
		System.out.println(e);
		}
		
		return aUser;
		
	}
	/***
	 * 
	 * @param login
	 * @return
	 * @throws NotFoundException
	 */
	public static String find(String login) throws NotFoundException
	{
		aUser = null;
		// define the SQL query statement using the phone number key
		String sqlQuery = "SELECT users.id, password, firstName, lastName, emailAddress, lastAccess, enrolDate, enabled, type FROM users WHERE users.id = ?"; //" + id;

                //System.out.println(sqlQuery);
	 	// execute the SQL query statement
		try
 		{
                    ResultSet rs = aStatement.executeQuery(sqlQuery);
                    // next method sets cursor & returns true if there is data
                    boolean gotIt = rs.next();
                    if (gotIt)
                    {	// extract the data
			id = rs.getLong("id");
			password = rs.getString("password");
			firstName = rs.getString("firstName");
			lastName = rs.getString("lastName");
			emailAddress = rs.getString("emailAddress");
			lastAccess = rs.getDate("lastAccess");
			enrolDate = rs.getDate("enrolDate");
			enabled = rs.getBoolean("enabled");
			type = rs.getString("type");
			
                    } else	// nothing was retrieved
                    {throw (new NotFoundException("Problem retrieving User record, id number " + id +" does not exist in the system."));}
                    rs.close();
	   	}catch (SQLException e)
		{ System.out.println(e);}
        String.valueOf(id);  
		return login;
	}
	/***
	 * 
	 * @param login
	 * @return
	 * @throws DuplicateException
	 * @throws NotFoundException
	 */
	public static boolean isExistingLogin(String login) throws DuplicateException, NotFoundException
	{
		retrieve(id);
		throw (new DuplicateException("Problem with creating User record, id number " + id +" already exists in the system."));
	}

}
