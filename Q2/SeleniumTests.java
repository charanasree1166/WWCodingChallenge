package Que2;

import NUnit.Framework.*;
import OpenQA.Selenium.*;
import OpenQA.Selenium.Chrome.*;
import OpenQA.Selenium.Firefox.*;

   public class SeleniumTests
   {
	  private IWebDriver _browserDriver;

	  public final void startBrowser()
	  {
		 _browserDriver = new ChromeDriver("C:\\Users\\keerthi.katakam\\Downloads\\Personal\\Charana Sree\\Coding");
	  }


	  public final void test()
	  {
		 _browserDriver.Url = "https://www.weightwatchers.com/us/";
		 _browserDriver.Manage().Window.Maximize();

		 String expectedtitle = "WW (Weight Watchers): Weight Loss & Wellness Help | WW USA";
		 _browserDriver.Manage().Timeouts().ImplicitWait = TimeSpan.FromSeconds(100);
		 String actualtitle = _browserDriver.Title;

		 assert expectedtitle == actualtitle;

		 _browserDriver.FindElement(By.XPath("//*[@class='MenuItem_menu-item__inner-wrapper__1trJ0 MenuItem_menu-item__inner-wrapper--with-icon__2l1uq']/span[2]")).Click();
		 expectedtitle = "Find WW Studios & Meetings Near You | WW USA";
		 Thread.sleep(1000);
		 actualtitle = _browserDriver.Title;
		 assert expectedtitle == actualtitle;

		 _browserDriver.FindElement(By.XPath("//*[@class='input input-3TfT5']")).SendKeys("10011");
		 _browserDriver.FindElement(By.XPath("//*[@class='ww button primary cta-1JqRp']")).Click();

		 Thread.sleep(1000);
		 String titleOfFirstResult = _browserDriver.FindElement(By.XPath("//*[@class='linkContainer-1NkqM']")).Text;
		 _browserDriver.FindElement(By.XPath("//*[@class='linkContainer-1NkqM']")).Click();
		 Thread.sleep(1000);
		 String ValidateText = _browserDriver.FindElement(By.XPath("//*[@class='locationName-1jro_']")).Text;

		 assert titleOfFirstResult == ValidateText;
		 int d = new java.util.Date().DayOfWeek.getValue();
		 String result = PrintMeetings(d);
		 assert result != null;
	  }

	  public final String PrintMeetings(int Day)
	  {
		 ReadOnlyCollection<IWebElement> elements = null;
		 switch (Day)
		 {
			case 1:
			   elements = _browserDriver.FindElements(By.XPath("//*[@class='day-NhBOb'][2]/div"));
			   break;
			case 2:
			   elements = _browserDriver.FindElements(By.XPath("//*[@class='day-NhBOb'][3]/div"));
			   break;
			case 3:
			   elements = _browserDriver.FindElements(By.XPath("//*[@class='day-NhBOb'][4]/div"));
			   break;
			case 4:
			   elements = _browserDriver.FindElements(By.XPath("//*[@class='day-NhBOb'][5]/div"));
			   break;
			case 5:
			   elements = _browserDriver.FindElements(By.XPath("//*[@class='day-NhBOb'][6]/div"));
			   break;
			case 6:
			   elements = _browserDriver.FindElements(By.XPath("//*[@class='day-NhBOb'][7]/div"));
			   break;
			case 7:
			   elements = _browserDriver.FindElements(By.XPath("//*[@class='day-NhBOb'][1]/div"));
			   break;
		 }

		 return print(elements);

	  }

	  private String print(ReadOnlyCollection<IWebElement> elements)
	  {
		 java.util.ArrayList<String> arr = new java.util.ArrayList<String>();
		 java.util.ArrayList<Integer> freq = new java.util.ArrayList<Integer>();
		 for (IWebElement elem : elements)
		 {
			arr.add(elem.Text.split("[\\n]", -1)[1]);
			freq.add(-1);
		 }
		 for (int i = 0; i < arr.size(); i++)
		 {
			int count = 1;
			for (int j = i + 1; j < arr.size(); j++)
			{
			   /* If duplicate element is found */
			   if (arr.get(i).equals(arr.get(j)))
			   {
				  count++;
				  /* Make sure not to count frequency of same element again */
				  freq.set(j, 0);
			   }
			}
			/* If frequency of current element is not counted */
			if (freq.get(i) != 0)
			{
			   freq.set(i, count);
			}
		 }

		 /* Print frequency of each element */

		 // printf("nFrequency of all elements of array: n");
		 String s = "";
		 for (int i = 0; i < arr.size(); i++)
		 {
			if (freq.get(i) != 0)
			{
			   s = s + arr.get(i) + " " + freq.get(i) + "\n";
			   //printf("% s occurs % d timesn", arr[i], freq[i]);
			}
		 }
		 System.out.println(s);
		 return s;
	  }

	  public final void closeBrowser()
	  {
		 _browserDriver.Close();
	  }
   }