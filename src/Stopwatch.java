public class Stopwatch
{
	private long startTime;
	private double elapsedTime;
	private String units;

	public Stopwatch()
	{
		resetWatch();
	}

	public String getUnits()
	{
		return units;
	}

	public void resetWatch()
	{
		startTime = System.nanoTime();
		units = "us";
	}

	public double getElapsedTime()
	{
		long endTime = System.nanoTime();
		elapsedTime = (double) (endTime - startTime) / (1000);
		if (elapsedTime > 900)
		{
			elapsedTime /= 1000;
			units = "ms";
			if (elapsedTime > 900)
			{
				elapsedTime /= 1000;
				units = "s";
			}
		}
		return elapsedTime;
	}
}
