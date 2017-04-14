package ctl.graphwalker.pmt.modelImpl;

import org.graphwalker.core.machine.ExecutionContext;
import org.graphwalker.java.annotation.GraphWalker;

import ctl.graphwalker.pmt.ReportIssue;

@GraphWalker(value = "random(edge_coverage(100))")
public class ReportIssueImpl extends ExecutionContext implements ReportIssue {

	@Override
	public void e_LogoutSharePoint() {
		// logout from IssueTracker
		
	}

	@Override
	public void e_SubmitIssue() {
		// add the values to the field and submit
		
	}

	@Override
	public void e_AddItem() {
		// click the add item to get the screen
		
	}

	@Override
	public void v_PmtIssueTracker() {
		// verify the issue tracker screen if it is properly
		
	}

	@Override
	public void v_IssueAdded() {
		// verify if issue added properly and landed back to Issue Tracker home.
		
	}

	@Override
	public void v_ReportIssue() {
		// detail verification of screen
		
	}
	

}
