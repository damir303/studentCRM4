package controller;

import dao.discipline.DBDiscipline;
import dao.student.DBStudents;
import model.Discipline;
import model.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet(name = "DisciplinesController", value="/disciplines")
public class DisciplinesController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DBDiscipline dbDiscipline = new DBDiscipline();
        try {
            ArrayList<Discipline> allDisciplines = dbDiscipline.getAllDisciplines();
            req.setAttribute("allDisciplines", allDisciplines);
            req.getRequestDispatcher("JSP/disciplines.jsp").forward(req, resp);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
