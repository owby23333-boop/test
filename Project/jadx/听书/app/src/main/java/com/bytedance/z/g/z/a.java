package com.bytedance.z.g.z;

import java.io.File;

/* JADX INFO: loaded from: classes2.dex */
public class a implements Runnable {
    private final dl g;
    private volatile boolean dl = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Runnable f1522a = new Runnable() { // from class: com.bytedance.z.g.z.a.1
        @Override // java.lang.Runnable
        public void run() {
            a.this.dl = false;
        }
    };
    private long z = z();

    a(dl dlVar) {
        this.g = dlVar;
        com.bytedance.z.g.gc.m.z(2L);
        com.bytedance.z.g.gc.gc.z().z(4500L, this.f1522a);
        com.bytedance.z.g.gc.gc.z().z(5000L, this, 40, 5000L);
    }

    @Override // java.lang.Runnable
    public void run() {
        String str;
        int i;
        if (this.dl) {
            return;
        }
        if (g()) {
            i = 200;
            str = "/data/anr/traces.txt";
        } else {
            str = null;
            i = 100;
        }
        if (this.g.z(i, str, 25)) {
            this.dl = true;
        }
    }

    private long z() {
        File file = new File("/data/anr/traces.txt");
        if (file.exists()) {
            return file.lastModified();
        }
        return 0L;
    }

    private boolean g() {
        File file = new File("/data/anr/traces.txt");
        return file.exists() && file.canRead();
    }
}
