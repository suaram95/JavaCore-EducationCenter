package educationCenter.storage;

import educationCenter.exception.DuplicateStudentException;
import educationCenter.model.Gender;
import educationCenter.model.Lesson;
import educationCenter.model.Student;

public class StudentStorage {

    private Student[] students = new Student[10];
    private int size = 0;

    public void add(Student student) throws DuplicateStudentException {
        if (getByEmail(student.getEmail())!=null){
            throw new DuplicateStudentException("Student by email:"+"<"+student.getEmail()+">"+" already exists!!");
        }
        if (size == students.length) {
            extend();
        }
        students[size++] = student;
    }

    private void extend() {
        Student[] tmp = new Student[students.length + 10];
        System.arraycopy(students, 0, tmp, 0, students.length);
        students = tmp;
    }

    public Student getByEmail(String email) {
        for (int i = 0; i < size; i++) {
            if (students[i].getEmail().equals(email)) {
                return (students[i]);
            }
        }
        return null;
    }

    public void printByLesson(Lesson byName){
        for (int i = 0; i < size; i++) {
            for (Lesson lesson:students[i].getLessons()) {
                if (lesson.equals(byName)){
                    System.out.println(students[i]);
                    break;
                }
            }
        }
    }

    public void printMaleStudents(){
        for (int i = 0; i < size; i++) {
            if (students[i].getGender()== Gender.MALE){
                System.out.println(students[0]);
            }
        }
    }

    public void printFemaleStudents(){
        for (int i = 0; i < size; i++) {
            if (students[i].getGender()== Gender.FEMALE){
                System.out.println(students[0]);
            }
        }
    }



    public void print() {
        for (int i = 0; i < size; i++) {
            System.out.println(students[i]);
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }


}
