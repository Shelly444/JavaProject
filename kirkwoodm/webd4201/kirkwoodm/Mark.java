/**
 * 
 */
package webd4201.kirkwoodm;

/***
 * @author michelle
 *
 */
public class Mark {

	public final double MINIMUM_GPA = 0.0;
	
	public final double MAXIMUM_GPA = 5.0;
	
	public final double GPA = 0.0;
	
	private String courseCode = "";
	private String courseName = "";
	private int result = 0;
	private float gpaWeighting = 0;
	/***
	 * @return the courseCode
	 */
	public String getCourseCode() {
		return courseCode;
	}
	/***
	 * @param courseCode the courseCode to set
	 */
	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}
	/***
	 * @return the courseName
	 */
	public String getCourseName() {
		return courseName;
	}
	/***
	 * @param courseName the courseName to set
	 */
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	/***
	 * @return the result
	 */
	public int getResult() {
		return result;
	}
	/***
	 * @param result the result to set
	 */
	public void setResult(int result) {
		this.result = result;
	}
	/***
	 * @return the gpaWeighting
	 */
	public float getGpaWeighting() {
		return gpaWeighting;
	}
	/***
	 * @param gpaWeighting the gpaWeighting to set
	 */
	public void setGpaWeighting(float gpaWeighting) {
		this.gpaWeighting = gpaWeighting;
	}
	/***
	 * @param courseCode
	 * @param courseName
	 * @param result
	 * @param gpaWeighting
	 */
	public Mark(String courseCode, String courseName, int result,
			float gpaWeighting) {
		this.courseCode = courseCode;
		this.courseName = courseName;
		this.result = result;
		this.gpaWeighting = gpaWeighting;
	}
	/***
	 * 
	 */
	public String toString()
	{
		return "";
	}
	
}
