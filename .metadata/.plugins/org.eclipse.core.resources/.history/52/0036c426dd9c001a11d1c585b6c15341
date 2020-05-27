package com.salesforce.automaton;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * This class defines the framework level methods and generic methods
 * 
 * @author Kushal Shrivastava
 *
 */

public class Base
{
	
	private static WebDriver	driver;
	
	/**
	 * GetDriver method invokes the driver
	 * 
	 * 
	 * @return WebDriver
	 * @param Eg
	 *            . Chrome ,Firefox
	 * @author Kushal Shrivastava
	 *
	 */
	public static WebDriver getDriver( String browserName )
	{
		if ( driver == null )
		{
			if ( browserName.equalsIgnoreCase("Chrome") )
			{
				System.setProperty("webdriver.chrome.driver", "src/resources/chromedriver.exe");
				driver = new ChromeDriver();
			} else if ( browserName.equalsIgnoreCase("Firefox") )
			{
				System.setProperty("webdriver.gecko.driver", "src/resources/geckodriver.exe");
				driver = new FirefoxDriver();
			}
		}
		return driver;
	}
	
	/**
	 * This method send the desired URL to the browser
	 * 
	 * @author Kushal Shrivastava
	 *
	 */
	public static void openUrl( String url )
	{
		driver.get(url);
		
	}
	
	/**
	 * This method quits the browser instance
	 * 
	 * @author Kushal Shrivastava
	 *
	 */
	public static void closeWindow()
	{
		driver.quit();
	}
	
	/**
	 * This method gives the current driver instance
	 * 
	 * @author Kushal Shrivastava
	 *
	 */
	public static WebDriver getDriverInstance()
	{
		return driver;
	}
	
	/**
	 * This method is used for logging purpose, the logs are stored in file as
	 * well as on console
	 * 
	 * @return Logger
	 * 
	 * @author Kushal Shrivastava
	 *
	 */
	public static Logger getLogger( String className )
	{
		DOMConfigurator.configure(Constants.CONFIG_LOG_FILE);
		Logger logger = Logger.getLogger(className);
		return logger;
	}
	
	/**
	 * 
	 * This method calls the implicit wait
	 * 
	 * @author Kushal Shrivastava
	 *
	 */
	public static void getImplicitWait( long timeinSeconds )
	{
		driver.manage().timeouts().implicitlyWait(timeinSeconds, TimeUnit.SECONDS);
	}
	
	/**
	 * 
	 * This method get current URL
	 * 
	 * @return String URL
	 * @author Kushal Shrivastava
	 *
	 */
	
	public static String getCurrentBrowserURL()
	{
		return driver.getCurrentUrl();
	}
	
	/**
	 * 
	 * This method performs keyboard actions
	 * 
	 * @return String Keyboard Action
	 *
	 *
	 */
	
	public static void performKeyboardActions( WebDriver driver , Keys keysToSend )
	{
		new Actions(driver).sendKeys(keysToSend).perform();
	}
	
	/**
	 * 
	 * This method gives an explicit wait instance
	 * 
	 * @return String Keyboard Action
	 *
	 *
	 */
	
	public static WebDriverWait getWait( WebDriver driver , int timeOutInSeconds )
	{
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		return wait;
	}
	
	/**
	 * 
	 * This method gives an explicit wait for element to be clickable
	 * 
	 * @return String Keyboard Action
	 *
	 *
	 */
	
	public static WebElement getWaitforelementclickable( WebDriver driver , int timeOutInSeconds , WebElement element )
	{
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		return wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	/**
	 * get current date and time
	 * format as a string eg: yyMMdd
	 * @return String in format specified 
	 */
	public static String getDate()
	{
		DateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
		Date date = new Date();
		return dateFormat.format(date);
	}
	
	/**
	 * get dynamic name
	 * format as a string eg: 
	 * @return String in format specified 
	 */
	public static String generateName( String type )
	{
		return type + getDate();
	}
}
