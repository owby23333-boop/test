package com.alipay.apmobilesecuritysdk.f;

import java.util.LinkedList;

/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static b f1685a = new b();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Thread f1686b = null;
    private LinkedList<Runnable> c = new LinkedList<>();

    public static b a() {
        return f1685a;
    }

    public synchronized void a(Runnable runnable) {
        this.c.add(runnable);
        if (this.f1686b == null) {
            Thread thread = new Thread(new c(this));
            this.f1686b = thread;
            thread.start();
        }
    }
}
