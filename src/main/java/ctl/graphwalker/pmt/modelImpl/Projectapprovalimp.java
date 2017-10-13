package ctl.graphwalker.pmt.modelImpl;

import org.graphwalker.core.machine.ExecutionContext;
import org.graphwalker.java.annotation.GraphWalker;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import ctl.graphwalker.pmt.helper.Helper;
import ctl.graphwalker.pmt.test.Projectapproval;

//@GraphWalker(start = "v_Home")
@GraphWalker(value = "random(edge_coverage(100))")
public class Projectapprovalimp extends ExecutionContext implements Projectapproval{

	@Override
	public void v_Home() {
		// TODO Auto-generated method stub
		Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[text()='Project']")));
		System.out.println("We are at the Home page");
	}
	
	
	@Override
	public void e_Hover2Project() {
		// TODO Auto-generated method stub
		Helper.mouseHover(Helper.getInstance().findElement(By.xpath(".//*[text()='Project']")));
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//a[text()='Pending WorkFlow Task']"))).click();
	}
	
	@Override
	public void v_Pending_Workflow_Task() {
		// TODO Auto-generated method stub
		Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@alt='Shows Project Details']")));
	}



	@Override
	public void e_Pending_task() {
		// TODO Auto-generated method stub
		Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@alt='Shows Project Details']"))).click();
	}

	
	@Override
	public void v_Approve_Pendingproject() {
		// TODO Auto-generated method stub
		Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@value='Approve']"))).click();
	}
	
	@Override
	public void e_Approval_Reason() {
		// TODO Auto-generated method stub
		Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@id='Approve/Reject Comments']"))).sendKeys("TEST");
		
		Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@value='Submit']"))).click();
	}
	

	@Override
	public void v_Nopending_Workflow_Task() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void v_logout() {
		// TODO Auto-generated method stub
		Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@alt='logout']"))).click();
	
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}




	



	

}
