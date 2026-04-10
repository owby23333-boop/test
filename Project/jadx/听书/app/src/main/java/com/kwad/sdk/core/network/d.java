package com.kwad.sdk.core.network;

import com.kwad.components.offline.api.BuildConfig;
import com.kwad.sdk.components.DevelopMangerComponents;
import com.kwad.sdk.core.request.model.StatusInfo;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.bc;
import com.umeng.umcrash.UMCrash;

/* JADX INFO: loaded from: classes4.dex */
public abstract class d extends b {
    public static final String TRACK_ID_KEY = "kuaishou-tracing-token";

    protected boolean enablePrivateInfoObtain() {
        return true;
    }

    protected boolean needAppList() {
        return false;
    }

    protected boolean needAppendKuaHeader() {
        return true;
    }

    public d() {
        this(0, null);
    }

    public d(int i, SceneImpl sceneImpl) {
        if (needAppendKuaHeader()) {
            appendKUAHeader();
        }
        putBody("deviceInfo", com.kwad.sdk.core.request.model.b.h(needAppList(), i));
        if (sceneImpl != null) {
            putBody("statusInfo", StatusInfo.d(sceneImpl));
        }
    }

    private void appendKUAHeader() {
        com.kwad.sdk.service.a.f fVar;
        com.kwad.sdk.core.i.c cVarJ = com.kwad.sdk.core.i.a.j(true, false);
        if (cVarJ == null || (fVar = (com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)) == null) {
            return;
        }
        addHeader("KUA", cVarJ.bI(fVar.getContext()));
    }

    @Override // com.kwad.sdk.core.network.b
    protected void buildBaseBody() {
        try {
            putBody("protocolVersion", "2.0");
            putBody("SDKVersion", BuildConfig.VERSION_NAME);
            putBody("SDKVersionCode", BuildConfig.VERSION_CODE);
            putBody("sdkApiVersion", ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).getApiVersion());
            putBody("sdkApiVersionCode", ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).getApiVersionCode());
            int i = 1;
            putBody("sdkType", 1);
            putBody("appInfo", com.kwad.sdk.core.request.model.a.II());
            putBody("tkVersion", "6.1.7");
            putBody("adSdkVersion", BuildConfig.VERSION_NAME);
            putBody("networkInfo", com.kwad.sdk.core.request.model.d.IM());
            putBody("liveSupportMode", ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).qu() ? 1 : 0);
            if (!((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).qt()) {
                i = 0;
            }
            putBody("waynePlayerSupportMode", i);
            putBody("userInfo", com.kwad.sdk.core.request.model.g.IP());
            putBody("requestSessionData", q.HB().ea(getUrl()));
            putBody(UMCrash.SP_KEY_TIMESTAMP, System.currentTimeMillis());
            if (enablePrivateInfoObtain()) {
                buildBaseBodyWithPrivateInfo();
            }
        } catch (Throwable th) {
            reportSdkCaughtException(th);
        }
        putBody("mediumDisableSensor", bc.useSensorManagerDisable());
    }

    protected void buildBaseBodyWithPrivateInfo() {
        try {
            putBody("geoInfo", com.kwad.sdk.core.request.model.c.IL());
            putBody("kGeoInfo", ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).Bp());
            putBody("ext", com.kwad.sdk.core.request.model.e.IO());
        } catch (Throwable th) {
            reportSdkCaughtException(th);
        }
    }

    @Override // com.kwad.sdk.core.network.b
    protected void buildBaseHeader() {
        if (com.kwad.framework.a.a.oz.booleanValue()) {
            com.kwad.sdk.components.d.f(DevelopMangerComponents.class);
            addHeader("trace-context", "{\"laneId\":\"STAGING.online.u\"}");
            com.kwad.sdk.components.d.f(DevelopMangerComponents.class);
        }
    }
}
