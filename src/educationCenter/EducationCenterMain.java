package educationCenter;

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
            switch (command){
                case EXIT:
                    isRun=false;
                    System.out.println("Program was closed");
                    break;
                case ADD_LESSON:
                    addLesson();
                    //todo
                    break;
                case ADD_STUDENT:
                    //todo
                    break;
                case PRINT_STUDENTS:
                    //todo
                    break;
                case PRINT_LESSONS:
                    //todo
                    break;
                case CHANGE_STUDENT_LESSON:
                    //todo
                    break;
                case PRINT_STUDENTS_BY_LESSON_NAME:
                    //todo
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
    }


}
