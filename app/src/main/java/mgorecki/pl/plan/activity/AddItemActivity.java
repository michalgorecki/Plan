package mgorecki.pl.plan.activity;

import android.content.Intent;
import android.icu.util.Calendar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import mgorecki.pl.plan.R;
import mgorecki.pl.plan.domain.PlanItem;
import mgorecki.pl.plan.utils.MyDbHelper;

public class AddItemActivity extends AppCompatActivity {
    public static final String TAG = "AddItemActivity";
    TimePicker timePicker;
    EditText nameEditText;
    EditText headingEditText;
    EditText teacherEditText;
    Calendar myCalendar;
    Button clearButton;
    Button submitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);
        myCalendar = Calendar.getInstance();
        clearButton = (Button) findViewById(R.id.clearButton);
        submitButton =  (Button) findViewById(R.id.submitButton);
        timePicker = (TimePicker) findViewById(R.id.timePicker);
        nameEditText = (EditText) findViewById(R.id.nameEditText);
        headingEditText = (EditText) findViewById(R.id.headingEditText);
        teacherEditText = (EditText) findViewById(R.id.teacherEditText);
        clearButton.setOnClickListener((v)->{
            clearForm();
        });
    }

    public void submitOnClick(View v){
        Log.d(TAG,"Adding item to db");
        String time = String.format("%02d:%02d",timePicker.getHour(),timePicker.getMinute());
        Log.d(TAG,"Time string: "+time);
        String name = nameEditText.getText().toString();
        String heading = headingEditText.getText().toString();
        String teacher = teacherEditText.getText().toString();
        if(name.isEmpty() || heading.isEmpty() || teacher.isEmpty()){
            Toast.makeText(this,"There's an empty field!",Toast.LENGTH_SHORT).show();
        }else{
            PlanItem item = new PlanItem(name,heading,teacher,time);
            MyDbHelper.addItem(this,item);
            clearForm();
            goBackToMain();
        }
    }

    private void clearForm(){
        nameEditText.getText().clear();
        headingEditText.getText().clear();
        teacherEditText.getText().clear();
    }
    private void goBackToMain(){
        Intent intent = new Intent(this, MainActivity.class);
        AddItemActivity.this.startActivity(intent);
    }




}
