import entity.Course;
import entity.Student;
import entity.Registration;
import service.StudentService;
import service.CourseService;
import service.RegistrationService;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        StudentService studentService = new StudentService();
        CourseService courseService = new CourseService();
        RegistrationService registrationService = new RegistrationService();

        while (true) {

            System.out.println("\n===== COURSE REGISTRATION SYSTEM =====");
            System.out.println("1. Add Student");
            System.out.println("2. Add Course");
            System.out.println("3. Register Student to Course");
            System.out.println("4. View Students");
            System.out.println("5. View Courses");
            System.out.println("6. View Registrations");
            System.out.println("7.exit");

            System.out.println("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
        }
    }
}