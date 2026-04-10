package com.bytedance.embedapplog;

import android.content.ContentValues;
import android.database.Cursor;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.dangdang.zframework.utils.DateUtil;
import com.xiaomi.mipush.sdk.Constants;
import com.yuewen.openapi.track.TrackConstants;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public abstract class i implements Cloneable {
    private static final SimpleDateFormat xu = new SimpleDateFormat(DateUtil.DATE_FORMAT_TYPE_2, Locale.US);
    public long bf;
    public long d;
    long e;
    public long ga;
    public int m;
    public String p;
    public String tg;
    public String v;
    public String vn;
    String wu;
    public int zk;

    public i() {
        e(0L);
    }

    public static String bf(long j) {
        return xu.format(new Date(j));
    }

    public abstract JSONObject bf();

    public final String d() {
        List<String> listE = e();
        if (listE == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder(128);
        sb.append("create table if not exists ");
        sb.append(tg());
        sb.append("(");
        for (int i = 0; i < listE.size(); i += 2) {
            sb.append(listE.get(i));
            sb.append(" ");
            sb.append(listE.get(i + 1));
            sb.append(",");
        }
        sb.delete(sb.length() - 1, sb.length());
        sb.append(")");
        return sb.toString();
    }

    public void e(long j) {
        if (j == 0) {
            j = System.currentTimeMillis();
        }
        this.bf = j;
    }

    @NonNull
    public final JSONObject ga() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("k_cls", tg());
            e(jSONObject);
        } catch (JSONException e) {
            tx.bf(e);
        }
        return jSONObject;
    }

    /* JADX INFO: renamed from: p, reason: merged with bridge method [inline-methods] */
    public i clone() {
        try {
            return (i) super.clone();
        } catch (CloneNotSupportedException e) {
            tx.bf(e);
            return null;
        }
    }

    @NonNull
    public abstract String tg();

    @NonNull
    public String toString() {
        String strTg = tg();
        if (!getClass().getSimpleName().equalsIgnoreCase(strTg)) {
            strTg = strTg + ", " + getClass().getSimpleName();
        }
        String strSubstring = this.tg;
        String str = Constants.ACCEPT_TIME_SEPARATOR_SERVER;
        if (strSubstring != null) {
            int iIndexOf = strSubstring.indexOf(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
            if (iIndexOf >= 0) {
                strSubstring = strSubstring.substring(0, iIndexOf);
            }
            str = strSubstring;
        }
        return "{" + strTg + ", " + v() + ", " + str + ", " + this.bf + com.alipay.sdk.m.y.l.d;
    }

    public String v() {
        return "sid:" + this.tg;
    }

    @NonNull
    public final JSONObject vn() {
        try {
            this.wu = bf(this.bf);
            return bf();
        } catch (JSONException e) {
            tx.bf(e);
            return null;
        }
    }

    public String zk() {
        return null;
    }

    public i bf(@NonNull JSONObject jSONObject) {
        this.bf = jSONObject.optLong("local_time_ms", 0L);
        this.e = 0L;
        this.d = 0L;
        this.zk = 0;
        this.ga = 0L;
        this.tg = null;
        this.vn = null;
        this.p = null;
        this.v = null;
        return this;
    }

    public List<String> e() {
        return Arrays.asList("_id", "integer primary key autoincrement", "local_time_ms", TypedValues.Custom.S_INT, "tea_event_index", TypedValues.Custom.S_INT, "nt", TypedValues.Custom.S_INT, "user_id", TypedValues.Custom.S_INT, "session_id", "varchar", "user_unique_id", "varchar", "ssid", "varchar", "ab_sdk_version", "varchar", TrackConstants.EVENT_TYPE, TypedValues.Custom.S_INT);
    }

    public int e(@NonNull Cursor cursor) {
        this.e = cursor.getLong(0);
        this.bf = cursor.getLong(1);
        this.d = cursor.getLong(2);
        this.zk = cursor.getInt(3);
        this.ga = cursor.getLong(4);
        this.tg = cursor.getString(5);
        this.vn = cursor.getString(6);
        this.p = cursor.getString(7);
        this.v = cursor.getString(8);
        this.m = cursor.getInt(9);
        return 10;
    }

    public final ContentValues bf(@Nullable ContentValues contentValues) {
        if (contentValues == null) {
            contentValues = new ContentValues();
        } else {
            contentValues.clear();
        }
        e(contentValues);
        return contentValues;
    }

    public void e(@NonNull ContentValues contentValues) {
        contentValues.put("local_time_ms", Long.valueOf(this.bf));
        contentValues.put("tea_event_index", Long.valueOf(this.d));
        contentValues.put("nt", Integer.valueOf(this.zk));
        contentValues.put("user_id", Long.valueOf(this.ga));
        contentValues.put("session_id", this.tg);
        contentValues.put("user_unique_id", this.vn);
        contentValues.put("ssid", this.p);
        contentValues.put("ab_sdk_version", this.v);
        contentValues.put(TrackConstants.EVENT_TYPE, Integer.valueOf(this.m));
    }

    public void e(@NonNull JSONObject jSONObject) throws JSONException {
        jSONObject.put("local_time_ms", this.bf);
    }

    public static i e(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            return yl.bf.get(jSONObject.optString("k_cls", "")).clone().bf(jSONObject);
        } catch (Throwable th) {
            tx.bf(th);
            return null;
        }
    }
}
