package com.kuaishou.weapon.p0;

import android.content.Context;
import android.text.TextUtils;
import anet.channel.strategy.dispatch.DispatchConstants;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class x {
    public JSONArray a(Context context) {
        try {
            JSONArray jSONArray = new JSONArray();
            String strD = bg.d();
            if (!TextUtils.isEmpty(strD) && !strD.startsWith("RISK")) {
                JSONArray jSONArray2 = new JSONArray(strD);
                for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("1", jSONArray2.getJSONObject(i2).getString(DispatchConstants.APP_NAME));
                    jSONObject.put("2", jSONArray2.getJSONObject(i2).getString("pkgName"));
                    jSONObject.put("3", jSONArray2.getJSONObject(i2).getString("appVersion"));
                    jSONObject.put("5", jSONArray2.getJSONObject(i2).getString("system_app"));
                    jSONObject.put("6", jSONArray2.getJSONObject(i2).getString("firstInstallTime"));
                    jSONObject.put("7", jSONArray2.getJSONObject(i2).getString("lastUpdateTime"));
                    jSONArray.put(jSONObject);
                }
                return jSONArray;
            }
        } catch (Exception unused) {
        }
        return null;
    }
}
