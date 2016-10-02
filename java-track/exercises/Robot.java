
public class Robot {
	
	private int x,y;
	private int orientation;
	private int speed;
	
	public Robot(int startX, int startY, int startOrientation, int startSpeed)
	{
		x = startX;
		y = startY;
		orientation = startOrientation;
		speed = startSpeed;
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
		if (orientation >= 360)
				orientation = 0;
		
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
}
