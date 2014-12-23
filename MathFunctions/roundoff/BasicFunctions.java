package com.teamindecisive.calcurmath.roundoff;


/*** The basic functions ***/
public class BasicFunctions 
{
	// Simple functions for a calculator
	
	public static double add(double a, double b)
	{
		return a+b;
	}
	
	// Kunnen onderstaande overslaan, maakt het a+ (-b), kijk maar wat handig is ivm vertalen.
	public static double minus(double a, double b)
	{
		return a-b;
	}
	
	public static double multiply(double a, double b)
	{
		return a*b;
	}
	
	public static double divide(double a, double b)
	{
		return a/b;
	}
	
	// This can be used to square as well
	public static double power(double a, double b)
	{
		return Math.pow(a, b);
	}
	
	// Can be done with power method as well
	public static double root(double a, double b)
	{
		return Math.pow(a, 1/b);
	}
}
