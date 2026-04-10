package com.kwad.sdk.api.loader;

import android.content.Context;
import android.util.Log;
import java.lang.Thread;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes4.dex */
public class f implements Thread.UncaughtExceptionHandler {
    private static f atX;
    private Thread.UncaughtExceptionHandler atY;
    private int atZ;
    private long aub;
    private Context mContext;
    private boolean DEBUG = false;
    private final AtomicBoolean aua = new AtomicBoolean();

    public static f aW(Context context) {
        if (atX == null) {
            synchronized (f.class) {
                if (atX == null) {
                    atX = new f(context);
                }
            }
        }
        return atX;
    }

    private f(Context context) {
        this.mContext = context;
    }

    public final void setDefaultUncaughtExceptionHandler(Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        if (uncaughtExceptionHandler != this) {
            this.atY = uncaughtExceptionHandler;
        }
    }

    public final void cp(int i) {
        this.aub = System.currentTimeMillis();
        this.atZ = i;
        if (this.DEBUG) {
            Log.d("test.chen", "startCheck:");
        }
    }

    public final void cancel() {
        if (this.DEBUG) {
            Log.d("test.chen", "AutoRevertHandler cancel:");
        }
        this.aua.set(true);
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        try {
            if (this.DEBUG) {
                Log.d("test.chen", "AutoRevertHandler uncaughtException, mStartCheckTime:" + this.aub + ",mMaxDuration:" + this.atZ + ",mIsCancel:" + this.aua.get());
            }
            if (!this.aua.get() && this.aub > 0 && System.currentTimeMillis() - this.aub <= this.atZ) {
                Boolean bool = (Boolean) com.kwad.sdk.api.c.g("filterStack", th);
                boolean zBooleanValue = bool != null ? bool.booleanValue() : true;
                Context context = this.mContext;
                if (context != null && zBooleanValue) {
                    b.a(context, i.auf, true);
                }
            }
            Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.atY;
            if (uncaughtExceptionHandler != null) {
                uncaughtExceptionHandler.uncaughtException(thread, th);
            }
        } catch (Throwable th2) {
            try {
                th2.printStackTrace();
                Thread.UncaughtExceptionHandler uncaughtExceptionHandler2 = this.atY;
                if (uncaughtExceptionHandler2 != null) {
                    uncaughtExceptionHandler2.uncaughtException(thread, th);
                }
            } catch (Throwable th3) {
                if (this.atY != null) {
                    this.atY.uncaughtException(thread, th);
                }
                throw th3;
            }
        }
    }
}
