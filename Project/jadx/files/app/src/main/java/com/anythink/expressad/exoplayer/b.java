package com.anythink.expressad.exoplayer;

import android.annotation.TargetApi;
import android.content.Context;
import android.media.AudioManager;
import com.anythink.expressad.exoplayer.k.af;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.UUID;

/* JADX INFO: loaded from: classes2.dex */
public final class b {
    public static final int A = 8;
    public static final int B = 14;
    public static final int C;
    public static final int D = 4;
    public static final int E = 8;
    public static final int F = 3;
    public static final int G = 5;
    public static final int H = 2;
    public static final int I = 1;
    public static final int J = 0;
    public static final int K = Integer.MIN_VALUE;
    public static final int L = 3;
    public static final int M = 3;
    public static final int N = 2;
    public static final int O = 4;
    public static final int P = 1;
    public static final int Q = 0;
    public static final int R = 1;
    public static final int S = 4;
    public static final int T = 11;
    public static final int U = 12;
    public static final int V = 13;
    public static final int W = 14;
    public static final int X = 1;
    public static final int Y = 5;
    public static final int Z = 9;
    public static final long a = Long.MIN_VALUE;
    public static final int aA = -5;
    public static final int aB = 0;
    public static final int aC = 1;
    public static final int aD = 2;
    public static final int aE = 3;
    public static final int aF = 4;
    public static final int aG = 5;
    public static final int aH = 6;
    public static final int aI = 10000;
    public static final int aJ = -1;
    public static final int aK = 0;
    public static final int aL = 1;
    public static final int aM = 2;
    public static final int aN = 3;
    public static final int aO = 4;
    public static final int aP = 5;
    public static final int aQ = 10000;
    public static final int aR = 0;
    public static final int aS = 1;
    public static final int aT = 2;
    public static final int aU = 3;
    public static final int aV = 4;
    public static final int aW = 10000;
    public static final int aX = 65536;
    public static final int aY = 13107200;
    public static final int aZ = 3538944;
    public static final int aa = 8;
    public static final int ab = 7;
    public static final int ac = 10;
    public static final int ad = 6;
    public static final int ae = 0;
    public static final int af = 2;
    public static final int ag = 3;
    public static final int ah = 1;
    public static final int ai = 4;
    public static final int aj = 1073741824;
    public static final int ak = Integer.MIN_VALUE;
    public static final int al = 1;
    public static final int am = 2;
    public static final int an = 1;
    public static final int ao = 1;
    public static final int ap = 2;
    public static final int aq = 4;
    public static final String ar = "und";
    public static final int as = 0;
    public static final int at = 1;
    public static final int au = 2;
    public static final int av = 3;
    public static final int aw = -1;
    public static final int ax = -2;
    public static final int ay = -3;
    public static final int az = -4;
    public static final long b = -9223372036854775807L;
    public static final int bA = 7;
    public static final int bB = 2;
    public static final int bC = 1;
    public static final int bD = 0;
    public static final int bE = -1000;
    public static final int ba = 131072;
    public static final int bb = 131072;
    public static final int bc = 16777216;
    public static final String bd = "cenc";
    public static final String be = "cbc1";
    public static final String bf = "cens";
    public static final String bg = "cbcs";
    public static final UUID bh;
    public static final UUID bi;
    public static final UUID bj;
    public static final UUID bk;
    public static final UUID bl;
    public static final int bm = 1;
    public static final int bn = 2;
    public static final int bo = 3;
    public static final int bp = 4;
    public static final int bq = 10000;
    public static final int br = 0;
    public static final int bs = 1;
    public static final int bt = 2;
    public static final int bu = 3;
    public static final int bv = 1;
    public static final int bw = 2;
    public static final int bx = 6;
    public static final int by = 3;
    public static final int bz = 6;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f8481c = -1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f8482d = -1;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f8483e = -1;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f8484f = -1;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final long f8485g = 1000000;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final long f8486h = 1000000000;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final String f8487i = "US-ASCII";

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final String f8488j = "UTF-8";

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final String f8489k = "UTF-16";

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final String f8490l = "serif";

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final String f8491m = "sans-serif";

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int f8492n = 0;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final int f8493o = 1;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final int f8494p = 2;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final int f8495q = 0;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final int f8496r = 0;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final int f8497s = 3;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final int f8498t = 2;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final int f8499u = Integer.MIN_VALUE;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final int f8500v = 1073741824;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final int f8501w = 4;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final int f8502x = 5;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final int f8503y = 6;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final int f8504z = 7;

    /* JADX INFO: loaded from: classes.dex */
    @Retention(RetentionPolicy.SOURCE)
    public @interface a {
    }

    /* JADX INFO: renamed from: com.anythink.expressad.exoplayer.b$b, reason: collision with other inner class name */
    /* JADX INFO: loaded from: classes.dex */
    @Retention(RetentionPolicy.SOURCE)
    public @interface InterfaceC0181b {
    }

    /* JADX INFO: loaded from: classes.dex */
    @Retention(RetentionPolicy.SOURCE)
    public @interface c {
    }

    /* JADX INFO: loaded from: classes.dex */
    @Retention(RetentionPolicy.SOURCE)
    public @interface d {
    }

    /* JADX INFO: loaded from: classes.dex */
    @Retention(RetentionPolicy.SOURCE)
    public @interface e {
    }

    /* JADX INFO: loaded from: classes.dex */
    @Retention(RetentionPolicy.SOURCE)
    public @interface f {
    }

    /* JADX INFO: loaded from: classes.dex */
    @Retention(RetentionPolicy.SOURCE)
    public @interface g {
    }

    /* JADX INFO: loaded from: classes.dex */
    @Retention(RetentionPolicy.SOURCE)
    public @interface h {
    }

    /* JADX INFO: loaded from: classes.dex */
    @Retention(RetentionPolicy.SOURCE)
    public @interface i {
    }

    /* JADX INFO: loaded from: classes.dex */
    @Retention(RetentionPolicy.SOURCE)
    public @interface j {
    }

    /* JADX INFO: loaded from: classes.dex */
    @Retention(RetentionPolicy.SOURCE)
    public @interface k {
    }

    /* JADX INFO: loaded from: classes.dex */
    @Retention(RetentionPolicy.SOURCE)
    public @interface l {
    }

    /* JADX INFO: loaded from: classes.dex */
    @Retention(RetentionPolicy.SOURCE)
    public @interface m {
    }

    /* JADX INFO: loaded from: classes.dex */
    @Retention(RetentionPolicy.SOURCE)
    public @interface n {
    }

    /* JADX INFO: loaded from: classes.dex */
    @Retention(RetentionPolicy.SOURCE)
    public @interface o {
    }

    static {
        C = af.a < 23 ? 1020 : 6396;
        bh = new UUID(0L, 0L);
        bi = new UUID(1186680826959645954L, -5988876978535335093L);
        bj = new UUID(-2129748144642739255L, 8654423357094679310L);
        bk = new UUID(-1301668207276963122L, -6645017420763422227L);
        bl = new UUID(-7348484286925749626L, -6083546864340672619L);
    }

    private b() {
    }

    public static long a(long j2) {
        return (j2 == b || j2 == Long.MIN_VALUE) ? j2 : j2 / 1000;
    }

    public static long b(long j2) {
        return (j2 == b || j2 == Long.MIN_VALUE) ? j2 : j2 * 1000;
    }

    @TargetApi(21)
    private static int a(Context context) {
        return ((AudioManager) context.getSystemService(com.anythink.expressad.exoplayer.k.o.b)).generateAudioSessionId();
    }
}
