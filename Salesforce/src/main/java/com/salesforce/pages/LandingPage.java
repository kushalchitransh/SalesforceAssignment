/**
 * 
 */
package com.salesforce.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.salesforce.automaton.Base;
import com.salesforce.automaton.Constants;

/**
 * * This class defines the page elements of Landing page of salesforce.com.
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
 */
public class LandingPage {

	@FindBy(xpath = "//*[@title='Setup']")
	private WebElement       lblSetup;

	@FindBy(xpath = ".//*[@id='oneHeader']/div[2]/span/div[2]/ul/li[9]/span/button")
	private WebElement       btnViewProfile;

	@FindBy(xpath = ".//*[@href='/ltng/switcher?destination=classic&referrer=%2Flightning%2Fsetup%2FSetupOneHome%2Fhome']")
	private WebElement       linkSwitchToClassic;

	@FindBy(xpath = ".//*[@class='switch-to-lightning']")
	private WebElement       linkSwitchToLightening;

	@FindBy(xpath = ".//*[@class='bBottom']//div[@class='tooltipTrigger tooltip-trigger uiTooltip']")
	private WebElement       btnAppLauncher;

	@FindBy(xpath = ".//*[@class='container']//input")
	private WebElement       txtSearchApp;

	@FindBy(xpath = "//div[@class='slds-size_small']/parent::a/parent::one-app-launcher-menu-item")
	private List<WebElement> listSearchResults;

	@FindBy(xpath = "//*[@href='/secur/logout.jsp']")
	private WebElement       linkLogout;

	public WebElement getLinkLogout() {
		return linkLogout;
	}

	public void ClickLinkLogout() {
		linkLogout.click();
	}

	public List<WebElement> getListSearchResults() {
		return listSearchResults;
	}

	public List<String> getSearchResult() {
		List<WebElement> searchResultlist = listSearchResults;
		List<String> search = new ArrayList<String>();
		for (WebElement iterator : searchResultlist) {
			search.add(iterator.getText());
		}
		return search;
	}

	public WebElement getBtnAppLauncher() {
		return btnAppLauncher;
	}

	public void setTxtSearchApp(String searchText) {
		txtSearchApp.clear();
		txtSearchApp.sendKeys(searchText);
	}

	public String getTxtSearchApp() {
		return txtSearchApp.getAttribute("value");
	}

	public void clickBtnAppLauncher() {
		btnAppLauncher.click();
	}

	public void clickLinkSwitchToLightening() {
		linkSwitchToLightening.click();
	}

	public WebElement getLinkSwitchToLightening() {
		return linkSwitchToLightening;
	}

	public void setLinkSwitchToLightening(WebElement linkSwitchToLightening) {
		this.linkSwitchToLightening = linkSwitchToLightening;
	}

	public void clickLinkSwitchToClassic() {
		linkSwitchToClassic.click();
	}

	public WebElement getLinkSwitchToClassic() {
		return linkSwitchToClassic;
	}

	public void setLinkSwitchToClassic(WebElement linkSwitchToClassic) {
		this.linkSwitchToClassic = linkSwitchToClassic;
	}

	public void clickBtnViewProfile() {
		btnViewProfile.click();
	}

	public WebElement getBtnViewProfile() {
		return btnViewProfile;
	}

	public void setBtnViewProfile(WebElement btnViewProfile) {
		this.btnViewProfile = btnViewProfile;
	}

	public WebElement getLblSetup() {
		return lblSetup;
	}

	public String getLblSetuptext() {
		return lblSetup.getText();
	}

	public LandingPage() {
		PageFactory.initElements(Base.getDriver(Constants.INPUT_BROWSER_NAME),
		        this);
	}

}
