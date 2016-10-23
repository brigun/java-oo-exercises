package javagram;

import javagram.filters.*;

import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class Javagram {

	public static void main(String[] args) {

		// Create the base path for images		
		String[] baseParts = {System.getProperty("user.dir"), "images"};
		String dir = String.join(File.separator, baseParts);
		String relPath;
		Picture picture = null;
		Scanner in = new Scanner(System.in);
		
		// prompt user for image to filter and validate input
		do {
			
			String imagePath = "path not set";
			
			// try to open the file
			try {
				
				System.out.println("Image path (relative to " + dir + "):");
				relPath = in.next();
				
				String[] relPathParts = relPath.split(File.separator);
				imagePath = dir + File.separator + String.join(File.separator, Arrays.asList(relPathParts));
				
				picture = new Picture(imagePath);
				
			} catch (RuntimeException e) {
				System.out.println("Could not open image: " + imagePath);
			}
			
		} while(picture == null);
		
		// TODO - prompt user for filter and validate input
		int pick = displayFilterMenu();
		
		
		// TODO - pass filter ID int to getFilter, and get an instance of Filter back 
		Filter filter = getFilter(pick);			

		// filter and display image
		Picture processed = filter.process(picture);
		processed.show();
		
		System.out.println("Image successfully filtered");
		
		// save image, if desired
		
		System.out.println("Save image to (relative to " + dir + ") (type 'exit' to quit w/o saving):");
		String fileName = in.next();
		
		// TODO - if the user enters the same file name as the input file, confirm that they want to overwrite the original
		
		if (fileName.equals("exit")) {
			System.out.println("Image not saved");
		} else {
			String absFileName = dir + File.separator + fileName;
			processed.save(absFileName);
			System.out.println("Image saved to " + absFileName);
		}	
		
		// close input scanner
		in.close();
	}
	
	// TODO - refactor this method to accept an int parameter, and return an instance of the Filter interface
	// TODO - refactor this method to thrown an exception if the int doesn't correspond to a filter
	private static Filter getFilter(int choice) 
	{
		// TODO - create some more filters, and add logic to return the appropriate one
		
		switch (choice)
		{
			case 1: Filter f = new Posterize();
				break;
			
			case 2: Filter f = new Greyscale();
				break;	
			
			case 3: Filter f = new Inverse();
				break;
			
			case 4: Filter f = new LowRes();
				break;
			
			case 5: Filter f = new BlueFilter();
				break;
				
			case 6: Filter f = new GreenFilter();
				break;
				
			case 7: Filter f = new RedFilter();
				break;
				
			default: System.out.println("Invalid choice selected, please select from the list.");
		}
		return f;
		
		
	}
	
	private static int displayFilterMenu()
	{
		int pick = 0;
		System.out.println("Please select a filter:");
		System.out.println();
		System.out.println("1 - Posterize");
		System.out.println("2 - Greyscale");
		System.out.println("3 - Inverse");
		System.out.println("4 - LowRes");
		System.out.println("5 - BlueFilter");
		System.out.println("6 - RedFilter");
		
		pick = getInput();
			
		return pick;
	}
	
	public static int getInput()
	{
		Scanner in = new Scanner(System.in);
		try
		{
			boolean b = in.hasNextInt();
		}
		catch(IllegalArgumentException e)
		{
			System.out.println("Please try to enter a number from the list provided.");
			getInput();
		}
	
		int a = 0;
		
		if (in.hasNextInt())
		{
			a = in.nextInt();
		}
		else
		{
			System.out.println("Please enter a number.");
			getInput();
		}
		in.close();
		return a;
	}

}