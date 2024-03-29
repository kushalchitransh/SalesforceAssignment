/**
 * 
 */
package com.salesforce.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.salesforce.automaton.Base;
import com.salesforce.automaton.Constants;

/**
 * This class defines the page elements of Login page of salesforce.com. This is
 * created under POM implementation
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
public class LoginPage {

	@FindBy(id = "username")
	private WebElement       txtUserName;

	@FindBy(id = "password")
	private WebElement       txtPassword;

	@FindBy(id = "Login")
	private WebElement       btnLogin;

	@FindBy(id = "error")
	private WebElement       lblInvalidLogin;

	@FindBy(xpath = "(//*[contains(text(),'Your session has ended')])[2]")
	private List<WebElement> lblSessionEnd;

	public List<WebElement> getLblSessionEnd() {
		return lblSessionEnd;
	}

	public WebElement getLblInvalidLogin() {
		return lblInvalidLogin;
	}

	public LoginPage() {
		PageFactory.initElements(Base.getDriver(Constants.INPUT_BROWSER_NAME),
		        this);
	}

	public void setTxtUsername(String text) {
		txtUserName.clear();
		txtUserName.sendKeys(text);
	}

	public String getTxtUserName() {
		return txtUserName.getAttribute("value");
	}

	public void setTxtPassword(String text) {
		txtPassword.clear();
		txtPassword.sendKeys(text);
	}

	public String getTxtPassword() {
		return txtPassword.getAttribute("value");
	}

	public void clickBtnLogin() {
		btnLogin.click();
	}

	public String getLblInvalidLogintext() {
		return lblInvalidLogin.getText();
	}

	public void setLblInvalidLogin(WebElement lblInvalidLogin) {
		this.lblInvalidLogin = lblInvalidLogin;
	}
}
