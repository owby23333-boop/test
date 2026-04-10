package com.kwad.sdk.g.kwai;

import android.content.Context;
import android.provider.Settings;
import androidx.annotation.Nullable;
import com.kwad.sdk.utils.s;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class d extends com.kwad.sdk.core.response.kwai.a implements com.kwad.sdk.core.b {
    public int awW = 0;
    public int awX = 0;
    public int awY = 0;
    public int awZ = 0;
    public int axa = 0;
    public int axb = 0;
    public int axc = 0;

    public d(Context context) {
        if (context != null) {
            bo(Settings.Secure.getInt(context.getContentResolver(), "adb_enabled", 0) > 0);
        }
    }

    private void a(d dVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        dVar.awW = jSONObject.optInt("isRoot");
        dVar.awX = jSONObject.optInt("isXPosed");
        dVar.awY = jSONObject.optInt("isFrameworkHooked");
        dVar.awZ = jSONObject.optInt("isVirtual");
        dVar.axa = jSONObject.optInt("isAdbEnabled");
        dVar.axb = jSONObject.optInt("isEmulator");
        dVar.axc = jSONObject.optInt("isGroupControl");
        super.afterParseJson(jSONObject);
    }

    private static JSONObject b(d dVar, JSONObject jSONObject) {
        s.putValue(jSONObject, "isRoot", dVar.awW);
        s.putValue(jSONObject, "isXPosed", dVar.awX);
        s.putValue(jSONObject, "isFrameworkHooked", dVar.awY);
        s.putValue(jSONObject, "isVirtual", dVar.awZ);
        s.putValue(jSONObject, "isAdbEnabled", dVar.axa);
        s.putValue(jSONObject, "isEmulator", dVar.axb);
        s.putValue(jSONObject, "isGroupControl", dVar.axc);
        return jSONObject;
    }

    private void bo(boolean z2) {
        this.axa = br(z2);
    }

    private static int br(boolean z2) {
        return z2 ? 1 : 2;
    }

    public final void bl(boolean z2) {
        this.awW = br(z2);
    }

    public final void bm(boolean z2) {
        this.awX = br(z2);
    }

    public final void bn(boolean z2) {
        this.awY = br(z2);
    }

    public final void bp(boolean z2) {
        this.axb = br(z2);
    }

    public final void bq(boolean z2) {
        this.axc = br(z2);
    }

    @Override // com.kwad.sdk.core.response.kwai.a, com.kwad.sdk.core.b
    public final void parseJson(@Nullable JSONObject jSONObject) {
        a(this, jSONObject);
        afterParseJson(jSONObject);
    }

    @Override // com.kwad.sdk.core.response.kwai.a, com.kwad.sdk.core.b
    public final JSONObject toJson() {
        JSONObject jSONObjectB = b(this, new JSONObject());
        afterToJson(jSONObjectB);
        return jSONObjectB;
    }
}
