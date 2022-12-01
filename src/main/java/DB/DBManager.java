package DB;

import entity.Student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class DBManager implements IDBManager {
    @Override
    public ArrayList<Student> getAllStudents() {
        ArrayList<Student> res = new ArrayList<>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/crm_student_4", "root", "admin");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from `student` where stsus = 1");
            while (rs.next()) {
                Student s = new Student();
                s.setId(rs.getInt("id"));
                s.setName(rs.getString("name"));
                s.setSurname(rs.getString("surname"));
                s.setGroup(rs.getString("group"));
                res.add(s);
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return res;
    }
}
