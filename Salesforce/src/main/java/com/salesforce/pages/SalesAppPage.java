/**
 * 
 */
package com.salesforce.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.salesforce.automaton.Base;
import com.salesforce.automaton.Constants;

/**
 * This class defines the page elements of Sales App page of salesforce.com.
 * This is created under POM implementation
 * <p>
 * Variables appended by txt stands for textbox field type
 * </p>
 * <p>
 * Variables appended by btn stands for button field type
 * </p>
 * <p>
 * Variables appended by lbl stands for label or static text field type
 * </p>
 * 
 * @author Kushal Shrivastava
 *
 */
public class SalesAppPage {

	@FindBy(xpath = "//one-app-nav-bar-item-root[@class='navItem slds-context-bar__item slds-shrink-none'][a[span[text()='Accounts']]]")
	private WebElement btnAccounts;

	@FindBy(xpath = "*//a[@href='/lightning/o/Account/home']//following-sibling::one-app-nav-bar-item-dropdown")
	private WebElement btnAccountDropDown;

	@FindBy(xpath = "//*[contains(text(),'New Account')]/parent::span/parent::a/parent::one-app-nav-bar-menu-item")
	private WebElement btnNewAccount;

	public WebElement getBtnNewAccount() {
		return btnNewAccount;
	}

	public void clickBtnNewAccount() {
		btnNewAccount.click();
	}

	public WebElement getBtnAccountDropDown() {
		return btnAccountDropDown;
	}

	public void clickBtnAccountDropdown() {
		btnAccountDropDown.click();
	}

	public void clickBtnAccounts() {
		btnAccounts.click();
	}

	public SalesAppPage() {
		PageFactory.initElements(Base.getDriver(Constants.INPUT_BROWSER_NAME),
		        this);
	}

	public WebElement getBtnAccounts() {
		return btnAccounts;
	}

}
