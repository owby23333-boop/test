package com.amgcyo.cuttadon.database;

import androidx.annotation.Nullable;
import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import com.amgcyo.cuttadon.api.entity.other.MkConfigSource;
import java.util.List;

/* JADX INFO: compiled from: MkConfigSourceDao.java */
/* JADX INFO: loaded from: classes.dex */
@Dao
public interface j {
    @Query("update MkConfigSource set regular_time =:regular_time,regular=:regular   where site_id = :site_id ")
    int a(long j2, String str, String str2);

    @Nullable
    @Query("select * from MkConfigSource ")
    LiveData<List<MkConfigSource>> a();

    @Nullable
    @Query("select * from MkConfigSource where site_id = :site_id ")
    MkConfigSource a(String str);

    @Insert(onConflict = 1)
    long insert(MkConfigSource mkConfigSource);
}
