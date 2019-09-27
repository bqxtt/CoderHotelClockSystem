
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
	public void setLocalTime(String localTime) throws Exception
	{
		String t[] = localTime.split(":");
		int tHour = Integer.parseInt(t[0]),tMinute = Integer.parseInt(t[1]);
		if(tHour < 0 || tHour > 24 || tMinute < 0 || tMinute > 60)
		{
			throw new Exception("时间输入有误");
		}
		else 
		{
			this.hour = tHour;
			this.minute = tMinute;
		}

	}
}
