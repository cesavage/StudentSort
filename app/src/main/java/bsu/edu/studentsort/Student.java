package bsu.edu.studentsort;

import android.support.annotation.NonNull;

import java.io.Serializable;
import java.util.Comparator;

public class Student implements Comparable<Student>, Serializable {
    public String firstName;
    public String lastName;
    public String year;
    public Integer yearIndex;
    public Double gpa;

    public Student(){
    }




    public static Comparator<Student> StudentFirstNameComparator = new Comparator<Student>() {
        @Override
        public int compare(Student student1, Student student2) {
            String firstName1 = student1.firstName.toUpperCase();
            String firstName2 = student2.firstName.toUpperCase();

            return firstName1.compareTo(firstName2);
        }
    };




    public static Comparator<Student> StudentLastNameComparator = new Comparator<Student>() {
        @Override
        public int compare(Student student1, Student student2) {
            String lastName1 = student1.lastName.toUpperCase();
            String lastName2 = student2.lastName.toUpperCase();

            return lastName1.compareTo(lastName2);
        }
    };




    public static Comparator<Student> StudentYearIndexComparator = new Comparator<Student>() {
        @Override
        public int compare(Student student1, Student student2) {
            Integer yearIndex1 = student1.yearIndex;
            Integer yearIndex2 = student2.yearIndex;

            return yearIndex1.compareTo(yearIndex2);
        }
    };




    public static Comparator<Student> StudentGpaComparator = new Comparator<Student>() {
        @Override
        public int compare(Student student1, Student student2) {
            Double gpa1 = student1.gpa;
            Double gpa2 = student2.gpa;

            return gpa1.compareTo(gpa2);
        }
    };




    @Override
    public int compareTo(@NonNull Student o) {
        return 0;
    }
}
