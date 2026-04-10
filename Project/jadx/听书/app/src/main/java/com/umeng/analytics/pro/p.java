package com.umeng.analytics.pro;

import com.umeng.analytics.AnalyticsConfig;
import java.lang.Thread;

/* JADX INFO: compiled from: CrashHandler.java */
/* JADX INFO: loaded from: classes4.dex */
public class p implements Thread.UncaughtExceptionHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Thread.UncaughtExceptionHandler f2248a;
    private t b;

    public p() {
        if (Thread.getDefaultUncaughtExceptionHandler() == this) {
            return;
        }
        this.f2248a = Thread.getDefaultUncaughtExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler(this);
    }

    public void a(t tVar) {
        this.b = tVar;
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        a(th);
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.f2248a;
        if (uncaughtExceptionHandler == null || uncaughtExceptionHandler == Thread.getDefaultUncaughtExceptionHandler()) {
            return;
        }
        this.f2248a.uncaughtException(thread, th);
    }

    private void a(Throwable th) {
        if (AnalyticsConfig.CATCH_EXCEPTION) {
            this.b.a(th);
        } else {
            this.b.a(null);
        }
    }
}
