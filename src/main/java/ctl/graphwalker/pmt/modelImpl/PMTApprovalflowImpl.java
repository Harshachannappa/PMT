package ctl.graphwalker.pmt.modelImpl;

import org.graphwalker.core.machine.ExecutionContext;
import org.graphwalker.java.annotation.GraphWalker;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import ctl.graphwalker.pmt.helper.Helper;
import ctl.graphwalker.pmt.test.Approvalflow;
import ctl.graphwalker.pmt.test.LoginDirector;

@GraphWalker(value = "random(edge_coverage(100))", start = "e_Init")

public class PMTApprovalflowImpl  extends ExecutionContext implements Approvalflow {

	@Override
	public void v_Home() {
		Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[text()='Project']")));
		System.out.println("We are at the Home page");
		
	}
	
	

	@Override
	public void e_ValidDirectorCredentials() {
		Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.name("cuid"))).sendKeys("nrmarik");
		
		Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@value='Login']"))).click();
		
		System.out.println("Entered the credentials");
		
	}

	@Override
	public void v_LoginPrompted() {
		Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.name("cuid")));
		System.out.println("Login page is displayed");
		
	}

	@Override
	public void v_BaseUrl() {
		Helper.getInstance().get("http://10.140.0.99:2010/T2-T3Code/jsp/logon.jsp");
		
		Helper.getInstance().manage().window().maximize();
		
		System.out.println("Done with launching the Application");
		
		
	}

	@Override
	public void e_StartClient() {
		System.out.println("Start of the PMT Application");
		
	}

	@Override
	public void e_Init() {
		Helper.getInstance();
		System.out.println("Launching Browser");
	}



	@Override
	public void v_logout() {
		Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@alt='logout']"))).click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	@Override
	public void e_Pending_task() {
		Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@alt='Shows Project Details']"))).click();
		
	}



	@Override
	public void e_Hover2Project() {
		Helper.mouseHover(Helper.getInstance().findElement(By.xpath(".//*[text()='Project']")));
		Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//a[text()='Pending WorkFlow Task']"))).click();
		
	}



	@Override
	public void v_Nopending_Workflow_Task() {
		System.out.println("checking any opn task");
		
	}



	@Override
	public void v_Pending_Workflow_Task() {
		Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@alt='Shows Project Details']")));
		
	}



	@Override
	public void v_Approve_Pendingproject() {
		Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@value='Approve']"))).click();
		
	}



	@Override
	public void e_Approval_Reason() {
		Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@id='Approve/Reject Comments']"))).sendKeys("TEST");
		
		Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@value='Submit']"))).click();
		
	}



	@Override
	public void e_ValidManagerCredentials() {
		Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.name("cuid"))).sendKeys("AA64405");
		//Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.name("password"))).sendKeys("Ctli@075");
		Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@value='Login']"))).click();
		
		System.out.println("Entered the credentials");
		
	}



	@Override
	public void e_nextapproval() {
		// TODO Auto-generated method stub
		System.out.println("Next approval");
	}

}
