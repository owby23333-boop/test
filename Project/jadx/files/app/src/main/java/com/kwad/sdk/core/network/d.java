package com.kwad.sdk.core.network;

import com.kwad.sdk.components.DevelopMangerComponents;
import com.kwad.sdk.core.request.model.StatusInfo;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.service.ServiceProvider;
import com.taobao.accs.common.Constants;

/* JADX INFO: loaded from: classes3.dex */
public abstract class d extends b {
    public static final String TRACK_ID_KEY = "kuaishou-tracing-token";
    private static int sLiveSupportMode;

    public d() {
        this(0, null);
    }

    public d(int i2, SceneImpl sceneImpl) {
        putBody("deviceInfo", com.kwad.sdk.core.request.model.b.g(isAddAppPackageNameParam(), i2));
        putBody("statusInfo", StatusInfo.b(sceneImpl));
    }

    @Override // com.kwad.sdk.core.network.b
    protected void buildBaseBody() {
        putBody("protocolVersion", "2.0");
        putBody("SDKVersion", "3.3.38");
        putBody("SDKVersionCode", 3033800);
        putBody("sdkApiVersion", ((com.kwad.sdk.service.kwai.e) ServiceProvider.get(com.kwad.sdk.service.kwai.e.class)).getApiVersion());
        putBody("sdkApiVersionCode", ((com.kwad.sdk.service.kwai.e) ServiceProvider.get(com.kwad.sdk.service.kwai.e.class)).getApiVersionCode());
        putBody("sdkType", 1);
        putBody("appInfo", com.kwad.sdk.core.request.model.a.xA());
        putBody("tkVersion", "5.0.0");
        putBody("networkInfo", com.kwad.sdk.core.request.model.d.xE());
        if (sLiveSupportMode == 0 && ((com.kwad.sdk.service.kwai.e) ServiceProvider.get(com.kwad.sdk.service.kwai.e.class)).hasLiveCompoReady()) {
            sLiveSupportMode = 1;
        }
        String str = "sLiveSupportMode :" + sLiveSupportMode;
        putBody("liveSupportMode", sLiveSupportMode);
        putBody("geoInfo", com.kwad.sdk.core.request.model.c.xD());
        putBody("ext", com.kwad.sdk.core.request.model.e.xG());
        putBody(Constants.KEY_USER_ID, com.kwad.sdk.core.request.model.g.xH());
        putBody("requestSessionData", r.wu().bO(getUrl()));
    }

    @Override // com.kwad.sdk.core.network.b
    protected void buildBaseHeader() {
        String url = getUrl();
        if (!com.kwad.b.kwai.a.bI.booleanValue() || url == null || url.contains(com.kwad.sdk.c.sx())) {
            return;
        }
        com.kwad.sdk.components.c.f(DevelopMangerComponents.class);
        addHeader("trace-context", "{\"laneId\":\"STAGING.online.u\"}");
        com.kwad.sdk.components.c.f(DevelopMangerComponents.class);
    }

    protected boolean isAddAppPackageNameParam() {
        return false;
    }
}
