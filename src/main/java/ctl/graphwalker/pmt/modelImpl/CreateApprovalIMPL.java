package ctl.graphwalker.pmt.modelImpl;

import java.util.List;

import org.graphwalker.core.machine.ExecutionContext;
import org.graphwalker.java.annotation.GraphWalker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import ctl.graphwalker.pmt.helper.Helper;
import ctl.graphwalker.pmt.test.CreateApproval;

@GraphWalker(value = "random(edge_coverage(100))")
public class CreateApprovalIMPL extends ExecutionContext implements CreateApproval {

	@Override
	public void v_logout() {
		Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@alt='logout']"))).click();
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void e_Pending_task() {
		Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@alt='Shows Project Details']"))).click();
		
	}

	@Override
	public void e_ProjectDetailsLoc() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void e_ValidDirectorCredentials() {
		Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.name("cuid"))).sendKeys("nrmarik");
		
		Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@value='Login']"))).click();
		
		System.out.println("Entered the credentials");
		
	}

	@Override
	public void v_SubmitProject() {
		Helper.getInstance().findElement(By.xpath("//input[@value=\"Submit\"]")).click(); 
		Helper.getWaiter().until(ExpectedConditions.alertIsPresent());
		Helper.getInstance().switchTo().alert().accept();
	}

	@Override
	public void e_Hover2Project() {
		Helper.mouseHover(Helper.getInstance().findElement(By.xpath(".//*[text()='Project']")));
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//a[text()='Pending WorkFlow Task']"))).click();
		
		
	}

	@Override
	public void v_BaseUrl() {
		Helper.getInstance().get("http://10.140.0.99:2010/T2-T3Code/jsp/logon.jsp");
		
		Helper.getInstance().manage().window().maximize();
		
		System.out.println("Done with launching the Application");
		
	}

	@Override
	public void v_Nopending_Workflow_Task() {
		System.out.println("checking any opn task");
		
	}

	@Override
	public void v_Home() {
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
	public void e_EnterAllRequiredDetail() {
		Helper.getInstance().findElement(By.name("projectName")).sendKeys("test_demo_133");
        //select the value from vp dropdown
        Select select=new Select(Helper.getInstance().findElement(By.id("vpD")));
        select.selectByVisibleText("SANDEEP M KULKARNI");
        //select the value from driecor dropdown
        Select select1=new Select(Helper.getInstance().findElement(By.id("qbDirector")));
        select1.selectByVisibleText("NARENDRA MARIKALE");
        //select the manager name from manager dropdown
        Select select2=new Select(Helper.getInstance().findElement(By.id("technicalManager")));
        select2.selectByVisibleText("SHESHANANDAN TIRU");
        //select the manager role from manager role dropdown
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
        /*System.out.println(lis1.size());
        for(int i=0;i<lis.size();i++)
        {
               try
               {
                     lis1.get(i).click();
                     break;
               }
               catch(Exception e)
               {
                     
               }
        }*/
        
        
        try {
               Thread.sleep(10000);
               System.out.println("wait start");
        } catch (InterruptedException e1) {
               // TODO Auto-generated catch block
               e1.printStackTrace();
        }
//      JavascriptExecutor executor = (JavascriptExecutor)Helper.getInstance();
//      executor.executeScript("arguments[0].click();", Helper.getInstance().findElement(By.id("end_date_b")));
 //     Helper.getInstance().findElement(By.id("end_date_b")).click();
        
        
        //List<WebElement> lis3 = Helper.getInstance().findElements(By.xpath("//td[text()='16']"));
        
        
        Helper.getInstance().findElement(By.id("end_date")).click();
        
        Helper.getInstance().findElement(By.id("end_date_b")).click();
        
        
        //Helper.getInstance().findElement(By.xpath("(//td[text()='16'])[2]")).click();
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

		
	}

	@Override
	public void v_Pending_Workflow_Task() {
		Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@alt='Shows Project Details']")));
		
	}

	@Override
	public void v_Approve_Pendingproject() {
		Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@value='Approve']"))).click();
		
	}

	@Override
	public void v_CreateProject() {
		WebElement lnk_Project = Helper.getInstance().findElement(By.xpath("//a[text()='Project']"));
		Actions action=new Actions( Helper.getInstance());
		action.moveToElement(lnk_Project).build().perform();
		//click on create link of project
		WebElement lnk_createSearch = Helper.getInstance().findElement(By.xpath("//a[text()='Create/Search Project']"));
		lnk_createSearch.click();
		//click on create button
		Helper.getInstance().findElement(By.name("Create")).click(); 
		
	}

	@Override
	public void e_nextapproval() {
		System.out.println("Next approval");
		
	}

	@Override
	public void v_AgainLoginPrompted() {
		System.out.println("Login as Director");
		
	}

	@Override
	public void e_ValidManagerCredentials() {
		Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.name("cuid"))).sendKeys("AA64405");
		//Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.name("password"))).sendKeys("Ctli@075");
		Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@value='Login']"))).click();
		
		System.out.println("Entered the credentials");
		
		
	}

	@Override
	public void e_StartClient() {
		System.out.println("Start of the PMT Application");
		
	}

	@Override
	public void e_Approval_Reason() {
		Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@id='Approve/Reject Comments']"))).clear();
		Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@id='Approve/Reject Comments']"))).sendKeys("MBT TEST");
			
			Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@value='Submit']"))).click();
			
			 
		
		
	}

	@Override
	public void v_Home_common() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void v_Search_flow() {
		// TODO Auto-generated method stub
		
	}


}
