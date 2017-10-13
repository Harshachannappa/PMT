package ctl.graphwalker.pmt.modelImpl;

import org.graphwalker.core.machine.ExecutionContext;
import org.graphwalker.java.annotation.AfterElement;
import org.graphwalker.java.annotation.AfterExecution;
import org.graphwalker.java.annotation.BeforeElement;
import org.graphwalker.java.annotation.BeforeExecution;
import org.graphwalker.java.annotation.GraphWalker;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import ctl.graphwalker.pmt.helper.Helper;
import ctl.graphwalker.pmt.test.LoginDirector;

@GraphWalker(value = "random(edge_coverage(100))", start = "e_Init")

public class LoginDirectorimpl extends ExecutionContext implements LoginDirector{
	
	@Override
	public void v_BaseUrl() {
		
	/*	Helper.getInstance().get("http://10.140.0.99:2010/T2-T3Code/jsp/logon.jsp");
		
		Helper.getInstance().manage().window().maximize();*/
		
		System.out.println("Done with launching the Application");
		
	}
	
	
	public void e_StartClient() {
	//	Helper.alertwindow();
		
Helper.getInstance().get("http://10.140.0.99:2010/T2-T3Code/jsp/logon.jsp");
		
		Helper.getInstance().manage().window().maximize();
		
		System.out.println("Done with launching the Application");
		
		System.out.println("Done handling any pop-up");
		
		
	}
	
	@Override
	public void v_LoginPrompted() {
		// TODO Auto-generated method stub
		
		
		System.out.println("Login page is displayed");
	}

	
		
		
		@Override
		public void e_ValidDirectorCredentials() {
			// TODO Auto-generated method stub		
			
			//Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.name("cuid"))).clear();
			Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.name("cuid"))).sendKeys("nrmarik");
			//Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.name("password"))).sendKeys("Ctli@075");
			Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@value='Login']"))).click();
			
			System.out.println("Entered the credentials");
			
		}		
	
		
		
		@Override
		public void v_Home() {
			// TODO Auto-generated method stub
			Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[text()='Project']")));
			System.out.println("We are at the Home page");
		}


		@Override
		public void e_Init() {
			// TODO Auto-generated method stub
			Helper.getInstance();
		}

	

}
