import java.sql.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n===== Student Management System =====");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Enter Choice: ");

            int choice = sc.nextInt();

            if (choice == 1) {
                try {
                    Connection con = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/schooldb",
                        "root",
                        "root123"
                    );

                    System.out.print("Enter Student ID: ");
                    int id = sc.nextInt();

                    System.out.print("Enter Student Name: ");
                    String name = sc.next();

                    PreparedStatement ps = con.prepareStatement(
                        "INSERT INTO students VALUES(?, ?)"
                    );

                    ps.setInt(1, id);
                    ps.setString(2, name);

                    int rows = ps.executeUpdate();

                    System.out.println(rows + " student added successfully");

                    con.close();

                } catch (Exception e) {
                    System.out.println(e);
                }
            }
            else if (choice == 2) {
                 try {
        Connection con = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/schooldb",
            "root",
            "root123"
        );

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
            else if (choice == 3) {
                try {
        Connection con = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/schooldb",
            "root",
            "root123"
        );

        System.out.print("Enter Student ID to Update: ");
        int id = sc.nextInt();

        System.out.print("Enter New Name: ");
        String name = sc.next();

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
            else if (choice == 4) {
                 try {
        Connection con = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/schooldb",
            "root",
            "root123"
        );

        System.out.print("Enter Student ID to Delete: ");
        int id = sc.nextInt();

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
            else if (choice == 5) {
                System.out.println("Exiting...");
                break;
            }
            else {
                System.out.println("Invalid Choice");
            }
        }

        sc.close();
    }
}