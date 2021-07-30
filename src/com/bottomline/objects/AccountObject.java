package com.bottomline.objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountObject {

	public int RandomNumber;

	public String AccountID_Value;

	public String Toast;

	@FindBy(xpath = "//div/button[text() = 'Add']/img")
	public WebElement Add;

	@FindBy(xpath = "//div[@class='tx-grid-toolbar d-inline-flex']//img[contains(@src,'edit')]")
	public WebElement Edit;

	@FindBy(xpath = "//div[@class='tx-grid-toolbar d-inline-flex']//img[contains(@src,'delete')]")
	public WebElement Delete;

	@FindBy(xpath = "//button[@type='submit'][text()='Save']")
	public WebElement Save;

	@FindBy(xpath = "//div[@role='toolbar']/div[@role='group']/button")
	public WebElement ToggleFilter;

	@FindBy(xpath = "//label[text() = 'Account Type']/..//div[@class='input-group-append']")
	public WebElement AccountType;

	@FindBy(xpath = "//label[text() = 'Account Id']//following-sibling::div//input")
	public WebElement AccountID;

	@FindBy(xpath = "//label[text() = 'Bank Account Number']//following-sibling::div//input")
	public WebElement BankAccountNumber;

	@FindBy(xpath = "//label[text() = 'Account Name']//following-sibling::div//input")
	public WebElement AccountName;

	@FindBy(xpath = "//label[text() = 'Currency']//following-sibling::div//input")
	public WebElement Currency;

	@FindBy(xpath = "//label[text() = 'Account Number']//following-sibling::div//input")
	public WebElement AccountNumber;

	@FindBy(xpath = "//label[text() = 'IBAN Number']//following-sibling::div//input")
	public WebElement IBAN;

	@FindBy(xpath = "//label[text() = 'Status']//following-sibling::div//input")
	public WebElement Status;

	@FindBy(xpath = "//label[text() = 'Bank']//following-sibling::div[@class='row']//button[text()='Select']")
	public WebElement Bank;

	@FindBy(xpath = "//label[text() = 'Company']//following-sibling::div[@class='row']//button[text()='Select']")
	public WebElement Company;

	@FindBy(xpath = "//label[text() = 'Accounts Label']//following-sibling::div[@class='row']//button[text()='Select']")
	public WebElement AccountsLabel;

	@FindBy(xpath = "//label[text() = 'Bank Branch']//following-sibling::div[@class='row']//button[text()='Select']")
	public WebElement BankBranch;

	@FindBy(xpath = "//label[text() = 'Child Account Number']//following-sibling::div[@class='row']//button[text()='Select']")
	public WebElement ChildAccountNumber;

	@FindBy(xpath = "//label[text() = 'Project']//following-sibling::div[@class='row']//button[text()='Select']")
	public WebElement Project;

}
