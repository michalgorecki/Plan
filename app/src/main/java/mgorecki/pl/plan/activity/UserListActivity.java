package mgorecki.pl.plan.activity;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

import mgorecki.pl.plan.R;
import mgorecki.pl.plan.db.AppDatabase;
import mgorecki.pl.plan.domain.User;
import mgorecki.pl.plan.utils.UserAdapter;

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
