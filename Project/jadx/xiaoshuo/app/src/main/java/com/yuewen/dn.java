package com.yuewen;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class dn {
    public static final dn e = new dn();
    public static final int f = 1;
    public static final int g = 2;
    public static final int h = 3;
    public static final int i = 1;
    public static final int j = 2;
    public static final int k = 3;
    public static final int l = 100;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f10215a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f10216b;
    public final String c;
    public final long d;

    public dn() {
        this.f10215a = 0;
        this.f10216b = 0;
        this.c = "";
        this.d = 0L;
    }

    public String a() {
        if (!d()) {
            return "";
        }
        String strC = c();
        return strC.substring(strC.lastIndexOf(47) + 1);
    }

    public String b() {
        String str = this.c;
        return str.substring(str.indexOf(10) + 1);
    }

    public String c() {
        String str = this.c;
        return str.substring(0, str.indexOf(10));
    }

    public boolean d() {
        return i() && c().startsWith("dangdang-cert://");
    }

    public boolean e() {
        return i() && c().startsWith("dangdang-cert://full");
    }

    public boolean equals(@Nullable Object obj) {
        if (super.equals(obj)) {
            return true;
        }
        if (obj.getClass() != getClass()) {
            return false;
        }
        dn dnVar = (dn) obj;
        if (this.f10215a == dnVar.f10215a && this.f10216b == dnVar.f10216b && this.d == dnVar.d) {
            return TextUtils.equals(this.c, dnVar.c);
        }
        return false;
    }

    public boolean f() {
        return i() && c().startsWith("dangdang-cert://trial");
    }

    public boolean g() {
        return d() ? TextUtils.isEmpty(b()) : this.f10216b < 1 && TextUtils.isEmpty(this.c);
    }

    public boolean h() {
        return !g() && this.f10216b < 100;
    }

    public boolean i() {
        return this.f10216b == 3;
    }

    public boolean j() {
        return !g() && this.f10216b >= 100;
    }

    public JSONObject k() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("devid_ver", this.f10215a);
        jSONObject.put("cert_ver", this.f10216b);
        jSONObject.put("cert", this.c);
        jSONObject.put("expiry_time", this.d);
        return jSONObject;
    }

    public String toString() {
        return "BookDrmInfo{deviceIdVersion=" + this.f10215a + ", bookCertVersion=" + this.f10216b + ", bookCert='" + this.c + "', expiryTime=" + this.d + '}';
    }

    public dn(String str) {
        int i2;
        int iOptInt = 0;
        String string = "";
        long jOptLong = 0;
        if (TextUtils.isEmpty(str)) {
            i2 = 0;
        } else {
            try {
                JSONObject jSONObject = new JSONObject(str);
                int iOptInt2 = jSONObject.optInt("devid_ver", jSONObject.optInt("version", 1));
                try {
                    iOptInt = jSONObject.optInt("cert_ver", 1);
                    string = jSONObject.getString("cert");
                    jOptLong = jSONObject.optLong("expiry_time", jSONObject.optLong("cert_limited_time", 0L));
                } catch (Throwable unused) {
                }
                int i3 = iOptInt;
                iOptInt = iOptInt2;
                i2 = i3;
            } catch (Throwable unused2) {
                i2 = 0;
            }
        }
        this.f10215a = iOptInt;
        this.f10216b = i2;
        this.c = string;
        this.d = jOptLong;
    }

    public dn(int i2, int i3, String str, long j2) {
        this.f10215a = i2;
        this.f10216b = i3;
        this.c = str;
        this.d = j2;
    }
}
