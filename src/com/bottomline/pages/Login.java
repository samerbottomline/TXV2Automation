package com.bottomline.pages;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import com.bottomline.common.Base;
import com.bottomline.objects.LoginObject;

//Login page used to authenticate to our version 2 application

public class Login extends Base {

	LoginObject obj = new LoginObject();

	// Report report = new Report(Login.class);

	public Login(WebDriver driver) {
		super(driver);
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 30);
		PageFactory.initElements(factory, obj);
	}

	public void login(String username, String password) {
		WaitForLoad(10);

		if (AlreadySignedIn()) {
			return;
		}

		// report.Info("writing username: " + username);
		Write(obj.username, username, 10);

		// report.Info("writing password: " + password);
		Write(obj.password, password, 10);

		// report.Info("clicking login button");
		Click(obj.loginButton, 10);
	}

	private Boolean AlreadySignedIn() {
		try {
			// WaitForLoad(7);

			if (GetCurrentURL().contains("https://qa-automation-auth.treasuryxpress.com/Account/Login?ReturnUrl=")) {
				return false;
			}

			return WaitForVisibility(obj.usernameInitials, 3);
		} catch (TimeoutException e) {
			return false;
		}
	}
}
