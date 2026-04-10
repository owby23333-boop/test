package com.kwad.sdk.core.network;

import android.text.TextUtils;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.aa;
import com.kwad.sdk.utils.bs;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public abstract class b implements f {
    private final Map<String, String> mHeader = new HashMap();
    public final JSONObject mBodyParams = new JSONObject();

    protected abstract void buildBaseBody();

    protected abstract void buildBaseHeader();

    protected boolean enableCrashReport() {
        return true;
    }

    @Override // com.kwad.sdk.core.network.f
    public Map<String, String> getBodyMap() {
        return null;
    }

    @Override // com.kwad.sdk.core.network.f
    public SceneImpl getScene() {
        return null;
    }

    @Override // com.kwad.sdk.core.network.f
    public abstract String getUrl();

    protected void onCreate() {
    }

    protected b() {
        try {
            onCreate();
            buildBaseHeader();
            buildBaseBody();
            if (encryptDisable()) {
                addHeader("x-ksad-ignore-decrypt", "true");
            }
            addHeader("cookie", com.kwad.sdk.core.response.b.f.IS().IT());
            com.kwad.sdk.core.a.d.g(getHeader());
            addHeader("User-Agent", p.getUserAgent());
            addHeader("BrowserUa", p.HA());
            addHeader("SystemUa", p.Hz());
        } catch (Throwable th) {
            reportSdkCaughtException(th);
        }
    }

    protected void reportSdkCaughtException(Throwable th) {
        if (enableCrashReport()) {
            ServiceProvider.reportSdkCaughtException(th);
        } else {
            com.kwad.sdk.core.d.c.printStackTrace(th);
        }
    }

    @Override // com.kwad.sdk.core.network.f
    public Map<String, String> getHeader() {
        return this.mHeader;
    }

    public void addHeader(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        this.mHeader.put(str, str2);
    }

    @Override // com.kwad.sdk.core.network.f
    public JSONObject getBody() {
        if (encryptDisable()) {
            return this.mBodyParams;
        }
        JSONObject jSONObject = new JSONObject();
        com.kwad.sdk.service.a.f fVar = (com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class);
        aa.putValue(jSONObject, "version", fVar.getSDKVersion());
        if (!TextUtils.isEmpty(bs.getAppId())) {
            aa.putValue(jSONObject, "appId", bs.getAppId());
        } else {
            aa.putValue(jSONObject, "appId", fVar.getAppId());
        }
        aa.putValue(jSONObject, "message", com.kwad.sdk.core.a.d.as(getBodyParamsString()));
        com.kwad.sdk.core.a.d.a(getUrl(), getHeader(), jSONObject.toString());
        return jSONObject;
    }

    public JSONObject getBodyParams() {
        return this.mBodyParams;
    }

    protected String getBodyParamsString() {
        return this.mBodyParams.toString();
    }

    public boolean encryptDisable() {
        return com.kwad.sdk.components.g.encryptDisable();
    }

    protected String getRequestHost() {
        return com.kwad.sdk.h.AK();
    }

    public void putBody(String str, String str2) {
        aa.putValue(this.mBodyParams, str, str2);
    }

    public void putBody(String str, double d) {
        aa.putValue(this.mBodyParams, str, d);
    }

    public void putBody(String str, int i) {
        aa.putValue(this.mBodyParams, str, i);
    }

    public void putBody(String str, float f) {
        aa.putValue(this.mBodyParams, str, f);
    }

    public void putBody(String str, byte b) {
        aa.putValue(this.mBodyParams, str, b);
    }

    public void putBody(String str, long j) {
        aa.putValue(this.mBodyParams, str, j);
    }

    public void putBody(String str, boolean z) {
        aa.putValue(this.mBodyParams, str, z);
    }

    public void putBody(String str, JSONObject jSONObject) {
        aa.putValue(this.mBodyParams, str, jSONObject);
    }

    public void putBody(String str, JSONArray jSONArray) {
        aa.putValue(this.mBodyParams, str, jSONArray);
    }

    public void putBody(String str, com.kwad.sdk.core.b bVar) {
        aa.a(this.mBodyParams, str, bVar);
    }

    public void putBody(String str, List<? extends com.kwad.sdk.core.b> list) {
        aa.putValue(this.mBodyParams, str, list);
    }
}
