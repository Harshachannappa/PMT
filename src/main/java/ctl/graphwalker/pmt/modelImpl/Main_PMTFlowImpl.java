package ctl.graphwalker.pmt.modelImpl;

import org.graphwalker.core.machine.ExecutionContext;
import org.graphwalker.java.annotation.AfterElement;
import org.graphwalker.java.annotation.AfterExecution;
import org.graphwalker.java.annotation.BeforeElement;
import org.graphwalker.java.annotation.BeforeExecution;
import org.graphwalker.java.annotation.GraphWalker;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import ctl.graphwalker.pmt.helper.Helper;
import ctl.graphwalker.pmt.test.Main_PMTFlow;

@GraphWalker(value = "random(edge_coverage(100))", start = "e_Init")

public class Main_PMTFlowImpl  extends ExecutionContext implements Main_PMTFlow{

	@BeforeExecution
    public void setup() {
        System.out.println("Graphwalker: Any setup steps happens here. " +
                           "The annotation @BeforeExecution makes sure that before any elements in the " +
                           "model is called, this method is called first");
        Helper.setup();
    }

    @AfterExecution
    public void cleanup() {
        System.out.println("Graphwalker: Any cleanup  steps happens here. " +
                           "The annotation @AfterExecution makes sure that after the test is done, " +
                           "this method is called last.");

    }

    @BeforeElement
    public void printBeforeElement() {
        System.out.println("Before element " + getCurrentElement().getName());
    }

    @AfterElement
    public void printAfterElement() {
        System.out.println("After element " + getCurrentElement().getName());
    }

	@Override
	public void e_Init() {
		Helper.getInstance();
		
	}
	
	@Override
	public void v_BaseUrl() {
		Helper.getInstance().get("http://10.140.0.99:2010/T2-T3Code/jsp/logon.jsp");
		
		
		Helper.getInstance().manage().window().maximize();
		
		System.out.println("Done with launching the Application");
		
	}
	
	public void v_BaseUrl_copy() {
		Helper.getInstance().get("http://10.140.0.99:2010/T2-T3Code/jsp/logon.jsp");
		
		
		Helper.getInstance().manage().window().maximize();
		
		System.out.println("Done with launching the Application");
		
	}
	
	@Override
	public void e_StartClient() {
		try{
			Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.name("cuid")));
		}  catch(TimeoutException | NoSuchElementException e){
			v_BaseUrl_copy();
		}
		
	}
	
	@Override	
	public void v_LoginPrompted() {
		e_StartClient();
		
	}
	
	@Override
	public void e_InvalidCredentials() {
		try{
			Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.name("cuid"))).sendKeys("123654");		
			Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@value='Login']"))).click();
			Assert.assertEquals("Invalid CUID/Password",Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='Invalid CUID/Password']"))).getText());
		}  catch(TimeoutException | NoSuchElementException  e){
			
			v_BaseUrl_copy();
		}
	}
	
	@Override
	public void e_Valid_Manager_Credentials() {
		try{
			Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.name("cuid"))).sendKeys("nrmarik");
//			Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.name("password"))).sendKeys("Ctli@075");
			Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@value='Login']"))).click();
			
			
			Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[text()='Project']")));	
		}  catch(TimeoutException | NoSuchElementException e){
				
			v_BaseUrl_copy();
				e_Valid_Manager_Credentials();
			}
		
	}
	
	public void e_Valid_Manager_Credentials_copy() {
		try{
			Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.name("cuid"))).sendKeys("nrmarik");
//			Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.name("password"))).sendKeys("Ctli@075");
			Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@value='Login']"))).click();
			
			
			Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[text()='Project']")));	
		}  catch(TimeoutException | NoSuchElementException e){
				
			v_BaseUrl_copy();
			e_Valid_Manager_Credentials_copy();
			}
		
	}
	
	@Override
	public void v_Home() {
		try{
			Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[text()='Project']")));	
			
		}  catch(TimeoutException | NoSuchElementException e){
			
			v_BaseUrl_copy();
			e_Valid_Manager_Credentials_copy();
		}
		
	}

	public void v_Home_copy() {
		try{
			Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[text()='Project']")));	
			
		}  catch(TimeoutException | NoSuchElementException e){
			
			v_BaseUrl_copy();
			e_Valid_Manager_Credentials_copy();
		}
		
	}
	

	@Override
	public void e_hover2Projecttab() {
		try{
			Helper.mouseHover(Helper.getInstance().findElement(By.xpath(".//*[text()='Project']")));
			Thread.sleep(2000);
		}  catch(TimeoutException | InterruptedException | NoSuchElementException e){
			
			v_Home_copy();
			e_hover2Projecttab();
		}
	
		
	}
	
	public void e_hover2Projecttab_copy() {
		try{
			Helper.mouseHover(Helper.getInstance().findElement(By.xpath(".//*[text()='Project']")));
			Thread.sleep(2000);
		}  catch(TimeoutException | InterruptedException | NoSuchElementException e){
			
			v_Home_copy();
			e_hover2Projecttab_copy();
		}
	
		
	}
	
	
	public void v_CreatePMTProject() {
		try{
			Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[text()='Create/Search Project']"))).click();
			
		
			Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.name("Create"))); 
			
		} catch(TimeoutException | NoSuchElementException | ElementNotVisibleException e){
			e_hover2Projecttab_copy();
			v_CreatePMTProject();
		}
		
		
	}

	
	
	public void v_SearchPMTProject() {
		// TODO Auto-generated method stub
		
	}

	
	public void e_houver2PMTProjectstatus() {
		// TODO Auto-generated method stub
		
	}

	
	public void v_ApprovePMTProject() {
		// TODO Auto-generated method stub
		
	}

	


	
	public void v_PMTProjectClosure() {
		// TODO Auto-generated method stub
		
	}

	

	
	

	
	public void e_houver2Searchproject() {
		// TODO Auto-generated method stub
		
	}


	
	public void e_houver2SearchProject() {
		// TODO Auto-generated method stub
		
	}

	
	

	




	
	public void v_UpdatePMTProject() {
		// TODO Auto-generated method stub
		
	}
  
	@Override
	public void e_houver2Logout() {
		Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@alt='logout']"))).click();
		Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='Logged Out Successfully']")));
		
		
		
	}

	@Override
	public void v_PMTLogout() {
	try{
		WebElement logmessage=Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='Logged Out Successfully']")));
		String expectedtext="Logged Out Successfully";
		String Actualtxt=logmessage.getText();
		Assert.assertEquals(Actualtxt, expectedtext);
	}  catch(TimeoutException | NoSuchElementException e){
		e_houver2Logout();
	}
	}
	

	public void e_houver2Logout_copy() {
		Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@alt='logout']"))).click();
		Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='Logged Out Successfully']")));
		
		
		
	}

	
	public void v_PMTLogout_copy() {
	try{
		WebElement logmessage=Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='Logged Out Successfully']")));
		String expectedtext="Logged Out Successfully";
		String Actualtxt=logmessage.getText();
		Assert.assertEquals(Actualtxt, expectedtext);
	}  catch(TimeoutException | NoSuchElementException e){
		e_houver2Logout();
	}
	}

	
	

}
