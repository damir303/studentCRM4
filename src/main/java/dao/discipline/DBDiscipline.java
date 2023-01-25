package dao.discipline;

import constants.Conections;
import model.Discipline;
import model.News;

import java.sql.*;
import java.util.ArrayList;

public class DBDiscipline implements IDBDisciplines{
    @Override
    public ArrayList<Discipline> getAllDisciplines() throws SQLException {
        ArrayList<Discipline> disciplinesArrayList = new ArrayList<>();

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        try (Connection connection = DriverManager.getConnection(Conections.CONNCTIONS_URL, Conections.CONNCTIONS_USER, Conections.CONNCTIONS_PASSWORD)){
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(getAllDisciplinesQuery());
            while (resultSet.next()) {
                Discipline discipline = new Discipline();
                discipline.setId(resultSet.getInt("id"));
                discipline.setName(resultSet.getString("name"));
                disciplinesArrayList.add(discipline);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return disciplinesArrayList;
    }

    private String getAllDisciplinesQuery() {
        return "SELECT * FROM `disciplines`";
    }


    @Override
    public void createDiscipline(Discipline discipline) throws SQLException {

    }

    @Override
    public void deleteDiscipline(Discipline discipline) throws SQLException {

    }

    @Override
    public void updateDiscipline(Discipline discipline) throws SQLException {

    }
}
