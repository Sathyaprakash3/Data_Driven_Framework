package dataDriven.Tests;

import org.testng.annotations.Test;

import junit.framework.Assert;
import testComponents.Test_Base;

public class Login extends Test_Base{
	@Test
	public void login_Errorvalidation()
	{
		landpage.loginapplication("error", "admin123");
		String loginerror = landpage.loginError();
		Assert.assertEquals("Invalid credentials", loginerror);
		String color = landpage.login_Color();
		Assert.assertEquals("#eb0910", color);
	}

}
