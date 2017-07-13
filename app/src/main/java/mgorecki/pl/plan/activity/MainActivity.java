package mgorecki.pl.plan.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import mgorecki.pl.plan.R;
import mgorecki.pl.plan.db.AppDatabase;
import mgorecki.pl.plan.domain.PlanItem;
import mgorecki.pl.plan.utils.PlanItemAdapter;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = "MainActivity";
    ListView listView;
    List<PlanItem> planList;
    Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.listview);



        toolbar = (Toolbar) findViewById(R.id.toolbar2);
        setSupportActionBar(toolbar);

        planList = AppDatabase.getAppDatabase(this).planItemDao().getAll();
        Log.d(TAG, "Rows count: " + AppDatabase.getAppDatabase(this).planItemDao().countPlanItem());

        PlanItemAdapter adapter = new PlanItemAdapter(this, planList);
        listView.setAdapter(adapter);
        listView.setClickable(true);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.d(TAG,"Item clicked...");
                Toast.makeText(MainActivity.this,"ASDASD",Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu,menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.addAction:
                Intent intent = new Intent(this, AddItemActivity.class);
                MainActivity.this.startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }



}
