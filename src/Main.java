public class Main
{
	public static void main(String[] args)
	{
		IntervalList list = new IntervalList();
		list.setNum(5)
			.setOrigin(0)
			.setBound(100)
			.build()
			.print()
			.checkN2();
	}
}
