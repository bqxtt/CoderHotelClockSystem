import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CoderHotelClockSystemTest
{
	CityClock londonCityClock  = new CityClock(0,"London");
	CityClock beijingCityClock = new CityClock(8, "Beijing");
	CityClock moscowCityClock  = new CityClock(4, "Moscow");
	CityClock sydneyCityClock  = new CityClock(10, "Sydney");
	CityClock newYorkCityClock = new CityClock(-5, "NewYork");
	
	@BeforeAll
	public static void init()
	{
		System.out.println("dsafs");
	}

	@Test
	@DisplayName("正确设置手机时间")
	void phoneClockTest()
	{
		PhoneClock phoneClock = new PhoneClock(8);
		phoneClock.setLocalTime("11:22");
		
		assertEquals(11, phoneClock.hour);
		assertEquals(22, phoneClock.minute);
		assertEquals("11:22", phoneClock.getLocalTime());
	}
	
	@Test
	@DisplayName("成功连接手机到系统")
	void clockSystemTest()
	{
		CoderHotelClockSystem coderHotelClockSystem = new CoderHotelClockSystem();
		PhoneClock phoneClock      = new PhoneClock(8);
		phoneClock.setCoderHotelClockSystem(coderHotelClockSystem);
		
		assertNotNull(phoneClock.coderHotelClockSystem);
	}
	
	@Test
	@DisplayName("成功添加地方时钟到系统")
	void addCityClockTest()
	{
		CoderHotelClockSystem coderHotelClockSystem = new CoderHotelClockSystem();
		coderHotelClockSystem.addClock(londonCityClock);
		coderHotelClockSystem.addClock(beijingCityClock);
		coderHotelClockSystem.addClock(moscowCityClock);
		coderHotelClockSystem.addClock(sydneyCityClock);
		coderHotelClockSystem.addClock(newYorkCityClock);
		
		assertNotNull(coderHotelClockSystem.getCityClock("London"));
		assertNotNull(coderHotelClockSystem.getCityClock("Beijing"));
		assertNotNull(coderHotelClockSystem.getCityClock("Moscow"));
		assertNotNull(coderHotelClockSystem.getCityClock("Sydney"));
		assertNotNull(coderHotelClockSystem.getCityClock("NewYork"));

	}
	
	@Test
	@DisplayName("正确校准伦敦时间")
	void londonClockTest()
	{
		CoderHotelClockSystem coderHotelClockSystem = new CoderHotelClockSystem();
		PhoneClock phoneClock      = new PhoneClock(8);
		coderHotelClockSystem.addClock(londonCityClock);
		phoneClock.setCoderHotelClockSystem(coderHotelClockSystem);
		phoneClock.setLocalTime("3:29");
		
		CityClock londonCityClock = coderHotelClockSystem.getCityClock("London");
		assertEquals("19:29", londonCityClock.getLocalTime());
	}
	
	@Test
	@DisplayName("正确校准莫斯科时间")
	void moscowClockTest()
	{
		CoderHotelClockSystem coderHotelClockSystem = new CoderHotelClockSystem();
		PhoneClock phoneClock      = new PhoneClock(8);
		coderHotelClockSystem.addClock(moscowCityClock);
		phoneClock.setCoderHotelClockSystem(coderHotelClockSystem);
		phoneClock.setLocalTime("3:36");
		
		CityClock moscowCityClock = coderHotelClockSystem.getCityClock("Moscow");
		assertEquals("23:36", moscowCityClock.getLocalTime());
	}
	
	@Test
	@DisplayName("正确校准悉尼时间")
	void sydneyClockTest()
	{
		CoderHotelClockSystem coderHotelClockSystem = new CoderHotelClockSystem();
		PhoneClock phoneClock      = new PhoneClock(8);
		coderHotelClockSystem.addClock(sydneyCityClock);
		phoneClock.setCoderHotelClockSystem(coderHotelClockSystem);
		phoneClock.setLocalTime("3:51");
		
		CityClock moscowCityClock = coderHotelClockSystem.getCityClock("Sydney");
		assertEquals("5:51", moscowCityClock.getLocalTime());
	}
	
	@Test
	@DisplayName("正确校准纽约时间")
	void newYorkClockTest()
	{
		CoderHotelClockSystem coderHotelClockSystem = new CoderHotelClockSystem();
		PhoneClock phoneClock      = new PhoneClock(8);
		coderHotelClockSystem.addClock(newYorkCityClock);
		phoneClock.setCoderHotelClockSystem(coderHotelClockSystem);
		phoneClock.setLocalTime("3:51");
		
		CityClock moscowCityClock = coderHotelClockSystem.getCityClock("NewYork");
		assertEquals("14:51", moscowCityClock.getLocalTime());
	}

}
