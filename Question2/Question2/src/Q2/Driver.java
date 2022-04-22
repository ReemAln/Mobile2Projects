package Q2;

import java.util.*;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.*;

public class Driver {

	public static void main(String[] args) throws ParseException {
		// define vairables
		Scanner input = new Scanner(System.in);
		String name="";
		String memberType="";
		Date date;
		int numberOfProducts, numberOfServices;
		double priceOfProduct, priceOfService;

		//String date;
		Customer cus = new Customer(name);
		
		//user input
		System.out.println("Enter the name ");
		name = input.nextLine();
		System.out.println("Are you a member ? if yes(Y) , no (N)");
		String isMem = input.nextLine();
		
		// if the customer is member enter your type
		if (isMem.equals("y") || (isMem.equals("Y"))) {
			cus.SetMember(true);
			System.out.println("Please select the member type: \n (1)for Premium,\n (2)for Gold,\n (3)for Silver");
			int selectType = input.nextInt();
			switch (selectType) {
			case 1:
				memberType = "Premium";
				break;
			case 2:
				memberType = "Gold";
				break;
			case 3:
				memberType = "Silver";
				break;

			default:
				
				break;
			}
			cus.setMemberType(memberType);
		}
		else if (isMem.equals("N") || (isMem.equals("n")))
		{
			cus.SetMember(false);
			memberType = "Not a Member!!";
		}
		
		cus.setMemberType(memberType);
		/*
		 * // define object from Customer class 
		 */
		// ask user to enter the visit date
		// System.out.println("Enter the visit date ");
		// date=input.nextLine();
		// Date data=new SimpleDateFormat("dd/MM/yyyy").parse(date);
		Date data = new Date();
		// ask user to enter the number of services
		System.out.println("Enter the number of services ");
		numberOfServices = input.nextInt();

		// ask user to enter the number of products
		System.out.println("Enter the number of products ");
		numberOfProducts = input.nextInt();

		// ask user to enter the price of one service
		//I suppose  the price is same for all service 
		System.out.println("Enter the price of service ");
		priceOfService = input.nextDouble();

		// ask user to enter the price of one products
		//I suppose  the price is same for all products 
		System.out.println("Enter the price of product ");
		priceOfProduct = input.nextDouble();
		

		System.out.println("Enter the date: ");
		String date1 = input.next();
		  try {
	            SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
	            date=sdf.parse(date1);
	            }
	        catch(Exception e)
	        {
	            System.out.println("The exception is "+e);
	        }
		
		
		// ---------------------------
		// calculate the total expenses
		Visit customerVisit = new Visit(name, data);
		customerVisit.setServiceExpense(priceOfService);
		customerVisit.setProductExpense(priceOfProduct);
		
		// customerVisit.set
		System.out.println("Customer Name: " + customerVisit.getName());
		System.out.println("Is A Member : " + cus.isMember());
		System.out.println("Member Type : " + cus.getMemberType());
		
		System.out.println("Service Expense: " + customerVisit.getServiceExpense());
		System.out.println("Product Expense: " + customerVisit.getProductExpensive());
		//System.out.println("Total Expensive: " + customerVisit.getTotalExpensive());
		String line=customerVisit.toString();
		System.out.println(line);
		if(cus.isMember())
		{
			System.out.println("Service Discount Rate: "+DiscountRate.getServiceDiscountRate(memberType));
			System.out.println("Product Discount Rate: "+DiscountRate.getProductDiscountRate(memberType));
			System.out.println("Service Expense  discount: "+DiscountRate.getServiceDiscountRate(memberType)*customerVisit.getServiceExpense());
			System.out.println("Product Expense  discount: "+DiscountRate.getProductDiscountRate(memberType)*customerVisit.getProductExpensive());
			
		}
		
		

	}

}
