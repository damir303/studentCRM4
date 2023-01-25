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
import java.util.*;

@WebServlet(name = "TimeTableController", value="/timetable")
public class TimeTableController extends HttpServlet {
    private DBTimeTable db = new DBTimeTable();
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
            resp.sendRedirect("/timetable?groupid=" + groups.get(0).getGroupID() + "&course=" + groups.get(0).getCourseIndex());
            return;
        }

        List<Group> groupsFromCourse = coursesMap.get(Integer.parseInt(course));
        groupid = "" + (groupid == "" && groupsFromCourse.size() > 0 ? groupsFromCourse.get(0).getGroupID() : groupid);

        if (groupsFromCourse.size() > 0 && groupid != "") {
            req.setAttribute("noData", false);
            req.setAttribute("groups", groupsFromCourse);

            ArrayList<ArrayList<TimeTableItem>> timeTable = new ArrayList<>();
            HashMap<String, TimeTableItem> timeTableMap = db.getTimeTable(Integer.parseInt(groupid));
            for (int i = 1; i < 8; i++) {
                ArrayList<TimeTableItem> week = new ArrayList<>();
                for (int j = 1; j < 7; j++) {
                    String key = "" + j + i;
                    if (timeTableMap.containsKey(key)) {
                        TimeTableItem timeTableItem = timeTableMap.get(key);
                        week.add(timeTableItem);
                    } else {
                        TimeTableItem timeTableItem = new TimeTableItem();
                        timeTableItem.setDayOfWeek(j);
                        timeTableItem.setGroupId(Integer.parseInt(groupid));
                        timeTableItem.setPairInIndex(i);
                        timeTableItem.setContent("");
                        week.add(timeTableItem);
                    }
                }
                timeTable.add(week);
            }

            Calendar calendar = Calendar.getInstance();
            calendar.setTime(new Date());
            req.setAttribute("today", calendar.get(Calendar.DAY_OF_WEEK));
            req.setAttribute("timetable", timeTable);
            req.setAttribute("selectedGroup", Integer.parseInt(groupid));
        } else {
            req.setAttribute("noData", true);
            req.setAttribute("selectedGroup", 0);
            req.setAttribute("groups", new ArrayList<Group>());
        }
        req.setAttribute("selectedCourse", Integer.parseInt(course));
        req.getRequestDispatcher("JSP/timeTable.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String groupid = req.getParameter("groupid");
        String course = req.getParameter("course");
        if (groupid == ""){
            resp.sendRedirect("/timetable?groupid=" + groupid + "&course=" + course);
        } else {
            Group group = dbStudents.getGroupByID(Integer.parseInt(groupid));
            resp.sendRedirect("/timetable?groupid=" + groupid + "&course=" + group.getCourseIndex());
        }
    }
}
