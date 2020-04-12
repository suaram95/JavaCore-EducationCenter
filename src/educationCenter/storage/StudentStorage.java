package educationCenter.storage;

import educationCenter.model.Student;

public class StudentStorage {

    private Student[] students = new Student[10];
    private int size = 0;

    public void add(Student student){
        if (size==students.length){
            extend();
        }
        students[size++]=student;
    }

    private void extend() {
        Student[] tmp=new Student[students.length+10];
        System.arraycopy(students,0,tmp,0,students.length);
        students=tmp;
    }

    public void print(){
        for (int i = 0; i < size; i++) {
            System.out.println(students[i]);
        }
    }



}
