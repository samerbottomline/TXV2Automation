package com.bottomline.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import com.bottomline.common.Base;
import com.bottomline.objects.AccountObject;

public class Account extends Base {

	AccountObject obj = new AccountObject();
	WebDriver driver;

	public Account(WebDriver driver) {
		super(driver);
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 30);
		PageFactory.initElements(factory, obj);
		this.driver = driver;
	}

	public void Navigate() {
		Administration admin = new Administration(driver);
		admin.Navigate("Accounts");
	}

	public AccountObject Add(String accountType, String accountID, String bankAccountNumber, String accountName,
			String currency, String accountNumber, String iban, String status, String bankID, String companyID,
			String accountLabelName, String bankBranchName, String childAccountID, String projectName) {

		Click(obj.Add);

		// filling account type
		Click(obj.AccountType);
		SelectFromPopupGrid("Account Type", "Account Type Name", accountType);

		// account id
		Write(obj.AccountID, accountID);

		// bank account number
		Write(obj.BankAccountNumber, bankAccountNumber);
		// account name
		Write(obj.AccountName, accountName);
		// currency
		Write(obj.Currency, currency);
		// account number
		Write(obj.AccountNumber, accountNumber);
		// IBAN
		Write(obj.IBAN, iban);
		// status
		Write(obj.Status, status);

		return obj;

	}

}
