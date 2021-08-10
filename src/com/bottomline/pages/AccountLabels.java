package com.bottomline.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import com.bottomline.common.Base;
import com.bottomline.common.Randoms;
import com.bottomline.objects.AccountLabelsObject;

public class AccountLabels extends Base {

	public AccountLabelsObject obj = new AccountLabelsObject();
	WebDriver driver;
	int timeout = 5;

	public AccountLabels(WebDriver driver) {
		super(driver);
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 30);
		PageFactory.initElements(factory, obj);
		this.driver = driver;
	}

	public void Navigate() {
		System.out.println("Navigating to account labels page");
		Administration admin = new Administration(driver);
		admin.Navigate("Account Labels");
	}

	public void Add(String accountLabelName, String interestType, String accountGroupLabel) {
		accountLabelName = Randoms.CompanyIndustry();

		Click(obj.Add, timeout);

		DropDown("Interest Type", interestType, timeout);

		Write(obj.AccountLabelName, accountLabelName, timeout);
		obj.AccountLabelName_Value = GetValue(obj.AccountLabelName);
		Click(obj.Save, timeout);

		obj.ValidationMessages = GetValidationMessages();
		obj.Toast = GetToastMsg();
	}

	public void Edit(String accountLabelName, String interestType, String accountGroupLabel) {

		if (!Search("Account Label Name", accountLabelName, timeout)) {
			obj.Toast = "No data found searching for " + accountLabelName;
			return;
		}

		Click(obj.Edit, timeout);
		Clear(obj.AccountLabelName);
		Write(obj.AccountLabelName, obj.AccountLabelName_Value += "_edited", timeout);
		obj.AccountLabelName_Value = GetValue(obj.AccountLabelName);

		if (interestType != null) {

			Clear(obj.InterestType);
			Write(obj.InterestType, interestType, timeout);
		}

		if (accountGroupLabel != null) {

			Clear(obj.AccountGroupLabel);
			Write(obj.AccountGroupLabel, accountGroupLabel, timeout);
		}
		
		Click(obj.Save, timeout);
		obj.Toast = GetToastMsg();
	}

	public void Delete(String accountLabelName) {

		if (Search("Account Label Name", accountLabelName, timeout)) {
			Click(obj.Delete, timeout);
			ConfirmDelete(true);

			obj.Toast = GetToastMsg();
		} else {
			obj.Toast = "Nothing found when searching for " + accountLabelName;
		}
	}

}
