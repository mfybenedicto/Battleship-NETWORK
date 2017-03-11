public class Account
{
	private String accName;
	private String password;
	// attribute for the profile pic
	
	public Account(String name, String pword)
	{
		username = name;
		password = pword;
	}
	
	public void setAccName(String name)
	{
		accName = name;
	}
	
	public String getAccName()
	{
		return accName;
	}
	
	public void setPassword(String pword)
	{
		password = pword;
	}
	
	public String getPassword()
	{
		return password;
	}
	
	public void setProfPic()
	{
		//sets the profile pic
	}
}