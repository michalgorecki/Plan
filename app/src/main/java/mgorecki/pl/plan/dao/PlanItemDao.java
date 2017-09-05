package mgorecki.pl.plan.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

import mgorecki.pl.plan.domain.PlanItem;

/**
 * Created by emigore on 2017-07-06.
 */


@Dao
public interface PlanItemDao {

    @Query("SELECT * FROM planitem ORDER BY time")
    List<PlanItem> getAll();

    @Query("SELECT * FROM planitem where teacher LIKE :teacher")
    List<PlanItem> findByTeacher(String teacher);

    @Query("SELECT COUNT(*) FROM planitem")
    int countPlanItem();

    @Query("SELECT * FROM planitem where weekday=:weekday ORDER BY time")
    List<PlanItem> getDailyPlan(String weekday);

    @Query("SELECT COUNT (*) FROM planitem where weekday like :weekday AND time LIKE :time")
    int countItemsWithDate(String weekday,String time);

    @Insert
    void insertAll(PlanItem... planItems);

    @Delete
    void delete(PlanItem planItem);


}

