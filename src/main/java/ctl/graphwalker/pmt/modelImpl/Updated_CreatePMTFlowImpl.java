package ctl.graphwalker.pmt.modelImpl;

import java.util.List;

import org.graphwalker.core.machine.ExecutionContext;
import org.graphwalker.java.annotation.GraphWalker;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import ctl.graphwalker.pmt.helper.Helper;
import ctl.graphwalker.pmt.test.Updated_CreatePMTFlow;

@GraphWalker(value = "random(edge_coverage(100))")
public class Updated_CreatePMTFlowImpl  extends ExecutionContext implements Updated_CreatePMTFlow{

	Updated_LoginPMTImpl LP=new Updated_LoginPMTImpl();
	
	public void v_Home() {
		try{
			Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[text()='Project']")));
			
		} catch(NoSuchElementException e){
			LP.v_BaseUrl();
			LP.e_Valid_Manager_Credentials();
		}		
		
	}

	@Override
	public void v_Approve_Pendingproject() {
		// TODO Auto-generated method stub
		
	}	


	@Override
	public void v_CreateProject() {
	
		Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[text()='Create/Search Project']"))).click();
		
		Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.name("Create"))).click();
		
		Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@value=\"Submit\"]")));
		
		Helper.getInstance().findElement(By.name("projectName")).sendKeys("test_demo_133");
      
        Select select=new Select(Helper.getInstance().findElement(By.id("vpD")));
        select.selectByVisibleText("SANDEEP M KULKARNI");        
        Select select1=new Select(Helper.getInstance().findElement(By.id("qbDirector")));
        select1.selectByVisibleText("NARENDRA MARIKALE");       
        Select select2=new Select(Helper.getInstance().findElement(By.id("technicalManager")));
        select2.selectByVisibleText("SHESHANANDAN TIRU");       
        Select select3=new Select(Helper.getInstance().findElement(By.id("managerRole")));
        select3.selectByVisibleText("TECHNICAL MANAGER");
        
        //..project Date.....
        Helper.getInstance().findElement(By.id("init_date_b")).click();
        //..select the value in calendar
        List<WebElement> lis = Helper.getInstance().findElements(By.xpath("//td[text()='13']"));
        for(int i=0;i<lis.size();i++)
        {
               try
               {
                     lis.get(i).click();
                     break;
               }
               catch(Exception e)
               {
                     
               }
        }
        
        
        
        Helper.getInstance().findElement(By.id("start_date_b")).click();
        List<WebElement> lis1 = Helper.getInstance().findElements(By.xpath("//td[text()='13']"));
        Helper.getInstance().findElement(By.xpath("(//td[text()='13'])[2]")).click();
          
        
        try {
               Thread.sleep(10000);
               System.out.println("wait start");
        } catch (InterruptedException e1) {
               // TODO Auto-generated catch block
               e1.printStackTrace();
        }        
        
        Helper.getInstance().findElement(By.id("end_date")).click();
        
        Helper.getInstance().findElement(By.id("end_date_b")).click();        
       
        List<WebElement> lis3 = Helper.getInstance().findElements(By.xpath("//td[text()='17']"));
        for(int i=0;i<lis3.size();i++)
        {
               try
               {
                     lis3.get(i).click();
                     break;
               }
               catch(Exception e)
               {
                     
               }
        }
        
        
        //...project type section.........
        Select select4=new Select(Helper.getInstance().findElement(By.id("projectCategary")));
        select4.selectByVisibleText("AGILE");
        Select select5=new Select(Helper.getInstance().findElement(By.id("projectLifeCycle")));
        select5.selectByVisibleText("AGILE");
        
        Select select6=new Select(Helper.getInstance().findElement(By.id("projectQSDP")));
        select6.selectByVisibleText("FULL PROCESS");
        
        Helper.getInstance().findElement(By.name("rationale")).sendKeys("Test");
        
        Helper.getInstance().findElement(By.xpath("//input[@value=\"OFFSHORE\"]")).click();
        Helper.getInstance().findElement(By.name("scrumMaster")).sendKeys("Test");
        Helper.getInstance().findElement(By.name("productOwner")).sendKeys("Test1");
        Select select10=new Select(Helper.getInstance().findElement(By.id("deliveryCoordinator")));
        select10.selectByVisibleText("PRATAP MYSORE NARASIMHA RAJU");
        
        
        Select select7=new Select(Helper.getInstance().findElement(By.id("agileProjType")));
        select7.selectByVisibleText("Hybrid Agile");
        Select select8=new Select(Helper.getInstance().findElement(By.id("projTrackTool")));
        select8.selectByVisibleText("PMT");
        Helper.getInstance().findElement(By.name("rallyWSPName")).sendKeys("Test");
        
        Helper.getInstance().findElement(By.name("rallyProjName")).sendKeys("Test");
        Helper.getInstance().findElement(By.name("rallyURL")).sendKeys("Test");      
        
        
        Select select9=new Select(Helper.getInstance().findElement(By.id("sqa")));
        select9.selectByVisibleText("SUDHANVA DODDABASAVAIAH");
        Helper.getInstance().findElement(By.name("peakTeamSize")).sendKeys("5");
        Helper.getInstance().findElement(By.name("peakFTE")).sendKeys("5");
	
		
		
		Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@value=\"Submit\"]"))).click();
		
		Helper.getWaiter().until(ExpectedConditions.alertIsPresent());
		Helper.getInstance().switchTo().alert().accept();
		
	}

	@Override
	public void v_Pending_Process_Status_validation() {
		
		e_Hover_Project();
		
		Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[text()='PMT Process Status']"))).click();
	}

	@Override
	public void e_Hover_Pending_Workflow() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void e_ValidDirectorCredentials() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void e_Logout() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void e_ValidManagerCredentials() {
		Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.name("cuid"))).sendKeys("AA64405");
		
		Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@value='Login']"))).click();
		
		Helper.mouseHover(Helper.getInstance().findElement(By.xpath(".//*[text()='Project']")));
		
		
	}

	@Override
	public void e_Hover_Project() {
		Helper.mouseHover(Helper.getInstance().findElement(By.xpath(".//*[text()='Project']")));
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
	}

	
	public void v_BaseUrl() {
		LP.v_BaseUrl();
		
	}

	@Override
	public void v_Search_flow() {
		// TODO Auto-generated method stub
		
	}

}
