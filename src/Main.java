// import java.sql.*;
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
               System.out.print("Enter Student ID: ");
    int id = sc.nextInt();

    System.out.print("Enter Student Name: ");
    String name = sc.next();

    Student student = new Student(id, name);

    StudentDAO dao = new StudentDAO();

    dao.addStudent(student);
            }
            else if (choice == 2) {
                  StudentDAO dao = new StudentDAO();

    dao.viewStudents();
            }
            else if (choice == 3) {
                  System.out.print("Enter Student ID to Update: ");
    int id = sc.nextInt();

    System.out.print("Enter New Name: ");
    String name = sc.next();

    StudentDAO dao = new StudentDAO();

    dao.updateStudent(id, name);
            }
            else if (choice == 4) {
                  System.out.print("Enter Student ID to Delete: ");
    int id = sc.nextInt();

    StudentDAO dao = new StudentDAO();

    dao.deleteStudent(id);
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