package mgorecki.pl.plan.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

import mgorecki.pl.plan.domain.User;

/**
 * Created by emigore on 2017-07-04.
 */


@Dao
public interface UserDao {

    @Query(("SELECT * FROM user"))
    List<User> getAll();

    @Query("SELECT * FROM user where email LIKE :email")
    User findByEmail(String email);

    @Query("SELECT COUNT(*) FROM user")
    int countUsers();

    @Insert
    void insertAll(User... users);

    @Delete
    void delete(User user);


}
