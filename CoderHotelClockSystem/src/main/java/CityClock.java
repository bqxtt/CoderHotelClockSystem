
public class CityClock extends Clock
{
	String cityName;
	public CityClock(int utcOffset,String cityName)
	{
		super(utcOffset);
		this.cityName = cityName;
	}
}
