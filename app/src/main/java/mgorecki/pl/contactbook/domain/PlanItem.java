package mgorecki.pl.contactbook.domain;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.TypeConverter;

import java.util.Date;

/**
 * Created by emigore on 2017-07-06.
 */

@Entity(tableName = "planitem", indices = {@Index(value = {"date"}, unique = true)}
    )
public class PlanItem {

    public PlanItem(String name,String heading,String teacher, Date date){
        this.name = name;
        this.heading = heading;
        this.teacher = teacher;
        this.date = date;
    }

    @PrimaryKey(autoGenerate = true)
    private int uid;

    @ColumnInfo(name = "name")
    private String name;

    @ColumnInfo(name = "heading")
    private String heading;

    @ColumnInfo(name = "teacher")
    private String teacher;


    @ColumnInfo(name = "date")
    private Date date;

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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }



}
