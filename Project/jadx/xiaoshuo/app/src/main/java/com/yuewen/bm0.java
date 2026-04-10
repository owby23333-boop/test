package com.yuewen;

import android.text.TextUtils;
import com.dangdang.reader.domain.GroupType;
import com.duokan.account.b;
import com.duokan.reader.domain.account.User;
import com.xiaomi.mipush.sdk.PushMessageHelper;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class bm0 {
    public static final int h = 5;
    public static final int i = 6;
    public static final int j = 10;
    public static final int k = 11;
    public static final int l = 13;
    public static final int m = 14;
    public static final int n = 15;
    public static final int o = 17;
    public static final int p = 19;
    public static final int q = 18;
    public static final int r = 27;
    public static final int s = 28;
    public static final int[] t = {5, 10, 13, 17, 19, 18, 27, 28};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f9151a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f9152b;
    public final String c;
    public final String d;
    public final long e;
    public final long f;
    public final a g;

    public static abstract class a {
        public abstract long a();

        public abstract String b();

        public abstract User c();

        public abstract void d(JSONObject jSONObject);
    }

    public interface b {
        a a(int i, JSONObject jSONObject) throws JSONException;
    }

    public bm0(String str, int i2, String str2, String str3, long j2, long j3, a aVar) {
        this.f9151a = str;
        this.f9152b = i2;
        this.c = str2;
        this.d = str3;
        this.e = j2;
        this.f = j3;
        this.g = aVar;
    }

    public static bm0 a(JSONObject jSONObject, b bVar) throws JSONException {
        int i2 = jSONObject.getInt(PushMessageHelper.MESSAGE_TYPE);
        return new bm0(jSONObject.getString("message_id"), i2, jSONObject.optString("title", ""), jSONObject.optString("message", ""), jSONObject.optLong(GroupType.TypeColumn.CREATE_TIME), jSONObject.optLong("start_time"), (!jSONObject.has(b.c.a.e) || TextUtils.isEmpty(jSONObject.getString(b.c.a.e))) ? new cm0() : bVar.a(i2, jSONObject.getJSONObject(b.c.a.e)));
    }

    public long b() {
        long jA = this.g.a();
        return jA == 0 ? this.e : jA;
    }

    public String c() {
        String strB = this.g.b();
        return TextUtils.isEmpty(strB) ? this.d : strB;
    }

    public User d() {
        return this.g.c();
    }

    public boolean e() {
        for (int i2 : t) {
            if (this.f9152b == i2) {
                return true;
            }
        }
        return false;
    }

    public void f(JSONObject jSONObject) {
        try {
            this.g.d(jSONObject.getJSONObject(b.c.a.e));
        } catch (JSONException unused) {
        }
    }
}
