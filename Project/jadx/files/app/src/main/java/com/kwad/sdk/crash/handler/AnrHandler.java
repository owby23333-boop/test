package com.kwad.sdk.crash.handler;

import android.app.ActivityManager;
import android.os.Build;
import android.os.FileObserver;
import android.os.Looper;
import android.os.Process;
import android.util.Printer;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.crash.e;
import com.kwad.sdk.crash.f;
import com.kwad.sdk.crash.model.message.AnrExceptionMessage;
import com.kwad.sdk.crash.model.message.AnrReason;
import com.kwad.sdk.crash.utils.g;
import com.kwad.sdk.utils.SystemUtil;
import com.kwad.sdk.utils.p;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes3.dex */
@Keep
public final class AnrHandler extends b {
    private static final String ANR_HAPPENED_BEGIN = "------ ANR Happened Begin ------\n";
    private static final String DEFAULT_TRACE_ROOT = "/data/anr/";
    private static final long GET_REASON_INTERVAL = 500;
    private static final long PARSE_TRACE_INTERVAL = 10000;
    private static final String TAG = "AnrHandler";
    private static final long TRY_TIMES = 20;
    private static long sLastTime;
    private FileObserver mTraceFileObserver;
    private static final int MY_PID = Process.myPid();
    private static final Pattern PID_PATTERN = Pattern.compile("-{5}\\spid\\s\\d+\\sat\\s\\d+-\\d+-\\d+\\s\\d{2}:\\d{2}:\\d{2}\\s-{5}");
    private static final boolean DUMP_FROM_SIG_QUIT = SystemUtil.cd(21);

    static class a {
        private static final AnrHandler aqM = new AnrHandler();
    }

    private AnrHandler() {
    }

    private static synchronized void dumpAnr(@Nullable String str, int i2) {
        com.kwad.sdk.core.d.b.d(TAG, "ANR dumpAnr tracePath=" + str + " index=" + i2);
        AnrExceptionMessage anrExceptionMessage = new AnrExceptionMessage();
        File file = getInstance().mLogDir;
        boolean z2 = true;
        try {
            if (!file.exists() && !file.mkdirs()) {
                com.kwad.sdk.core.d.b.d(TAG, "ANR dumpAnr create dir failed.");
                anrExceptionMessage.mErrorMessage += "create " + file.getPath() + " failed!\n";
                z2 = false;
            }
            if (str != null && z2) {
                StringBuilder sb = new StringBuilder();
                getInstance();
                sb.append(b.FILE_NAME_BASE);
                sb.append("-");
                sb.append(i2);
                sb.append(".dump");
                p.d(new File(str), new File(file, sb.toString()));
                StringBuilder sb2 = new StringBuilder();
                getInstance();
                sb2.append(b.FILE_NAME_BASE);
                sb2.append("-");
                sb2.append(i2);
                sb2.append(com.anythink.china.common.a.a.f6394f);
                g.z(new File(file, sb2.toString()));
            }
            g.b(null, anrExceptionMessage, e.zJ().getContext());
            g.a(anrExceptionMessage, 3);
            if (getInstance().mExceptionListener != null) {
                getInstance().mExceptionListener.a(getInstance().getCrashType(), anrExceptionMessage);
            }
        } catch (Throwable th) {
            try {
                anrExceptionMessage.mErrorMessage += th;
                com.kwad.sdk.core.d.b.printStackTraceOnly(th);
            } finally {
                dumpAnrReason(str, i2, anrExceptionMessage, z2);
            }
        }
    }

    private static void dumpAnrReason(@Nullable String str, int i2, @NonNull AnrExceptionMessage anrExceptionMessage, boolean z2) throws Throwable {
        com.kwad.sdk.core.d.b.d(TAG, "ANR dumpAnrReason tracePath=" + str + " index=" + i2 + " dirReady=" + z2);
        com.kwad.sdk.crash.report.e uploader = getInstance().getUploader();
        try {
            File file = getInstance().mLogDir;
            final StringBuilder sb = new StringBuilder();
            Looper.getMainLooper().dump(new Printer() { // from class: com.kwad.sdk.crash.handler.AnrHandler.2
                @Override // android.util.Printer
                public final void println(String str2) {
                    StringBuilder sb2 = sb;
                    sb2.append(str2);
                    sb2.append("\n");
                }
            }, "");
            anrExceptionMessage.mMessageQueueDetail = sb.substring(0, sb.length() - 1);
            String string = anrExceptionMessage.toJson().toString();
            StringBuilder sb2 = new StringBuilder();
            getInstance();
            sb2.append(b.FILE_NAME_BASE);
            sb2.append("-");
            sb2.append(i2);
            sb2.append(".dump");
            File file2 = new File(file, sb2.toString());
            if (z2) {
                StringBuilder sb3 = new StringBuilder();
                getInstance();
                sb3.append(b.FILE_NAME_BASE);
                sb3.append("-");
                sb3.append(i2);
                sb3.append(".msg");
                File file3 = new File(file, sb3.toString());
                StringBuilder sb4 = new StringBuilder();
                getInstance();
                sb4.append(b.FILE_NAME_BASE);
                sb4.append("-");
                sb4.append(i2);
                sb4.append(".minfo");
                File file4 = new File(file, sb4.toString());
                g.a(file3, string);
                getInstance().backupLogFiles(file);
                if (uploader != null) {
                    new StringBuilder(ANR_HAPPENED_BEGIN).append(anrExceptionMessage);
                }
                g.a(uploader, TAG, file2);
                getInstance().uploadRemainingExceptions();
                g.C(file4);
            } else if (uploader != null) {
                if (str != null) {
                    uploader.a(anrExceptionMessage, null);
                }
                new StringBuilder(ANR_HAPPENED_BEGIN).append(anrExceptionMessage);
            }
            StringBuilder sb5 = new StringBuilder();
            getInstance();
            sb5.append(b.FILE_NAME_BASE);
            sb5.append("-");
            sb5.append(i2);
            sb5.append(".anr");
            getAnrReason(str, new File(file, sb5.toString()));
        } catch (Throwable th) {
            com.kwad.sdk.core.d.b.printStackTraceOnly(th);
            if (uploader != null) {
                g.j(th);
            }
        }
    }

    private static void getAnrReason(@Nullable String str, final File file) {
        com.kwad.sdk.core.d.b.d(TAG, "ANR getAnrReason");
        if (str == null) {
            com.kwad.sdk.utils.g.schedule(new Runnable() { // from class: com.kwad.sdk.crash.handler.AnrHandler.3
                @Override // java.lang.Runnable
                public final void run() {
                    AnrHandler.getAnrReasonInner(null, file);
                }
            }, 0L, TimeUnit.MILLISECONDS);
        } else {
            getAnrReasonInner(str, file);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void getAnrReasonInner(@Nullable String str, File file) {
        com.kwad.sdk.core.d.b.d(TAG, "ANR getAnrReasonInner");
        com.kwad.sdk.crash.report.e uploader = getInstance().getUploader();
        if (str != null) {
            try {
                long jLastModified = new File(str).lastModified();
                if (Math.abs(jLastModified - sLastTime) < PARSE_TRACE_INTERVAL) {
                    return;
                } else {
                    sLastTime = jLastModified;
                }
            } catch (Throwable unused) {
                return;
            }
        }
        ActivityManager activityManager = (ActivityManager) e.zJ().getContext().getSystemService("activity");
        ActivityManager.ProcessErrorStateInfo processErrorStateInfo = null;
        if (activityManager == null) {
            return;
        }
        for (int i2 = 0; i2 < 20; i2++) {
            List<ActivityManager.ProcessErrorStateInfo> processesInErrorState = activityManager.getProcessesInErrorState();
            if (processesInErrorState != null) {
                Iterator<ActivityManager.ProcessErrorStateInfo> it = processesInErrorState.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    ActivityManager.ProcessErrorStateInfo next = it.next();
                    if (next.condition == 2) {
                        processErrorStateInfo = next;
                        break;
                    }
                }
            }
            if (processErrorStateInfo != null) {
                break;
            }
            Thread.sleep(500L);
        }
        if (processErrorStateInfo == null) {
            return;
        }
        if (processErrorStateInfo.pid != MY_PID) {
            if (uploader != null) {
                new StringBuilder("other process anr:\n").append(processErrorStateInfo.shortMsg);
            }
        } else {
            AnrReason anrReason = new AnrReason();
            anrReason.mTag = processErrorStateInfo.tag;
            anrReason.mShortMsg = processErrorStateInfo.shortMsg;
            anrReason.mLongMsg = processErrorStateInfo.longMsg;
            g.a(file, anrReason.toJson().toString());
        }
    }

    public static AnrHandler getInstance() {
        return a.aqM;
    }

    public static native void install(String str, int i2);

    @Keep
    public static void onCallFromNative(int i2) {
        com.kwad.sdk.core.d.b.d(TAG, "ANR onCallFromNative index=" + i2);
        dumpAnr(null, i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onTraceFileWritten(String str) {
        com.kwad.sdk.core.d.b.d(TAG, "ANR onTraceFileWritten");
        if (parseTraceFile(str)) {
            dumpAnr(str, this.mIndex.getAndIncrement());
        }
    }

    private boolean parseTraceFile(String str) throws Throwable {
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2 = null;
        try {
            try {
                bufferedReader = new BufferedReader(new FileReader(str));
                int i2 = -1;
                while (true) {
                    try {
                        String line = bufferedReader.readLine();
                        if (line == null) {
                            break;
                        }
                        if (PID_PATTERN.matcher(line).matches()) {
                            i2 = Integer.parseInt(line.split("\\s")[2]);
                            break;
                        }
                    } catch (FileNotFoundException unused) {
                        bufferedReader2 = bufferedReader;
                        getUploader();
                        com.kwad.sdk.crash.utils.b.closeQuietly(bufferedReader2);
                        return false;
                    } catch (IOException unused2) {
                        bufferedReader2 = bufferedReader;
                        getUploader();
                        com.kwad.sdk.crash.utils.b.closeQuietly(bufferedReader2);
                        return false;
                    } catch (Throwable th) {
                        th = th;
                        com.kwad.sdk.crash.utils.b.closeQuietly(bufferedReader);
                        throw th;
                    }
                }
                boolean z2 = i2 == MY_PID;
                com.kwad.sdk.crash.utils.b.closeQuietly(bufferedReader);
                return z2;
            } catch (Throwable th2) {
                th = th2;
                bufferedReader = bufferedReader2;
            }
        } catch (FileNotFoundException | IOException unused3) {
        }
    }

    private void watchTraceFile() {
        com.kwad.sdk.core.d.b.d(TAG, "ANR watchTraceFile");
        this.mTraceFileObserver = new FileObserver(DEFAULT_TRACE_ROOT, 8) { // from class: com.kwad.sdk.crash.handler.AnrHandler.1
            @Override // android.os.FileObserver
            public final void onEvent(int i2, @Nullable String str) {
                if (str != null) {
                    AnrHandler.this.onTraceFileWritten(AnrHandler.DEFAULT_TRACE_ROOT + str);
                }
            }
        };
        try {
            this.mTraceFileObserver.startWatching();
        } catch (Throwable unused) {
            getInstance().getUploader();
        }
    }

    @Override // com.kwad.sdk.crash.handler.b
    protected final int getCrashType() {
        return 3;
    }

    @Override // com.kwad.sdk.crash.handler.b
    public final void init(File file, f fVar, com.kwad.sdk.crash.report.e eVar) {
        super.init(file, fVar, eVar);
        if (com.kwad.sdk.crash.b.zt()) {
            com.kwad.sdk.core.d.b.d(TAG, "ANR init");
            this.mLogDir = file;
            if (!this.mLogDir.exists()) {
                this.mLogDir.mkdirs();
            }
            File file2 = new File(this.mLogDir, b.FILE_NAME_BASE);
            if (!DUMP_FROM_SIG_QUIT) {
                watchTraceFile();
                return;
            }
            try {
                install(file2.getPath(), Build.VERSION.SDK_INT);
            } catch (Throwable unused) {
                getUploader();
            }
        }
    }

    @Override // com.kwad.sdk.crash.handler.b
    protected final void reportException(@NonNull File[] fileArr, @Nullable CountDownLatch countDownLatch) {
        com.kwad.sdk.crash.report.b bVar = new com.kwad.sdk.crash.report.b();
        bVar.a(getUploader());
        for (File file : fileArr) {
            bVar.a(file, countDownLatch);
        }
    }
}
