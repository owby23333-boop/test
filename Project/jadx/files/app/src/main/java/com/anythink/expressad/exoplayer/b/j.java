package com.anythink.expressad.exoplayer.b;

import android.media.AudioTrack;
import android.os.SystemClock;
import com.anythink.expressad.exoplayer.k.af;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
final class j {
    private static final int a = 1;
    private static final int b = 2;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int f8548c = 3;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final long f8549d = 5000000;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final long f8550e = 5000000;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final long f8551f = 200;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final int f8552g = 10;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final int f8553h = 30000;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final int f8554i = 500000;
    private long A;
    private long B;
    private int C;
    private int D;
    private long E;
    private long F;
    private long G;
    private long H;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final a f8555j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final long[] f8556k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private AudioTrack f8557l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f8558m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private int f8559n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private i f8560o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private int f8561p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private boolean f8562q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private long f8563r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private long f8564s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private long f8565t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private Method f8566u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private long f8567v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private boolean f8568w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private boolean f8569x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private long f8570y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private long f8571z;

    public interface a {
        void a(int i2, long j2);

        void a(long j2);

        void a(long j2, long j3, long j4, long j5);

        void b(long j2, long j3, long j4, long j5);
    }

    /* JADX INFO: loaded from: classes.dex */
    @Retention(RetentionPolicy.SOURCE)
    private @interface b {
    }

    public j(a aVar) {
        this.f8555j = (a) com.anythink.expressad.exoplayer.k.a.a(aVar);
        if (af.a >= 18) {
            try {
                this.f8566u = AudioTrack.class.getMethod("getLatency", null);
            } catch (NoSuchMethodException unused) {
            }
        }
        this.f8556k = new long[10];
    }

    private void f(long j2) {
        Method method;
        if (!this.f8569x || (method = this.f8566u) == null || j2 - this.f8570y < 500000) {
            return;
        }
        try {
            this.f8567v = (((long) ((Integer) method.invoke(this.f8557l, null)).intValue()) * 1000) - this.f8563r;
            this.f8567v = Math.max(this.f8567v, 0L);
            if (this.f8567v > 5000000) {
                this.f8555j.a(this.f8567v);
                this.f8567v = 0L;
            }
        } catch (Exception unused) {
            this.f8566u = null;
        }
        this.f8570y = j2;
    }

    private long g(long j2) {
        return (j2 * 1000000) / ((long) this.f8561p);
    }

    private long h() {
        return g(i());
    }

    private long i() {
        if (this.E != com.anythink.expressad.exoplayer.b.b) {
            return Math.min(this.H, this.G + ((((SystemClock.elapsedRealtime() * 1000) - this.E) * ((long) this.f8561p)) / 1000000));
        }
        int playState = this.f8557l.getPlayState();
        if (playState == 1) {
            return 0L;
        }
        long playbackHeadPosition = 4294967295L & ((long) this.f8557l.getPlaybackHeadPosition());
        if (this.f8562q) {
            if (playState == 2 && playbackHeadPosition == 0) {
                this.B = this.f8571z;
            }
            playbackHeadPosition += this.B;
        }
        if (af.a <= 28) {
            if (playbackHeadPosition == 0 && this.f8571z > 0 && playState == 3) {
                if (this.F == com.anythink.expressad.exoplayer.b.b) {
                    this.F = SystemClock.elapsedRealtime();
                }
                return this.f8571z;
            }
            this.F = com.anythink.expressad.exoplayer.b.b;
        }
        if (this.f8571z > playbackHeadPosition) {
            this.A++;
        }
        this.f8571z = playbackHeadPosition;
        return playbackHeadPosition + (this.A << 32);
    }

    public final void a(AudioTrack audioTrack, int i2, int i3, int i4) {
        this.f8557l = audioTrack;
        this.f8558m = i3;
        this.f8559n = i4;
        this.f8560o = new i(audioTrack);
        this.f8561p = audioTrack.getSampleRate();
        this.f8562q = af.a < 23 && (i2 == 5 || i2 == 6);
        this.f8569x = af.b(i2);
        this.f8563r = this.f8569x ? g(i4 / i3) : -9223372036854775807L;
        this.f8571z = 0L;
        this.A = 0L;
        this.B = 0L;
        this.f8568w = false;
        this.E = com.anythink.expressad.exoplayer.b.b;
        this.F = com.anythink.expressad.exoplayer.b.b;
        this.f8567v = 0L;
    }

    public final boolean b() {
        return this.f8557l.getPlayState() == 3;
    }

    public final boolean c(long j2) {
        return this.F != com.anythink.expressad.exoplayer.b.b && j2 > 0 && SystemClock.elapsedRealtime() - this.F >= f8551f;
    }

    public final void d(long j2) {
        this.G = i();
        this.E = SystemClock.elapsedRealtime() * 1000;
        this.H = j2;
    }

    public final boolean e(long j2) {
        return j2 > i() || g();
    }

    private boolean g() {
        return this.f8562q && this.f8557l.getPlayState() == 2 && i() == 0;
    }

    public final int b(long j2) {
        return this.f8559n - ((int) (j2 - (i() * ((long) this.f8558m))));
    }

    private void e() {
        long jH = h();
        if (jH == 0) {
            return;
        }
        long jNanoTime = System.nanoTime() / 1000;
        if (jNanoTime - this.f8565t >= 30000) {
            long[] jArr = this.f8556k;
            int i2 = this.C;
            jArr[i2] = jH - jNanoTime;
            this.C = (i2 + 1) % 10;
            int i3 = this.D;
            if (i3 < 10) {
                this.D = i3 + 1;
            }
            this.f8565t = jNanoTime;
            this.f8564s = 0L;
            int i4 = 0;
            while (true) {
                int i5 = this.D;
                if (i4 >= i5) {
                    break;
                }
                this.f8564s += this.f8556k[i4] / ((long) i5);
                i4++;
            }
        }
        if (this.f8562q) {
            return;
        }
        if (this.f8560o.a(jNanoTime)) {
            long jF = this.f8560o.f();
            long jG = this.f8560o.g();
            if (Math.abs(jF - jNanoTime) > 5000000) {
                this.f8555j.b(jG, jF, jNanoTime, jH);
                this.f8560o.a();
            } else if (Math.abs(g(jG) - jH) > 5000000) {
                this.f8555j.a(jG, jF, jNanoTime, jH);
                this.f8560o.a();
            } else {
                this.f8560o.b();
            }
        }
        f(jNanoTime);
    }

    public final boolean c() {
        f();
        if (this.E != com.anythink.expressad.exoplayer.b.b) {
            return false;
        }
        this.f8560o.e();
        return true;
    }

    public final void d() {
        f();
        this.f8557l = null;
        this.f8560o = null;
    }

    private void f() {
        this.f8564s = 0L;
        this.D = 0;
        this.C = 0;
        this.f8565t = 0L;
    }

    public final long a(boolean z2) {
        long jH;
        if (this.f8557l.getPlayState() == 3) {
            long jH2 = h();
            if (jH2 != 0) {
                long jNanoTime = System.nanoTime() / 1000;
                if (jNanoTime - this.f8565t >= 30000) {
                    long[] jArr = this.f8556k;
                    int i2 = this.C;
                    jArr[i2] = jH2 - jNanoTime;
                    this.C = (i2 + 1) % 10;
                    int i3 = this.D;
                    if (i3 < 10) {
                        this.D = i3 + 1;
                    }
                    this.f8565t = jNanoTime;
                    this.f8564s = 0L;
                    int i4 = 0;
                    while (true) {
                        int i5 = this.D;
                        if (i4 >= i5) {
                            break;
                        }
                        this.f8564s += this.f8556k[i4] / ((long) i5);
                        i4++;
                    }
                }
                if (!this.f8562q) {
                    if (this.f8560o.a(jNanoTime)) {
                        long jF = this.f8560o.f();
                        long jG = this.f8560o.g();
                        if (Math.abs(jF - jNanoTime) > 5000000) {
                            this.f8555j.b(jG, jF, jNanoTime, jH2);
                            this.f8560o.a();
                        } else if (Math.abs(g(jG) - jH2) > 5000000) {
                            this.f8555j.a(jG, jF, jNanoTime, jH2);
                            this.f8560o.a();
                        } else {
                            this.f8560o.b();
                        }
                    }
                    f(jNanoTime);
                }
            }
        }
        long jNanoTime2 = System.nanoTime() / 1000;
        if (this.f8560o.c()) {
            long jG2 = g(this.f8560o.g());
            return !this.f8560o.d() ? jG2 : jG2 + (jNanoTime2 - this.f8560o.f());
        }
        if (this.D == 0) {
            jH = h();
        } else {
            jH = this.f8564s + jNanoTime2;
        }
        return !z2 ? jH - this.f8567v : jH;
    }

    public final void a() {
        this.f8560o.e();
    }

    public final boolean a(long j2) {
        a aVar;
        int playState = this.f8557l.getPlayState();
        if (this.f8562q) {
            if (playState == 2) {
                this.f8568w = false;
                return false;
            }
            if (playState == 1 && i() == 0) {
                return false;
            }
        }
        boolean z2 = this.f8568w;
        this.f8568w = e(j2);
        if (z2 && !this.f8568w && playState != 1 && (aVar = this.f8555j) != null) {
            aVar.a(this.f8559n, com.anythink.expressad.exoplayer.b.a(this.f8563r));
        }
        return true;
    }

    private void a(long j2, long j3) {
        if (this.f8560o.a(j2)) {
            long jF = this.f8560o.f();
            long jG = this.f8560o.g();
            if (Math.abs(jF - j2) > 5000000) {
                this.f8555j.b(jG, jF, j2, j3);
                this.f8560o.a();
            } else if (Math.abs(g(jG) - j3) > 5000000) {
                this.f8555j.a(jG, jF, j2, j3);
                this.f8560o.a();
            } else {
                this.f8560o.b();
            }
        }
    }

    private static boolean a(int i2) {
        if (af.a < 23) {
            return i2 == 5 || i2 == 6;
        }
        return false;
    }
}
