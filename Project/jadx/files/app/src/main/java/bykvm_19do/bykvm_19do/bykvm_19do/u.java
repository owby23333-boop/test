package bykvm_19do.bykvm_19do.bykvm_19do;

import android.content.ContentValues;
import android.database.Cursor;
import com.umeng.message.proguard.ad;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public abstract class u implements Cloneable {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final SimpleDateFormat f748h = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US);
    public long a = System.currentTimeMillis();
    public long b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f749c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f750d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f751e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f752f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    String f753g;

    public static u a(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            return v.f756e.get(jSONObject.optString("k_cls", "")).clone().b(jSONObject);
        } catch (Throwable th) {
            l0.a(th);
            return null;
        }
    }

    public static String a(long j2) {
        return f748h.format(new Date(j2));
    }

    public abstract u a(Cursor cursor);

    protected abstract void a(ContentValues contentValues);

    protected abstract void a(JSONObject jSONObject);

    protected abstract String[] a();

    final ContentValues b(ContentValues contentValues) {
        if (contentValues == null) {
            contentValues = new ContentValues();
        } else {
            contentValues.clear();
        }
        a(contentValues);
        return contentValues;
    }

    protected abstract u b(JSONObject jSONObject);

    protected abstract JSONObject b();

    final String c() {
        String[] strArrA = a();
        if (strArrA == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder(128);
        sb.append("create table if not exists ");
        sb.append(d());
        sb.append(ad.f20405r);
        for (int i2 = 0; i2 < strArrA.length; i2 += 2) {
            sb.append(strArrA[i2]);
            sb.append(" ");
            sb.append(strArrA[i2 + 1]);
            sb.append(",");
        }
        sb.delete(sb.length() - 1, sb.length());
        sb.append(ad.f20406s);
        return sb.toString();
    }

    abstract String d();

    public final JSONObject e() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("k_cls", d());
            a(jSONObject);
        } catch (JSONException e2) {
            l0.a(e2);
        }
        return jSONObject;
    }

    final JSONObject f() {
        try {
            this.f753g = a(this.a);
            return b();
        } catch (JSONException e2) {
            l0.a(e2);
            return null;
        }
    }

    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public u clone() {
        try {
            return (u) super.clone();
        } catch (CloneNotSupportedException e2) {
            l0.a(e2);
            return null;
        }
    }

    protected String h() {
        return "sid:" + this.f749c;
    }

    public String toString() {
        if (!l0.a) {
            return super.toString();
        }
        String strD = d();
        if (!getClass().getSimpleName().equalsIgnoreCase(strD)) {
            strD = strD + ", " + getClass().getSimpleName();
        }
        String strSubstring = this.f749c;
        if (strSubstring != null) {
            int iIndexOf = strSubstring.indexOf("-");
            if (iIndexOf >= 0) {
                strSubstring = strSubstring.substring(0, iIndexOf);
            }
        } else {
            strSubstring = "-";
        }
        return "{" + strD + ", " + h() + ", " + strSubstring + ", " + this.a + "}";
    }
}
