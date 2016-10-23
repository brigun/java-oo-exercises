package javagram.filters;

import java.awt.Color;

import javagram.Picture;
import javagram.filters.Filter;

public class Posterize implements Filter {

	@Override
	public Picture process(Picture original) {
			Picture processed = new Picture(original.width(), original.height());
        
	    //get each pixel one by one
	    for (int i = 0; i < original.width(); i++) {
	      for (int j = 0; j < original.height(); j++) {
	    	  
	    	  Color c = original.get(i, j);
	          
	          //get color components from each pixel
	          int r = c.getRed();
	          int g = c.getGreen();
	          int b = c.getBlue();
	          
	          int newBlue = (int)(b / 64) * 64;
	          int newGreen = (int)(g / 64) * 64;
	          int newRed = (int)(r / 64) * 64;
	          
	          processed.set(i, j, new Color(newRed, newGreen, newBlue));
	    	  
	      }
	    }
		
		return processed;
	}

}
