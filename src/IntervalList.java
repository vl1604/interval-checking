import java.util.*;

public class IntervalList
{
	private List<Interval> list;
	private int size, origin, bound;
	private String caption;

	public IntervalList()
	{
		size = 10;
		origin = 0;
		bound = 1;
	}

	public String getCaption()
	{
		return caption;
	}

	public IntervalList setNum(int num)
	{
		this.size = num;
		return this;
	}

	public int getNum()
	{
		return size;
	}

	public IntervalList setOrigin(int origin)
	{
		this.origin = origin;
		return this;
	}

	public int getOrigin()
	{
		return origin;
	}

	public IntervalList setBound(int bound)
	{
		this.bound = bound;
		return this;
	}

	public int getBound()
	{
		return bound;
	}

	private void updateCaption()
	{
		caption = "interval list of " 
			+ String.valueOf(size) + " ("
			+ String.valueOf(origin) + ", "
			+ String.valueOf(bound) + ")";

	}

	public IntervalList build()
	{
		double r1, r2, tmp;
		Random r = new Random();

		list = new ArrayList<Interval>();
		updateCaption();

		for (int i=0; i < size; i++)
		{
			r1 = origin + (bound - origin) * r.nextDouble();
			r2 = origin + (bound - origin) * r.nextDouble();

			if (r1 > r2)
			{
				tmp = r1;
				r1 = r2;
				r2 = tmp;
			}

			list.add(new Interval(r1, r2));
		}

		return this;
	}

	public IntervalList print()
	{
		System.out.println("Printing " + caption);
		Stopwatch stopWatch = new Stopwatch();
		for (int i=0; i < list.size(); i++)
		{
			stopWatch.resetWatch();
			System.out.printf("%d:  (%f, %f) - %fus\n", i, 
							  list.get(i).getA(), 
							  list.get(i).getB(),
							  stopWatch.getElapsedTime());
		}
		System.out.println();

		return this;
	}

	public int checkN2()
	{
		int size = list.size();
		int fitCount = 0;
		boolean isFit;

		System.out.println("Checking " + caption);

		Stopwatch stopWatchTotal = new Stopwatch();
		Stopwatch stopWatch = new Stopwatch();
		for (int j = 0; j < size; j++)
			for (int i = 0; i < size; i++)
			{
				stopWatch.resetWatch();
				if (i != j)
				{
					isFit = list.get(j).contains(
						list.get((i)));

					if (isFit)
					{
						fitCount++;
						System.out.printf(
							"%d contains %d - %s (%fus)\n",
							j, i, isFit ?"true": "false",
							stopWatch.getElapsedTime());
					}
				}
			}

		System.out.printf("Total time: %f%s\n", 
						  stopWatchTotal.getElapsedTime(),
						  stopWatchTotal.getUnits());
		System.out.printf("Fits count: %d\n", fitCount);
		return fitCount;
	}

}
