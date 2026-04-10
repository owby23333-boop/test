package com.bytedance.sdk.openadsdk.core.l;

import android.os.Build;
import com.bytedance.sdk.openadsdk.core.dl.a;
import com.bytedance.sdk.openadsdk.core.l.z.dl;
import com.bytedance.sdk.openadsdk.core.l.z.g;
import com.bytedance.sdk.openadsdk.core.uy;
import com.bytedance.sdk.openadsdk.core.zw;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class z {
    private static z z = new z();
    private volatile int g = -1;
    private volatile long dl = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private volatile long f1235a = 0;

    private z() {
    }

    public static z z() {
        return z;
    }

    public long g() {
        return this.dl;
    }

    public long dl() {
        return this.f1235a;
    }

    public void z(long j, long j2) {
        this.dl = j;
        this.f1235a = j2;
    }

    public void a() {
        JSONObject jSONObjectSd = zw.g().sd();
        if (jSONObjectSd == null) {
            this.g = 1;
        }
        if (z(jSONObjectSd)) {
            new dl().z(jSONObjectSd, this.g);
        } else if (g(jSONObjectSd)) {
            new g().z(jSONObjectSd, this.g);
        } else {
            this.g = 1;
        }
    }

    public boolean gc() {
        return this.g == 0 || this.g == 3;
    }

    public boolean z(String str) {
        String str2 = Build.MANUFACTURER;
        String str3 = Build.BRAND;
        if (str2 != null && str3 != null) {
            return str2.equalsIgnoreCase(str) || str3.equalsIgnoreCase(str);
        }
        if (str2 != null) {
            return str2.equalsIgnoreCase(str);
        }
        if (str3 != null) {
            return str3.equalsIgnoreCase(str);
        }
        return false;
    }

    public int m() {
        if (!uy.ls().gc()) {
            return 0;
        }
        if (this.g == -1) {
            int iTb = a.z().tb();
            if (iTb == -1) {
                if (zw.g().sd() == null) {
                    this.g = 1;
                } else {
                    this.g = 2;
                }
            } else {
                this.g = iTb;
            }
        }
        return this.g;
    }

    public void z(int i) {
        if (this.g != i) {
            a.z().m(i);
        }
        this.g = i;
    }

    public boolean z(JSONObject jSONObject) {
        JSONArray jSONArrayOptJSONArray;
        if (jSONObject != null && (jSONArrayOptJSONArray = jSONObject.optJSONArray("register")) != null && jSONArrayOptJSONArray.length() != 0) {
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                if (z(jSONArrayOptJSONArray.optString(i))) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean g(JSONObject jSONObject) {
        JSONArray jSONArrayOptJSONArray;
        if (jSONObject != null && (jSONArrayOptJSONArray = jSONObject.optJSONArray("callback")) != null && jSONArrayOptJSONArray.length() != 0) {
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                if (z(jSONArrayOptJSONArray.optString(i))) {
                    return true;
                }
            }
        }
        return false;
    }
}
