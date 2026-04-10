package com.kwad.sdk.crash.handler;

import android.os.Build;
import android.os.Looper;
import android.os.MessageQueue;
import com.kwad.sdk.crash.model.message.ExceptionMessage;
import com.kwad.sdk.crash.model.message.NativeExceptionMessage;
import com.kwad.sdk.crash.report.g;
import java.io.File;
import java.util.concurrent.CountDownLatch;

/* JADX INFO: loaded from: classes4.dex */
public final class NativeCrashHandler extends b {
    private static final String NATIVE_CRASH_HAPPENED_BEGIN = "------ Native Crash Happened Begin ------\n";
    private static final String TAG = "NativeCrashHandler";
    private static ExceptionMessage mMessage = new NativeExceptionMessage();
    private File mMessageFile;

    public static native void doCrash();

    public static native void doFakeCrash();

    public static native void doMemoryCorruption();

    public static native void doNativeFdOverLimitCrash();

    public static native void install(String str, String str2, int i);

    @Override // com.kwad.sdk.crash.handler.b
    protected final int getCrashType() {
        return 4;
    }

    static class a {
        private static final NativeCrashHandler aPh = new NativeCrashHandler();
    }

    public static NativeCrashHandler getInstance() {
        return a.aPh;
    }

    private NativeCrashHandler() {
    }

    public final void init(File file, boolean z, final String str, com.kwad.sdk.crash.report.c cVar) {
        super.init(file, null, cVar);
        if (com.kwad.sdk.crash.b.La()) {
            this.mLogDir = file;
            if (!this.mLogDir.exists()) {
                this.mLogDir.mkdirs();
            }
            this.mDumpDir = new File(file, FILE_NAME_BASE + "-native-0");
            this.mLogcatFile = new File(this.mDumpDir, "logcat");
            this.mMessageFile = new File(this.mDumpDir, "message");
            this.mJavaTraceFile = new File(this.mDumpDir, "all_java_backtrace");
            this.mMemoryInfoFile = new File(this.mDumpDir, "meminfo");
            try {
                Looper.getMainLooper().getQueue().addIdleHandler(new MessageQueue.IdleHandler() { // from class: com.kwad.sdk.crash.handler.NativeCrashHandler.1
                    @Override // android.os.MessageQueue.IdleHandler
                    public final boolean queueIdle() {
                        com.kwad.sdk.core.d.c.d(NativeCrashHandler.TAG, "native install in idle" + NativeCrashHandler.this.mDumpDir.getPath());
                        NativeCrashHandler.install(NativeCrashHandler.this.mDumpDir.getPath(), str, Build.VERSION.SDK_INT);
                        return false;
                    }
                });
            } catch (Throwable unused) {
                getUploader();
            }
        }
    }

    /* JADX INFO: renamed from: com.kwad.sdk.crash.handler.NativeCrashHandler$2, reason: invalid class name */
    final class AnonymousClass2 implements Runnable {
        final /* synthetic */ String aPf;

        AnonymousClass2(String str) {
            this.aPf = str;
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.kwad.sdk.core.d.c.e(NativeCrashHandler.TAG, "native install in main:" + NativeCrashHandler.this.mDumpDir.getPath());
            NativeCrashHandler.install(NativeCrashHandler.this.mDumpDir.getPath(), this.aPf, Build.VERSION.SDK_INT);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x018a A[Catch: all -> 0x019f, DONT_GENERATE, TRY_LEAVE, TryCatch #5 {all -> 0x019f, blocks: (B:29:0x0135, B:30:0x0160, B:32:0x018a), top: B:80:0x0135, outer: #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0222 A[Catch: all -> 0x0237, TRY_LEAVE, TryCatch #1 {all -> 0x0237, blocks: (B:44:0x01cd, B:45:0x01f8, B:47:0x0222), top: B:73:0x01cd, outer: #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:83:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static synchronized void onCallFromNative(long r9) {
        /*
            Method dump skipped, instruction units count: 699
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.crash.handler.NativeCrashHandler.onCallFromNative(long):void");
    }

    @Override // com.kwad.sdk.crash.handler.b
    protected final void reportException(File[] fileArr, CountDownLatch countDownLatch) {
        g gVar = new g();
        gVar.a(getUploader());
        for (File file : fileArr) {
            gVar.a(file, countDownLatch);
        }
    }
}
