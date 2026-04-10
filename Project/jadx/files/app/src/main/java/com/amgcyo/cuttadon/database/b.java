package com.amgcyo.cuttadon.database;

import android.database.Cursor;
import androidx.lifecycle.LiveData;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.amgcyo.cuttadon.api.entity.other.LocalReadHistoryBean;
import com.anythink.expressad.foundation.d.c;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: LocalReadHistorykDao_Impl.java */
/* JADX INFO: loaded from: classes.dex */
public final class b implements com.amgcyo.cuttadon.database.a {
    private final RoomDatabase a;
    private final EntityInsertionAdapter<LocalReadHistoryBean> b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final EntityDeletionOrUpdateAdapter<LocalReadHistoryBean> f3625c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final SharedSQLiteStatement f3626d;

    /* JADX INFO: compiled from: LocalReadHistorykDao_Impl.java */
    class a extends EntityInsertionAdapter<LocalReadHistoryBean> {
        a(b bVar, RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.EntityInsertionAdapter
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void bind(SupportSQLiteStatement supportSQLiteStatement, LocalReadHistoryBean localReadHistoryBean) {
            supportSQLiteStatement.bindLong(1, localReadHistoryBean.getBook_id());
            if (localReadHistoryBean.getName() == null) {
                supportSQLiteStatement.bindNull(2);
            } else {
                supportSQLiteStatement.bindString(2, localReadHistoryBean.getName());
            }
            if (localReadHistoryBean.getAuthor() == null) {
                supportSQLiteStatement.bindNull(3);
            } else {
                supportSQLiteStatement.bindString(3, localReadHistoryBean.getAuthor());
            }
            if (localReadHistoryBean.getImage() == null) {
                supportSQLiteStatement.bindNull(4);
            } else {
                supportSQLiteStatement.bindString(4, localReadHistoryBean.getImage());
            }
            if (localReadHistoryBean.getCreated_at() == null) {
                supportSQLiteStatement.bindNull(5);
            } else {
                supportSQLiteStatement.bindString(5, localReadHistoryBean.getCreated_at());
            }
            if (localReadHistoryBean.getLtype() == null) {
                supportSQLiteStatement.bindNull(6);
            } else {
                supportSQLiteStatement.bindString(6, localReadHistoryBean.getLtype());
            }
            if (localReadHistoryBean.getStype() == null) {
                supportSQLiteStatement.bindNull(7);
            } else {
                supportSQLiteStatement.bindString(7, localReadHistoryBean.getStype());
            }
            supportSQLiteStatement.bindLong(8, localReadHistoryBean.getStatus());
            supportSQLiteStatement.bindLong(9, localReadHistoryBean.getFav_count());
            supportSQLiteStatement.bindLong(10, localReadHistoryBean.getComment_number());
            supportSQLiteStatement.bindLong(11, localReadHistoryBean.getForm());
            supportSQLiteStatement.bindLong(12, localReadHistoryBean.getWords_number());
            supportSQLiteStatement.bindLong(13, localReadHistoryBean.getChapter_count());
            if (localReadHistoryBean.getLast_chapter_name() == null) {
                supportSQLiteStatement.bindNull(14);
            } else {
                supportSQLiteStatement.bindString(14, localReadHistoryBean.getLast_chapter_name());
            }
            if (localReadHistoryBean.getUpdated_at() == null) {
                supportSQLiteStatement.bindNull(15);
            } else {
                supportSQLiteStatement.bindString(15, localReadHistoryBean.getUpdated_at());
            }
            if (localReadHistoryBean.getList_reload_path() == null) {
                supportSQLiteStatement.bindNull(16);
            } else {
                supportSQLiteStatement.bindString(16, localReadHistoryBean.getList_reload_path());
            }
            if (localReadHistoryBean.getList_path() == null) {
                supportSQLiteStatement.bindNull(17);
            } else {
                supportSQLiteStatement.bindString(17, localReadHistoryBean.getList_path());
            }
            supportSQLiteStatement.bindLong(18, localReadHistoryBean.getType());
            supportSQLiteStatement.bindLong(19, localReadHistoryBean.getNeedToldServer());
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "INSERT OR REPLACE INTO `LocalReadHistoryBean` (`book_id`,`name`,`author`,`image`,`created_at`,`ltype`,`stype`,`status`,`fav_count`,`comment_number`,`form`,`words_number`,`chapter_count`,`last_chapter_name`,`updated_at`,`list_reload_path`,`list_path`,`type`,`needToldServer`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        }
    }

    /* JADX INFO: renamed from: com.amgcyo.cuttadon.database.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: LocalReadHistorykDao_Impl.java */
    class C0086b extends EntityDeletionOrUpdateAdapter<LocalReadHistoryBean> {
        C0086b(b bVar, RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.EntityDeletionOrUpdateAdapter
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void bind(SupportSQLiteStatement supportSQLiteStatement, LocalReadHistoryBean localReadHistoryBean) {
            supportSQLiteStatement.bindLong(1, localReadHistoryBean.getBook_id());
            if (localReadHistoryBean.getName() == null) {
                supportSQLiteStatement.bindNull(2);
            } else {
                supportSQLiteStatement.bindString(2, localReadHistoryBean.getName());
            }
            if (localReadHistoryBean.getAuthor() == null) {
                supportSQLiteStatement.bindNull(3);
            } else {
                supportSQLiteStatement.bindString(3, localReadHistoryBean.getAuthor());
            }
            if (localReadHistoryBean.getImage() == null) {
                supportSQLiteStatement.bindNull(4);
            } else {
                supportSQLiteStatement.bindString(4, localReadHistoryBean.getImage());
            }
            if (localReadHistoryBean.getCreated_at() == null) {
                supportSQLiteStatement.bindNull(5);
            } else {
                supportSQLiteStatement.bindString(5, localReadHistoryBean.getCreated_at());
            }
            if (localReadHistoryBean.getLtype() == null) {
                supportSQLiteStatement.bindNull(6);
            } else {
                supportSQLiteStatement.bindString(6, localReadHistoryBean.getLtype());
            }
            if (localReadHistoryBean.getStype() == null) {
                supportSQLiteStatement.bindNull(7);
            } else {
                supportSQLiteStatement.bindString(7, localReadHistoryBean.getStype());
            }
            supportSQLiteStatement.bindLong(8, localReadHistoryBean.getStatus());
            supportSQLiteStatement.bindLong(9, localReadHistoryBean.getFav_count());
            supportSQLiteStatement.bindLong(10, localReadHistoryBean.getComment_number());
            supportSQLiteStatement.bindLong(11, localReadHistoryBean.getForm());
            supportSQLiteStatement.bindLong(12, localReadHistoryBean.getWords_number());
            supportSQLiteStatement.bindLong(13, localReadHistoryBean.getChapter_count());
            if (localReadHistoryBean.getLast_chapter_name() == null) {
                supportSQLiteStatement.bindNull(14);
            } else {
                supportSQLiteStatement.bindString(14, localReadHistoryBean.getLast_chapter_name());
            }
            if (localReadHistoryBean.getUpdated_at() == null) {
                supportSQLiteStatement.bindNull(15);
            } else {
                supportSQLiteStatement.bindString(15, localReadHistoryBean.getUpdated_at());
            }
            if (localReadHistoryBean.getList_reload_path() == null) {
                supportSQLiteStatement.bindNull(16);
            } else {
                supportSQLiteStatement.bindString(16, localReadHistoryBean.getList_reload_path());
            }
            if (localReadHistoryBean.getList_path() == null) {
                supportSQLiteStatement.bindNull(17);
            } else {
                supportSQLiteStatement.bindString(17, localReadHistoryBean.getList_path());
            }
            supportSQLiteStatement.bindLong(18, localReadHistoryBean.getType());
            supportSQLiteStatement.bindLong(19, localReadHistoryBean.getNeedToldServer());
            supportSQLiteStatement.bindLong(20, localReadHistoryBean.getBook_id());
        }

        @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "UPDATE OR REPLACE `LocalReadHistoryBean` SET `book_id` = ?,`name` = ?,`author` = ?,`image` = ?,`created_at` = ?,`ltype` = ?,`stype` = ?,`status` = ?,`fav_count` = ?,`comment_number` = ?,`form` = ?,`words_number` = ?,`chapter_count` = ?,`last_chapter_name` = ?,`updated_at` = ?,`list_reload_path` = ?,`list_path` = ?,`type` = ?,`needToldServer` = ? WHERE `book_id` = ?";
        }
    }

    /* JADX INFO: compiled from: LocalReadHistorykDao_Impl.java */
    class c extends SharedSQLiteStatement {
        c(b bVar, RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "DELETE FROM LocalReadHistoryBean  where form=? ";
        }
    }

    /* JADX INFO: compiled from: LocalReadHistorykDao_Impl.java */
    class d extends SharedSQLiteStatement {
        d(b bVar, RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "update LocalReadHistoryBean set needToldServer =1 where book_id = ? ";
        }
    }

    /* JADX INFO: compiled from: LocalReadHistorykDao_Impl.java */
    class e implements Callable<List<LocalReadHistoryBean>> {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        final /* synthetic */ RoomSQLiteQuery f3627s;

        e(RoomSQLiteQuery roomSQLiteQuery) {
            this.f3627s = roomSQLiteQuery;
        }

        protected void finalize() {
            this.f3627s.release();
        }

        @Override // java.util.concurrent.Callable
        public List<LocalReadHistoryBean> call() throws Exception {
            int i2;
            String string;
            int i3;
            String string2;
            String string3;
            String string4;
            Cursor cursorQuery = DBUtil.query(b.this.a, this.f3627s, false, null);
            try {
                int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "book_id");
                int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "name");
                int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "author");
                int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, c.C0205c.f10205e);
                int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "created_at");
                int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "ltype");
                int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "stype");
                int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "status");
                int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "fav_count");
                int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "comment_number");
                int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "form");
                int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "words_number");
                int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "chapter_count");
                int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "last_chapter_name");
                int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "updated_at");
                int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "list_reload_path");
                int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "list_path");
                int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "type");
                int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "needToldServer");
                int i4 = columnIndexOrThrow14;
                ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                while (cursorQuery.moveToNext()) {
                    LocalReadHistoryBean localReadHistoryBean = new LocalReadHistoryBean();
                    ArrayList arrayList2 = arrayList;
                    localReadHistoryBean.setBook_id(cursorQuery.getInt(columnIndexOrThrow));
                    localReadHistoryBean.setName(cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2));
                    localReadHistoryBean.setAuthor(cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getString(columnIndexOrThrow3));
                    localReadHistoryBean.setImage(cursorQuery.isNull(columnIndexOrThrow4) ? null : cursorQuery.getString(columnIndexOrThrow4));
                    localReadHistoryBean.setCreated_at(cursorQuery.isNull(columnIndexOrThrow5) ? null : cursorQuery.getString(columnIndexOrThrow5));
                    localReadHistoryBean.setLtype(cursorQuery.isNull(columnIndexOrThrow6) ? null : cursorQuery.getString(columnIndexOrThrow6));
                    localReadHistoryBean.setStype(cursorQuery.isNull(columnIndexOrThrow7) ? null : cursorQuery.getString(columnIndexOrThrow7));
                    localReadHistoryBean.setStatus(cursorQuery.getInt(columnIndexOrThrow8));
                    localReadHistoryBean.setFav_count(cursorQuery.getInt(columnIndexOrThrow9));
                    localReadHistoryBean.setComment_number(cursorQuery.getInt(columnIndexOrThrow10));
                    localReadHistoryBean.setForm(cursorQuery.getInt(columnIndexOrThrow11));
                    localReadHistoryBean.setWords_number(cursorQuery.getInt(columnIndexOrThrow12));
                    localReadHistoryBean.setChapter_count(cursorQuery.getInt(columnIndexOrThrow13));
                    int i5 = i4;
                    if (cursorQuery.isNull(i5)) {
                        i2 = columnIndexOrThrow;
                        string = null;
                    } else {
                        i2 = columnIndexOrThrow;
                        string = cursorQuery.getString(i5);
                    }
                    localReadHistoryBean.setLast_chapter_name(string);
                    int i6 = columnIndexOrThrow15;
                    if (cursorQuery.isNull(i6)) {
                        i3 = i6;
                        string2 = null;
                    } else {
                        i3 = i6;
                        string2 = cursorQuery.getString(i6);
                    }
                    localReadHistoryBean.setUpdated_at(string2);
                    int i7 = columnIndexOrThrow16;
                    if (cursorQuery.isNull(i7)) {
                        columnIndexOrThrow16 = i7;
                        string3 = null;
                    } else {
                        columnIndexOrThrow16 = i7;
                        string3 = cursorQuery.getString(i7);
                    }
                    localReadHistoryBean.setList_reload_path(string3);
                    int i8 = columnIndexOrThrow17;
                    if (cursorQuery.isNull(i8)) {
                        columnIndexOrThrow17 = i8;
                        string4 = null;
                    } else {
                        columnIndexOrThrow17 = i8;
                        string4 = cursorQuery.getString(i8);
                    }
                    localReadHistoryBean.setList_path(string4);
                    int i9 = columnIndexOrThrow18;
                    localReadHistoryBean.setType(cursorQuery.getInt(i9));
                    columnIndexOrThrow18 = i9;
                    int i10 = columnIndexOrThrow19;
                    localReadHistoryBean.setNeedToldServer(cursorQuery.getInt(i10));
                    arrayList2.add(localReadHistoryBean);
                    columnIndexOrThrow19 = i10;
                    arrayList = arrayList2;
                    columnIndexOrThrow = i2;
                    int i11 = i3;
                    i4 = i5;
                    columnIndexOrThrow15 = i11;
                }
                return arrayList;
            } finally {
                cursorQuery.close();
            }
        }
    }

    public b(RoomDatabase roomDatabase) {
        this.a = roomDatabase;
        this.b = new a(this, roomDatabase);
        this.f3625c = new C0086b(this, roomDatabase);
        this.f3626d = new c(this, roomDatabase);
        new d(this, roomDatabase);
    }

    @Override // com.amgcyo.cuttadon.database.a
    public int b(int i2) {
        this.a.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.f3626d.acquire();
        supportSQLiteStatementAcquire.bindLong(1, i2);
        this.a.beginTransaction();
        try {
            int iExecuteUpdateDelete = supportSQLiteStatementAcquire.executeUpdateDelete();
            this.a.setTransactionSuccessful();
            return iExecuteUpdateDelete;
        } finally {
            this.a.endTransaction();
            this.f3626d.release(supportSQLiteStatementAcquire);
        }
    }

    @Override // com.amgcyo.cuttadon.database.a
    public LocalReadHistoryBean c(int i2) throws Throwable {
        RoomSQLiteQuery roomSQLiteQuery;
        int columnIndexOrThrow;
        int columnIndexOrThrow2;
        int columnIndexOrThrow3;
        int columnIndexOrThrow4;
        int columnIndexOrThrow5;
        int columnIndexOrThrow6;
        int columnIndexOrThrow7;
        int columnIndexOrThrow8;
        int columnIndexOrThrow9;
        int columnIndexOrThrow10;
        int columnIndexOrThrow11;
        int columnIndexOrThrow12;
        int columnIndexOrThrow13;
        int columnIndexOrThrow14;
        LocalReadHistoryBean localReadHistoryBean;
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("select * from LocalReadHistoryBean where book_id = ? ", 1);
        roomSQLiteQueryAcquire.bindLong(1, i2);
        this.a.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.a, roomSQLiteQueryAcquire, false, null);
        try {
            columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "book_id");
            columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "name");
            columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "author");
            columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, c.C0205c.f10205e);
            columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "created_at");
            columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "ltype");
            columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "stype");
            columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "status");
            columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "fav_count");
            columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "comment_number");
            columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "form");
            columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "words_number");
            columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "chapter_count");
            columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "last_chapter_name");
            roomSQLiteQuery = roomSQLiteQueryAcquire;
        } catch (Throwable th) {
            th = th;
            roomSQLiteQuery = roomSQLiteQueryAcquire;
        }
        try {
            int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "updated_at");
            int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "list_reload_path");
            int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "list_path");
            int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "type");
            int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "needToldServer");
            if (cursorQuery.moveToFirst()) {
                localReadHistoryBean = new LocalReadHistoryBean();
                localReadHistoryBean.setBook_id(cursorQuery.getInt(columnIndexOrThrow));
                localReadHistoryBean.setName(cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2));
                localReadHistoryBean.setAuthor(cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getString(columnIndexOrThrow3));
                localReadHistoryBean.setImage(cursorQuery.isNull(columnIndexOrThrow4) ? null : cursorQuery.getString(columnIndexOrThrow4));
                localReadHistoryBean.setCreated_at(cursorQuery.isNull(columnIndexOrThrow5) ? null : cursorQuery.getString(columnIndexOrThrow5));
                localReadHistoryBean.setLtype(cursorQuery.isNull(columnIndexOrThrow6) ? null : cursorQuery.getString(columnIndexOrThrow6));
                localReadHistoryBean.setStype(cursorQuery.isNull(columnIndexOrThrow7) ? null : cursorQuery.getString(columnIndexOrThrow7));
                localReadHistoryBean.setStatus(cursorQuery.getInt(columnIndexOrThrow8));
                localReadHistoryBean.setFav_count(cursorQuery.getInt(columnIndexOrThrow9));
                localReadHistoryBean.setComment_number(cursorQuery.getInt(columnIndexOrThrow10));
                localReadHistoryBean.setForm(cursorQuery.getInt(columnIndexOrThrow11));
                localReadHistoryBean.setWords_number(cursorQuery.getInt(columnIndexOrThrow12));
                localReadHistoryBean.setChapter_count(cursorQuery.getInt(columnIndexOrThrow13));
                localReadHistoryBean.setLast_chapter_name(cursorQuery.isNull(columnIndexOrThrow14) ? null : cursorQuery.getString(columnIndexOrThrow14));
                localReadHistoryBean.setUpdated_at(cursorQuery.isNull(columnIndexOrThrow15) ? null : cursorQuery.getString(columnIndexOrThrow15));
                localReadHistoryBean.setList_reload_path(cursorQuery.isNull(columnIndexOrThrow16) ? null : cursorQuery.getString(columnIndexOrThrow16));
                localReadHistoryBean.setList_path(cursorQuery.isNull(columnIndexOrThrow17) ? null : cursorQuery.getString(columnIndexOrThrow17));
                localReadHistoryBean.setType(cursorQuery.getInt(columnIndexOrThrow18));
                localReadHistoryBean.setNeedToldServer(cursorQuery.getInt(columnIndexOrThrow19));
            } else {
                localReadHistoryBean = null;
            }
            cursorQuery.close();
            roomSQLiteQuery.release();
            return localReadHistoryBean;
        } catch (Throwable th2) {
            th = th2;
            cursorQuery.close();
            roomSQLiteQuery.release();
            throw th;
        }
    }

    @Override // com.amgcyo.cuttadon.database.a
    public long insert(LocalReadHistoryBean localReadHistoryBean) {
        this.a.assertNotSuspendingTransaction();
        this.a.beginTransaction();
        try {
            long jInsertAndReturnId = this.b.insertAndReturnId(localReadHistoryBean);
            this.a.setTransactionSuccessful();
            return jInsertAndReturnId;
        } finally {
            this.a.endTransaction();
        }
    }

    @Override // com.amgcyo.cuttadon.database.a
    public void update(LocalReadHistoryBean localReadHistoryBean) {
        this.a.assertNotSuspendingTransaction();
        this.a.beginTransaction();
        try {
            this.f3625c.handle(localReadHistoryBean);
            this.a.setTransactionSuccessful();
        } finally {
            this.a.endTransaction();
        }
    }

    @Override // com.amgcyo.cuttadon.database.a
    public List<LocalReadHistoryBean> a(int i2) throws Throwable {
        RoomSQLiteQuery roomSQLiteQuery;
        int columnIndexOrThrow;
        int columnIndexOrThrow2;
        int columnIndexOrThrow3;
        int columnIndexOrThrow4;
        int columnIndexOrThrow5;
        int columnIndexOrThrow6;
        int columnIndexOrThrow7;
        int columnIndexOrThrow8;
        int columnIndexOrThrow9;
        int columnIndexOrThrow10;
        int columnIndexOrThrow11;
        int columnIndexOrThrow12;
        int columnIndexOrThrow13;
        int columnIndexOrThrow14;
        int i3;
        String string;
        int i4;
        String string2;
        String string3;
        String string4;
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("select * from LocalReadHistoryBean where form=? ORDER BY  created_at DESC ", 1);
        roomSQLiteQueryAcquire.bindLong(1, i2);
        this.a.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.a, roomSQLiteQueryAcquire, false, null);
        try {
            columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "book_id");
            columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "name");
            columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "author");
            columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, c.C0205c.f10205e);
            columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "created_at");
            columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "ltype");
            columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "stype");
            columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "status");
            columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "fav_count");
            columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "comment_number");
            columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "form");
            columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "words_number");
            columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "chapter_count");
            columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "last_chapter_name");
            roomSQLiteQuery = roomSQLiteQueryAcquire;
        } catch (Throwable th) {
            th = th;
            roomSQLiteQuery = roomSQLiteQueryAcquire;
        }
        try {
            int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "updated_at");
            int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "list_reload_path");
            int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "list_path");
            int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "type");
            int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "needToldServer");
            int i5 = columnIndexOrThrow14;
            ArrayList arrayList = new ArrayList(cursorQuery.getCount());
            while (cursorQuery.moveToNext()) {
                LocalReadHistoryBean localReadHistoryBean = new LocalReadHistoryBean();
                ArrayList arrayList2 = arrayList;
                localReadHistoryBean.setBook_id(cursorQuery.getInt(columnIndexOrThrow));
                localReadHistoryBean.setName(cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2));
                localReadHistoryBean.setAuthor(cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getString(columnIndexOrThrow3));
                localReadHistoryBean.setImage(cursorQuery.isNull(columnIndexOrThrow4) ? null : cursorQuery.getString(columnIndexOrThrow4));
                localReadHistoryBean.setCreated_at(cursorQuery.isNull(columnIndexOrThrow5) ? null : cursorQuery.getString(columnIndexOrThrow5));
                localReadHistoryBean.setLtype(cursorQuery.isNull(columnIndexOrThrow6) ? null : cursorQuery.getString(columnIndexOrThrow6));
                localReadHistoryBean.setStype(cursorQuery.isNull(columnIndexOrThrow7) ? null : cursorQuery.getString(columnIndexOrThrow7));
                localReadHistoryBean.setStatus(cursorQuery.getInt(columnIndexOrThrow8));
                localReadHistoryBean.setFav_count(cursorQuery.getInt(columnIndexOrThrow9));
                localReadHistoryBean.setComment_number(cursorQuery.getInt(columnIndexOrThrow10));
                localReadHistoryBean.setForm(cursorQuery.getInt(columnIndexOrThrow11));
                localReadHistoryBean.setWords_number(cursorQuery.getInt(columnIndexOrThrow12));
                localReadHistoryBean.setChapter_count(cursorQuery.getInt(columnIndexOrThrow13));
                int i6 = i5;
                if (cursorQuery.isNull(i6)) {
                    i3 = columnIndexOrThrow;
                    string = null;
                } else {
                    i3 = columnIndexOrThrow;
                    string = cursorQuery.getString(i6);
                }
                localReadHistoryBean.setLast_chapter_name(string);
                int i7 = columnIndexOrThrow15;
                if (cursorQuery.isNull(i7)) {
                    i4 = i7;
                    string2 = null;
                } else {
                    i4 = i7;
                    string2 = cursorQuery.getString(i7);
                }
                localReadHistoryBean.setUpdated_at(string2);
                int i8 = columnIndexOrThrow16;
                if (cursorQuery.isNull(i8)) {
                    columnIndexOrThrow16 = i8;
                    string3 = null;
                } else {
                    columnIndexOrThrow16 = i8;
                    string3 = cursorQuery.getString(i8);
                }
                localReadHistoryBean.setList_reload_path(string3);
                int i9 = columnIndexOrThrow17;
                if (cursorQuery.isNull(i9)) {
                    columnIndexOrThrow17 = i9;
                    string4 = null;
                } else {
                    columnIndexOrThrow17 = i9;
                    string4 = cursorQuery.getString(i9);
                }
                localReadHistoryBean.setList_path(string4);
                int i10 = columnIndexOrThrow18;
                localReadHistoryBean.setType(cursorQuery.getInt(i10));
                columnIndexOrThrow18 = i10;
                int i11 = columnIndexOrThrow19;
                localReadHistoryBean.setNeedToldServer(cursorQuery.getInt(i11));
                arrayList2.add(localReadHistoryBean);
                columnIndexOrThrow19 = i11;
                arrayList = arrayList2;
                columnIndexOrThrow = i3;
                int i12 = i4;
                i5 = i6;
                columnIndexOrThrow15 = i12;
            }
            ArrayList arrayList3 = arrayList;
            cursorQuery.close();
            roomSQLiteQuery.release();
            return arrayList3;
        } catch (Throwable th2) {
            th = th2;
            cursorQuery.close();
            roomSQLiteQuery.release();
            throw th;
        }
    }

    @Override // com.amgcyo.cuttadon.database.a
    public List<LocalReadHistoryBean> b() throws Throwable {
        RoomSQLiteQuery roomSQLiteQuery;
        int columnIndexOrThrow;
        int columnIndexOrThrow2;
        int columnIndexOrThrow3;
        int columnIndexOrThrow4;
        int columnIndexOrThrow5;
        int columnIndexOrThrow6;
        int columnIndexOrThrow7;
        int columnIndexOrThrow8;
        int columnIndexOrThrow9;
        int columnIndexOrThrow10;
        int columnIndexOrThrow11;
        int columnIndexOrThrow12;
        int columnIndexOrThrow13;
        int columnIndexOrThrow14;
        int i2;
        String string;
        int i3;
        String string2;
        String string3;
        String string4;
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("select * from LocalReadHistoryBean ORDER BY  created_at DESC ", 0);
        this.a.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.a, roomSQLiteQueryAcquire, false, null);
        try {
            columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "book_id");
            columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "name");
            columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "author");
            columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, c.C0205c.f10205e);
            columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "created_at");
            columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "ltype");
            columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "stype");
            columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "status");
            columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "fav_count");
            columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "comment_number");
            columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "form");
            columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "words_number");
            columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "chapter_count");
            columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "last_chapter_name");
            roomSQLiteQuery = roomSQLiteQueryAcquire;
        } catch (Throwable th) {
            th = th;
            roomSQLiteQuery = roomSQLiteQueryAcquire;
        }
        try {
            int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "updated_at");
            int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "list_reload_path");
            int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "list_path");
            int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "type");
            int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "needToldServer");
            int i4 = columnIndexOrThrow14;
            ArrayList arrayList = new ArrayList(cursorQuery.getCount());
            while (cursorQuery.moveToNext()) {
                LocalReadHistoryBean localReadHistoryBean = new LocalReadHistoryBean();
                ArrayList arrayList2 = arrayList;
                localReadHistoryBean.setBook_id(cursorQuery.getInt(columnIndexOrThrow));
                localReadHistoryBean.setName(cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2));
                localReadHistoryBean.setAuthor(cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getString(columnIndexOrThrow3));
                localReadHistoryBean.setImage(cursorQuery.isNull(columnIndexOrThrow4) ? null : cursorQuery.getString(columnIndexOrThrow4));
                localReadHistoryBean.setCreated_at(cursorQuery.isNull(columnIndexOrThrow5) ? null : cursorQuery.getString(columnIndexOrThrow5));
                localReadHistoryBean.setLtype(cursorQuery.isNull(columnIndexOrThrow6) ? null : cursorQuery.getString(columnIndexOrThrow6));
                localReadHistoryBean.setStype(cursorQuery.isNull(columnIndexOrThrow7) ? null : cursorQuery.getString(columnIndexOrThrow7));
                localReadHistoryBean.setStatus(cursorQuery.getInt(columnIndexOrThrow8));
                localReadHistoryBean.setFav_count(cursorQuery.getInt(columnIndexOrThrow9));
                localReadHistoryBean.setComment_number(cursorQuery.getInt(columnIndexOrThrow10));
                localReadHistoryBean.setForm(cursorQuery.getInt(columnIndexOrThrow11));
                localReadHistoryBean.setWords_number(cursorQuery.getInt(columnIndexOrThrow12));
                localReadHistoryBean.setChapter_count(cursorQuery.getInt(columnIndexOrThrow13));
                int i5 = i4;
                if (cursorQuery.isNull(i5)) {
                    i2 = columnIndexOrThrow;
                    string = null;
                } else {
                    i2 = columnIndexOrThrow;
                    string = cursorQuery.getString(i5);
                }
                localReadHistoryBean.setLast_chapter_name(string);
                int i6 = columnIndexOrThrow15;
                if (cursorQuery.isNull(i6)) {
                    i3 = i6;
                    string2 = null;
                } else {
                    i3 = i6;
                    string2 = cursorQuery.getString(i6);
                }
                localReadHistoryBean.setUpdated_at(string2);
                int i7 = columnIndexOrThrow16;
                if (cursorQuery.isNull(i7)) {
                    columnIndexOrThrow16 = i7;
                    string3 = null;
                } else {
                    columnIndexOrThrow16 = i7;
                    string3 = cursorQuery.getString(i7);
                }
                localReadHistoryBean.setList_reload_path(string3);
                int i8 = columnIndexOrThrow17;
                if (cursorQuery.isNull(i8)) {
                    columnIndexOrThrow17 = i8;
                    string4 = null;
                } else {
                    columnIndexOrThrow17 = i8;
                    string4 = cursorQuery.getString(i8);
                }
                localReadHistoryBean.setList_path(string4);
                int i9 = columnIndexOrThrow18;
                localReadHistoryBean.setType(cursorQuery.getInt(i9));
                columnIndexOrThrow18 = i9;
                int i10 = columnIndexOrThrow19;
                localReadHistoryBean.setNeedToldServer(cursorQuery.getInt(i10));
                arrayList2.add(localReadHistoryBean);
                columnIndexOrThrow19 = i10;
                arrayList = arrayList2;
                columnIndexOrThrow = i2;
                int i11 = i3;
                i4 = i5;
                columnIndexOrThrow15 = i11;
            }
            ArrayList arrayList3 = arrayList;
            cursorQuery.close();
            roomSQLiteQuery.release();
            return arrayList3;
        } catch (Throwable th2) {
            th = th2;
            cursorQuery.close();
            roomSQLiteQuery.release();
            throw th;
        }
    }

    public static List<Class<?>> c() {
        return Collections.emptyList();
    }

    @Override // com.amgcyo.cuttadon.database.a
    public LiveData<List<LocalReadHistoryBean>> a() {
        return this.a.getInvalidationTracker().createLiveData(new String[]{"LocalReadHistoryBean"}, false, new e(RoomSQLiteQuery.acquire("select * from LocalReadHistoryBean ORDER BY  created_at DESC ", 0)));
    }
}
