package ctl.graphwalker.pmt.modelImpl;

import org.graphwalker.core.machine.ExecutionContext;
import org.graphwalker.java.annotation.GraphWalker;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import ctl.graphwalker.pmt.helper.Helper;
import ctl.graphwalker.pmt.test.Test1;

@GraphWalker(value = "random(edge_coverage(100))", start = "e_Init")

public class Test11Impl extends ExecutionContext implements Test1{

	@Override
	public void e_Init() {
		Helper.getInstance();
		
	}
	
	@Override
	public void v_BaseUrl() {
		Helper.getInstance().get("http://10.140.0.99:2010/T2-T3Code/jsp/logon.jsp");
		Helper.getInstance().manage().window().maximize();
		Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[starts-with(text(),'User Name')]")));
		
	}
	
	@Override
	public void e_StartClient() {
		Assert.assertEquals("http://10.140.0.99:2010/T2-T3Code/jsp/logon.jsp",Helper.getInstance().getCurrentUrl());
		
	}
	
	@Override
	public void v_LoginPrompted() {
		String Usernamefield = Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[starts-with(text(),'User Name')]"))).getText().trim();
		String passwordfield = Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[starts-with(text(),'Password')]"))).getText().trim();
		Assert.assertTrue("User Field not found!", Usernamefield.contains("User Name (CUID)"));
		Assert.assertTrue("Password Field not found!", passwordfield.contains("Password (LDAP)"));
		
	}

	@Override
	public void e_InvalidCredentials() {
		Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.name("cuid"))).sendKeys("123654");		
		Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@value='Login']"))).click();
		Assert.assertEquals("Invalid CUID/Password",Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='Invalid CUID/Password']"))).getText());
		
	}
	
	@Override
	public void e_Valid_Manager_Credentials() {
		Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.name("cuid"))).sendKeys("nrmarik");		
		Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@value='Login']"))).click();
		
		System.out.println("Entered the credentials");
		Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[text()='Project']")));
		
	}


	
	@Override
	public void v_Home() {
		Assert.assertTrue("Not in Home Page", Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[text()='Project']"))).isDisplayed());
		
	}


	@Override
	public void e_hover2Projecttab() {
		Helper.mouseHover(Helper.getInstance().findElement(By.xpath(".//*[text()='Project']")));
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
	}



	@Override
	public void v_CreatePMTProject() {
		Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[text()='Create/Search Project']"))).click();
		
		Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.name("Create"))).click();
		Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@value=\"Submit\"]")));
	}

	


	

	
}
