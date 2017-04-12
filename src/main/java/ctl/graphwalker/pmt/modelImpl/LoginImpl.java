package ctl.graphwalker.pmt.modelImpl;

import org.graphwalker.core.machine.ExecutionContext;
import org.graphwalker.java.annotation.AfterElement;
import org.graphwalker.java.annotation.AfterExecution;
import org.graphwalker.java.annotation.BeforeElement;
import org.graphwalker.java.annotation.BeforeExecution;
import org.graphwalker.java.annotation.GraphWalker;
import org.openqa.selenium.WebDriver;

import ctl.graphwalker.pmt.Login;
import ctl.graphwalker.pmt.helper.Helper;



@GraphWalker(value = "random(edge_coverage(100))", start = "e_StartClient")
 
public class LoginImpl extends ExecutionContext implements Login {
	
	WebDriver driver=null;

	public void v_Home() {
		// TODO Auto-generated method stub
		
	}

	public void e_ToggleRememberMe() {
		// TODO Auto-generated method stub
		
	}

	public void e_ValidPremiumCredentials() {
		// TODO Auto-generated method stub
		
	}

	public void v_applicationDown() {
		// TODO Auto-generated method stub
		
	}

	public void e_Logout() {
		// TODO Auto-generated method stub
		
	}

	public void v_LoginPrompted() {
		// TODO Auto-generated method stub
		
	}

	public void e_StartClient() {
		driver.get("http://10.140.0.99:2010/T2-T3Code/jsp/logon.jsp");		
	}

	public void e_Close() {
		// TODO Auto-generated method stub
		
	}

	public void e_Init() {
		driver=Helper.getInstance();
		
	}

	public void e_Exit() {
		// TODO Auto-generated method stub
		
	}

	public void e_InvalidCredentials() {
		// TODO Auto-generated method stub
		
	}

	@BeforeExecution
    public void setup() {
        System.out.println("PetClinic: Any setup steps happens here. " +
                           "The annotation @BeforeExecution makes sure that before any elements in the " +
                           "model is called, this method is called first");
        Helper.setup();
    }

    @AfterExecution
    public void cleanup() {
        System.out.println("PetClinic: Any cleanup  steps happens here. " +
                           "The annotation @AfterExecution makes sure that after the test is done, " +
                           "this method is called last.");
        Helper.tearDown();
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
