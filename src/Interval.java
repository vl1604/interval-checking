public class Interval
{
	private Double a, b;

	Interval(Double a, Double b)
	{
		this.a = a;
		this.b = b;
	}

	public Double getA()
	{
		return a;
	}

	public Double getB()
	{
		return b;
	}

	boolean contains(Interval p)
	{
		return this.a < p.a && this.b > p.b;
	}
}
