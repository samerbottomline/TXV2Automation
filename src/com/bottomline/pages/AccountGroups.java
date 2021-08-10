package com.bottomline.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import com.bottomline.common.Base;
import com.bottomline.common.Randoms;
import com.bottomline.objects.AccountGroupsObject;

public class AccountGroups extends Base {

	public AccountGroupsObject obj = new AccountGroupsObject();
	WebDriver driver;
	int timeout = 5;

	public AccountGroups(WebDriver driver) {
		super(driver);
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 30);
		PageFactory.initElements(factory, obj);
		this.driver = driver;
	}

	public void Navigate() {
		System.out.println("Navigating to account groups page");
		Administration admin = new Administration(driver);
		admin.Navigate("Account Groups");
	}

	public void Add(String accountGroupName) {

		Click(obj.Add, timeout);
		Write(obj.AccountGroupName, accountGroupName + ' ' + Randoms.ID(), timeout);
		obj.AccountGroupName_Value = GetValue(obj.AccountGroupName);

		Click(obj.Save, timeout);
		obj.Toast = GetToastMsg();
	}

	public void Edit(String accountGroupName) {
		if (!Search("Account Group Name", accountGroupName, timeout)) {
			obj.Toast = accountGroupName + " not found";
			return;
		}

		Click(obj.Edit, timeout);
		Clear(obj.AccountGroupName);
		Write(obj.AccountGroupName, accountGroupName + "_edited", timeout);
		obj.AccountGroupName_Value = GetValue(obj.AccountGroupName);

		Click(obj.Save, timeout);
		obj.Toast = GetToastMsg();
	}

	public void Delete(String accountGroupName) {

		if (!Search("Account Group Name", accountGroupName, timeout)) {
			obj.Toast = accountGroupName + " not found";
			return;
		}

		Click(obj.Delete, timeout);
		ConfirmDelete(true);
		obj.Toast = GetToastMsg();
	}

	public void OpenAccountGroupOptions(String accountGroupName) {
		Search("Account Group Name", accountGroupName, timeout);
		Click(obj.ViewAccounts, timeout);
	}
}
