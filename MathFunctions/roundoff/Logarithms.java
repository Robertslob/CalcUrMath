package com.teamindecisive.calcurmath.roundoff;

public class Logarithms 
{
	// The natural logarithm
	public static double ln(double a)
	{
		return Math.log(a);
	}
	
	// The logarithm with base 10
	public static double log(double a)
	{
		return Math.log10(a);
	}
	
	// The base of the logarithm is the double a
	public static double baseLog(double a, double b)
	{
		// The log of b to base a is equivalent with (log10(b))/(log10(a))
		return log(b)/log(a);
	}
	
	// The function e^a
	public static double exponential(double a)
	{
		return Math.exp(a);
	}
	
	// Kan eventueel worden overgeslagen, weet ook niet wat de engelse naam hiervan is
	// The function 10^a
	public static double powerTen(double a)
	{
		return Math.pow(10, a);
	}
}
