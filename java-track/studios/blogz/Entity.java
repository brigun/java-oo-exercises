package blogz;

import java.util.Objects;

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
		
		//cast to Entity
		Entity e = (Entity)o;
		
		//compare uid
		return Objects.equals(this.getUid(), e.getUid());
	}
	
	

}
