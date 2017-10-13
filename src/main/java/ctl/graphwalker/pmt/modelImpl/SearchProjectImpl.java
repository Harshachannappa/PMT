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
import ctl.graphwalker.pmt.test.SearchProject;

@GraphWalker(value = "random(edge_coverage(100))")

public class SearchProjectImpl extends ExecutionContext implements SearchProject{

	public void v_Home_common() {
		Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[text()='Project']")));
		System.out.println("We are at the Home page");
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void e_ProjectDetailsLoc() {
		Helper.mouseHover(Helper.getInstance().findElement(By.xpath(".//*[text()='Project']")));
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[text()='Create/Search Project']"))).click();
		
		Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.name("Create")));
		
	}

	@Override
	public void v_Search_Project() {
		try {
			Helper.getInstance().findElement(By.name("Search")).isDisplayed();
		}
		catch(NoSuchElementException e){
			v_Home_common();
			e_ProjectDetailsLoc();
		}
		
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
            if(col.getText().equals("test_demo_133"))
            {
                   System.out.println("Entered to IF Conditions");
                   WebElement col1=Helper.getInstance().findElement(By.xpath("//table[@id='projectTable']/tbody/tr["+i+"]"+"/td[1]"));
                   col1.click();
                   break;
            }
            
         }
         
         
         Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.linkText("Resource")));

		
	}

	@Override
	public void v_Search_flow() {
		// TODO Auto-generated method stub
		
	}



}
