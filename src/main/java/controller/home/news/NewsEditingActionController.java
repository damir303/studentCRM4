package controller.home.news;

import dao.news.DBNews;
import model.News;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@WebServlet(name = "NewsEditingActionController", value="/editNewsAction")
public class NewsEditingActionController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");

        DBNews dbNews = new DBNews();
        String header = req.getParameter("header");
        String content = req.getParameter("content");

        News news = new News();
        news.setVisible(true);
        news.setHeader(header);
        news.setContent(content);
        news.setId(Integer.parseInt(req.getParameter("id")));

        if (dbNews.updateNews(news)) {
            resp.sendRedirect("/");
        }
    }
}
