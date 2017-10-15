package ctl.graphwalker.pmt.modelImpl;

import org.graphwalker.core.machine.ExecutionContext;
import org.graphwalker.java.annotation.GraphWalker;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import ctl.graphwalker.pmt.helper.Helper;
import ctl.graphwalker.pmt.test.Test6;

@GraphWalker(value = "random(edge_coverage(100))")

public class Test6Impl extends ExecutionContext implements Test6 {

	@Override
	public void v_PMTProjectClosure() {
		 Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.linkText("Details"))).click();
		
	}
	
	@Override
	public void e_hover2Detaills() {
		 Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.linkText("Details"))).click();
		
	}

	
	@Override
	public void v_PerformProjectClosure() {
		  Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@value='Project Closure']"))).click();
		  Helper.getWaiter().until(ExpectedConditions.alertIsPresent());
			Helper.getInstance().switchTo().alert().accept();
			Helper.getWaiter().until(ExpectedConditions.alertIsPresent());
			Helper.getInstance().switchTo().alert().accept();
		
	}
	
	@Override
	public void e_houver2Logout() {
		Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@alt='logout']"))).click();
		Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='Logged Out Successfully']")));
		
	}





	@Override
	public void v_PMTLogout() {
		Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='Logged Out Successfully']")));
		
	}

	
}
