package ctl.graphwalker.pmt.modelImpl;

import org.graphwalker.core.machine.ExecutionContext;
import org.graphwalker.java.annotation.GraphWalker;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import ctl.graphwalker.pmt.PlanningTrigger;
import ctl.graphwalker.pmt.helper.Helper;

@GraphWalker(value = "random(edge_coverage(100))")
public class PlanningTriggerImpl extends ExecutionContext implements PlanningTrigger {

	@Override
	public void e_CorrectData() {
		// TODO enter correct data and submit
		
		Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.id("darTrigger"))).sendKeys("GWH Demo");		
		Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.id("carTrigger"))).sendKeys("GWH Demo");
	    Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.id("replanTrigger"))).sendKeys("GWH Demo");
	    Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.id("btnSave"))).click();
	  
	
	}
	@Override
	public void e_IncorrectData() {
		// TODO dont enter data and and click submit
		
		Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.id("darTrigger"))).sendKeys("GWH Demo");		
		Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.id("carTrigger"))).clear();
	    Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.id("replanTrigger"))).clear();
	    Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.id("btnSave"))).click();
		
		
	}
	@Override
	public void v_IncorrectData() {
		// TODO  handle the screen popup
		
	 Helper.alertwindow(); 	
	}

	@Override
	public void v_PlanningTrigger() {
		// TODO Click the planning trigger link
		Assert.assertTrue("Text not found!", Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@id='nav']/li[1]/a"))).getText().contains("Project Details"));
	    Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='nav']/li[2]/ul/li[14]/a"))).click();
		
		
	    
	    
	}

	@Override
	public void v_CorrectData() {
		// TODO verify record saved successfully
		
		
	//	Assert.assertTrue("Text not found!", Helper.getWaiter().until(ExpectedConditions.visibilityOfElementLocated(By.id("msgBox"))).getText().contains("Saved Successfully"));

		Helper.getWaiter().until(ExpectedConditions.alertIsPresent());
		Assert.assertEquals("Saved Successfully", Helper.getInstance().switchTo().alert().getText());
		Helper.getInstance().switchTo().alert().accept(); 
	}

	
	
}
