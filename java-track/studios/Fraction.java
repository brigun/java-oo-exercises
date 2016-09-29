
public class Fraction 
{
	private int numerator;
	private int denominator;
	
	public String toString() 
	{
		return "Fraction [numerator=" + numerator + ", denominator=" + denominator + "]";
	}

	public Fraction(int numerator, int denominator)
	{
		this.numerator = numerator;
		this.denominator = denominator;
	}

	public int getNumerator() 
	{
		return numerator;
	}

	public void setNumerator(int numerator) 
	{
		this.numerator = numerator;
	}

	public int getDenominator() 
	{
		return denominator;
	}

	public void setDenominator(int denominator) 
	{
		this.denominator = denominator;
	}
	
	public Fraction addFraction(Fraction toSum)
	{
		int top = (this.getNumerator() * toSum.getDenominator()) + (toSum.getNumerator() * toSum.getDenominator());
		int bottom = this.getDenominator() * toSum.getDenominator();
		
		Fraction summation = new Fraction(top, bottom);
		
		return summation;
		
	}
	
	public Fraction multiplyFraction(Fraction factor)
	{
		int top = this.getNumerator() * factor.getNumerator();
		int bottom = this.getDenominator() * factor.getDenominator();
		
		Fraction product = new Fraction(top, bottom);
		
		return product;
	}
	
	public Fraction takeReciprocal()
	{
		Fraction flipped = new Fraction(this.getDenominator(), this.getNumerator());
		
		return flipped;
	}
	
	public Fraction simplify()
	{
		int factor = this.findGCF(this);
		Fraction output = new Fraction(this.numerator / factor, this.denominator / factor);
		return output;
	}
	
	public int findGCF(Fraction target)
	{
		int gcf = 0;
		for (int i = 2; i < target.numerator * target.denominator; i++)
		{
			if (target.numerator % i == 0 && target.denominator % i == 0)
			{
				gcf = i;
			}
		}
		
		return gcf;
	
	}
	
	public static void main(String[] args)
	{
		Fraction first = new Fraction(25, 100);
		System.out.println(first);
		System.out.println(first.takeReciprocal());
		
		Fraction second = new Fraction (40, 50);
		Fraction third = first.addFraction(second);
		System.out.println(third);
		
		Fraction a = third.simplify();
		System.out.println(a);
	}

	
	}


