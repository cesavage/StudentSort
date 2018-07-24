package bsu.edu.studentsort;

import android.content.Context;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.InputStream;
import java.util.Scanner;

public class JsonParser{
    private Context mCurrentContext;
    private StudentStore mStudentStore = StudentStore.getStudentStore();

    public JsonParser(Context currentContext){
        mCurrentContext = currentContext;
    }




    public void parseJson(){
        InputStream inputStream = mCurrentContext.getResources().openRawResource(R.raw.students);
        String jsonString = new Scanner(inputStream).useDelimiter("\\A").next();

        try {
            JSONArray studentsJsonArray = new JSONArray(jsonString);

            for (int i=0; i < studentsJsonArray.length(); i++){
                Student currentStudent = new Student();

                JSONObject studentObject = studentsJsonArray.getJSONObject(i);
                currentStudent.firstName = studentObject.opt("firstName").toString();
                currentStudent.lastName = studentObject.opt("lastName").toString();
                currentStudent.year = studentObject.opt("year").toString();
                currentStudent.gpa = Double.parseDouble(studentObject.opt("gpa").toString());

                setYearIndex(currentStudent);

                mStudentStore.mStudentList.add(currentStudent);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }




    private void setYearIndex(Student student){
        switch (student.year){
            case "Freshman":
                student.yearIndex = 1;
                break;

            case "Sophomore":
                student.yearIndex = 2;
                break;

            case "Junior":
                student.yearIndex = 3;
                break;

            case "Senior":
                student.yearIndex = 4;
                break;
        }

    }
}