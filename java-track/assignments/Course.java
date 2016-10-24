import java.util.ArrayList;
import java.util.Objects;

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
	
	
	@Override
	public String toString()
	{
		return "Course: " + this.getName() + ", Credits: " + this.getCredits(); 
	}
	
	public boolean addStudent(Student s)
	{
		if (this.getRemainingSeats() < 1)
			return false;
		
		Student[] r = this.getRoster();
		
		for (int i = 0; i < this.getRoster().length; i++)
		{
			if (r[i] != null && r.length > 0)
			{
				if (r[i].getName() == s.getName())
				{
					return false;
				}
			}
			else
			{
				int seats = this.getRemainingSeats() - 1;
				r[i] = s;
				this.setRemainingSeats(seats);
				return true;
			}
			
		}
		return false;
	}
	
	public String generateRoster()
	{
		String response = "";
		Student[] r = this.getRoster();
		if (r.length == 0)
		{
			response = "There are no students enrolled at this time.";
			return response;
		}
		for(int i = 0; i < r.length; i++)
		{
			if (r[i] != null && r.length > 0)
			{
				response = response + r[i].getName() + ", ";
			}
		}
		return response;
	}
	
	public double averageGPA()
	{
		double avg = 0.0;
		double gpaTotal = 0.0;
		int enrolled = 0;
		Student[] r = this.getRoster();
		for( int i = 0; i < r.length; i++)
		{
			if ( r[i] != null && r.length > 0)
			{
				gpaTotal = gpaTotal + r[i].getGPA();
				enrolled = enrolled + 1;
			}
			
		}
		avg = (double) gpaTotal / enrolled;
		return avg;
	}
	
	@Override
	public boolean equals(Object o)
	{
		//self check
		if(this == o)
			return true;
		
		//null check
		if (o == null)
			return false;
		
		//type check
		if (getClass() != o.getClass())
			return false;
		
		//cast to Course
		Course c = (Course)o;
		
		//compare fields
		return Objects.equals(this.getName(), c.getName()) && Objects.equals(this.getCredits(), c.getCredits());
	}
}