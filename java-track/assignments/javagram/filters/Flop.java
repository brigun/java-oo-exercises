package javagram.filters;

import java.awt.Color;

import javagram.Picture;

public class Flop implements Filter {

	@Override
	public Picture process(Picture original) {
		Picture processed = new Picture(original.width(), original.height());
        
	    //get each pixel one by one
	    for (int i = 0; i < original.width(); i++) {
	      for (int j = 0; j < original.height(); j++) {
	    	  
	          int otherI = original.width() - 1 - i;  //take pixels from the right side 
				Color c = original.get(otherI, j);    // and set their color to pixel  
				processed.set(i, j, c);               // on the left side  
	      }
	    }
		return processed;
	}

}
