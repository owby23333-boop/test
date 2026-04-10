package com.bytedance.pangle.download;

import android.os.Handler;
import android.os.Looper;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes2.dex */
public class b {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static volatile b f14539e;
    final Map<String, Long> a = new ConcurrentHashMap();
    public final Handler b = new Handler(Looper.getMainLooper());

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<String, Runnable> f14540c = new ConcurrentHashMap();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final Map<String, Runnable> f14541d = new ConcurrentHashMap();

    private b() {
    }

    public static b a() {
        if (f14539e == null) {
            synchronized (b.class) {
                if (f14539e == null) {
                    f14539e = new b();
                }
            }
        }
        return f14539e;
    }
}
