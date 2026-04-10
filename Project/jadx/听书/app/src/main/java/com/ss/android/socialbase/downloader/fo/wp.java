package com.ss.android.socialbase.downloader.fo;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes4.dex */
public class wp {
    private static final String z = "wp";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AtomicReference<i> f2075a;
    private volatile boolean dl;
    private int e;
    private final a g;
    private AtomicReference<i> gc;
    private final ArrayList<Object> m;

    private static class z {
        public static final wp z = new wp(null);
    }

    /* synthetic */ wp(AnonymousClass1 anonymousClass1) {
        this();
    }

    public static wp z() {
        return z.z;
    }

    private wp() {
        this.g = new a(0.05d);
        this.dl = false;
        this.f2075a = new AtomicReference<>(i.UNKNOWN);
        this.m = new ArrayList<>();
    }

    public synchronized void z(long j, long j2) {
        double d = ((j * 1.0d) / j2) * 8.0d;
        if (j2 == 0 || d < 3.0d) {
            return;
        }
        try {
            this.g.z(d);
            i iVarG = g();
            if (this.dl) {
                this.e++;
                if (iVarG != this.gc.get()) {
                    this.dl = false;
                    this.e = 1;
                }
                if (this.e >= 5.0d && dl()) {
                    this.dl = false;
                    this.e = 1;
                    this.f2075a.set(this.gc.get());
                    a();
                }
                return;
            }
            if (this.f2075a.get() != iVarG) {
                this.dl = true;
                this.gc = new AtomicReference<>(iVarG);
            }
        } catch (Throwable unused) {
        }
    }

    private boolean dl() {
        double d;
        if (this.g == null) {
            return false;
        }
        try {
            int i = AnonymousClass1.z[this.f2075a.get().ordinal()];
            double d2 = 150.0d;
            if (i == 1) {
                d = 0.0d;
            } else if (i == 2) {
                d2 = 550.0d;
                d = 150.0d;
            } else if (i == 3) {
                d = 550.0d;
                d2 = 2000.0d;
            } else {
                if (i != 4) {
                    return true;
                }
                d2 = 3.4028234663852886E38d;
                d = 2000.0d;
            }
            double dZ = this.g.z();
            if (dZ > d2) {
                if (dZ > d2 * 1.25d) {
                    return true;
                }
            } else if (dZ < d * 0.8d) {
                return true;
            }
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.wp.z(th);
        }
        return false;
    }

    /* JADX INFO: renamed from: com.ss.android.socialbase.downloader.fo.wp$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] z;

        static {
            int[] iArr = new int[i.values().length];
            z = iArr;
            try {
                iArr[i.POOR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                z[i.MODERATE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                z[i.GOOD.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                z[i.EXCELLENT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public synchronized i g() {
        a aVar = this.g;
        if (aVar == null) {
            return i.UNKNOWN;
        }
        try {
            return z(aVar.z());
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.wp.z(th);
            return i.UNKNOWN;
        }
    }

    private i z(double d) {
        if (d < 0.0d) {
            return i.UNKNOWN;
        }
        if (d < 150.0d) {
            return i.POOR;
        }
        if (d < 550.0d) {
            return i.MODERATE;
        }
        if (d < 2000.0d) {
            return i.GOOD;
        }
        return i.EXCELLENT;
    }

    private void a() {
        try {
            int size = this.m.size();
            for (int i = 0; i < size; i++) {
                this.m.get(i);
                this.f2075a.get();
            }
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.wp.z(th);
        }
    }
}
