package com.umeng.analytics.pro;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseCorruptException;
import android.database.sqlite.SQLiteOpenHelper;
import com.umeng.commonsdk.debug.UMRTLog;

/* JADX INFO: compiled from: CacheDBHelper.java */
/* JADX INFO: loaded from: classes3.dex */
public class ao extends SQLiteOpenHelper {
    private static final Object b = new Object();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static ao f19503c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String f19504d = "CREATE TABLE IF NOT EXISTS stf(_id INTEGER PRIMARY KEY AUTOINCREMENT, _tp TEXT, _hd TEXT, _bd TEXT, _ts TEXT, _uuid TEXT, _re1 TEXT, _re2 TEXT)";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final String f19505e = "DROP TABLE IF EXISTS stf";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final String f19506f = "DELETE FROM stf WHERE _id IN( SELECT _id FROM stf ORDER BY _id LIMIT 1)";
    private final Context a;

    private ao(Context context, String str, SQLiteDatabase.CursorFactory cursorFactory, int i2) {
        super(context, str, cursorFactory, i2);
        this.a = context;
    }

    public static final int a() {
        return 1;
    }

    public static ao a(Context context) {
        ao aoVar;
        synchronized (b) {
            if (f19503c == null) {
                f19503c = new ao(context, aq.b, null, 1);
            }
            aoVar = f19503c;
        }
        return aoVar;
    }

    private void b(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL(f19504d);
        } catch (SQLiteDatabaseCorruptException unused) {
            a(sQLiteDatabase);
        } catch (Throwable th) {
            UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> [有状态]创建二级缓存数据库失败: " + th.getMessage());
        }
    }

    private void d() {
        try {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            if (writableDatabase == null || !writableDatabase.isOpen()) {
                return;
            }
            try {
                writableDatabase.execSQL(f19506f);
                if (writableDatabase == null) {
                    return;
                }
            } catch (Throwable unused) {
                if (writableDatabase == null) {
                    return;
                }
            }
            writableDatabase.close();
        } catch (Throwable unused2) {
        }
    }

    public boolean c() {
        return !b(aq.f19511c);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        b(sQLiteDatabase);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
    }

    public void b() {
        try {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            if (writableDatabase == null || !writableDatabase.isOpen()) {
                return;
            }
            writableDatabase.close();
        } catch (Throwable unused) {
        }
    }

    private void a(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL(f19505e);
            sQLiteDatabase.execSQL(f19504d);
        } catch (SQLException unused) {
        }
    }

    public boolean b(String str) {
        SQLiteDatabase writableDatabase;
        Cursor cursorQuery = null;
        try {
            writableDatabase = getWritableDatabase();
            if (writableDatabase != null) {
                try {
                    if (writableDatabase.isOpen()) {
                        cursorQuery = writableDatabase.query(str, null, null, null, null, null, null, null);
                    }
                } catch (Throwable unused) {
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    if (writableDatabase == null) {
                        return false;
                    }
                }
            }
            if (cursorQuery != null) {
                if (cursorQuery.getCount() > 0) {
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    if (writableDatabase != null) {
                        writableDatabase.close();
                    }
                    return true;
                }
            }
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            if (writableDatabase == null) {
                return false;
            }
        } catch (Throwable unused2) {
            writableDatabase = null;
        }
        writableDatabase.close();
        return false;
    }

    public void a(String str, ContentValues contentValues) {
        try {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            if (writableDatabase == null || !writableDatabase.isOpen()) {
                return;
            }
            try {
                writableDatabase.beginTransaction();
                writableDatabase.insert(str, null, contentValues);
                writableDatabase.setTransactionSuccessful();
                UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> [有状态]插入二级缓存数据记录 成功。");
                if (writableDatabase == null) {
                    return;
                }
            } catch (Throwable unused) {
                if (writableDatabase == null) {
                    return;
                }
            }
            writableDatabase.endTransaction();
            writableDatabase.close();
        } catch (Throwable unused2) {
        }
    }

    public void a(String str, String str2, String[] strArr) {
        try {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            if (writableDatabase == null || !writableDatabase.isOpen()) {
                return;
            }
            try {
                writableDatabase.beginTransaction();
                writableDatabase.delete(str, str2, strArr);
                writableDatabase.setTransactionSuccessful();
                if (writableDatabase == null) {
                    return;
                }
            } catch (Throwable unused) {
                if (writableDatabase == null) {
                    return;
                }
            }
            writableDatabase.endTransaction();
            writableDatabase.close();
        } catch (Throwable unused2) {
        }
    }

    public ap a(String str) {
        Cursor cursorA;
        ap apVar = null;
        try {
            cursorA = a(str, new String[]{aq.f19517i, aq.f19513e, aq.f19514f, aq.f19515g, aq.f19518j, aq.f19519k}, null, null, null, null, null, "1");
            if (cursorA != null) {
                try {
                    if (cursorA.moveToFirst()) {
                        ap apVar2 = new ap();
                        try {
                            apVar2.a = cursorA.getString(0);
                            apVar2.b = cursorA.getString(1);
                            String string = cursorA.getString(2);
                            String string2 = cursorA.getString(3);
                            apVar2.f19507c = i.a(this.a).d(string);
                            apVar2.f19508d = i.a(this.a).d(string2);
                            apVar2.f19509e = cursorA.getString(4);
                            apVar2.f19510f = cursorA.getString(5);
                            apVar = apVar2;
                        } catch (Throwable unused) {
                            apVar = apVar2;
                            try {
                                d();
                                if (cursorA != null) {
                                }
                                return apVar;
                            } finally {
                            }
                        }
                    }
                } catch (Throwable unused2) {
                }
            }
        } catch (Throwable unused3) {
            cursorA = null;
        }
        if (cursorA != null) {
            cursorA.close();
        }
        return apVar;
    }

    public void a(String str, String str2) {
        a(str, "_uuid=?", new String[]{str2});
    }

    public Cursor a(String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5, String str6) {
        try {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            if (writableDatabase == null || !writableDatabase.isOpen()) {
                return null;
            }
            return writableDatabase.query(str, strArr, str2, strArr2, str3, str4, str5, str6);
        } catch (Throwable unused) {
            return null;
        }
    }
}
