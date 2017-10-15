package ctl.graphwalker.pmt.modelImpl;

import java.util.List;

import org.graphwalker.core.machine.ExecutionContext;
import org.graphwalker.java.annotation.GraphWalker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import ctl.graphwalker.pmt.helper.Helper;
import ctl.graphwalker.pmt.helper.PMT_Helperfile;
import ctl.graphwalker.pmt.test.Test3;
import ctl.graphwalker.pmt.test.Test4;

@GraphWalker(value = "random(edge_coverage(100))")

public class Test4Impl extends ExecutionContext implements Test4 {
	PMT_Helperfile PMT = new PMT_Helperfile();
	@Override
	public void v_SearchPMTProject() {
		PMT.BaseUrl();
		PMT.Login_validcredentials();
		PMT.hover2Projecttab();
		Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[text()='Create/Search Project']"))).click();
		
		Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.name("Create")));
		
		
	}
	
	@Override
	public void e_hover2update_Project() {
		List<WebElement> table=Helper.getInstance().findElements(By.xpath("//table[@id='projectTable']/tbody/tr"));
        System.out.println("Table size:"+table.size());
        try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        Helper.jsClick(Helper.getInstance().findElement(By.xpath("//table[@id='projectTable']/tbody/tr/td/font[contains(text(),'test_demo_145')]/../..//a[1]")));
     /*    for(int i=1;i<table.size();i++)
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
            
         }*/
         
         
         Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.linkText("Resource")));
	}




	@Override
	public void v_UpdatePMTProject() {
		 Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.linkText("Resource")));
		
	}

}
