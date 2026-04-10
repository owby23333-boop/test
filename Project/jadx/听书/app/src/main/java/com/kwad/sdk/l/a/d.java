package com.kwad.sdk.l.a;

import android.content.Context;
import android.provider.Settings;
import com.kwad.sdk.utils.aa;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class d extends com.kwad.sdk.core.response.a.a implements com.kwad.sdk.core.b {
    public int aWI = 0;
    public int aWJ = 0;
    public int aWK = 0;
    public int aWL = 0;
    public int aWM = 0;
    public int aWN = 0;
    public int aWO = 0;

    private static int bZ(boolean z) {
        return z ? 1 : 2;
    }

    public d(Context context) {
        if (context != null) {
            try {
                bW(Settings.Secure.getInt(context.getContentResolver(), "adb_enabled", 0) > 0);
            } catch (Throwable unused) {
            }
        }
    }

    public final void bT(boolean z) {
        this.aWI = bZ(z);
    }

    public final void bU(boolean z) {
        this.aWJ = bZ(z);
    }

    public final void bV(boolean z) {
        this.aWK = bZ(z);
    }

    private void bW(boolean z) {
        this.aWM = bZ(z);
    }

    public final void bX(boolean z) {
        this.aWN = bZ(z);
    }

    public final void bY(boolean z) {
        this.aWO = bZ(z);
    }

    private void a(d dVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        dVar.aWI = jSONObject.optInt("isRoot");
        dVar.aWJ = jSONObject.optInt("isXPosed");
        dVar.aWK = jSONObject.optInt("isFrameworkHooked");
        dVar.aWL = jSONObject.optInt("isVirtual");
        dVar.aWM = jSONObject.optInt("isAdbEnabled");
        dVar.aWN = jSONObject.optInt("isEmulator");
        dVar.aWO = jSONObject.optInt("isGroupControl");
        super.afterParseJson(jSONObject);
    }

    private static JSONObject b(d dVar, JSONObject jSONObject) {
        aa.putValue(jSONObject, "isRoot", dVar.aWI);
        aa.putValue(jSONObject, "isXPosed", dVar.aWJ);
        aa.putValue(jSONObject, "isFrameworkHooked", dVar.aWK);
        aa.putValue(jSONObject, "isVirtual", dVar.aWL);
        aa.putValue(jSONObject, "isAdbEnabled", dVar.aWM);
        aa.putValue(jSONObject, "isEmulator", dVar.aWN);
        aa.putValue(jSONObject, "isGroupControl", dVar.aWO);
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.response.a.a, com.kwad.sdk.core.b
    public final void parseJson(JSONObject jSONObject) {
        a(this, jSONObject);
        afterParseJson(jSONObject);
    }

    @Override // com.kwad.sdk.core.response.a.a, com.kwad.sdk.core.b
    public final JSONObject toJson() {
        JSONObject jSONObjectB = b(this, new JSONObject());
        afterToJson(jSONObjectB);
        return jSONObjectB;
    }
}
