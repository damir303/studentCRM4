package dao.student;

import model.Group;
import model.News;
import model.Student;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

public interface IDBStudents {
    ArrayList<Student> getAllStudents() throws SQLException;

    boolean createStudents(Student student) throws SQLException;

    public Student getStudentById(int id) throws SQLException;

    void deleteStudents(Student student) throws SQLException;

    void updateStudents(Student student) throws SQLException;

    ArrayList<Group> getAllGroups();

    Group getGroupByID(int id);

    ArrayList<Student> getStudentFromGroup(int id);
}
