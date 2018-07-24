package bsu.edu.studentsort;

import java.util.ArrayList;
import java.util.Collections;
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


    public void sortByFirstName(){
        Collections.sort(mStudentList, Student.StudentFirstNameComparator);
    }

    public void sortByLastName(){
        Collections.sort(mStudentList, Student.StudentLastNameComparator);
    }

    public void sortByYearIndex(){
        Collections.sort(mStudentList, Student.StudentYearIndexComparator);
    }

    public void sortByGpa(){
        Collections.sort(mStudentList, Student.StudentGpaComparator);
    }


}
