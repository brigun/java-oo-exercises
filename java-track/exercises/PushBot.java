
public class PushBot extends Robot
{
	private int targetX;
	private int targetY;

	public PushBot(String name, int startX, int startY, int startOrientation, int startSpeed) 
	{
		super(name, startX, startY, startOrientation, startSpeed);
		this.targetX = 0;
		this.targetY = 0;
	}
	
	public void setTarget(int x, int y)
	{
		this.targetX = x;
		this.targetY = y;
	}
	
	public int getTarget()
	{
		int a = this.targetX;
		int b = this.targetY;
		return a & b;
	}
	

}
