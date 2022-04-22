package Q2;

public class Customer 
{
	private String name;
	private boolean  member=false;
	private String memberType;
	
	public Customer() {};
	
	public Customer(String name) 
	{
		this.name=name;
	}
	
	public String getName() 
	{
		return this.name;
	}
	
	public boolean isMember() 
	{
		return this.member;
	}
	
    public void SetMember(boolean member) 
    {
    	this.member=member;
    }
    
    public String getMemberType() 
    {
    	return this.memberType;
    }
    
    public void setMemberType(String memberType) 
    {
    	this.memberType=memberType;
    }
    
    public String toString()
    {
    	return "name "+this.getName()+" is member "+this.isMember()+" member type "+this.getMemberType();
    }
		
		

}
