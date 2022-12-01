package controller;

import DB.DBManager;
import entity.Student;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "StudenController", value = "/student")
public class StudenController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DBManager manager = new DBManager();
        ArrayList<Student> allStudents = manager.getAllStudents();
        request.setAttribute("allStudents",allStudents);
        request.getRequestDispatcher("JSP/student.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
