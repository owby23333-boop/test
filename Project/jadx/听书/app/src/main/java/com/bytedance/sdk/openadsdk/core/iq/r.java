package com.bytedance.sdk.openadsdk.core.iq;

import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f1191a;
    private String dl;
    private String g;
    private String gc;
    private String m;
    private String z;

    public r(String str, String str2, String str3, String str4) {
        this.z = str3;
        this.g = str2;
        this.f1191a = str;
        this.dl = str4;
    }

    public void z(String str, String str2, String str3, String str4) {
        this.z = str3;
        this.g = str2;
        this.f1191a = str;
        this.dl = str4;
    }

    public String z() {
        return this.g;
    }

    public String g() {
        return this.z;
    }

    public String toString() {
        JSONObject jSONObjectDl = dl();
        return jSONObjectDl.length() > 0 ? jSONObjectDl.toString() : "";
    }

    public JSONObject dl() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("tk", this.z).put("vd", this.f1191a).put("cr", this.dl).put(NotificationCompat.CATEGORY_ERROR, this.g);
            if (!TextUtils.isEmpty(this.dl) && this.dl.equals("2")) {
                if (!TextUtils.isEmpty(this.gc)) {
                    jSONObject.put("i6", this.gc);
                }
                if (!TextUtils.isEmpty(this.m)) {
                    jSONObject.put("prov", this.m);
                }
            }
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    public void z(String str) {
        this.gc = str;
    }

    public void g(String str) {
        this.m = str;
    }
}
