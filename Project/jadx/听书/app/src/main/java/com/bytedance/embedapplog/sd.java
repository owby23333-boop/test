package com.bytedance.embedapplog;

import android.content.ContentValues;
import android.database.Cursor;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.umeng.analytics.pro.ar;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public abstract class sd implements Cloneable {
    private static final SimpleDateFormat wp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f299a;
    public long dl;
    public String e;
    public int fo;
    public long g;
    public long gc;
    public String gz;
    String kb;
    public String m;
    public int uy;
    long z;

    abstract String a();

    protected String fo() {
        return null;
    }

    protected abstract JSONObject g();

    public sd() {
        z(0L);
    }

    public void z(long j) {
        if (j == 0) {
            j = System.currentTimeMillis();
        }
        this.g = j;
    }

    protected List<String> z() {
        return Arrays.asList(ar.d, "integer primary key autoincrement", "local_time_ms", TypedValues.Custom.S_INT, "tea_event_index", TypedValues.Custom.S_INT, "nt", TypedValues.Custom.S_INT, "user_id", TypedValues.Custom.S_INT, "session_id", "varchar", "user_unique_id", "varchar", "ssid", "varchar", "ab_sdk_version", "varchar", "event_type", TypedValues.Custom.S_INT);
    }

    public int z(Cursor cursor) {
        this.z = cursor.getLong(0);
        this.g = cursor.getLong(1);
        this.dl = cursor.getLong(2);
        this.fo = cursor.getInt(3);
        this.gc = cursor.getLong(4);
        this.f299a = cursor.getString(5);
        this.m = cursor.getString(6);
        this.e = cursor.getString(7);
        this.gz = cursor.getString(8);
        this.uy = cursor.getInt(9);
        return 10;
    }

    protected void z(ContentValues contentValues) {
        contentValues.put("local_time_ms", Long.valueOf(this.g));
        contentValues.put("tea_event_index", Long.valueOf(this.dl));
        contentValues.put("nt", Integer.valueOf(this.fo));
        contentValues.put("user_id", Long.valueOf(this.gc));
        contentValues.put("session_id", this.f299a);
        contentValues.put("user_unique_id", this.m);
        contentValues.put("ssid", this.e);
        contentValues.put("ab_sdk_version", this.gz);
        contentValues.put("event_type", Integer.valueOf(this.uy));
    }

    public static String g(long j) {
        return wp.format(new Date(j));
    }

    protected void z(JSONObject jSONObject) throws JSONException {
        jSONObject.put("local_time_ms", this.g);
    }

    protected sd g(JSONObject jSONObject) {
        this.g = jSONObject.optLong("local_time_ms", 0L);
        this.z = 0L;
        this.dl = 0L;
        this.fo = 0;
        this.gc = 0L;
        this.f299a = null;
        this.m = null;
        this.e = null;
        this.gz = null;
        return this;
    }

    final ContentValues g(ContentValues contentValues) {
        if (contentValues == null) {
            contentValues = new ContentValues();
        } else {
            contentValues.clear();
        }
        z(contentValues);
        return contentValues;
    }

    final String dl() {
        List<String> listZ = z();
        if (listZ == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder(128);
        sb.append("create table if not exists ").append(a()).append("(");
        for (int i = 0; i < listZ.size(); i += 2) {
            sb.append(listZ.get(i)).append(" ").append(listZ.get(i + 1)).append(",");
        }
        sb.delete(sb.length() - 1, sb.length());
        sb.append(")");
        return sb.toString();
    }

    public final JSONObject gc() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("k_cls", a());
            z(jSONObject);
        } catch (JSONException e) {
            cb.g(e);
        }
        return jSONObject;
    }

    public final JSONObject m() {
        try {
            this.kb = g(this.g);
            return g();
        } catch (JSONException e) {
            cb.g(e);
            return null;
        }
    }

    public static sd z(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            return tf.g.get(jSONObject.optString("k_cls", "")).clone().g(jSONObject);
        } catch (Throwable th) {
            cb.g(th);
            return null;
        }
    }

    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public sd clone() {
        try {
            return (sd) super.clone();
        } catch (CloneNotSupportedException e) {
            cb.g(e);
            return null;
        }
    }

    public String toString() {
        String strA = a();
        if (!getClass().getSimpleName().equalsIgnoreCase(strA)) {
            strA = strA + ", " + getClass().getSimpleName();
        }
        String strSubstring = this.f299a;
        String str = "-";
        if (strSubstring != null) {
            int iIndexOf = strSubstring.indexOf("-");
            if (iIndexOf >= 0) {
                strSubstring = strSubstring.substring(0, iIndexOf);
            }
            str = strSubstring;
        }
        return "{" + strA + ", " + gz() + ", " + str + ", " + this.g + "}";
    }

    protected String gz() {
        return "sid:" + this.f299a;
    }
}
