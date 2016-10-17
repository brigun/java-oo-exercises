public class Student 
{
	private String firstName;
	private String lastName;
	private int studentID;
	private double GPA;
	private int credits;
	private String classStanding;
	
	public Student(String first, String last, int ID)
	{
		firstName = first;
		lastName = last;
		studentID = ID;
		GPA = 0.0;
		credits = 0;
		classStanding = "Freshman";
	}

	public double getGPA() 
	{
		return GPA;
	}

	public void setGPA(double GPA) 
	{
		this.GPA = GPA;
	}

	public int getCredits() 
	{
		return credits;
	}

	public void setCredits(int credits) 
	{
		this.credits = credits;
	}

	public String getFirstName() 
	{
		return firstName;
	}

	public String getLastName() 
	{
		return lastName;
	}

	public int getStudentID() 
	{
		return studentID;
	}
	
	public String getName()
	{
		return this.getFirstName() + " " + this.getLastName();
	}
	
	
	
	@Override
	public String toString()
	{
		return "Student: " + this.getFirstName() + " " + this.getLastName() + ", Student ID: " + this.getStudentID();
	}
	
	public String getClassStanding()
	{
		String cs = "";
		int s = this.getCredits();
		if (s < 30)
		{
			cs =  "Freshman";
		}
		else if (s > 29 && s < 60)
		{
			cs = "Sophomore";
		}
		else if (s > 59 && s < 90)
		{
			cs = "Junior";
		}
		else if (s > 89)
		{
			cs = "Senior";
		}
		
		return cs;
	}
	
	public void submitGrade(double grade, int credits)
	{
		
		double g = grade;
		int c = credits;
		int currentCredits = this.getCredits();
		double currentGPA = this.getGPA();
		
		double qs = g * c;
		double oldQs = currentGPA * currentCredits;
		double GPA = (qs + oldQs) / (double)(currentCredits + credits);
		
		//round GPA to three decimals
		double roundedGPA = (Math.round(GPA * 1000)/ 1000.0);
		
		//set new GPA
		this.setGPA(roundedGPA);
		
		//set new total credits
		this.setCredits(currentCredits + credits);
		
	}
	
	public double computeTuition()
	{
		double tuition = 0.0;
		int c = this.getCredits();
		double tuitionPerCredit = 1333.33;
		while (c >= 15)
		{
			c = c - 15;
			tuition += 20000.00;
		}
		tuition += Math.round(c * tuitionPerCredit * 100)/ 100.00;
		return tuition;
	}
	
	public static Student createLegacy(Student first, Student second)
	{
		Student legacy = new Student(first.getName(), second.getName(), first.getStudentID() + second.getStudentID());
		int legacyCredit = 0;
		legacy.setGPA((first.getGPA() + second.getGPA())/2.0);
		if (first.getCredits() > second.getCredits())
		{
			legacyCredit = first.getCredits();
		}
		else
		{
			legacyCredit = second.getCredits();
		}
		legacy.setCredits(legacyCredit);
		return legacy;
	}
	
}