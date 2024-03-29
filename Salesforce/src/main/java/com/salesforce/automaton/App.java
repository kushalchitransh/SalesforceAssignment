package com.salesforce.automaton;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Hello world!
 *
 */
public class App
{
	
	public static void main( String[] args ) throws InterruptedException
	{
		DOMConfigurator.configure("log4j-alternate.xml");
		Logger logger = Logger.getLogger(App.class.getName());
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver", "src/resources/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		logger.info("Driver Initialized");
		driver.get("https://login.salesforce.com/");
		
		WebElement textBoxlogin = driver.findElement(By.xpath("//*[@id='username']"));
		textBoxlogin.clear();
		textBoxlogin.sendKeys("kushalchitransh@gmail.com");
		WebElement textBoxPassword = driver.findElement(By.xpath("//*[@id='password']"));
		textBoxPassword.clear();
		textBoxPassword.sendKeys("Summer@2015");
		WebElement buttonLogin = driver.findElement(By.xpath("//*[@id='Login']"));
		buttonLogin.click();
		// driver.findElement(
		// By.xpath(".//*[@id='oneHeader']/div[2]/span/div[2]/ul/li[9]/span/button"))
		// .click();
		// Thread.sleep(20);
		// driver.findElement(
		// By.xpath(".//*[@href='/ltng/switcher?destination=classic&referrer=%2Flightning%2Fsetup%2FSetupOneHome%2Fhome']"))
		// .click();
		
		if ( !driver.getCurrentUrl().contains("lightning") )
		{
			WebDriverWait waitforlink = new WebDriverWait(driver, 10);
			waitforlink.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@class='switch-to-lightning']"))).click();
			;
		}
		new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@class='bBottom']//div[@class='tooltipTrigger tooltip-trigger uiTooltip']")))).click();
		new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@class='slds-input']")))).sendKeys("Sales ");
		;
		// .//*[@class='container']//input
		new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.xpath("(//*/div[@class='slds-size_small'])[3]")));
		List < WebElement > a = driver.findElements(By.xpath("//div[@class='slds-size_small']/parent::a/parent::one-app-launcher-menu-item"));
		
		for ( WebElement e : a )
		{
			System.out.println(e);
			System.out.println(e.getText());
			
			if ( e.getText().equals("Sales") )
			{
				WebElement test = e;
				test.click();
			}
			
			driver.findElement(By.xpath("//one-app-nav-bar-item-root[@class='navItem slds-context-bar__item slds-shrink-none'][a[span[text()='Accounts")).isDisplayed();
			new WebDriverWait(driver, 40).until(ExpectedConditions.elementToBeClickable(By.xpath("*//a[@href='/lightning/o/Account/home']//following-sibling::one-app-nav-bar-item-dropdown"))).click();
		}
	}
}

/*
 * @Test ( enabled = false ) public void G_ValidateStartAccountPage() {
 * Base.getLogger
 * (className).info("Test started --------------G_ValidateStartAccountPage");
 * try { if ( loginPage.getLblSessionEnd().size() != 0 ) {
 * Base.performKeyboardActions(Base.getDriverInstance(), Keys.ENTER);
 * Base.getDriverInstance().navigate().refresh(); } } catch (Exception e) {
 * System.out.println("The session has timed out"); }
 * Base.getDriverInstance().navigate().refresh();
 * Base.getWaitforelementclickable(Base.getDriverInstance(), 20,
 * landingPage.getBtnAppLauncher()).click();
 * Base.getLogger(className).info("Clicked on app launcher Icon");
 * 
 * landingPage.setTxtSearchApp(Constants.INPUT_SEARCH_TEXT);
 * 
 * Base.getLogger(className).info("Entered text in search app text box"); List <
 * WebElement > searchResults = landingPage.getListSearchResults(); for (
 * WebElement iterator : searchResults ) { if (
 * iterator.getText().equals(Constants.INPUT_SEARCH_TEXT) ) { iterator.click();
 * } } Base.getLogger(className).info("Clicked on the searched text");
 * Assert.assertTrue(salesAppPage.getBtnAccounts().isDisplayed());
 * Base.getLogger(className).info("The user has navigated to Sales Page.");
 * Base.getWaitforelementclickable(Base.getDriverInstance(), 20,
 * salesAppPage.getBtnAccountDropDown());
 * salesAppPage.clickBtnAccountDropdown();
 * Base.getLogger(className).info("Clicked on accounts dropdown");
 * Base.getWaitforelementclickable(Base.getDriverInstance(), 20,
 * salesAppPage.getBtnNewAccount()); salesAppPage.clickBtnNewAccount();
 * Base.getLogger
 * (className).info("Clicked on New Accounts Button in the dropdown");
 * Base.getWaitforelementclickable(Base.getDriverInstance(), 20,
 * accountPage.getLblNewAccountHeader());
 * Assert.assertTrue(accountPage.getLblNewAccountHeader().isDisplayed());
 * Base.getLogger(className).info("New Accounts Screen is visible"); }
 * 
 * 
 * 
 * @Test ( enabled = false ) public void F_ValidateAppChange() {
 * Base.getLogger(className
 * ).info("Test started --------------F_ValidateAppChange"); try { if (
 * loginPage.getLblSessionEnd().size() != 0 ) {
 * Base.performKeyboardActions(Base.getDriverInstance(), Keys.ENTER);
 * Base.getDriverInstance().navigate().refresh(); } } catch (Exception e) {
 * System.out.println("The session has timed out"); }
 * Base.getDriverInstance().navigate().refresh();
 * Base.getWaitforelementclickable(Base.getDriverInstance(), 20,
 * landingPage.getBtnAppLauncher()).click();
 * Base.getLogger(className).info("Clicked on app launcher Icon");
 * 
 * landingPage.setTxtSearchApp(Constants.INPUT_SEARCH_TEXT);
 * 
 * Base.getLogger(className).info("Entered text in search app text box"); List <
 * WebElement > searchResults = landingPage.getListSearchResults(); for (
 * WebElement iterator : searchResults ) { if (
 * iterator.getText().equals(Constants.INPUT_SEARCH_TEXT) ) { iterator.click();
 * } } Base.getLogger(className).info("Clicked on the searched text");
 * Assert.assertTrue(salesAppPage.getBtnAccounts().isDisplayed());
 * 
 * Base.getLogger(className).info("The user has navigated to Sales Page."); }
 */

// try
// {
// if ( loginPage.getLblSessionEnd().size() != 0 )
// {
// Base.performKeyboardActions(Base.getDriverInstance(), Keys.ENTER);
// Base.getDriverInstance().navigate().refresh();
// }
// } catch (Exception e)
// {
// System.out.println("The session has timed out");
// }