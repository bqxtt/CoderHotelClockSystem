
public class Clock
{
	protected int utcOffset;
	protected int hour,minute;
	
	public Clock(int utcOffset)
	{
		this.utcOffset = utcOffset;
	}
	public String getLocalTime()
	{
		return this.hour + ":" + this.minute;
	}
	public void setLocalTime(String localTime)
	{
		String t[] = localTime.split(":");
		this.hour = Integer.parseInt(t[0]);
		this.minute = Integer.parseInt(t[1]);
	}
}
