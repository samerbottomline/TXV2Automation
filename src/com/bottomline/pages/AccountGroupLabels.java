package com.bottomline.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import com.bottomline.common.Base;
import com.bottomline.common.Randoms;
import com.bottomline.objects.AccountGroupLabelsObject;

public class AccountGroupLabels extends Base {

	public AccountGroupLabelsObject obj = new AccountGroupLabelsObject();
	WebDriver driver;
	int timeout = 5;

	public AccountGroupLabels(WebDriver driver) {
		super(driver);
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 30);
		PageFactory.initElements(factory, obj);
		this.driver = driver;
	}

	public void Navigate() {
		System.out.println("Navigating to account group label page");
		Administration admin = new Administration(driver);
		admin.Navigate("Account Group Labels");
	}

	public void Add(String accountGroupLabel) {
		accountGroupLabel = Randoms.CompanyIndustry();
		Click(obj.Add, timeout);
		Write(obj.AccountGroupLabelName, accountGroupLabel, timeout);
		obj.AccountGroupLabelName_Value = GetValue(obj.AccountGroupLabelName);
		Click(obj.Save, timeout);
		obj.Toast = GetToastMsg();
	}

	public void Edit(String accountGroupLabelName) {

		if (!Search("Account Group Label Name", accountGroupLabelName, timeout)) {
			obj.Toast = accountGroupLabelName + "not found";
			return;
		}

		Click(obj.Edit, timeout);
		Clear(obj.AccountGroupLabelName);
		Write(obj.AccountGroupLabelName, accountGroupLabelName += "_edited", timeout);
		obj.AccountGroupLabelName_Value = GetValue(obj.AccountGroupLabelName);
		Click(obj.Save, timeout);
		obj.Toast = GetToastMsg();
	}

	public void Delete(String accountGroupLabelName) {
		if (!Search("Account Group Label Name", accountGroupLabelName, timeout)) {
			obj.Toast = accountGroupLabelName + " not found";
			return;
		}

		Click(obj.Delete, timeout);
		ConfirmDelete(true);
		obj.Toast = GetToastMsg();
	}
}
