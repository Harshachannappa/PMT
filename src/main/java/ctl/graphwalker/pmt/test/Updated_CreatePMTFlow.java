// Generated by GraphWalker (http://www.graphwalker.org)
package ctl.graphwalker.pmt.test;

import org.graphwalker.java.annotation.Model;
import org.graphwalker.java.annotation.Vertex;
import org.graphwalker.java.annotation.Edge;

@Model(file = "ctl/graphwalker/pmt/Updated_CreatePMTFlow.graphml")
public interface Updated_CreatePMTFlow {

    @Vertex()
    void v_Home();

    @Vertex()
    void v_Approve_Pendingproject();

    @Vertex()
    void v_CreateProject();

    @Vertex()
    void v_Pending_Process_Status_validation();

    @Edge()
    void e_Hover_Pending_Workflow();

    @Edge()
    void e_ValidDirectorCredentials();

    @Edge()
    void e_Logout();

    @Edge()
    void e_ValidManagerCredentials();

    @Edge()
    void e_Hover_Project();

    @Vertex()
    void v_BaseUrl();

    @Vertex()
    void v_Search_flow();
}
