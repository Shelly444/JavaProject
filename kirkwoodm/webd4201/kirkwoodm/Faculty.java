/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webd4201.kirkwoodm;

import java.util.Date;

/***
 *
 * @author Michelle Kirkwood
 */
public class Faculty extends User{
    
    public final String DEFAULT_SCHOOL_CODE = "SET";
    
    public final String DEFAULT_SCHOOL_DESCRIPTION = "School of Engineering & Technology";
    
    public final String DEFAULT_OFFICE = "H-140";
    
    public final int DEFAULT_PHONE_EXTENSION = 1234;
    
    private String schoolCode;
    private String schoolDescription;
    private String office;
    private int extension;
    
	/***
	 * 
	 */
	public Faculty() {
		super();
		this.schoolCode = DEFAULT_SCHOOL_CODE;
		this.schoolDescription = DEFAULT_SCHOOL_DESCRIPTION;
		this.office = DEFAULT_OFFICE;
		this.extension = DEFAULT_PHONE_EXTENSION;
	}
	/***
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
	public Faculty(long id, String password, String firstName, String lastName,
			String emailAddress, Date lastAccess, Date enrolDate,
			boolean enabled, String type, String schoolCode, String schoolDescription, String office, int extension) {
		super(id, password, firstName, lastName, emailAddress, lastAccess, enrolDate,
				enabled, type);
		this.schoolCode = schoolCode;
		this.schoolDescription = schoolDescription;
		this.office = office;
		this.extension = extension;
	}
	/***
	 * @return the schoolCode
	 */
	public String getSchoolCode() {
		return schoolCode;
	}
	/***
	 * @param schoolCode the schoolCode to set
	 */
	public void setSchoolCode(String schoolCode) {
		this.schoolCode = schoolCode;
	}
	/***
	 * @return the schoolDescription
	 */
	public String getSchoolDescription() {
		return schoolDescription;
	}
	/***
	 * @param schoolDescription the schoolDescription to set
	 */
	public void setSchoolDescription(String schoolDescription) {
		this.schoolDescription = schoolDescription;
	}
	/***
	 * @return the office
	 */
	public String getOffice() {
		return office;
	}
	/***
	 * @param office the office to set
	 */
	public void setOffice(String office) {
		this.office = office;
	}
	/***
	 * @return the extension
	 */
	public int getExtension() {
		return extension;
	}
	/***
	 * @param extension the extension to set
	 */
	public void setExtension(int extension) {
		this.extension = extension;
	}
	/***
	 * 
	 */
	public String getTypeForDisplay()
    {
        return "Faculty";
    }
	/***
	 * 
	 */
	@Override
    public String toString()
    {
        String output = "User infor for: " + getId();
        output += "\n\tName: " + getFirstName() + getLastName();
        output += "\n\tCreated on: " + DF.format(getEnrolDate());
        output += "\n\tLast Access: " + DF.format(getLastAccess());
        
        return output;
    }
    
    
}
