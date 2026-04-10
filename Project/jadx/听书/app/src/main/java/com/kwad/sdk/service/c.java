package com.kwad.sdk.service;

import com.ksad.annotation.invoker.ForInvoker;
import com.kwad.components.ad.feed.FeedDownloadActivityProxy;
import com.kwad.components.ad.fullscreen.KsFullScreenLandScapeVideoActivityProxy;
import com.kwad.components.ad.fullscreen.KsFullScreenVideoActivityProxy;
import com.kwad.components.ad.reward.KSRewardLandScapeVideoActivityProxy;
import com.kwad.components.ad.reward.KSRewardVideoActivityProxy;
import com.kwad.components.core.internal.api.KSAdVideoPlayConfigImpl;
import com.kwad.components.core.internal.api.VideoPlayConfigImpl;
import com.kwad.components.core.page.AdWebViewActivityProxy;
import com.kwad.components.core.page.AdWebViewVideoActivityProxy;
import com.kwad.framework.filedownloader.services.FileDownloadServiceProxy;
import com.kwad.sdk.internal.api.SceneImpl;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public final class c {
    private static final Map<Class<?>, Class<?>> aYh = new HashMap(128);
    private static final Map<Class<?>, Class<?>> aYi = new HashMap();
    private static boolean aYj = false;
    private static boolean aYk = false;

    public static void init() {
        Pk();
        Pm();
    }

    private static synchronized void Pk() {
        if (aYj) {
            return;
        }
        Pl();
        aYj = true;
    }

    @ForInvoker(methodId = "initComponentProxyForInvoker")
    private static void Pl() {
        FeedDownloadActivityProxy.register();
        KsFullScreenLandScapeVideoActivityProxy.register();
        KsFullScreenVideoActivityProxy.register();
        KSRewardLandScapeVideoActivityProxy.register();
        KSRewardVideoActivityProxy.register();
        com.kwad.components.core.page.a.register();
        AdWebViewActivityProxy.register();
        AdWebViewVideoActivityProxy.register();
        com.kwad.components.core.page.d.register();
        com.kwad.components.core.s.a.a.register();
        FileDownloadServiceProxy.register();
        com.kwad.sdk.collector.b.a.register();
        a.register();
    }

    public static void a(Class<?> cls, Class<?> cls2) {
        aYh.put(cls, cls2);
    }

    public static Class<?> g(Class<?> cls) {
        Pk();
        return aYh.get(cls);
    }

    private static synchronized void Pm() {
        if (aYk) {
            return;
        }
        Pn();
        aYk = true;
    }

    @ForInvoker(methodId = "initModeImplForInvoker")
    private static void Pn() {
        KSAdVideoPlayConfigImpl.register();
        com.kwad.components.core.internal.api.d.register();
        VideoPlayConfigImpl.register();
        com.kwad.components.core.q.b.register();
        SceneImpl.register();
    }

    public static void b(Class cls, Class cls2) {
        aYi.put(cls, cls2);
    }

    public static Class<?> h(Class<?> cls) {
        Pm();
        return aYi.get(cls);
    }
}
