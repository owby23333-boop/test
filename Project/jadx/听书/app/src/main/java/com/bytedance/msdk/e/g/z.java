package com.bytedance.msdk.e.g;

import android.text.TextUtils;
import com.bytedance.msdk.gz.l;
import com.bytedance.msdk.z.gc.dl;
import com.bytedance.sdk.component.utils.wp;
import com.umeng.analytics.pro.an;

/* JADX INFO: loaded from: classes2.dex */
public class z {
    private static volatile z g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f459a;
    private long gc;
    private String m;
    private final String z = an.aD;
    private l dl = com.bytedance.msdk.e.z.gc();

    private z() {
    }

    public static z z() {
        if (g == null) {
            synchronized (z.class) {
                if (g == null) {
                    g = new z();
                }
            }
        }
        return g;
    }

    public void z(long j) {
        try {
            if (this.dl.g("first_install_time", -1L) == -1) {
                long jG = com.bytedance.msdk.e.z.z().g("first_install_time", -1L);
                if (jG != -1) {
                    j = jG;
                }
                this.dl.z("first_install_time", j);
            }
        } catch (Throwable th) {
            wp.z(th);
        }
    }

    public long g() {
        try {
            long jG = this.dl.g("first_install_time", -1L);
            if (jG == -1) {
                jG = com.bytedance.msdk.e.z.z().g("first_install_time", -1L);
                if (jG == -1) {
                    jG = System.currentTimeMillis();
                }
                this.dl.z("first_install_time", jG);
            }
            return jG;
        } catch (Throwable th) {
            wp.z(th);
            return 0L;
        }
    }

    public synchronized void dl() {
        this.dl.z("discard_num", this.dl.g("discard_num", 0) + 1);
    }

    public synchronized int a() {
        return this.dl.g("discard_num", 0);
    }

    public synchronized void gc() {
        this.dl.z("discard_num", 0);
    }

    public void m() {
        this.f459a = System.currentTimeMillis();
    }

    public void e() {
        this.gc = System.currentTimeMillis();
    }

    public long gz() {
        long j = this.gc - this.f459a;
        dl.g(this.z, "InitMethodDuration = ".concat(String.valueOf(j)));
        return j;
    }

    public long fo() {
        long jCurrentTimeMillis = System.currentTimeMillis() - this.f459a;
        dl.g(this.z, "SplashRequestDuration = ".concat(String.valueOf(jCurrentTimeMillis)));
        return jCurrentTimeMillis;
    }

    public long uy() {
        long jCurrentTimeMillis = System.currentTimeMillis() - this.f459a;
        dl.g(this.z, "SplashFillDuration = ".concat(String.valueOf(jCurrentTimeMillis)));
        return jCurrentTimeMillis;
    }

    public void z(String str) {
        this.m = str;
    }

    public boolean kb() {
        return TextUtils.isEmpty(this.m);
    }

    public boolean wp() {
        boolean zEquals = TextUtils.equals(this.m, com.bytedance.msdk.gc.z.dl);
        dl.g(this.z, "canUploadInitDuration = " + zEquals + " 当sessionId = " + com.bytedance.msdk.gc.z.dl + " 存储的sessionId = " + this.m);
        return !zEquals;
    }
}
