// Generated by GraphWalker (http://www.graphwalker.org)
package ctl.graphwalker.pmt.test;

import org.graphwalker.java.annotation.Model;
import org.graphwalker.java.annotation.Vertex;
import org.graphwalker.java.annotation.Edge;

@Model(file = "ctl/graphwalker/pmt/ProjectClosure.graphml")
public interface ProjectClosure {

    @Vertex()
    void v_logout();

    @Vertex()
    void v_Project_closureinitiated();

    @Edge()
    void e_Project_closure();

    @Edge()
    void e_Accepting_Projectclosure();

    @Vertex()
    void v_Project_closure();
}
