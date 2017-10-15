package ctl.graphwalker.pmt.modelImpl;

import org.graphwalker.core.machine.ExecutionContext;
import org.graphwalker.java.annotation.GraphWalker;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;

import ctl.graphwalker.pmt.helper.Helper;
import ctl.graphwalker.pmt.test.PMTProjectStatus;

@GraphWalker(value = "random(edge_coverage(100))")
public class PMTProjectStatusImpl  extends ExecutionContext implements PMTProjectStatus{
	Main_PMTFlowImpl mp=new Main_PMTFlowImpl();

	
	public void v_PMTProject_Status() {
		try{
			Helper.mouseHover(Helper.getInstance().findElement(By.xpath(".//*[text()='Project']")));
			Thread.sleep(2000);
			Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@alt='PMT Process Status']"))).click();
			Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[text()='Pending Process Status']")));
			
			if(Helper.isElementPresent(By.xpath("(.//*[text()='test_demo_120'])[2]"))){
				if(Helper.getInstance().findElement(By.xpath("(.//*[text()='test_demo_120'])[1]/following-sibling::td[1])")).getText().trim().contains("Project Creation")){
					System.out.println("Project Approved");
				} else {
					System.out.println("Project is Pending from:"+Helper.getInstance().findElement(By.xpath("(.//*[text()='test_demo_134'])[1]/following-sibling::td[3]")).getText().trim());
				}
			} else {
				System.out.println("Project is Pending from:"+Helper.getInstance().findElement(By.xpath("(.//*[text()='test_demo_134'])[1]/following-sibling::td[3]")).getText().trim());
			}
			mp.v_PMTLogout_copy();
		}  catch(TimeoutException | InterruptedException | NoSuchElementException e){
			
			mp.v_Home();
			mp.e_hover2Projecttab();
			v_PMTProject_Status();
		}
		
	}

}
