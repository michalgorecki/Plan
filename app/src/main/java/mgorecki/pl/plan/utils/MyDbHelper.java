package mgorecki.pl.plan.utils;

import android.content.Context;

import java.util.List;

import mgorecki.pl.plan.db.AppDatabase;
import mgorecki.pl.plan.domain.PlanItem;

/**
 * Created by emigore on 2017-07-07.
 */

public class MyDbHelper {
    private static final String TAG = DatabaseInit.class.getName();

    public static void addItem(Context context, PlanItem... items){
        AppDatabase.getAppDatabase(context).planItemDao().insertAll(items);
    }
    public static void removeItem(Context context, PlanItem item){
        AppDatabase.getAppDatabase(context).planItemDao().delete(item);
    }
    public static List<PlanItem> getAllItems(Context context){
        return AppDatabase.getAppDatabase(context).planItemDao().getAll();

    }
    public static List<PlanItem> getAllItemsPerDay(Context context,String weekday){
        return AppDatabase.getAppDatabase(context).planItemDao().getDailyPlan(weekday);
    }
    public static final int getCount(Context context){
        return AppDatabase.getAppDatabase(context).planItemDao().countPlanItem();
    }

}
