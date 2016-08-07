public class Main
{
	public static void main(String[] args)
	{
		IntervalList list = new IntervalList();
		list.setNum(1000)
			.setOrigin(0).setBound(100)
			.build()//.print()
			.checkN2()
			.sort2()//.print();
			.sortCheck2();
	}
}
