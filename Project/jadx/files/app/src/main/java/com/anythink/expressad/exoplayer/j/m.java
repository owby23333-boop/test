package com.anythink.expressad.exoplayer.j;

import android.os.Handler;
import android.support.v4.media.session.PlaybackStateCompat;
import androidx.annotation.Nullable;
import com.anythink.expressad.exoplayer.j.d;

/* JADX INFO: loaded from: classes2.dex */
public final class m implements aa<Object>, d {
    public static final long a = 1000000;
    public static final int b = 2000;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int f9681c = 2000;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final int f9682d = 524288;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Nullable
    private final Handler f9683e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Nullable
    private final d.a f9684f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final com.anythink.expressad.exoplayer.k.y f9685g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final com.anythink.expressad.exoplayer.k.c f9686h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f9687i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private long f9688j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private long f9689k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private long f9690l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private long f9691m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private long f9692n;

    /* JADX INFO: renamed from: com.anythink.expressad.exoplayer.j.m$1, reason: invalid class name */
    final class AnonymousClass1 implements Runnable {
        final /* synthetic */ int a;
        final /* synthetic */ long b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ long f9693c;

        AnonymousClass1(int i2, long j2, long j3) {
            this.a = i2;
            this.b = j2;
            this.f9693c = j3;
        }

        @Override // java.lang.Runnable
        public final void run() {
            m.this.f9684f.c();
        }
    }

    /* synthetic */ m(Handler handler, d.a aVar, long j2, int i2, com.anythink.expressad.exoplayer.k.c cVar, byte b2) {
        this(handler, aVar, j2, i2, cVar);
    }

    @Override // com.anythink.expressad.exoplayer.j.aa
    public final synchronized void b() {
        if (this.f9687i == 0) {
            this.f9688j = this.f9686h.a();
        }
        this.f9687i++;
    }

    @Override // com.anythink.expressad.exoplayer.j.aa
    public final synchronized void c() {
        com.anythink.expressad.exoplayer.k.a.b(this.f9687i > 0);
        long jA = this.f9686h.a();
        int i2 = (int) (jA - this.f9688j);
        this.f9690l += i2;
        this.f9691m += this.f9689k;
        if (i2 > 0) {
            this.f9685g.a((int) Math.sqrt(this.f9689k), (this.f9689k * 8000) / r6);
            if (this.f9690l >= com.anythink.expressad.exoplayer.i.a.f9492f || this.f9691m >= PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED) {
                this.f9692n = (long) this.f9685g.a();
            }
        }
        long j2 = this.f9689k;
        long j3 = this.f9692n;
        if (this.f9683e != null && this.f9684f != null) {
            this.f9683e.post(new AnonymousClass1(i2, j2, j3));
        }
        int i3 = this.f9687i - 1;
        this.f9687i = i3;
        if (i3 > 0) {
            this.f9688j = jA;
        }
        this.f9689k = 0L;
    }

    public m() {
        this(null, null, 1000000L, 2000, com.anythink.expressad.exoplayer.k.c.a);
    }

    @Override // com.anythink.expressad.exoplayer.j.d
    public final synchronized long a() {
        return this.f9692n;
    }

    public static final class a {

        @Nullable
        private Handler a;

        @Nullable
        private d.a b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private long f9695c = 1000000;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f9696d = 2000;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private com.anythink.expressad.exoplayer.k.c f9697e = com.anythink.expressad.exoplayer.k.c.a;

        private a a(Handler handler, d.a aVar) {
            com.anythink.expressad.exoplayer.k.a.a((handler == null || aVar == null) ? false : true);
            this.a = handler;
            this.b = aVar;
            return this;
        }

        private a a(int i2) {
            this.f9696d = i2;
            return this;
        }

        private a a(long j2) {
            this.f9695c = j2;
            return this;
        }

        private a a(com.anythink.expressad.exoplayer.k.c cVar) {
            this.f9697e = cVar;
            return this;
        }

        private m a() {
            return new m(this.a, this.b, this.f9695c, this.f9696d, this.f9697e, (byte) 0);
        }
    }

    @Deprecated
    private m(Handler handler, d.a aVar) {
        this(handler, aVar, 1000000L, 2000, com.anythink.expressad.exoplayer.k.c.a);
    }

    @Override // com.anythink.expressad.exoplayer.j.aa
    public final synchronized void a(int i2) {
        this.f9689k += (long) i2;
    }

    @Deprecated
    private m(Handler handler, d.a aVar, int i2) {
        this(handler, aVar, 1000000L, i2, com.anythink.expressad.exoplayer.k.c.a);
    }

    private m(@Nullable Handler handler, @Nullable d.a aVar, long j2, int i2, com.anythink.expressad.exoplayer.k.c cVar) {
        this.f9683e = handler;
        this.f9684f = aVar;
        this.f9685g = new com.anythink.expressad.exoplayer.k.y(i2);
        this.f9686h = cVar;
        this.f9692n = j2;
    }

    private void a(int i2, long j2, long j3) {
        Handler handler = this.f9683e;
        if (handler == null || this.f9684f == null) {
            return;
        }
        handler.post(new AnonymousClass1(i2, j2, j3));
    }
}
