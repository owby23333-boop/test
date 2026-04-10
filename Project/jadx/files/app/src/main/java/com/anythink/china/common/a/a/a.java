package com.anythink.china.common.a.a;

import com.anythink.core.common.k.b.b;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: loaded from: classes2.dex */
public final class a {
    public static final int a = 1;
    public static final int b = 2;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static a f6415c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private ExecutorService f6416d;

    /* JADX INFO: renamed from: com.anythink.china.common.a.a.a$1, reason: invalid class name */
    final class AnonymousClass1 extends b {
        final /* synthetic */ long a = 0;
        final /* synthetic */ Runnable b;

        AnonymousClass1(Runnable runnable) {
            this.b = runnable;
        }

        @Override // com.anythink.core.common.k.b.b
        public final void a() {
            try {
                Thread.sleep(this.a);
            } catch (InterruptedException unused) {
            }
            new StringBuilder("thread-").append(b());
            this.b.run();
        }
    }

    protected a() {
        this.f6416d = null;
        this.f6416d = Executors.newSingleThreadExecutor();
    }

    public static a a() {
        if (f6415c == null) {
            f6415c = new a();
        }
        return f6415c;
    }

    private void b(b bVar) {
        a(bVar);
    }

    private void b(Runnable runnable) {
        if (runnable != null) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(runnable);
            anonymousClass1.a(Long.valueOf(System.currentTimeMillis() / 1000).intValue());
            a((b) anonymousClass1);
        }
    }

    private static void a(a aVar) {
        f6415c = aVar;
    }

    private void b() {
        this.f6416d.shutdown();
    }

    public final void a(b bVar) {
        this.f6416d.execute(bVar);
    }

    private void a(Runnable runnable) {
        if (runnable != null) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(runnable);
            anonymousClass1.a(Long.valueOf(System.currentTimeMillis() / 1000).intValue());
            a((b) anonymousClass1);
        }
    }
}
