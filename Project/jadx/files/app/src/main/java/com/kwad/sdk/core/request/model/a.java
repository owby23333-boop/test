package com.kwad.sdk.core.request.model;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.bd;
import com.kwad.sdk.utils.k;
import com.kwad.sdk.utils.s;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class a implements com.kwad.sdk.core.b {
    private static JSONObject akx;
    private String aky;
    private String appId;
    private String name;
    private String packageName;
    private String version;

    private static boolean B(@Nullable JSONObject jSONObject) {
        if (jSONObject == null) {
            return false;
        }
        String strOptString = jSONObject.optString(com.anythink.expressad.videocommon.e.b.f12231u);
        String strOptString2 = jSONObject.optString("name");
        return !TextUtils.isEmpty(strOptString2) && !TextUtils.isEmpty(strOptString) && strOptString.equals(((com.kwad.sdk.service.kwai.e) ServiceProvider.get(com.kwad.sdk.service.kwai.e.class)).getAppId()) && strOptString2.equals(((com.kwad.sdk.service.kwai.e) ServiceProvider.get(com.kwad.sdk.service.kwai.e.class)).getAppName());
    }

    public static JSONObject xA() {
        if (!B(akx)) {
            akx = xB().toJson();
        }
        return akx;
    }

    private static a xB() {
        a aVar = new a();
        com.kwad.sdk.service.kwai.e eVar = (com.kwad.sdk.service.kwai.e) ServiceProvider.get(com.kwad.sdk.service.kwai.e.class);
        aVar.appId = eVar.getAppId();
        aVar.name = eVar.getAppName();
        Context context = eVar.getContext();
        if (context != null) {
            aVar.packageName = context.getPackageName();
            aVar.version = k.bS(context);
        }
        aVar.aky = com.kwad.sdk.utils.e.bI(context);
        if (!TextUtils.isEmpty(bd.getAppId())) {
            aVar.appId = bd.getAppId();
        }
        if (!TextUtils.isEmpty(bd.getPackageName())) {
            aVar.packageName = bd.getPackageName();
        }
        return aVar;
    }

    @Override // com.kwad.sdk.core.b
    public final void parseJson(@Nullable JSONObject jSONObject) {
    }

    @Override // com.kwad.sdk.core.b
    public final JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        s.putValue(jSONObject, com.anythink.expressad.videocommon.e.b.f12231u, this.appId);
        s.putValue(jSONObject, "name", this.name);
        s.putValue(jSONObject, "packageName", this.packageName);
        s.putValue(jSONObject, "version", this.version);
        s.putValue(jSONObject, "sha1", this.aky);
        return jSONObject;
    }
}
