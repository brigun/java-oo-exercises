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
		String relPath = "";
		Picture picture = null;
		Scanner in = new Scanner(System.in);
		
		// prompt user for image to filter and validate input
		do {
			
			String imagePath = "path not set";
			
			// try to open the file
			try {
				
				System.out.println("Image path (relative to " + dir + "):");
				relPath = in.next();
				/*
				String[] relPathParts = relPath.split(File.separator);
				imagePath = dir + File.separator + String.join(File.separator, Arrays.asList(relPathParts));
				*/
				imagePath= (dir + "\\" + relPath );
						
				picture = new Picture(imagePath);
				
			} catch (RuntimeException e) {
				System.out.println("Could not open image: " + imagePath);
			}
			
		} while(picture == null);
		
		// TODO - prompt user for filter and validate input
		int pick = 0;
		do
		{
		pick = displayFilterMenu();
		}while (pick < 1 && pick > 7);
		
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
		if (fileName.equals(relPath))
		{
			System.out.println("Overwrite original file? y OR n");
			String confirm = in.next();
			if(confirm.equals("n"))
			{
				System.out.println("Save image to (relative to " + dir + ") (type 'exit' to quit w/o saving):");
				fileName = in.next();
			}
		}
		
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
		Filter selection = null;
		switch (choice)
		{
			case 1: selection = new Posterize();
				break;
			
			case 2: selection = new Greyscale();
				break;	
			
			case 3: selection = new Inverse();
				break;
			
			case 4: selection = new LowRes();
				break;
			
			case 5: selection = new BlueFilter();
				break;
				
			case 6: selection = new GreenFilter();
				break;
				
			case 7: selection = new RedFilter();
				break;
				
			
			
		}
		return selection;
		
		
	}
	
	private static int displayFilterMenu()
	{
		int pick = 0;
		System.out.println("Please select a filter:");
		System.out.println();
		System.out.println("1 - Posterize");
		System.out.println("2 - Greyscale");
		System.out.println("3 - Inverse");
		System.out.println("4 - LowRes(not implemented yet, do not choose");
		System.out.println("5 - BlueFilter");
		System.out.println("6 - GreenFilter");
		System.out.println("7 - RedFilter");
		pick = getInput();
			
		return pick;
	}
	
	public static int getInput()
	{
		Scanner in = new Scanner(System.in);
		boolean loop = false;
		int a = 0;
		do
		{
		while (!in.hasNextInt())
		{
			System.out.println("Please enter a number from the list");
			in.nextLine();
		}
		a = in.nextInt();
		if (a < 1 || a > 7)
			{
			
				System.out.println("Please select a choice from the list.");
				in.nextLine();
				loop = true;
			}
		else{
			return a;
		}
		}while(loop = true);
		return a;
		}
	}

	

