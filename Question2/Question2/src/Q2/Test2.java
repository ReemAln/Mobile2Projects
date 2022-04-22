package Q2;
import java.util.Date;
import java.text.SimpleDateFormat;
import static org.junit.Assert.*;

import org.junit.Test;

public class Test2 {
	public Date convertDate()
    {
        String testDate="2022/04/21";
        Date date=null;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
            date=sdf.parse(testDate);
            }
        catch(Exception e)
        {
            System.out.println("The exception is "+e);
        }
        return date;
    }
	Customer cu = new Customer("reem");
	Visit v = new Visit("reem",convertDate());
	
	@Test
	public void test() {
		
		cu.SetMember(false);
		
		String result="name reem is member false member type null\n, date of vist: Thu Apr 21 22:58:04 EDT 2022 Service Expense 0.0 Product Expenses = 0.0 Total = 0.0\n"
				;
		String out =v.toString();
		assertEquals(result,out);
		
		/*return customer.toString()+"\n"+", date of vist: "+this.date+" Service Expense "+this.getServiceExpense()
		       +" Product Expenses = "+this.getProductExpensive() +" Total = "+this.getTotalExpensive();
		}
		
		public String toString()
    {
    	return "name "+this.getName()+" is member "+this.isMember()+" member type "+this.getMemberType();
    }
		*/
			}

}
