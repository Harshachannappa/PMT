package ctl.graphwalker.pmt.modelImpl;

import org.graphwalker.core.machine.ExecutionContext;
import org.graphwalker.java.annotation.GraphWalker;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import ctl.graphwalker.pmt.ApplicationUpdate;
import ctl.graphwalker.pmt.helper.Helper;
@GraphWalker(value = "random(edge_coverage(100))")
public class ApplicationUpdateImpl extends ExecutionContext implements ApplicationUpdate {

	@Override
	public void v_Home() {
		// TODO describe home application
		
		Assert.assertTrue("Text not found!", Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.xpath("html/body/table/tbody/tr[2]/td/form/table[2]/tbody/tr/td/font[1]/b"))).getText().contains("Approved/Active Projects"));
		
		
	
		
		
	}

	@Override
	public void v_ProjectDetails() {
		// TODO verify project detail screen
		
		Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@id='projectTable']/tbody/tr[1]/td[1]/a/img"))).click();
		Helper.getWaiter();
		Assert.assertTrue("Text not found!", Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@value='Project Closure']"))).getText().contains("Project Closure"));
		
		
		
		
	}

	/*@Override
	public void e_UpdateAppStatus() {
		// TODO click on update folder link, update end date and submit
		
	}*/

	@Override
	public void e_SaveAppStatus() {
		// TODO fill the data start date and end date and submit.
		
	}

	@Override
	public void e_PlanningTrigger() {
		// TODO click on PlanningTrigger component on left side of screen.
		Assert.assertTrue("Text not found!", Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@id='nav']/li[1]/a"))).getText().contains("Project Details"));
		Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='nav']/li[2]/ul/li[14]/a"))).click();
	}

	@Override
	public void e_ProjectDetailsLoc() {
		// TODO click the project detail folder link
		
	}

	@Override
	public void v_ApplicationStatusUpdate() {
		// TODO verify updated application status updated
		
	}

	@Override
	public void v_Application() {
		// TODO verify application screen
		
		
	}

	@Override
	public void e_DeleteAppStatus() {
		// TODO A click on delete entity and handle the popup -click ok.
		
		Assert.assertTrue("Text not found!", Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@id='applicationTable']/tbody/tr/td[1]"))).getText().contains("EASE-ASR"));
		Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@id='applicationTable']/tbody/tr/td[9]/a"))).click();
		
	}

	@Override
	public void v_PlanningTrigger() {
		// TODO verify planning trigger screen
		Assert.assertTrue("Text not found!",Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.id("darTrigger"))).getText().contains("DAR Triggers	"));
	   
	}

	@Override
	public void e_ApplicationDetail() {
		// TODO click on the application link
		
	}

	/*@Override
	public void e_AddAnotherProject() {
		// TODO populate the other project and handle the submit
		
	}*/

	
}
