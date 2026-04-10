package com.yxcorp.kuaishou.addfp.android.b;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
class c {
    boolean a;
    int b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    boolean f20609c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    String f20610d;

    c(String str) {
        this.a = true;
        if (TextUtils.isEmpty(str)) {
            this.a = false;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.b = jSONObject.optInt("errorCode", 2);
            this.f20609c = jSONObject.optBoolean("userSet", true);
            this.f20610d = jSONObject.optString("value", "KWE_OTHER");
        } catch (JSONException e2) {
            this.a = false;
            e2.printStackTrace();
        }
    }

    public String a(boolean z2) {
        if (!this.a) {
            return "KWE_OTHER";
        }
        if (z2 != this.f20609c) {
            return "KWE_NPN";
        }
        int i2 = this.b;
        return i2 != 0 ? i2 != 1 ? i2 != 2 ? i2 != 3 ? i2 != 4 ? "KWE_OTHER" : "KWE_NS" : "KWE_N" : "KWE_PE" : "KWE_PN" : !TextUtils.isEmpty(this.f20610d) ? this.f20610d : "KWE_N";
    }
}
