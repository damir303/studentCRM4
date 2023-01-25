package controller.student;

import dao.news.DBNews;
import dao.student.DBStudents;
import model.Group;
import model.News;
import model.Student;
import model.TimeTableItem;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name = "StudentsController", value="/students")
public class StudentsController extends HttpServlet {

    private DBStudents dbStudents = new DBStudents();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ArrayList<Group> groups = dbStudents.getAllGroups();

        HashMap<Integer, List<Group>> coursesMap = new HashMap<>();
        for (int i = 1; i <= 4; i++) {
            final int courseIndex = i;
            List<Group> groupsFilteredByCourse = groups.stream().filter((Group groupItem) -> groupItem.getCourseIndex() == courseIndex).toList();
            coursesMap.put(i, groupsFilteredByCourse);
        }

        String groupid = req.getParameter("groupid");
        String course = req.getParameter("course");
        if (groupid == null && groups.size() > 0) {
            resp.sendRedirect("/students?groupid=" + groups.get(0).getGroupID() + "&course=" + groups.get(0).getCourseIndex());
            return;
        }

        List<Group> groupsFromCourse = coursesMap.get(Integer.parseInt(course));
        groupid = "" + (groupid == "" && groupsFromCourse.size() > 0 ? groupsFromCourse.get(0).getGroupID() : groupid);

        if (groupsFromCourse.size() > 0 && groupid != "") {
            req.setAttribute("groups", groupsFromCourse);

            req.setAttribute("selectedGroup", Integer.parseInt(groupid));
        } else {
            req.setAttribute("selectedGroup", 0);
            req.setAttribute("groups", new ArrayList<Group>());
        }

        ArrayList<Student> studentFromGroup = dbStudents.getStudentFromGroup(Integer.parseInt(groupid));

        req.setAttribute("noData", studentFromGroup.size() > 0);
        req.setAttribute("students", studentFromGroup);
        req.setAttribute("selectedCourse", Integer.parseInt(course));
        req.getRequestDispatcher("JSP/students.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String groupid = req.getParameter("groupid");
        String course = req.getParameter("course");
        if (groupid == ""){
            resp.sendRedirect("/students?groupid=" + groupid + "&course=" + course);
        } else {
            Group group = dbStudents.getGroupByID(Integer.parseInt(groupid));
            resp.sendRedirect("/students?groupid=" + groupid + "&course=" + group.getCourseIndex());
        }
    }
}
