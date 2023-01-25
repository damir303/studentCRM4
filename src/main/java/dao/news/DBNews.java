package dao.news;

import constants.Conections;
import model.News;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class DBNews implements IDBNews {
    @Override
    public ArrayList<News> getAllNews() throws SQLException {
        ArrayList<News> newsArrayList = new ArrayList<>();

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        try (Connection connection = DriverManager.getConnection(Conections.CONNCTIONS_URL, Conections.CONNCTIONS_USER, Conections.CONNCTIONS_PASSWORD)){
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM `news` WHERE `visible` = 1 ORDER BY id DESC");
            while (resultSet.next()) {
                News news = new News();
                news.setId(resultSet.getInt("id"));
                news.setCreateDate(resultSet.getDate("createDate"));
                news.setHeader(resultSet.getString("header"));
                news.setContent(resultSet.getString("content"));
                newsArrayList.add(news);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return newsArrayList;
    }

    @Override
    public boolean createNews(News news) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        try (Connection connection = DriverManager.getConnection(Conections.CONNCTIONS_URL, Conections.CONNCTIONS_USER, Conections.CONNCTIONS_PASSWORD)){
            Statement statement = connection.createStatement();
             int row = statement.executeUpdate("INSERT INTO `news` (`header`, `content`, `createDate`, `visible`) VALUES ('"
                    + news.getHeader() + "', '" + news.getContent() + "', '" +
                    new java.sql.Date(news.getCreateDate().getTime()) + "', 1)");
            return true;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean deleteNews(int id) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        try (Connection connection = DriverManager.getConnection(Conections.CONNCTIONS_URL, Conections.CONNCTIONS_USER, Conections.CONNCTIONS_PASSWORD)){
            Statement statement = connection.createStatement();
            int row = statement.executeUpdate(
                    "UPDATE `news` SET  `visible` = 0 WHERE `id`=" + id);
            return true;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean updateNews(News news) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        try (Connection connection = DriverManager.getConnection(Conections.CONNCTIONS_URL, Conections.CONNCTIONS_USER, Conections.CONNCTIONS_PASSWORD)){
            Statement statement = connection.createStatement();
            int row = statement.executeUpdate(
                    "UPDATE `news` SET  `header` = '"+ news.getHeader() +"', `content` = '"+ news.getContent() +"' WHERE `id`=" + news.getId());
            return true;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public News getNewsById(int id) throws SQLException{
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        try (Connection connection = DriverManager.getConnection(Conections.CONNCTIONS_URL, Conections.CONNCTIONS_USER, Conections.CONNCTIONS_PASSWORD)){
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM `news` WHERE id=" + id);
            if(resultSet.next()){
                News news = new News();
                news.setId(resultSet.getInt("id"));
                news.setHeader(resultSet.getString("header"));
                news.setContent(resultSet.getString("content"));
                news.setCreateDate(resultSet.getDate("createDate"));
                return news;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
