package com.bottomline.tests;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.bottomline.common.Functions;
import com.bottomline.common.Fundamental;
import com.bottomline.common.Randoms;
import com.bottomline.pages.Account;
import com.bottomline.pages.Login;

//Basic operations for account module, ADD EDIT DELETE
public class AccountCRUD extends Fundamental {

	

	@Parameters({ "Account Type", "Account ID", "Bank Number", "Account Name", "Currency", "Account Number", "IBAN",
			"Status", "Bank ID", "Company ID", "Account Label Name", "Bank Branch Name", "Child Account ID",
			"Project Name" })

	@Test
	public void Add(String accountType, String accountID, String bankAccountNumber, String accountName, String currency,
			String accountNumber, String iban, String status, String bankID, String companyID, String accountLabelName,
			String bankBranchName, String childAccountID, String projectName) {

		Login login = new Login(driver);
		Account account = new Account(driver);
		
		String defaultUsername = Functions.GetProperty("DefaultUsername");
		String defaultPassword = Functions.GetProperty("DefaultPassword");

		login.login(defaultUsername, defaultPassword);
		account.Navigate();
		account.Add(accountType, accountID, bankAccountNumber, accountName, currency, accountNumber, iban, status,
				bankID, companyID, accountLabelName, bankBranchName, childAccountID, projectName);

		Assert.assertEquals(account.obj.Toast, "Successfully Added");
	}

	@Parameters({ "Account ID" })
	@Test
	public void Edit(String accountID) {
		Login login = new Login(driver);
		Account account = new Account(driver);
		
		String defaultUsername = Functions.GetProperty("DefaultUsername");
		String defaultPassword = Functions.GetProperty("DefaultPassword");
		login.login(defaultUsername, defaultPassword);
		account.Navigate();
		account.Edit(accountID);
		Assert.assertEquals(account.obj.Toast, "Successfully Updated");
	}

	@Test
	public void Delete(String accountID) {

	}
}
