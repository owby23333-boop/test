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
import cn.bmob.v3.util.BmobDbOpenHelper;
import com.amgcyo.cuttadon.api.entity.other.MkUser;
import com.baidu.mobads.sdk.api.ArticleInfo;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: MkUserDao_Impl.java */
/* JADX INFO: loaded from: classes.dex */
public final class m implements com.amgcyo.cuttadon.database.l {
    private final RoomDatabase a;
    private final EntityInsertionAdapter<MkUser> b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final com.amgcyo.cuttadon.j.c.c f3662c = new com.amgcyo.cuttadon.j.c.c();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final EntityDeletionOrUpdateAdapter<MkUser> f3663d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final EntityDeletionOrUpdateAdapter<MkUser> f3664e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final SharedSQLiteStatement f3665f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final SharedSQLiteStatement f3666g;

    /* JADX INFO: compiled from: MkUserDao_Impl.java */
    class a extends SharedSQLiteStatement {
        a(m mVar, RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "update MkUser set ad_style =?  where user_id = ? ";
        }
    }

    /* JADX INFO: compiled from: MkUserDao_Impl.java */
    class b extends SharedSQLiteStatement {
        b(m mVar, RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "update MkUser set master_user_id =?  where user_id = ? ";
        }
    }

    /* JADX INFO: compiled from: MkUserDao_Impl.java */
    class c implements Callable<MkUser> {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        final /* synthetic */ RoomSQLiteQuery f3667s;

        c(RoomSQLiteQuery roomSQLiteQuery) {
            this.f3667s = roomSQLiteQuery;
        }

        protected void finalize() {
            this.f3667s.release();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public MkUser call() throws Exception {
            MkUser mkUser;
            Cursor cursorQuery = DBUtil.query(m.this.a, this.f3667s, false, null);
            try {
                int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "art_id");
                int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "user_id");
                int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, BmobDbOpenHelper.USER);
                int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "phone");
                int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "token");
                int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "nick");
                int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "avatar");
                int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, ArticleInfo.USER_SEX);
                int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "ad_style");
                int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "master_user_id");
                int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "invitation_code");
                int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "invitation_count");
                int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "data");
                if (cursorQuery.moveToFirst()) {
                    MkUser mkUser2 = new MkUser();
                    mkUser2.setArt_id(cursorQuery.getInt(columnIndexOrThrow));
                    mkUser2.setUser_id(cursorQuery.getInt(columnIndexOrThrow2));
                    mkUser2.setUser(cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getString(columnIndexOrThrow3));
                    mkUser2.setPhone(cursorQuery.isNull(columnIndexOrThrow4) ? null : cursorQuery.getString(columnIndexOrThrow4));
                    mkUser2.setToken(cursorQuery.isNull(columnIndexOrThrow5) ? null : cursorQuery.getString(columnIndexOrThrow5));
                    mkUser2.setNick(cursorQuery.isNull(columnIndexOrThrow6) ? null : cursorQuery.getString(columnIndexOrThrow6));
                    mkUser2.setAvatar(cursorQuery.isNull(columnIndexOrThrow7) ? null : cursorQuery.getString(columnIndexOrThrow7));
                    mkUser2.setSex(cursorQuery.getInt(columnIndexOrThrow8));
                    mkUser2.setAd_style(cursorQuery.getInt(columnIndexOrThrow9));
                    mkUser2.setMaster_user_id(cursorQuery.getInt(columnIndexOrThrow10));
                    mkUser2.setInvitation_code(cursorQuery.isNull(columnIndexOrThrow11) ? null : cursorQuery.getString(columnIndexOrThrow11));
                    mkUser2.setInvitation_count(cursorQuery.getInt(columnIndexOrThrow12));
                    mkUser2.setData(m.this.f3662c.a(cursorQuery.isNull(columnIndexOrThrow13) ? null : cursorQuery.getString(columnIndexOrThrow13)));
                    mkUser = mkUser2;
                } else {
                    mkUser = null;
                }
                return mkUser;
            } finally {
                cursorQuery.close();
            }
        }
    }

    /* JADX INFO: compiled from: MkUserDao_Impl.java */
    class d extends EntityInsertionAdapter<MkUser> {
        d(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.EntityInsertionAdapter
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void bind(SupportSQLiteStatement supportSQLiteStatement, MkUser mkUser) {
            supportSQLiteStatement.bindLong(1, mkUser.getArt_id());
            supportSQLiteStatement.bindLong(2, mkUser.getUser_id());
            if (mkUser.getUser() == null) {
                supportSQLiteStatement.bindNull(3);
            } else {
                supportSQLiteStatement.bindString(3, mkUser.getUser());
            }
            if (mkUser.getPhone() == null) {
                supportSQLiteStatement.bindNull(4);
            } else {
                supportSQLiteStatement.bindString(4, mkUser.getPhone());
            }
            if (mkUser.getToken() == null) {
                supportSQLiteStatement.bindNull(5);
            } else {
                supportSQLiteStatement.bindString(5, mkUser.getToken());
            }
            if (mkUser.getNick() == null) {
                supportSQLiteStatement.bindNull(6);
            } else {
                supportSQLiteStatement.bindString(6, mkUser.getNick());
            }
            if (mkUser.getAvatar() == null) {
                supportSQLiteStatement.bindNull(7);
            } else {
                supportSQLiteStatement.bindString(7, mkUser.getAvatar());
            }
            supportSQLiteStatement.bindLong(8, mkUser.getSex());
            supportSQLiteStatement.bindLong(9, mkUser.getAd_style());
            supportSQLiteStatement.bindLong(10, mkUser.getMaster_user_id());
            if (mkUser.getInvitation_code() == null) {
                supportSQLiteStatement.bindNull(11);
            } else {
                supportSQLiteStatement.bindString(11, mkUser.getInvitation_code());
            }
            supportSQLiteStatement.bindLong(12, mkUser.getInvitation_count());
            String strA = m.this.f3662c.a(mkUser.getData());
            if (strA == null) {
                supportSQLiteStatement.bindNull(13);
            } else {
                supportSQLiteStatement.bindString(13, strA);
            }
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "INSERT OR REPLACE INTO `MkUser` (`art_id`,`user_id`,`user`,`phone`,`token`,`nick`,`avatar`,`sex`,`ad_style`,`master_user_id`,`invitation_code`,`invitation_count`,`data`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?,?,?,?)";
        }
    }

    /* JADX INFO: compiled from: MkUserDao_Impl.java */
    class e extends EntityDeletionOrUpdateAdapter<MkUser> {
        e(m mVar, RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.EntityDeletionOrUpdateAdapter
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void bind(SupportSQLiteStatement supportSQLiteStatement, MkUser mkUser) {
            supportSQLiteStatement.bindLong(1, mkUser.getArt_id());
        }

        @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "DELETE FROM `MkUser` WHERE `art_id` = ?";
        }
    }

    /* JADX INFO: compiled from: MkUserDao_Impl.java */
    class f extends EntityDeletionOrUpdateAdapter<MkUser> {
        f(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.EntityDeletionOrUpdateAdapter
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void bind(SupportSQLiteStatement supportSQLiteStatement, MkUser mkUser) {
            supportSQLiteStatement.bindLong(1, mkUser.getArt_id());
            supportSQLiteStatement.bindLong(2, mkUser.getUser_id());
            if (mkUser.getUser() == null) {
                supportSQLiteStatement.bindNull(3);
            } else {
                supportSQLiteStatement.bindString(3, mkUser.getUser());
            }
            if (mkUser.getPhone() == null) {
                supportSQLiteStatement.bindNull(4);
            } else {
                supportSQLiteStatement.bindString(4, mkUser.getPhone());
            }
            if (mkUser.getToken() == null) {
                supportSQLiteStatement.bindNull(5);
            } else {
                supportSQLiteStatement.bindString(5, mkUser.getToken());
            }
            if (mkUser.getNick() == null) {
                supportSQLiteStatement.bindNull(6);
            } else {
                supportSQLiteStatement.bindString(6, mkUser.getNick());
            }
            if (mkUser.getAvatar() == null) {
                supportSQLiteStatement.bindNull(7);
            } else {
                supportSQLiteStatement.bindString(7, mkUser.getAvatar());
            }
            supportSQLiteStatement.bindLong(8, mkUser.getSex());
            supportSQLiteStatement.bindLong(9, mkUser.getAd_style());
            supportSQLiteStatement.bindLong(10, mkUser.getMaster_user_id());
            if (mkUser.getInvitation_code() == null) {
                supportSQLiteStatement.bindNull(11);
            } else {
                supportSQLiteStatement.bindString(11, mkUser.getInvitation_code());
            }
            supportSQLiteStatement.bindLong(12, mkUser.getInvitation_count());
            String strA = m.this.f3662c.a(mkUser.getData());
            if (strA == null) {
                supportSQLiteStatement.bindNull(13);
            } else {
                supportSQLiteStatement.bindString(13, strA);
            }
            supportSQLiteStatement.bindLong(14, mkUser.getArt_id());
        }

        @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "UPDATE OR ABORT `MkUser` SET `art_id` = ?,`user_id` = ?,`user` = ?,`phone` = ?,`token` = ?,`nick` = ?,`avatar` = ?,`sex` = ?,`ad_style` = ?,`master_user_id` = ?,`invitation_code` = ?,`invitation_count` = ?,`data` = ? WHERE `art_id` = ?";
        }
    }

    /* JADX INFO: compiled from: MkUserDao_Impl.java */
    class g extends SharedSQLiteStatement {
        g(m mVar, RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "delete from MkUser";
        }
    }

    /* JADX INFO: compiled from: MkUserDao_Impl.java */
    class h extends SharedSQLiteStatement {
        h(m mVar, RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "update MkUser set avatar =?  where user_id = ? ";
        }
    }

    /* JADX INFO: compiled from: MkUserDao_Impl.java */
    class i extends SharedSQLiteStatement {
        i(m mVar, RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "update MkUser set nick =?  where user_id = ? ";
        }
    }

    /* JADX INFO: compiled from: MkUserDao_Impl.java */
    class j extends SharedSQLiteStatement {
        j(m mVar, RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "update MkUser set phone =? , user=?  where user_id = ? ";
        }
    }

    /* JADX INFO: compiled from: MkUserDao_Impl.java */
    class k extends SharedSQLiteStatement {
        k(m mVar, RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "update MkUser set invitation_code =?  where user_id = ? ";
        }
    }

    /* JADX INFO: compiled from: MkUserDao_Impl.java */
    class l extends SharedSQLiteStatement {
        l(m mVar, RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "update MkUser set invitation_count =?  where user_id = ? ";
        }
    }

    public m(RoomDatabase roomDatabase) {
        this.a = roomDatabase;
        this.b = new d(roomDatabase);
        this.f3663d = new e(this, roomDatabase);
        this.f3664e = new f(roomDatabase);
        this.f3665f = new g(this, roomDatabase);
        this.f3666g = new h(this, roomDatabase);
        new i(this, roomDatabase);
        new j(this, roomDatabase);
        new k(this, roomDatabase);
        new l(this, roomDatabase);
        new a(this, roomDatabase);
        new b(this, roomDatabase);
    }

    public static List<Class<?>> d() {
        return Collections.emptyList();
    }

    @Override // com.amgcyo.cuttadon.database.l
    public LiveData<MkUser> c() {
        return this.a.getInvalidationTracker().createLiveData(new String[]{"MkUser"}, false, new c(RoomSQLiteQuery.acquire("select * from MkUser ORDER BY art_id DESC LIMIT 0,1", 0)));
    }

    @Override // com.amgcyo.cuttadon.database.l
    public void delete(MkUser mkUser) {
        this.a.assertNotSuspendingTransaction();
        this.a.beginTransaction();
        try {
            this.f3663d.handle(mkUser);
            this.a.setTransactionSuccessful();
        } finally {
            this.a.endTransaction();
        }
    }

    @Override // com.amgcyo.cuttadon.database.l
    public long insert(MkUser mkUser) {
        this.a.assertNotSuspendingTransaction();
        this.a.beginTransaction();
        try {
            long jInsertAndReturnId = this.b.insertAndReturnId(mkUser);
            this.a.setTransactionSuccessful();
            return jInsertAndReturnId;
        } finally {
            this.a.endTransaction();
        }
    }

    @Override // com.amgcyo.cuttadon.database.l
    public int update(MkUser mkUser) {
        this.a.assertNotSuspendingTransaction();
        this.a.beginTransaction();
        try {
            int iHandle = this.f3664e.handle(mkUser) + 0;
            this.a.setTransactionSuccessful();
            return iHandle;
        } finally {
            this.a.endTransaction();
        }
    }

    @Override // com.amgcyo.cuttadon.database.l
    public int a(String str, int i2) {
        this.a.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.f3666g.acquire();
        if (str == null) {
            supportSQLiteStatementAcquire.bindNull(1);
        } else {
            supportSQLiteStatementAcquire.bindString(1, str);
        }
        supportSQLiteStatementAcquire.bindLong(2, i2);
        this.a.beginTransaction();
        try {
            int iExecuteUpdateDelete = supportSQLiteStatementAcquire.executeUpdateDelete();
            this.a.setTransactionSuccessful();
            return iExecuteUpdateDelete;
        } finally {
            this.a.endTransaction();
            this.f3666g.release(supportSQLiteStatementAcquire);
        }
    }

    @Override // com.amgcyo.cuttadon.database.l
    public int b() {
        this.a.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.f3665f.acquire();
        this.a.beginTransaction();
        try {
            int iExecuteUpdateDelete = supportSQLiteStatementAcquire.executeUpdateDelete();
            this.a.setTransactionSuccessful();
            return iExecuteUpdateDelete;
        } finally {
            this.a.endTransaction();
            this.f3665f.release(supportSQLiteStatementAcquire);
        }
    }

    @Override // com.amgcyo.cuttadon.database.l
    public MkUser a() throws Throwable {
        RoomSQLiteQuery roomSQLiteQuery;
        MkUser mkUser;
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("select * from MkUser ORDER BY art_id DESC LIMIT 0,1", 0);
        this.a.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.a, roomSQLiteQueryAcquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "art_id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "user_id");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, BmobDbOpenHelper.USER);
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "phone");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "token");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "nick");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "avatar");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, ArticleInfo.USER_SEX);
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "ad_style");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "master_user_id");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "invitation_code");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "invitation_count");
            int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "data");
            if (cursorQuery.moveToFirst()) {
                roomSQLiteQuery = roomSQLiteQueryAcquire;
                try {
                    MkUser mkUser2 = new MkUser();
                    mkUser2.setArt_id(cursorQuery.getInt(columnIndexOrThrow));
                    mkUser2.setUser_id(cursorQuery.getInt(columnIndexOrThrow2));
                    mkUser2.setUser(cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getString(columnIndexOrThrow3));
                    mkUser2.setPhone(cursorQuery.isNull(columnIndexOrThrow4) ? null : cursorQuery.getString(columnIndexOrThrow4));
                    mkUser2.setToken(cursorQuery.isNull(columnIndexOrThrow5) ? null : cursorQuery.getString(columnIndexOrThrow5));
                    mkUser2.setNick(cursorQuery.isNull(columnIndexOrThrow6) ? null : cursorQuery.getString(columnIndexOrThrow6));
                    mkUser2.setAvatar(cursorQuery.isNull(columnIndexOrThrow7) ? null : cursorQuery.getString(columnIndexOrThrow7));
                    mkUser2.setSex(cursorQuery.getInt(columnIndexOrThrow8));
                    mkUser2.setAd_style(cursorQuery.getInt(columnIndexOrThrow9));
                    mkUser2.setMaster_user_id(cursorQuery.getInt(columnIndexOrThrow10));
                    mkUser2.setInvitation_code(cursorQuery.isNull(columnIndexOrThrow11) ? null : cursorQuery.getString(columnIndexOrThrow11));
                    mkUser2.setInvitation_count(cursorQuery.getInt(columnIndexOrThrow12));
                    mkUser2.setData(this.f3662c.a(cursorQuery.isNull(columnIndexOrThrow13) ? null : cursorQuery.getString(columnIndexOrThrow13)));
                    mkUser = mkUser2;
                } catch (Throwable th) {
                    th = th;
                    cursorQuery.close();
                    roomSQLiteQuery.release();
                    throw th;
                }
            } else {
                roomSQLiteQuery = roomSQLiteQueryAcquire;
                mkUser = null;
            }
            cursorQuery.close();
            roomSQLiteQuery.release();
            return mkUser;
        } catch (Throwable th2) {
            th = th2;
            roomSQLiteQuery = roomSQLiteQueryAcquire;
        }
    }
}
