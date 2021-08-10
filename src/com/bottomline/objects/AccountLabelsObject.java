package com.bottomline.objects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountLabelsObject {

	@FindBy(xpath = "//label[contains(.,'Account Group Label (optional)')]/parent::div//*/button[text() = 'Select']")
	public WebElement AccountGroupLabel;

	@FindBy(xpath = "//label[contains(.,'Account Label Name')]/parent::div//*/input")
	public WebElement AccountLabelName;

	@FindBy(xpath = "//label[contains(.,'Interest Type')]/parent::div//*/input")
	public WebElement InterestType;

	@FindBy(xpath = "//*/button[@type='button' and @class='btn btn-sm dx-btn ']")
	public WebElement SelectAccountGroupLabelID;

	@FindBy(xpath = "//div/button[text() = 'Add']/img")
	public WebElement Add;

	@FindBy(xpath = "//div[@class='tx-grid-toolbar d-inline-flex']//img[contains(@src,'edit')]")
	public WebElement Edit;

	@FindBy(xpath = "//div[@class='tx-grid-toolbar d-inline-flex']//img[contains(@src,'delete')]")
	public WebElement Delete;

	@FindBy(xpath = "//button[@type='submit']")
	public WebElement Save;

	@FindBy(xpath = "//table[@class='dxbs-table table table-bordered table-sm dxbs-fixed']/tbody/tr/td[1]")
	public WebElement FirstRow;

	@FindBy(xpath = "//div[@role='toolbar']/div[@role='group']/button")
	public WebElement ToggleFilter;

	public int Random;
	public String AccountLabelName_Value;
	public String Toast;
	public List<String> ValidationMessages;

}
