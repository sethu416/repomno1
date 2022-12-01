package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import Resource.Basic;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Testthree extends Basic {
	@Test
	public void test3() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://tutorialsninja.com/demo/index.php?route=common/home");
		Thread.sleep(3000);
		driver.close();
	}
}
