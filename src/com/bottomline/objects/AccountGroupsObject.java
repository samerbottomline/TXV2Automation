package com.bottomline.objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountGroupsObject {

	@FindBy(xpath = "//div[@role='toolbar']/div[@role='group']/button")
	public WebElement ToggleFilter;

	@FindBy(xpath = "//div/button[text() = 'Add']")
	public WebElement Add;

	@FindBy(xpath = "//div[@class='tx-grid-toolbar d-inline-flex']//img[contains(@src,'edit')]")
	public WebElement Edit;

	@FindBy(xpath = "//div[@class='tx-grid-toolbar d-inline-flex']//img[contains(@src,'delete')]")
	public WebElement Delete;

	@FindBy(xpath = "//button[@type='submit']")
	public WebElement Save;

	@FindBy(xpath = "//button[contains(.,'View Accounts')]")
	public WebElement ViewAccounts;

	@FindBy(xpath = "//a[@id='navbarDropdownMenuLink'][text() = 'Administration']")
	public WebElement Administration_Button;

	@FindBy(xpath = "//a[@id='navbarDropdownMenuLink'][text() = 'Administration']/../div/a[text() = 'Account Groups']")
	public WebElement AccountGroups_Button;

	@FindBy(xpath = "//label[text()='Account Group Name']/parent::div/div[@class='tx-textbox-input']//*/input")
	public WebElement AccountGroupName;

	public String Toast;
	public String AccountGroupName_Value;
}