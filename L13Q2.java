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

class Student extends PersonProfile {
    private ArrayList<String> courseNames, courseCodes, sessions, semesters;
    private ArrayList<Double> marks;
    private String fileName;

    public Student(String name, String gender, String dateOfBirth, String fileName) {
        super(name, gender, dateOfBirth);
        this.fileName = fileName;
        this.courseCodes = new ArrayList<>();
        this.courseNames = new ArrayList<>();
        this.sessions = new ArrayList<>();
        this.semesters = new ArrayList<>();
        this.marks = new ArrayList<>();
        readCourseDetails();
    }

    private void readCourseDetails() {
        try {
            Scanner input = new Scanner(new FileInputStream(fileName));
    
            while(input.hasNextLine()) {
                String courseCode = input.nextLine();
                String courseName = input.nextLine();
                String studentSemester = input.nextLine();
                String studentSession = input.nextLine();
                double studentMarks = Double.parseDouble(input.nextLine());
    
                courseCodes.add(courseCode);
                courseNames.add(courseName);
                semesters.add(studentSemester);
                sessions.add(studentSession);
                marks.add(studentMarks);
            }
    
            input.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found exception.");
            e.printStackTrace();
        }
    }

    public void displayStudentDetails() {
        profileDisplay();
        System.out.println("Course Details:");

        for(int i = 0; i < courseNames.size(); i++) {
            System.out.println("Course Code: " + courseCodes.get(i));
            System.out.println("Course Name: " + courseNames.get(i));
            System.out.println("Session: " + sessions.get(i));
            System.out.println("Semester: " + semesters.get(i));
            System.out.println("Mark: " + marks.get(i));
            System.out.println("Grade: " + getGrade(marks.get(i)));
            System.out.println();
        }
    }

    private String getGrade(double mark) {
        if (mark >= 85) {
            return "A";
        } else if (mark >= 75) {
            return "A-";
        } else if (mark >= 70) {
            return "B+";
        } else if (mark >= 65) {
            return "B";
        } else if (mark >= 60) {
            return "B-";
        } else if (mark >= 55) {
            return "C+";
        } else if (mark >= 50) {
            return "C";
        } else if (mark >= 45) {
            return "D";
        } else if (mark >= 35) {
            return "E";
        } else {
            return "F";
        }
    }
}

public class L13Q2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String fileName = "course.txt";
        System.out.println("Enter the name of the student.");
        String studentName = input.nextLine();
        System.out.println("Enter the gender of the student.");
        String studentGender = input.nextLine();
        System.out.println("Enter the date of birth of the student.");
        String studentDateOfBirth = input.nextLine();
        System.out.println();

        Student student = new Student(studentName, studentGender, studentDateOfBirth, fileName);
        student.displayStudentDetails();
        input.close();
    }
}