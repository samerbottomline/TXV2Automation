package com.bottomline.tests;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.bottomline.common.Fundamental;
import com.bottomline.pages.AccountLabels;

public class AccountLabelsCRUD extends Fundamental {

	AccountLabels accountLabels;

	@Parameters({ "Account Label Name", "Interest Type", "Account Group Label ID" })
	@Test(priority = 1)
	public void Add(String accountLabelName, String interestType, String accountGroupLabelID) {
		accountLabels = new AccountLabels(driver);
		accountLabels.Navigate();
		accountLabels.Add(accountLabelName, interestType, accountGroupLabelID);
		Assert.assertEquals(accountLabels.obj.Toast, "Successfully Added");
	}

	@Test(priority = 2)
	public void Edit() {
		accountLabels.Edit(accountLabels.obj.AccountLabelName_Value, null, null);
		Assert.assertEquals(accountLabels.obj.Toast, "Successfully Updated");
	}

	@Test(priority = 3)
	public void Delete() {
		accountLabels.Delete(accountLabels.obj.AccountLabelName_Value);
		Assert.assertEquals(accountLabels.obj.Toast, "Successfully Deleted");
	}

}
