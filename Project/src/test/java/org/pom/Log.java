package org.pom;

import org.base.Baseclasss;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Log extends Baseclasss {
	public Log() {
		PageFactory.initElements(driver, this);
	}
	@FindBy(id="Username")
	WebElement user;
	
	@FindBy(id="Password")
	WebElement passwd;
	
	@FindBy(id="btnLoginClick")
	WebElement loging;

	public WebElement getUser() {
		return user;
	}

	public WebElement getPasswd() {
		return passwd;
	}

	public WebElement getLoging() {
		return loging;
	}
	
	

}
