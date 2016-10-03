
public class Rectangle 
{
	private double length;
	private double width;
	
	public String toString() 
	{
		return "Rectangle [length=" + length + ", width=" + width + "]";
	}

	public Rectangle (double length, double width)
	{
		this.length = length;
		this.width = width;
	}

	public double getLength() 
	{
		return length;
	}

	public void setLength(double length) 
	{
		this.length = length;
	}

	public double getWidth() 
	{
		return width;
	}

	public void setWidth(double width)
	{
		this.width = width;
	}
	
	public double getArea()
	{
		return this.length * this.width;
	}
	
	public double getPerimeter()
	{
		return (this.length * 2) + (this.width * 2);
	}
	
	public boolean isSquare()
	{
		if (this.length == this.width)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public boolean isSmaller(Rectangle secondRect)
	{
		if (this.getArea()< secondRect.getArea())
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	public static void main(String[] args)
	{
		Rectangle first = new Rectangle(4,6);
		Rectangle second = new Rectangle(2.5, 3.5);
		
		System.out.println("The area is: " + first.getArea());
		System.out.println("The first rectangle is smaller: " + first.isSmaller(second));
	}
}
