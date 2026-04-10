package com.kwad.sdk.service;

import com.kwad.components.ad.feed.FeedDownloadActivityProxy;
import com.kwad.components.ad.fullscreen.KsFullScreenLandScapeVideoActivityProxy;
import com.kwad.components.ad.fullscreen.KsFullScreenVideoActivityProxy;
import com.kwad.components.ad.reward.KSRewardLandScapeVideoActivityProxy;
import com.kwad.components.ad.reward.KSRewardVideoActivityProxy;
import com.kwad.components.core.internal.api.KSAdVideoPlayConfigImpl;
import com.kwad.components.core.internal.api.VideoPlayConfigImpl;
import com.kwad.components.core.page.AdWebViewActivityProxy;
import com.kwad.components.core.page.AdWebViewVideoActivityProxy;
import com.kwad.components.core.page.d;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwai.filedownloader.services.FileDownloadServiceProxy;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class a {
    private static final Map<Class<?>, Class<?>> axF = new HashMap();
    private static final Map<Class<?>, Class<?>> axG = new HashMap();
    private static boolean axH = false;
    private static boolean axI = false;

    private static synchronized void CB() {
        if (axH) {
            return;
        }
        CC();
        axH = true;
    }

    private static void CC() {
        com.ksad.download.b.a.register();
        FeedDownloadActivityProxy.register();
        KsFullScreenLandScapeVideoActivityProxy.register();
        KsFullScreenVideoActivityProxy.register();
        KSRewardLandScapeVideoActivityProxy.register();
        KSRewardVideoActivityProxy.register();
        com.kwad.components.core.page.a.register();
        AdWebViewActivityProxy.register();
        AdWebViewVideoActivityProxy.register();
        d.register();
        com.kwad.components.core.q.kwai.a.register();
        com.kwad.sdk.collector.a.a.register();
        FileDownloadServiceProxy.register();
    }

    private static synchronized void CD() {
        if (axI) {
            return;
        }
        CE();
        axI = true;
    }

    private static void CE() {
        KSAdVideoPlayConfigImpl.register();
        com.kwad.components.core.internal.api.d.register();
        VideoPlayConfigImpl.register();
        com.kwad.components.core.o.b.register();
        SceneImpl.register();
    }

    public static void a(Class<?> cls, Class<?> cls2) {
        axF.put(cls, cls2);
    }

    public static void b(Class cls, Class cls2) {
        axG.put(cls, cls2);
    }

    public static Class<?> g(Class<?> cls) {
        CB();
        return axF.get(cls);
    }

    public static Class<?> h(Class<?> cls) {
        CD();
        return axG.get(cls);
    }

    public static void init() {
        CB();
        CD();
    }
}
