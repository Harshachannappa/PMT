package ctl.graphwalker.pmt.modelImpl;

import org.graphwalker.core.machine.ExecutionContext;
import org.graphwalker.java.annotation.GraphWalker;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import ctl.graphwalker.pmt.helper.Helper;
import ctl.graphwalker.pmt.test.LoginManger;
import ctl.graphwalker.pmt.test.PMTLaunch;

@GraphWalker(value = "random(edge_coverage(100))", start = "e_Init")

public class PMTLaunchImpl extends ExecutionContext implements PMTLaunch{

	@Override
	public void v_LoginPrompted() {
		Helper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.name("cuid")));
		System.out.println("Login page is displayed");
	}

	@Override
	public void v_BaseUrl() {
		Helper.getInstance().get("http://10.140.0.99:2010/T2-T3Code/jsp/logon.jsp");
		
		Helper.getInstance().manage().window().maximize();
		
		System.out.println("Done with launching the Application");
		
		
	}

	@Override
	public void e_StartClient() {
		
		System.out.println("Done handling any pop-up");
	}

	@Override
	public void e_Init() {
		
		Helper.getInstance();
	}

}
