package mgorecki.pl.contactbook.utils;

import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.util.Log;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import mgorecki.pl.contactbook.db.AppDatabase;
import mgorecki.pl.contactbook.domain.PlanItem;
import mgorecki.pl.contactbook.domain.User;

/**
 * Created by emigore on 2017-07-04.
 */

public class DatabaseInit {

    private static final String TAG = DatabaseInit.class.getName();

    public static void populateAsync(@NonNull final AppDatabase db) {
        PopulateDbAsync task = new PopulateDbAsync(db);
    }

    public static void populateSync(@NonNull final AppDatabase db) {
        populateWithTestData(db);
    }

    private static User addUser(final AppDatabase db, User user) {
        db.userDao().insertAll(user);
        return user;
    }

    private static void populateWithTestData(AppDatabase db) {
        String pattern = "yyyy-MM-dd hh:mm";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        Date date = null;
        try {
            date = simpleDateFormat.parse("2017-07-23 10:30");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        PlanItem planItem = new PlanItem("Matematyka","Algebra liniowa","Jan Kowalski",date);
        db.planItemDao().insertAll(planItem);

        Log.d(TAG,"Items in the planitem: "+db.planItemDao().countPlanItem());

    }

    private static class PopulateDbAsync extends AsyncTask<Void, Void, Void> {

        private final AppDatabase mDb;

        PopulateDbAsync(AppDatabase db) {
            mDb = db;
        }

        @Override
        protected Void doInBackground(final Void... params) {
            populateWithTestData(mDb);
            return null;
        }

    }
}
