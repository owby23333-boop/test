package com.liulishuo.filedownloader;

import android.content.Context;

/* JADX INFO: compiled from: FileDownloader.java */
/* JADX INFO: loaded from: classes3.dex */
public class q {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Object f17277c = new Object();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Object f17278d = new Object();
    private w a;
    private v b;

    /* JADX INFO: compiled from: FileDownloader.java */
    private static final class a {
        private static final q a = new q();
    }

    public static void a(Context context) {
        com.liulishuo.filedownloader.h0.c.a(context.getApplicationContext());
    }

    public static q d() {
        return a.a;
    }

    w b() {
        if (this.a == null) {
            synchronized (f17277c) {
                if (this.a == null) {
                    this.a = new c0();
                }
            }
        }
        return this.a;
    }

    public void bindService() {
        if (c()) {
            return;
        }
        m.c().a(com.liulishuo.filedownloader.h0.c.a());
    }

    public boolean c() {
        return m.c().isConnected();
    }

    public com.liulishuo.filedownloader.a a(String str) {
        return new c(str);
    }

    public void a(e eVar) {
        f.a().a("event.service.connect.changed", eVar);
    }

    public void a(boolean z2) {
        m.c().stopForeground(z2);
    }

    public void bindService(Runnable runnable) {
        if (c()) {
            runnable.run();
        } else {
            m.c().a(com.liulishuo.filedownloader.h0.c.a(), runnable);
        }
    }

    v a() {
        if (this.b == null) {
            synchronized (f17278d) {
                if (this.b == null) {
                    this.b = new z();
                    a((e) this.b);
                }
            }
        }
        return this.b;
    }
}
