
public class Course 
{
	private String name;
	private int credits;
	private int remainingSeats;
	private Student[] roster;
	
	public Course(String name, int credits, int seats)
	{
		this.name = name;
		this.credits = credits;
		remainingSeats = seats;
		roster = new Student[remainingSeats];
	}

	public String getName() 
	{
		return name;
	}

	public void setName(String name) 
	{
		this.name = name;
	}

	public int getCredits() {
		return credits;
	}

	public void setCredits(int credits) 
	{
		this.credits = credits;
	}

	public int getRemainingSeats() 
	{
		return remainingSeats;
	}

	public void setRemainingSeats(int remainingSeats) 
	{
		this.remainingSeats = remainingSeats;
	}

	public Student[] getRoster() 
	{
		return roster;
	}

	public void setRoster(Student[] roster) 
	{
		this.roster = roster;
	}
	
	
}
