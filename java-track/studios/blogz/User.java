package blogz;
import java.util.List;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class User extends Entity 
{
	private String username;
	private String passwordHash;
	private static List<User> members =  new ArrayList<User>();
	
	
	
	public User(String name, String password)
	{
		super();
		
		if (User.isValidUsername(name))
		{
			
			username = name;
			
			passwordHash = User.hashPassword(password);
			
			User.members.add(this);
		}
		else
		{
			System.out.println("Invalid Username, please try again.");
		}
	}
	
	private static String hashPassword(String password)
	{
		String hash = password;
		return hash;
	}
	
	public String getUsername()
	{
		return this.username;
	}
	
	public String getPasswordHash()
	{
		return this.passwordHash;
	}
	
	public boolean isValidPassword(String testWord)
	{
		return this.getPasswordHash() == User.hashPassword(testWord);
	}
	
	public static List<User> getMemberList()
	{
		return User.members;
	}
	
	private static boolean isValidUsername(String test)
	{
		Pattern p = Pattern.compile("[a-zA-Z][a-zA-Z0-9_-]{4,11}");
		Matcher m = p.matcher(test);
		boolean b = m.matches();
		
		return b;
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", passwordHash=" + passwordHash + "]";
	}

}
