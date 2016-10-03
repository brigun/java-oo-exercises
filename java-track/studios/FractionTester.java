import static org.junit.Assert.*;

import org.junit.Test;

public class FractionTester {

	@Test
	public void testAddFraction()
	{
		Fraction f = new Fraction(2,3);
		Fraction g = new Fraction(1,5);
		Fraction e = f.addFraction(g);
		assertTrue("Check your factoring.",e.getNumerator() == 13 );
		assertTrue("Check your multiplication.", e.getDenominator() == 15);
	}
	
	@Test
	public void testMultiplyFraction()
	{
		Fraction f = new Fraction(4,5);
		Fraction g = new Fraction(6,7);
		Fraction e = f.multiplyFraction(g);
		assertTrue("Check your multiplication", e.getNumerator() == 24 );
		assertTrue("Check your multiplication", e.getDenominator()== 35);
	}
	
	@Test
	public void testTakeReciprocal()
	{
		Fraction f = new Fraction(34,43);
		Fraction a = f.takeReciprocal();
		
		assertTrue("Reciprocal not fuctioning properly.", f.getNumerator() == a.getDenominator());
		assertTrue("Reciprocal not fuctioning properly.", f.getDenominator() == a.getNumerator());
	}
	
	@Test
	public void testSimplify()
	{
		Fraction f = new Fraction(450, 1200);
		Fraction a = f.simplify();
		
		assertTrue("Simplification not simple enough.", a.getNumerator() == 3);
		assertTrue("Simplification not simple enough.", a.getDenominator() == 8);
	}
	
	@Test
	public void testFindGCF()
	{
		Fraction f = new Fraction(4,12);
		assertTrue("FindGCF not functioning properly.", f.findGCF(f) == 4);
		
		Fraction g = new Fraction(450, 1200);
		assertTrue("FindGCF not functioning properly.", g.findGCF(g) == 150);
	}

}
