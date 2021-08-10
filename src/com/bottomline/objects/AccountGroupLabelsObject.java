package com.bottomline.objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountGroupLabelsObject {

	@FindBy(xpath = "AccountGroup")
	public WebElement URN;

	@FindBy(xpath = "//label[text()='Account Group Label Name']/parent::div/div[@class='tx-textbox-input']//*/input")
	public WebElement AccountGroupLabelName;

	@FindBy(xpath = "//div/button[text() = 'Add']/img")
	public WebElement Add;

	@FindBy(xpath = "//div[@class='tx-grid-toolbar d-inline-flex']//img[contains(@src,'edit')]")
	public WebElement Edit;

	@FindBy(xpath = "//div[@class='tx-grid-toolbar d-inline-flex']//img[contains(@src,'delete')]")
	public WebElement Delete;

	@FindBy(xpath = "//button[@type='submit']")
	public WebElement Save;

	public String Toast;
	public String AccountGroupLabelName_Value;
}
