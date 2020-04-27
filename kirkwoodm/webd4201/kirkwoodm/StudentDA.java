/**
 * 
 */
package webd4201.kirkwoodm;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.util.Date;

/**
 * @author michelle
 *
 */
public class StudentDA {

	static Vector<Student> students = new Vector<Student>();	// contains customer references
	static Student aStudent;
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
	static String programCode;
	static String programDescription;
	static int year;
	

	// establish the database connection
	/***
	 * 
	 * @param c
	 */
	public static void initialize(Connection c)
	{
            try {
                aConnection=c;
                aStatement=aConnection.createStatement();
            }
            catch (SQLException e)
            { System.out.println(e);	}
	}

	// close the database connection
	/***
	 * 
	 */
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
	public static Student retrieve(long id) throws NotFoundException
	{ // retrieve Customer and Boat data
		aStudent = null;
		// define the SQL query statement using the phone number key
		String sqlQuery = "SELECT users.id, password, firstName, lastName, emailAddress, lastAccess, enrolDate, enabled, type, programCode, programDescription, year FROM users, students WHERE users.id = students.id AND users.id = ?"; //" + id;

                //System.out.println(sqlQuery);
	 	// execute the SQL query statement
		try
 		{
                    ResultSet rs = aStatement.executeQuery(sqlQuery);
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
			programCode = rs.getString("programCode");
			programDescription = rs.getString("programDescription");
			year = rs.getInt("year");
			
                    } else	// nothing was retrieved
                    {throw (new NotFoundException("Problem retrieving Student record, id number " + id +" does not exist in the system."));}
                    rs.close();
	   	}catch (SQLException e)
		{ System.out.println(e);}
                
		return aStudent;
	}
	/***
	 * 
	 * @return
	 */
	public static Vector<Student> retrieveAll()
        {   // retrieve Customers and their boats
            // define the SQL query statement for get all
            String sqlQuery = "SELECT users.id, password, firstName, lastName, emailAddress, lastAccess, enrolDate, enabled, type, programCode, programDescription, year FROM users, students WHERE users.id = ?";
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
        			programCode = rs.getString(10);
        			programDescription = rs.getString(11);
        			year = rs.getInt(12);
        			
        			
                    students.addElement(aStudent);
                    moreData = rs.next();
                }
                rs.close();
            }
            catch (SQLException e)
                    { System.out.println(e);}
            return students;
	}
	/***
	 * 
	 * @param aStudent
	 * @return
	 * @throws DuplicateException
	 */
	public static boolean create(Student aStudent) throws DuplicateException
	{	
		boolean inserted = false; //insertion success flag
		// retrieve the customer attribute values
		id = aStudent.getId();
		password = aStudent.getPassword();
		firstName = aStudent.getFirstName();
		lastName = aStudent.getLastName();
		emailAddress = aStudent.getEmailAddress();
		lastAccess = aStudent.getLastAccess();
		enrolDate = aStudent.getEnrolDate();
		enabled = aStudent.isEnabled();
		type = aStudent.getType();
		programCode = aStudent.getProgramCode();
		programDescription = aStudent.getProgramDescription();
		year = aStudent.getYear();
		
		// create the SQL insert statement using attribute values
		String sqlInsertStudent = "INSERT INTO students (id, programCode, programDescription, year) VALUES (100222222, 'CPA', 'Computer Programmer Analyst', 3)";
		// see if this customer already exists in the database
		try
		{
			retrieve(id);
			throw (new DuplicateException("Problem with creating Student record, id number " + id +" already exists in the system."));
		}
		// if NotFoundException, add customer to database
		catch(NotFoundException e)
		{
			try
 			{  // execute the SQL update statement
	    		inserted = aStatement.execute(sqlInsertStudent);
	    		
			}
			catch (SQLException ee)
				{ System.out.println(ee);	}
		}
		return inserted;
	}
	/***
	 * 
	 * @param aStudent
	 * @return
	 * @throws NotFoundException
	 */
	public static int delete(Student aStudent) throws NotFoundException
	{	
		int records = 0;
		// retrieve the phone no (key)
		id = aStudent.getId();
		// create the SQL delete statement
		
		String sqlDeleteStudent = "DELETE FROM students WHERE id = ?";
		// see if this customer already exists in the database
		try
		{
			Student.retrieve(id);  //used to determine if record exists for the passed Customer
    		// if found, execute the SQL update statement
    		
    		records = aStatement.executeUpdate(sqlDeleteStudent);
		}catch(NotFoundException e)
		{
			throw new NotFoundException("Student with id " + id 
					+ " cannot be deleted, does not exist.");
		}catch (SQLException e)
			{ System.out.println(e);	}
		return records;
	}
	/***
	 * 
	 * @param aStudent
	 * @return
	 * @throws NotFoundException
	 * @throws SQLException 
	 */
	public static int update(Student aStudent) throws NotFoundException, SQLException
	{	
		aConnection.setAutoCommit(false);
		UserDA.update(aUser);
		int records = 0;  //records updated in method
		
		// retrieve the customer argument attribute values
		id = aStudent.getId();
		password = aStudent.getPassword();
		firstName = aStudent.getFirstName();
		lastName = aStudent.getLastName();
		emailAddress = aStudent.getEmailAddress();
		lastAccess = aStudent.getLastAccess();
		enrolDate = aStudent.getEnrolDate();
		enabled = aStudent.isEnabled();
		type = aStudent.getType();
		programCode = aStudent.getProgramCode();
		programDescription = aStudent.getProgramDescription();
		year = aStudent.getYear();

		// define the SQL query statement using the phone number key
		String sqlUpdateStudent = "UPDATE students SET programCode='RPN', programDescription='Registered Practical Nurse', year=3 WHERE id = ?";
		// see if this customer exists in the database
		// NotFoundException is thrown by find method
		try
		{
                    Student.retrieve(id);  //determine if there is a Customer recrod to be updated
                    // if found, execute the SQL update statement
                    aConnection.commit();
                    records = aStatement.executeUpdate(sqlUpdateStudent);
                    
		}catch(NotFoundException e)
		{
			aConnection.rollback();
			throw new NotFoundException("Student with id number " + id 
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
	public static Student authenticate(long id, String password) throws NotFoundException
	{
		String sqlQuery = "SELECT  * " +
				" FROM students " +
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
		
		return aStudent;
		
	}
	/***
	 * 
	 * @param login
	 * @return
	 * @throws NotFoundException
	 */
	public static String find(String login) throws NotFoundException
	{
		aStudent = null;
		// define the SQL query statement using the phone number key
		String sqlQuery = "SELECT users.id, password, firstName, lastName, emailAddress, lastAccess, enrolDate, enabled, type, programCode, programDescription, year FROM users, students WHERE users.id = students.id AND users.id = ?"; //" + id;

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
			programCode = rs.getString("programCode");
			programDescription = rs.getString("programDescription");
			year = rs.getInt("year");
			
                    } else	// nothing was retrieved
                    {throw (new NotFoundException("Problem retrieving Student record, id number " + id +" does not exist in the system."));}
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
		throw (new DuplicateException("Problem with creating Student record, id number " + id +" already exists in the system."));
	}
}
