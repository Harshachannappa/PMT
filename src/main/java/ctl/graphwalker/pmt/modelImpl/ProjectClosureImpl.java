package ctl.graphwalker.pmt.modelImpl;

import java.util.List;

import org.graphstream.graph.ElementNotFoundException;
import org.graphwalker.core.machine.ExecutionContext;
import org.graphwalker.java.annotation.GraphWalker;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import ctl.graphwalker.pmt.helper.Helper;
import ctl.graphwalker.pmt.test.ProjectClosure;

@GraphWalker(value = "random(edge_coverage(100))")

public class ProjectClosureImpl extends ExecutionContext implements ProjectClosure{

	@Override
	public void v_logout() {
Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@alt='logout']"))).click();
		
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void v_Project_closureinitiated() {
		  Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@value='Project Closure']"))).click();
		
	}

	@Override
	public void e_Project_closure() {
		
		try {
			Helper.getInstance().findElement(By.xpath("//input[@value='Project Closure']")).isDisplayed();
		}
		catch(NoSuchElementException e){
			Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.linkText("Details"))).click();
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			//  Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@value='Project Closure']")));
		
		}   
		
		
		  
	}

	
	public void v_Search_Project() {
		SearchProjectImpl sp=new SearchProjectImpl();
		try {
			Helper.getInstance().findElement(By.linkText("Details")).isDisplayed();
		}
		catch(NoSuchElementException e){
			sp.v_Search_Project();
		
		}   
         
         
         Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.linkText("Details")));
		
	}

	@Override
	public void e_Accepting_Projectclosure() {
		Helper.getWaiter().until(ExpectedConditions.alertIsPresent());
		Helper.getInstance().switchTo().alert().accept();
		Helper.getWaiter().until(ExpectedConditions.alertIsPresent());
		Helper.getInstance().switchTo().alert().accept();
		
	}

	@Override
	public void v_Project_closure() {
		// TODO Auto-generated method stub
		
	}

	

}
