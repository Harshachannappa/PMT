package ctl.graphwalker.pmt.modelImpl;

import java.util.List;

import org.graphwalker.core.machine.ExecutionContext;
import org.graphwalker.java.annotation.GraphWalker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import ctl.graphwalker.pmt.helper.Helper;
import ctl.graphwalker.pmt.helper.PMT_Helperfile;
import ctl.graphwalker.pmt.test.Test2;
import ctl.graphwalker.pmt.test.Test3;

@GraphWalker(value = "random(edge_coverage(100))")

public class Test3Impl extends ExecutionContext implements Test3 {
	PMT_Helperfile PMT = new PMT_Helperfile();
	
	@Override
	public void v_PMTProject_Status() {
		Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[text()='Pending Process Status']")));
		
			
			if(Helper.getInstance().findElement(By.xpath("(.//*[text()='test_demo_145'])[1]/following-sibling::td[2]")).getText().trim().contains("SQA")){
				PMT.PMTLogout();
				PMT.BaseUrl();
				PMT.Login_SQAcredentials();
				
			} else if(Helper.getInstance().findElement(By.xpath("(.//*[text()='test_demo_145'])[1]/following-sibling::td[2]")).getText().trim().contains("DIRECTOR")){
				PMT.PMTLogout();
				PMT.BaseUrl();
				PMT.Login_Directorcredentials();
			} else {
				e_hover2SearchProject();
			}
				
	}

	
	@Override
	public void e_hover2ProjectTask() {
		PMT.hover2Projecttab();
		Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//a[text()='Pending WorkFlow Task']"))).click();
		
		
	}

	@Override
	public void v_ApprovePMTProject() {
		if(Helper.isElementPresent(By.xpath(".//*[@alt='Shows Project Details']"))){
			Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@alt='Shows Project Details']"))).click();
			Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@value='Approve']"))).click();
			Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@id='Approve/Reject Comments']"))).sendKeys("TEST");
			
			Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@value='Submit']"))).click();
			
		}
		PMT.PMTLogout();
		PMT.BaseUrl();
		PMT.Login_validcredentials();
		PMT.hover2Projecttab();
		Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[text()='PMT Process Status']"))).click();
		PMT.PMTProject_Status();
		PMT.hover2Projecttab();
		Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//a[text()='Pending WorkFlow Task']"))).click();
		
		if(Helper.isElementPresent(By.xpath(".//*[@alt='Shows Project Details']"))){
			Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@alt='Shows Project Details']"))).click();
			Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@value='Approve']"))).click();
			Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@id='Approve/Reject Comments']"))).sendKeys("TEST");
			
			Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@value='Submit']"))).click();
			
		}
		
		PMT.PMTLogout();
		PMT.BaseUrl();
		PMT.Login_validcredentials();
		PMT.hover2Projecttab();
		Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[text()='PMT Process Status']"))).click();
	}
	

	@Override
	public void e_hover2SearchProject() {
		
		PMT.hover2Projecttab();
		Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[text()='Create/Search Project']"))).click();
		
		Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.name("Create")));
		
		
		
	}
	
	@Override
	public void v_SearchPMTProject() {
		List<WebElement> table=Helper.getInstance().findElements(By.xpath("//table[@id='projectTable']/tbody/tr"));
        System.out.println("Table size:"+table.size());
        try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
         for(int i=1;i<table.size();i++)
         {
            WebElement col=Helper.getInstance().findElement(By.xpath("//table[@id='projectTable']/tbody/tr["+i+"]"+"/td[2]"));
            System.out.println("Column :"+col.getText());
            if(col.getText().equals("test_demo_145"))
            {
                   System.out.println("Entered to IF Conditions");
                   WebElement col1=Helper.getInstance().findElement(By.xpath("//table[@id='projectTable']/tbody/tr["+i+"]"+"/td[1]"));
                   col1.click();
                   break;
            }
            
         }
         
         
         Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.linkText("Resource")));
         PMT.PMTLogout();
	}


	


}
