package ctl.graphwalker.pmt.runners;

import org.graphstream.graph.Graph;
import org.graphstream.graph.implementations.SingleGraph;
import org.graphwalker.core.event.Observer;
import org.graphwalker.java.test.Executor;
import org.graphwalker.java.test.Result;
import org.graphwalker.java.test.TestExecutor;

import ctl.graphwalker.pmt.modelImpl.*;
import ctl.graphwalker.pmt.observers.GraphStreamObserver;

import java.io.IOException;

/**
 * @author Rakesh Upadhayaya
 */
public class GraphStreamApplication {

  public static void main(String[] args) throws IOException {
	  Result result =null;
        System.setProperty("org.graphstream.ui.renderer",
                "org.graphstream.ui.j2dviewer.J2DGraphRenderer");
        Graph graph = new SingleGraph("GraphWalker MeetUp");
        graph.display(true);
        Executor executor = new TestExecutor(LoginImpl.class,
                ApplicationUpdateImpl.class,
                PlanningTriggerImpl.class);
              //  ReportIssueImpl.class
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
