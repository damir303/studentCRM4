package controller.timetable;

import dao.student.DBStudents;
import dao.timeTable.DBTimeTable;
import model.Group;
import model.TimeTableItem;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

@WebServlet(name = "TimeTableEditingController", value="/timetableEditing")
public class TimeTableEditingController extends HttpServlet {
    private DBTimeTable db = new DBTimeTable();
    private DBStudents dbStudents = new DBStudents();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        TimeTableItem timeTableItem = db.getTimetableByID(id);
        if (timeTableItem == null) {
            timeTableItem = new TimeTableItem();
            timeTableItem.setGroupId(Integer.parseInt(req.getParameter("groupId")));
            timeTableItem.setDayOfWeek(Integer.parseInt(req.getParameter("dayOfWeek")));
            timeTableItem.setPairInIndex(Integer.parseInt(req.getParameter("pairInIndex")));
        }
        req.setAttribute("groupName", dbStudents.getGroupByID(timeTableItem.getGroupId()).getGroupName());
        req.setAttribute("timeTableItem", timeTableItem);
        req.getRequestDispatcher("JSP/timetableEditing.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");

        int id = req.getParameter("id") == "" ? -1 : Integer.parseInt(req.getParameter("id"));
        int groupId = Integer.parseInt(req.getParameter("groupId"));
        int dayOfWeek = Integer.parseInt(req.getParameter("dayOfWeek"));
        int pairInIndex = Integer.parseInt(req.getParameter("pairInIndex"));
        String content = req.getParameter("content");
        TimeTableItem timeTableItem = db.getTimetableByID(id);
        if (timeTableItem  == null) {
            timeTableItem = new TimeTableItem();
            timeTableItem.setGroupId(groupId);
            timeTableItem.setDayOfWeek(dayOfWeek);
            timeTableItem.setPairInIndex(pairInIndex);
            timeTableItem.setContent(content);
            db.createNewTimetableItem(timeTableItem);
        } else {
            timeTableItem.setContent(content);
            db.updateTimetableItem(timeTableItem);
        }

        Group group = dbStudents.getGroupByID(groupId);
        resp.sendRedirect("/timetable?groupid=" + timeTableItem.getGroupId() + "&course=" + group.getCourseIndex());
    }
}
