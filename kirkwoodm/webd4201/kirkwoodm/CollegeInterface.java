/**
* @author Michelle Kirkwood
* @version 1.0 (2019/1/11)
* @since 1.0
*/
package webd4201.kirkwoodm;

public interface CollegeInterface {
    /***
     * The name of the educational institute
     */
    public static final String COLLEGE_NAME = "Durham College";
    
    public static final String PHONE_NUMBER = "(905)721-2000";
    
    public static final long MINIMUM_ID_NUMBER =  100000000L;
    
    public static final long MAXIMUM_ID_NUMBER =  999999999L;
    /***
     * 
     * @return 
     */
    public String getTypeForDisplay();
    
}
