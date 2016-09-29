
public class BaseballPlayer 
{
	private String name;
	private int jerseyNum;
	private boolean hitsRight;
	private boolean hitsLeft;
	private int numHits;
	private int rBi;
	private int gamesPlayed;
	
	public String toString() 
	{
		return "BaseballPlayer [name=" + name + ", jerseyNum=" + jerseyNum + ", hitsRight=" + hitsRight + ", hitsLeft="
				+ hitsLeft + ", numHits=" + numHits + ", rBi=" + rBi + ", gamesPlayed=" + gamesPlayed + "]";
	}
	
	public BaseballPlayer(String name, int jerseyNum, boolean hitsRight, boolean hitsLeft)
	{
		this.name = name;
		this.jerseyNum = jerseyNum;
		this.hitsRight = hitsRight;
		this.hitsLeft = hitsLeft;
		this.numHits = 0;
		this.rBi = 0;
		this.gamesPlayed = 0;
	}

	public String getName() 
	{
		return name;
	}

	public void setName(String name) 
	{
		this.name = name;
	}

	public int getJerseyNum() 
	{
		return jerseyNum;
	}

	public void setJerseyNum(int jerseyNum) 
	{
		this.jerseyNum = jerseyNum;
	}

	public boolean isHitsRight() 
	{
		return hitsRight;
	}

	public void setHitsRight(boolean hitsRight) 
	{
		this.hitsRight = hitsRight;
	}

	public boolean isHitsLeft() 
	{
		return hitsLeft;
	}

	public void setHitsLeft(boolean hitsLeft) 
	{
		this.hitsLeft = hitsLeft;
	}

	public int getNumHits() 
	{
		return numHits;
	}

	public void setNumHits(int numHits) 
	{
		this.numHits = numHits;
	}

	public int getrBi() 
	{
		return rBi;
	}

	public void setrBi(int rBi) 
	{
		this.rBi = rBi;
	}

	public int getGamesPlayed() 
	{
		return gamesPlayed;
	}

	public void setGamesPlayed(int gamesPlayed) 
	{
		this.gamesPlayed = gamesPlayed;
	}
	
	
	
	
	
}
