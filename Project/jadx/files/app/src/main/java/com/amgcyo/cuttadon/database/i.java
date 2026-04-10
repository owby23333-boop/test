package com.amgcyo.cuttadon.database;

import android.database.Cursor;
import androidx.lifecycle.LiveData;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.amgcyo.cuttadon.api.entity.other.MkCommentStatus;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: MkCommentStatusDao_Impl.java */
/* JADX INFO: loaded from: classes.dex */
public final class i implements h {
    private final RoomDatabase a;
    private final EntityInsertionAdapter<MkCommentStatus> b;

    /* JADX INFO: compiled from: MkCommentStatusDao_Impl.java */
    class a extends EntityInsertionAdapter<MkCommentStatus> {
        a(i iVar, RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.EntityInsertionAdapter
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void bind(SupportSQLiteStatement supportSQLiteStatement, MkCommentStatus mkCommentStatus) {
            supportSQLiteStatement.bindLong(1, mkCommentStatus.getArt_id());
            supportSQLiteStatement.bindLong(2, mkCommentStatus.getCommentId());
            supportSQLiteStatement.bindLong(3, mkCommentStatus.getComment_fav_status());
            supportSQLiteStatement.bindLong(4, mkCommentStatus.getLikeUserId());
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "INSERT OR REPLACE INTO `MkCommentStatus` (`art_id`,`commentId`,`comment_fav_status`,`likeUserId`) VALUES (nullif(?, 0),?,?,?)";
        }
    }

    /* JADX INFO: compiled from: MkCommentStatusDao_Impl.java */
    class b implements Callable<List<MkCommentStatus>> {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        final /* synthetic */ RoomSQLiteQuery f3657s;

        b(RoomSQLiteQuery roomSQLiteQuery) {
            this.f3657s = roomSQLiteQuery;
        }

        protected void finalize() {
            this.f3657s.release();
        }

        @Override // java.util.concurrent.Callable
        public List<MkCommentStatus> call() throws Exception {
            Cursor cursorQuery = DBUtil.query(i.this.a, this.f3657s, false, null);
            try {
                int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "art_id");
                int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "commentId");
                int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "comment_fav_status");
                int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "likeUserId");
                ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                while (cursorQuery.moveToNext()) {
                    MkCommentStatus mkCommentStatus = new MkCommentStatus();
                    mkCommentStatus.setArt_id(cursorQuery.getInt(columnIndexOrThrow));
                    mkCommentStatus.setCommentId(cursorQuery.getInt(columnIndexOrThrow2));
                    mkCommentStatus.setComment_fav_status(cursorQuery.getInt(columnIndexOrThrow3));
                    mkCommentStatus.setLikeUserId(cursorQuery.getInt(columnIndexOrThrow4));
                    arrayList.add(mkCommentStatus);
                }
                return arrayList;
            } finally {
                cursorQuery.close();
            }
        }
    }

    public i(RoomDatabase roomDatabase) {
        this.a = roomDatabase;
        this.b = new a(this, roomDatabase);
    }

    public static List<Class<?>> c() {
        return Collections.emptyList();
    }

    @Override // com.amgcyo.cuttadon.database.h
    public List<MkCommentStatus> b() {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("select * from MkCommentStatus ", 0);
        this.a.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.a, roomSQLiteQueryAcquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "art_id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "commentId");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "comment_fav_status");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "likeUserId");
            ArrayList arrayList = new ArrayList(cursorQuery.getCount());
            while (cursorQuery.moveToNext()) {
                MkCommentStatus mkCommentStatus = new MkCommentStatus();
                mkCommentStatus.setArt_id(cursorQuery.getInt(columnIndexOrThrow));
                mkCommentStatus.setCommentId(cursorQuery.getInt(columnIndexOrThrow2));
                mkCommentStatus.setComment_fav_status(cursorQuery.getInt(columnIndexOrThrow3));
                mkCommentStatus.setLikeUserId(cursorQuery.getInt(columnIndexOrThrow4));
                arrayList.add(mkCommentStatus);
            }
            return arrayList;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // com.amgcyo.cuttadon.database.h
    public long insert(MkCommentStatus mkCommentStatus) {
        this.a.assertNotSuspendingTransaction();
        this.a.beginTransaction();
        try {
            long jInsertAndReturnId = this.b.insertAndReturnId(mkCommentStatus);
            this.a.setTransactionSuccessful();
            return jInsertAndReturnId;
        } finally {
            this.a.endTransaction();
        }
    }

    @Override // com.amgcyo.cuttadon.database.h
    public LiveData<List<MkCommentStatus>> a() {
        return this.a.getInvalidationTracker().createLiveData(new String[]{"MkCommentStatus"}, false, new b(RoomSQLiteQuery.acquire("select * from MkCommentStatus ", 0)));
    }
}
