package mgorecki.pl.plan.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import mgorecki.pl.plan.R;
import mgorecki.pl.plan.db.AppDatabase;
import mgorecki.pl.plan.domain.User;
import mgorecki.pl.plan.utils.DatabaseInit;
import mgorecki.pl.plan.utils.Validator;

public class AddUserActivity extends AppCompatActivity {

    Button clearButton;
    Button submitButton;
    Button listButton;
    EditText emailField;
    EditText passwordField;
    EditText ageField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adduser);
        DatabaseInit.populateAsync(AppDatabase.getAppDatabase(this));

        submitButton = (Button) findViewById(R.id.submitButton);
        listButton = (Button) findViewById(R.id.listButton);
        clearButton = (Button) findViewById(R.id.clearButton);

        emailField = (EditText) findViewById(R.id.emailEditText);
        passwordField = (EditText) findViewById(R.id.passwordEditText);
        ageField = (EditText) findViewById(R.id.ageEditText);
    }

    public void clearForm(View v){
        emailField.getText().clear();
        passwordField.getText().clear();
        ageField.getText().clear();
    }


    public void addUser(View v){
        String email = emailField.getText().toString();
        if(Validator.isEmailValid(email)){
            User user = new User();
            user.setEmail(email);
            user.setPassword(passwordField.getText().toString());
            user.setAge(Integer.valueOf(ageField.getText().toString()));
            AppDatabase.getAppDatabase(this).userDao().insertAll(user);
            clearForm(v);
        }else{
            Toast.makeText(this,"Invalid email!",Toast.LENGTH_SHORT).show();
            emailField.getText().clear();
        }

    }

    public void listOnClick(View v){
        Intent intent = new Intent(this, UserListActivity.class);
        AddUserActivity.this.startActivity(intent);
    }





}
