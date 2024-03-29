package com.salesforce.automation;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.salesforce.automaton.Base;
import com.salesforce.automaton.Constants;
import com.salesforce.pages.AccountPage;
import com.salesforce.pages.LandingPage;
import com.salesforce.pages.LoginPage;
import com.salesforce.pages.SalesAppPage;

public class TestCase_B_Salesforce_CheckUI
{
	LoginPage		loginPage;
	LandingPage		landingPage;
	SalesAppPage	salesAppPage;
	AccountPage		accountPage;
	String			className	= TestCase_B_Salesforce_CheckUI.class.getName();
	
	@BeforeClass
	public void InitializePage()
	{
		loginPage = new LoginPage();
		landingPage = new LandingPage();
		salesAppPage = new SalesAppPage();
		accountPage = new AccountPage();
		Base.getLogger(className).info("Browser initialized......");
		Base.openUrl(Constants.URL_SALESFORCELOGIN);
		loginPage.setTxtUsername(Constants.INPUT_USERNAME);
		loginPage.setTxtPassword(Constants.INPUT_PASSWORD);
		loginPage.clickBtnLogin();
		Base.getLogger(className).info("Logged In Successfully....");
		
		Base.performKeyboardActions(Base.getDriverInstance(), Keys.ENTER);
	}
	
	@BeforeMethod
	public void initializeURL()
	{
		
	}
	
	@Test ( enabled = true )
	public void D_ValidateLandingPageIsLightening()
	{
		Base.getLogger(className).info("Test started --------------D_ValidateLandingPageIsLightening");
		Base.getDriverInstance().navigate().refresh();
		String url = Base.getCurrentBrowserURL();
		Assert.assertTrue(url.contains(Constants.URL_SALESFORCELIGHTENING), "The loanding page is open in lightening mode");
		Base.getLogger(className).info("The page loaded in Salesforce landing page is in LighteningMode.");
	}
	
	@Test ( enabled = true )
	public void E_ValidateSwitchToLightening() throws Exception
	{
		Base.getLogger(className).info("Test started --------------E_ValidateSwitchToLightening");
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
		Base.getDriverInstance().navigate().refresh();
		Base.getWaitforelementclickable(Base.getDriverInstance(), 20, landingPage.getBtnViewProfile());
		landingPage.clickBtnViewProfile();
		Base.getLogger(className).info("Clicked on View Profile Icon ");
		Base.getWaitforelementclickable(Base.getDriverInstance(), 20, landingPage.getLinkSwitchToClassic());
		landingPage.clickLinkSwitchToClassic();
		Base.getLogger(className).info("Clicked on 'Switch to Salesforce Classic'");
		Assert.assertTrue(Base.getCurrentBrowserURL().contains(Constants.URL_SALESFORCESTANDARD));
		Base.getLogger(className).info("User has moved to Standard Mode of salesforce.");
		Base.getWaitforelementclickable(Base.getDriverInstance(), 20, landingPage.getLinkSwitchToLightening());
		landingPage.clickLinkSwitchToLightening();
		Base.getLogger(className).info("Clicked on 'Switch to lightening experience' link.");
		Base.getWaitforelementclickable(Base.getDriverInstance(), 20, landingPage.getBtnViewProfile());
		if ( !landingPage.getBtnViewProfile().isDisplayed() )
		{
			if ( loginPage.getLblSessionEnd().size() != 0 )
			{
				Base.performKeyboardActions(Base.getDriverInstance(), Keys.ENTER);
				Base.getDriverInstance().navigate().refresh();
			}
		}
		Assert.assertTrue(Base.getCurrentBrowserURL().contains(Constants.URL_SALESFORCELIGHTENING));
		Base.getLogger(className).info("User is navigated back to landing page in lightening mode.");
		
		Base.getWaitforelementclickable(Base.getDriverInstance(), 20, landingPage.getBtnViewProfile());
		landingPage.clickBtnViewProfile();
		Base.getWaitforelementclickable(Base.getDriverInstance(), 20, landingPage.getLinkLogout());
		landingPage.ClickLinkLogout();
		
	}
	
	@AfterClass
	public void closeBrowser()
	{
		// Base.closeWindow();
	}
}
