package com.kwad.sdk.service;

import android.content.Context;
import com.kwad.components.offline.api.BuildConfig;
import com.kwad.sdk.api.SdkConfig;
import com.kwad.sdk.o.m;
import com.kwad.sdk.service.a.e;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes4.dex */
public final class ServiceProvider {
    private static List<Throwable> Oe;
    private static Context aYl;
    private static Context aYm;
    private static boolean aYn;
    private static Context mContext;

    public static String getSdkVersion() {
        return BuildConfig.VERSION_NAME;
    }

    public static void co(Context context) {
        aYl = context;
        mContext = m.ep(context);
    }

    public static void Po() {
        aYn = true;
    }

    @Deprecated
    public static Context Pp() {
        return mContext;
    }

    public static Context getContext() {
        if (aYn) {
            return Pp();
        }
        if (aYm == null) {
            aYm = m.wrapContextIfNeed(mContext);
        }
        return aYm;
    }

    public static SdkConfig getSDKConfig() {
        return b.getSDKConfig();
    }

    public static String getAppId() {
        return b.getAppId();
    }

    public static String getAppName() {
        return b.getAppName();
    }

    public static <T> T get(Class<T> cls) {
        return (T) ServiceProviderDelegate.INSTANCE.get(cls);
    }

    public static <T> void put(Class<T> cls, T t) {
        ServiceProviderDelegate.INSTANCE.put(cls, t);
    }

    public static void reportSdkCaughtException(Throwable th) {
        e eVar = (e) get(e.class);
        if (eVar != null) {
            eVar.gatherException(th);
        } else {
            b(th);
        }
    }

    private static void b(Throwable th) {
        if (Oe == null) {
            Oe = new CopyOnWriteArrayList();
        }
        Oe.add(th);
    }

    public static void f(com.kwad.sdk.g.a<Throwable> aVar) {
        List<Throwable> list = Oe;
        if (list == null) {
            return;
        }
        Iterator<Throwable> it = list.iterator();
        while (it.hasNext()) {
            aVar.accept(it.next());
        }
        Oe.clear();
        Oe = null;
    }

    enum ServiceProviderDelegate {
        INSTANCE;

        private final Map<Class<?>, Object> mProviders = new HashMap(32);

        ServiceProviderDelegate() {
        }

        public final <T> T get(Class<T> cls) {
            return (T) this.mProviders.get(cls);
        }

        public final <T> void put(Class<T> cls, T t) {
            this.mProviders.put(cls, t);
        }
    }
}
