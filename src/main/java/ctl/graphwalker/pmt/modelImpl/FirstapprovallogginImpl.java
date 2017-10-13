package ctl.graphwalker.pmt.modelImpl;

import org.graphwalker.core.machine.ExecutionContext;
import org.graphwalker.java.annotation.GraphWalker;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import ctl.graphwalker.pmt.helper.Helper;
import ctl.graphwalker.pmt.test.Firstapprovalloggin;

//@GraphWalker(start = "v_LoginPrompted")
@GraphWalker(value = "random(edge_coverage(100))")
public class FirstapprovallogginImpl extends ExecutionContext implements Firstapprovalloggin{

	@Override
	public void v_Home() {
		Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[text()='Project']")));
		System.out.println("We are at the Home page");
		
	}

	@Override
	public void v_LoginPrompted() {
		System.out.println("Login page is displayed");
		
	}

	@Override
	public void e_ValidManagerCredentials() {
		//Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.name("cuid"))).clear();
		Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.name("cuid"))).sendKeys("AA64405");
		//Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.name("cuid"))).sendKeys("nrmarik");
		//Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.name("password"))).sendKeys("Ctli@075");
		Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@value='Login']"))).click();
		
		System.out.println("Entered the credentials");
		
	}

}
