package tests;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import Resource.Basic;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Testfour extends Basic{
	public WebDriver driver;

	@Test
	public void test4() throws InterruptedException {
		System.out.println("this is the first change");
		WebDriverManager.chromedriver().setup();
		
		 driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://tutorialsninja.com/demo/index.php?route=common/home");
		System.out.println("this is the third chnage");
		Thread.sleep(3000);
		Assert.assertTrue(false);
	}
	@AfterMethod
	public void closure() {
		driver.close();
}
}