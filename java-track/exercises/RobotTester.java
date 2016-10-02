import static org.junit.Assert.*;

import org.junit.Test;

public class RobotTester {

	@Test
	public void testMoveRobot() 
	{
		Robot r = new Robot("Test", 0, 0, 0, 5);
		assertTrue(r.getX() == 0);
		assertFalse(r.getX() == 5);
		assertTrue(r.getY() == 0);
		
		r.moveRobot();
		assertTrue("The x dimension of the move method isn't working properly", r.getX() == r.getSpeed());
		
		r.setOrientation(270);
		r.moveRobot();
		assertTrue("The y dimension of the move method isn't working properly", r.getY() == r.getSpeed());
		assertTrue(r.getX() == r.getSpeed());
		
		r.setOrientation(90);
		r.moveRobot();
		r.moveRobot();
		assertTrue(r.getY() == (0 - r.getSpeed()));
	}
	
	@Test
	public void testTurnLeft()
	{
		Robot r = new Robot("Tiny", 0, 0, 0, 5);
		assertTrue("Problem in constructor for Robot class", r.getOrientation() == 0);
		r.turnLeft();
		assertTrue("turnLeft method not working properly", r.getOrientation() == 270);
		r.turnLeft();
		assertTrue("Addition problems in turnLeft method", r.getOrientation() == 180);
		
	}
	
	@Test
	public void testTurnRight()
	{
		Robot r = new Robot("Wrongway", 0, 0, 0, 5);
		assertTrue("Problem in constructor for Robot class", r.getOrientation() == 0);
		r.turnRight();
		assertTrue("turnRight method has a problem", r.getOrientation() == 90);
		r.turnRight();
		r.turnRight();
		r.turnRight();
		assertTrue("turnRight method has a problem", r.getOrientation() == 0);
	}
	
	@Test
	public void testGetDistance()
	{
		Robot r = new Robot("Winnie", 0, 0, 0, 5);
		Robot s = new Robot("ThePooh", 3, 4, 180, 5);
		
		assertTrue("Problem in distance equation", r.getDistance(s) == 5);
		
		Robot t = new Robot ("Thurston", 0, 0, 0, 0);
		
		assertFalse("False assertion failed, problem with getDistance method", s.getDistance(t) == 6);
		assertTrue("Both robots in same spot, check maths in distance equation", r.getDistance(t) == 0);
	}
	
	@Test
	public void testGetOrientationString()
	{
		Robot r = new Robot("Robbie", 0, 0 ,0, 7);
		
		assertTrue("String output method failed", r.getOrientationString() == "East");
		
		r.setOrientation(270);
		assertTrue("String output selector not working properly", r.getOrientationString() == "North");
		
		r.setOrientation(360);
		assertTrue("String output selector not working properly", r.getOrientationString() == "East");
		
		r.setOrientation(0);
		assertTrue("String output selector not working properly", r.getOrientationString() == "East");
	}
 
}
