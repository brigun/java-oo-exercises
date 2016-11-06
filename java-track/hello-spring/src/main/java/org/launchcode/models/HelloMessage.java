package org.launchcode.models;

public class HelloMessage
{

	public static String getMessage(String name, String language)
	{
		String greeting = "";
		switch(language)
		{
		case "Finnish":

			greeting = "Terve";
			break;
			
		case "Icelandic":
			
			greeting = "Hallo";
			break;
			
		case "Welsh":
			
			greeting = "Shwmae";
			break;
			
		default:
			
			greeting = "Hello";
			break;
		
		}
		return greeting + ", " + name + "!";
		
	}
}
