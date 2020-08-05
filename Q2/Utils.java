package Que2;

import OpenQA.Selenium.*;
import OpenQA.Selenium.Interactions.*;

   public final class Utils
   {
	  private static java.util.HashMap<String, Locator> locators = new java.util.HashMap<String, Locator>();
	  public static Locator GetLocator(String name)
	  {
		 if (locators.isEmpty())
		 {
			synchronized (locators)
			{
			   // load all for one time
			   XmlDocument objectRepository = new XmlDocument();
			   objectRepository.Load(Path.Combine("Objects.xml"));

			   for (XmlNode page : objectRepository.SelectNodes("/PageFactory/page"))
			   {
				  for (XmlNode eachObject : page.ChildNodes)
				  {
					 Locator locator = null;

					 switch (eachObject.SelectSingleNode("identifyBy").InnerText.toLowerCase())
					 {
						case "id":
						   locator = Locator.Get(LocatorType.ID, eachObject.SelectSingleNode("value").InnerText);
						   break;

						case "xpath":
						   locator = Locator.Get(LocatorType.XPath, eachObject.SelectSingleNode("value").InnerText);
						   break;

						case "classname":
						   locator = Locator.Get(LocatorType.ClassName, eachObject.SelectSingleNode("value").InnerText);
						   break;

						case "name":
						   locator = Locator.Get(LocatorType.Name, eachObject.SelectSingleNode("value").InnerText);
						   break;
					 }

					 locators.put(eachObject.SelectSingleNode("name").InnerText, locator);
				  }
			   }
			}
		 }
		 return locators.get(name);
	  }

	  public static By GetBy(String v)
	  {
		 return GetLocator(v)?.GetBy();
	  }

	  public static void PerformAction(IWebDriver browserDriver, String input)
	  {
		 Actions action1 = new Actions(browserDriver);
		 action1.SendKeys(input);
		 action1.Perform();
	  }
   }