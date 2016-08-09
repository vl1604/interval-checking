public class Main
{
	public static void main(String[] args)
	{
		IntervalList list = new IntervalList();
		list.setNum(1000)
			.setOrigin(0).setBound(100)
			.build()//.print()
			.checkN2()
			.sort2().sortCheck2();
			
		CollectionTesting test = new CollectionTesting();
		test.testArrayList(Integer.MAX_VALUE/50,
						Integer.MAX_VALUE/1000);
	}
}
