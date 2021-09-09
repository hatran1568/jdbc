package dao;

import model.Department;
import model.Student;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class StudentDAO extends BaseDAO{

    public ArrayList<Student> getStudents(){

        ArrayList<Student> students = new ArrayList<>();

        try {
            String sql = "SELECT s.id, s.`name`, s.gender, s.phone, s.dept_id, d.`name` as dept_name, d.founding_year\n" +
                    "FROM student s JOIN department d\n" +
                    "ON s.dept_id = d.id";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet resultSet = stm.executeQuery();

            while (resultSet.next()){

                Student s = new Student();
                s.setId(resultSet.getInt("id"));
                s.setName(resultSet.getNString("name"));
                s.setGender(resultSet.getBoolean("gender"));
                s.setPhone(resultSet.getString("phone"));

                Department dept = new Department();
                dept.setId(resultSet.getString("dept_id"));
                dept.setName(resultSet.getNString("dept_name"));
                dept.setFoundingYear(resultSet.getString("founding_year"));

                s.setDepartment(dept);

                students.add(s);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }
}
