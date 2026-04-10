package com.umeng.message.proguard;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.text.TextUtils;
import com.umeng.message.common.UPLog;
import java.util.ArrayList;

/* JADX INFO: compiled from: MsgLogStore.java */
/* JADX INFO: loaded from: classes3.dex */
public class ae {
    private static final String A = "MsgLogStore";
    private static ae B = null;
    private static final String D = " Asc ";
    private static final String E = " Desc ";
    public static final String a = " And ";
    public static final String b = "MsgLogStore.db";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f20414c = 7;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f20415d = "MsgLogStore";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f20416e = "MsgLogIdTypeStore";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f20417f = "MsgLogStoreForAgoo";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String f20418g = "MsgLogIdTypeStoreForAgoo";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final String f20419h = "MsgConfigInfo";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final String f20420i = "InAppLogStore";

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final String f20421j = "MsgId";

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final String f20422k = "MsgType";

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final String f20423l = "ActionType";

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final String f20424m = "pa";

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final String f20425n = "Time";

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final String f20426o = "TaskId";

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final String f20427p = "MsgStatus";

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final String f20428q = "SerialNo";

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final String f20429r = "AppLaunchAt";

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final String f20430s = "UpdateResponse";

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final String f20431t = "NumDisplay";

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final String f20432u = "NumOpenFull";

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final String f20433v = "NumOpenTop";

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final String f20434w = "NumOpenBottom";

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final String f20435x = "NumClose";

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final String f20436y = "NumDuration";

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final String f20437z = "NumCustom";
    private final Context C;

    /* JADX INFO: compiled from: MsgLogStore.java */
    public static class b {
        public String a;
        public String b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f20440c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public long f20441d;

        public b(Cursor cursor) {
            this.a = cursor.getString(cursor.getColumnIndex(ae.f20421j));
            this.b = cursor.getString(cursor.getColumnIndex(ae.f20426o));
            this.f20440c = cursor.getString(cursor.getColumnIndex(ae.f20427p));
            this.f20441d = cursor.getLong(cursor.getColumnIndex(ae.f20425n));
        }
    }

    /* JADX INFO: compiled from: MsgLogStore.java */
    public static class c {
        public String a;
        public String b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f20442c;

        public c(String str, String str2, String str3) {
            this.a = str;
            this.b = str2;
            this.f20442c = str3;
        }

        public ContentValues a() {
            ContentValues contentValues = new ContentValues();
            contentValues.put(ae.f20421j, this.a);
            contentValues.put(ae.f20426o, this.b);
            contentValues.put(ae.f20427p, this.f20442c);
            return contentValues;
        }
    }

    private ae(Context context) {
        this.C = context.getApplicationContext();
    }

    public static ae a(Context context) {
        if (B == null) {
            B = new ae(context);
        }
        return B;
    }

    public ArrayList<b> b() {
        ArrayList<b> arrayList = new ArrayList<>();
        Cursor cursorQuery = this.C.getContentResolver().query(ab.f20371i, null, null, null, "Time Asc ");
        if (cursorQuery != null) {
            for (boolean zMoveToFirst = cursorQuery.moveToFirst(); zMoveToFirst; zMoveToFirst = cursorQuery.moveToNext()) {
                arrayList.add(new b(cursorQuery));
            }
            cursorQuery.close();
        }
        return arrayList;
    }

    public long c() {
        try {
            Cursor cursorQuery = this.C.getContentResolver().query(ab.f20373k, new String[]{f20429r}, null, null, null);
            if (cursorQuery == null) {
                return 0L;
            }
            long j2 = cursorQuery.moveToFirst() ? cursorQuery.getLong(cursorQuery.getColumnIndex(f20429r)) : 0L;
            cursorQuery.close();
            UPLog.d("MsgLogStore", "appLaunchAt=" + j2);
            return j2;
        } catch (Throwable th) {
            UPLog.d("MsgLogStore", "get appLaunchAt" + th.getMessage());
            return 0L;
        }
    }

    public boolean a(String str, int i2, long j2, String str2) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (str2 == null) {
            str2 = "";
        }
        return this.C.getContentResolver().insert(ab.f20369g, new a(str, i2, j2, str2).a()) != null;
    }

    /* JADX INFO: compiled from: MsgLogStore.java */
    public static class a {
        public String a;
        public long b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f20438c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f20439d;

        public a(String str, int i2, long j2, String str2) {
            this.a = str;
            this.f20438c = i2;
            this.b = j2;
            this.f20439d = str2;
        }

        public ContentValues a() {
            ContentValues contentValues = new ContentValues();
            contentValues.put(ae.f20421j, this.a);
            contentValues.put(ae.f20425n, Long.valueOf(this.b));
            contentValues.put("ActionType", Integer.valueOf(this.f20438c));
            contentValues.put("pa", this.f20439d);
            return contentValues;
        }

        public a(Cursor cursor) {
            this.a = cursor.getString(cursor.getColumnIndex(ae.f20421j));
            this.b = cursor.getLong(cursor.getColumnIndex(ae.f20425n));
            this.f20438c = cursor.getInt(cursor.getColumnIndex("ActionType"));
            this.f20439d = cursor.getString(cursor.getColumnIndex("pa"));
        }
    }

    public ArrayList<a> a() {
        ArrayList<a> arrayList = new ArrayList<>();
        Cursor cursorQuery = this.C.getContentResolver().query(ab.f20369g, null, null, null, "Time Asc ");
        if (cursorQuery == null) {
            return arrayList;
        }
        for (boolean zMoveToFirst = cursorQuery.moveToFirst(); zMoveToFirst; zMoveToFirst = cursorQuery.moveToNext()) {
            arrayList.add(new a(cursorQuery));
        }
        cursorQuery.close();
        return arrayList;
    }

    public boolean a(String str, String str2) {
        return !TextUtils.isEmpty(str) && this.C.getContentResolver().delete(ab.f20371i, "MsgId=? And MsgStatus=?", new String[]{str, str2}) == 1;
    }

    public boolean a(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return this.C.getContentResolver().insert(ab.f20372j, new c(str, str2, str3).a()) != null;
    }

    public boolean a(String str) {
        return !TextUtils.isEmpty(str) && this.C.getContentResolver().delete(ab.f20372j, "MsgId=?", new String[]{str}) == 1;
    }

    public void a(long j2) {
        int count;
        try {
            Cursor cursorQuery = this.C.getContentResolver().query(ab.f20373k, new String[]{f20429r}, null, null, null);
            if (cursorQuery != null) {
                count = cursorQuery.getCount();
                cursorQuery.close();
            } else {
                count = 0;
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put(f20429r, j2 + "");
            if (count > 0) {
                this.C.getContentResolver().update(ab.f20373k, contentValues, null, null);
            } else {
                this.C.getContentResolver().insert(ab.f20373k, contentValues);
            }
        } catch (Throwable th) {
            UPLog.d("MsgLogStore", "set appLaunchAt" + th.getMessage());
        }
    }
}
