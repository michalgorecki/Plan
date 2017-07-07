package mgorecki.pl.contactbook.utils;

import android.arch.persistence.room.TypeConverter;

import java.util.Date;

/**
 * Created by emigore on 2017-07-06.
 */

public class Converters {

    @TypeConverter
    public static Date fromTimestamp(Long value) {
        return value == null ? null : new Date(value);
    }


    @TypeConverter
    public static Long dateToTimestamp(Date date) {
        return date == null ? null : date.getTime();
    }
}
