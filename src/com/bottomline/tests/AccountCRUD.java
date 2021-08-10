package com.bottomline.tests;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.bottomline.common.Fundamental;
import com.bottomline.pages.Account;

//Basic operations for account module, ADD EDIT DELETE
public class AccountCRUD extends Fundamental {

	Account account;

	@Parameters({ "Account Type", "Account ID", "Bank Number", "Account Name", "Currency", "Account Number", "IBAN",
			"Status", "Bank ID", "Company ID", "Account Label Name", "Bank Branch Name", "Child Account ID",
			"Project Name" })
	@Test(priority = 1)
	public void Add(String accountType, String accountID, String bankAccountNumber, String accountName, String currency,
			String accountNumber, String iban, String status, String bankID, String companyID, String accountLabelName,
			String bankBranchName, String childAccountID, String projectName) {

		account = new Account(driver);
		account.Navigate();
		account.Add(accountType, accountID, bankAccountNumber, accountName, currency, accountNumber, iban, status,
				bankID, companyID, accountLabelName, bankBranchName, childAccountID, projectName);

		Assert.assertEquals(account.obj.Toast, "Successfully Added");
	}

	@Test(priority = 2)
	public void Edit() {
		System.out.println("Editing account " + account.obj.AccountID_Value);
		account.Edit(account.obj.AccountID_Value);
		Assert.assertEquals(account.obj.Toast, "Successfully Updated");
	}

	@Test(priority = 3)
	public void Delete() {
		System.out.println("Deleting account " + account.obj.AccountID_Value);
		account.Delete(account.obj.AccountID_Value);
		Assert.assertEquals(account.obj.Toast, "Successfully Deleted");
	}
}
