package Que2;

import OpenQA.Selenium.*;
import OpenQA.Selenium.Interactions.*;

   public enum LocatorType
   {
	  XPath,
	  ID,
	  ClassName,
	  Name;

	   public int getValue()
	   {
		   return this.ordinal();
	   }

	   public static LocatorType forValue(int value)
	   {
		   return values()[value];
	   }
   }