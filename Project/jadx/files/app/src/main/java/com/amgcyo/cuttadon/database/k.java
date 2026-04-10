package com.amgcyo.cuttadon.database;

import android.database.Cursor;
import androidx.lifecycle.LiveData;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.amgcyo.cuttadon.api.entity.other.MkConfigSource;
import com.bytedance.sdk.openadsdk.live.TTLiveConstants;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: MkConfigSourceDao_Impl.java */
/* JADX INFO: loaded from: classes.dex */
public final class k implements j {
    private final RoomDatabase a;
    private final EntityInsertionAdapter<MkConfigSource> b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final SharedSQLiteStatement f3659c;

    /* JADX INFO: compiled from: MkConfigSourceDao_Impl.java */
    class a extends EntityInsertionAdapter<MkConfigSource> {
        a(k kVar, RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.EntityInsertionAdapter
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void bind(SupportSQLiteStatement supportSQLiteStatement, MkConfigSource mkConfigSource) {
            supportSQLiteStatement.bindLong(1, mkConfigSource.getArt_id());
            if (mkConfigSource.getSite_id() == null) {
                supportSQLiteStatement.bindNull(2);
            } else {
                supportSQLiteStatement.bindString(2, mkConfigSource.getSite_id());
            }
            supportSQLiteStatement.bindLong(3, mkConfigSource.getUrl_state());
            supportSQLiteStatement.bindLong(4, mkConfigSource.getRegular_time());
            String strA = com.amgcyo.cuttadon.j.c.d.a(mkConfigSource.getRegular());
            if (strA == null) {
                supportSQLiteStatement.bindNull(5);
            } else {
                supportSQLiteStatement.bindString(5, strA);
            }
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "INSERT OR REPLACE INTO `MkConfigSource` (`art_id`,`site_id`,`url_state`,`regular_time`,`regular`) VALUES (nullif(?, 0),?,?,?,?)";
        }
    }

    /* JADX INFO: compiled from: MkConfigSourceDao_Impl.java */
    class b extends SharedSQLiteStatement {
        b(k kVar, RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "update MkConfigSource set regular_time =?,regular=?   where site_id = ? ";
        }
    }

    /* JADX INFO: compiled from: MkConfigSourceDao_Impl.java */
    class c implements Callable<List<MkConfigSource>> {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        final /* synthetic */ RoomSQLiteQuery f3660s;

        c(RoomSQLiteQuery roomSQLiteQuery) {
            this.f3660s = roomSQLiteQuery;
        }

        protected void finalize() {
            this.f3660s.release();
        }

        @Override // java.util.concurrent.Callable
        public List<MkConfigSource> call() throws Exception {
            Cursor cursorQuery = DBUtil.query(k.this.a, this.f3660s, false, null);
            try {
                int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "art_id");
                int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, TTLiveConstants.APP_SITEID_KEY);
                int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "url_state");
                int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "regular_time");
                int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "regular");
                ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                while (cursorQuery.moveToNext()) {
                    MkConfigSource mkConfigSource = new MkConfigSource();
                    mkConfigSource.setArt_id(cursorQuery.getInt(columnIndexOrThrow));
                    mkConfigSource.setSite_id(cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2));
                    mkConfigSource.setUrl_state(cursorQuery.getInt(columnIndexOrThrow3));
                    mkConfigSource.setRegular_time(cursorQuery.getLong(columnIndexOrThrow4));
                    mkConfigSource.setRegular(com.amgcyo.cuttadon.j.c.d.a(cursorQuery.isNull(columnIndexOrThrow5) ? null : cursorQuery.getString(columnIndexOrThrow5)));
                    arrayList.add(mkConfigSource);
                }
                return arrayList;
            } finally {
                cursorQuery.close();
            }
        }
    }

    public k(RoomDatabase roomDatabase) {
        this.a = roomDatabase;
        this.b = new a(this, roomDatabase);
        this.f3659c = new b(this, roomDatabase);
    }

    public static List<Class<?>> b() {
        return Collections.emptyList();
    }

    @Override // com.amgcyo.cuttadon.database.j
    public long insert(MkConfigSource mkConfigSource) {
        this.a.assertNotSuspendingTransaction();
        this.a.beginTransaction();
        try {
            long jInsertAndReturnId = this.b.insertAndReturnId(mkConfigSource);
            this.a.setTransactionSuccessful();
            return jInsertAndReturnId;
        } finally {
            this.a.endTransaction();
        }
    }

    @Override // com.amgcyo.cuttadon.database.j
    public int a(long j2, String str, String str2) {
        this.a.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.f3659c.acquire();
        supportSQLiteStatementAcquire.bindLong(1, j2);
        if (str == null) {
            supportSQLiteStatementAcquire.bindNull(2);
        } else {
            supportSQLiteStatementAcquire.bindString(2, str);
        }
        if (str2 == null) {
            supportSQLiteStatementAcquire.bindNull(3);
        } else {
            supportSQLiteStatementAcquire.bindString(3, str2);
        }
        this.a.beginTransaction();
        try {
            int iExecuteUpdateDelete = supportSQLiteStatementAcquire.executeUpdateDelete();
            this.a.setTransactionSuccessful();
            return iExecuteUpdateDelete;
        } finally {
            this.a.endTransaction();
            this.f3659c.release(supportSQLiteStatementAcquire);
        }
    }

    @Override // com.amgcyo.cuttadon.database.j
    public MkConfigSource a(String str) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("select * from MkConfigSource where site_id = ? ", 1);
        if (str == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(1, str);
        }
        this.a.assertNotSuspendingTransaction();
        MkConfigSource mkConfigSource = null;
        String string = null;
        Cursor cursorQuery = DBUtil.query(this.a, roomSQLiteQueryAcquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "art_id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, TTLiveConstants.APP_SITEID_KEY);
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "url_state");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "regular_time");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "regular");
            if (cursorQuery.moveToFirst()) {
                MkConfigSource mkConfigSource2 = new MkConfigSource();
                mkConfigSource2.setArt_id(cursorQuery.getInt(columnIndexOrThrow));
                mkConfigSource2.setSite_id(cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2));
                mkConfigSource2.setUrl_state(cursorQuery.getInt(columnIndexOrThrow3));
                mkConfigSource2.setRegular_time(cursorQuery.getLong(columnIndexOrThrow4));
                if (!cursorQuery.isNull(columnIndexOrThrow5)) {
                    string = cursorQuery.getString(columnIndexOrThrow5);
                }
                mkConfigSource2.setRegular(com.amgcyo.cuttadon.j.c.d.a(string));
                mkConfigSource = mkConfigSource2;
            }
            return mkConfigSource;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // com.amgcyo.cuttadon.database.j
    public LiveData<List<MkConfigSource>> a() {
        return this.a.getInvalidationTracker().createLiveData(new String[]{"MkConfigSource"}, false, new c(RoomSQLiteQuery.acquire("select * from MkConfigSource ", 0)));
    }
}
