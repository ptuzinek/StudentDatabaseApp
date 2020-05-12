package studentdatabaseapp;

import java.util.Scanner;

public class Student {
    private String firstName;
    private  String lastName;
    private int gradeYear;
    private String studentID;
    private String courses = "";
    private int tuitionBalance = 0;
    private static int costOfCourse = 600;
    private static int id = 1000;

    // Constructor: prompt user to enter student's name and year
    public Student() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nEnter student first name: ");
        this.firstName = scanner.nextLine();

        System.out.println("Enter student last name: ");
        this.lastName = scanner.nextLine();

        System.out.println("1 Freshmen\n2 Sophmore\n3 Junior\n4 Senior\nEnter student class level: ");
        this.gradeYear = scanner.nextInt();

        setStudentID();
    }

    // Generate ID
    private void setStudentID() {
        // Grade level + ID
        id++;
        this.studentID = gradeYear + "" + id;
    }
    // Enroll in courses
    public void  enroll() {
        // Get inside a loop, user hits 0
        do {
            System.out.print("Enter course to enroll (Q to quit): ");
            Scanner scanner = new Scanner(System.in);
            String course = scanner.nextLine();
            if (!course.equals("Q")) {
                courses += "\n  " + course;
                tuitionBalance += costOfCourse;
            }
            else break;
        } while (true);
    }
    // View balance
    public void viewBalance() {
        System.out.println("Your balance is $" + tuitionBalance);
    }
    // Pay Tuition
    public void payTuition() {
        viewBalance();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Your payment: $");
        int payment = scanner.nextInt();
        tuitionBalance -= payment;
        System.out.println("Thank You for Your payment of " + payment);
        viewBalance();
    }

    // Show status
    public String showInfo() {
        return "\nSTUDENT INFO: " +
                "\nName: " + firstName + " " + lastName +
                "\nGrade Level: " + gradeYear +
                "\nStudent ID: "  + studentID +
                "\nCourses Enrolled: " + courses +
                "\nBalance: $" + tuitionBalance;
    }
}
