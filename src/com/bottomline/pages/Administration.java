package com.bottomline.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import com.bottomline.common.Base;
import com.bottomline.objects.AdministrationObject;

public class Administration extends Base {

	AdministrationObject obj = new AdministrationObject();

	public Administration(WebDriver driver) {
		super(driver);
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 30);
		PageFactory.initElements(factory, obj);
	}

	public void Navigate(String module) {

		Click(obj.DropdownToggle, 5);
		Click(obj.DropdownItem, 5);

		// if anchor not found after 5 seconds, means there is a sub menu, will expand
		// and search again
		if (!Click(obj.GetModuleLink(module), 5))// make it wait for 5 seconds)
		{
			// expanding to reveal nested link
			Click(obj.GetSectionTitleExpand(module), 5);
			Click(obj.GetModuleLink(module), 5);
		}
	}
}
