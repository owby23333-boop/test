package com.bytedance.sdk.component.gz.g.e;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.bytedance.sdk.component.gz.z.gc;

/* JADX INFO: loaded from: classes2.dex */
public class z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile z f731a = null;
    private static int dl = 3000;
    private volatile Handler g = null;
    private Looper gc;
    private volatile HandlerThread z;

    public static z z(gc gcVar) {
        if (f731a == null) {
            synchronized (z.class) {
                if (f731a == null) {
                    f731a = new z(gcVar);
                }
            }
        }
        return f731a;
    }

    private z(gc gcVar) {
        this.z = null;
        this.gc = null;
        if (gcVar == null || gcVar.a() == null || gcVar.a().pf() == null) {
            this.z = new HandlerThread("csj_ad_log", 10);
            this.z.start();
        } else {
            this.gc = gcVar.a().pf();
        }
    }

    public Handler z() {
        if (this.gc != null) {
            if (this.g == null) {
                synchronized (z.class) {
                    if (this.g == null) {
                        this.g = new Handler(this.gc);
                    }
                }
            }
        } else if (this.z == null || !this.z.isAlive()) {
            synchronized (z.class) {
                if (this.z == null || !this.z.isAlive()) {
                    this.z = new HandlerThread("csj_init_handle", -1);
                    this.z.start();
                    this.g = new Handler(this.z.getLooper());
                }
            }
        } else if (this.g == null) {
            synchronized (z.class) {
                if (this.g == null) {
                    this.g = new Handler(this.z.getLooper());
                }
            }
        }
        return this.g;
    }

    public int g() {
        if (dl <= 0) {
            dl = 3000;
        }
        return dl;
    }
}
