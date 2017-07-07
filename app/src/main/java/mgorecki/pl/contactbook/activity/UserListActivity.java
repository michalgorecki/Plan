package mgorecki.pl.contactbook.activity;

import android.app.ListActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import mgorecki.pl.contactbook.R;
import mgorecki.pl.contactbook.db.AppDatabase;
import mgorecki.pl.contactbook.domain.User;
import mgorecki.pl.contactbook.utils.UserAdapter;

public class UserListActivity extends ListActivity {

    public static final String TAG = "UserListActivity";

    TextView textView;
    ListView  listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_list);

        textView = (TextView) findViewById(R.id.textView);
        listView = (ListView) findViewById(android.R.id.list);
        List<User> userList = AppDatabase.getAppDatabase(this).userDao().getAll();
        UserAdapter adapter = new UserAdapter(this,userList);
        setListAdapter(adapter);
    }

}
