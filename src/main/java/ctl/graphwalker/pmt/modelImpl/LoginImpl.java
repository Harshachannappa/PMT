package ctl.graphwalker.pmt.modelImpl;

import java.util.Set;

import org.graphwalker.core.machine.ExecutionContext;
import org.graphwalker.java.annotation.AfterElement;
import org.graphwalker.java.annotation.AfterExecution;
import org.graphwalker.java.annotation.BeforeElement;
import org.graphwalker.java.annotation.BeforeExecution;
import org.graphwalker.java.annotation.GraphWalker;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import ctl.graphwalker.pmt.Login;
import ctl.graphwalker.pmt.helper.Helper;



@GraphWalker(value = "random(edge_coverage(100))", start = "e_Init")
 
public class LoginImpl extends ExecutionContext implements Login {
	
	WebDriver driver=null;

	public void v_Home() {
		
		
		//Verifying the homepage element
		Assert.assertTrue("Text not found!", Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='loading']/form/table[1]/tbody/tr/td[3]"))).getText().contains("Effort should be entered in HH:MM format"));
		
	}

	/* Added Helper.getWaiter to avoid quick hit. Its expecting element before it appears  */
	public void e_ValidPremiumCredentials() {	
		
		Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.name("cuid"))).clear();
		Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.name("cuid"))).sendKeys("AB72075");
		Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.name("password")))
        .sendKeys("Ctli@075");
		driver.findElement(By.xpath("/html/body/table/tbody/tr[1]/td/table/tbody/tr[5]/td[4]/table/tbody/tr[2]/td/form/table/tbody/tr[3]/td[1]/input[1]")).click();
		Helper.alertwindow(driver);
		
	}

    /*
     * Writing to click the logout button 
     */
	public void e_Logout() {		
		Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/table/tbody/tr[1]/td/table/tbody/tr/td[3]/a/img"))).click();
		WebElement logmessage=Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(text(),'Logged')]")));
		String expectedtext="Logged Out Successfully";
		String Actualtxt=logmessage.getText();
		Assert.assertEquals(Actualtxt, expectedtext);
		
	}

	public void v_LoginPrompted() {
		//validate the login page of application	
   
	String bodyText = Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(text(),'User Name')]"))).getText();
	Assert.assertTrue("Text not found!", bodyText.contains("User Name (CUID)"));
		
		

	}
   
	@Override
	public void v_BaseUrl() {
		String baseurl="http://"+"AB72075"+":"+"Ctli@075"+"@"+"10.140.0.99:2010/T2-T3Code/jsp/logon.jsp";
		driver.get(baseurl);
		
	}
	
	public void e_StartClient() {
		Helper.alertwindow(driver);			
	}

	public void e_Init() {
		driver=Helper.getInstance();
		
	}

	public void e_Exit() {
		// writing to go back to login page again
		String bodyText = Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(text(),'User Name')]"))).getText();
		Assert.assertTrue("Text not found!", bodyText.contains("User Name (CUID)"));
			
	}

	
	public void e_InvalidCredentials() {
		//pass invalid credential and verify the error messages

	Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.name("cuid"))).sendKeys("AB62075");
	Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.name("password"))).sendKeys("Ctli@075");
	driver.findElement(By.xpath("/html/body/table/tbody/tr[1]/td/table/tbody/tr[5]/td[4]/table/tbody/tr[2]/td/form/table/tbody/tr[3]/td[1]/input[1]")).click();
	WebElement errormessage=Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(text(),'Invalid CUID')]")));
	String expectedtext="Invalid CUID/Password";
	String Actualtxt=errormessage.getText();
	Assert.assertEquals(Actualtxt, expectedtext);
			
	}


	@Override
	public void e_ReportIssue() {
		//click the report issue Link
				
		Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a/font/strong[text()='CLICK HERE']"))).click();
			}

	@Override
	public void v_ReprtIssue() {
		// verify if we reach to right Report issue Page
		
		
		Assert.assertTrue("Text not found!", Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@id='idHomePageNewItem']"))).getText().contains("Add new item"));
		Helper.getWaiter();
		Helper.windowhandles(driver);
     		Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@id='idHomePageNewItem']"))).click();
		
	}
	
	

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
//        Helper.tearDown();
    }

    @BeforeElement
    public void printBeforeElement() {
        System.out.println("Before element " + getCurrentElement().getName());
    }

    @AfterElement
    public void printAfterElement() {
        System.out.println("After element " + getCurrentElement().getName());
    }

	
}
