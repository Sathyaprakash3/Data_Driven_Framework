import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class dynamic_xpath {
	public WebDriver driver;
	public void dynamic()
	{
	WebDriverManager.chromedriver().setup();
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://leafground.com/list.xhtml");
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	List<WebElement> xpaths = driver.findElements(By.xpath("//span[@class='product-price']"));
	List<Double> check = new ArrayList<Double>();
	List<Integer> num = new ArrayList<Integer>();
	for(WebElement dy : xpaths)
	{
		//System.out.println(dy.getText());
		String values = dy.getText().replace("$", "");
		double i = Double.parseDouble(values);
		int numvalue = (int)i;
		//System.out.println(i);
		//System.out.println(values);
		num.add(numvalue);
		
	}
	int minvalue = Collections.min(num);
	System.out.println(minvalue);

}
	
	public static void main(String Args[])
	{
		dynamic_xpath dx= new dynamic_xpath();
		dx.dynamic();
	}
}