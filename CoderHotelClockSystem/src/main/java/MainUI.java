import java.util.Scanner;

public class MainUI
{
	public static void main(String[] args)
	{
		System.out.println("******************************");
		System.out.println("     欢迎使用码农酒店世界时钟系统             ");
		System.out.println("******************************");
		
		CoderHotelClockSystem coderHotelClockSystem = new CoderHotelClockSystem();
		PhoneClock phoneClock      = new PhoneClock(8);
		CityClock londonCityClock  = new CityClock(0,"London");
		CityClock beijingCityClock = new CityClock(8, "Beijing");
		CityClock moscowCityClock  = new CityClock(4, "Moscow");
		CityClock sydneyCityClock  = new CityClock(10, "Sydney");
		CityClock newYorkCityClock = new CityClock(-5, "NewYork");
		coderHotelClockSystem.addClock(londonCityClock);
		coderHotelClockSystem.addClock(beijingCityClock);
		coderHotelClockSystem.addClock(moscowCityClock);
		coderHotelClockSystem.addClock(sydneyCityClock);
		coderHotelClockSystem.addClock(newYorkCityClock);
		phoneClock.setCoderHotelClockSystem(coderHotelClockSystem);
		
		try
		{
			phoneClock.setLocalTime("00:00");
		} catch (Exception e1)
		{
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		int op;
		Scanner cinScanner = new Scanner(System.in);
		do
		{
			System.out.println("1.设置手机时间");
			System.out.println("2.显示各地时间");
			System.out.println("3.退出时钟系统");
			op = cinScanner.nextInt();
			if(op == 1)
			{
				System.out.println("请输入时间(hh:ss)");
				String localTime = cinScanner.next();
				try
				{
					phoneClock.setLocalTime(localTime);
				} catch (Exception e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else if(op == 2)
			{
				coderHotelClockSystem.showCityTime();
			}
			
		} while (op != 3);
		System.out.println("再见。。。。。");
		cinScanner.close();
	}
}
