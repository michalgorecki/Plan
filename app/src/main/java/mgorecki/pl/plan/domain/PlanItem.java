package mgorecki.pl.plan.domain;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.util.StringUtil;

/**
 * Created by emigore on 2017-07-06.
 */

@Entity(tableName = "planitem")
public class PlanItem {

    public PlanItem(String name,String heading,String teacher, String time,String weekday){
        this.name = name;
        this.heading = heading;
        this.teacher = teacher;
        this.time = time;
        this.weekday = weekday;
    }

    @PrimaryKey(autoGenerate = true)
    private int uid;

    @ColumnInfo(name = "name")
    private String name;

    @ColumnInfo(name = "heading")
    private String heading;

    @ColumnInfo(name = "teacher")
    private String teacher;

    @ColumnInfo(name = "weekday")
    private String weekday;

    @ColumnInfo(name = "time")
    private String time;

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHeading() {
        return heading;
    }

    public void setHeading(String heading) {
        this.heading = heading;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getWeekday() {
        return weekday;
    }

    public void setWeekday(String weekday) {
        this.weekday = weekday;
    }
}

