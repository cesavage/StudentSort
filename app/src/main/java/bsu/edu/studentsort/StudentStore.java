package bsu.edu.studentsort;

import java.util.ArrayList;
import java.util.List;

public class StudentStore {
    public static StudentStore sStudentStore;
    public List<Student> mStudentList;

    private StudentStore(){
        mStudentList = new ArrayList<>();
    }

    public static StudentStore getStudentStore(){
        if (sStudentStore == null){
            sStudentStore = new StudentStore();
        }

        return sStudentStore;
    }

}
