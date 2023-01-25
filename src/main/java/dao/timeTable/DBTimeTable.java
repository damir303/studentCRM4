package dao.timeTable;

import constants.Conections;
import model.TimeTableItem;

import java.sql.*;
import java.util.HashMap;

public class DBTimeTable implements IDBTimeTable {

    @Override
    public HashMap<String, TimeTableItem> getTimeTable(int groupId) {
        HashMap<String, TimeTableItem> result = new HashMap<>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        try (Connection connection = DriverManager.getConnection(Conections.CONNCTIONS_URL, Conections.CONNCTIONS_USER, Conections.CONNCTIONS_PASSWORD)) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM `timeTable` WHERE `groupId` = " + groupId);
            while (resultSet.next()) {
                TimeTableItem timeTableItem = new TimeTableItem();
                timeTableItem.setId(resultSet.getInt("id"));
                timeTableItem.setGroupId(resultSet.getInt("groupId"));
                timeTableItem.setDayOfWeek(resultSet.getInt("dayOfWeek"));
                timeTableItem.setPairInIndex(resultSet.getInt("pairIndex"));
                timeTableItem.setContent(resultSet.getString("content"));
                result.put("" + timeTableItem.getDayOfWeek() + timeTableItem.getPairInIndex(), timeTableItem);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    @Override
    public TimeTableItem getTimetableByID(int id) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        try (Connection connection = DriverManager.getConnection(Conections.CONNCTIONS_URL, Conections.CONNCTIONS_USER, Conections.CONNCTIONS_PASSWORD)) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM `timeTable` WHERE `id`=" + id);
            if (resultSet.next()) {
                TimeTableItem timeTableItem = new TimeTableItem();
                timeTableItem.setId(resultSet.getInt("id"));
                timeTableItem.setGroupId(resultSet.getInt("groupId"));
                timeTableItem.setDayOfWeek(resultSet.getInt("dayOfWeek"));
                timeTableItem.setPairInIndex(resultSet.getInt("pairIndex"));
                timeTableItem.setContent(resultSet.getString("content"));
                return timeTableItem;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public void createNewTimetableItem(TimeTableItem timeTableItem) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        try (Connection connection = DriverManager.getConnection(Conections.CONNCTIONS_URL, Conections.CONNCTIONS_USER, Conections.CONNCTIONS_PASSWORD)) {
            Statement statement = connection.createStatement();
            int row = statement.executeUpdate("INSERT INTO `timeTable` (`groupId`, `dayOfWeek`, `pairIndex`, `content`) VALUES ('"
                    + timeTableItem.getGroupId() + "', '" + timeTableItem.getDayOfWeek() + "', '" + timeTableItem.getPairInIndex() + "', '" + timeTableItem.getContent() + "')");

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateTimetableItem(TimeTableItem timeTableItem) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        try (Connection connection = DriverManager.getConnection(Conections.CONNCTIONS_URL, Conections.CONNCTIONS_USER, Conections.CONNCTIONS_PASSWORD)) {
            Statement statement = connection.createStatement();
            int row = statement.executeUpdate(
                    "UPDATE `timeTable` SET  `groupId` = '" + timeTableItem.getGroupId()
                            + "', `dayOfWeek` = '" + timeTableItem.getDayOfWeek()
                            + "', `pairIndex` = '" + timeTableItem.getPairInIndex()
                            + "', `content` = '" + timeTableItem.getContent()
                            + "' WHERE `id`=" + timeTableItem.getId());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
