package datadriven.Pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import datadriven.Abstractcomponent.AbstractComponent;

public class MiyinfoPageobj extends AbstractComponent{
	WebDriver driver;
	public MiyinfoPageobj(WebDriver driver)
	{
		super(driver);
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//li[6]/a/span")
	//li[6]/a/span
	//span[contains(text(),'My Info')]
	//While page transition text is not loading properly in DOM, so xpath used like that as List Number as '6'.
	// use javascript to load the Html console to load text first and then use the text(),'My Info'
	
	WebElement InfoMenu;
	
	@FindBy(name = "firstName")
	WebElement Empname;
	//Here too we used Absolute Xpath
	//div[1]/div[1]/div/div[2]/input
	//body/div[@id='app']/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/div[2]/div[1]/div[1]/div[1]/div[2]/input[1]
	@FindBy(xpath="//div[1]/div[1]/div/div[2]/input")
	WebElement Empno;
	
	@FindBy(xpath = "//p[@class=\"oxd-text oxd-text--p orangehrm-form-hint\"]/following-sibling::button")
	//div[5]//button[@type='submit']
	
	WebElement Savebtn1;
	
	@FindBy(xpath ="//div[@id='oxd-toaster_1']/div")
	WebElement Toaster;
	
	By toaster = By.xpath("//div[@id='oxd-toaster_1']/div");
	
	public void dashboard_Menu()
	{
		InfoMenu.click();
	}
	
	public String EmpName() throws InterruptedException
	{
		//Value retains the previous name after clearing
		Thread.sleep(10000);
		Empname.click();
		Empname.clear();
		Empname.click();
		Empname.sendKeys("Sathya");
		String Empnamevalue = Empname.getText();
		return Empnamevalue;
	}
	
	public String Empno()
	{
		Empno.click();
		Empno.clear();
		Empno.sendKeys("030");
		String Empnovalue = Empno.getText();
		return Empnovalue;
	}
	
	public String save_btn1() throws InterruptedException
	{
		Thread.sleep(5000);
		Savebtn1.click();
		ElementtobeAppear(toaster);
		String savemsg = Savebtn1.getText();
		System.out.println(savemsg);
		dashboard_Menu();
		return savemsg;
	}
	
	public void Employee_operation() throws InterruptedException
	{
		dashboard_Menu();
		EmpName();
		Empno();
		
		
	}
	
	

}
