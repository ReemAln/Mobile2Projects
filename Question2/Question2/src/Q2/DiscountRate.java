package Q2;

public class DiscountRate 
{
	   
	    //enum membership {Premium,Gold,Silver};
		private static double serviceDiscountPremium=0.2;
		private static double serviceDiscountGold=0.15;
		private static double serviceDiscountSilver=0.1;
		private static double productDiscountPrimium =0.1;
		private static double productDiscountGold =0.1;
		private static double productDiscountSilver=0.1;

		public static double getServiceDiscountRate(String member) 
		{
			if (member.equalsIgnoreCase("Premium")) 
			{
				return serviceDiscountPremium;
			}
			
			else if(member.equalsIgnoreCase("Gold")) 
			{
				return serviceDiscountGold;
			}
			
			else if(member.equalsIgnoreCase("Silver")) 
			{
				return serviceDiscountSilver;
			}
			
			else return 0.0;
		}
		
		

		public static double getProductDiscountRate(String productMember) 
		{
			if (productMember.equalsIgnoreCase("Premium")) 
			{
				return  productDiscountPrimium;
			}
			else if (productMember.equalsIgnoreCase("Gold"))
			{
				return productDiscountGold;
			}
			
			else if (productMember.equalsIgnoreCase("Silver")) 
			{
				return productDiscountSilver;
			}
			
			else {return 0.0;}
			
		}
	

		
}

