package dao.student;

import constants.Conections;
import model.Group;
import model.News;
import model.Student;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

public class DBStudents implements IDBStudents{

    @Override
    public ArrayList<Student> getAllStudents() throws SQLException {
        ArrayList<Student> studentsArrayList = new ArrayList<>();

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        try (Connection connection = DriverManager.getConnection(Conections.CONNCTIONS_URL, Conections.CONNCTIONS_USER, Conections.CONNCTIONS_PASSWORD)){
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(getAllStudentsQuery());
            while (resultSet.next()) {
                Student student = new Student();
                student.setId(resultSet.getInt("id"));
                student.setFirstname(resultSet.getString("firstname"));
                student.setLastname(resultSet.getString("lastname"));
                student.setMiddlename(resultSet.getString("middlename"));
                student.setGroupid(resultSet.getInt("groupId"));
                student.setPhoneNumber(resultSet.getString("phoneNumber"));
                student.setEmail(resultSet.getString("email"));
                student.setGroupName(resultSet.getString("groupName"));
//                student.setAvatar(resultSet.getBytes("avatar"));
                if (resultSet.getDate("recieptDate") != null) {
                    student.setRecieptDate(resultSet.getDate("recieptDate").toLocalDate());
                }
                student.setStatus(resultSet.getBoolean("status"));
                studentsArrayList.add(student);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return studentsArrayList;
    }

    private String getAllStudentsQuery() {
        return "SELECT " +
                "    students.id," +
                "    students.firstname," +
                "    students.lastname," +
                "    students.middlename," +
                "    students.groupId," +
                "    students.phoneNumber," +
                "    students.email," +
                "    students.recieptDate," +
                "    students.status," +
                "    groupstable.groupName" +
                " FROM studentCRM.students AS students " +
                " LEFT JOIN studentCRM.groups AS groupstable" +
                " ON students.groupId = groupstable.groupId";
    }

    private String getStudentsFromGroupQuery(int groupId) {
        return "SELECT " +
                "    students.id," +
                "    students.firstname," +
                "    students.lastname," +
                "    students.middlename," +
                "    students.groupId," +
                "    students.phoneNumber," +
                "    students.email," +
                "    students.recieptDate," +
                "    students.status," +
                "    groupstable.groupName" +
                " FROM studentCRM.students AS students " +
                " INNER JOIN studentCRM.groups AS groupstable" +
                " ON students.groupId = groupstable.groupId" +
                " AND students.groupId = " + groupId;
    }
    @Override
    public boolean createStudents(Student student) throws SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        try (Connection connection = DriverManager.getConnection(Conections.CONNCTIONS_URL, Conections.CONNCTIONS_USER, Conections.CONNCTIONS_PASSWORD)){
            Statement statement = connection.createStatement();
            if (student.getId() == 0) {
                boolean row = statement.execute(
                        "INSERT INTO `students` (`firstname`, `lastname`, `middlename`, `groupId`, `recieptdate`, `email`, `phonenumber`, `status`, `avatar`)" +
                                " VALUES ('"
                                + student.getFirstname() + "', '" + student.getLastname() + "', '" +
                                student.getMiddlename() + "', '" + student.getGroupid() + "', '" +
                                new java.sql.Date(Date.valueOf(student.getRecieptDate()).getTime()) + "', '" +
                                student.getEmail() + "', '" + student.getPhoneNumber() + "', 1" + student.getAvatar() + ")");
            } else {
                int row = statement.executeUpdate(
                        "UPDATE `students` SET " +
                                "`firstname` = '" + student.getFirstname() +
                                "', `lastname` = '" + student.getLastname() +
                                "', `middlename` = '" + student.getMiddlename() +
                                "', `groupId` = '" + student.getGroupid() +
                                "', `email` = '" + student.getEmail() +
                                "', `phonenumber` = '" + student.getPhoneNumber() +
                                "', `recieptdate` = '" + new java.sql.Date(Date.valueOf(student.getRecieptDate()).getTime()) +
                                "', `avatar` = '" + student.getAvatar() +
                                "', `status` = " + (student.isStatus() ? "1" : "0") +
                                " WHERE `id` = " + student.getId());
            }
            return true;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Student getStudentById(int id) throws SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        try (Connection connection = DriverManager.getConnection(Conections.CONNCTIONS_URL, Conections.CONNCTIONS_USER, Conections.CONNCTIONS_PASSWORD)){
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM `students` WHERE id=" + id);
            if(resultSet.next()){
                Student student = new Student();
                student.setId(resultSet.getInt("id"));
                student.setFirstname(resultSet.getString("firstname"));
                student.setLastname(resultSet.getString("lastname"));
                student.setMiddlename(resultSet.getString("middlename"));
                student.setEmail(resultSet.getString("email"));
                student.setGroupid(resultSet.getInt("groupId"));
                student.setStatus(resultSet.getInt("status") == 1);
                student.setPhoneNumber(resultSet.getString("phonenumber"));
//                student.setAvatar(resultSet.getBytes("avatar"));
                if(resultSet.getDate("recieptDate") != null) {
                    student.setRecieptDate(resultSet.getDate("recieptDate").toLocalDate());
                }
                return student;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public void deleteStudents(Student student) throws SQLException {

    }

    @Override
    public void updateStudents(Student student) throws SQLException {

    }

    @Override
    public ArrayList<Group> getAllGroups() {
        ArrayList<Group> result = new ArrayList<>();

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        try (Connection connection = DriverManager.getConnection(Conections.CONNCTIONS_URL, Conections.CONNCTIONS_USER, Conections.CONNCTIONS_PASSWORD)){
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM `groups`");
            while (resultSet.next()) {
                Group group = new Group();
                group.setGroupID(resultSet.getInt("groupId"));
                group.setGroupName(resultSet.getString("groupName"));
                group.setCourseIndex(resultSet.getInt("courseIndex"));
                result.add(group);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    @Override
    public Group getGroupByID(int id) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        try (Connection connection = DriverManager.getConnection(Conections.CONNCTIONS_URL, Conections.CONNCTIONS_USER, Conections.CONNCTIONS_PASSWORD)){
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM `groups` WHERE `groupId` = " + id);
            Group group = new Group();
            if (resultSet.next()) {
                group.setGroupID(resultSet.getInt("groupId"));
                group.setGroupName(resultSet.getString("groupName"));
                group.setCourseIndex(resultSet.getInt("courseIndex"));
                return group;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public ArrayList<Student> getStudentFromGroup(int id) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        ArrayList<Student> studentsArrayList = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(Conections.CONNCTIONS_URL, Conections.CONNCTIONS_USER, Conections.CONNCTIONS_PASSWORD)){
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(getStudentsFromGroupQuery(id));
            while (resultSet.next()) {
                Student student = new Student();
                student.setId(resultSet.getInt("id"));
                student.setFirstname(resultSet.getString("firstname"));
                student.setLastname(resultSet.getString("lastname"));
                student.setMiddlename(resultSet.getString("middlename"));
                student.setGroupid(resultSet.getInt("groupId"));
                student.setPhoneNumber(resultSet.getString("phoneNumber"));
                student.setEmail(resultSet.getString("email"));
                student.setGroupName(resultSet.getString("groupName"));
                if (resultSet.getDate("recieptDate") != null) {
                    student.setRecieptDate(resultSet.getDate("recieptDate").toLocalDate());
                }
                student.setStatus(resultSet.getBoolean("status"));
                studentsArrayList.add(student);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return studentsArrayList;
    }
}
