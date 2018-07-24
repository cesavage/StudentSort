package bsu.edu.studentsort;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

public class MainActivity extends SingleFragmentActivity {

    protected Fragment createFragment(){
        return new StudentsFragment();
    }

}
