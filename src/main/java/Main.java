import dao.DepartmentDAO;
import dao.StudentDAO;
import model.Department;
import model.Student;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        DepartmentDAO departmentDAO = new DepartmentDAO();
        ArrayList<Department> departments = departmentDAO.getDepts();

        System.out.println("\nDepartment list: ");
        for (Department d : departments){
            System.out.println(d.toString());
        }

        StudentDAO studentDAO = new StudentDAO();
        ArrayList<Student> students = studentDAO.getStudents();

        System.out.println("\nStudent list: ");
        for (Student s : students){
            System.out.println(s.toString());
        }
    }
}
