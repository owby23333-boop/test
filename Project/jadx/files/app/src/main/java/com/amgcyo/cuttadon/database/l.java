package com.amgcyo.cuttadon.database;

import androidx.annotation.Nullable;
import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import com.amgcyo.cuttadon.api.entity.other.MkUser;

/* JADX INFO: compiled from: MkUserDao.java */
/* JADX INFO: loaded from: classes.dex */
@Dao
public interface l {
    @Query("update MkUser set avatar =:avatar  where user_id = :user_id ")
    int a(String str, int i2);

    @Nullable
    @Query("select * from MkUser ORDER BY art_id DESC LIMIT 0,1")
    MkUser a();

    @Query("delete from MkUser")
    int b();

    @Nullable
    @Query("select * from MkUser ORDER BY art_id DESC LIMIT 0,1")
    LiveData<MkUser> c();

    @Delete
    void delete(MkUser mkUser);

    @Insert(onConflict = 1)
    long insert(MkUser mkUser);

    @Update
    int update(MkUser mkUser);
}
