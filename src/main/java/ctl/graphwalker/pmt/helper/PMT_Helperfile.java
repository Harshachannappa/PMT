package ctl.graphwalker.pmt.helper;

import org.graphwalker.core.machine.ExecutionContext;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class PMT_Helperfile extends ExecutionContext  {

	public void BaseUrl() {
		Helper.getInstance().get("http://10.140.0.99:2010/T2-T3Code/jsp/logon.jsp");
		Helper.getInstance().manage().window().maximize();
		Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[starts-with(text(),'User Name')]")));
	}
	
	
	public void Login_validcredentials() {
		Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.name("cuid"))).sendKeys("stiru");		
		Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@value='Login']"))).click();
		
		System.out.println("Entered the credentials");
		Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[text()='Project']")));
		
	}
	
	public void Login_SQAcredentials() {
		Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.name("cuid"))).sendKeys("AA64405");		
		Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@value='Login']"))).click();
		
		System.out.println("Entered the credentials");
		Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[text()='Project']")));
		
	}
	
	public void Login_Directorcredentials() {
		Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.name("cuid"))).sendKeys("nrmarik");		
		Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@value='Login']"))).click();
		
		System.out.println("Entered the credentials");
		Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[text()='Project']")));
		
	}
	
	
	public void hover2Projecttab() {
		Helper.mouseHover(Helper.getInstance().findElement(By.xpath(".//*[text()='Project']")));
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
	}
	
	public void SearchProjectScreen() {
		Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[text()='Create/Search Project']"))).click();
		
		Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.name("Create")));
		
	}
	
	public void CreateProjectscreen(){
		Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.name("Create"))).click();	
		Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@value=\"Submit\"]")));
	}
	
	public void e_houver2Logout_copy() {
		
		
		
		
	}

	
	public void PMTLogout() {
	
		Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@alt='logout']"))).click();
		Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='Logged Out Successfully']")));
		
		//Assert.assertEquals("Logged Out Successfully", Helper.getInstance().findElement(By.xpath("//*[text()='Logged Out Successfully']")));

	}
	
	public void PMTProject_Status() {
		Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[text()='Pending Process Status']")));
		
			
			if(Helper.getInstance().findElement(By.xpath("(.//*[text()='test_demo_145'])[1]/following-sibling::td[2]")).getText().trim().contains("SQA")){
				PMTLogout();
				BaseUrl();
				Login_SQAcredentials();
				
			} else if(Helper.getInstance().findElement(By.xpath("(.//*[text()='test_demo_145'])[1]/following-sibling::td[2]")).getText().trim().contains("DIRECTOR")){
				PMTLogout();
				BaseUrl();
				Login_Directorcredentials();
			}
	}

	
}
