package ctl.graphwalker.pmt.runners;

import java.io.IOException;

import org.graphstream.graph.Graph;
import org.graphstream.graph.implementations.SingleGraph;
import org.graphwalker.core.event.Observer;
import org.graphwalker.java.test.Executor;
import org.graphwalker.java.test.Result;
import org.graphwalker.java.test.TestExecutor;
import org.junit.Test;

import ctl.graphwalker.pmt.modelImpl.CreateApprovalIMPL;
import ctl.graphwalker.pmt.modelImpl.CreatePMTProjectImpl;
import ctl.graphwalker.pmt.modelImpl.LoginImpl;
import ctl.graphwalker.pmt.modelImpl.LoginMangerimpl;
import ctl.graphwalker.pmt.modelImpl.Main_PMTFlowImpl;
import ctl.graphwalker.pmt.modelImpl.ProjectClosureImpl;
import ctl.graphwalker.pmt.modelImpl.SearchProjectImpl;
import ctl.graphwalker.pmt.modelImpl.Test11Impl;
import ctl.graphwalker.pmt.modelImpl.Test2Impl;
import ctl.graphwalker.pmt.modelImpl.Test3Impl;
import ctl.graphwalker.pmt.modelImpl.Test4Impl;
import ctl.graphwalker.pmt.modelImpl.Test5Impl;
import ctl.graphwalker.pmt.modelImpl.Test6Impl;
import ctl.graphwalker.pmt.modelImpl.UpdateProjectImpl;
import ctl.graphwalker.pmt.modelImpl.Updated_LoginPMTImpl;
import ctl.graphwalker.pmt.observers.GraphStreamObserver;

public class NewRunnerPMT {

/*@Test
	public void test() throws IOException{*/
		public static void main(String[] args) throws IOException{
		 Result result =null;
	        System.setProperty("org.graphstream.ui.renderer",
	                "org.graphstream.ui.j2dviewer.J2DGraphRenderer");
	        Graph graph = new SingleGraph("GraphWalker MeetUp");
	        graph.display(true);
	        Executor executor = new TestExecutor(Test11Impl.class,
	        		Test2Impl.class,
	        		Test3Impl.class,
	        		Test4Impl.class,
	        		Test5Impl.class,
	        		Test6Impl.class
	        		
	                           );
	        Observer observer = new GraphStreamObserver(graph);
	        executor.getMachine().addObserver(observer);
	  try{
	         result = executor.execute(true);
	        if (result.hasErrors()) {
	            for (String error : result.getErrors()) {
	                System.out.println(error);
	            }
	        }
	  }catch(Exception e){}  
	        
	        System.out.println("Done: [" + result.getResults().toString(2) + "]");
	    }
	
}
