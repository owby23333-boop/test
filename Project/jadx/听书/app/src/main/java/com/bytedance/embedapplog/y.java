package com.bytedance.embedapplog;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Base64;
import java.io.UnsupportedEncodingException;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
class y extends gp {
    private final Context gc;

    y(Context context) {
        super(false, false);
        this.gc = context;
    }

    @Override // com.bytedance.embedapplog.gp
    protected boolean z(JSONObject jSONObject) throws JSONException {
        SharedPreferences sharedPreferencesG = com.bytedance.sdk.openadsdk.api.plugin.g.g(this.gc, "snssdk_openudid", 0);
        String strG = g(sharedPreferencesG.getString("custom_a", null));
        if (TextUtils.isEmpty(strG)) {
            strG = sharedPreferencesG.getString("clientudid", null);
        }
        if (!gb.z(strG)) {
            try {
                strG = UUID.randomUUID().toString();
                strG = z("clientudid.dat", strG);
            } catch (Exception unused) {
            }
            String strZ = z(strG);
            SharedPreferences.Editor editorEdit = sharedPreferencesG.edit();
            editorEdit.putString("custom_a", strZ);
            editorEdit.apply();
        }
        jSONObject.put("clientudid", strG);
        return true;
    }

    public static String z(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        try {
            return Base64.encodeToString(str.getBytes("UTF-8"), 0);
        } catch (UnsupportedEncodingException e) {
            com.bytedance.sdk.component.utils.wp.z(e);
            return str;
        }
    }

    public static String g(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return new String(Base64.decode(str.getBytes("UTF-8"), 0));
        } catch (UnsupportedEncodingException e) {
            com.bytedance.sdk.component.utils.wp.z(e);
            return str;
        }
    }
}
