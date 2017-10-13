package ctl.graphwalker.pmt.modelImpl;

import org.graphwalker.core.machine.ExecutionContext;
import org.graphwalker.java.annotation.GraphWalker;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import ctl.graphwalker.pmt.helper.Helper;
import ctl.graphwalker.pmt.test.Secondapprovalloggin;

@GraphWalker(value = "random(edge_coverage(100))")
public class SecondapprovallogginImpl extends ExecutionContext implements Secondapprovalloggin{

	@Override
	public void v_Home() {
		Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[text()='Project']")));
		System.out.println("We are at the Home page");
		
	}

	@Override
	public void e_ValidDirectorCredentials() {
		Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.name("cuid"))).sendKeys("nrmarik");
		//Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.name("password"))).sendKeys("Ctli@075");
		Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@value='Login']"))).click();
		
		System.out.println("Entered the credentials");
		
	}

	@Override
	public void v_LoginPrompted() {
		System.out.println("Login page is displayed");
		
	}

	@Override
	public void v_BaseUrl() {
	Helper.getInstance().get("http://10.140.0.99:2010/T2-T3Code/jsp/logon.jsp");
		
		//Helper.getInstance().manage().window().maximize();
		
		System.out.println("Done with launching the Application");
		
	}

	@Override
	public void e_launch() {
		// TODO Auto-generated method stub
		
	}

	
	

}
