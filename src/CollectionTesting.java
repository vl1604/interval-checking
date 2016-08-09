import java.util.*;

public class CollectionTesting
{
	public void testArrayList(int size, int step)
	{
		double elapsedTime=0, meanTime=0;
		String testElem = "a";
		List<String> testList = new ArrayList<String>();
		Stopwatch stopWatch = new Stopwatch();
		Stopwatch totalStopWatch = new Stopwatch();

		testList.add(testElem);
		for (int i = 1; i < size; i++)
		{
			stopWatch.resetWatch();
			testList.add(testElem);
			elapsedTime = stopWatch.getElapsedTime();

			meanTime = (meanTime * (i - 1) + elapsedTime) / i;

			if (i % step == 0)
				System.out.printf("#%d: %f%s - %f%s\n", i, 
								  elapsedTime,
								  stopWatch.getUnits(),
								  meanTime,
								  stopWatch.getUnits()
								  );
		}

		System.out.printf("Total time: %f%s\n",
						  totalStopWatch.getElapsedTime(),
						  totalStopWatch.getUnits()
						  );
	}

	//	public IntervalList sort3(){
////		list.stream();
////		List<String> items = {"1","2"};
////		List<String> sorted = items.stream()
////			.sorted().collect(Collectors.toList());
////		
//		return this;
//	}


}
