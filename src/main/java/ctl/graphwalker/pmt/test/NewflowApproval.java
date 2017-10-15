// Generated by GraphWalker (http://www.graphwalker.org)
package ctl.graphwalker.pmt.test;

import org.graphwalker.java.annotation.Model;
import org.graphwalker.java.annotation.Vertex;
import org.graphwalker.java.annotation.Edge;

@Model(file = "ctl/graphwalker/pmt/NewflowApproval.graphml")
public interface NewflowApproval {

    @Vertex()
    void v_logout();

    @Edge()
    void e_Pending_task();

    @Edge()
    void e_ValidDirectorCredentials();

    @Vertex()
    void v_LoginPrompted();

    @Edge()
    void e_Hover2Project();

    @Vertex()
    void v_BaseUrl();

    @Vertex()
    void v_Nopending_Workflow_Task();

    @Vertex()
    void v_Home();

    @Vertex()
    void v_Pending_Workflow_Task();

    @Vertex()
    void v_Approve_Pendingproject();

    @Edge()
    void e_nextapproval();

    @Vertex()
    void v_AgainLoginPrompted();

    @Edge()
    void e_ValidManagerCredentials();

    @Edge()
    void e_StartClient();

    @Edge()
    void e_Approval_Reason();
}