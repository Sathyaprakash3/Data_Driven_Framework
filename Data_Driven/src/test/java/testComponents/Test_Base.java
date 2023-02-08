package testComponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import datadriven.Pageobjects.LandingpageObjects;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Test_Base {
	public WebDriver driver;
	public LandingpageObjects landpage;
	public WebDriver DriverInitalize() throws IOException
	{
	//FileInputStream fis = new FileInputStream(System.getProperty("C:\\Users\\DELL\\eclipse-workspace\\Data_Driven\\src\\main\\java\\datadriven\\Resources\\config.properties"));
	//Properties prop = new Properties();
	//prop.load(fis);
	//String browserName = System.getProperty("browser");
	String browserName = "Chrome";
	//String url = System.getProperty("URL");
	String url = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
	if(browserName.equalsIgnoreCase("Chrome"))
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}
	driver.manage().window().maximize();
	driver.get(url);
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	return driver;
		
	}
	
	@BeforeTest(alwaysRun=true)
	public LandingpageObjects Launchapplication() throws IOException
	{
		driver = DriverInitalize();
		landpage = new LandingpageObjects(driver);
		//landpage.loginapplication("Admin", "admin123");
		return landpage;
		
	}
	
	public void screeshot(String testcaseName) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File file = new File(System.getProperty("user.dir") + "//reports//" + testcaseName + ".png");
		FileUtils.copyFile(file, source);
	}
	
	/*
	 * @AfterTest public void teardown() { driver.quit(); }
	 */
	
	public static void main(String Args[]) throws IOException
	{
		Test_Base test = new Test_Base();
		//test.teardown();
	}
	

}
