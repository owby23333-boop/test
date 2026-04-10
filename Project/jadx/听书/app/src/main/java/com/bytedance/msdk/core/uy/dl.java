package com.bytedance.msdk.core.uy;

import android.text.TextUtils;
import com.umeng.umcrash.UMCrash;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class dl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f405a;
    private String dl;
    private double e;
    private String g;
    private String gc;
    private double m;
    private String z;

    public dl(String str, String str2, String str3, int i, String str4, double d, double d2) {
        this.z = str;
        this.g = str2;
        this.dl = str3;
        this.f405a = i;
        this.gc = str4;
        this.m = d;
        this.e = d2;
    }

    public String z() {
        return this.g;
    }

    public String g() {
        return this.dl;
    }

    public int dl() {
        return this.f405a;
    }

    public String a() {
        return this.gc;
    }

    public double gc() {
        return this.m;
    }

    public double m() {
        return this.e;
    }

    public static dl z(String str, JSONObject jSONObject) {
        if (TextUtils.isEmpty(str) || jSONObject == null) {
            return null;
        }
        return new dl(str, jSONObject.optString("label_name"), jSONObject.optString(UMCrash.SP_KEY_TIMESTAMP), jSONObject.optInt("label_id"), jSONObject.optString("label_version"), jSONObject.optDouble("upper_bound"), jSONObject.optDouble("lower_bound"));
    }
}
