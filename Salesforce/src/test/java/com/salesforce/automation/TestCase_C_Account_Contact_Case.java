package com.salesforce.automation;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.salesforce.automaton.Base;
import com.salesforce.automaton.Constants;
import com.salesforce.pages.AccountPage;
import com.salesforce.pages.LandingPage;
import com.salesforce.pages.LoginPage;
import com.salesforce.pages.SalesAppPage;

public class TestCase_C_Account_Contact_Case
{
	LoginPage		loginPage;
	LandingPage		landingPage;
	SalesAppPage	salesAppPage;
	AccountPage		accountPage;
	String			className		= TestCase_C_Account_Contact_Case.class.getName();
	String			accountName		= Base.generateName("Account");
	String			contactlastName	= Base.generateName("Contact");
	String			caseSubject		= Base.generateName("CaseSubject");
	String			caseDescription	= Base.generateName("CaseDescription");
	String			caseId			= null;
	
	@BeforeClass
	public void InitializePage()
	{
		loginPage = new LoginPage();
		landingPage = new LandingPage();
		salesAppPage = new SalesAppPage();
		accountPage = new AccountPage();
		Base.getImplicitWait(20);
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
		// Use this when want the code t be run before every test
	}
	
	@Test
	public void F_ValidateAppChange()
	{
		Base.getLogger(className).info("Test started --------------F_ValidateAppChange");
		
		Base.getDriverInstance().navigate().refresh();
		Base.getWaitforelementclickable(Base.getDriverInstance(), 20, landingPage.getBtnAppLauncher()).click();
		Base.getLogger(className).info("Clicked on app launcher Icon");
		
		landingPage.setTxtSearchApp(Constants.INPUT_SEARCH_TEXT);
		
		Base.getLogger(className).info("Entered text in search app text box");
		List < WebElement > searchResults = landingPage.getListSearchResults();
		for ( WebElement iterator : searchResults )
		{
			if ( iterator.getText().equals(Constants.INPUT_SEARCH_TEXT) )
			{
				iterator.click();
			}
		}
		Base.getLogger(className).info("Clicked on the searched text");
		Assert.assertTrue(salesAppPage.getBtnAccounts().isDisplayed());
		Base.getLogger(className).info("The user has navigated to Sales Page.");
	}//
		//
	
	@Test
	public void G_ValidateAccountCreation()
	{
		Base.getLogger(className).info("Test started --------------G_ValidateAccountCreation");
		
		Base.getWaitforelementclickable(Base.getDriverInstance(), 20, salesAppPage.getBtnAccountDropDown());
		salesAppPage.clickBtnAccountDropdown();
		Base.getLogger(className).info("Clicked on accounts dropdown");
		//
		//
		Base.getWaitforelementclickable(Base.getDriverInstance(), 20, salesAppPage.getBtnNewAccount());
		salesAppPage.clickBtnNewAccount();
		Base.getLogger(className).info("Clicked on New Accounts Button in the dropdown");
		//
		//
		Base.getWaitforelementclickable(Base.getDriverInstance(), 20, accountPage.getLblNewAccountHeader());
		Assert.assertTrue(accountPage.getLblNewAccountHeader().isDisplayed());
		Base.getLogger(className).info("New Accounts Screen is visible");
		//
		//
		Base.getWaitforelementclickable(Base.getDriverInstance(), 20, accountPage.getTxtAccountName());
		// String accountName = Base.generateName("Account");
		accountPage.setTxtAccountName(accountName);
		Base.getLogger(className).info("Entered Account Name :" + accountName);
		//
		//
		Base.getWaitforelementclickable(Base.getDriverInstance(), 20, accountPage.getBtnSaveAccount());
		accountPage.clickBtnSaveAccount();
		Base.getLogger(className).info("Clicked Save Button");
		//
		//
		Base.getWaitforelementclickable(Base.getDriverInstance(), 20, accountPage.getAlertAccountCreated());
		Assert.assertTrue(accountPage.getAlertAccountCreatedMessage().contains(accountName));
		Base.getLogger(className).info("Verified the account is created Successfully and the message as well");
	}
	
	@Test
	public void H_ValidateContactCreation() throws InterruptedException
	{
		Base.getLogger(className).info("Test started --------------H_ValidateContactCreation");
		Thread.sleep(5000);
		Base.getWaitforelementclickable(Base.getDriverInstance(), 30, accountPage.getBtnNewContact());
		accountPage.clickBtnNewContact();
		Base.getLogger(className).info("Clicked on New Contact Button");
		//
		//
		Assert.assertTrue(accountPage.getLblNewontactHeader().isDisplayed());
		Base.getLogger(className).info("New Contact Screen is visible");
		//
		//
		Base.getWaitforelementclickable(Base.getDriverInstance(), 20, accountPage.getTxtContactLastName());
		// String lastName = Base.generateName("Contact");
		accountPage.setTxtLastName(contactlastName);
		Base.getLogger(className).info("Entered New Contact Last Name :" + contactlastName);
		//
		//
		Base.getWaitforelementclickable(Base.getDriverInstance(), 20, accountPage.getLblContactAccountName());
		Assert.assertTrue(accountPage.getTextLblContactAccountName().contains(accountName));
		Base.getLogger(className).info("Verified the account name exists against the account field");
		//
		//
		Base.getWaitforelementclickable(Base.getDriverInstance(), 20, accountPage.getBtnSaveContact());
		accountPage.clickBtnSaveContact();
		Base.getLogger(className).info("Saved New Contact");
		//
		//
		Base.getWaitforelementclickable(Base.getDriverInstance(), 20, accountPage.getAlertContactCreated());
		Assert.assertTrue(accountPage.getAlertContactCreatedMessage().contains(contactlastName));
		Base.getLogger(className).info("Verified the Contact is created Successfully and the message as well");
		//
		//
		List < WebElement > contacts = accountPage.getListLblContactsSaved();
		for ( WebElement contact : contacts )
		{
			if ( contact.getText().equals(contactlastName) )
				Assert.assertTrue( ( contact.getText().contains(contactlastName) ));
		}
		Base.getLogger(className).info("Verified the contact created successfully by checking the related  tab  contact option ");
		
	}
	
	@Test
	public void I_ValidateCaseCreation() throws InterruptedException
	{
		Base.getLogger(className).info("Test started --------------I_ValidateCaseCreation");
		Thread.sleep(6000);
		// Base.getWait(Base.getDriverInstance(),
		// 20).until(ExpectedConditions.stalenessOf(accountPage.getAlertContactCreated()));
		Base.getWaitforelementclickable(Base.getDriverInstance(), 30, accountPage.getBtnNewCase());
		accountPage.clickBtnNewCase();
		Base.getLogger(className).info("Clicked on New Case Button");
		//
		//
		Base.getWait(Base.getDriverInstance(), 20).until(ExpectedConditions.visibilityOf(accountPage.getLblNewCaseHeader()));
		Assert.assertTrue(accountPage.getLblNewCaseHeader().isDisplayed());
		Base.getLogger(className).info("New Case Screen is visible");
		//
		//
		Base.getWaitforelementclickable(Base.getDriverInstance(), 20, accountPage.getTxtCaseContactName());
		accountPage.setTxtCaseContactName(contactlastName);
		Base.getLogger(className).info("Entered Contact Last Name : " + contactlastName);
		//
		//
		Base.getWaitforelementclickable(Base.getDriverInstance(), 20, accountPage.getListContactName().get(0));
		List < WebElement > contactList = accountPage.getListContactName();
		for ( WebElement iterator : contactList )
		{
			if ( iterator.getText().equals(contactlastName) )
			{
				iterator.click();
			}
		}
		Base.getLogger(className).info("Selected Contact Last Name : " + contactlastName);
		//
		//
		accountPage.clickSelectCaseStatus();
		List < WebElement > statusList = accountPage.getListCaseStatuses();
		for ( WebElement iterator : statusList )
		{
			if ( iterator.getText().equals(Constants.INPUT_CASE_STATUS) )
			{
				iterator.click();
			}
		}
		Base.getLogger(className).info("Selected Case Status : " + Constants.INPUT_CASE_STATUS);
		//
		// //
		Base.getWaitforelementclickable(Base.getDriverInstance(), 20, accountPage.getTxtCaseSubject());
		accountPage.setTxtCaseSubject(caseSubject);
		Base.getLogger(className).info("Entered Case Subject : " + caseSubject);
		//
		//
		
		Base.getWaitforelementclickable(Base.getDriverInstance(), 20, accountPage.getTxtAreaCaseDescription());
		accountPage.setTxtAreaCaseDescription(caseDescription);
		Base.getLogger(className).info("Entered Case Subject : " + caseDescription);
		//
		//
		Base.getWaitforelementclickable(Base.getDriverInstance(), 20, accountPage.getBtnSaveCase());
		accountPage.clickBtnSaveCase();
		Base.getLogger(className).info("Clicked Case Save Button");
		//
		//
		Base.getWaitforelementclickable(Base.getDriverInstance(), 20, accountPage.getAlertCaseCreated());
		caseId = ( accountPage.getCaseIdCreated() );
		Assert.assertTrue(accountPage.getAlertCaseCreated().isDisplayed());
		Base.getLogger(className).info(" Verified the case created successfully by checking the alert and Case iD saved :"
				+ caseId);
	}
	
	@AfterTest
	public void closeBrowser()
	{
		// Base.closeWindow();
	}
	
}
