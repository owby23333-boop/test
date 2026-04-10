package com.anythink.expressad.exoplayer.h;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.CheckResult;
import androidx.annotation.Nullable;
import com.anythink.expressad.exoplayer.h.s;
import java.io.IOException;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes2.dex */
public interface t {

    public static final class a {
        public final int a;

        @Nullable
        public final s.a b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final CopyOnWriteArrayList<C0195a> f9420c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final long f9421d;

        /* JADX INFO: renamed from: com.anythink.expressad.exoplayer.h.t$a$a, reason: collision with other inner class name */
        private static final class C0195a {
            public final Handler a;
            public final t b;

            public C0195a(Handler handler, t tVar) {
                this.a = handler;
                this.b = tVar;
            }
        }

        public a() {
            this(new CopyOnWriteArrayList(), 0, null, 0L);
        }

        @CheckResult
        public final a a(int i2, @Nullable s.a aVar, long j2) {
            return new a(this.f9420c, i2, aVar, j2);
        }

        public final void b() {
            com.anythink.expressad.exoplayer.k.a.b(this.b != null);
            for (C0195a c0195a : this.f9420c) {
                final t tVar = c0195a.b;
                a(c0195a.a, new Runnable() { // from class: com.anythink.expressad.exoplayer.h.t.a.2
                    @Override // java.lang.Runnable
                    public final void run() {
                        t tVar2 = tVar;
                        a aVar = a.this;
                        tVar2.b(aVar.a, aVar.b);
                    }
                });
            }
        }

        public final void c(final b bVar, final c cVar) {
            for (C0195a c0195a : this.f9420c) {
                final t tVar = c0195a.b;
                a(c0195a.a, new Runnable() { // from class: com.anythink.expressad.exoplayer.h.t.a.5
                    @Override // java.lang.Runnable
                    public final void run() {
                        t tVar2 = tVar;
                        a aVar = a.this;
                        tVar2.c(aVar.a, aVar.b, bVar, cVar);
                    }
                });
            }
        }

        private a(CopyOnWriteArrayList<C0195a> copyOnWriteArrayList, int i2, @Nullable s.a aVar, long j2) {
            this.f9420c = copyOnWriteArrayList;
            this.a = i2;
            this.b = aVar;
            this.f9421d = j2;
        }

        public final void a(Handler handler, t tVar) {
            com.anythink.expressad.exoplayer.k.a.a((handler == null || tVar == null) ? false : true);
            this.f9420c.add(new C0195a(handler, tVar));
        }

        public final void a(t tVar) {
            for (C0195a c0195a : this.f9420c) {
                if (c0195a.b == tVar) {
                    this.f9420c.remove(c0195a);
                }
            }
        }

        public final void c() {
            com.anythink.expressad.exoplayer.k.a.b(this.b != null);
            for (C0195a c0195a : this.f9420c) {
                final t tVar = c0195a.b;
                a(c0195a.a, new Runnable() { // from class: com.anythink.expressad.exoplayer.h.t.a.7
                    @Override // java.lang.Runnable
                    public final void run() {
                        t tVar2 = tVar;
                        a aVar = a.this;
                        tVar2.c(aVar.a, aVar.b);
                    }
                });
            }
        }

        public final void b(final b bVar, final c cVar) {
            for (C0195a c0195a : this.f9420c) {
                final t tVar = c0195a.b;
                a(c0195a.a, new Runnable() { // from class: com.anythink.expressad.exoplayer.h.t.a.4
                    @Override // java.lang.Runnable
                    public final void run() {
                        t tVar2 = tVar;
                        a aVar = a.this;
                        tVar2.b(aVar.a, aVar.b, bVar, cVar);
                    }
                });
            }
        }

        public final void a() {
            com.anythink.expressad.exoplayer.k.a.b(this.b != null);
            for (C0195a c0195a : this.f9420c) {
                final t tVar = c0195a.b;
                a(c0195a.a, new Runnable() { // from class: com.anythink.expressad.exoplayer.h.t.a.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        t tVar2 = tVar;
                        a aVar = a.this;
                        tVar2.a(aVar.a, aVar.b);
                    }
                });
            }
        }

        private void b(com.anythink.expressad.exoplayer.j.k kVar, int i2, long j2, long j3, long j4) {
            b(kVar, i2, -1, null, 0, null, com.anythink.expressad.exoplayer.b.b, com.anythink.expressad.exoplayer.b.b, j2, j3, j4);
        }

        public final void b(com.anythink.expressad.exoplayer.j.k kVar, int i2, int i3, @Nullable com.anythink.expressad.exoplayer.m mVar, int i4, @Nullable Object obj, long j2, long j3, long j4, long j5, long j6) {
            c(new b(kVar, j4, j5, j6), new c(i2, i3, mVar, i4, obj, a(j2), a(j3)));
        }

        private void a(com.anythink.expressad.exoplayer.j.k kVar, int i2, long j2) {
            a(kVar, i2, -1, null, 0, null, com.anythink.expressad.exoplayer.b.b, com.anythink.expressad.exoplayer.b.b, j2);
        }

        public final void a(com.anythink.expressad.exoplayer.j.k kVar, int i2, int i3, @Nullable com.anythink.expressad.exoplayer.m mVar, int i4, @Nullable Object obj, long j2, long j3, long j4) {
            a(new b(kVar, j4, 0L, 0L), new c(i2, i3, mVar, i4, obj, a(j2), a(j3)));
        }

        public final void b(final c cVar) {
            for (C0195a c0195a : this.f9420c) {
                final t tVar = c0195a.b;
                a(c0195a.a, new Runnable() { // from class: com.anythink.expressad.exoplayer.h.t.a.9
                    @Override // java.lang.Runnable
                    public final void run() {
                        t tVar2 = tVar;
                        a aVar = a.this;
                        tVar2.b(aVar.a, aVar.b, cVar);
                    }
                });
            }
        }

        public final void a(final b bVar, final c cVar) {
            for (C0195a c0195a : this.f9420c) {
                final t tVar = c0195a.b;
                a(c0195a.a, new Runnable() { // from class: com.anythink.expressad.exoplayer.h.t.a.3
                    @Override // java.lang.Runnable
                    public final void run() {
                        t tVar2 = tVar;
                        a aVar = a.this;
                        tVar2.a(aVar.a, aVar.b, bVar, cVar);
                    }
                });
            }
        }

        private void a(com.anythink.expressad.exoplayer.j.k kVar, int i2, long j2, long j3, long j4) {
            a(kVar, i2, -1, null, 0, null, com.anythink.expressad.exoplayer.b.b, com.anythink.expressad.exoplayer.b.b, j2, j3, j4);
        }

        public final void a(com.anythink.expressad.exoplayer.j.k kVar, int i2, int i3, @Nullable com.anythink.expressad.exoplayer.m mVar, int i4, @Nullable Object obj, long j2, long j3, long j4, long j5, long j6) {
            b(new b(kVar, j4, j5, j6), new c(i2, i3, mVar, i4, obj, a(j2), a(j3)));
        }

        public final void a(com.anythink.expressad.exoplayer.j.k kVar, IOException iOException) {
            a(kVar, 6, -1, null, 0, null, com.anythink.expressad.exoplayer.b.b, com.anythink.expressad.exoplayer.b.b, -1L, 0L, 0L, iOException, true);
        }

        public final void a(com.anythink.expressad.exoplayer.j.k kVar, int i2, int i3, @Nullable com.anythink.expressad.exoplayer.m mVar, int i4, @Nullable Object obj, long j2, long j3, long j4, long j5, long j6, IOException iOException, boolean z2) {
            a(new b(kVar, j4, j5, j6), new c(i2, i3, mVar, i4, obj, a(j2), a(j3)), iOException, z2);
        }

        public final void a(final b bVar, final c cVar, final IOException iOException, final boolean z2) {
            for (C0195a c0195a : this.f9420c) {
                final t tVar = c0195a.b;
                a(c0195a.a, new Runnable() { // from class: com.anythink.expressad.exoplayer.h.t.a.6
                    @Override // java.lang.Runnable
                    public final void run() {
                        t tVar2 = tVar;
                        a aVar = a.this;
                        tVar2.a(aVar.a, aVar.b, bVar, cVar, iOException, z2);
                    }
                });
            }
        }

        public final void a(int i2, long j2, long j3) {
            a(new c(1, i2, null, 3, null, a(j2), a(j3)));
        }

        public final void a(final c cVar) {
            for (C0195a c0195a : this.f9420c) {
                final t tVar = c0195a.b;
                a(c0195a.a, new Runnable() { // from class: com.anythink.expressad.exoplayer.h.t.a.8
                    @Override // java.lang.Runnable
                    public final void run() {
                        t tVar2 = tVar;
                        a aVar = a.this;
                        tVar2.a(aVar.a, aVar.b, cVar);
                    }
                });
            }
        }

        public final void a(int i2, @Nullable com.anythink.expressad.exoplayer.m mVar, int i3, @Nullable Object obj, long j2) {
            b(new c(1, i2, mVar, i3, obj, a(j2), com.anythink.expressad.exoplayer.b.b));
        }

        private long a(long j2) {
            long jA = com.anythink.expressad.exoplayer.b.a(j2);
            return jA == com.anythink.expressad.exoplayer.b.b ? com.anythink.expressad.exoplayer.b.b : this.f9421d + jA;
        }

        private static void a(Handler handler, Runnable runnable) {
            if (handler.getLooper() == Looper.myLooper()) {
                runnable.run();
            } else {
                handler.post(runnable);
            }
        }
    }

    public static final class b {
        public final com.anythink.expressad.exoplayer.j.k a;
        public final long b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final long f9434c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final long f9435d;

        public b(com.anythink.expressad.exoplayer.j.k kVar, long j2, long j3, long j4) {
            this.a = kVar;
            this.b = j2;
            this.f9434c = j3;
            this.f9435d = j4;
        }
    }

    public static final class c {
        public final int a;
        public final int b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @Nullable
        public final com.anythink.expressad.exoplayer.m f9436c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f9437d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @Nullable
        public final Object f9438e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final long f9439f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final long f9440g;

        public c(int i2, int i3, @Nullable com.anythink.expressad.exoplayer.m mVar, int i4, @Nullable Object obj, long j2, long j3) {
            this.a = i2;
            this.b = i3;
            this.f9436c = mVar;
            this.f9437d = i4;
            this.f9438e = obj;
            this.f9439f = j2;
            this.f9440g = j3;
        }
    }

    void a(int i2, s.a aVar);

    void a(int i2, @Nullable s.a aVar, b bVar, c cVar);

    void a(int i2, @Nullable s.a aVar, b bVar, c cVar, IOException iOException, boolean z2);

    void a(int i2, s.a aVar, c cVar);

    void b(int i2, s.a aVar);

    void b(int i2, @Nullable s.a aVar, b bVar, c cVar);

    void b(int i2, @Nullable s.a aVar, c cVar);

    void c(int i2, s.a aVar);

    void c(int i2, @Nullable s.a aVar, b bVar, c cVar);
}
