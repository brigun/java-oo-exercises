
public class Robot {
	
	private String name;
	private int x,y;
	private int orientation;
	private int speed;
	
	public Robot(String name, int startX, int startY, int startOrientation, int startSpeed)
	{
		this.name = name;
		x = startX;
		y = startY;
		orientation = startOrientation;
		speed = startSpeed;
	}
	
	public String getName()
	{
		return name;
	}
	
	public int getX()
	{
		return x;
	}
	
	public int getY()
	{
		return y;
	}
	
	public int getPosition()
	{
		int a = this.getX();
		int b = this.getY();
		return a & b;
	}
	public int getOrientation()
	{
		return orientation;
	}
	
	public int getSpeed()
	{
		return speed;
	}
	
	public void setName(String newName)
	{
		this.name = newName;
	}

	public void setX(int x)
	{
		this.x = x;
	}

	public void setY(int y)
    {
		this.y = y;
	}

	public void setOrientation(int orientation) 
	{
		this.orientation = orientation;
	}

	public void setSpeed(int speed) 
	{
		this.speed = speed;
	}
	
	public void moveRobot()
	{
		int	a = this.getOrientation();
		if (a == 0)
		{
			int newPosition = this.getX() + this.getSpeed();
			this.setX(newPosition);
		}
		else if( a == 90)
		{
			int newPosition = this.getY() - this.getSpeed();
			this.setY(newPosition);
		}
		else if (a == 180)
		{
			int newPosition = this.getX() - this.getSpeed();
			this.setX(newPosition);
		}
		else if ( a == 270)
		{
			int newPosition = this.getY() + this.getSpeed();
			this.setY(newPosition);
		}
	}
	
	public void turnLeft()
	{
		int a = this.getOrientation();
		
		int newFacing = a - 90;
		
		if (newFacing < 0)
			newFacing = 270;
		
		this.setOrientation(newFacing);
	}
	
	public void turnRight()
	{
		int a = this.getOrientation();
		
		int newFacing = a + 90;
		
		if (newFacing >= 360)
			newFacing = 0;
		
		this.setOrientation(newFacing);
	}
	
	public double getDistance(Robot robot2)
	{
		int x = robot2.getX() - this.getX();
		
		int y = robot2.getY() - this.getY();
		
		double diffX = Math.pow(x, 2.0);
		double diffY = Math.pow(y, 2.0);
		double distance = Math.sqrt(diffX + diffY);
		distance = Math.round(distance * 100)/100.0;
		
		return distance;
	}
	
	public String getOrientationString()
	{
		String word = "";
		
		if (this.getOrientation() == 0)
		{
			word = "East";
		}
		else if (this.getOrientation() == 90)
		{
			word = "South";
		}
		else if (this.getOrientation() == 180)
		{
			word = "West";
		}
		else
		{
			word = "North";
		}
				
		return word;
	}
	
	public String toString()
	{
		return "Name: " + this.name + " Position: " + this.getX() + ", " + this.getY() + " Speed: " + this.getSpeed() + " Orientation: " + this.getOrientationString();
	}
	
	public static void main(String[] args)
	{
		Robot a = new Robot("fred", 0,0, 0, 10);
		Robot b = new Robot("Audrey", 2,-3, 270, 5);
		
		System.out.println(a.toString());
		System.out.println(b.toString());
		
		a.moveRobot();
		a.turnLeft();
		a.moveRobot();
		
		System.out.println(a.toString());
		System.out.println(a.getDistance(b));
		
	}
}

