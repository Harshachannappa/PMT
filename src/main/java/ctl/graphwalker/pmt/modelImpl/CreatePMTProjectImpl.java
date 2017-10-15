package ctl.graphwalker.pmt.modelImpl;

import java.util.List;

import org.graphwalker.core.machine.ExecutionContext;
import org.graphwalker.java.annotation.GraphWalker;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import ctl.graphwalker.pmt.helper.Helper;
import ctl.graphwalker.pmt.test.CreatePMTProject;

@GraphWalker(value = "random(edge_coverage(100))")
public class CreatePMTProjectImpl  extends ExecutionContext implements  CreatePMTProject{
	
	Main_PMTFlowImpl mp=new Main_PMTFlowImpl();
	
	
	public void v_CreatePMTProject() {
		try{
				
			Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.name("Create"))).click(); 
			Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@value=\"Submit\"]")));
		} catch(TimeoutException | NoSuchElementException | ElementNotVisibleException e){
			mp.e_hover2Projecttab_copy();
			mp.v_CreatePMTProject();
		}
		
	}
	
	@Override
	public void e_IncorrectData() {
		/*try{
			
			Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@value=\"Submit\"]")));
			Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@value=\"Submit\"]"))).click();
			Helper.getWaiter().until(ExpectedConditions.alertIsPresent());
			Assert.assertEquals("Enter Project name",Helper.getInstance().switchTo().alert().getText());
			Helper.getInstance().switchTo().alert().accept();
			
		} catch(TimeoutException | NoSuchElementException e){
			mp.v_CreatePMTProject();
			 e_IncorrectData();
		}*/
	}
	
	@Override
	public void e_CorrectData() {
		try{		
			
			Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@value=\"Submit\"]")));
			
			Helper.getInstance().findElement(By.name("projectName")).sendKeys("test_demo_135");
	      
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
	        List<WebElement> lis = Helper.getInstance().findElements(By.xpath("//td[text()='15']"));
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
	        List<WebElement> lis1 = Helper.getInstance().findElements(By.xpath("//td[text()='15']"));
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
	       
	        List<WebElement> lis3 = Helper.getInstance().findElements(By.xpath("//td[text()='19']"));
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
			if(Helper.getInstance().switchTo().alert().getText().equals("Project Not Created Successfully.")){
				Helper.getInstance().switchTo().alert().accept();
				Helper.getInstance().findElement(By.name("projectName")).sendKeys("test_demo_134");
				e_CorrectData_copy();
			} else {
				Assert.assertEquals("Project Created Successfully.",Helper.getInstance().switchTo().alert().getText());
				
				Helper.getInstance().switchTo().alert().accept();
			}
			
			mp.v_PMTLogout_copy();
			
		}  catch(TimeoutException | NoSuchElementException e){
			mp.v_CreatePMTProject();
			e_CorrectData();
		}
		
	}	


	public void e_CorrectData_copy() {
		try{		
			
			Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@value=\"Submit\"]")));
			
		
	      
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
			if(Helper.getInstance().switchTo().alert().getText().equals("Project Not Created Successfully.")){
				Helper.getInstance().switchTo().alert().accept();
				e_CorrectData();
			}
			Assert.assertEquals("Project Created Successfully.",Helper.getInstance().switchTo().alert().getText());
			
			Helper.getInstance().switchTo().alert().accept();
			
		}  catch(TimeoutException | NoSuchElementException e){
			mp.v_CreatePMTProject();
			e_CorrectData();
		}
		
	}	


	@Override
	public void v_PMTProject_Status() {
		try{
			Helper.mouseHover(Helper.getInstance().findElement(By.xpath(".//*[text()='Project']")));
			
		} catch(TimeoutException | NoSuchElementException e){
			
			mp.v_Home_copy();
			mp.e_hover2Projecttab_copy();
		}
		
		
	}

}
