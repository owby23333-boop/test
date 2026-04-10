package com.kwad.sdk.liteapi.report;

import android.os.Build;
import com.kwad.sdk.liteapi.LiteApiLogger;
import com.kwad.sdk.liteapi.LiteOAIDHelper;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
final class b {
    public String LM;
    public String LN;
    public String LO;
    public String aCl;
    public String aIl;
    public int adi;
    public int adk;
    public String adl;

    b() {
    }

    public static b MV() {
        b bVar = new b();
        try {
            bVar.aCl = LiteOAIDHelper.obtainCurrent();
            bVar.adk = Build.VERSION.SDK_INT;
            bVar.LO = Build.VERSION.RELEASE;
            bVar.adi = 1;
            bVar.adl = Locale.getDefault().getLanguage();
            bVar.aIl = Build.MANUFACTURER;
            bVar.LM = Build.MODEL;
            bVar.LN = Build.BRAND;
        } catch (Throwable unused) {
        }
        return bVar;
    }

    public final JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("oaid", this.aCl);
        } catch (JSONException e) {
            LiteApiLogger.printStackTrace(e);
        }
        return jSONObject;
    }
}
