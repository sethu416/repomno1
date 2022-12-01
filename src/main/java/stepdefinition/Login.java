package stepdefinition;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import Pageobjects.Accountpage;
import Pageobjects.LandingPage;
import Pageobjects.Loginpage;
import Resource.Basic;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Login extends Basic {
	WebDriver driver;
	Loginpage loginpage;
@Given("^Open any Browser$")	
public void Open_any_Browser() throws IOException {
	driver=intializeDriver();
}
@And("^Navigate to loginpage$")
public void  Navigate_to_loginpage() throws InterruptedException {
	driver.get(prop.getProperty("url"));
	LandingPage landingpage=new LandingPage(driver);
	landingpage.myaccountdropdown().click();
	landingpage.loginoption().click();
	Thread.sleep(2000);
	
}
@When("^user enters username as \"([^\"]*)\" and password as \"([^\"]*)\"$")
public void user_enters_username_as_someemail_and_password_as_somepassword(String email,String password) {
	 loginpage=new Loginpage(driver);
	loginpage.emailaddress().sendKeys(email);
	loginpage.password().sendKeys(password);
}
@And("^user clicks on login button$")
public void user_clicks_on_login_button() {
	loginpage.loginbutton().click();
}
@Then("^verify user is able to successfully login$")
public void verify_user_is_able_to_successfully_login() {
	Accountpage account=new Accountpage(driver);
	Assert.assertTrue(account.accountpage().isDisplayed());
}
@After
public void closure() {
	driver.close();
}

}
