package educationCenter.storage;

import educationCenter.model.Lesson;

public class LessonStorage {

    private Lesson[] lessons = new Lesson[10];
    private int size = 0;

    public void add(Lesson lesson){
        if (size==lessons.length){
            extend();
        }
        lessons[size++]=lesson;
    }

    private void extend() {
        Lesson[] tmp=new Lesson[lessons.length+10];
        System.arraycopy(lessons,0,tmp,0,lessons.length);
        lessons=tmp;
    }

    public void print(){
        for (int i = 0; i < size; i++) {
            System.out.println(lessons[i]);
        }
    }

}
