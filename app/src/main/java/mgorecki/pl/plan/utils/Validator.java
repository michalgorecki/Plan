package mgorecki.pl.plan.utils;

import android.content.Context;
import android.util.Patterns;
import android.view.View;

import mgorecki.pl.plan.db.AppDatabase;
import mgorecki.pl.plan.domain.PlanItem;

/**
 * Created by emigore on 2017-07-05.
 */

public  class Validator {

    public static boolean isEmailValid(String email){
        return Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    public static boolean isDateUnique(PlanItem item, Context context){
        return AppDatabase.getAppDatabase(context).planItemDao()
                .countItemsWithDate(item.getWeekday(), item.getTime()) > 0 ? false : true;
    }


}
