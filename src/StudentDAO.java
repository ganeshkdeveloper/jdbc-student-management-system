import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class StudentDAO {

    public void addStudent(Student student) {
        try {
            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(
                "INSERT INTO students VALUES(?, ?)"
            );

            ps.setInt(1, student.getId());
            ps.setString(2, student.getName());

            int rows = ps.executeUpdate();

            System.out.println(rows + " student added successfully");

            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public void viewStudents() {

    try {
        Connection con = DBConnection.getConnection();

        PreparedStatement ps = con.prepareStatement(
            "SELECT * FROM students"
        );

        ResultSet rs = ps.executeQuery();

        System.out.println("\nID\tNAME");
        System.out.println("--------------");

        while (rs.next()) {
            System.out.println(
                rs.getInt("id") + "\t" +
                rs.getString("name")
            );
        }

        con.close();

    } catch (Exception e) {
        System.out.println(e);
    }
}
public void updateStudent(int id, String name) {

    try {
        Connection con = DBConnection.getConnection();

        PreparedStatement ps = con.prepareStatement(
            "UPDATE students SET name=? WHERE id=?"
        );

        ps.setString(1, name);
        ps.setInt(2, id);

        int rows = ps.executeUpdate();

        System.out.println(rows + " student updated");

        con.close();

    } catch (Exception e) {
        System.out.println(e);
    }
}
public void deleteStudent(int id) {

    try {
        Connection con = DBConnection.getConnection();

        PreparedStatement ps = con.prepareStatement(
            "DELETE FROM students WHERE id=?"
        );

        ps.setInt(1, id);

        int rows = ps.executeUpdate();

        System.out.println(rows + " student deleted");

        con.close();

    } catch (Exception e) {
        System.out.println(e);
    }
}
public void searchStudent(int id) {

    try {

        Connection con = DBConnection.getConnection();

        PreparedStatement ps = con.prepareStatement(
            "SELECT * FROM students WHERE id=?"
        );

        ps.setInt(1, id);

        ResultSet rs = ps.executeQuery();

        if(rs.next()) {

            System.out.println("\nStudent Found");
            System.out.println("ID: " + rs.getInt("id"));
            System.out.println("Name: " + rs.getString("name"));

        } else {

            System.out.println("Student Not Found");
        }

        con.close();

    } catch (Exception e) {
        System.out.println(e);
    }
}public void searchStudentByName(String name) {

    try {

        Connection con = DBConnection.getConnection();

        PreparedStatement ps = con.prepareStatement(
            "SELECT * FROM students WHERE name=?"
        );

        ps.setString(1, name);

        ResultSet rs = ps.executeQuery();

        if(rs.next()) {

            System.out.println("\nStudent Found");
            System.out.println("ID: " + rs.getInt("id"));
            System.out.println("Name: " + rs.getString("name"));

        } else {

            System.out.println("Student Not Found");
        }

        con.close();

    } catch (Exception e) {
        System.out.println(e);
    }
}
}