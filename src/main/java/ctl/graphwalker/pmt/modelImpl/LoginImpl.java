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

import ctl.graphwalker.pmt.test.LoginPmt;



@GraphWalker(value = "random(edge_coverage(100))", start = "e_Init")
 
public class LoginImpl extends ExecutionContext implements LoginPmt {
	
	

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
		Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.name("cuid"))).sendKeys("ab72075");
		Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.name("password"))).sendKeys("Ctli@075");
		Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@value='Login']"))).click();
		
		System.out.println("Entered the credentials");
		
	}
		
		
		public void e_InvalidCredentials() {
			//pass invalid credential and verify the error messages

		Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.name("cuid"))).sendKeys("AB62075");
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
		
		

		
	public void v_Project() throws InterruptedException {
		
		
		//Verifying the homepage element
		//Thread.sleep(2000);
		Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.xpath("//ul[@id='jsddm']")));
		//Assert.assertTrue("Text not found!", Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@name='Search']"))).getText().contains("Search"));
	}

	/* Added Helper.getWaiter to avoid quick hit. Its expecting element before it appears  */
	

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

	/*public void v_LoginPrompted() throws InterruptedException {
		//validate the login page of application	
	
	Helper.getInstance().findElement(By.xpath("//a[text()='Project']")).click();
	//Thread.sleep(2000);
	//Helper.getInstance().findElement(By.xpath("//a[text()='Create/Search Project']")).click();
   
//	String bodyText = Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(text(),'User Name')]"))).getText();
//	Assert.assertTrue("Text not found!", bodyText.contains("User Name (CUID)"));
		
		

	}*/
   
	

	public void e_Init() {
		Helper.getInstance();
		
	}

	/*public void e_Exit() {
		// writing to go back to login page again
		String bodyText = Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(text(),'User Name')]"))).getText();
		Assert.assertTrue("Text not found!", bodyText.contains("User Name (CUID)"));
			
	}*/

	


/*	@Override
	public void e_ReportIssue() {
		//click the report issue Link
				
		Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a/font/strong[text()='CLICK HERE']"))).click();

			}

	@Override
	public void v_ReprtIssue() {
		// verify if we reach to right Report issue Page
		
		Helper.windowhandles();
		Assert.assertTrue("Text not found!", Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@id='{BFF7A648-34EE-45D3-963E-12911AF0BD58}-{EA9077F0-B8B5-46EC-BC57-24C391A69436}']/tbody[1]/tr/th[2]/div"))).getText().contains("Edit"));
		 Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@id='idHomePageNewItem']")));
		
	}*/
	
	

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
