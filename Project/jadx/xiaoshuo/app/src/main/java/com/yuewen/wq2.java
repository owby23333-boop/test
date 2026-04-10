package com.yuewen;

import android.text.TextUtils;
import fm.qingting.qtsdk.QTConstant;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class wq2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f19586a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f19587b;
    public final String c;
    public final int d;

    public wq2(String str, String str2, int i, String str3) {
        this.f19586a = str;
        this.f19587b = str2;
        this.c = str3;
        this.d = i;
    }

    public static wq2 a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            return new wq2(jSONObject.optString("access_token"), jSONObject.optString(QTConstant.REFRESH_TOKEN), jSONObject.optInt("expire"), jSONObject.getString("qt_user_id"));
        } catch (JSONException unused) {
            return null;
        }
    }

    public String toString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("access_token", this.f19586a);
            jSONObject.put(QTConstant.REFRESH_TOKEN, this.f19587b);
            jSONObject.put("expire", this.d);
            jSONObject.put("qt_user_id", this.c);
        } catch (JSONException unused) {
        }
        return jSONObject.toString();
    }
}
