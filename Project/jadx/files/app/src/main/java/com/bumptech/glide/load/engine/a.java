package com.bumptech.glide.load.engine;

import android.os.Process;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.load.engine.n;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/* JADX INFO: compiled from: ActiveResources.java */
/* JADX INFO: loaded from: classes2.dex */
final class a {
    private final boolean a;
    private final Executor b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @VisibleForTesting
    final Map<com.bumptech.glide.load.c, d> f13497c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final ReferenceQueue<n<?>> f13498d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private n.a f13499e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private volatile boolean f13500f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @Nullable
    private volatile c f13501g;

    /* JADX INFO: renamed from: com.bumptech.glide.load.engine.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ActiveResources.java */
    class ThreadFactoryC0258a implements ThreadFactory {

        /* JADX INFO: renamed from: com.bumptech.glide.load.engine.a$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: ActiveResources.java */
        class RunnableC0259a implements Runnable {

            /* JADX INFO: renamed from: s, reason: collision with root package name */
            final /* synthetic */ Runnable f13502s;

            RunnableC0259a(ThreadFactoryC0258a threadFactoryC0258a, Runnable runnable) {
                this.f13502s = runnable;
            }

            @Override // java.lang.Runnable
            public void run() {
                Process.setThreadPriority(10);
                this.f13502s.run();
            }
        }

        ThreadFactoryC0258a() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(@NonNull Runnable runnable) {
            return new Thread(new RunnableC0259a(this, runnable), "glide-active-resources");
        }
    }

    /* JADX INFO: compiled from: ActiveResources.java */
    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.a();
        }
    }

    /* JADX INFO: compiled from: ActiveResources.java */
    @VisibleForTesting
    interface c {
        void a();
    }

    /* JADX INFO: compiled from: ActiveResources.java */
    @VisibleForTesting
    static final class d extends WeakReference<n<?>> {
        final com.bumptech.glide.load.c a;
        final boolean b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @Nullable
        s<?> f13504c;

        d(@NonNull com.bumptech.glide.load.c cVar, @NonNull n<?> nVar, @NonNull ReferenceQueue<? super n<?>> referenceQueue, boolean z2) {
            s<?> sVar;
            super(nVar, referenceQueue);
            com.bumptech.glide.util.k.a(cVar);
            this.a = cVar;
            if (nVar.d() && z2) {
                s<?> sVarC = nVar.c();
                com.bumptech.glide.util.k.a(sVarC);
                sVar = sVarC;
            } else {
                sVar = null;
            }
            this.f13504c = sVar;
            this.b = nVar.d();
        }

        void a() {
            this.f13504c = null;
            clear();
        }
    }

    a(boolean z2) {
        this(z2, Executors.newSingleThreadExecutor(new ThreadFactoryC0258a()));
    }

    void a(n.a aVar) {
        synchronized (aVar) {
            synchronized (this) {
                this.f13499e = aVar;
            }
        }
    }

    @Nullable
    synchronized n<?> b(com.bumptech.glide.load.c cVar) {
        d dVar = this.f13497c.get(cVar);
        if (dVar == null) {
            return null;
        }
        n<?> nVar = dVar.get();
        if (nVar == null) {
            a(dVar);
        }
        return nVar;
    }

    @VisibleForTesting
    a(boolean z2, Executor executor) {
        this.f13497c = new HashMap();
        this.f13498d = new ReferenceQueue<>();
        this.a = z2;
        this.b = executor;
        executor.execute(new b());
    }

    @VisibleForTesting
    void b() {
        this.f13500f = true;
        Executor executor = this.b;
        if (executor instanceof ExecutorService) {
            com.bumptech.glide.util.e.a((ExecutorService) executor);
        }
    }

    synchronized void a(com.bumptech.glide.load.c cVar, n<?> nVar) {
        d dVarPut = this.f13497c.put(cVar, new d(cVar, nVar, this.f13498d, this.a));
        if (dVarPut != null) {
            dVarPut.a();
        }
    }

    synchronized void a(com.bumptech.glide.load.c cVar) {
        d dVarRemove = this.f13497c.remove(cVar);
        if (dVarRemove != null) {
            dVarRemove.a();
        }
    }

    void a(@NonNull d dVar) {
        synchronized (this) {
            this.f13497c.remove(dVar.a);
            if (dVar.b && dVar.f13504c != null) {
                this.f13499e.a(dVar.a, new n<>(dVar.f13504c, true, false, dVar.a, this.f13499e));
            }
        }
    }

    void a() {
        while (!this.f13500f) {
            try {
                a((d) this.f13498d.remove());
                c cVar = this.f13501g;
                if (cVar != null) {
                    cVar.a();
                }
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
