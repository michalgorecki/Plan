package mgorecki.pl.plan.utils;

import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.util.Log;

import mgorecki.pl.plan.db.AppDatabase;
import mgorecki.pl.plan.domain.PlanItem;

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


    private static void populateWithTestData(AppDatabase db) {
        PlanItem planItem = new PlanItem("Matematyka","Algebra liniowa","Jan Kowalski","12:00","Wednesday");
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
