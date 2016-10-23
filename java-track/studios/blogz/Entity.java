package blogz;

public abstract class Entity {
	private static int allEntities;
	private int uid;
	
	public Entity()
	{
		allEntities = allEntities + 1;
		final int uid = allEntities;
	}
	
	public int getUid()
	{
		return this.uid;
	}
	
	private static int getAllEntities()
	{
		return Entity.allEntities;
	}
	

}
