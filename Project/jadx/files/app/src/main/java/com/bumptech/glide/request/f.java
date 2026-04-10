package com.bumptech.glide.request;

import android.graphics.drawable.Drawable;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import anet.channel.util.HttpConstant;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.util.l;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: compiled from: RequestFutureTarget.java */
/* JADX INFO: loaded from: classes2.dex */
public class f<R> implements d<R>, g<R> {
    private static final a C = new a();

    @GuardedBy("this")
    private boolean A;

    @Nullable
    @GuardedBy("this")
    private GlideException B;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final int f13849s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final int f13850t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private final boolean f13851u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private final a f13852v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    @Nullable
    @GuardedBy("this")
    private R f13853w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    @Nullable
    @GuardedBy("this")
    private e f13854x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    @GuardedBy("this")
    private boolean f13855y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    @GuardedBy("this")
    private boolean f13856z;

    /* JADX INFO: compiled from: RequestFutureTarget.java */
    @VisibleForTesting
    static class a {
        a() {
        }

        void a(Object obj, long j2) throws InterruptedException {
            obj.wait(j2);
        }

        void a(Object obj) {
            obj.notifyAll();
        }
    }

    public f(int i2, int i3) {
        this(i2, i3, true, C);
    }

    @Override // com.bumptech.glide.request.k.j
    public void a(@Nullable Drawable drawable) {
    }

    @Override // com.bumptech.glide.request.k.j
    public synchronized void a(@Nullable e eVar) {
        this.f13854x = eVar;
    }

    @Override // com.bumptech.glide.request.k.j
    public void a(@NonNull com.bumptech.glide.request.k.i iVar) {
    }

    @Override // com.bumptech.glide.request.k.j
    public void b(@Nullable Drawable drawable) {
    }

    @Override // com.bumptech.glide.request.k.j
    public void b(@NonNull com.bumptech.glide.request.k.i iVar) {
        iVar.a(this.f13849s, this.f13850t);
    }

    @Override // com.bumptech.glide.request.k.j
    public synchronized void c(@Nullable Drawable drawable) {
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean z2) {
        e eVar;
        synchronized (this) {
            if (isDone()) {
                return false;
            }
            this.f13855y = true;
            this.f13852v.a(this);
            if (z2) {
                eVar = this.f13854x;
                this.f13854x = null;
            } else {
                eVar = null;
            }
            if (eVar != null) {
                eVar.clear();
            }
            return true;
        }
    }

    @Override // java.util.concurrent.Future
    public R get() throws ExecutionException, InterruptedException {
        try {
            return a((Long) null);
        } catch (TimeoutException e2) {
            throw new AssertionError(e2);
        }
    }

    @Override // java.util.concurrent.Future
    public synchronized boolean isCancelled() {
        return this.f13855y;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0010  */
    @Override // java.util.concurrent.Future
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized boolean isDone() {
        /*
            r1 = this;
            monitor-enter(r1)
            boolean r0 = r1.f13855y     // Catch: java.lang.Throwable -> L13
            if (r0 != 0) goto L10
            boolean r0 = r1.f13856z     // Catch: java.lang.Throwable -> L13
            if (r0 != 0) goto L10
            boolean r0 = r1.A     // Catch: java.lang.Throwable -> L13
            if (r0 == 0) goto Le
            goto L10
        Le:
            r0 = 0
            goto L11
        L10:
            r0 = 1
        L11:
            monitor-exit(r1)
            return r0
        L13:
            r0 = move-exception
            monitor-exit(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.request.f.isDone():boolean");
    }

    @Override // com.bumptech.glide.l.m
    public void onDestroy() {
    }

    @Override // com.bumptech.glide.l.m
    public void onStart() {
    }

    @Override // com.bumptech.glide.l.m
    public void onStop() {
    }

    public String toString() {
        e eVar;
        String str;
        String str2 = super.toString() + "[status=";
        synchronized (this) {
            eVar = null;
            if (this.f13855y) {
                str = "CANCELLED";
            } else if (this.A) {
                str = "FAILURE";
            } else if (this.f13856z) {
                str = HttpConstant.SUCCESS;
            } else {
                str = "PENDING";
                eVar = this.f13854x;
            }
        }
        if (eVar == null) {
            return str2 + str + "]";
        }
        return str2 + str + ", request=[" + eVar + "]]";
    }

    f(int i2, int i3, boolean z2, a aVar) {
        this.f13849s = i2;
        this.f13850t = i3;
        this.f13851u = z2;
        this.f13852v = aVar;
    }

    @Override // com.bumptech.glide.request.k.j
    @Nullable
    public synchronized e a() {
        return this.f13854x;
    }

    @Override // java.util.concurrent.Future
    public R get(long j2, @NonNull TimeUnit timeUnit) throws ExecutionException, InterruptedException, TimeoutException {
        return a(Long.valueOf(timeUnit.toMillis(j2)));
    }

    @Override // com.bumptech.glide.request.k.j
    public synchronized void a(@NonNull R r2, @Nullable com.bumptech.glide.request.l.d<? super R> dVar) {
    }

    private synchronized R a(Long l2) throws ExecutionException, InterruptedException, TimeoutException {
        if (this.f13851u && !isDone()) {
            l.a();
        }
        if (!this.f13855y) {
            if (!this.A) {
                if (this.f13856z) {
                    return this.f13853w;
                }
                if (l2 == null) {
                    this.f13852v.a(this, 0L);
                } else if (l2.longValue() > 0) {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    long jLongValue = l2.longValue() + jCurrentTimeMillis;
                    while (!isDone() && jCurrentTimeMillis < jLongValue) {
                        this.f13852v.a(this, jLongValue - jCurrentTimeMillis);
                        jCurrentTimeMillis = System.currentTimeMillis();
                    }
                }
                if (!Thread.interrupted()) {
                    if (!this.A) {
                        if (!this.f13855y) {
                            if (this.f13856z) {
                                return this.f13853w;
                            }
                            throw new TimeoutException();
                        }
                        throw new CancellationException();
                    }
                    throw new ExecutionException(this.B);
                }
                throw new InterruptedException();
            }
            throw new ExecutionException(this.B);
        }
        throw new CancellationException();
    }

    @Override // com.bumptech.glide.request.g
    public synchronized boolean a(@Nullable GlideException glideException, Object obj, com.bumptech.glide.request.k.j<R> jVar, boolean z2) {
        this.A = true;
        this.B = glideException;
        this.f13852v.a(this);
        return false;
    }

    @Override // com.bumptech.glide.request.g
    public synchronized boolean a(R r2, Object obj, com.bumptech.glide.request.k.j<R> jVar, DataSource dataSource, boolean z2) {
        this.f13856z = true;
        this.f13853w = r2;
        this.f13852v.a(this);
        return false;
    }
}
