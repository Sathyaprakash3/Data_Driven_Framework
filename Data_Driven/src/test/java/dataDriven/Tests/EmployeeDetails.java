package dataDriven.Tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import datadriven.Pageobjects.MiyinfoPageobj;
import testComponents.Test_Base;

public class EmployeeDetails extends Test_Base{
	@Test
	public void Employee_operations() throws InterruptedException
	{
		MiyinfoPageobj info = landpage.loginapplication("Admin", "admin123");
		Thread.sleep(5000);
		//String savemsg = info.save_btn1();
		info.dashboard_Menu();
		String empname = info.EmpName();
		String empno = info.Empno();
		String savemsg1 = info.save_btn1();
		info.dashboard_Menu();
		//Assert.assertEquals("Sathya", empname);
		//Assert.assertEquals("030", empno);
		Assert.assertEquals(savemsg1,"Success");
		
	}
	
	

}
