package com.ss.android.socialbase.downloader.network;

import com.yuewen.w51;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes4.dex */
public class wu {
    private static final String e = "wu";
    private final tg bf;
    private volatile boolean d;
    private AtomicReference<xu> ga;
    private int p;
    private final AtomicReference<xu> tg;
    private final ArrayList<bf> vn;

    /* JADX INFO: renamed from: com.ss.android.socialbase.downloader.network.wu$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] e;

        static {
            int[] iArr = new int[xu.values().length];
            e = iArr;
            try {
                iArr[xu.POOR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                e[xu.MODERATE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                e[xu.GOOD.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                e[xu.EXCELLENT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public interface bf {
        void e(xu xuVar);
    }

    public static class e {
        public static final wu e = new wu(null);
    }

    public /* synthetic */ wu(AnonymousClass1 anonymousClass1) {
        this();
    }

    private boolean d() {
        double d;
        if (this.bf == null) {
            return false;
        }
        try {
            int i = AnonymousClass1.e[this.tg.get().ordinal()];
            double d2 = 150.0d;
            if (i == 1) {
                d = w51.l;
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
            double dE = this.bf.e();
            if (dE > d2) {
                if (dE > d2 * 1.25d) {
                    return true;
                }
            } else if (dE < d * 0.8d) {
                return true;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return false;
    }

    public static wu e() {
        return e.e;
    }

    private void tg() {
        try {
            int size = this.vn.size();
            for (int i = 0; i < size; i++) {
                this.vn.get(i).e(this.tg.get());
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public synchronized xu bf() {
        tg tgVar = this.bf;
        if (tgVar == null) {
            return xu.UNKNOWN;
        }
        try {
            return e(tgVar.e());
        } catch (Throwable th) {
            th.printStackTrace();
            return xu.UNKNOWN;
        }
    }

    private wu() {
        this.bf = new tg(0.05d);
        this.d = false;
        this.tg = new AtomicReference<>(xu.UNKNOWN);
        this.vn = new ArrayList<>();
    }

    public synchronized void e(long j, long j2) {
        xu xuVarBf;
        double d = ((j * 1.0d) / j2) * 8.0d;
        if (j2 == 0 || d < 3.0d) {
            return;
        }
        try {
            this.bf.e(d);
            xuVarBf = bf();
        } catch (Throwable unused) {
        }
        if (!this.d) {
            if (this.tg.get() != xuVarBf) {
                this.d = true;
                this.ga = new AtomicReference<>(xuVarBf);
            }
            return;
        }
        this.p++;
        if (xuVarBf != this.ga.get()) {
            this.d = false;
            this.p = 1;
        }
        if (this.p >= 5.0d && d()) {
            this.d = false;
            this.p = 1;
            this.tg.set(this.ga.get());
            tg();
        }
    }

    private xu e(double d) {
        if (d < w51.l) {
            return xu.UNKNOWN;
        }
        if (d < 150.0d) {
            return xu.POOR;
        }
        if (d < 550.0d) {
            return xu.MODERATE;
        }
        if (d < 2000.0d) {
            return xu.GOOD;
        }
        return xu.EXCELLENT;
    }
}
