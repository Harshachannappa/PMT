package ctl.graphwalker.pmt.modelImpl;

import java.util.List;

import org.graphstream.graph.ElementNotFoundException;
import org.graphwalker.core.machine.ExecutionContext;
import org.graphwalker.java.annotation.GraphWalker;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import ctl.graphwalker.pmt.helper.Helper;
import ctl.graphwalker.pmt.test.UpdateProject;

@GraphWalker(value = "random(edge_coverage(100))")

public class UpdateProjectImpl extends ExecutionContext implements UpdateProject{

	@Override
	public void v_Adding_resouces() {
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
        Rname.sendKeys("DURGA SRAVANI",Keys.ARROW_DOWN.ENTER);
        Select As=new Select(Helper.getInstance().findElement(By.id("d_hour")));
        As.selectByValue("5");
        Helper.getInstance().findElement(By.name("addResources")).click();

		
	}

	@Override
	public void e_Risk_link() {
		 Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.linkText("Risks"))).click();
		 try {
				Thread.sleep(4000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

	@Override
	public void e_Resources_link() {
		  Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.linkText("Resource"))).click();
		  Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.name("addResources")));
	}

	@Override
	public void v_Adding_applicationdetails() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void e_Application_link() {
		 Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.linkText("Application"))).click();
		 try {
				Thread.sleep(4000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}

	@Override
	public void v_Adding_dependency() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void e_Dependency_link() {
		
		 Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.linkText("Dependency"))).click();
		 try {
				Thread.sleep(4000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}

	@Override
	public void v_Adding_risks() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void v_Search_Project() {
		SearchProjectImpl sp=new SearchProjectImpl();
		try {
			Helper.getInstance().findElement(By.linkText("Resource")).isDisplayed();
		}
		catch(NoSuchElementException e){
			sp.v_Search_Project();
		
		}         
         
         Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.linkText("Resource")));
		
	}

	@Override
	public void v_Project_closure() {
		// TODO Auto-generated method stub
		
	}



}
