package blogz;

public abstract class Entity {
	private static int allEntities;
	private final int uid;
	
	public Entity()
	{
		allEntities = allEntities + 1;
		uid = allEntities;
	}
	
	public int getUid()
	{
		return this.uid;
	}
	
	

}
