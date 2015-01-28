package com.teamindecisive.calcurmath.function;

import org.matheclipse.core.eval.EvalDouble;
import org.matheclipse.core.eval.EvalUtilities;

import com.teamindecisive.calcurmath.symbolic.ProbabilityFunctions;

// A string like the following should be given with "diff(sin(x)*cos(x),x)" or "integrate(sin(x)^5,x)"
// Other expressions can be given aswell, like "1/2+1/3" which returns "5/6"
// There will be a string returned like "-Sin(x)^2+Cos(x)^2" (note the capitals)
// For more details, see https://bitbucket.org/axelclk/symja_android_library/wiki/examples/Calculus
public class Calculus 
{	
	// The string must be written with lowerCases
	public static String lowerCase(String s)
	{
		// The replaces optimize the string from the input and for the output
		EvalUtilities util = new EvalUtilities(false, true);	
		return optimizeAnswer(util.evaluate(optimizeInput(s)).toString());
	}
	
	public static String doubleLowerCase(String s)
	{
		// The replaces optimize the string from the input and for the output
		EvalDouble doubleUtil = new EvalDouble(true);
		return optimizeAnswer(String.valueOf(doubleUtil.evaluate(optimizeInput(s))));
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
	
	// optimize the input for the evalEngine
	public static String optimizeInput(String s){
		// Calculate NcR/NpR statements first
		if(s.contains("NcR["))
			s = getProbValue(s, "NcR[");
		if(s.contains("NpR["))
			s = getProbValue(s, "NpR[");
		s = s.replace('i', 'I');
		s = s.replace("[","(");
		s = s.replace("]",",x)");
		return s;
	}
	
	// optimize the answer/output for the ansViewer
	public static String optimizeAnswer(String s){
		s = s.replace("Sec", "1/Cos");
		s = s.replace("Csc", "1/Sin");
		s = s.replace("Cot", "1/Tan");
		s = s.replace('I', 'i');
		return s;
	}
	
	// Calculate the value of the NcR/NpR and return the string with this value calculated
	public static String getProbValue(String s, String Case){
		int count = 1;
		int firstCount = s.indexOf(Case);
		int lastCount = 0;
		// We take the cases with more than multiple [ and ] in consideration
		// That way we can still solve an input like "NcR[Diff[7x],3]"
		for(int i = s.indexOf(Case)+4; ; i++){			
			if (s.charAt(i) == '[')
				count++;
			if (s.charAt(i) == ']')
				count--;			
			lastCount = i+1;
			if(count == 0)
				break;
		}
		
		// The NcR/Npr statement which should be replaced 
		String replaceString = s.substring(firstCount, lastCount);
		// The first part, between the [ and the ','
		String firstChild = Calculus.lowerCase(replaceString.substring
				(4,replaceString.indexOf(",")));
		// The last part, between the , and the last ]
		String lastChild = Calculus.lowerCase(replaceString.substring(
				replaceString.indexOf(",")+1, replaceString.length()-1));
		String probValueCalculated;
		// Calculate the NcR/NpR value and put it in the string probValueCalculated
		if(Case == "NcR[")
			probValueCalculated = String.valueOf(ProbabilityFunctions.combinations(Integer.parseInt(firstChild), 
				Integer.parseInt(lastChild)));				
		else probValueCalculated = String.valueOf(ProbabilityFunctions.permutations(Integer.parseInt(firstChild),
				Integer.parseInt(lastChild)));		
		// Swap the calculated value with the NcR/NpR statement
		String preFinal =  s.replace(replaceString, probValueCalculated);
		
		// In case there are multiple NcR/NpR statements in the string
		if(preFinal.contains(Case))
			preFinal = getProbValue(preFinal, Case);
		return preFinal;
	}
}
