// Generated by GraphWalker (http://www.graphwalker.org)
package ctl.graphwalker.pmt.test;

import org.graphwalker.java.annotation.Model;
import org.graphwalker.java.annotation.Vertex;
import org.graphwalker.java.annotation.Edge;

@Model(file = "ctl/graphwalker/pmt/Updated_LoginPMT.graphml")
public interface Updated_LoginPMT {

    @Vertex()
    void v_Home();

    @Edge()
    void e_Logout();

    @Vertex()
    void v_LoginPrompted();

    @Vertex()
    void v_BaseUrl();

    @Edge()
    void e_StartClient();

    @Edge()
    void e_Init();

    @Edge()
    void e_Valid_Manager_Credentials();

    @Edge()
    void e_InvalidCredentials();
}