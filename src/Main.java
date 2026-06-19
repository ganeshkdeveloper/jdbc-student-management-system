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
                System.out.println("View Students Selected");
            }
            else if (choice == 3) {
                System.out.println("Update Student Selected");
            }
            else if (choice == 4) {
                System.out.println("Delete Student Selected");
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