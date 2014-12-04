package com.teamindecisive.calcurmath;

public class ProbabilityFunctions 
{
	public static long factorial(int a)
	{
		long b = 1;
		for(int n = 1; n <= a; n++)
			b*=n;
		return b;
	}
	
	// nPr method
	public static long permutations(int a, int b)
	{
		// The formula is: a!/(a-b)!
		// Which equals the following for-loop
		long c = 1;
		for(int n = a; n>(a-b); n--)
			c*=n;
		return c;
	}	
		
	// nCr method
	public static long combinations(int a, int b)
	{
		// The formula is: a!/(b!*(a-b)!))
		long r = factorial(b);
		return permutations(a,b)/r;
	}	
}
