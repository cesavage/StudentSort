package bsu.edu.studentsort;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

public class StudentsFragment extends android.support.v4.app.Fragment {
    private View mInflatedFragmentView;
    private RecyclerView mStudentsRecyclerView;
    private StudentStore mStudentStore;

    private ConstraintLayout mFirstNameHeader;
    private ImageView mFirstNameHeaderArrow;

    private ConstraintLayout mLastNameHeader;
    private ImageView mLastNameHeaderArrow;

    private ConstraintLayout mYearHeader;
    private ImageView mYearHeaderArrow;

    private ConstraintLayout mGpaHeader;
    private ImageView mGpaHeaderArrow;

    private static final String KEY_STUDENTS = "students";

    @Override
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup container, Bundle savedInstanceState){
        mInflatedFragmentView = layoutInflater.inflate(R.layout.fragment_students, container, false);

        setWidgetVariables();
        configureWidgets();

        if(savedInstanceState != null){
            mStudentStore = StudentStore.getStudentStore();
            mStudentStore.mStudentList = (List<Student>) savedInstanceState.getSerializable(KEY_STUDENTS);
            updateUI();
        }

        else{
            getStudentsInformationFromFile();
        }



        return mInflatedFragmentView;
    }




    private void setWidgetVariables(){
        mStudentsRecyclerView = mInflatedFragmentView.findViewById(R.id.recyclerView_students);

        mFirstNameHeader = mInflatedFragmentView.findViewById(R.id.header_firstName);
        mFirstNameHeaderArrow = mInflatedFragmentView.findViewById(R.id.imageView_header_arrowFirstName);

        mLastNameHeader = mInflatedFragmentView.findViewById(R.id.header_lastName);
        mLastNameHeaderArrow = mInflatedFragmentView.findViewById(R.id.imageView_header_arrowLastName);

        mYearHeader = mInflatedFragmentView.findViewById(R.id.header_year);
        mYearHeaderArrow = mInflatedFragmentView.findViewById(R.id.imageView_header_arrowYear);

        mGpaHeader = mInflatedFragmentView.findViewById(R.id.header_gpa);
        mGpaHeaderArrow = mInflatedFragmentView.findViewById(R.id.imageView_header_arrowGPA);
    }




    private void configureWidgets(){
        mStudentsRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        mFirstNameHeader.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mStudentStore.sortByFirstName();
                hideAllArrows();
                mFirstNameHeaderArrow.setVisibility(View.VISIBLE);

                updateUI();
            }
        });

        mLastNameHeader.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mStudentStore.sortByLastName();
                hideAllArrows();
                mLastNameHeaderArrow.setVisibility(View.VISIBLE);

                updateUI();
            }
        });

        mYearHeader.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mStudentStore.sortByYearIndex();
                hideAllArrows();
                mYearHeaderArrow.setVisibility(View.VISIBLE);

                updateUI();
            }
        });

        mGpaHeader.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mStudentStore.sortByGpa();
                hideAllArrows();
                mGpaHeaderArrow.setVisibility(View.VISIBLE);

                updateUI();
            }
        });
    }




    private void getStudentsInformationFromFile(){
        JsonParser jsonParser = new JsonParser(getContext());
        jsonParser.parseJson();

        mStudentStore = StudentStore.getStudentStore();
        //mStudentStore.sortByFirstName();
        //mStudentStore.sortByLastName();
        mStudentStore.sortByYearIndex();
        //mStudentStore.sortByGpa();
        updateUI();
    }



    private void hideAllArrows(){
        mFirstNameHeaderArrow.setVisibility(View.GONE);
        mLastNameHeaderArrow.setVisibility(View.GONE);
        mYearHeaderArrow.setVisibility(View.GONE);
        mGpaHeaderArrow.setVisibility(View.GONE);
    }



    private void updateUI(){
        StudentsRecyclerViewAdapter studentsRecyclerViewAdapter = new StudentsRecyclerViewAdapter();
        mStudentsRecyclerView.setAdapter(studentsRecyclerViewAdapter);
    }



    private class StudentsRecyclerViewAdapter extends RecyclerView.Adapter<StudentViewHolder>{

        @NonNull
        @Override
        public StudentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
            return new StudentViewHolder(layoutInflater, parent, getContext());
        }

        @Override
        public void onBindViewHolder(@NonNull StudentViewHolder holder, int position){
            Student student = mStudentStore.mStudentList.get(position);
            holder.bind(student);
        }

        @Override
        public int getItemCount(){
            return mStudentStore.mStudentList.size();
        }

    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle savedInstanceState){
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putSerializable(KEY_STUDENTS, (Serializable) mStudentStore.mStudentList);
    }
}
