
public class MagnaBot extends Robot 
{

	protected boolean magOn;
	
	public MagnaBot(String name, int startX, int startY, int startOrientation, int startSpeed, boolean magOn)
	{
		super(name, startX, startY, startOrientation, startSpeed);
		this.magOn = magOn;
		
	}
	
	public boolean getMagOn()
	{
		return this.magOn;
	}
	
	public void toggleMagOn()
	{
		this.magOn = !magOn;
	}
	
	public void tractorRobot(Robot r)
	{
		if (this.getDistance(r) < 4)
		{
			if (this.magOn)
			{
				r.setSpeed(this.speed);
				r.setOrientation(this.orientation);
			}
			else
			{
				this.toggleMagOn();
			}
		}
		
	}

}
