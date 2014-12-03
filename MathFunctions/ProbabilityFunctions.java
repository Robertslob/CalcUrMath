package com.teamindecisive.calcurmath;

public class ProbabilityFunctions 
{
	public static int factorial(int a)
	{
		int b = 1;
		for(int n = a; n > 0; n--)
			b*=n;
		return b;
	}
}
