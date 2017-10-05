package ctl.graphwalker.pmt.modelImpl;

import org.graphwalker.core.machine.ExecutionContext;
import org.graphwalker.java.annotation.GraphWalker;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import ctl.graphwalker.pmt.test.ReportIssue;
import ctl.graphwalker.pmt.helper.Helper;

@GraphWalker(value = "random(edge_coverage(100))")
public class ReportIssueImpl extends ExecutionContext implements ReportIssue {
	
	WebDriver driver=null;
	

	@Override
	public void e_LogoutSharePoint() {
		// logout from IssueTracker
		
		//Helper.switchTo().defaultContent();
		Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='zz11_Menu']/span"))).click();
		Helper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.partialLinkText("Sign Out"))).click();
		
	
	
	}

	@Override
	public void e_SubmitIssue() {
		// add the values to the field and submit
	
		//Helper.getInstance().switchTo().frame(Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.xpath("//iframe[starts-with(@id,'DlgFrame')]"))));
		/*Helper.getWaiter();
		Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@title='Title Required Field']"))).sendKeys("Graphwalker Testing Please ignore ");
		new Select(Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.xpath("//select[@title='Status']")))).selectByIndex(1);
        new Select(Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.xpath("//select[@title='Priority']")))).selectByIndex(1);
        Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.xpath("//textarea[@title='Description']"))).sendKeys("This is for testing the graphwalker implementation for the purpose of Demo.Please ignore");;
        new Select(Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.xpath("//select[@title='Category']")))).selectByIndex(2);
        Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.xpath("//textarea[@title='Resolution Required Field']"))).sendKeys("High Priority Resolution required immediate");
   	    new Select(Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.xpath("//select[@title='Project SQA Required Field']")))).selectByIndex(2);
   	    new Select(Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.xpath("//select[@title='SQA/SEPG Status']")))).selectByIndex(1);
   	    Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@id='ctl00_m_g_69850ceb_e267_4a38_bcdb_dccd35401267_savebutton2_ctl00_diidIOSaveItem']"))).click();
		*/
	}

	@Override
	public void e_AddItem() {
		// click the add item to get the screen
		//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	//	Helper.getWaiter();
    //   Helper.windowhandles();
	//   Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@id='idHomePageNewItem']"))).click();
	   //Helper.getInstance().switchTo().frame(2);
	   
	//   Helper.getInstance().switchTo().frame(Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.xpath("//iframe[starts-with(@id,'DlgFrame')]"))));
	}

	@Override
	public void v_PmtIssueTracker() {
		// verify the issue tracker screen if it is properly
	   	
	// Helper.getWaiter();
	// Assert.assertTrue("Text not found!", Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.linkText("Click for help about adding basic HTML formatting."))).getText().contains("Click for help about adding basic HTML formatting."));
	
		
		
	}

	

	@Override
	public void v_IssueAdded() {
		// verify if issue added properly and landed back to Issue Tracker home.
		

		//Assert.assertTrue("Text not found!", Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='group0']/td/a"))).getText().contains("Approval Status"));
	
		
	}

	@Override
	public void v_ReportIssue() {
		// detail verification of screen

	//	Assert.assertTrue("Text not found!", Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@id='idHomePageNewItem']"))).getText().contains("Add new item"));		
		Helper.windowhandles();
		Assert.assertTrue("Text not found!", Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@id='{BFF7A648-34EE-45D3-963E-12911AF0BD58}-{EA9077F0-B8B5-46EC-BC57-24C391A69436}']/tbody[1]/tr/th[2]/div"))).getText().contains("Edit"));
		// Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@id='idHomePageNewItem']")));
		
	}
	

}
