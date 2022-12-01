package Resource;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Basic {
	WebDriver driver;
	public Properties prop;
public WebDriver intializeDriver() throws IOException {
	 prop=new Properties();
	String proppath = System.getProperty("user.dir")+"\\src\\main\\java\\Resource\\data.properties";
	FileInputStream fis=new FileInputStream(proppath);
	prop.load(fis);
	String browser=prop.getProperty("browser");
	if(browser.equalsIgnoreCase("chrome")) {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		
	}
	else if(browser.equalsIgnoreCase("firefox")) {
		WebDriverManager.firefoxdriver().setup();
		driver=new FirefoxDriver();
	}else if(browser.equalsIgnoreCase("IE")) {
		WebDriverManager.edgedriver().setup();
		driver=new InternetExplorerDriver();
	}
	driver.manage().window().maximize();
	//driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	return driver;
	
}
public String takescreenshot(String testName,WebDriver driver) throws IOException {
	File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	String path = System.getProperty("user.dir")+"\\Screenshots\\"+testName+".png";
	FileUtils.copyFile(src, new File(path));
	return path;
}


}
