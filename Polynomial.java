public class Polynomial
{
	public double[] coeffs;
	public Polynomial()
	{
		coeffs = new double[] {0};

	}
	public Polynomial(double[] coeffsArr)
	{
		coeffs = coeffsArr;
	}
	Polynomial add(Polynomial p)
	{
		int max = Math.max(p.coeffs.length, coeffs.length);
		double[] arr = new double[max];
		Polynomial sum = new Polynomial(arr);
		double a = 0;
		double b = 0;
		for(int x = 0; x < max; x++)
		{
			a = 0;
			b = 0;
			if(x < coeffs.length)
				a = coeffs[x];
			if(x < p.coeffs.length)
				b = p.coeffs[x];	
			sum.coeffs[x] = a + b;
		}
		return sum;
	}
	double evaluate(double x)
	{
		double ans = 0;
		for(int i = 0; i < coeffs.length; i++)
		{
			ans += coeffs[i]*Math.pow(x,i);
		}
		return ans;
	}
	boolean hasRoot(double x)
	{
		return evaluate(x) == 0;
	}

}