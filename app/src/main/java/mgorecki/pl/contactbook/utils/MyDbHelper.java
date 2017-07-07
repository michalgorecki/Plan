package mgorecki.pl.contactbook.utils;

import android.content.Context;

import mgorecki.pl.contactbook.db.AppDatabase;
import mgorecki.pl.contactbook.domain.PlanItem;

/**
 * Created by emigore on 2017-07-07.
 */

public class MyDbHelper {
    private static final String TAG = DatabaseInit.class.getName();

    public static void addItem(Context context, PlanItem... items){
        AppDatabase.getAppDatabase(context).planItemDao().insertAll(items);
    }

}
