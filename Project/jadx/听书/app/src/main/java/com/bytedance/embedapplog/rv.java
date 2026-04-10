package com.bytedance.embedapplog;

import android.content.SharedPreferences;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
class rv extends gp {
    private final bv gc;

    rv(bv bvVar) {
        super(true, false, false);
        this.gc = bvVar;
    }

    @Override // com.bytedance.embedapplog.gp
    protected boolean z(JSONObject jSONObject) throws JSONException {
        SharedPreferences sharedPreferencesGc = this.gc.gc();
        String string = sharedPreferencesGc.getString("install_id", null);
        String string2 = sharedPreferencesGc.getString("device_id", null);
        String string3 = sharedPreferencesGc.getString("ssid", null);
        gb.z(jSONObject, "install_id", string);
        gb.z(jSONObject, "device_id", string2);
        gb.z(jSONObject, "ssid", string3);
        long j = 0;
        long j2 = sharedPreferencesGc.getLong("register_time", 0L);
        if ((gb.g(string) && gb.g(string2)) || j2 == 0) {
            j = j2;
        } else {
            sharedPreferencesGc.edit().putLong("register_time", 0L).apply();
        }
        jSONObject.put("register_time", j);
        return true;
    }
}
