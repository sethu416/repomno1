package Pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {
WebDriver driver;
public LandingPage(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver, this);
}
@FindBy(xpath="//a[@title='My Account']")
WebElement myaccountdropdown;
@FindBy(xpath="//a[normalize-space()='Login']")
WebElement loginoption;
public WebElement myaccountdropdown() {
	return myaccountdropdown;
}
public WebElement loginoption() {
	return loginoption;
}
}
