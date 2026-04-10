package com.amgcyo.cuttadon.database;

import androidx.annotation.Nullable;
import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import com.amgcyo.cuttadon.api.entity.other.MkCommentStatus;
import java.util.List;

/* JADX INFO: compiled from: MkCommentStatusDao.java */
/* JADX INFO: loaded from: classes.dex */
@Dao
public interface h {
    @Nullable
    @Query("select * from MkCommentStatus ")
    LiveData<List<MkCommentStatus>> a();

    @Nullable
    @Query("select * from MkCommentStatus ")
    List<MkCommentStatus> b();

    @Insert(onConflict = 1)
    long insert(MkCommentStatus mkCommentStatus);
}
