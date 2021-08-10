package com.bottomline.tests;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.bottomline.common.Fundamental;
import com.bottomline.pages.AccountGroupLabels;

public class AccountGroupLabelsCRUD extends Fundamental {

	AccountGroupLabels accountGroupLabels;

	@Parameters({"Account Group Label"})
	@Test(priority = 1)
	public void Add(String accountGroupLabel) {
		accountGroupLabels = new AccountGroupLabels(driver);
		accountGroupLabels.Navigate();
		accountGroupLabels.Add(accountGroupLabel);
		Assert.assertEquals(accountGroupLabels.obj.Toast, "Successfully Added");
	}

	@Test(priority = 2)
	public void Edit() {
		System.out.println("Editing account " + accountGroupLabels.obj.AccountGroupLabelName_Value);
		accountGroupLabels.Edit(accountGroupLabels.obj.AccountGroupLabelName_Value);
		Assert.assertEquals(accountGroupLabels.obj.Toast, "Successfully Updated");
	}

	@Test(priority = 3)
	public void Delete() {
		System.out.println("Deleting account " + accountGroupLabels.obj.AccountGroupLabelName_Value);
		accountGroupLabels.Delete(accountGroupLabels.obj.AccountGroupLabelName_Value);
		Assert.assertEquals(accountGroupLabels.obj.Toast, "Successfully Deleted");
	}

}
