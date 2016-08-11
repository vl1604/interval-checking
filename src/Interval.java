public class Interval implements Comparable<Interval>
{
	private Double a, b;
	private int containsCount;

	public void setContainsCount(int containsCount)
	{
		this.containsCount = containsCount;
	}

	public int getContainsCount()
	{
		return containsCount;
	}
	
	@Override
	public int compareTo(Interval interval)
	{
		return this.getA() < interval.getA() ?-1:
			this.getA() > interval.getA() ?1:
			this.getB() < interval.getB() ?-1:
			this.getB() > interval.getB() ?1: 0;
	}

	Interval(Double a, Double b)
	{
		this.a = a;
		this.b = b;
		this.containsCount = 0;
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
