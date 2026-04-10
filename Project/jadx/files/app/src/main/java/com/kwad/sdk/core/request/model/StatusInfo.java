package com.kwad.sdk.core.request.model;

import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.s;
import java.io.Serializable;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class StatusInfo extends com.kwad.sdk.core.response.kwai.a {
    public SplashAdInfo alg;
    public NativeAdRequestInfo alh;
    public int ale = ((com.kwad.sdk.service.kwai.e) ServiceProvider.get(com.kwad.sdk.service.kwai.e.class)).isPersonalRecommend() ? 1 : 0;
    public int alf = ((com.kwad.sdk.service.kwai.e) ServiceProvider.get(com.kwad.sdk.service.kwai.e.class)).isProgrammaticRecommend() ? 1 : 0;
    public List<f> ali = com.kwad.sdk.core.c.a.wi();

    public static final class NativeAdRequestInfo extends com.kwad.sdk.core.response.kwai.a implements Serializable {
        private static final long serialVersionUID = -7917397487136276024L;
        public NativeAdStyleControl nativeAdStyleControl;

        public static NativeAdRequestInfo create(SceneImpl sceneImpl) {
            NativeAdRequestInfo nativeAdRequestInfo = new NativeAdRequestInfo();
            nativeAdRequestInfo.nativeAdStyleControl = com.kwad.sdk.utils.b.d(sceneImpl);
            return nativeAdRequestInfo;
        }
    }

    public static final class NativeAdStyleControl extends com.kwad.sdk.core.response.kwai.a implements Serializable {
        private static final long serialVersionUID = -6047032783829467891L;
        public boolean enableShake;

        @Override // com.kwad.sdk.core.response.kwai.a
        public final void afterToJson(JSONObject jSONObject) {
            super.afterToJson(jSONObject);
            s.putValue(jSONObject, "enableShake", this.enableShake);
        }
    }

    public static final class SplashAdInfo extends com.kwad.sdk.core.response.kwai.a implements Serializable {
        private static final long serialVersionUID = 7910709346852904072L;
        public int dailyShowCount;
        public SplashStyleControl splashStyleControl;

        public static SplashAdInfo create(SceneImpl sceneImpl) {
            SplashAdInfo splashAdInfo = new SplashAdInfo();
            splashAdInfo.dailyShowCount = com.kwad.sdk.utils.b.CG();
            splashAdInfo.splashStyleControl = com.kwad.sdk.utils.b.c(sceneImpl);
            return splashAdInfo;
        }
    }

    public static final class SplashStyleControl extends com.kwad.sdk.core.response.kwai.a implements Serializable {
        private static final long serialVersionUID = -6510852657198503314L;
        public boolean disableRotate;
        public boolean disableShake;
        public boolean disableSlide;
    }

    private StatusInfo(SceneImpl sceneImpl) {
        this.alh = NativeAdRequestInfo.create(sceneImpl);
        this.alg = SplashAdInfo.create(sceneImpl);
    }

    public static StatusInfo b(SceneImpl sceneImpl) {
        return new StatusInfo(sceneImpl);
    }
}
