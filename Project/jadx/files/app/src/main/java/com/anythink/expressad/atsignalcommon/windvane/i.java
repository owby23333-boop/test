package com.anythink.expressad.atsignalcommon.windvane;

import android.content.Context;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public final class i {
    private static HashMap<String, Class> a = new HashMap<>();
    private Context b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Object f8326c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private WindVaneWebView f8327d;

    public i(Context context, WindVaneWebView windVaneWebView) {
        this.b = context;
        this.f8327d = windVaneWebView;
        try {
            a((Class) Class.forName("com.anythink.expressad.atsignalcommon.bridge.BannerJSPlugin"));
        } catch (ClassNotFoundException unused) {
        }
        try {
            a((Class) Class.forName("com.anythink.expressad.video.signal.communication.RewardJs"));
        } catch (ClassNotFoundException unused2) {
        }
        try {
            a((Class) Class.forName("com.anythink.expressad.video.signal.communication.VideoBridge"));
        } catch (ClassNotFoundException unused3) {
        }
        try {
            a((Class) Class.forName("com.anythink.expressad.atsignalcommon.mraid.MraidJSBridge"));
        } catch (ClassNotFoundException unused4) {
        }
        try {
            a((Class) Class.forName("com.anythink.expressad.splash.js.SplashJs"));
        } catch (ClassNotFoundException unused5) {
        }
        try {
            a((Class) Class.forName("com.anythink.expressad.atsignalcommon.webEnvCheck.WebGLCheckjs"));
        } catch (ClassNotFoundException unused6) {
        }
    }

    private static void b(String str) {
        if (a == null) {
            a = new HashMap<>();
        }
        a.remove(str);
    }

    public final void a(Context context) {
        this.b = context;
    }

    public final void a(Object obj) {
        this.f8326c = obj;
    }

    private Object a(String str, WindVaneWebView windVaneWebView, Context context) {
        Class cls = a.get(str);
        if (cls == null) {
            return null;
        }
        try {
            if (!l.class.isAssignableFrom(cls)) {
                return null;
            }
            l lVar = (l) cls.newInstance();
            lVar.initialize(context, windVaneWebView);
            lVar.initialize(this.f8326c, windVaneWebView);
            return lVar;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static void a(Class cls) {
        if (a == null) {
            a = new HashMap<>();
        }
        a.put(cls.getSimpleName(), cls);
    }

    public final Object a(String str) {
        if (a == null) {
            a = new HashMap<>();
        }
        return a(str, this.f8327d, this.b);
    }

    private static void a() {
        try {
            a((Class) Class.forName("com.anythink.expressad.atsignalcommon.bridge.BannerJSPlugin"));
        } catch (ClassNotFoundException unused) {
        }
        try {
            a((Class) Class.forName("com.anythink.expressad.video.signal.communication.RewardJs"));
        } catch (ClassNotFoundException unused2) {
        }
        try {
            a((Class) Class.forName("com.anythink.expressad.video.signal.communication.VideoBridge"));
        } catch (ClassNotFoundException unused3) {
        }
        try {
            a((Class) Class.forName("com.anythink.expressad.atsignalcommon.mraid.MraidJSBridge"));
        } catch (ClassNotFoundException unused4) {
        }
        try {
            a((Class) Class.forName("com.anythink.expressad.splash.js.SplashJs"));
        } catch (ClassNotFoundException unused5) {
        }
        try {
            a((Class) Class.forName("com.anythink.expressad.atsignalcommon.webEnvCheck.WebGLCheckjs"));
        } catch (ClassNotFoundException unused6) {
        }
    }
}
