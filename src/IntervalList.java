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

		for (int i = 0; i < size; i++)
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
		for (int i = 0; i < list.size(); i++)
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

	public IntervalList checkN2()
	{
		Stopwatch stopWatchTotal = new Stopwatch();
		int size = list.size();
		int fitCount = 0;
		boolean isFit;

		//Stopwatch stopWatch = new Stopwatch();
		for (int j = 0; j < size; j++)
			for (int i = 0; i < size; i++)
			{
				//stopWatch.resetWatch();
				if (i != j)
				{
					isFit = list.get(j).contains(
						list.get((i)));

					if (isFit)
					{
						fitCount++;
//						System.out.printf(
//							"%d contains %d - %s (%fus)\n",
//							j, i, isFit ?"true": "false",
//							stopWatch.getElapsedTime());
					}
				}
			}

		System.out.printf("Total checking time: %f%s\n", 
						  stopWatchTotal.getElapsedTime(),
						  stopWatchTotal.getUnits());
		System.out.printf("Fits count: %d\n\n", fitCount);

		return this;
	}

	public IntervalList sortCheck2()
	{
		Stopwatch stopWatch = new Stopwatch();
		int count = 0;
		int size = list.size();

		// Linked list sorting
		for (int j = 0; j < size; j++)
			for (int i = j + 1; i < size; i++)
				if (list.get(j).getB() > list.get(i).getB()
					&&
					list.get(i).getA() < list.get(j).getB())
				{
					//list.add(j, list.remove(i));
//					System.out.printf("#%d (%d contains %d)\n", 
//									  j * list.size() + i, 
//									  j, i);
					//printL(list);
					count++;
				}
		System.out.printf("Total checking 2 time: %f%s\n",
						  stopWatch.getElapsedTime(),
						  stopWatch.getUnits());
		System.out.printf("Fits c2 count: %d\n\n", count);
		return this;
	}

	public IntervalList sort2()
	{
		Stopwatch stopWatch = new Stopwatch();
		List<Interval> ll = new ArrayList<Interval>(list);
		int size = ll.size();

		for (int j = 0; j < size; j++)
			for (int i = j + 1; i < size; i++)
				if (ll.get(i).getA() < ll.get(j).getA())
				{
					ll.add(j, ll.remove(i));
					//System.out.printf("#%d (%d,%d)\n", j*ll.size()+i, j, i);
					//printL(ll);
				}

		this.list = ll;
		System.out.printf("Total sorting time: %f%s\n",
						  stopWatch.getElapsedTime(),
						  stopWatch.getUnits());
		return this;
	}

	private void printL(List<Interval> ll)
	{
		System.out.println("Printing ll of " + caption);
		Stopwatch stopWatch = new Stopwatch();
		for (int i=0; i < ll.size(); i++)
		{
			stopWatch.resetWatch();
			System.out.printf("%d:  (%f, %f) - %fus\n", i, 
							  ll.get(i).getA(), 
							  ll.get(i).getB(),
							  stopWatch.getElapsedTime());
		}
		System.out.println();
	}

}
