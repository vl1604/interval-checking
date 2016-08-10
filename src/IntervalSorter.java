
import java.util.ArrayList;
import java.util.*;

public class IntervalSorter
{
	ArrayList<Interval> intervalList = new ArrayList<Interval>();

	public IntervalSorter(ArrayList<Interval> intervalList)
	{
		this.intervalList = intervalList;
	}

	public ArrayList<Interval> getSorted()
	{
		Collections.sort(intervalList);
		return intervalList;
	}
}
