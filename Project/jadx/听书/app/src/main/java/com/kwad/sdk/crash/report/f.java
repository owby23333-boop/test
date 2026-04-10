package com.kwad.sdk.crash.report;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.kwad.sdk.crash.model.message.ExceptionMessage;
import com.kwad.sdk.crash.model.message.JavaExceptionMessage;
import com.kwad.sdk.crash.model.message.MemoryInfo;
import com.kwad.sdk.crash.model.message.ThreadInfo;
import com.kwad.sdk.utils.w;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class f extends d {
    @Override // com.kwad.sdk.crash.report.d
    protected final ExceptionMessage a(File file, File file2, File file3, File file4, File file5) {
        return null;
    }

    @Override // com.kwad.sdk.crash.report.d
    public final void D(File file) {
        com.kwad.sdk.core.d.c.d("AnrAndNativeAdExceptionCollector", "reportException dir =" + file);
        File[] fileArrListFiles = file.listFiles(new FileFilter() { // from class: com.kwad.sdk.crash.report.f.1
            @Override // java.io.FileFilter
            public final boolean accept(File file2) {
                return file2.getName().endsWith(".dump");
            }
        });
        if (fileArrListFiles != null) {
            for (File file2 : fileArrListFiles) {
                a(file2, (CountDownLatch) null);
            }
        }
    }

    private ExceptionMessage a(File file, File file2, String str) {
        String strW;
        JavaExceptionMessage javaExceptionMessage;
        Exception e;
        JavaExceptionMessage javaExceptionMessage2 = null;
        try {
            strW = w.W(file);
        } catch (Exception e2) {
            this.mErrorMessage += e2 + "\n";
            strW = null;
        }
        if (strW != null) {
            try {
                javaExceptionMessage = new JavaExceptionMessage();
                try {
                    javaExceptionMessage.parseJson(new JSONObject(strW));
                } catch (Exception e3) {
                    e = e3;
                    this.mErrorMessage += e + "\n";
                }
            } catch (Exception e4) {
                javaExceptionMessage = null;
                e = e4;
            }
            javaExceptionMessage2 = javaExceptionMessage;
        }
        if (javaExceptionMessage2 == null) {
            javaExceptionMessage2 = new JavaExceptionMessage();
            if (!TextUtils.isEmpty(strW)) {
                javaExceptionMessage2.mCrashDetail = strW;
                com.kwad.sdk.core.d.c.w("ExceptionJavaCrashReporter", "message.mCrashDetail:" + javaExceptionMessage2.mCrashDetail);
            }
        }
        try {
            javaExceptionMessage2.mLogUUID = com.kwad.sdk.crash.utils.g.fU(file.getName());
            new StringBuilder("------ Java Crash Report Begin ------\n").append(javaExceptionMessage2);
            b(new File(str + ".jtrace"), javaExceptionMessage2);
            a(file2, javaExceptionMessage2);
            com.kwad.sdk.crash.utils.g.a(file, javaExceptionMessage2.toString());
            com.kwad.sdk.crash.utils.g.d(file2, file);
            file.renameTo(file2);
            javaExceptionMessage2.mDumpsys = w.W(new File(str + ".minfo"));
        } catch (Throwable th) {
            this.mErrorMessage += th + "\n";
            com.kwad.sdk.core.d.c.printStackTraceOnly(th);
        }
        if (!TextUtils.isEmpty(this.mErrorMessage)) {
            javaExceptionMessage2.mErrorMessage += this.mErrorMessage;
        }
        return javaExceptionMessage2;
    }

    private static void b(File file, ExceptionMessage exceptionMessage) throws Throwable {
        try {
            MemoryInfo memoryInfo = new MemoryInfo(exceptionMessage.mMemoryInfo);
            ArrayList arrayList = new ArrayList();
            BufferedReader bufferedReader = null;
            try {
                try {
                    BufferedReader bufferedReader2 = new BufferedReader(new FileReader(file));
                    try {
                        ThreadInfo threadInfo = new ThreadInfo();
                        while (true) {
                            String line = bufferedReader2.readLine();
                            if (line != null) {
                                if (line.isEmpty()) {
                                    arrayList.add(threadInfo);
                                    threadInfo = new ThreadInfo();
                                } else if (line.startsWith("at ") || line.startsWith("(no ")) {
                                    if (threadInfo.mTrace != null) {
                                        line = threadInfo.mTrace + line;
                                    }
                                    threadInfo.mTrace = line;
                                    threadInfo.mTrace += "#";
                                } else {
                                    threadInfo.mName = line;
                                }
                            } else {
                                memoryInfo.mJavaThreads = arrayList;
                                exceptionMessage.mMemoryInfo = memoryInfo.toJson().toString();
                                com.kwad.sdk.crash.utils.b.closeQuietly(bufferedReader2);
                                return;
                            }
                        }
                    } catch (IOException e) {
                        e = e;
                        bufferedReader = bufferedReader2;
                        com.kwad.sdk.core.d.c.printStackTraceOnly(e);
                        com.kwad.sdk.crash.utils.b.closeQuietly(bufferedReader);
                    } catch (Throwable th) {
                        th = th;
                        bufferedReader = bufferedReader2;
                        com.kwad.sdk.crash.utils.b.closeQuietly(bufferedReader);
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (IOException e2) {
                e = e2;
            }
        } catch (Exception e3) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(e3);
        }
    }

    @Override // com.kwad.sdk.crash.report.d
    public final void a(File file, CountDownLatch countDownLatch) {
        String strFU = com.kwad.sdk.crash.utils.g.fU(file.getPath());
        File file2 = new File(strFU + ".msg");
        File file3 = new File(strFU + ".log");
        File file4 = new File(strFU + ".blog");
        File file5 = new File(strFU + ".jtrace");
        File file6 = new File(strFU + ".minfo");
        ArrayList arrayList = new ArrayList();
        try {
            ExceptionMessage exceptionMessageA = a(file, file3, strFU);
            if (exceptionMessageA == null) {
                try {
                    w.delete(file.getPath());
                    w.delete(file3.getPath());
                    w.delete(file4.getPath());
                    w.delete(file2.getPath());
                    w.delete(file5.getPath());
                    w.delete(file6.getPath());
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        w.delete(((File) it.next()).getPath());
                    }
                    com.kwad.sdk.crash.utils.g.G(com.kwad.sdk.crash.handler.b.sBackupDir);
                    return;
                } catch (Throwable th) {
                    com.kwad.sdk.core.d.c.printStackTraceOnly(th);
                    return;
                }
            }
            com.kwad.sdk.core.d.c.d("ExceptionJavaCrashReporter", "message.mCrashSource=" + exceptionMessageA.mCrashSource);
            if (exceptionMessageA.mCrashSource == 2) {
                try {
                    w.delete(file.getPath());
                    w.delete(file3.getPath());
                    w.delete(file4.getPath());
                    w.delete(file2.getPath());
                    w.delete(file5.getPath());
                    w.delete(file6.getPath());
                    Iterator it2 = arrayList.iterator();
                    while (it2.hasNext()) {
                        w.delete(((File) it2.next()).getPath());
                    }
                    com.kwad.sdk.crash.utils.g.G(com.kwad.sdk.crash.handler.b.sBackupDir);
                    return;
                } catch (Throwable th2) {
                    com.kwad.sdk.core.d.c.printStackTraceOnly(th2);
                    return;
                }
            }
            this.mUploader.a(exceptionMessageA, countDownLatch);
            if (this instanceof f) {
                com.kwad.sdk.core.d.c.d("ExceptionJavaCrashReporter", " java crash 不上传文件");
                try {
                    w.delete(file.getPath());
                    w.delete(file3.getPath());
                    w.delete(file4.getPath());
                    w.delete(file2.getPath());
                    w.delete(file5.getPath());
                    w.delete(file6.getPath());
                    Iterator it3 = arrayList.iterator();
                    while (it3.hasNext()) {
                        w.delete(((File) it3.next()).getPath());
                    }
                    com.kwad.sdk.crash.utils.g.G(com.kwad.sdk.crash.handler.b.sBackupDir);
                    return;
                } catch (Throwable th3) {
                    com.kwad.sdk.core.d.c.printStackTraceOnly(th3);
                    return;
                }
            }
            com.kwad.sdk.crash.utils.g.F(file4);
            List<File> arrayList2 = new ArrayList<>();
            Collections.addAll(arrayList2, file3, file4);
            Iterator<File> it4 = arrayList2.iterator();
            while (it4.hasNext()) {
                if (!it4.next().exists()) {
                    it4.remove();
                }
            }
            File file7 = new File(file.getParentFile().getParent(), MediationConstant.KEY_USE_POLICY_OBJ_CUSTOM);
            if (file7.exists()) {
                for (File file8 : file7.listFiles()) {
                    if (!file8.isDirectory() && (file8.getName().startsWith(exceptionMessageA.mLogUUID) || file8.getName().startsWith(fQ(exceptionMessageA.mLogUUID)))) {
                        arrayList.add(file8);
                    }
                }
                arrayList2.addAll(arrayList);
            }
            a(exceptionMessageA, arrayList2, countDownLatch);
            try {
                w.delete(file.getPath());
                w.delete(file3.getPath());
                w.delete(file4.getPath());
                w.delete(file2.getPath());
                w.delete(file5.getPath());
                w.delete(file6.getPath());
                Iterator it5 = arrayList.iterator();
                while (it5.hasNext()) {
                    w.delete(((File) it5.next()).getPath());
                }
                com.kwad.sdk.crash.utils.g.G(com.kwad.sdk.crash.handler.b.sBackupDir);
            } catch (Throwable th4) {
                com.kwad.sdk.core.d.c.printStackTraceOnly(th4);
            }
        } catch (Throwable th5) {
            try {
                com.kwad.sdk.core.d.c.printStackTraceOnly(th5);
                com.kwad.sdk.crash.utils.g.r(th5);
                try {
                    w.delete(file.getPath());
                    w.delete(file3.getPath());
                    w.delete(file4.getPath());
                    w.delete(file2.getPath());
                    w.delete(file5.getPath());
                    w.delete(file6.getPath());
                    Iterator it6 = arrayList.iterator();
                    while (it6.hasNext()) {
                        w.delete(((File) it6.next()).getPath());
                    }
                    com.kwad.sdk.crash.utils.g.G(com.kwad.sdk.crash.handler.b.sBackupDir);
                } catch (Throwable th6) {
                    com.kwad.sdk.core.d.c.printStackTraceOnly(th6);
                }
            } catch (Throwable th7) {
                try {
                    w.delete(file.getPath());
                    w.delete(file3.getPath());
                    w.delete(file4.getPath());
                    w.delete(file2.getPath());
                    w.delete(file5.getPath());
                    w.delete(file6.getPath());
                    Iterator it7 = arrayList.iterator();
                    while (it7.hasNext()) {
                        w.delete(((File) it7.next()).getPath());
                    }
                    com.kwad.sdk.crash.utils.g.G(com.kwad.sdk.crash.handler.b.sBackupDir);
                    throw th7;
                } catch (Throwable th8) {
                    com.kwad.sdk.core.d.c.printStackTraceOnly(th8);
                    throw th7;
                }
            }
        }
    }
}
