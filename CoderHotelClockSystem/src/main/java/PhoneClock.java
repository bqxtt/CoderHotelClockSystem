
public class PhoneClock extends Clock
{
	public CoderHotelClockSystem coderHotelClockSystem;
	
	public PhoneClock(int utcOffset)
	{
		super(utcOffset);
		coderHotelClockSystem = null;
	}
	
	public void setCoderHotelClockSystem(CoderHotelClockSystem coderHotelClockSystem)
	{
		this.coderHotelClockSystem = coderHotelClockSystem; 
	}
	
	public void setLocalTime(String localTime) throws Exception
	{
		super.setLocalTime(localTime);
		if(coderHotelClockSystem != null)
		{
			int utcHour = (this.hour - this.utcOffset + 24) % 24;
			coderHotelClockSystem.updateClocksWithUtcTime(utcHour + ":" + this.minute);
		}
	}
}
