package com.bytedance.pangle.gc;

import android.os.Handler;
import android.os.Looper;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.util.MethodUtils;

/* JADX INFO: loaded from: classes2.dex */
public class z {
    private static Object g;
    private static Class z;

    public static final Object z() {
        if (g == null) {
            try {
                synchronized (z.class) {
                    if (g == null) {
                        if (z == null) {
                            z = Class.forName("android.app.ActivityThread");
                        }
                        g = MethodUtils.invokeStaticMethod(z, "currentActivityThread", new Object[0]);
                    }
                    if (g == null && Looper.myLooper() != Looper.getMainLooper()) {
                        final Object obj = new Object();
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.bytedance.pangle.gc.z.1
                            @Override // java.lang.Runnable
                            public void run() {
                                try {
                                    try {
                                        Object unused = z.g = MethodUtils.invokeStaticMethod(z.z, "currentActivityThread", new Object[0]);
                                        synchronized (obj) {
                                            obj.notify();
                                        }
                                    } catch (Exception e) {
                                        ZeusLogger.errReport(ZeusLogger.TAG, "ActivityThreadHelper main looper invoke currentActivityThread failed.", e);
                                        synchronized (obj) {
                                            obj.notify();
                                        }
                                    }
                                } catch (Throwable th) {
                                    synchronized (obj) {
                                        obj.notify();
                                        throw th;
                                    }
                                }
                            }
                        });
                        if (g == null) {
                            synchronized (obj) {
                                try {
                                    obj.wait(5000L);
                                } catch (InterruptedException e) {
                                    ZeusLogger.errReport(ZeusLogger.TAG, "ActivityThreadHelper currentActivityThread interruptedException failed.", e);
                                }
                            }
                        }
                    }
                }
            } catch (Exception e2) {
                ZeusLogger.errReport(ZeusLogger.TAG, "ActivityThreadHelper currentActivityThread failed.", e2);
            }
        }
        return g;
    }
}
