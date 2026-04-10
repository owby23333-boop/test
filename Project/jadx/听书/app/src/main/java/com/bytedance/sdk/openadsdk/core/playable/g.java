package com.bytedance.sdk.openadsdk.core.playable;

import android.os.SystemClock;
import android.text.TextUtils;
import android.util.LruCache;
import com.bytedance.sdk.component.uy.e;
import com.bytedance.sdk.component.uy.fo;
import com.bytedance.sdk.openadsdk.core.iq.na;
import com.bytedance.sdk.openadsdk.core.zw;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class g {
    private static volatile g z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f1295a;
    private final long dl;
    private LruCache<String, com.bytedance.sdk.openadsdk.core.playable.z.z> g;
    private CopyOnWriteArrayList<String> gc = new CopyOnWriteArrayList<>();
    private CopyOnWriteArrayList<String> m = new CopyOnWriteArrayList<>();
    private ConcurrentHashMap<String, WeakReference<com.bytedance.sdk.openadsdk.core.js.dl>> e = new ConcurrentHashMap<>();
    private ConcurrentHashMap<String, Long> gz = new ConcurrentHashMap<>();
    private final Object fo = new Object();

    static /* synthetic */ void z(g gVar, String str) {
    }

    private g() {
        int iVk = zw.g().vk();
        this.f1295a = iVk;
        if (iVk > 30) {
            this.f1295a = 30;
        } else if (iVk < 0) {
            this.f1295a = 5;
        }
        this.dl = zw.g().pc() * 1000;
        this.g = new LruCache<String, com.bytedance.sdk.openadsdk.core.playable.z.z>(this.f1295a) { // from class: com.bytedance.sdk.openadsdk.core.playable.g.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // android.util.LruCache
            /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
            public int sizeOf(String str, com.bytedance.sdk.openadsdk.core.playable.z.z zVar) {
                return 1;
            }
        };
    }

    public static g z() {
        if (z == null) {
            synchronized (g.class) {
                if (z == null) {
                    z = new g();
                }
            }
        }
        return z;
    }

    public void z(na naVar) {
        if (naVar != null) {
            try {
                if (naVar.lb() == 3) {
                    a(naVar);
                }
            } catch (Throwable unused) {
            }
        }
    }

    private void a(final na naVar) {
        if (TextUtils.isEmpty(naVar.vf())) {
            return;
        }
        final String strVf = naVar.vf();
        if (this.gc.contains(strVf) || this.m.contains(strVf) || this.g.get(strVf) != null) {
            return;
        }
        this.gc.add(strVf);
        this.gz.put(strVf, Long.valueOf(System.currentTimeMillis()));
        e.g(new fo("playable_prefetch") { // from class: com.bytedance.sdk.openadsdk.core.playable.g.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    g.this.z(naVar, strVf);
                } catch (Throwable unused) {
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(na naVar, final String str) {
        com.bytedance.sdk.openadsdk.core.io.g.z(naVar, naVar == null ? null : naVar.rw(), new com.bytedance.sdk.openadsdk.core.js.dl() { // from class: com.bytedance.sdk.openadsdk.core.playable.g.3
            @Override // com.bytedance.sdk.openadsdk.core.js.dl
            public void z(boolean z2, List<na> list, boolean z3) {
                try {
                    if (g.this.m != null && g.this.m.contains(str)) {
                        g.z(g.this, "prefetchCache-onAdLoaded.. discardTask. key: " + str);
                        return;
                    }
                    g.z(g.this, "prefetchCache-onAdLoaded.. success: ".concat(String.valueOf(z2)));
                    synchronized (g.this.fo) {
                        if (!z2 || list == null) {
                            g.this.gc.remove(str);
                        } else {
                            if (list.size() > 0) {
                                com.bytedance.sdk.openadsdk.core.playable.z.z zVar = new com.bytedance.sdk.openadsdk.core.playable.z.z();
                                zVar.z = list;
                                zVar.g = z2;
                                zVar.dl = SystemClock.elapsedRealtime();
                                g.this.g.put(str, zVar);
                                g.z(g.this, "prefetchCache-onAdLoaded.. 缓存save  key: " + str);
                            }
                            g.this.gc.remove(str);
                        }
                    }
                    WeakReference weakReference = (WeakReference) g.this.e.get(str);
                    com.bytedance.sdk.openadsdk.core.js.dl dlVar = weakReference == null ? null : (com.bytedance.sdk.openadsdk.core.js.dl) weakReference.get();
                    if (dlVar != null) {
                        dlVar.z(z2, list, true);
                        g.this.e.remove(str);
                        g.z(g.this, "prefetchCache-onAdLoaded..callback invoke key: " + str);
                    }
                } catch (Exception unused) {
                }
            }
        }, (com.bytedance.sdk.openadsdk.ls.dl.dl.g) null);
    }

    public void g(na naVar) {
        if (naVar != null) {
            try {
                if (TextUtils.isEmpty(naVar.vf())) {
                    return;
                }
                String strVf = naVar.vf();
                this.m.add(strVf);
                this.g.remove(strVf);
                this.gc.remove(strVf);
                this.e.remove(strVf);
                this.gz.remove(strVf);
                this.g.size();
                this.gc.size();
                this.m.size();
            } catch (Exception unused) {
            }
        }
    }

    public boolean z(na naVar, com.bytedance.sdk.openadsdk.core.js.dl dlVar) {
        if (naVar != null && !TextUtils.isEmpty(naVar.vf())) {
            String strVf = naVar.vf();
            try {
                synchronized (this.fo) {
                    if (this.gc.contains(strVf)) {
                        this.e.put(strVf, new WeakReference<>(dlVar));
                        return true;
                    }
                    com.bytedance.sdk.openadsdk.core.playable.z.z zVar = this.g.get(strVf);
                    if (zVar == null) {
                        return false;
                    }
                    if (z(zVar)) {
                        g(naVar);
                        return false;
                    }
                    if (dlVar != null) {
                        dlVar.z(zVar.g, zVar.z, true);
                        return true;
                    }
                }
            } catch (Exception unused) {
            }
        }
        return false;
    }

    private boolean z(com.bytedance.sdk.openadsdk.core.playable.z.z zVar) {
        return this.dl > 0 && zVar != null && SystemClock.elapsedRealtime() - zVar.dl > this.dl;
    }

    public long dl(na naVar) {
        try {
            if (this.gz == null || naVar == null || TextUtils.isEmpty(naVar.vf())) {
                return 0L;
            }
            return this.gz.get(naVar.vf()).longValue();
        } catch (Exception unused) {
            return 0L;
        }
    }
}
