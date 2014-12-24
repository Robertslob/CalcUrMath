package com.teamindecisive.calcurmath.function;

import org.matheclipse.core.basic.Config;
import org.matheclipse.core.eval.EvalUtilities;

// A string like the following should be given with "diff(sin(x)*cos(x),x)" or "integrate(sin(x)^5,x)"
// There will be a string returned like "-Sin(x)^2+Cos(x)^2" (note the capitals)
// For more details, see https://bitbucket.org/axelclk/symja_android_library/wiki/examples/Calculus
public class Calculus 
{	
	// The string must be written with lowerCases
	public static String lowerCase(String s)
	{
		EvalUtilities util = new EvalUtilities(true, false);
		return util.evaluate(s).toString();
	}
	/**
	// Hoe we dit implementeren is afhankelijk van Daan, kan nu nog niet heel veel mee
	// startwaarde a t/m b
	public static String summation(String s, int a, int b)
	{
		// declareer hier een waarde ding
		for (int n = a; n<=b; n++)
			c = n;
			// Waarde ding += Functiewaarde(s, n);
			// Kan hier nog niks doen zonder Daan
		// return waarde ding
	}
	**/
}
