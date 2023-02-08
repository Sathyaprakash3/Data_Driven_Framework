package datadriven.Pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import datadriven.Abstractcomponent.AbstractComponent;

public class LandingpageObjects extends AbstractComponent{
	WebDriver driver;
	public LandingpageObjects(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="username")
	WebElement userName;
	@FindBy(name="password")
	WebElement passWord;
	@FindBy(xpath="//button[@type='submit']")
	WebElement submitBtn;
	@FindBy(xpath = "//p[@class='oxd-text oxd-text--p oxd-alert-content-text']")
	WebElement LoginError;
	
	public MiyinfoPageobj loginapplication(String username, String password)
	{
		userName.sendKeys(username);
		passWord.sendKeys(password);
		submitBtn.click();
		MiyinfoPageobj myinfo = new MiyinfoPageobj(driver);
		return myinfo;
	}
	
	public String loginError()
	{
		String errormsg = LoginError.getText();
		return errormsg;
	}
	
	public String login_Color()
	{
		String s = LoginError.getCssValue("color");
		System.out.println(s);
		String col = Color.fromString(s).asHex();
		System.out.println(col);
		return col;
	}

}
