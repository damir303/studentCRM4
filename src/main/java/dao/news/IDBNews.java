package dao.news;

import model.News;

import java.sql.SQLException;
import java.util.ArrayList;

public interface IDBNews {

    ArrayList<News> getAllNews() throws SQLException;

    boolean createNews(News news) throws SQLException;

    boolean deleteNews(int id) throws SQLException;

    boolean updateNews(News news) throws SQLException;

    News getNewsById(int id) throws SQLException;

}
