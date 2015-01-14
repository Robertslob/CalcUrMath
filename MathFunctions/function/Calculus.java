package com.teamindecisive.calcurmath.function;

import org.matheclipse.core.eval.EvalDouble;
import org.matheclipse.core.eval.EvalUtilities;

// A string like the following should be given with "diff(sin(x)*cos(x),x)" or "integrate(sin(x)^5,x)"
// Other expressions can be given aswell, like "1/2+1/3" which returns "5/6"
// There will be a string returned like "-Sin(x)^2+Cos(x)^2" (note the capitals)
// For more details, see https://bitbucket.org/axelclk/symja_android_library/wiki/examples/Calculus
public class Calculus 
{	
	// The string must be written with lowerCases
	public static String lowerCase(String s)
	{
		EvalUtilities util = new EvalUtilities(false, true);
		return util.evaluate(s).toString();
	}
	
	public static String doubleLowerCase(String s)
	{
		EvalDouble doubleUtil = new EvalDouble(true);
		return String.valueOf(doubleUtil.evaluate(s));		
	}
	// Get the value of an function s like "Sin(x)" for x=b
	// If the boolean is true, the answer is exact, otherwise its an approximation
	public static String getValue(String s, String b, boolean c)
	{
		if(c){
			EvalUtilities util = new EvalUtilities(false, true);
			util.evaluate("x=" + b);
			return String.valueOf(util.evaluate(s));
		}
		else{
			EvalDouble doubleUtil = new EvalDouble(true);
			doubleUtil.evaluate("x=" + b);
			return String.valueOf(doubleUtil.evaluate(s));			
		}
	}
	
	// A summation from a to b with function s
	// If the boolean is true, the answer is exact, otherwise its an approximation
	// example of s: "Sin(x)" 
	public static String summation(String s, int a, int b, boolean c)
	{
		String result = "";
		for (int n = a; n<=b; n++)
		{
			result += getValue(s, String.valueOf(n), c);
			if (!(b==n))
				result += "+";
		}
		if(c)
			return lowerCase(result);
		else return doubleLowerCase(result);
	}
}
