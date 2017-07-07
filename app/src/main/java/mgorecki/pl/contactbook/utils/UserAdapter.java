package mgorecki.pl.contactbook.utils;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import mgorecki.pl.contactbook.R;
import mgorecki.pl.contactbook.db.AppDatabase;
import mgorecki.pl.contactbook.domain.User;

/**
 * Created by emigore on 2017-07-05.
 */

public class UserAdapter extends ArrayAdapter<User> {

    public UserAdapter(Context context, List<User> userList){
        super(context,0,userList);
    }

    @Override
    public View getView(int position,View convertView, ViewGroup parent){
        final User user = getItem(position);

        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.user_list_item,parent,false);
        }

        TextView emailField = (TextView) convertView.findViewById(R.id.emailTextView);
        TextView passwordField = (TextView) convertView.findViewById(R.id.passwordTextView);
        TextView ageField = (TextView) convertView.findViewById(R.id.ageTextView);

        Button deleteButton = (Button) convertView.findViewById(R.id.deleteButton);
        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppDatabase.getAppDatabase(getContext()).userDao().delete(user);
                notifyDataSetChanged();

            }
        });


        emailField.setText(user.getEmail());
        passwordField.setText(user.getPassword());
        ageField.setText(String.valueOf(user.getAge()));

        return convertView;
    }



}
