package com.bottomline.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import com.bottomline.common.Base;
import com.bottomline.common.Functions;
import com.bottomline.common.Randoms;
import com.bottomline.objects.AccountObject;
import com.google.common.base.Function;

public class Account extends Base {

	public AccountObject obj = new AccountObject();
	WebDriver driver;

	public Account(WebDriver driver) {
		super(driver);
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 30);
		PageFactory.initElements(factory, obj);
		this.driver = driver;
	}

	public void Navigate() {
		System.out.println("Navigating to accounts page");
		Administration admin = new Administration(driver);
		admin.Navigate("Accounts");
	}

	public AccountObject Add(String accountType, String accountID, String bankAccountNumber, String accountName,
			String currency, String accountNumber, String iban, String status, String bankID, String companyID,
			String accountLabelName, String bankBranchName, String parentAccountID, String projectName) {
		int timeout = 5;
		System.out.println("Clicking add");
		// add new
		Click(obj.Add, timeout);

		System.out.println("click account type and select");
		Click(obj.AccountType, timeout);
		SelectFromPopupGrid("Account Type", "Account Type Name", accountType, timeout);

		System.out.println("write account id");
		obj.AccountID_Value = Write(obj.AccountID, accountID + Randoms.ID(), timeout);
		System.out.println("new account id: " + obj.AccountID_Value);

		System.out.println("write bank account number");
		Write(obj.BankAccountNumber, bankAccountNumber, timeout);

		System.out.println("write account name");
		Write(obj.AccountName, accountName, timeout);

		System.out.println("selecting from dropdown currency");
		DropDown("Currency", currency, timeout);

		System.out.println("writing account number");
		Write(obj.AccountNumber, accountNumber, timeout);

		System.out.println("writing iban");// IBAN
		Write(obj.IBAN, iban, timeout);

		System.out.println("dropdown status");// status
		DropDown("Status", status, timeout);

		System.out.println("selecting bank");// bank
		Click(obj.Bank, timeout);
		SelectFromPopupGrid("Bank", "Bank ID", bankID, timeout);

		System.out.println("selecting company");
		Click(obj.Company, timeout);
		SelectFromPopupGrid("Company", "Company Id", companyID, timeout);

		System.out.println("selecting account label");
		Click(obj.AccountsLabel, timeout);
		SelectFromPopupGrid("Accounts Label", "Account Label Name", accountLabelName, timeout);

		System.out.println("selecting bank branc");
		Click(obj.BankBranch, timeout);
		SelectFromPopupGrid("Bank Branch", "Bank Branch Name", bankBranchName, timeout);

		System.out.println("selecting project");
		Click(obj.Project, timeout);
		SelectFromPopupGrid("Project", "Project Name", projectName, timeout);

		System.out.println("selecting parent account");
		Click(obj.ParentAccount, timeout);
		SelectFromPopupGrid("Parent Account", "Account Id", parentAccountID, timeout);

		System.out.println("clicking save");
		Click(obj.Save, timeout);

		System.out.println("getting toast message");
		obj.Toast = GetToastMsg();

		return obj;

	}

	public AccountObject Edit(String accountID) {

		int timeout = 5;

		if (!Search("Account Id", accountID, 5)) {
			return obj;
		}

		Click(obj.Edit, timeout);

		Clear(obj.AccountID);
		obj.AccountID_Value = Write(obj.AccountID, Randoms.ID(), 5);
		System.out.println("new EDITED account id: " + obj.AccountID_Value);
		Click(obj.Save, 3);
		obj.Toast = GetToastMsg();

		return obj;

	}

	public AccountObject Delete(String accountID) {

		int timeout = 5;

		if (!Search("Account Id", accountID, 5)) {
			return obj;
		}

		Click(obj.Delete, timeout);

		ConfirmDelete(true);

		obj.Toast = GetToastMsg();

		return obj;

	}

}
