package tests;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Pageobjects.Accountpage;
import Pageobjects.LandingPage;
import Pageobjects.Loginpage;
import Resource.Basic;

public class LogiTest extends Basic {
	WebDriver driver;
	Logger log;
@Test(dataProvider="getlogindata")	
public void login(String email,String password,String expectedstatus) throws IOException  {
	 
	LandingPage landingpage=new LandingPage(driver);
	log.debug("the myaacount got  opened");
	landingpage.myaccountdropdown().click();
	log.debug("myaccount page got clicked");
	landingpage.loginoption().click();
	log.debug("login button got clicked");
	Loginpage loginpage=new Loginpage(driver);
	log.debug("login page got luanched");
	loginpage.emailaddress().sendKeys(email);
	log.debug("the email got entered");
	loginpage.password().sendKeys(password);
	log.debug("the password got entered");
	loginpage.loginbutton().click();
	log.debug("the login button got clicked");
	Accountpage account=new Accountpage(driver);
	log.debug("the accountpage got launched");
	String actualresult=null;
try {
	if(account.accountpage().isDisplayed()) {
		actualresult="successful";
		log.debug("the page is successfull");
	}
}catch(Exception e) {
	actualresult="failure";
	log.debug("the account got failed");
}
Assert.assertEquals(actualresult,expectedstatus);
	log.debug("the page are equal");
}
@BeforeMethod
public void openapplication() throws IOException {
	log = LogManager.getLogger(LogiTest.class.getName());
	driver= intializeDriver();
	log.debug("Browser got launched");
	driver.get(prop.getProperty("url"));
	log.debug("the url got luanche");
}
@AfterMethod
public void closure() {
	log.debug("the page got closed");
	driver.close();
	
}
@DataProvider
public Object[][] getlogindata(){
	Object[][] data= {{"sethuram416@gmail.com","Sethu@416","successful"}};
	return data;

}
}