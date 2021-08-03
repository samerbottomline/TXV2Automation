package com.bottomline.pages;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import com.bottomline.common.Base;
import com.bottomline.objects.AccountObject;

public class Account extends Base {

	public AccountObject obj = new AccountObject();
	WebDriver driver;
	static Logger log = LogManager.getLogger(Account.class);;

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
		
		System.out.println("Clicking add");
		//add new
		Click(obj.Add);
		
		
		System.out.println("click account type and select");
		Click(obj.AccountType);
		SelectFromPopupGrid("Account Type", "Account Type Name", accountType);

		System.out.println("write account id");
		Write(obj.AccountID, accountID);

		System.out.println("write bank account number");
		Write(obj.BankAccountNumber, bankAccountNumber);

		System.out.println("write account name");
		Write(obj.AccountName, accountName);

		System.out.println("selecting from dropdown currency");
		DropDown("Currency", currency);

		System.out.println("writing account number");
		Write(obj.AccountNumber, accountNumber);

		System.out.println("writing iban");// IBAN
		Write(obj.IBAN, iban);

		System.out.println("dropdown status");// status
		DropDown("Status", status);

		System.out.println("selecting bank");// bank
		Click(obj.Bank);
		SelectFromPopupGrid("Bank", "Bank ID", bankID);

		System.out.println("selecting company");
		Click(obj.Company);
		SelectFromPopupGrid("Company", "Company Id", companyID);

		System.out.println("selecting account label");
		Click(obj.AccountsLabel);
		SelectFromPopupGrid("Accounts Label", "Account Label Name", accountLabelName);

		System.out.println("selecting bank branc");
		Click(obj.BankBranch);
		SelectFromPopupGrid("Bank Branch", "Bank Branch Name", bankBranchName);

		System.out.println("selecting parent account");
		Click(obj.ParentAccount);
		SelectFromPopupGrid("Parent Account", "Account Id", parentAccountID);

		System.out.println("selecting project");
		Click(obj.Project);
		SelectFromPopupGrid("Project", "Project Name", projectName);

		System.out.println("clicking save");
		Click(obj.Save);
		
		System.out.println("getting toast message");
		obj.Toast = GetToastMsg();

		return obj;

	}

}
