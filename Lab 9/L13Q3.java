//WONG YOONG YEE, UM AY2023/2024, WIX1002
import java.io.*;
import java.util.*;

class PersonProfile {
    protected String name, gender, dateOfBirth;

    public PersonProfile(String name, String gender, String dateOfBirth) {
        this.name = name;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
    }

    public void profileDisplay() {
        System.out.println("Name: " + name);
        System.out.println("Gender: " + gender);
        System.out.println("Date of Birth: " + dateOfBirth);
    }
}

class Lecturer extends PersonProfile {
    private ArrayList<String> courseCodes, courseNames, sessions, semesters;
    private ArrayList<Integer> creditHours, registeredStudentNumber;
    private String fileName;

    public Lecturer(String name, String gender, String dateOfBirth, String fileName) {
        super(name, gender, dateOfBirth);
        this.fileName = fileName;
        this.courseCodes = new ArrayList<>();
        this.courseNames = new ArrayList<>();
        this.sessions = new ArrayList<>();
        this.semesters = new ArrayList<>();
        this.creditHours = new ArrayList<>();
        this.registeredStudentNumber = new ArrayList<>();
        readLecturerDetails();
    }

    private void readLecturerDetails() {
        try {
            Scanner input = new Scanner(new File(fileName));

            while(input.hasNextLine()) {
                String courseCode = input.nextLine();
                String courseName = input.nextLine();
                String lectureSession = input.nextLine();
                String lectureSemester = input.nextLine();
                int lectureCreditHours = Integer.parseInt(input.nextLine());
                int lectureStudentNumber = Integer.parseInt(input.nextLine());
    
                courseCodes.add(courseCode);
                courseNames.add(courseName);
                sessions.add(lectureSession);
                semesters.add(lectureSemester);
                creditHours.add(lectureCreditHours);
                registeredStudentNumber.add(lectureStudentNumber);
            }

            input.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found exception.");
            e.printStackTrace();
        }
    }

    public void displayLecturerDetails() {
        profileDisplay();
        System.out.println("Course Details:");

        for (int i = 0; i < courseNames.size(); i++) {
            System.out.println("Course Code: " + courseCodes.get(i));
            System.out.println("Course Name: " + courseNames.get(i));
            System.out.println("Session: " + sessions.get(i));
            System.out.println("Semester: " + semesters.get(i));
            System.out.println("Original Credit Hour: " + creditHours.get(i));
            System.out.println("Number of Students Registered: " + registeredStudentNumber.get(i));
            updateCreditHour(i);
            System.out.println("Updated Credit Hour: " + creditHours.get(i));
            System.out.println();
        }
    }

    private void updateCreditHour(int index) {
        int studentsRegistered = registeredStudentNumber.get(index);

        if(studentsRegistered >= 150) {
            creditHours.set(index, creditHours.get(index) * 3);
        } else if(studentsRegistered >= 100) {
            creditHours.set(index, creditHours.get(index) * 2);
        } else if(studentsRegistered >= 50) {
            creditHours.set(index, (int) (creditHours.get(index) * 1.5));
        } else {
            creditHours.set(index, (int) (creditHours.get(index) * 1));
        }
    }
}

public class L13Q3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String fileName = "lecturer.txt";
        System.out.println("Enter the name of the lecturer.");
        String lecturerName = input.nextLine();
        System.out.println("Enter the gender of the lecturer.");
        String lecturerGender = input.nextLine();
        System.out.println("Enter the date of birth of the lecturer.");
        String lecturerDateOfBirth = input.nextLine();

        Lecturer lecturer = new Lecturer(lecturerName, lecturerGender, lecturerDateOfBirth, fileName);
        lecturer.displayLecturerDetails();
        input.close();
    }
}
