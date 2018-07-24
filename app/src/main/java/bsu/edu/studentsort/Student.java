package bsu.edu.studentsort;

import android.support.annotation.NonNull;

import java.util.Comparator;

public class Student implements Comparable<Student> {
    String firstName;
    String lastName;
    String year;
    Double gpa;

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

    public static Comparator<Student> StudentYearComparator = new Comparator<Student>() {
        @Override
        public int compare(Student student1, Student student2) {
            String year1 = student1.year.toUpperCase();
            String year2 = student2.year.toUpperCase();

            return year1.compareTo(year2);
        }
    };

    @Override
    public int compareTo(@NonNull Student o) {
        return 0;
    }
}
