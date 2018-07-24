package bsu.edu.studentsort;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

public class StudentsFragment extends android.support.v4.app.Fragment {
    private View mInflatedFragmentView;
    private RecyclerView mStudentsRecyclerView;
    private StudentStore mStudentStore;

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
    }




    private void configureWidgets(){
        mStudentsRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
    }




    private void getStudentsInformationFromFile(){
        JsonParser jsonParser = new JsonParser(getContext());
        jsonParser.parseJson();

        mStudentStore = StudentStore.getStudentStore();
        //mStudentStore.sortByFirstName();
        //mStudentStore.sortByLastName();
        //mStudentStore.sortByYear();
        mStudentStore.sortByGpa();
        updateUI();
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
