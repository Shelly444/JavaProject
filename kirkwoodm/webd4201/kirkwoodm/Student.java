/**
 * 
 */
package webd4201.kirkwoodm;

import java.sql.Connection;
import java.util.Date;
import java.util.Vector;

/**
 * @author Michelle Kirkwood
 *
 */
public class Student extends User{
	
	public final static String DEFAULT_PROGRAM_CODE = "UNDC";
	
	public final static String DEFAULT_PROGRAM_DESCRIPTION = "Undeclared";
	
	public final static int DEFAULT_YEAR = 1;
	
	private String programCode;
	private String programDescription;
	private int year;
	private Vector<Mark> marks = new Vector<>();
	private int gpa;
	
	/***
	 * 
	 * @param c
	 */
	public static void initialize(Connection c)
		{StudentDA.initialize(c);}
	/***
	 * 
	 * @param id
	 * @return
	 * @throws NotFoundException
	 */
	public static Student retrieve(long id) throws NotFoundException
		{return StudentDA.retrieve(id);}
	/*public static Vector<Student> retrieveAll()
		{return StudentDA.retrieveAll();}*/
	/***
	 * 
	 */
	public static void terminate()
		{StudentDA.terminate();}

// DA instance methods, you NEED to be a Customer object to do these *********************************
	/***
	 * 
	 */
	public boolean create() throws DuplicateException
		{return StudentDA.create(this);}
	/***
	 * 
	 */
	public int delete() throws NotFoundException
		{return StudentDA.delete(this);}
	/***
	 * 
	 */
	public int update() throws NotFoundException
		{return StudentDA.update(this);}
	/**
	 * @return the programCode
	 */
	public String getProgramCode() {
		return programCode;
	}
	/**
	 * @param programCode the programCode to set
	 */
	public void setProgramCode(String programCode) {
		this.programCode = programCode;
	}
	/**
	 * @return the programDescription
	 */
	public String getProgramDescription() {
		return programDescription;
	}
	/**
	 * @param programDescription the programDescription to set
	 */
	public void setProgramDescription(String programDescription) {
		this.programDescription = programDescription;
	}
	/**
	 * @return the year
	 */
	public int getYear() {
		return year;
	}
	/**
	 * @param year the year to set
	 */
	public void setYear(int year) {
		this.year = year;
	}
	/**
	 * @return the marks
	 */
	public Vector<Mark> getMarks() {
		return marks;
	}
	/**
	 * @param marks the marks to set
	 */
	public void setMarks(Vector<Mark> marks) {
		this.marks = marks;
	}
	/**
	 * 
	 */
	public Student() {
		this(DEFAULT_ID, DEFAULT_PASSWORD, DEFAULT_FIRST_NAME, 
				DEFAULT_LAST_NAME, DEFAULT_EMAIL_ADDRESS, 
						new Date(), new Date(), DEFAULT_ENABLED_STATUS, DEFAULT_TYPE, DEFAULT_PROGRAM_CODE, DEFAULT_PROGRAM_DESCRIPTION, DEFAULT_YEAR);

	}
	/**
	 * @param id
	 * @param password
	 * @param firstName
	 * @param lastName
	 * @param emailAddress
	 * @param lastAccess
	 * @param enrolDate
	 * @param enabled
	 * @param type
	 */
	public Student(long id, String password, String firstName, String lastName,
			String emailAddress, Date lastAccess, Date enrolDate,
			boolean enabled, String type, String programCode, String programDescription, int year, Vector<Mark> marks) {
		super(id, password, firstName, lastName, emailAddress, lastAccess, enrolDate,
				enabled, type);
		
		this.programCode = programCode;
		this.programDescription = programDescription;
		this.year = year;
		this.marks = marks;
		
	}
	/***
	 * 
	 * @param id
	 * @param password
	 * @param firstName
	 * @param lastName
	 * @param emailAddress
	 * @param lastAccess
	 * @param enrolDate
	 * @param enabled
	 * @param type
	 * @param programCode
	 * @param programDescription
	 * @param year
	 */
	public Student(long id, String password, String firstName, String lastName,
			String emailAddress, Date lastAccess, Date enrolDate,
			boolean enabled, String type,String programCode, String programDescription, int year){
		this.programCode = programCode;
		this.programDescription = programDescription;
		this.year = year;
		marks = new Vector<Mark>();
	}
	/***
	 * 
	 */
	@Override
    public String toString()
    {
		return "";
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
		return StudentDA.authenticate(id, password);
	}
	/***
	 * 
	 * @param login
	 * @return
	 * @throws NotFoundException
	 */
	public static Student find(String login) throws NotFoundException {
		
		StudentDA.find(login);
		return StudentDA.aStudent;
	}
	/***
	 * 
	 * @param login
	 * @return
	 * @throws DuplicateException
	 * @throws NotFoundException
	 */
	public static boolean isExistingLogin(String login) throws DuplicateException, NotFoundException {
		
		return StudentDA.isExistingLogin(login);
	}
	/***
	 * 
	 * @param id
	 * @return
	 */
	public int calculateGPA(long id)
	{
		
		return gpa;
	}

}
