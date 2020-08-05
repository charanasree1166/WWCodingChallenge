package Que2;

import OpenQA.Selenium.*;
import OpenQA.Selenium.Interactions.*;

   public class Locator
   {
	  public Locator(LocatorType locatorType, String location)
	  {
		 this.setLocation(location);
		 this.setLocatorType(locatorType);
	  }

	  public static Locator Get(LocatorType locatorType, String location)
	  {
		 return new Locator(locatorType, location);
	  }

	  public final By GetBy()
	  {
		 By by = null;
		 switch (this.getLocatorType())
		 {
			case XPath:
			   by = By.XPath(this.getLocation());
			   break;

			case ID:
			   by = By.Id(this.getLocation());
			   break;

			case Name:
			   by = By.Name(this.getLocation());
			   break;

			case ClassName:
			   by = By.ClassName(this.getLocation());
			   break;
		 }

		 return by;
	  }

	  private String privateLocation;
	  public final String getLocation()
	  {
		  return privateLocation;
	  }
	  public final void setLocation(String value)
	  {
		  privateLocation = value;
	  }
	  private LocatorType privateLocatorType = getLocatorType().values()[0];
	  public final LocatorType getLocatorType()
	  {
		  return privateLocatorType;
	  }
	  public final void setLocatorType(LocatorType value)
	  {
		  privateLocatorType = value;
	  }
   }