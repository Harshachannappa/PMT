package ctl.graphwalker.pmt.modelImpl;



import javax.xml.xpath.XPath;

import org.graphwalker.core.machine.ExecutionContext;
import org.graphwalker.java.annotation.AfterElement;
import org.graphwalker.java.annotation.AfterExecution;
import org.graphwalker.java.annotation.BeforeElement;
import org.graphwalker.java.annotation.BeforeExecution;
import org.graphwalker.java.annotation.GraphWalker;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;


import ctl.graphwalker.pmt.helper.Helper;
import ctl.graphwalker.pmt.test.LoginManger;




@GraphWalker(value = "random(edge_coverage(100))", start = "e_Init")
 
public class LoginMangerimpl extends ExecutionContext implements LoginManger {
	
	
	public void e_Init() {
		Helper.getInstance();
		
	}
	
	@Override
	public void v_BaseUrl() {
		
		Helper.getInstance().get("http://10.140.0.99:2010/T2-T3Code/jsp/logon.jsp");
		
		Helper.getInstance().manage().window().maximize();
		
		System.out.println("Done with launching the Application");
		
	}
	
	
	public void e_StartClient() {
	//	Helper.alertwindow();
		System.out.println("Done handling any pop-up");
		
		
	}
	
	@Override
	public void v_LoginPrompted() {
		// TODO Auto-generated method stub
		
		
		System.out.println("Login page is displayed");
	}

	
		public void e_ValidPremiumCredentials() {	
		
		//Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.name("cuid"))).clear();
		Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.name("cuid"))).sendKeys("AA64405");
		//Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.name("password"))).sendKeys("Ctli@075");
		Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@value='Login']"))).click();
		
		System.out.println("Entered the credentials");
		
	}
		
		@Override
		public void e_ValidManagerCredentials() {
			// TODO Auto-generated method stub		
			
			//Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.name("cuid"))).clear();
			//Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.name("cuid"))).sendKeys("AA64405");
			Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.name("cuid"))).sendKeys("nrmarik");
			//Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.name("password"))).sendKeys("Ctli@075");
			Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@value='Login']"))).click();
			
			System.out.println("Entered the credentials");
			
		}
		
		
		public void e_InvalidCredentials() {
			//pass invalid credential and verify the error messages

		//Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.name("cuid"))).sendKeys("AB62075");
		
			Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.name("password"))).sendKeys("Ctli@075");
		Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/table/tbody/tr[1]/td/table/tbody/tr[5]/td[4]/table/tbody/tr[2]/td/form/table/tbody/tr[3]/td[1]/input[1]"))).click();
		WebElement errormessage=Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(text(),'Invalid CUID')]")));
		String expectedtext="Invalid CUID/Password";
		String Actualtxt=errormessage.getText();
		Assert.assertEquals(Actualtxt, expectedtext);
			
		System.out.println("Re-Entered the credentials Again");
		}

		
		
		@Override
		public void v_Home() {
			// TODO Auto-generated method stub
			Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[text()='Project']")));
			System.out.println("We are at the Home page");
		}

	



	

	/*@BeforeExecution
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
*/


	

	

	
}
