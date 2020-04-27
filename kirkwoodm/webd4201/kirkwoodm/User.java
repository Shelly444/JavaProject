/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webd4201.kirkwoodm;

import java.security.MessageDigest;
import java.sql.Connection;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Vector;

/**
 *
 * @author Michelle Kirkwood
 */
public class User implements CollegeInterface{
    /***
     * 
     */
    public static final long DEFAULT_ID = 100123456L;
    
    public static final String DEFAULT_PASSWORD = "password";
    
    public static final String DEFAULT_LAST_NAME = "John";
    
    public static final String DEFAULT_FIRST_NAME = "Doe";
    
    public static final String DEFAULT_EMAIL_ADDRESS = "jone.doe@dcmail.ca";
    
    public static final boolean DEFAULT_ENABLED_STATUS = true;
    
    public static final String DEFAULT_TYPE = "s";
    
    public static final byte ID_NUMBER_LENGTH = 9;
    
    public static final DateFormat DF = DateFormat.getDateInstance(DateFormat.MEDIUM, Locale.CANADA);
    
    private long id;
    private String password;
    private String firstName;
    private String lastName;
    private String emailAddress;
    private Date lastAccess;
    private Date enrolDate;
    private boolean enabled;
    private String type;
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
     */
    public User(long id, String password, String firstName, String lastName, String emailAddress, Date lastAccess, Date enrolDate, boolean enabled, String type) {
        this.id = id;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAddress = emailAddress;
        this.lastAccess = lastAccess;
        this.enrolDate = enrolDate;
        this.enabled = enabled;
        this.type = type;
    }
    /***
     * 
     */
    public User()
    {
        this(DEFAULT_ID, DEFAULT_PASSWORD, DEFAULT_LAST_NAME, DEFAULT_FIRST_NAME, DEFAULT_EMAIL_ADDRESS, new Date(), new Date(), DEFAULT_ENABLED_STATUS, DEFAULT_TYPE);
    }
    /***
     * 
     * @param c
     */
    public static void initialize(Connection c)
	{UserDA.initialize(c);}
    /***
     * 
     * @param id
     * @return
     * @throws NotFoundException
     */
    public static User retrieve(long id) throws NotFoundException
	{return UserDA.retrieve(id);}
    /***
     * 
     * @return
     */
    public static Vector<User> retrieveAll()
	{return UserDA.retrieveAll();}
    /***
     * 
     */
    public static void terminate()
	{UserDA.terminate();}

//DA instance methods, you NEED to be a Customer object to do these *********************************
    /***
     * 
     * @return
     * @throws DuplicateException
     */
    public boolean create() throws DuplicateException
	{return UserDA.create(this);}
    /***
     * 
     * @return
     * @throws NotFoundException
     */
    public int delete() throws NotFoundException
	{return UserDA.delete(this);}
    /***
     * 
     * @return
     * @throws NotFoundException
     */
    public int update() throws NotFoundException
	{return UserDA.update(this);}
    
    //MessageDigest md = MessageDigest.getInstance("SHA1"); 
    //md.update(thingToBeHashed.getBytes()); 
    //byte[] bytesOfHashedString = md.digest();
    /***
     * 
     * @param bytes
     * @return
     */
    public static String decToHex(byte[] bytes)
    {
        String hex = "";
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < bytes.length ;i++)
        {
            System.out.println(bytes[i] + " as hex is " 
    				+ Integer.toHexString(bytes[i]));
    	System.out.println(bytes[i] + " as 2-digit hex is " 
    				+ String.format("%02x", bytes[i]));
    	sb.append(String.format("%02x", bytes[i]));
        }
        hex = sb.toString();
        return hex;
    }


    /***
     * 
     * @return
     */
    public long getId() {
        return id;
    }
    /***
     * 
     * @param id
     */
    public void setId(long id) {
        this.id = id;
    }
    /***
     * 
     * @return
     */
    public String getPassword() {
        return password;
    }
    /***
     * 
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }
    /***
     * 
     * @return
     */
    public String getFirstName() {
        return firstName;
    }
    /***
     * 
     * @param firstName
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    /***
     * 
     * @return
     */
    public String getLastName() {
        return lastName;
    }
    /***
     * 
     * @param lastName
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    /***
     * 
     * @return
     */
    public String getEmailAddress() {
        return emailAddress;
    }
    /***
     * 
     * @param emailAddress
     */
    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }
    /***
     * 
     * @return
     */
    public Date getLastAccess() {
        return lastAccess;
    }
    /***
     * 
     * @param lastAccess
     */
    public void setLastAccess(Date lastAccess) {
        this.lastAccess = lastAccess;
    }
    /***
     * 
     * @return
     */
    public Date getEnrolDate() {
        return enrolDate;
    }
    /***
     * 
     * @param enrolDate
     */
    public void setEnrolDate(Date enrolDate) {
        this.enrolDate = enrolDate;
    }
    /***
     * 
     * @return
     */
    public boolean isEnabled() {
        return enabled;
    }
    /***
     * 
     * @param enabled
     */
    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
    /***
     * 
     * @return
     */
    public String getType() {
        return type;
    }
    /***
     * 
     * @param type
     */
    public void setType(String type) {
        this.type = type;
    }
    @Override
    /***
     * 
     */
    public String toString()
    {
        String output = "User infor for: " + getId();
        output += "\n\tName: " + getFirstName() + getLastName();
        output += "\n\tCreated on: " + DF.format(getEnrolDate());
        output += "\n\tLast Access: " + DF.format(getLastAccess());
        
        return output;
    }
    /***
     * 
     */
    public void dump(){
        System.out.println(toString());
    }
    /***
     *     
     */
    public String getTypeForDisplay()
    {
        return "";
    }
    /***
     * 
     * @param id
     * @return
     */
    public static boolean verifyId(long id)
    {
    	if(id < ID_NUMBER_LENGTH && id > ID_NUMBER_LENGTH)
    	{
    		return false;
    	}
    	else
    	{
    		return true;
    	}
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
}
