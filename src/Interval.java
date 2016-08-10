public class Interval implements Comparable<Interval>
{

	@Override
	public int compareTo(Interval interval)
	{
		return this.getA() < interval.getA() ?-1:
			this.getA() > interval.getA() ?1:
			this.getB() < interval.getB() ?-1:
			this.getB() > interval.getB() ?1: 0;
	}

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
