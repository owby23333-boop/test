package com.kwad.sdk.crash.report;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.crash.model.message.ExceptionMessage;
import com.kwad.sdk.crash.model.message.MemoryInfo;
import com.kwad.sdk.crash.model.message.ThreadInfo;
import com.kwad.sdk.utils.m;
import com.kwad.sdk.utils.p;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public abstract class d {
    protected String mErrorMessage = "";
    protected e mUploader;

    private void a(ExceptionMessage exceptionMessage, @NonNull List<File> list, @Nullable CountDownLatch countDownLatch) throws Throwable {
        com.kwad.sdk.core.d.b.d("ExceptionCollector", "compressAndUpload");
        File fileZF = this.mUploader.zF();
        if (!fileZF.exists()) {
            fileZF.mkdir();
        }
        File file = new File(fileZF, exceptionMessage.mLogUUID + ".zip");
        StringBuilder sb = new StringBuilder("compressAndUpload zipFile=");
        sb.append(file.getPath());
        com.kwad.sdk.core.d.b.d("ExceptionCollector", sb.toString());
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (Exception e2) {
                com.kwad.sdk.core.d.b.printStackTraceOnly(e2);
            }
        }
        m.a((File[]) list.toArray(new File[0]), file.getPath());
        if (file.length() <= 0) {
            p.N(file);
            return;
        }
        HashMap map = new HashMap();
        map.put("mLogUUID", exceptionMessage.mLogUUID);
        new JSONObject(map);
        b(file, countDownLatch);
    }

    protected static void a(File file, ExceptionMessage exceptionMessage) throws Throwable {
        BufferedReader bufferedReader;
        ThreadInfo threadInfo;
        String line;
        String str;
        try {
            MemoryInfo memoryInfo = new MemoryInfo(exceptionMessage.mMemoryInfo);
            ArrayList arrayList = new ArrayList();
            BufferedReader bufferedReader2 = null;
            BufferedReader bufferedReader3 = null;
            try {
                try {
                    bufferedReader = new BufferedReader(new FileReader(file));
                    try {
                        threadInfo = new ThreadInfo();
                    } catch (IOException e2) {
                        e = e2;
                        bufferedReader3 = bufferedReader;
                        com.kwad.sdk.core.d.b.printStackTraceOnly(e);
                        com.kwad.sdk.crash.utils.b.closeQuietly(bufferedReader3);
                        bufferedReader2 = bufferedReader3;
                    } catch (Throwable th) {
                        th = th;
                        com.kwad.sdk.crash.utils.b.closeQuietly(bufferedReader);
                        throw th;
                    }
                } catch (IOException e3) {
                    e = e3;
                }
                while (true) {
                    line = bufferedReader.readLine();
                    if (line == null) {
                        break;
                    }
                    if (line.isEmpty()) {
                        arrayList.add(threadInfo);
                        threadInfo = new ThreadInfo();
                    } else if (line.startsWith("at ") || line.startsWith("(no ")) {
                        if (threadInfo.mTrace == null) {
                            str = line;
                        } else {
                            str = threadInfo.mTrace + line;
                        }
                        threadInfo.mTrace = str;
                        threadInfo.mTrace += "#";
                    } else {
                        threadInfo.mName = line;
                    }
                }
                memoryInfo.mJavaThreads = arrayList;
                exceptionMessage.mMemoryInfo = memoryInfo.toJson().toString();
                com.kwad.sdk.crash.utils.b.closeQuietly(bufferedReader);
                bufferedReader2 = line;
            } catch (Throwable th2) {
                th = th2;
                bufferedReader = bufferedReader2;
            }
        } catch (Exception e4) {
            com.kwad.sdk.core.d.b.printStackTraceOnly(e4);
        }
    }

    @SuppressLint({"CheckResult"})
    private static void b(File file, @Nullable CountDownLatch countDownLatch) {
        com.kwad.sdk.crash.report.upload.d.a(file, true, countDownLatch);
    }

    private static String dA(String str) {
        return (str == null || !str.contains("-")) ? str : str.substring(0, str.lastIndexOf(45));
    }

    protected abstract ExceptionMessage a(@NonNull File file, File file2, File file3, String str);

    public final void a(e eVar) {
        this.mUploader = eVar;
    }

    public final void a(File file, @Nullable CountDownLatch countDownLatch) {
        String strDE = com.kwad.sdk.crash.utils.g.dE(file.getPath());
        File file2 = new File(strDE + ".msg");
        File file3 = new File(strDE + com.anythink.china.common.a.a.f6394f);
        File file4 = new File(strDE + ".blog");
        File file5 = new File(strDE + ".jtrace");
        File file6 = new File(strDE + ".minfo");
        ArrayList arrayList = new ArrayList();
        try {
            ExceptionMessage exceptionMessageA = a(file, file2, file3, strDE);
            if (exceptionMessageA == null) {
                try {
                    p.delete(file.getPath());
                    p.delete(file3.getPath());
                    p.delete(file4.getPath());
                    p.delete(file2.getPath());
                    p.delete(file5.getPath());
                    p.delete(file6.getPath());
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        p.delete(((File) it.next()).getPath());
                    }
                    com.kwad.sdk.crash.utils.g.A(com.kwad.sdk.crash.handler.b.sBackupDir);
                    return;
                } catch (Throwable th) {
                    com.kwad.sdk.core.d.b.printStackTraceOnly(th);
                    return;
                }
            }
            com.kwad.sdk.core.d.b.d("ExceptionCollector", "message.mCrashSource=" + exceptionMessageA.mCrashSource);
            if (exceptionMessageA.mCrashSource == 2) {
                try {
                    p.delete(file.getPath());
                    p.delete(file3.getPath());
                    p.delete(file4.getPath());
                    p.delete(file2.getPath());
                    p.delete(file5.getPath());
                    p.delete(file6.getPath());
                    Iterator it2 = arrayList.iterator();
                    while (it2.hasNext()) {
                        p.delete(((File) it2.next()).getPath());
                    }
                    com.kwad.sdk.crash.utils.g.A(com.kwad.sdk.crash.handler.b.sBackupDir);
                    return;
                } catch (Throwable th2) {
                    com.kwad.sdk.core.d.b.printStackTraceOnly(th2);
                    return;
                }
            }
            this.mUploader.a(exceptionMessageA, countDownLatch);
            if (this instanceof f) {
                com.kwad.sdk.core.d.b.d("ExceptionCollector", " java crash 不上传文件");
                try {
                    p.delete(file.getPath());
                    p.delete(file3.getPath());
                    p.delete(file4.getPath());
                    p.delete(file2.getPath());
                    p.delete(file5.getPath());
                    p.delete(file6.getPath());
                    Iterator it3 = arrayList.iterator();
                    while (it3.hasNext()) {
                        p.delete(((File) it3.next()).getPath());
                    }
                    com.kwad.sdk.crash.utils.g.A(com.kwad.sdk.crash.handler.b.sBackupDir);
                    return;
                } catch (Throwable th3) {
                    com.kwad.sdk.core.d.b.printStackTraceOnly(th3);
                    return;
                }
            }
            com.kwad.sdk.crash.utils.g.z(file4);
            List<File> arrayList2 = new ArrayList<>();
            Collections.addAll(arrayList2, file3, file4);
            Iterator<File> it4 = arrayList2.iterator();
            while (it4.hasNext()) {
                if (!it4.next().exists()) {
                    it4.remove();
                }
            }
            File file7 = new File(file.getParentFile().getParent(), "custom");
            if (file7.exists()) {
                for (File file8 : file7.listFiles()) {
                    if (!file8.isDirectory() && (file8.getName().startsWith(exceptionMessageA.mLogUUID) || file8.getName().startsWith(dA(exceptionMessageA.mLogUUID)))) {
                        arrayList.add(file8);
                    }
                }
                arrayList2.addAll(arrayList);
            }
            a(exceptionMessageA, arrayList2, countDownLatch);
            try {
                p.delete(file.getPath());
                p.delete(file3.getPath());
                p.delete(file4.getPath());
                p.delete(file2.getPath());
                p.delete(file5.getPath());
                p.delete(file6.getPath());
                Iterator it5 = arrayList.iterator();
                while (it5.hasNext()) {
                    p.delete(((File) it5.next()).getPath());
                }
                com.kwad.sdk.crash.utils.g.A(com.kwad.sdk.crash.handler.b.sBackupDir);
            } catch (Throwable th4) {
                com.kwad.sdk.core.d.b.printStackTraceOnly(th4);
            }
        } catch (Throwable th5) {
            try {
                com.kwad.sdk.core.d.b.printStackTraceOnly(th5);
                com.kwad.sdk.crash.utils.g.j(th5);
                try {
                    p.delete(file.getPath());
                    p.delete(file3.getPath());
                    p.delete(file4.getPath());
                    p.delete(file2.getPath());
                    p.delete(file5.getPath());
                    p.delete(file6.getPath());
                    Iterator it6 = arrayList.iterator();
                    while (it6.hasNext()) {
                        p.delete(((File) it6.next()).getPath());
                    }
                    com.kwad.sdk.crash.utils.g.A(com.kwad.sdk.crash.handler.b.sBackupDir);
                } catch (Throwable th6) {
                    com.kwad.sdk.core.d.b.printStackTraceOnly(th6);
                }
            } catch (Throwable th7) {
                try {
                    p.delete(file.getPath());
                    p.delete(file3.getPath());
                    p.delete(file4.getPath());
                    p.delete(file2.getPath());
                    p.delete(file5.getPath());
                    p.delete(file6.getPath());
                    Iterator it7 = arrayList.iterator();
                    while (it7.hasNext()) {
                        p.delete(((File) it7.next()).getPath());
                    }
                    com.kwad.sdk.crash.utils.g.A(com.kwad.sdk.crash.handler.b.sBackupDir);
                    throw th7;
                } catch (Throwable th8) {
                    com.kwad.sdk.core.d.b.printStackTraceOnly(th8);
                    throw th7;
                }
            }
        }
    }

    protected final void b(File file, ExceptionMessage exceptionMessage) throws Throwable {
        BufferedReader bufferedReader;
        StringBuilder sb;
        StringBuilder sb2;
        StringBuilder sb3;
        StringBuilder sb4;
        StringBuilder sb5;
        BufferedReader bufferedReader2 = null;
        try {
            try {
                bufferedReader = new BufferedReader(new FileReader(file));
                boolean z2 = false;
                while (true) {
                    try {
                        String line = bufferedReader.readLine();
                        if (line == null) {
                            com.kwad.sdk.crash.utils.b.closeQuietly(bufferedReader);
                            return;
                        }
                        if (!z2 && line.contains("JNI DETECTED ERROR IN APPLICATION")) {
                            exceptionMessage.mJNIError = line.substring(line.indexOf("JNI DETECTED ERROR IN APPLICATION"));
                            z2 = true;
                        } else if (line.contains("Waiting for a blocking GC ") || line.contains("WaitForGcToComplete")) {
                            if (TextUtils.isEmpty(exceptionMessage.mGCInfo)) {
                                sb = new StringBuilder();
                                sb.append(line);
                                sb.append("\n");
                            } else {
                                sb = new StringBuilder();
                                sb.append(exceptionMessage.mGCInfo);
                                sb.append(line);
                                sb.append("\n");
                            }
                            exceptionMessage.mGCInfo = sb.toString();
                        } else if (line.contains("dvm_lock_sample")) {
                            if (TextUtils.isEmpty(exceptionMessage.mLockInfo)) {
                                sb2 = new StringBuilder();
                                sb2.append(line);
                                sb2.append("\n");
                            } else {
                                sb2 = new StringBuilder();
                                sb2.append(exceptionMessage.mLockInfo);
                                sb2.append(line);
                                sb2.append("\n");
                            }
                            exceptionMessage.mLockInfo = sb2.toString();
                        } else if (line.contains("Long monitor")) {
                            if (TextUtils.isEmpty(exceptionMessage.mMonitorInfo)) {
                                sb3 = new StringBuilder();
                                sb3.append(line);
                                sb3.append("\n");
                            } else {
                                sb3 = new StringBuilder();
                                sb3.append(exceptionMessage.mMonitorInfo);
                                sb3.append(line);
                                sb3.append("\n");
                            }
                            exceptionMessage.mMonitorInfo = sb3.toString();
                        } else if (line.contains("Slow Looper")) {
                            if (TextUtils.isEmpty(exceptionMessage.mSlowLooper)) {
                                sb4 = new StringBuilder();
                                sb4.append(line);
                                sb4.append("\n");
                            } else {
                                sb4 = new StringBuilder();
                                sb4.append(exceptionMessage.mSlowLooper);
                                sb4.append(line);
                                sb4.append("\n");
                            }
                            exceptionMessage.mSlowLooper = sb4.toString();
                        } else if (line.contains("Slow Operation")) {
                            if (TextUtils.isEmpty(exceptionMessage.mSlowOperation)) {
                                sb5 = new StringBuilder();
                                sb5.append(line);
                                sb5.append("\n");
                            } else {
                                sb5 = new StringBuilder();
                                sb5.append(exceptionMessage.mSlowOperation);
                                sb5.append(line);
                                sb5.append("\n");
                            }
                            exceptionMessage.mSlowOperation = sb5.toString();
                        }
                    } catch (FileNotFoundException e2) {
                        e = e2;
                        bufferedReader2 = bufferedReader;
                        this.mErrorMessage += e + "\n";
                        com.kwad.sdk.crash.utils.b.closeQuietly(bufferedReader2);
                        return;
                    } catch (IOException e3) {
                        e = e3;
                        bufferedReader2 = bufferedReader;
                        this.mErrorMessage += e + "\n";
                        com.kwad.sdk.crash.utils.b.closeQuietly(bufferedReader2);
                        return;
                    } catch (Throwable th) {
                        th = th;
                        com.kwad.sdk.crash.utils.b.closeQuietly(bufferedReader);
                        throw th;
                    }
                }
            } catch (FileNotFoundException e4) {
                e = e4;
            } catch (IOException e5) {
                e = e5;
            }
        } catch (Throwable th2) {
            th = th2;
            bufferedReader = null;
        }
    }

    @SuppressLint({"CheckResult"})
    public final void x(File file) {
        com.kwad.sdk.core.d.b.d("ExceptionCollector", "reportException dir =" + file);
        File[] fileArrListFiles = file.listFiles(new FileFilter() { // from class: com.kwad.sdk.crash.report.d.1
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
}
