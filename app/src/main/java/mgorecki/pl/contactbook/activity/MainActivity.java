package mgorecki.pl.contactbook.activity;

import android.app.IntentService;
import android.app.ListActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import mgorecki.pl.contactbook.R;
import mgorecki.pl.contactbook.db.AppDatabase;
import mgorecki.pl.contactbook.domain.PlanItem;
import mgorecki.pl.contactbook.utils.PlanItemAdapter;

public class MainActivity extends ListActivity {
    public static final String TAG = "MainActivity";
    ListView listView;
    List<PlanItem> planList;
    Button addButton;
    Button removeButton;
    Button nextButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addButton = (Button) findViewById(R.id.addButton);
        removeButton = (Button) findViewById(R.id.removeButton);
        nextButton = (Button) findViewById(R.id.nextButton);
        removeButton.setOnClickListener((View v) ->{
            Toast.makeText(this,"Remove was hit",Toast.LENGTH_SHORT).show();});


        planList = AppDatabase.getAppDatabase(this).planItemDao().getAll();
        Log.d(TAG,"Rows count: "+AppDatabase.getAppDatabase(this).planItemDao().countPlanItem());

        PlanItemAdapter adapter = new PlanItemAdapter(this,planList);
        setListAdapter(adapter);
    }


    public void addOnClick(View v){
        Intent intent = new Intent(this,AddItemActivity.class);
        MainActivity.this.startActivity(intent);

    }


}
