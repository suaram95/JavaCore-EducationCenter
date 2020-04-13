package educationCenter;

import educationCenter.model.Lesson;
import educationCenter.model.Student;
import educationCenter.storage.LessonStorage;
import educationCenter.storage.StudentStorage;

import java.util.Scanner;

public class EducationCenterMain implements Commands {

    private static Scanner scanner = new Scanner(System.in);
    private static LessonStorage lessonStorage = new LessonStorage();
    private static StudentStorage studentStorage = new StudentStorage();

    public static void main(String[] args) {
        boolean isRun = true;
        while (isRun) {
            printCommands();
            int command = Integer.parseInt(scanner.nextLine());
            switch (command) {
                case EXIT:
                    isRun = false;
                    System.out.println("Program was closed");
                    break;
                case ADD_LESSON:
                    addLesson();
                    break;
                case ADD_STUDENT:
                    addStudent();
                    break;
                case PRINT_STUDENTS:
                    studentStorage.print();
                    break;
                case PRINT_LESSONS:
                    lessonStorage.print();
                    break;
                case CHANGE_STUDENT_LESSON:
                    changeStudentLessons();
                    break;
                case PRINT_STUDENTS_BY_LESSON_NAME:
                    printStudentsByLessonName();
                    break;
                default:
                    System.out.println("Wrong Command!!");
            }
        }
    }

    private static void printCommands() {
        System.out.println("Please Input " + EXIT + " for EXIT");
        System.out.println("Please Input " + ADD_LESSON + " to ADD LESSON");
        System.out.println("Please Input " + ADD_STUDENT + " to ADD STUDENT");
        System.out.println("Please Input " + PRINT_STUDENTS + " to SEE ALL STUDENTS");
        System.out.println("Please Input " + PRINT_LESSONS + " to PRINT LESSONS");
        System.out.println("Please Input " + CHANGE_STUDENT_LESSON + " TO CHANGE STUDENT LESSON");
        System.out.println("Please Input " + PRINT_STUDENTS_BY_LESSON_NAME + " PRINT STUDENTS BY LESSON NAME");
    }

    private static void addLesson() {
        System.out.println("Please input lesson data /Name, Lecturer Name, Duration, Price/");
        String lessonDataStr = scanner.nextLine();
        String[] lessonData = lessonDataStr.split(",");
        Lesson byName = lessonStorage.getByName(lessonData[0]);
        if (byName != null) {
            System.out.println("Duplicate lesson!");
            addLesson();
        } else {
            Lesson lesson = new Lesson();
            lesson.setName(lessonData[0]);
            lesson.setLecturerName(lessonData[1]);
            lesson.setDuration(Integer.parseInt(lessonData[2]));
            lesson.setPrice(Double.parseDouble(lessonData[3]));
            lessonStorage.add(lesson);
            System.out.println("Lesson was added!");
        }
    }

    private static void addStudent() {
        if (lessonStorage.isEmpty()) {
            System.out.println("Please add lesson first");
            return;
        }
        Lesson[] lessons = chooseLessons();
        if (lessons.length > 0) {

            System.out.println("Please input student data /Name, Surname, Phone, E-mail/");
            String studentDataStr = scanner.nextLine();
            String[] studentData = studentDataStr.split(",");
            Student byEmail = studentStorage.getByEmail(studentData[3]);
            if (byEmail != null) {
                System.out.println("Duplicate student!");
                addStudent();
            } else {
                Student student = new Student();
                student.setName(studentData[0]);
                student.setSurname(studentData[1]);
                student.setPhone(studentData[2]);
                student.setEmail(studentData[3]);
                student.setLessons(lessons);
                studentStorage.add(student);
                System.out.println("Thank you, Student was added.");
            }
        }
    }

    private static void changeStudentLessons() {
        System.out.println("Please input Student E-mail");
        String studentName = scanner.nextLine();
        Student student = studentStorage.getByEmail(studentName);
        if (student == null) {
            System.out.println("Wrong name!");
            changeStudentLessons();
        } else {
            Lesson[] lessons = chooseLessons();
            if (lessons.length>0) {
                student.setLessons(lessons);
                System.out.println("Student lessons are changed");
            }
        }
    }

    private static void printStudentsByLessonName() {
        System.out.println("Please Input lesson name");
        String lessonName = scanner.nextLine();
        Lesson byName = lessonStorage.getByName(lessonName);
        if (byName == null) {
            System.out.println("Wrong lesson name!");
            printStudentsByLessonName();
        } else {
            studentStorage.printByLesson(byName);
        }
    }


    private static Lesson[] chooseLessons() {
        System.out.println("Please choose lessons from list");
        lessonStorage.print();
        String lessonsStr = scanner.nextLine();
        String[] lessonNames = lessonsStr.split(",");
        Lesson[] lessons = new Lesson[lessonNames.length];
        int i = 0;
        for (String lessonName : lessonNames) {
            Lesson byName = lessonStorage.getByName(lessonName);
            if (byName != null) {
                lessons[i++] = byName;
            }
        }
        return lessons;
    }


}
