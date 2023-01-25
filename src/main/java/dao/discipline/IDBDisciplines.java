package dao.discipline;

import model.Discipline;

import java.sql.SQLException;
import java.util.ArrayList;

public interface IDBDisciplines {

    ArrayList<Discipline> getAllDisciplines() throws SQLException;

    void createDiscipline(Discipline discipline) throws SQLException;

    void deleteDiscipline(Discipline discipline) throws SQLException;

    void updateDiscipline(Discipline discipline) throws SQLException;

}
