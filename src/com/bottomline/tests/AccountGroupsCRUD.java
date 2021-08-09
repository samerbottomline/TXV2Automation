package com.bottomline.tests;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.bottomline.common.Fundamental;
import com.bottomline.pages.AccountGroups;

public class AccountGroupsCRUD extends Fundamental {

	AccountGroups accountGroups;

	@Parameters({ "Account Group Name" })
	@Test(priority = 1)
	public void Add(String accountGroupName) {
		accountGroups = new AccountGroups(driver);
		accountGroups.Navigate();
		accountGroups.Add(accountGroupName);
		Assert.assertEquals(accountGroups.obj.Toast, "Successfully Added");
	}

	@Test(priority = 2)
	public void Edit() {
		System.out.println("Editing account group " + accountGroups.obj.AccountGroupName_Value);
		
		accountGroups.Edit(accountGroups.obj.AccountGroupName_Value);
		Assert.assertEquals(accountGroups.obj.Toast, "Successfully Updated");
	}

	@Test(priority = 3)
	public void Delete() {
		System.out.println("Deleting account " + accountGroups.obj.AccountGroupName_Value);
		
		accountGroups.Delete(accountGroups.obj.AccountGroupName_Value);
		Assert.assertEquals(accountGroups.obj.Toast, "Successfully Deleted");
	}
}
