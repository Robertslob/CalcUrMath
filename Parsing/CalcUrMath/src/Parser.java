public class Parser
{
	public String input;
	private int cursor;
	Parser(String input)
	{
		this.input = input;
		this.cursor = 0;
	}
	
	char getCurrent()
	{
		return this.input.charAt(cursor);
	}
	
	double getNumber()
	{
		double number = 0;
		while(getCurrent() >= '0' && getCurrent() <= '9')
		{
			number *= 10;
			number += Integer.parseInt(input.substring(cursor, cursor + 1));
			cursor++;
		}
		if (getCurrent() == '.')
		{
			cursor++;
			for(int t = 1;getCurrent() >= '0' && getCurrent() <= '9'; t++)
			{
				number += Integer.parseInt(input.substring(cursor, cursor + 1))/(Math.pow(10, -1 * t));
				cursor++;
			}
		}
		return number;
	}
	
	Formula parseExpression()
	{
		Formula term, expr;
		term = parseTerm();
		if (cursor == input.length())
			return term;
		else if (getCurrent() == '+')
		{
			cursor++;
			expr = parseExpression();
			return new OperatorFormula("+", term, expr);
		}
		else if (getCurrent() == '-')
		{
			cursor++;
			expr = parseExpression();
			return new OperatorFormula("-", term, expr);
		}
		else return null;
	}
	
	Formula parseTerm()
	{
		Formula fact, term;
		fact = parseFactor();
		if (cursor == input.length())
			return fact;
		else if (getCurrent() == '*')
		{
			cursor++;
			term = parseTerm();
			return new OperatorFormula("*", fact, term);
		}
		else if (getCurrent() == '/')
		{
			cursor++;
			term = parseTerm();
			return new OperatorFormula("*", fact, term);
		}
		else return null;

	}
	
	Formula parseFactor()
	{
		if (getCurrent() == '(')
		{
			cursor++;
			Formula e = parseExpression();
			if (getCurrent() == ')')
			{
				cursor++;
				return e;
			}
			else
			{
				String error;
				error = "Can't parse this: " + input.substring(cursor) + "/nAre the brackets balanced?";
				System.out.println(error);
				return null;
			}
		}
		else if (getCurrent() >= '0' && getCurrent() <= '9' || getCurrent() == '.')
		{
			double number = getNumber();
			return new ConstantFormula(number);
		}
		else if (getCurrent() == '-')
		{
			double number = getNumber();
			return new ConstantFormula(-1 * number);
		}
		else if (getCurrent() >= 'a' && getCurrent() <= 'Z')
		{
			String operator = "";
			while (getCurrent() >= 'a' && getCurrent() <= 'Z')
			{
				operator += this.input.charAt(cursor);
				cursor++;
			}
			if (getCurrent() != '(')
			{
				String error;
				error = "You seem to be missing a bracket for: " + operator + "./nCan't parse:" + this.input.substring(cursor);
				System.out.println(error);
				return null;
			}
			
			Formula e = parseExpression();				//Eventueel kunnen we hier eerst checken of de operator wel een valid operator is
			return new FunctionFormula(operator, e);
		}
		else return null;
	}
}
