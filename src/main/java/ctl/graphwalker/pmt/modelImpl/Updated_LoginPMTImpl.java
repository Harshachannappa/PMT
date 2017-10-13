package ctl.graphwalker.pmt.modelImpl;

import org.graphwalker.core.machine.ExecutionContext;
import org.graphwalker.java.annotation.GraphWalker;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import ctl.graphwalker.pmt.helper.Helper;
import ctl.graphwalker.pmt.test.Updated_LoginPMT;

@GraphWalker(value = "random(edge_coverage(100))", start = "e_Init")

public class Updated_LoginPMTImpl extends ExecutionContext implements Updated_LoginPMT{

	
	public void v_Home() {
		
		Assert.assertTrue("Not in Home Page", Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[text()='Project']"))).isDisplayed());
		
	}

	
	public void e_Logout() {
			Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@alt='logout']"))).click();
		
			
			
			Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='Logged Out Successfully']")));
			
			WebElement logmessage=Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='Logged Out Successfully']")));
			String expectedtext="Logged Out Successfully";
			String Actualtxt=logmessage.getText();
			Assert.assertEquals(Actualtxt, expectedtext);
		
	}

	
	public void v_LoginPrompted() {
		//validate the login page of application	
		
		String Usernamefield = Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[starts-with(text(),'User Name')]"))).getText().trim();
		String passwordfield = Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[starts-with(text(),'Password')]"))).getText().trim();
		Assert.assertTrue("User Field not found!", Usernamefield.contains("User Name (CUID)"));
		Assert.assertTrue("Password Field not found!", passwordfield.contains("Password (LDAP)"));
	}

	
	public void v_BaseUrl() {
		Helper.getInstance().get("http://10.140.0.99:2010/T2-T3Code/jsp/logon.jsp");
		Helper.getInstance().manage().window().maximize();
		Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[starts-with(text(),'User Name')]")));
	}

	
	public void e_StartClient() {
		// TODO Auto-generated method stub
		
	}

	
	public void e_Init() {
		Helper.getInstance();
		
	}

	
	public void e_Valid_Manager_Credentials() {
		Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.name("cuid"))).sendKeys("nrmarik");		
		Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@value='Login']"))).click();
		
		System.out.println("Entered the credentials");
		Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[text()='Project']")));
		
		// Add Negative sceanrio to handle this
	}

	
	public void e_InvalidCredentials() {
		Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.name("cuid"))).sendKeys("123654");		
		Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@value='Login']"))).click();
		Assert.assertEquals("Invalid CUID/Password",Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='Invalid CUID/Password']"))).getText());
	}

}
