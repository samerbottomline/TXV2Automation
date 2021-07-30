package com.bottomline.objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginObject {
	@FindBy(id="user-name")
	public WebElement username;
	
	@FindBy(id="Password")
	public WebElement password;
	
	@FindBy(xpath="//*/button[@value='login']")
	public WebElement loginButton;
}
