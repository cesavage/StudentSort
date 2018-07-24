package bsu.edu.studentsort;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class StudentsFragment extends android.support.v4.app.Fragment {
    private View mInflatedFragmentView;
    private RecyclerView mStudentsRecyclerView;

    @Override
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup container, Bundle savedInstanceState){
        mInflatedFragmentView = layoutInflater.inflate(R.layout.fragment_students, container, false);

        setWidgetVariables();

        return mInflatedFragmentView;
    }

    private void setWidgetVariables(){
        mStudentsRecyclerView = mInflatedFragmentView.findViewById(R.id.recyclerView_students);
    }
}
