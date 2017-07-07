package mgorecki.pl.contactbook.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

import mgorecki.pl.contactbook.domain.PlanItem;

/**
 * Created by emigore on 2017-07-06.
 */


@Dao
public interface PlanItemDao {

    @Query("SELECT * FROM planitem")
    List<PlanItem> getAll();

    @Query("SELECT * FROM planitem where teacher LIKE :teacher")
    List<PlanItem> findByTeacher(String teacher);

    @Query("SELECT COUNT(*) FROM planitem")
    int countPlanItem();

    @Insert
    void insertAll(PlanItem... planItems);

    @Delete
    void delete(PlanItem planItem);
}

