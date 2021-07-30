package com.bottomline.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import com.bottomline.common.Base;
import com.bottomline.loging.Report;
import com.bottomline.objects.LoginObject;

//Login page used to authenticate to our version 2 application

public class Login extends Base {

	LoginObject obj = new LoginObject();

	//Report report = new Report(Login.class);

	public Login(WebDriver driver) {
		super(driver);
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 30);
		PageFactory.initElements(factory, obj);
	}

	public void login(String username, String password) {
		WaitForLoad(10,5);
		//report.Info("writing username: " + username);
		Write(obj.username, username);

		//report.Info("writing password: " + password);
		Write(obj.password, password);

		//report.Info("clicking login button");
		Click(obj.loginButton);
	}
}
