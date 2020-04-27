/**
 * 
 */
package demo;

import java.sql.Connection;
import java.util.Vector;

/**
 * @author 100184325
 *
 */
public class Lab8Tester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		  
		Connection c = null;
		try{  
	        // initialize the databases (i.e. connect)
	        c = CustomerConnect.initialize();
	        Customer.initialize(c);
	        Customer aCustomer;
	        try // get a customer
	        {
	                aCustomer = Customer.find("123-4567");
	                System.out.println(aCustomer.toString());
	        }
	        catch(NotFoundException e)
	                {	System.out.println(e);}
		  }catch(Exception e)
		  {
			  System.out.println(e);
		  }

	}

}
