package com.kwad.sdk.api.loader;

import android.content.Context;
import java.lang.Thread;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
public class d implements Thread.UncaughtExceptionHandler {
    private static d Zg;
    private Thread.UncaughtExceptionHandler Zh;
    private int Zi;
    private long Zk;
    private Context mContext;
    private boolean DEBUG = false;
    private final AtomicBoolean Zj = new AtomicBoolean();

    private d(Context context) {
        this.mContext = context;
    }

    public static d ax(Context context) {
        if (Zg == null) {
            synchronized (d.class) {
                if (Zg == null) {
                    Zg = new d(context);
                }
            }
        }
        return Zg;
    }

    public final void aO(int i2) {
        this.Zk = System.currentTimeMillis();
        this.Zi = i2;
        boolean z2 = this.DEBUG;
    }

    public final void cancel() {
        boolean z2 = this.DEBUG;
        this.Zj.set(true);
    }

    public final void setDefaultUncaughtExceptionHandler(Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        if (uncaughtExceptionHandler != this) {
            this.Zh = uncaughtExceptionHandler;
        }
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        try {
            if (this.DEBUG) {
                String str = "AutoRevertHandler uncaughtException, mStartCheckTime:" + this.Zk + ",mMaxDuration:" + this.Zi + ",mIsCancel:" + this.Zj.get();
            }
            if (!this.Zj.get() && this.Zk > 0 && System.currentTimeMillis() - this.Zk <= this.Zi) {
                Boolean bool = (Boolean) com.kwad.sdk.api.c.a("filterStack", th);
                boolean zBooleanValue = bool != null ? bool.booleanValue() : true;
                if (this.mContext != null && zBooleanValue) {
                    t.a(this.mContext, g.Zp, true);
                }
            }
        } catch (Throwable th2) {
            try {
                th2.printStackTrace();
                Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.Zh;
                if (uncaughtExceptionHandler != null) {
                    uncaughtExceptionHandler.uncaughtException(thread, th);
                }
            } finally {
                Thread.UncaughtExceptionHandler uncaughtExceptionHandler2 = this.Zh;
                if (uncaughtExceptionHandler2 != null) {
                    uncaughtExceptionHandler2.uncaughtException(thread, th);
                }
            }
        }
    }
}
