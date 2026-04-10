package com.yuewen;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.text.TextUtils;
import java.io.File;
import java.util.List;
import java.util.UUID;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes8.dex */
public final class k implements i {
    public static volatile k e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final File f13304a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ContentResolver f13305b;
    public final Context c;
    public final j d;

    public k(Context context, String str) {
        this.c = context;
        this.f13305b = context.getContentResolver();
        this.f13304a = context.getDatabasePath("ywreportdata");
        this.d = j.a(str);
    }

    public static k c() {
        if (e != null) {
            return e;
        }
        throw new IllegalStateException("The static method getInstance(Context context, String packageName) should be called before calling getInstance()");
    }

    @Override // com.yuewen.i
    public int a(String str) {
        Cursor cursorQuery = null;
        try {
            try {
                this.f13305b.delete(this.d.a(), "_id <= ?", new String[]{str});
                cursorQuery = this.f13305b.query(this.d.a(), null, null, null, null);
                count = cursorQuery != null ? cursorQuery.getCount() : -1;
                p.a(cursorQuery);
            } catch (Exception e2) {
                h.a(e2);
                p.a(cursorQuery);
            }
            return count;
        } catch (Throwable th) {
            p.a(cursorQuery);
            throw th;
        }
    }

    public final boolean b() {
        return this.f13304a.exists() && Math.max(this.f13304a.getUsableSpace(), b.g().e()) < this.f13304a.length();
    }

    @Override // com.yuewen.i
    public int a(List<JSONObject> list) {
        int count = -1;
        Cursor cursorQuery = null;
        try {
            try {
                if (b()) {
                    h.a("ReportDbDao", "There is not enough space left on the device to store reports, so will delete some old reports");
                    String[] strArrA = a(100);
                    if (strArrA == null) {
                        p.a(null);
                        return -2;
                    }
                    count = a(strArrA[0]);
                    if (count <= 0) {
                        p.a(null);
                        return -2;
                    }
                }
                ContentValues[] contentValuesArr = new ContentValues[list.size()];
                int i = 0;
                for (JSONObject jSONObject : list) {
                    ContentValues contentValues = new ContentValues();
                    String string = (String) jSONObject.opt(eq2.n);
                    if (TextUtils.isEmpty(string)) {
                        string = UUID.randomUUID().toString();
                    }
                    contentValues.put("message_id", string);
                    contentValues.put("data", jSONObject.toString() + "\t" + jSONObject.toString().hashCode());
                    contentValues.put("created_at", Long.valueOf(System.currentTimeMillis()));
                    contentValuesArr[i] = contentValues;
                    i++;
                }
                this.f13305b.bulkInsert(this.d.a(), contentValuesArr);
                cursorQuery = this.f13305b.query(this.d.a(), null, null, null, null);
                if (cursorQuery != null) {
                    count = cursorQuery.getCount();
                }
                p.a(cursorQuery);
            } catch (Exception e2) {
                h.a(e2);
                p.a(cursorQuery);
            }
            return count;
        } catch (Throwable th) {
            p.a(cursorQuery);
            throw th;
        }
    }

    @Override // com.yuewen.i
    public int a(JSONObject jSONObject) {
        int count = -1;
        Cursor cursorQuery = null;
        try {
            try {
                if (b()) {
                    String[] strArrA = a(50);
                    if (strArrA == null) {
                        p.a(null);
                        return -2;
                    }
                    count = a(strArrA[0]);
                    if (count <= 0) {
                        p.a(null);
                        return -2;
                    }
                }
                String string = (String) jSONObject.opt(eq2.n);
                if (TextUtils.isEmpty(string)) {
                    string = UUID.randomUUID().toString();
                }
                ContentValues contentValues = new ContentValues();
                contentValues.put("message_id", string);
                contentValues.put("data", jSONObject.toString() + "\t" + jSONObject.toString().hashCode());
                contentValues.put("created_at", Long.valueOf(System.currentTimeMillis()));
                this.f13305b.insert(this.d.a(), contentValues);
                cursorQuery = this.f13305b.query(this.d.a(), null, null, null, null);
                if (cursorQuery != null) {
                    count = cursorQuery.getCount();
                }
                p.a(cursorQuery);
            } catch (Exception e2) {
                h.a(e2);
                p.a(cursorQuery);
            }
            return count;
        } catch (Throwable th) {
            p.a(cursorQuery);
            throw th;
        }
    }

    public static k a(Context context, String str) {
        if (e == null) {
            synchronized (k.class) {
                if (e == null) {
                    e = new k(context, str);
                }
            }
        }
        return e;
    }

    @Override // com.yuewen.i
    public void a() {
        try {
            this.f13305b.delete(this.d.a(), null, new String[0]);
        } catch (Exception e2) {
            h.a(e2);
        }
    }

    @Override // com.yuewen.i
    public String[] a(int i) throws Throwable {
        Cursor cursorQuery;
        String string;
        String string2;
        Cursor cursor = null;
        try {
            cursorQuery = this.f13305b.query(this.d.a(), null, null, null, "created_at ASC LIMIT " + String.valueOf(i));
            if (cursorQuery != null) {
                try {
                    try {
                        StringBuilder sb = new StringBuilder();
                        sb.append("[");
                        String str = ",";
                        string2 = null;
                        while (cursorQuery.moveToNext()) {
                            if (cursorQuery.isLast()) {
                                string2 = cursorQuery.getString(cursorQuery.getColumnIndex("_id"));
                                str = "]";
                            }
                            try {
                                String string3 = cursorQuery.getString(cursorQuery.getColumnIndex("data"));
                                if (!TextUtils.isEmpty(string3)) {
                                    int iLastIndexOf = string3.lastIndexOf("\t");
                                    if (iLastIndexOf > -1) {
                                        String strReplaceFirst = string3.substring(iLastIndexOf).replaceFirst("\t", "");
                                        string3 = string3.substring(0, iLastIndexOf);
                                        if (!TextUtils.isEmpty(string3) && !TextUtils.isEmpty(strReplaceFirst) && strReplaceFirst.equals(String.valueOf(string3.hashCode()))) {
                                        }
                                    }
                                    sb.append((CharSequence) string3, 0, string3.length() - 1);
                                    sb.append(",\"_flush_time\":");
                                    sb.append(System.currentTimeMillis());
                                    sb.append(com.alipay.sdk.m.y.l.d);
                                    sb.append(str);
                                }
                            } catch (Exception e2) {
                                h.a(e2);
                            }
                        }
                        string = sb.toString();
                    } catch (Throwable th) {
                        th = th;
                        cursor = cursorQuery;
                        p.a(cursor);
                        throw th;
                    }
                } catch (SQLiteException e3) {
                    e = e3;
                    h.a("ReportDbDao", "Could not pull records for YWReports out of database reports with error: " + e.getMessage());
                    p.a(cursorQuery);
                    string = null;
                    string2 = null;
                }
            } else {
                string = null;
                string2 = null;
            }
            p.a(cursorQuery);
        } catch (SQLiteException e4) {
            e = e4;
            cursorQuery = null;
        } catch (Throwable th2) {
            th = th2;
            p.a(cursor);
            throw th;
        }
        if (string2 != null) {
            return new String[]{string2, string};
        }
        return null;
    }
}
