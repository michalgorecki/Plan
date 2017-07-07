package mgorecki.pl.contactbook.activity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.icu.util.Calendar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.DatePicker;
import android.widget.EditText;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import mgorecki.pl.contactbook.R;
import mgorecki.pl.contactbook.domain.PlanItem;
import mgorecki.pl.contactbook.utils.MyDbHelper;

public class AddItemActivity extends AppCompatActivity {
    public static final String TAG = "AddItemActivity";
    EditText dateEditText;
    EditText timeEditText;
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
        dateEditText = (EditText) findViewById(R.id.dateEditText);
        timeEditText = (EditText) findViewById(R.id.timeEditText);
        nameEditText = (EditText) findViewById(R.id.nameEditText);
        headingEditText = (EditText) findViewById(R.id.headingEditText);
        teacherEditText = (EditText) findViewById(R.id.teacherEditText);


        clearButton.setOnClickListener((v)->{
            clearForm();
        });
        DatePickerDialog.OnDateSetListener date = (view, year, monthOfYear, dayOfMonth) -> {
            // TODO Auto-generated method stub
            myCalendar.set(Calendar.YEAR, year);
            myCalendar.set(Calendar.MONTH, monthOfYear);
            myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
            updateLabel();
        };
        dateEditText.setOnClickListener(v -> new DatePickerDialog(AddItemActivity.this,date,myCalendar.get(Calendar.YEAR),myCalendar.get(Calendar.MONTH),myCalendar.get(Calendar.DAY_OF_MONTH)).show());
    }

    public void submitOnClick(View v){
        try {
            Log.d(TAG,"Adding item to db");
            String dateString = dateEditText.getText().toString()+" "+timeEditText.getText().toString();
            Log.d(TAG,"Date string: "+dateString);
            Date inDate = new SimpleDateFormat("yyyy-MM-dd hh:mm").parse(dateString);
            PlanItem item = new PlanItem(nameEditText.getText().toString(),headingEditText.getText().toString(),teacherEditText.getText().toString(),inDate);
            MyDbHelper.addItem(this,item);
            clearForm();
            goBackToMain();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    private void updateLabel() {
        //TODO format timestampu
        String myFormat = "yyyy-MM-dd";
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);
        dateEditText.setText(sdf.format(myCalendar.getTime()));
    }

    private void clearForm(){
        dateEditText.getText().clear();
        nameEditText.getText().clear();
        headingEditText.getText().clear();
        teacherEditText.getText().clear();
    }
    private void goBackToMain(){
        Intent intent = new Intent(this, MainActivity.class);
        AddItemActivity.this.startActivity(intent);
    }




}
