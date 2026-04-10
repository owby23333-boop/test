package com.kwad.sdk.core.request.model;

import android.text.TextUtils;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.aa;
import com.kwad.sdk.utils.bs;
import com.kwad.sdk.utils.m;
import com.xuexiang.xupdate.proxy.impl.DefaultUpdateParser;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class a implements com.kwad.sdk.core.b {
    private static JSONObject aHZ;
    private String aIa;
    private String appId;
    private String name;
    private String packageName;
    private String version;
    private int versionCode;

    @Override // com.kwad.sdk.core.b
    public final void parseJson(JSONObject jSONObject) {
    }

    public static JSONObject II() {
        if (!l(aHZ)) {
            aHZ = IJ().toJson();
        }
        return aHZ;
    }

    public static a IJ() {
        a aVar = new a();
        try {
            aVar.appId = ServiceProvider.getSDKConfig().appId;
            aVar.name = ServiceProvider.getSDKConfig().appName;
            aVar.packageName = ServiceProvider.Pp().getPackageName();
            aVar.version = m.cE(ServiceProvider.Pp());
            aVar.versionCode = m.cG(ServiceProvider.Pp());
            aVar.aIa = com.kwad.sdk.utils.f.cs(ServiceProvider.Pp());
            if (!TextUtils.isEmpty(bs.getAppId())) {
                aVar.appId = bs.getAppId();
            }
            if (!TextUtils.isEmpty(bs.getPackageName())) {
                aVar.packageName = bs.getPackageName();
            }
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
        return aVar;
    }

    private static boolean l(JSONObject jSONObject) {
        if (jSONObject == null) {
            return false;
        }
        String strOptString = jSONObject.optString("appId");
        String strOptString2 = jSONObject.optString("name");
        return !TextUtils.isEmpty(strOptString2) && !TextUtils.isEmpty(strOptString) && strOptString.equals(ServiceProvider.getSDKConfig().appId) && strOptString2.equals(ServiceProvider.getSDKConfig().appName);
    }

    @Override // com.kwad.sdk.core.b
    public final JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        aa.putValue(jSONObject, "appId", this.appId);
        aa.putValue(jSONObject, "name", this.name);
        aa.putValue(jSONObject, "packageName", this.packageName);
        aa.putValue(jSONObject, "version", this.version);
        aa.putValue(jSONObject, DefaultUpdateParser.APIKeyLower.VERSION_CODE, this.versionCode);
        aa.putValue(jSONObject, "sha1", this.aIa);
        return jSONObject;
    }
}
