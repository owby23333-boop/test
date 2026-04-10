package com.umeng.message.provider;

import android.content.ContentProvider;
import android.content.ContentProviderOperation;
import android.content.ContentProviderResult;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.OperationApplicationException;
import android.content.SharedPreferences;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.webkit.WebSettings;
import com.umeng.message.common.UPLog;
import com.umeng.message.proguard.ab;
import com.umeng.message.proguard.ad;
import com.umeng.message.proguard.ae;
import com.umeng.message.proguard.r;
import java.util.ArrayList;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class MessageProvider extends ContentProvider {
    private static final String a = "MessageProvider";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final int f20554e = 1;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final int f20555f = 2;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final int f20556g = 3;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final int f20557h = 4;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final int f20558i = 5;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final int f20559j = 6;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final int f20560k = 7;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final int f20561l = 8;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final int f20562m = 9;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final int f20563n = 10;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static final int f20564o = 11;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private a f20565c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private b f20566d;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private SharedPreferences f20567p;
    private final UriMatcher b = new UriMatcher(-1);

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private String f20568q = null;

    static class a extends SQLiteOpenHelper {
        public a(Context context) {
            super(context, ad.a, (SQLiteDatabase.CursorFactory) null, 3);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            try {
                UPLog.i(MessageProvider.a, "MessageStoreHelper-->onCreate-->start");
                sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS MessageStore(_id Integer  PRIMARY KEY  AUTOINCREMENT  , MsdId Varchar  , Json Varchar  , SdkVersion Varchar  , ArrivalTime Long  , ActionType Integer )");
                sQLiteDatabase.execSQL(String.format("create table if not exists %s(id INTEGER AUTO_INCREMENT, tempkey varchar default NULL, tempvalue varchar default NULL, PRIMARY KEY(id))", ad.f20390c));
                sQLiteDatabase.execSQL(String.format("create table if not exists %s(time long, type varchar default NULL, alias varchar default NULL, exclusive int, error int, message varchar, PRIMARY KEY(time))", "MsgAlias"));
                UPLog.i(MessageProvider.a, "MessageStoreHelper-->onCreate-->end");
            } catch (Throwable th) {
                UPLog.e(MessageProvider.a, "MessageStoreHelper-->onCreate error:", th.getMessage());
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
            if (i2 <= 2) {
                try {
                    sQLiteDatabase.execSQL("drop table MsgTemp");
                } catch (Throwable th) {
                    UPLog.e(MessageProvider.a, "MessageStoreHelper-->onUpgrade error:", th.getMessage());
                    return;
                }
            }
            onCreate(sQLiteDatabase);
            UPLog.i(MessageProvider.a, "MessageStoreHelper-->onUpgrade");
        }
    }

    static class b extends SQLiteOpenHelper {
        public b(Context context) {
            super(context, ae.b, (SQLiteDatabase.CursorFactory) null, 7);
        }

        private boolean a(SQLiteDatabase sQLiteDatabase, String str) {
            boolean z2 = false;
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            try {
                Cursor cursorRawQuery = sQLiteDatabase.rawQuery(String.format("select count(*) as c from sqlite_master where type = 'table' and name = '%s'", str.trim()), null);
                if (cursorRawQuery != null) {
                    if (cursorRawQuery.moveToNext() && cursorRawQuery.getInt(0) > 0) {
                        z2 = true;
                    }
                    cursorRawQuery.close();
                }
            } catch (Throwable unused) {
            }
            return z2;
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            try {
                sQLiteDatabase.execSQL(String.format("create table if not exists MsgLogStore (MsgId varchar, ActionType Integer, Time long, %s varchar, PRIMARY KEY(MsgId, ActionType))", "pa"));
                sQLiteDatabase.execSQL("create table if not exists MsgLogIdTypeStore (MsgId varchar, MsgType varchar, PRIMARY KEY(MsgId))");
                sQLiteDatabase.execSQL("create table if not exists MsgLogStoreForAgoo (MsgId varchar, TaskId varchar, MsgStatus varchar, Time long, PRIMARY KEY(MsgId, MsgStatus))");
                sQLiteDatabase.execSQL("create table if not exists MsgLogIdTypeStoreForAgoo (MsgId varchar, TaskId varchar, MsgStatus varchar, PRIMARY KEY(MsgId))");
                sQLiteDatabase.execSQL("create table if not exists MsgConfigInfo (SerialNo integer default 1, AppLaunchAt long default 0, UpdateResponse varchar default NULL)");
                sQLiteDatabase.execSQL("create table if not exists InAppLogStore (Time long, MsgId varchar, MsgType Integer, NumDisplay Integer, NumOpenFull Integer, NumOpenTop Integer, NumOpenBottom Integer, NumClose Integer, NumDuration Integer, NumCustom Integer, PRIMARY KEY(Time))");
                UPLog.i(MessageProvider.a, "MsgLogStoreHelper-->onCreate");
            } catch (Throwable th) {
                UPLog.e(MessageProvider.a, "MsgLogStoreHelper-->onCreate error:", th.getMessage());
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
            try {
                UPLog.i(MessageProvider.a, "oldVersion:" + i2 + ",newVersion:" + i3);
                if (i2 <= 4) {
                    UPLog.i(MessageProvider.a, "MsgLogStoreHelper-->drop delete");
                    sQLiteDatabase.execSQL("drop table MsgConfigInfo");
                }
                if (i2 <= 5) {
                    UPLog.i(MessageProvider.a, "MsgLogStoreHelper-->drop MsgLogStore");
                    sQLiteDatabase.execSQL(String.format("ALTER TABLE MsgLogStore ADD COLUMN %s varchar", "pa"));
                }
                if (i2 <= 6 && a(sQLiteDatabase, ae.f20420i)) {
                    UPLog.i(MessageProvider.a, "MsgLogStoreHelper-->alter InAppLogStore");
                    sQLiteDatabase.execSQL(String.format("ALTER TABLE InAppLogStore ADD COLUMN %s Integer", ae.f20437z));
                }
                onCreate(sQLiteDatabase);
                UPLog.i(MessageProvider.a, "MsgLogStoreHelper-->onUpgrade");
            } catch (Throwable th) {
                UPLog.e(MessageProvider.a, "MsgLogStoreHelper-->onUpgrade error:", th.getMessage());
            }
        }
    }

    @Override // android.content.ContentProvider
    public ContentProviderResult[] applyBatch(ArrayList<ContentProviderOperation> arrayList) throws OperationApplicationException {
        b bVar = this.f20566d;
        if (bVar == null) {
            return super.applyBatch(arrayList);
        }
        SQLiteDatabase writableDatabase = bVar.getWritableDatabase();
        if (writableDatabase == null) {
            return super.applyBatch(arrayList);
        }
        try {
            writableDatabase.beginTransaction();
            ContentProviderResult[] contentProviderResultArrApplyBatch = super.applyBatch(arrayList);
            writableDatabase.setTransactionSuccessful();
            writableDatabase.endTransaction();
            try {
                Uri uri = null;
                for (ContentProviderOperation contentProviderOperation : arrayList) {
                    if (!contentProviderOperation.getUri().equals(uri)) {
                        uri = contentProviderOperation.getUri();
                        getContext().getContentResolver().notifyChange(contentProviderOperation.getUri(), null);
                        UPLog.i(a, "notifyChange endTransaction..uri:" + contentProviderOperation.getUri());
                    }
                }
            } catch (Throwable unused) {
            }
            return contentProviderResultArrApplyBatch;
        } catch (Throwable th) {
            writableDatabase.endTransaction();
            try {
                Uri uri2 = null;
                for (ContentProviderOperation contentProviderOperation2 : arrayList) {
                    if (!contentProviderOperation2.getUri().equals(uri2)) {
                        uri2 = contentProviderOperation2.getUri();
                        getContext().getContentResolver().notifyChange(contentProviderOperation2.getUri(), null);
                        UPLog.i(a, "notifyChange endTransaction..uri:" + contentProviderOperation2.getUri());
                    }
                }
            } catch (Throwable unused2) {
            }
            throw th;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:83:0x00cc A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // android.content.ContentProvider
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int delete(android.net.Uri r5, java.lang.String r6, java.lang.String[] r7) {
        /*
            Method dump skipped, instruction units count: 262
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.message.provider.MessageProvider.delete(android.net.Uri, java.lang.String, java.lang.String[]):int");
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        int iMatch = this.b.match(uri);
        if (iMatch == 1 || iMatch == 2 || iMatch == 3 || iMatch == 5 || iMatch == 11 || iMatch == 7 || iMatch == 8 || iMatch == 9) {
            return ab.a.f20384l;
        }
        return null;
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        SQLiteDatabase writableDatabase;
        SQLiteDatabase writableDatabase2;
        SQLiteDatabase writableDatabase3;
        SQLiteDatabase writableDatabase4;
        SQLiteDatabase writableDatabase5;
        SQLiteDatabase writableDatabase6;
        SQLiteDatabase writableDatabase7;
        SQLiteDatabase writableDatabase8;
        try {
        } catch (Throwable th) {
            UPLog.e(a, "insert() ", th.getMessage());
        }
        switch (this.b.match(uri)) {
            case 1:
                if (this.f20565c == null || (writableDatabase = this.f20565c.getWritableDatabase()) == null) {
                    return null;
                }
                long jInsertWithOnConflict = writableDatabase.insertWithOnConflict(ad.b, null, contentValues, 5);
                if (jInsertWithOnConflict > 0) {
                    Uri uriWithAppendedId = ContentUris.withAppendedId(ab.b, jInsertWithOnConflict);
                    getContext().getContentResolver().notifyChange(uriWithAppendedId, null);
                    return uriWithAppendedId;
                }
                return null;
            case 2:
                if (this.f20567p == null || contentValues == null) {
                    return null;
                }
                String asString = contentValues.getAsString("k");
                String asString2 = contentValues.getAsString("v");
                if (!TextUtils.isEmpty(asString)) {
                    this.f20567p.edit().putString(asString, asString2).apply();
                }
                return null;
            case 3:
                if (this.f20565c == null || (writableDatabase2 = this.f20565c.getWritableDatabase()) == null) {
                    return null;
                }
                long jInsertWithOnConflict2 = writableDatabase2.insertWithOnConflict("MsgAlias", null, contentValues, 5);
                if (jInsertWithOnConflict2 > 0) {
                    Uri uriWithAppendedId2 = ContentUris.withAppendedId(ab.f20367e, jInsertWithOnConflict2);
                    getContext().getContentResolver().notifyChange(uriWithAppendedId2, null);
                    return uriWithAppendedId2;
                }
                return null;
            case 4:
            default:
                return null;
            case 5:
                if (this.f20566d == null || (writableDatabase3 = this.f20566d.getWritableDatabase()) == null) {
                    return null;
                }
                long jInsertWithOnConflict3 = writableDatabase3.insertWithOnConflict(ae.f20415d, null, contentValues, 5);
                if (jInsertWithOnConflict3 > 0) {
                    Uri uriWithAppendedId3 = ContentUris.withAppendedId(ab.f20369g, jInsertWithOnConflict3);
                    getContext().getContentResolver().notifyChange(uriWithAppendedId3, null);
                    return uriWithAppendedId3;
                }
                return null;
            case 6:
                if (this.f20566d == null || (writableDatabase4 = this.f20566d.getWritableDatabase()) == null) {
                    return null;
                }
                long jInsertWithOnConflict4 = writableDatabase4.insertWithOnConflict(ae.f20416e, null, contentValues, 5);
                if (jInsertWithOnConflict4 > 0) {
                    return ContentUris.withAppendedId(ab.f20370h, jInsertWithOnConflict4);
                }
                return null;
            case 7:
                if (this.f20566d == null || (writableDatabase5 = this.f20566d.getWritableDatabase()) == null) {
                    return null;
                }
                long jInsertWithOnConflict5 = writableDatabase5.insertWithOnConflict(ae.f20417f, null, contentValues, 5);
                if (jInsertWithOnConflict5 > 0) {
                    return ContentUris.withAppendedId(ab.f20371i, jInsertWithOnConflict5);
                }
                return null;
            case 8:
                if (this.f20566d == null || (writableDatabase6 = this.f20566d.getWritableDatabase()) == null) {
                    return null;
                }
                long jInsertWithOnConflict6 = writableDatabase6.insertWithOnConflict(ae.f20418g, null, contentValues, 5);
                if (jInsertWithOnConflict6 > 0) {
                    return ContentUris.withAppendedId(ab.f20372j, jInsertWithOnConflict6);
                }
                return null;
            case 9:
                if (this.f20566d == null || (writableDatabase7 = this.f20566d.getWritableDatabase()) == null) {
                    return null;
                }
                long jInsertWithOnConflict7 = writableDatabase7.insertWithOnConflict(ae.f20419h, null, contentValues, 5);
                if (jInsertWithOnConflict7 > 0) {
                    return ContentUris.withAppendedId(ab.f20373k, jInsertWithOnConflict7);
                }
                return null;
            case 10:
                if (this.f20566d == null || (writableDatabase8 = this.f20566d.getWritableDatabase()) == null) {
                    return null;
                }
                long jInsertWithOnConflict8 = writableDatabase8.insertWithOnConflict(ae.f20420i, null, contentValues, 5);
                if (jInsertWithOnConflict8 > 0) {
                    return ContentUris.withAppendedId(ab.f20374l, jInsertWithOnConflict8);
                }
                return null;
        }
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        try {
            Context context = getContext();
            r.a(context);
            this.f20567p = context.getSharedPreferences("umeng_push", 0);
            this.f20565c = new a(context);
            this.f20566d = new b(context);
            String str = ab.a;
            this.b.addURI(str, ab.a.a, 1);
            this.b.addURI(str, ab.a.b, 2);
            this.b.addURI(str, ab.a.f20375c, 11);
            this.b.addURI(str, "MsgAlias", 3);
            this.b.addURI(str, ab.a.f20377e, 4);
            this.b.addURI(str, ab.a.f20378f, 5);
            this.b.addURI(str, ab.a.f20379g, 6);
            this.b.addURI(str, ab.a.f20380h, 7);
            this.b.addURI(str, ab.a.f20381i, 8);
            this.b.addURI(str, ab.a.f20382j, 9);
            this.b.addURI(str, ab.a.f20383k, 10);
        } catch (Throwable th) {
            UPLog.e(a, "onCreate() ", th.getMessage());
        }
        return true;
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        SQLiteDatabase readableDatabase;
        Cursor cursorQuery;
        SQLiteDatabase readableDatabase2;
        SQLiteDatabase readableDatabase3;
        SQLiteDatabase readableDatabase4;
        SQLiteDatabase readableDatabase5;
        SQLiteDatabase readableDatabase6;
        String defaultUserAgent;
        Cursor cursor = null;
        try {
            switch (this.b.match(uri)) {
                case 1:
                    return null;
                case 2:
                    if (this.f20567p == null) {
                        return null;
                    }
                    MatrixCursor matrixCursor = new MatrixCursor(new String[]{"k", "v"});
                    Map<String, ?> all = this.f20567p.getAll();
                    if (strArr2 != null && strArr2.length != 0) {
                        for (String str3 : strArr2) {
                            Object obj = all.get(str3);
                            if (obj instanceof String) {
                                matrixCursor.addRow(new Object[]{str3, obj});
                            }
                        }
                        return matrixCursor;
                    }
                    for (String str4 : all.keySet()) {
                        Object obj2 = all.get(str4);
                        if (obj2 instanceof String) {
                            matrixCursor.addRow(new Object[]{str4, obj2});
                        }
                    }
                    return matrixCursor;
                case 3:
                    if (this.f20565c == null || (readableDatabase = this.f20565c.getReadableDatabase()) == null) {
                        return null;
                    }
                    cursorQuery = readableDatabase.query("MsgAlias", strArr, str, strArr2, null, null, str2);
                    break;
                case 4:
                case 6:
                default:
                    return null;
                case 5:
                    if (this.f20566d == null || (readableDatabase2 = this.f20566d.getReadableDatabase()) == null) {
                        return null;
                    }
                    cursorQuery = readableDatabase2.query(ae.f20415d, strArr, str, strArr2, null, null, str2);
                    break;
                case 7:
                    if (this.f20566d == null || (readableDatabase3 = this.f20566d.getReadableDatabase()) == null) {
                        return null;
                    }
                    cursorQuery = readableDatabase3.query(ae.f20417f, strArr, str, strArr2, null, null, str2);
                    break;
                case 8:
                    if (this.f20566d == null || (readableDatabase4 = this.f20566d.getReadableDatabase()) == null) {
                        return null;
                    }
                    cursorQuery = readableDatabase4.query(ae.f20418g, strArr, str, strArr2, null, null, str2);
                    break;
                case 9:
                    if (this.f20566d == null || (readableDatabase5 = this.f20566d.getReadableDatabase()) == null) {
                        return null;
                    }
                    cursorQuery = readableDatabase5.query(ae.f20419h, strArr, str, strArr2, null, null, str2);
                    break;
                case 10:
                    if (this.f20566d == null || (readableDatabase6 = this.f20566d.getReadableDatabase()) == null) {
                        return null;
                    }
                    cursorQuery = readableDatabase6.query(ae.f20420i, strArr, str, strArr2, null, null, str2);
                    break;
                case 11:
                    MatrixCursor matrixCursor2 = new MatrixCursor(new String[]{"ua"});
                    if (this.f20568q != null) {
                        matrixCursor2.addRow(new Object[]{this.f20568q});
                        return matrixCursor2;
                    }
                    if (Build.VERSION.SDK_INT >= 17) {
                        try {
                            defaultUserAgent = WebSettings.getDefaultUserAgent(getContext());
                        } catch (Throwable unused) {
                            defaultUserAgent = null;
                        }
                        break;
                    } else {
                        defaultUserAgent = null;
                    }
                    if (defaultUserAgent == null) {
                        defaultUserAgent = "";
                    }
                    this.f20568q = defaultUserAgent;
                    matrixCursor2.addRow(new Object[]{defaultUserAgent});
                    return matrixCursor2;
            }
            cursor = cursorQuery;
            if (cursor != null) {
                cursor.setNotificationUri(getContext().getContentResolver(), uri);
            }
        } catch (Throwable th) {
            UPLog.e(a, "query() ", th.getMessage());
        }
        return cursor;
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        int iUpdateWithOnConflict;
        SQLiteDatabase writableDatabase;
        SQLiteDatabase writableDatabase2;
        SQLiteDatabase writableDatabase3;
        SQLiteDatabase writableDatabase4;
        try {
            int iMatch = this.b.match(uri);
            if (iMatch != 1) {
                if (iMatch == 2) {
                    if (this.f20567p != null && contentValues != null && strArr != null && strArr.length != 0) {
                        String str2 = strArr[0];
                        String asString = contentValues.getAsString("v");
                        if (!TextUtils.isEmpty(str2)) {
                            this.f20567p.edit().putString(str2, asString).apply();
                            return 1;
                        }
                    }
                    return 0;
                }
                if (iMatch != 3) {
                    if (iMatch != 9) {
                        if (iMatch != 10) {
                            iUpdateWithOnConflict = 0;
                        } else {
                            if (this.f20566d == null || (writableDatabase4 = this.f20566d.getWritableDatabase()) == null) {
                                return 0;
                            }
                            iUpdateWithOnConflict = writableDatabase4.updateWithOnConflict(ae.f20420i, contentValues, str, strArr, 5);
                        }
                    } else {
                        if (this.f20566d == null || (writableDatabase3 = this.f20566d.getWritableDatabase()) == null) {
                            return 0;
                        }
                        iUpdateWithOnConflict = writableDatabase3.updateWithOnConflict(ae.f20419h, contentValues, str, strArr, 5);
                    }
                } else {
                    if (this.f20565c == null || (writableDatabase2 = this.f20565c.getWritableDatabase()) == null) {
                        return 0;
                    }
                    iUpdateWithOnConflict = writableDatabase2.updateWithOnConflict("MsgAlias", contentValues, str, strArr, 5);
                }
            } else {
                if (this.f20565c == null || (writableDatabase = this.f20565c.getWritableDatabase()) == null) {
                    return 0;
                }
                iUpdateWithOnConflict = writableDatabase.updateWithOnConflict(ad.b, contentValues, str, strArr, 5);
            }
            if (iUpdateWithOnConflict > 0) {
                try {
                    getContext().getContentResolver().notifyChange(uri, null);
                } catch (Throwable th) {
                    th = th;
                    UPLog.e(a, "update() ", th.getMessage());
                }
            }
        } catch (Throwable th2) {
            th = th2;
            iUpdateWithOnConflict = 0;
        }
        return iUpdateWithOnConflict;
    }
}
