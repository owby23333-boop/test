package com.xiaomi.onetrack.api;

import android.os.Process;
import android.util.Log;
import com.xiaomi.ad.common.util.SignatureUtils;
import java.lang.Thread;
import java.util.Date;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes8.dex */
public class k implements Thread.UncaughtExceptionHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f7561a = "OneTrackExceptionHandler";
    private static final String c = "tombstone";
    private static final String d = ".java.xcrash";
    private static final String e = "backtrace feature id:\n\t";
    private static final String f = "error reason:\n\t";
    private static final long h = 2;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Thread.UncaughtExceptionHandler f7562b;
    private m i;
    private final Date g = new Date();
    private int j = 50;
    private int k = 50;
    private int l = 200;
    private boolean m = true;
    private boolean n = true;

    public k(m mVar) {
        this.i = mVar;
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        Log.d(com.xiaomi.onetrack.util.p.a(f7561a), "crash happened->stacktrace: " + th.getStackTrace());
        FutureTask futureTask = new FutureTask(new l(this, thread, th), null);
        com.xiaomi.onetrack.util.i.a(futureTask);
        try {
            futureTask.get(2L, TimeUnit.SECONDS);
        } catch (Exception e2) {
            Log.e(com.xiaomi.onetrack.util.p.a(f7561a), "handleException error :" + e2.getMessage());
        }
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.f7562b;
        if (uncaughtExceptionHandler != null) {
            uncaughtExceptionHandler.uncaughtException(thread, th);
        }
    }

    public void a() {
        Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
        if (defaultUncaughtExceptionHandler instanceof k) {
            return;
        }
        this.f7562b = defaultUncaughtExceptionHandler;
        Thread.setDefaultUncaughtExceptionHandler(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:88:0x008f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:98:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r8v24 */
    /* JADX WARN: Type inference failed for: r8v3, types: [java.io.RandomAccessFile] */
    /* JADX WARN: Type inference failed for: r8v6 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:67:0x0180 -> B:75:0x0191). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(java.lang.Thread r16, java.lang.Throwable r17) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 402
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.onetrack.api.k.a(java.lang.Thread, java.lang.Throwable):void");
    }

    private String a(Date date, Thread thread, String str) {
        return com.xiaomi.onetrack.util.b.a(this.g, date, "java", com.xiaomi.onetrack.f.a.e(), com.xiaomi.onetrack.util.b.a(com.xiaomi.onetrack.f.a.b())) + "pid: " + Process.myPid() + ", tid: " + Process.myTid() + ", name: " + thread.getName() + "  >>> " + com.xiaomi.onetrack.f.a.e() + " <<<\n\njava stacktrace:\n" + str + SignatureUtils.DELIMITER;
    }
}
