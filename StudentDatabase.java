package studentdatabaseapp;

import java.util.Arrays;
import java.util.Scanner;

public class StudentDatabase {
    private int studentsNumber;
    private String[] studentsName;
    private int[] studentsYear;
    private String[] studentsID;
    private int[] balance;
    private int courseCost = 600;
    private String[] coursesEnrolled = new String[5];
    private String grade = "4";
    private int[] payTuition;

    public StudentDatabase() {
        System.out.println("How many students will be added?");
        Scanner scanner = new Scanner(System.in);
        this.studentsNumber = scanner.nextInt();
        this.studentsName = new String[studentsNumber];
        this.studentsYear = new int[studentsNumber];
        this.studentsID = new String[studentsNumber];
        this.payTuition = new int[studentsNumber];
        this.balance = new int[studentsNumber];
        scanner.nextLine();
        for (int i = 0; i < this.studentsNumber; i++) {
            System.out.println("NAME of the student: ");
            this.studentsName[i] = scanner.nextLine();
            System.out.println("YEAR of the student: ");
            this.studentsYear[i] = scanner.nextInt();
            scanner.nextLine();

            System.out.println("Student's ID: " + creatID(i));
        }

        // User handling
        System.out.println("Provide your student ID:");
        int studentNum = Arrays.asList(studentsID).indexOf(scanner.nextLine()); // tutaj potrzebuje indeksu pasujacego ID w tablicy ID
        System.out.println("Provide your balance:");
        balance[studentNum] = scanner.nextInt();
        scanner.nextLine();
        boolean enrolling = true;
        int j = 0;
        while (enrolling && j < 5 && balance[studentNum] >= 600) {
            System.out.println("What courses You want to enroll?");
            System.out.println("0 History 101\n" +
                    "1 Mathematics 101\n" +
                    "2 English 101\n" +
                    "3 Chemistry 101\n" +
                    "4 Computer Science 101\n");
            int course = scanner.nextInt();
            scanner.nextLine();
            if (course == 0) {
                coursesEnrolled[j] = "History 101";
                payTuition[studentNum] += 600;
                balance[studentNum] -= 600;
            }
            if (course == 0) {
                coursesEnrolled[j] = "Mathematics 101";
                payTuition[studentNum] += 600;
                balance[studentNum] -= 600;
            }
            if (course == 0) {
                coursesEnrolled[j] = "English 101";
                payTuition[studentNum] += 600;
                balance[studentNum] -= 600;
            }
            if (course == 0) {
                coursesEnrolled[j] = "Chemistry 101";
                payTuition[studentNum] += 600;
                balance[studentNum] -= 600;
            }
            if (course == 0) {
                coursesEnrolled[j] = "Computer Science 101";
                payTuition[studentNum] += 600;
                balance[studentNum] -= 600;
            }

            System.out.println("Your balance is: " + balance[studentNum]);
            System.out.println("Your pay tuition is: " + payTuition[studentNum]);
            System.out.println("Do You want to add another course?\ny or n?");
            String decision = scanner.nextLine();
            if (decision.equals("n")) enrolling = false;
            j++;
        }

        System.out.println(showInfo(studentsID[studentNum] ,studentNum));

    }

    // Create ID
    private String creatID(int studentNumber) {
        String numbers = "0123456789";
        this.studentsID[studentNumber] = this.grade;
        for(int i = 1; i < 5; i++) {
            int rand = (int) (Math.random() * numbers.length());
            this.studentsID[studentNumber] += numbers.charAt(rand);
        }
        return studentsID[studentNumber];
    }

    // Show Info
    public String showInfo(String studentID, int studentNum){
        return "NAME: " + studentsName[studentNum] +
                "\nID: " + studentID +
                "\nCOURSES ENROLLED: " + coursesEnrolled.toString() +
                "\nBALANCE " + balance[studentNum];

    }
}
