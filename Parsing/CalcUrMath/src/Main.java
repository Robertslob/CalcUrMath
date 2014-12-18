
public class Main {
	public static void main(String[] args) 
	{
		Parser parser = new Parser("13-5-2"); //tijdelijke input
		Formula f = parser.parseExpression();
		double a = f.calculate();
		System.out.println(a);
	}
}
