package Pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Accountpage {
WebDriver driver ;
public Accountpage(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver,this);
	
}
@FindBy(linkText="Edit your account information")
WebElement accountpage;
public WebElement accountpage() {
	return accountpage;
}
}
