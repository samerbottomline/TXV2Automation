package com.bottomline.objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AdministrationObject {

	@FindBy(xpath = "//li[@class='dropdown-setting']/a[@class='dropdown-toggle'][@id='navbarDropdownMenuLink']")
	public WebElement DropdownToggle;

	@FindBy(xpath = "//a[contains(@class,'dropdown-item') and text()='Administration']")
	public WebElement DropdownItem;

	@FindBy(xpath = "//a")
	public WebElement ModuleLinks;

	public WebElement GetModuleLink(String module) {
		WebElement ModuleLink = ModuleLinks.findElement(By.xpath("//a[text() ='" + module + "']"));
		return ModuleLink;
	}

	public WebElement GetSectionTitleExpand(String module) {
		WebElement SectionTitleExpand = ModuleLinks.findElement(By.xpath("//a[text() ='" + module + "']/ancestor::li/a[@class='parent-link']"));
		return SectionTitleExpand;
	}

}
