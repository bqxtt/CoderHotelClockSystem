import java.util.ArrayList;

public class CoderHotelClockSystem
{
	ArrayList<CityClock> clocks;
	public CoderHotelClockSystem()
	{
		clocks = new ArrayList<CityClock>();
	}
	public void addClock(CityClock clock)
	{
		clocks.add(clock);
	}
	public void updateClocksWithUtcTime(String utcTime)
	{
		String t[] = utcTime.split(":");
		int hour = Integer.parseInt(t[0]);
		int minute = Integer.parseInt(t[1]);
		for(Clock clock : clocks)
		{
			int localHour = (hour + clock.utcOffset + 24 ) % 24;
			clock.setLocalTime(localHour + ":" + minute);
		}
	}
	public void showCityTime()
	{
		for(CityClock clock : clocks)
		{
			System.out.println(clock.cityName + ": " + clock.hour + ":" + clock.minute);
		}
	}
	public CityClock getCityClock(String cityName)
	{
		for(CityClock clock : clocks)
		{
			if(clock.cityName.equals(cityName))
				return clock;
		}
		return null;
	}
}
