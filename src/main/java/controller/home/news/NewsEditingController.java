package controller.home.news;

import dao.news.DBNews;
import model.News;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet(name = "NewsEditingController", value="/editnews")
public class NewsEditingController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DBNews dbNews = new DBNews();
        try {
            News news = dbNews.getNewsById(Integer.parseInt(req.getParameter("id")));
            req.setAttribute("newsid", news.getId());
            req.setAttribute("newsheader", news.getHeader());
            req.setAttribute("newscontent", news.getContent());
            req.getRequestDispatcher("JSP/newsEditing.jsp").forward(req, resp);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
