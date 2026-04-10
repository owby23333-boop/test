package com.amgcyo.cuttadon.database;

import androidx.annotation.Nullable;
import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import com.amgcyo.cuttadon.api.entity.other.LocalReadHistoryBean;
import java.util.List;

/* JADX INFO: compiled from: LocalReadHistorykDao.java */
/* JADX INFO: loaded from: classes.dex */
@Dao
public interface a {
    @Nullable
    @Query("select * from LocalReadHistoryBean ORDER BY  created_at DESC ")
    LiveData<List<LocalReadHistoryBean>> a();

    @Nullable
    @Query("select * from LocalReadHistoryBean where form=:form ORDER BY  created_at DESC ")
    List<LocalReadHistoryBean> a(int i2);

    @Query("DELETE FROM LocalReadHistoryBean  where form=:form ")
    int b(int i2);

    @Nullable
    @Query("select * from LocalReadHistoryBean ORDER BY  created_at DESC ")
    List<LocalReadHistoryBean> b();

    @Nullable
    @Query("select * from LocalReadHistoryBean where book_id = :book_id ")
    LocalReadHistoryBean c(int i2);

    @Insert(onConflict = 1)
    long insert(LocalReadHistoryBean localReadHistoryBean);

    @Update(onConflict = 1)
    void update(LocalReadHistoryBean localReadHistoryBean);
}
