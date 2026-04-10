package bykvm_19do.bykvm_19do.bykvm_19do;

import android.content.SharedPreferences;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
class o extends e2 {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final j2 f736e;

    o(j2 j2Var) {
        super(true, false, false);
        this.f736e = j2Var;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_19do.e2
    protected boolean a(JSONObject jSONObject) throws JSONException {
        SharedPreferences sharedPreferencesW = this.f736e.w();
        String string = sharedPreferencesW.getString("install_id", null);
        String string2 = sharedPreferencesW.getString("device_id", null);
        String string3 = sharedPreferencesW.getString("ssid", null);
        k2.a(jSONObject, "install_id", string);
        k2.a(jSONObject, "device_id", string2);
        k2.a(jSONObject, "ssid", string3);
        long j2 = 0;
        long j3 = sharedPreferencesW.getLong("register_time", 0L);
        if ((k2.b(string) && k2.b(string2)) || j3 == 0) {
            j2 = j3;
        } else {
            sharedPreferencesW.edit().putLong("register_time", 0L).apply();
        }
        jSONObject.put("register_time", j2);
        return true;
    }
}
