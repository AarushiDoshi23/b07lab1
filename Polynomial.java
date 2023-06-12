import java.io.*;
import java.util.Arrays;

public class Polynomial{
	
	public double[] coeff;
	public int[] powers;

	// CONSTRUCTOR 1
	public Polynomial()
	{
		this.coeff = null;
		this.powers = null;
	}

	// CONSTRUCTOR 2
	public Polynomial(double[] coeff, int[] powers)
	{
		if (coeff.length == 0) 
		{
            this.coeff = null;
            this.powers = null;
		}
		else
		{
			this.coeff = new double[coeff.length];
        	this.powers = new int[powers.length];
        	for (int i = 0; i < coeff.length; i++) 
			{
				if (coeff[i] != 0)
				{
					this.coeff[i] = coeff[i];
            		this.powers[i] = powers[i];
				}
        	}
		}
	}

	// CONSTRUCTOR 3
	public Polynomial(File file) throws IOException 
	{
		BufferedReader reader = new BufferedReader(new FileReader(file));
		String line = reader.readLine();
		reader.close();

		String[] terms;
		terms = line.split("(?=[+-])");

		double[] parsedCoeffs = new double[terms.length];
		int[] parsedPows = new int[terms.length];

		String term;

		for (int i = 0; i < terms.length; i++) {
			term = terms[i];
			int ind = term.indexOf('x');

			if (ind != -1) 
			{
				parsedCoeffs[i] = Double.parseDouble(term.substring(0, ind));
				parsedPows[i] = Integer.parseInt(term.substring(ind + 1));
			} 
			else
			{
				parsedCoeffs[i] = Double.parseDouble(term);
				parsedPows[i] = 0;
			}
		}

		this.coeff = parsedCoeffs;
		this.powers = parsedPows;
	}

	public Polynomial add(Polynomial p)
	{
		if(this.coeff == null)
		{
			return p;
		}
		if(p.coeff == null)
		{
			return this;
		}

		int length = HighestExp(p.powers) + 1;

		double[] newCoeff = new double[length];
		int[] newPowers = new int[length];
		int position;

		for (int i = 0; i < this.coeff.length; i++)
		{
			position=this.powers[i];
			newCoeff[position] += this.coeff[i];
			newPowers[position] = this.powers[i];
		}

		for (int i = 0; i < p.coeff.length; i++) 
		{
			position=p.powers[i];
			newCoeff[position] += p.coeff[i];
			newPowers[position] = p.powers[i];
		}

		return TrimmedPoly(newCoeff, newPowers, length);
	}
	
	public double evaluate(double x) 
	{
		if (this.coeff == null)
		{
			System.out.println("null Polynomial!");
			return 0;
		}
		double ans = 0;
		for(int i = 0; i < coeff.length; i++)
		{
			ans += this.coeff[i]*Math.pow(x,this.powers[i]);
		}
		return ans;
	}
	
	public boolean hasRoot(double x) 
	{
		if (this.coeff == null)	
		{
			System.out.println("null Polynomial!");
			return false;
		}	
		return this.evaluate(x) == 0;
	}

	public Polynomial multiply(Polynomial p) 
	{		
		if(this.coeff == null || p.coeff == null)
		{
			return new Polynomial();
		}
		int newLength = HighestExp(p.powers) + 1;
		double[] newCoeff = new double[newLength];
		int[] newPowers = new int[newLength];

		for (int i = 0; i < this.powers.length; i++) 
		{
			for (int j = 0; j < p.powers.length; j++) 
			{
				int newExp = this.powers[i] + p.powers[j];
				newCoeff[newExp] += (this.coeff[i] * p.coeff[j]);
				newPowers[newExp] = newExp;
			}
		}

		return TrimmedPoly(newCoeff, newPowers, newLength);
	}

	public int HighestExp(int[] exp)
	{
		int highestPow1 = 0;
		int highestPow2 = 0;
		for (int x = 0; x < this.powers.length; x++)
		{
			if (this.powers[x] > highestPow1)
			{
				highestPow1 = this.powers[x];
			}
		}
		for (int x = 0; x < exp.length; x++)
		{
			if (exp[x] > highestPow2)
			{
				highestPow2 = exp[x];
			}
		}
		return highestPow1 + highestPow2;
	}
	public Polynomial TrimmedPoly(double[] coeffs, int[] exponents, int len){
		int finalLen = 0;
		double[] finalCoeff = new double[len];
		int[] finalExp = new int[len];
		for (int i = 0; i < len; i++) 
		{
			if (coeffs[i] != 0) 
			{
				finalCoeff[finalLen] = coeffs[i];
				finalExp[finalLen] = exponents[i];
				finalLen++;
			}
		}


		finalCoeff = Arrays.copyOf(finalCoeff, finalLen);
		finalExp = Arrays.copyOf(finalExp, finalLen);

		return new Polynomial(finalCoeff, finalExp);
	}

	public void saveToFile(String fileName) throws IOException
	{
		BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
		for (int i = 0; i < this.coeff.length; i++)
			{
				if (this.coeff[i] != 0) 
				{
					if (coeff[i] > 0 && i != 0) 
					{
						writer.write("+");
					}
					writer.write(Double.toString(this.coeff[i]));

					if(this.powers[i] != 0)
					{
						writer.write("x");
						if(this.powers[i] != 1)
						{
							writer.write(Integer.toString(this.powers[i]));
						}
					}
				}
			}
			writer.close(); 
	}
}