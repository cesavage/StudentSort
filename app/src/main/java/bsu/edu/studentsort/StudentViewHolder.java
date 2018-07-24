package bsu.edu.studentsort;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

public class StudentViewHolder extends RecyclerView.ViewHolder {

    private TextView mFirstName;
    private TextView mLastName;
    private TextView mYear;
    private TextView mGpa;


    public StudentViewHolder(LayoutInflater layoutInflater, ViewGroup parent, Context currentContext){
        super(layoutInflater.inflate(R.layout.student_list_item, parent, false));

        mFirstName = itemView.findViewById(R.id.textView_firstName);
        mLastName = itemView.findViewById(R.id.textView_lastName);
        mYear = itemView.findViewById(R.id.textView_year);
        mGpa = itemView.findViewById(R.id.textView_gpa);
    }

    public void bind(Student student){
        mFirstName.setText(student.firstName);
        mLastName.setText(student.lastName);
        mYear.setText(student.year);
        mGpa.setText(student.gpa.toString());
    }
}
