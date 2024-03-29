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
 * @author Kushal Shrivastava
 * 
 *         * This class defines the page elements of Accounts page of
 *         salesforce.com. This is created under POM implementation
 *         <p>
 *         Variables appended by txt stands for textbox field type
 *         </p>
 *         <p>
 *         Variables appended by btn stands for button field type
 *         </p>
 *         <p>
 *         Variables appended by lbl stands for label or static text field type
 *         </p>
 */
public class AccountPage
{
	@FindBy ( xpath = ".//div[@data-aura-class='forceDetailPanelDesktop']/article//*[contains(text(),'New Account')]" )
	private WebElement			lblNewAccountHeader;
	
	@FindBy ( xpath = "(.//*[@class='slds-form-element__control']//input)[2]" )
	private WebElement			txtAccountName;
	
	@FindBy ( xpath = ".//*[@class='inlineFooter']//div[@class='button-container-inner slds-float_right']/button[@title='Save']" )
	private WebElement			btnSaveAccount;
	
	@FindBy ( xpath = ( "html/body/div[6]/div/div/div" ) )
	private WebElement			alertAccountCreated;
	
	@FindBy ( xpath = "//*[@class='slds-button slds-button--neutral slds-truncate'][1]/a/div" )
	private WebElement			btnNewContact;
	
	@FindBy ( xpath = ( "//h2[contains(text(),'New Contact')]" ) )
	private WebElement			lblNewContactHeader;
	
	@FindBy ( xpath = ".//*[@placeholder='Last Name']" )
	private WebElement			txtContactLastName;
	
	@FindBy ( xpath = "//*[@class='modal-footer slds-modal__footer']/button[2]" )
	private WebElement			btnSaveContact;
	
	@FindBy ( xpath = "html/body/div[6]/div/div/div/div/div/span" )
	private WebElement			alertContactCreated;
	
	@FindBy ( xpath = "//*[@data-aura-class='forcePageBlockSectionRow'][4]//div[@class='contentWrapper slds-box--border']//ul/li/a//span[@class='pillText']" )
	private WebElement			lblContactAccountName;
	
	@FindBy ( xpath = "(//*/h3)//a" )
	private List < WebElement >	lblListContactsSaved;
	
	@FindBy ( xpath = ".//*[@class='windowViewMode-normal oneContent active lafPageHost']//li[@class='slds-button slds-button--neutral slds-truncate'][2]/a/div" )
	private WebElement			btnNewCase;
	
	@FindBy ( xpath = "//h2[contains(text(),'New Case')]" )
	private WebElement			lblNewCaseHeader;
	
	@FindBy ( xpath = ".//*[@placeholder='Search Contacts...']" )
	private WebElement			txtCaseContactName;
	
	@FindBy ( xpath = ".//*[@class='select']" )
	private WebElement			selectCaseStatus;
	
	@FindBy ( xpath = ".//*[@class='select-options']/ul/li/a" )
	private List < WebElement >	listCaseStatuses;
	
	@FindBy ( xpath = ".//*[@class='listContent']//div[@class='slds-m-left--smalllabels slds-truncate slds-media__body']/div[@class='primaryLabel slds-truncate slds-lookup__result-text']" )
	private List < WebElement >	listCaseContactName;
	
	@FindBy ( xpath = ".//*[@class='uiInput uiInputText uiInput--default uiInput--input']/label/following-sibling::input" )
	private WebElement			txtCaseSubject;
	
	@FindBy ( xpath = ".//textarea" )
	private WebElement			txtAreaCaseDescription;
	
	@FindBy ( xpath = "//*[@class='modal-footer slds-modal__footer']/button[2]" )
	private WebElement			btnSaveCase;
	
	@FindBy ( xpath = "html/body/div[6]/div/div/div/div/div/span/a/div" )
	private WebElement			alertCaseCreated;
	
	public WebElement getAlertCaseCreated()
	{
		return alertCaseCreated;
	}
	
	public String getCaseIdCreated()
	{
		return alertCaseCreated.getAttribute("title");
	}
	
	public WebElement getBtnSaveCase()
	{
		return btnSaveCase;
	}
	
	public void clickBtnSaveCase()
	{
		btnSaveCase.click();
	}
	
	public WebElement getTxtAreaCaseDescription()
	{
		return txtAreaCaseDescription;
	}
	
	public void setTxtAreaCaseDescription( String textAreaCaseDescription )
	{
		txtAreaCaseDescription.clear();
		txtAreaCaseDescription.sendKeys(textAreaCaseDescription);
	}
	
	public WebElement getTxtCaseSubject()
	{
		return txtCaseSubject;
	}
	
	public void setTxtCaseSubject( String textCaseSubject )
	{
		txtCaseSubject.clear();
		txtCaseSubject.sendKeys(textCaseSubject);
	}
	
	public List < WebElement > getListContactName()
	{
		return listCaseContactName;
	}
	
	public List < WebElement > getListCaseStatuses()
	{
		return listCaseStatuses;
	}
	
	public void setListCaseStatuses( List < WebElement > listCaseStatuses )
	{
		this.listCaseStatuses = listCaseStatuses;
	}
	
	public WebElement getSelectCaseStatus()
	{
		return selectCaseStatus;
	}
	
	public void clickSelectCaseStatus()
	{
		selectCaseStatus.click();
	}
	
	public WebElement getTxtCaseContactName()
	{
		return txtCaseContactName;
	}
	
	public void setTxtCaseContactName( String textCaseContactName )
	{
		txtCaseContactName.clear();
		txtCaseContactName.sendKeys(textCaseContactName);
	}
	
	public WebElement getLblNewCaseHeader()
	{
		return lblNewCaseHeader;
	}
	
	public WebElement getBtnNewCase()
	{
		return btnNewCase;
	}
	
	public void clickBtnNewCase()
	{
		btnNewCase.click();
	}
	
	public List < WebElement > getListLblContactsSaved()
	{
		return lblListContactsSaved;
		
	}
	
	public WebElement getLblContactAccountName()
	{
		return lblContactAccountName;
	}
	
	public String getTextLblContactAccountName()
	{
		return lblContactAccountName.getText();
	}
	
	public String getTextLblContactAccountNameAttribute()
	{
		return lblContactAccountName.getAttribute("value");
	}
	
	public WebElement getAlertContactCreated()
	{
		return alertContactCreated;
	}
	
	public String getAlertContactCreatedMessage()
	{
		return alertContactCreated.getText();
	}
	
	public WebElement getBtnSaveContact()
	{
		return btnSaveContact;
	}
	
	public void clickBtnSaveContact()
	{
		btnSaveContact.click();
	}
	
	public WebElement getTxtContactLastName()
	{
		return txtContactLastName;
	}
	
	public String getTxtContactLastNameValue()
	{
		return txtContactLastName.getAttribute("value");
	}
	
	public void setTxtLastName( String lastName )
	{
		txtContactLastName.clear();
		txtContactLastName.sendKeys(lastName);
	}
	
	public WebElement getLblNewontactHeader()
	{
		return lblNewContactHeader;
	}
	
	public WebElement getBtnNewContact()
	{
		return btnNewContact;
	}
	
	public void clickBtnNewContact()
	{
		btnNewContact.click();
	}
	
	public WebElement getAlertAccountCreated()
	{
		return alertAccountCreated;
	}
	
	public String getAlertAccountCreatedMessage()
	{
		return alertAccountCreated.getText();
	}
	
	public WebElement getBtnSaveAccount()
	{
		return btnSaveAccount;
	}
	
	public void clickBtnSaveAccount()
	{
		btnSaveAccount.click();
	}
	
	public WebElement getTxtAccountName()
	{
		return txtAccountName;
	}
	
	public String getTxtAccountNameValue()
	{
		return txtAccountName.getAttribute("value");
	}
	
	public void setTxtAccountName( String inputText )
	{
		txtAccountName.clear();
		txtAccountName.sendKeys(inputText);
		;
	}
	
	public WebElement getLblNewAccountHeader()
	{
		return lblNewAccountHeader;
	}
	
	public AccountPage()
	{
		PageFactory.initElements(Base.getDriver(Constants.INPUT_BROWSER_NAME), this);
	}
}
