package webd4201.kirkwoodm;
/**
 * Lab7ExampleTester - this file will implement the Student, StudentDatabaseConnect, StudentDA classes and
                illustrate exception handling.  If one follows through the code
                they will find everything they will need to create/modify for
                the latest WEDJ4203 assignment
 *              methods  
 * @author Darren Puffer
 * @version .0 (07 March 2015)
 * @since 1.0
 */

import java.util.Date;
import java.util.Vector;
import java.sql.Connection;
/***
 * 
 * @author michelle
 *
 */
public class Lab1ExampleTester
{
	static Student aStudent; //a Student object, when we are dealing with only one
                                    //at a time, it has been created outside of the
                                    //main() method, to take advantage of the
                                    //printDetails() method at the bottom
	/***
	 * 
	 * @param args
	 */
	public static void main(String args[])
  	{
      Vector<Student> customers;  //a Vector to hold all customers
      Connection c = null;
	  try{  
            // initialize the databases (i.e. connect)
            c = DatabaseConnect.initialize();
            Student.initialize(c);
            
            try // get a customer
            {
                    aStudent = Student.retrieve(1);
                    printDetails();
            }
            catch(NotFoundException e)
                    {	System.out.println(e);}

            try // try to get a non-existent customer
            {
                    aStudent = Student.retrieve(100222222);
                    printDetails();
            }
            catch(NotFoundException e)
                    {	System.out.println("Did not find " + Student.retrieve(100222222)+"\n");}

            // get all customers
            //customers = Student.retrieveAll();
            //for(int i = 0; i < customers.size(); i++)
            //{
                // get customer reference
                //aStudent = customers.get(i);
                //printDetails();
            //} 
            
            
            try
            {
                aStudent.create();
                System.out.println("Robert added\n");
            }
            catch(DuplicateException e)
            {	System.out.println(e);}

            try // now, find the new customer
            {
                    aStudent = Student.retrieve(100222222);
                    printDetails();
            }
            catch(NotFoundException e)
                    {	System.out.println("Did not find " + Student.retrieve(100222222) + "\n");}

            try // now, delete the new customer
            {
                    aStudent.delete();
                    System.out.println("Robert deleted\n");
            }
            catch(NotFoundException e)
                    {	System.out.println(e);}

            try // now, try to find the deleted customer
            {
                    aStudent = Student.retrieve(416643123);
                    printDetails();
            }
            catch(NotFoundException e)
            {	System.out.println("Did not find " + Student.retrieve(416643123) + "\n");}

            // change Eleanor's address to Miami

            try
            {
                    aStudent = Student.retrieve(234567890);
                    printDetails();
                    //change customer address
                    aStudent.setEmailAddress("Robert@gmail.com");
                    aStudent.update();
                    System.out.println("Robert updated\n");
            }
            catch (NotFoundException e)
                    {System.out.println(e);}

            try // now, try to find the Sue
            {
                aStudent = Student.retrieve(234567890);
                printDetails();
            }
            catch(NotFoundException e)
            {
                System.out.println("Sue not found");
            }
	  }catch(Exception e){
		  System.out.println(e.toString());
	  }finally{ // close the database resources, if possible            
          try{  Student.terminate(); }catch(Exception e){}
          try{  DatabaseConnect.terminate(); }catch(Exception e){}
	  }
	}
	//A method created just to limit the number of System.out.println() calls in the main() method above
	/***
	 * 
	 */
	private static void printDetails() {
		System.out.println(aStudent.toString()+ "\n");
	}
}
