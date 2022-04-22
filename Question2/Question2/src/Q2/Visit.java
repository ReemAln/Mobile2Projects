package Q2;
import java.util.Date;
public class Visit
{

		private Customer customer;
		private Date date;
		private double serviceExpense;
		private double productExpensive;

		public Visit(String name,Date theDate) 
		{
		this.customer= new Customer(name);
		// this.getName();
		 this.date=theDate;		
		}

		public String getName() {
		return customer.getName();
		}
		public double getServiceExpense() {
		return this.serviceExpense;
		}
		public void setServiceExpense(double serviceExpense) {
		this.serviceExpense = serviceExpense;
		}

		public double getProductExpensive() {
			return this.productExpensive;
		}
		public void setProductExpense(double productExpensive) {
		this.productExpensive = productExpensive;
		}
		//getTotalExpensive
		public double getTotalExpensive() {
		return this.getProductExpensive()+this.getServiceExpense();
		}

		public String toString(){
		return customer.toString()+"\n"+", date of vist: "+this.date+" Service Expense "+this.getServiceExpense()
		       +" Product Expenses = "+this.getProductExpensive() +" Total = "+this.getTotalExpensive();
		}
		
	
	
	
	
}
