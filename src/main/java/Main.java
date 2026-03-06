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

            switch (choice) {

                case 1:

                    System.out.println("Enter student name: ");
                    String name = scanner.nextLine();

                    System.out.println("Enter email: ");
                    String email = scanner.nextLine();

                    studentService.saveStudent(name,email);
                    System.out.println("Student added!");
                    break;

                case 2:
                    System.out.println("Enter course title: ");
                    String title = scanner.nextLine();

                    System.out.println("Enter course instructor: ");
                    String instructor = scanner.nextLine();

                    courseService.addCourse(title,instructor);
                    System.out.println("Course added successfully!");
                    break;

                case 3:
                    System.out.println("Enter student id: ");
                    Long studentId = scanner.nextLong();

                    System.out.println("Enter course id: ");
                    Long courseId = scanner.nextLong();

                    registrationService.registerStudent(studentId,courseId);
                    System.out.println("Student was registered to course successfully!");
                    break;

                case 4:
                    List<Student> allStudents = studentService.getAllStudents();
                    allStudents.forEach(s ->
                                    System.out.println("id: " + s.getId() + "\nname: " + s.getName()
                                            + "\n email: " + s.getEmail())
                            );
                    break;

                case 5:
                    List<Course> allCourses = courseService.getAllCourses();
                    allCourses.forEach(c ->
                                    System.out.println("id: " + c.getId() + "\ntitle: " + c.getTitle()
                                    + "\ninstructor: " + c.getInstructor())
                            );
                    break;

                case 6:
                    List<Registration> allRegistrations = registrationService.getAllRegistrations();
                    allRegistrations.forEach(r ->
                                    System.out.println("id: " + r.getId() + "\nstudentId: " + r.getStudent() +
                                            "\ncourseId: " + r.getCourse())
                            );
                    break;

                case 7:
                    System.exit(0);

                default:
                    System.out.println("Invalid input entered!");
                    break;
            }
        }
    }
}