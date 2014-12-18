
public abstract class Formula
{
	abstract double calculate();
}

class OperatorFormula extends Formula
{
	public String operator;
	public Formula left, right;
	OperatorFormula(String s, Formula left, Formula right)
	{
		this.operator = s;
		this.left = left;
		this.right = right;
	}
	public double calculate()
	{
		double l = left.calculate();
		double r = right.calculate();
		
		if (operator == "+")
			return l + r;
		if (operator == "-")
			return l - r;
		if (operator == "*")
			return l * r;
		if (operator == "/")
			return l / r;
		else
		{
			String error = "Can't calculate using the operator " + operator + ". Returning 0.";
			System.out.println(error);
			return 0;
		}
	}
}

class FunctionFormula extends Formula
{
	public String function;
	public Formula toCalculate;
	FunctionFormula(String s, Formula formula)
	{
		this.function = s;
		this.toCalculate = formula;
	}
	
	public double calculate()
	{
		double value = toCalculate.calculate();
		if (function == "sin")
			return Math.sin(value);
		else
		{
			String error = "Can't calculate using the function " + function + ". Returning 0.";
			System.out.println(error);
			return 0;
		}
	}	
}

class ConstantFormula extends Formula
{
	public double number;
	ConstantFormula(double d)
	{
		this.number = d;
	}
	
	public double calculate()
	{
		return number;
	}
}

class VariableFormula extends Formula
{
	public char variable; //Willen we hier een character als variabele naam of moet dat ook een string kunnen zijn?
	VariableFormula(char c)
	{
		this.variable = c;
	}
	
	public double calculate()
	{
		return 0; //WIP
	}
}
