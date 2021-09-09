package dao;

import model.Department;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DepartmentDAO extends BaseDAO{
    public ArrayList<Department> getDepts(){
        ArrayList<Department> depts = new ArrayList<>();

        try {
            String sql = "SELECT id, `name`, founding_year FROM department";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet resultSet = stm.executeQuery();

            while (resultSet.next()){
                Department dept = new Department();
                dept.setId(resultSet.getString("id"));
                dept.setName(resultSet.getNString("name"));
                dept.setFoundingYear(resultSet.getString("founding_year"));

                depts.add(dept);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return depts;
    }


}
