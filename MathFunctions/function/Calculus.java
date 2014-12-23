package com.teamindecisive.calcurmath.function;

import org.matheclipse.core.basic.Config;
import org.matheclipse.core.eval.EvalUtilities;

// A string like the following should be given with "diff(sin(x)*cos(x),x)" or "integrate(sin(x)^5,x)"
// There will be a string returned like "-Sin(x)^2+Cos(x)^2" (note the capitals)
// For more details, see https://bitbucket.org/axelclk/symja_android_library/wiki/examples/Calculus
public class Calculus 
{	
	String s;
	
	Calculus(String operateFunction)
	{
		s = operateFunction;
	}
	
	// The string must be written with lowerCases
	public String lowerCase()
	{
		Config.PARSER_USE_LOWERCASE_SYMBOLS = true;
		
		EvalUtilities util = new EvalUtilities(true, false);
		return util.evaluate(s).toString();
	}
	
	// The string must be written with upperCases
	public String upperCase()
	{
		// not sure of onderstaande regel nodig is
		Config.PARSER_USE_LOWERCASE_SYMBOLS = false;
		
		EvalUtilities util = new EvalUtilities(true, false);
		return util.evaluate(s).toString();
	}	
}
