import static org.junit.Assert.*;

import org.junit.Test;

public class RectangleTester {

	@Test
	public void testGetArea() 
	{
		Rectangle r = new Rectangle(4, 5);
		assertTrue("The multiplication didn't work properly.",r.getArea() == 20);
	}
	
	@Test
	public void testGetPerimeter()
	{
		Rectangle r = new Rectangle(4, 5);
		assertTrue("Check your maths.", r.getPerimeter()== 18);
	}
	
	@Test
	public void testIsSquare()
	{
		Rectangle r = new Rectangle(4, 5);
		assertFalse("Square detection not functioning properly.", r.isSquare());
	}
	
	@Test
	public void testIsSmaller()
	{
		Rectangle r = new Rectangle(4, 5);
		Rectangle q = new Rectangle(4, 3);
		assertFalse("Size detection is not functioning properly.", r.isSmaller(q));
		assertTrue("Size detection is not functioning properly.", q.isSmaller(r));
	}

}
