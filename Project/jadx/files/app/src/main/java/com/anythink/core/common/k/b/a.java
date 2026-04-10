package com.anythink.core.common.k.b;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: loaded from: classes2.dex */
public class a {
    public static final int a = 1;
    public static final int b = 2;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f7654c = 4;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f7655d = 5;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f7656e = 6;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f7657f = 7;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static volatile a f7658g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private ExecutorService f7659h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private ExecutorService f7660i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private ExecutorService f7661j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private ExecutorService f7662k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private ExecutorService f7663l = null;

    private a() {
        this.f7659h = null;
        this.f7660i = null;
        this.f7659h = Executors.newCachedThreadPool();
        this.f7660i = Executors.newSingleThreadExecutor();
    }

    public static a a() {
        if (f7658g == null) {
            synchronized (a.class) {
                if (f7658g == null) {
                    f7658g = new a();
                }
            }
        }
        return f7658g;
    }

    public final void b(final Runnable runnable) {
        if (runnable != null) {
            b bVar = new b() { // from class: com.anythink.core.common.k.b.a.2
                @Override // com.anythink.core.common.k.b.b
                public final void a() {
                    runnable.run();
                }
            };
            bVar.a(Long.valueOf(System.currentTimeMillis() / 1000).intValue());
            a(bVar, 2);
        }
    }

    private void b() {
        this.f7660i.shutdown();
        this.f7659h.shutdown();
    }

    public final synchronized void a(b bVar, int i2) {
        if (i2 == 1) {
            bVar.a("anythink_type_single");
            this.f7660i.execute(bVar);
            return;
        }
        if (i2 == 2) {
            bVar.a("anythink_type_normal");
            this.f7659h.execute(bVar);
            return;
        }
        if (i2 == 4) {
            bVar.a("anythink_type_tcp_log");
            if (this.f7661j == null) {
                this.f7661j = Executors.newSingleThreadExecutor();
            }
            this.f7661j.execute(bVar);
            return;
        }
        if (i2 == 5) {
            bVar.a("anythink_type_image_type");
            if (this.f7662k == null) {
                this.f7662k = Executors.newFixedThreadPool(5);
            }
            this.f7662k.execute(bVar);
            return;
        }
        if (i2 == 6) {
            bVar.a("anythink_type_preload_task");
            if (this.f7663l == null) {
                this.f7663l = Executors.newSingleThreadExecutor();
            }
            this.f7663l.execute(bVar);
        } else if (i2 == 7) {
            bVar.a("anythink_type_network");
            this.f7659h.execute(bVar);
        }
    }

    private void a(b bVar) {
        a(bVar, 2);
    }

    public final void a(Runnable runnable) {
        a(runnable, 0L);
    }

    public final void a(final Runnable runnable, final long j2) {
        if (runnable != null) {
            b bVar = new b() { // from class: com.anythink.core.common.k.b.a.1
                @Override // com.anythink.core.common.k.b.b
                public final void a() {
                    try {
                        Thread.sleep(j2);
                    } catch (InterruptedException unused) {
                    }
                    new StringBuilder("thread-").append(b());
                    runnable.run();
                }
            };
            bVar.a(Long.valueOf(System.currentTimeMillis() / 1000).intValue());
            a(bVar, 2);
        }
    }
}
