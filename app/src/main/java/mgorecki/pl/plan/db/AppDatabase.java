package mgorecki.pl.plan.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;
import android.content.Context;

import mgorecki.pl.plan.dao.PlanItemDao;
import mgorecki.pl.plan.dao.UserDao;
import mgorecki.pl.plan.domain.PlanItem;
import mgorecki.pl.plan.domain.User;
import mgorecki.pl.plan.utils.Converters;

/**
 * Created by emigore on 2017-07-04.
 */

@Database(entities = {User.class, PlanItem.class}, version = 4)
@TypeConverters({Converters.class})
public abstract class AppDatabase extends RoomDatabase {

    private static AppDatabase INSTANCE;

    public abstract UserDao userDao();
    public abstract PlanItemDao planItemDao();

    public static AppDatabase getAppDatabase(Context context){
        if(INSTANCE == null){
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(),AppDatabase.class,"user-database").allowMainThreadQueries().build();
            /*
            Queries on the main thread ---> shouldn't be done this way in a "real" app
             */
        }
        return INSTANCE;
    }


    public static void destroyInstance(){
        INSTANCE = null;
    }


}
