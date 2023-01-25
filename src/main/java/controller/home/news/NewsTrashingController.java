package controller.home.news;

import dao.news.DBNews;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "NewsTrashingController", value="/deletenews")
public class NewsTrashingController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DBNews dbNews = new DBNews();
        if (dbNews.deleteNews(Integer.parseInt(req.getParameter("id")))) {
            resp.sendRedirect("/");
        }
    }
}
