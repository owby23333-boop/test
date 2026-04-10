package com.yuewen;

import android.text.TextUtils;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes12.dex */
public class zg {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f20766a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f20767b;

    public zg(String str, String str2) {
        this.f20767b = str;
        this.f20766a = str2;
    }

    public static zg a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        String strOptString = jSONObject.optString("sign");
        String strOptString2 = jSONObject.optString("nonce");
        if (TextUtils.isEmpty(strOptString) || TextUtils.isEmpty(strOptString2)) {
            return null;
        }
        return new zg(strOptString, strOptString2);
    }
}
