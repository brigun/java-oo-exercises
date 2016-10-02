import java.util.ArrayList;
import java.util.Scanner;

public class RobotMenu 
{
	private ArrayList<Robot> robots;
	private Scanner s;
	
	public static void main(String[] args)
	{
		int x = 0;
		RobotMenu rm = new RobotMenu();
		do 
		{
			x = rm.startMenu();
			rm.processInput(x);
		}
		while (x != 6);
	}
	
	public RobotMenu()
	{
		s = new Scanner(System.in);
		robots = new ArrayList<Robot>();
	}
	
	public int startMenu()
	{
		System.out.println("Welcome to the GunterTech Virtual Robot Factory Menu!");
		System.out.println("What would you like to do today?");
		System.out.println("1. Create a robot");
		System.out.println("2. Display the list of available robots");
		System.out.println("3. Move a robot");
		System.out.println("4. Rotate a robot");
		System.out.println("5. Compute the distance between two robots");
		System.out.println("6. Exit");
		System.out.println("Please select an option:");
		
		int selection = getInput();
		while (selection < 1 || selection > 6)
			{
				System.out.println("Invalid Input, please select a menu option.");
				selection = getInput();
			}
		return selection;
	}
	
	public int getInput()
	{
		int a = 0;
		if (s.hasNextInt())
		{
			a = s.nextInt();
		}
		else
		{
			System.out.println("Please enter a number.");
			getInput();
		}
		return a;
		 
		
	}
	
	public void processInput(int selection)
	{
		if (selection == 1)
		{
			createRobot();
			
		}
		else if (selection == 2)
		{
			displayRobots();
		}
		else if (selection == 3)
		{
			displayRobots();
			
			Robot r = selectRobot();
			
			r.moveRobot();
			
			System.out.println("Moved robot " + r.getName() + " " + r.getSpeed() + " units " + r.getOrientationString() + ".");
		}
		else if (selection == 4)
		{
			displayRobots();
			
			Robot r = selectRobot();
			
			System.out.println("Which way would you like the robot to rotate?");
			System.out.println("1. Right");
			System.out.println("2. Left");
			System.out.println("Enter your choice:");
			
			int turn = getInput();
			if (turn != 1 && turn != 2)
			{
				System.out.println("Please pick either 1 for right, or 2 for left, please.");
				turn = getInput();
			}
			else if (turn == 1)
			{
				r.turnRight();
			}
			else
			{
				r.turnLeft();
			}
			
		}
		else if (selection == 5)
		{
			displayRobots();
			
			Robot r = selectRobot();
			
			System.out.println("Please select a second robot from the list");
			
			Robot s = selectRobot();
			
			System.out.println("The distance between " + r.getName() + " and " + s.getName() + " is " + r.getDistance(s) );
		}
	}
	
	private void displayRobots()
	{
		for (int i = 0; i < robots.size(); i++)
		{
			System.out.println((i+1) + ". " + robots.get(i));
		}
	}
	
	private Robot selectRobot()
	{
		System.out.println("Please select a robot from the list:");
		int selection = getInput();
		while (selection < 1 || selection > robots.size())
		{
			System.out.println("Invalid Input, please select a number from the list");
			selection = getInput();
		}
		return robots.get(selection - 1);
	}
	
	private void createRobot()
	{
		System.out.println("Please name your new robot:");
		String name = s.next();
		while (name == "")
		{
			System.out.println("Invalid Input, please name your shiny new robot.");
			name = s.next();
		}
		
		System.out.println("Enter the x-coordinate for robot creation:");
		int x = getInput();
		
		System.out.println("Enter the y-coordinate for robot creation:");
		int y = getInput();
		
		System.out.println("Please select a begining orientation:");
		System.out.println("1. East");
		System.out.println("2. South");
		System.out.println("3. West");
		System.out.println("4. North");
		int orientation = getInput();
		while (orientation < 1 || orientation > 4)
		{
			System.out.println("Please select an option from the list.");
			orientation = getInput();
		}
		orientation = (orientation - 1) * 90;
		
		System.out.println("Please enter the intial speed your robot will travel:");
		int speed = getInput();
		while (speed < 0)
		{
			System.out.println("Your robot is travelling backwards.");
			System.out.println("Please enter a positive integer.");
			speed = getInput();
		}
		while (speed > 1000)
		{
			System.out.println("That is quite fast for a robot.");
			System.out.println("Try something a bit slower:");
			speed = getInput();
		}
		robots.add(new Robot(name, x, y, orientation, speed));
		
	}
	
}
