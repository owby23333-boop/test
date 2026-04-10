package com.kwad.sdk.crash;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.crash.g;
import com.kwad.sdk.crash.handler.AnrHandler;
import com.kwad.sdk.crash.handler.NativeCrashHandler;
import com.kwad.sdk.crash.model.message.ExceptionMessage;
import com.kwad.sdk.utils.x;
import java.io.File;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
public final class b {
    private static volatile boolean apX = false;
    private static volatile boolean apY = false;
    private static Handler Ss = new Handler(Looper.getMainLooper());
    private static final AtomicBoolean ISLOADED = new AtomicBoolean(false);
    private static final String[] apZ = {"c++_shared", "kscutils", "exception-handler"};
    private static boolean aqa = false;
    private static boolean aqb = false;

    public static void a(@NonNull c cVar) {
        if (cVar.context == null || apY) {
            return;
        }
        apY = true;
        aqa = cVar.aqa;
        aqb = cVar.aqb;
        try {
            com.kwad.sdk.crash.utils.e.init(cVar.context);
            com.kwad.sdk.crash.kwai.a.init(cVar.context, cVar.aqm);
            e.zJ().a(cVar);
            bw(cVar.context);
            if (!bv(cVar.context) && (aqa || aqb)) {
                g.a(cVar, new g.a() { // from class: com.kwad.sdk.crash.b.1
                    @Override // com.kwad.sdk.crash.g.a
                    public final void zE() {
                        b.Ss.post(new Runnable() { // from class: com.kwad.sdk.crash.b.1.1
                            @Override // java.lang.Runnable
                            public final void run() {
                                if (b.aqa) {
                                    b.zu();
                                }
                                if (b.aqb) {
                                    b.c(false, "/sdcard/");
                                }
                            }
                        });
                    }
                });
            }
            zv();
        } catch (Throwable unused) {
        }
    }

    private static boolean bv(Context context) {
        return context == null || x.ce(context) >= 3;
    }

    private static void bw(Context context) {
        com.kwad.sdk.crash.handler.c.zZ().init(com.kwad.sdk.crash.kwai.a.zU(), new f() { // from class: com.kwad.sdk.crash.b.3
            @Override // com.kwad.sdk.crash.f
            public final void a(int i2, ExceptionMessage exceptionMessage) {
                e.zJ().b(i2, exceptionMessage);
            }
        }, new com.kwad.sdk.crash.report.c() { // from class: com.kwad.sdk.crash.b.4
            @Override // com.kwad.sdk.crash.report.e
            public final void a(ExceptionMessage exceptionMessage, @Nullable CountDownLatch countDownLatch) {
                a(exceptionMessage, 1, countDownLatch);
            }

            @Override // com.kwad.sdk.crash.report.e
            public final File zF() {
                return new File(com.kwad.sdk.crash.kwai.a.zT(), "java_crash/upload");
            }
        });
        Thread.setDefaultUncaughtExceptionHandler(new com.kwad.sdk.crash.handler.d(context));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void c(boolean z2, String str) {
        if (com.kwad.sdk.crash.kwai.a.v(com.kwad.sdk.crash.kwai.a.zW())) {
            NativeCrashHandler.getInstance().init(com.kwad.sdk.crash.kwai.a.zW(), z2, str, new com.kwad.sdk.crash.report.c() { // from class: com.kwad.sdk.crash.b.7
                @Override // com.kwad.sdk.crash.report.e
                public final void a(ExceptionMessage exceptionMessage, @Nullable CountDownLatch countDownLatch) {
                    com.kwad.sdk.core.d.b.d("ExceptionCollector", "Native upload");
                    a(exceptionMessage, 4, countDownLatch);
                }

                @Override // com.kwad.sdk.crash.report.e
                public final File zF() {
                    return new File(com.kwad.sdk.crash.kwai.a.zT(), "native_crash_log/upload");
                }
            });
        }
    }

    public static void f(@NonNull final Throwable th) {
        com.kwad.sdk.utils.g.execute(new Runnable() { // from class: com.kwad.sdk.crash.b.2
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    if (com.kwad.sdk.crash.a.a.g(th)) {
                        com.kwad.sdk.crash.handler.a.h(new SdkCaughtException(th));
                    }
                } catch (Throwable th2) {
                    com.kwad.sdk.core.d.b.printStackTrace(th2);
                }
            }
        });
    }

    public static boolean zt() {
        if (ISLOADED.get()) {
            return true;
        }
        try {
            for (String str : apZ) {
                System.loadLibrary(str);
            }
            ISLOADED.set(true);
            return true;
        } catch (Throwable unused) {
            ISLOADED.set(false);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void zu() {
        AnrHandler.getInstance().init(com.kwad.sdk.crash.kwai.a.zV(), new f() { // from class: com.kwad.sdk.crash.b.5
            @Override // com.kwad.sdk.crash.f
            public final void a(int i2, ExceptionMessage exceptionMessage) {
                e.zJ().b(i2, exceptionMessage);
            }
        }, new com.kwad.sdk.crash.report.c() { // from class: com.kwad.sdk.crash.b.6
            @Override // com.kwad.sdk.crash.report.e
            public final void a(ExceptionMessage exceptionMessage, @Nullable CountDownLatch countDownLatch) {
                com.kwad.sdk.core.d.b.d("ExceptionCollector", "ANR upload");
                a(exceptionMessage, 3, countDownLatch);
            }

            @Override // com.kwad.sdk.crash.report.e
            public final File zF() {
                return new File(com.kwad.sdk.crash.kwai.a.zT(), "anr_log/upload");
            }
        });
    }

    private static synchronized void zv() {
        if (!apX) {
            apX = true;
            com.kwad.sdk.core.threads.a.xU().postDelayed(new Runnable() { // from class: com.kwad.sdk.crash.b.8
                @Override // java.lang.Runnable
                public final void run() {
                    try {
                        b.zw();
                    } catch (Throwable unused) {
                    }
                }
            }, TimeUnit.SECONDS.toMillis(d.aqz));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void zw() {
        zx();
        if (aqa) {
            zy();
        }
        if (aqb) {
            zz();
        }
    }

    private static void zx() {
        com.kwad.sdk.core.d.b.d("ExceptionCollector", "reportJavaException");
        com.kwad.sdk.crash.report.f fVar = new com.kwad.sdk.crash.report.f();
        fVar.a(com.kwad.sdk.crash.handler.c.zZ().getUploader());
        fVar.x(com.kwad.sdk.crash.kwai.a.zU());
    }

    private static void zy() {
        com.kwad.sdk.core.d.b.d("ExceptionCollector", "reportAnrException");
        com.kwad.sdk.crash.report.b bVar = new com.kwad.sdk.crash.report.b();
        bVar.a(AnrHandler.getInstance().getUploader());
        bVar.x(com.kwad.sdk.crash.kwai.a.zV());
    }

    private static void zz() {
        com.kwad.sdk.core.d.b.d("ExceptionCollector", "reportNativeException");
        com.kwad.sdk.crash.report.g gVar = new com.kwad.sdk.crash.report.g();
        gVar.a(NativeCrashHandler.getInstance().getUploader());
        gVar.x(com.kwad.sdk.crash.kwai.a.zW());
    }
}
