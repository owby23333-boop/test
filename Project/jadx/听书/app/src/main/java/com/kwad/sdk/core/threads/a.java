package com.kwad.sdk.core.threads;

import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes4.dex */
public final class a {
    private static Map<String, WeakReference<C0407a>> aJq = new ConcurrentHashMap();

    public static synchronized Handler Ji() {
        return eB("reportHT").getHandler();
    }

    private static C0407a eB(String str) {
        WeakReference<C0407a> weakReference = aJq.get(str);
        if (weakReference == null || weakReference.get() == null) {
            C0407a c0407a = new C0407a(str);
            aJq.put(str, new WeakReference<>(c0407a));
            return c0407a;
        }
        return weakReference.get();
    }

    /* JADX INFO: renamed from: com.kwad.sdk.core.threads.a$a, reason: collision with other inner class name */
    public static class C0407a {
        private HandlerThread aJr;
        private Handler iK;

        public C0407a(String str) {
            HandlerThread handlerThread = new HandlerThread(TextUtils.isEmpty(str) ? "ksad-HT" : "ksad-" + str);
            this.aJr = handlerThread;
            handlerThread.start();
            this.iK = new Handler(this.aJr.getLooper());
        }

        public final Handler getHandler() {
            return this.iK;
        }
    }
}
