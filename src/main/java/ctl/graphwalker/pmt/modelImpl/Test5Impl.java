package ctl.graphwalker.pmt.modelImpl;

import org.graphwalker.core.machine.ExecutionContext;
import org.graphwalker.java.annotation.GraphWalker;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import ctl.graphwalker.pmt.helper.Helper;
import ctl.graphwalker.pmt.test.Test5;

@GraphWalker(value = "random(edge_coverage(100))")

public class Test5Impl extends ExecutionContext implements Test5 {

	@Override
	public void v_UpdatePMTProject() {
		 Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.linkText("Resource")));
		
	}

	@Override
	public void e_hover2link() {
		 Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.linkText("Risks"))).click();
		 
	}
	@Override
	public void v_LinkUpdate() {
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Override
	public void e_hover2resouce() {
		 Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.linkText("Resource"))).click();
		
		
	}
	
	@Override
	public void v_ResourceUpdate() {
		  Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.name("addResources")));
		  Select Rs=new Select(Helper.getInstance().findElement(By.id("Role")));
	        Rs.selectByValue("Team Member");
	        try {
				Thread.sleep(4000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        WebElement Rname=Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//font[contains(text(),'Resource Name') ])[1]/../../../..//td[4]//input")));
	      //  act.sendKeys(Rname, "DURGA SRAVANI",Keys.ARROW_DOWN.ENTER);
	        Rname.sendKeys("DURGA SRAVANI");
	        Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[starts-with(text(),'DURGA SRAVANI')]"))).click();
	        Select As=new Select(Helper.getInstance().findElement(By.id("d_hour")));
	        As.selectByValue("5");
	        Helper.getInstance().findElement(By.name("addResources")).click();
	}
	
	@Override
	public void e_hover2Detaills() {
		 Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.linkText("Details"))).click();
		
	}
	
	@Override
	public void v_DetailsUpdate() {
		  Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@value='Project Closure']")));
		
	}

	@Override
	public void e_hover2Application() {
		 Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.linkText("Application"))).click();
		
	}
	
	@Override
	public void v_ApplicationUpdate() {
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}



	@Override
	public void e_hover2Projectclosure() {
		 Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.linkText("Details"))).click();
		
	}

	@Override
	public void v_PMTProjectClosure() {
		  Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@value='Project Closure']")));
		
	}

	

	



	

	


}
