package com.kwad.sdk.crash.utils;

import android.content.Context;
import android.os.Build;
import android.os.Debug;
import android.os.Environment;
import android.os.ParcelFileDescriptor;
import android.os.Process;
import android.system.Os;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.crash.model.message.DiskInfo;
import com.kwad.sdk.crash.model.message.ExceptionMessage;
import com.kwad.sdk.crash.model.message.JavaExceptionMessage;
import com.kwad.sdk.crash.model.message.MemoryInfo;
import com.kwad.sdk.crash.model.message.NativeExceptionMessage;
import com.kwad.sdk.crash.model.message.ThreadInfo;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.AbiUtil;
import com.kwad.sdk.utils.SystemUtil;
import com.kwad.sdk.utils.an;
import com.kwad.sdk.utils.p;
import com.kwad.sdk.utils.r;
import com.umeng.message.proguard.ad;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.math.BigDecimal;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class g {
    private static final File asy = new File("/proc/self/fd");
    private static final File asz = new File("/proc/self/task");

    public static void A(File file) {
        if (file == null) {
            return;
        }
        try {
            p.O(file);
        } catch (Exception e2) {
            com.kwad.sdk.core.d.b.printStackTraceOnly(e2);
        }
    }

    private static int Av() {
        File[] fileArrListFiles;
        an.checkNotNull(asy);
        if (asy.exists() && asy.isDirectory() && (fileArrListFiles = asy.listFiles()) != null) {
            return fileArrListFiles.length;
        }
        return 0;
    }

    public static void B(File file) throws Throwable {
        BufferedWriter bufferedWriter;
        try {
            p.K(file);
            BufferedWriter bufferedWriter2 = null;
            try {
                try {
                    bufferedWriter = new BufferedWriter(new FileWriter(file, true));
                } catch (FileNotFoundException e2) {
                    e = e2;
                } catch (IOException e3) {
                    e = e3;
                }
                try {
                    for (Map.Entry<Thread, StackTraceElement[]> entry : Thread.getAllStackTraces().entrySet()) {
                        String strB = b(entry.getValue());
                        if (strB.isEmpty()) {
                            strB = "(no managed stack frames)\n";
                        }
                        bufferedWriter.write(entry.getKey().getName());
                        bufferedWriter.newLine();
                        bufferedWriter.write(strB);
                        bufferedWriter.newLine();
                    }
                    b.closeQuietly(bufferedWriter);
                } catch (FileNotFoundException e4) {
                    e = e4;
                    bufferedWriter2 = bufferedWriter;
                    com.kwad.sdk.core.d.b.printStackTraceOnly(e);
                    b.closeQuietly(bufferedWriter2);
                } catch (IOException e5) {
                    e = e5;
                    bufferedWriter2 = bufferedWriter;
                    com.kwad.sdk.core.d.b.printStackTraceOnly(e);
                    b.closeQuietly(bufferedWriter2);
                } catch (Throwable th) {
                    th = th;
                    b.closeQuietly(bufferedWriter);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                bufferedWriter = null;
            }
        } catch (IOException e6) {
            com.kwad.sdk.core.d.b.printStackTraceOnly(e6);
        }
    }

    public static void C(File file) {
        try {
            Debug.MemoryInfo memoryInfo = new Debug.MemoryInfo();
            Debug.getMemoryInfo(memoryInfo);
            Object objD = r.d(r.a("android.app.ActivityThread", "currentActivityThread", new Object[0]), "mAppThread");
            ParcelFileDescriptor parcelFileDescriptorOpen = ParcelFileDescriptor.open(file, 1006632960);
            ParcelFileDescriptor fileDescriptor = parcelFileDescriptorOpen;
            if (!SystemUtil.cd(26)) {
                fileDescriptor = parcelFileDescriptorOpen.getFileDescriptor();
            }
            if (SystemUtil.cd(24)) {
                r.a(objD, "dumpMemInfo", fileDescriptor, memoryInfo, Boolean.FALSE, Boolean.TRUE, Boolean.TRUE, Boolean.FALSE, Boolean.FALSE, new String[0]);
            } else if (SystemUtil.cd(23)) {
                r.a(objD, "dumpMemInfo", fileDescriptor, memoryInfo, Boolean.FALSE, Boolean.TRUE, Boolean.TRUE, Boolean.FALSE, new String[0]);
            } else if (SystemUtil.cd(19)) {
                r.a(objD, "dumpMemInfo", fileDescriptor, memoryInfo, Boolean.FALSE, Boolean.TRUE, Boolean.TRUE, new String[0]);
            }
            ParcelFileDescriptor parcelFileDescriptorOpen2 = ParcelFileDescriptor.open(file, 973078528);
            ParcelFileDescriptor fileDescriptor2 = parcelFileDescriptorOpen2;
            if (!SystemUtil.cd(26)) {
                fileDescriptor2 = parcelFileDescriptorOpen2.getFileDescriptor();
            }
            r.a(objD, "dumpGfxInfo", fileDescriptor2, new String[]{SystemUtil.getProcessName(com.kwad.sdk.crash.e.zJ().getContext())});
        } catch (Exception e2) {
            com.kwad.sdk.core.d.b.printStackTraceOnly(e2);
        }
    }

    private static String S(@NonNull String str, String str2) {
        an.et(str);
        return !str.endsWith(str2) ? str : str.substring(0, str.lastIndexOf(str2));
    }

    private static double X(long j2) {
        return BigDecimal.valueOf((j2 >> 20) / 1024.0f).setScale(2, 4).floatValue();
    }

    private static String a(StackTraceElement[] stackTraceElementArr, int i2) {
        if (stackTraceElementArr == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (StackTraceElement stackTraceElement : stackTraceElementArr) {
            sb.append("at ");
            sb.append(stackTraceElement);
            sb.append('\n');
        }
        return sb.substring(0);
    }

    public static void a(ExceptionMessage exceptionMessage, int i2) {
        com.kwad.sdk.crash.h hVarZP = com.kwad.sdk.crash.e.zJ().zP();
        if (hVarZP == null) {
            com.kwad.sdk.core.d.b.d("tag", "getter is null!");
        } else {
            exceptionMessage.mCustomMsg = hVarZP.mV().toString();
        }
    }

    private static void a(@NonNull ExceptionMessage exceptionMessage, @Nullable Context context) {
        if (exceptionMessage instanceof JavaExceptionMessage) {
            if ("Unknown".equals(exceptionMessage.mThreadName)) {
                exceptionMessage.mThreadName = Thread.currentThread().getName();
            }
            exceptionMessage.mTid = Process.myTid();
        }
        if (context != null) {
            String processName = SystemUtil.getProcessName(context);
            if (!TextUtils.isEmpty(processName)) {
                exceptionMessage.mProcessName = processName;
            }
        }
        exceptionMessage.mPid = Process.myPid();
        exceptionMessage.mCurrentTimeStamp = System.currentTimeMillis();
        exceptionMessage.mUsageTimeMills = com.kwad.sdk.crash.e.zJ().zQ();
        exceptionMessage.mAbi = AbiUtil.isArm64(context) ? "arm64" : "arm";
        exceptionMessage.mVersionConflict = TextUtils.equals(exceptionMessage.mVersionCode, ExceptionMessage.getSdkCrashVersionName("1.0", com.kwad.sdk.crash.e.zJ().zN()));
        exceptionMessage.mBuildConfigInfo = bA(context);
        e(exceptionMessage);
        b(exceptionMessage, context);
        exceptionMessage.mTaskId = bz(context);
    }

    private static void a(ExceptionMessage exceptionMessage, DiskInfo diskInfo) {
        File externalStorageDirectory;
        try {
            String path = Environment.getDataDirectory().getPath();
            diskInfo.mDataTotalGB = X(h.getTotalBytes(path));
            if (!((com.kwad.sdk.service.kwai.f) ServiceProvider.get(com.kwad.sdk.service.kwai.f.class)).D(1024L)) {
                diskInfo.mDataAvailableGB = X(h.getAvailableBytes(path));
            }
            if ("mounted".equals(Environment.getExternalStorageState()) && (externalStorageDirectory = Environment.getExternalStorageDirectory()) != null) {
                diskInfo.mExternalStorageTotalGB = X(h.getTotalBytes(externalStorageDirectory.getPath()));
                if (!((com.kwad.sdk.service.kwai.f) ServiceProvider.get(com.kwad.sdk.service.kwai.f.class)).D(1024L)) {
                    diskInfo.mExternalStorageAvailableGB = X(h.getAvailableBytes(externalStorageDirectory.getPath()));
                }
            }
        } catch (Exception e2) {
            com.kwad.sdk.core.d.b.printStackTraceOnly(e2);
        }
        exceptionMessage.mDiskInfo = diskInfo.toJson().toString();
    }

    private static void a(ExceptionMessage exceptionMessage, MemoryInfo memoryInfo) {
        if (memoryInfo.mPssMB * 2 > memoryInfo.mTotalMB || (!AbiUtil.isArm64(((com.kwad.sdk.service.kwai.e) ServiceProvider.get(com.kwad.sdk.service.kwai.e.class)).getContext()) && memoryInfo.mVssMB > 3686.4d)) {
            exceptionMessage.mCrashType = exceptionMessage.getTypeHeapOOM();
        }
    }

    private static void a(ExceptionMessage exceptionMessage, MemoryInfo memoryInfo, @Nullable Context context) throws Throwable {
        List<String> list;
        String canonicalPath;
        SystemUtil.a aVarEx = SystemUtil.Ex();
        aVarEx.azK = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        aVarEx.azG = SystemUtil.Ew();
        aVarEx.azJ = Debug.getPss();
        memoryInfo.mTotalMB = (int) (aVarEx.azG / 1048576);
        memoryInfo.mJavaHeapLimitMB = (int) (com.kwad.sdk.crash.d.aqu / 1048576.0d);
        memoryInfo.mJavaHeapMB = (int) (aVarEx.azK / 1048576);
        memoryInfo.mVssMB = (int) (aVarEx.azH / 1024);
        memoryInfo.mRssMB = (int) (aVarEx.azI / 1024);
        memoryInfo.mPssMB = (int) (aVarEx.azJ / 1024);
        memoryInfo.mThreadsCount = aVarEx.mThreadsCount;
        memoryInfo.mFdCount = Av();
        if (context != null) {
            memoryInfo.mAvailableMB = (int) (SystemUtil.de(context) / 1048576);
        }
        exceptionMessage.mFdOverflow = "False";
        if (memoryInfo.mFdCount > 800) {
            exceptionMessage.mCrashType = exceptionMessage.getTypeFdOOM();
            exceptionMessage.mFdOverflow = "True";
            File[] fileArrListFiles = asy.listFiles();
            if (fileArrListFiles != null && fileArrListFiles.length > 0) {
                for (File file : fileArrListFiles) {
                    try {
                        if (Build.VERSION.SDK_INT >= 21) {
                            list = memoryInfo.mFds;
                            canonicalPath = Os.readlink(file.getPath());
                        } else {
                            list = memoryInfo.mFds;
                            canonicalPath = file.getCanonicalPath();
                        }
                        list.add(canonicalPath);
                    } catch (Exception e2) {
                        com.kwad.sdk.core.d.b.printStackTraceOnly(e2);
                    }
                }
                Collections.sort(memoryInfo.mFds);
            }
        }
        exceptionMessage.mThreadOverflow = "False";
        if (aVarEx.mThreadsCount > 400) {
            exceptionMessage.mCrashType = exceptionMessage.getTypeThreadOOM();
            exceptionMessage.mThreadOverflow = "True";
            a(memoryInfo);
            Collections.sort(memoryInfo.mAllThreads, new Comparator<ThreadInfo>() { // from class: com.kwad.sdk.crash.utils.g.1
                private static int a(ThreadInfo threadInfo, ThreadInfo threadInfo2) {
                    return threadInfo.mName.compareTo(threadInfo2.mName);
                }

                @Override // java.util.Comparator
                public final /* synthetic */ int compare(ThreadInfo threadInfo, ThreadInfo threadInfo2) {
                    return a(threadInfo, threadInfo2);
                }
            });
        }
        exceptionMessage.mMemoryInfo = memoryInfo.toJson().toString();
    }

    private static void a(MemoryInfo memoryInfo) {
        File[] fileArrListFiles = asz.listFiles();
        if (fileArrListFiles == null) {
            return;
        }
        for (File file : fileArrListFiles) {
            ThreadInfo threadInfo = new ThreadInfo();
            try {
                threadInfo.mName = h.D(new File(file, "comm"));
            } catch (IOException e2) {
                com.kwad.sdk.core.d.b.printStackTraceOnly(e2);
            }
            if (!TextUtils.isEmpty(threadInfo.mName)) {
                threadInfo.mName = S(threadInfo.mName, "\n");
                memoryInfo.mAllThreads.add(threadInfo);
            }
        }
    }

    public static void a(com.kwad.sdk.crash.report.e eVar, String str, File file) throws Throwable {
        String line;
        try {
            p.K(file);
            BufferedReader bufferedReader = null;
            try {
                try {
                    BufferedReader bufferedReader2 = new BufferedReader(new FileReader(file));
                    if (eVar != null) {
                        do {
                            try {
                                line = bufferedReader2.readLine();
                                if (line == null) {
                                    break;
                                }
                            } catch (FileNotFoundException e2) {
                                e = e2;
                                bufferedReader = bufferedReader2;
                                com.kwad.sdk.core.d.b.printStackTraceOnly(e);
                                b.closeQuietly(bufferedReader);
                                return;
                            } catch (IOException e3) {
                                e = e3;
                                bufferedReader = bufferedReader2;
                                com.kwad.sdk.core.d.b.printStackTraceOnly(e);
                                b.closeQuietly(bufferedReader);
                                return;
                            } catch (Throwable th) {
                                th = th;
                                bufferedReader = bufferedReader2;
                                b.closeQuietly(bufferedReader);
                                throw th;
                            }
                        } while (!line.isEmpty());
                    }
                    b.closeQuietly(bufferedReader2);
                } catch (FileNotFoundException e4) {
                    e = e4;
                } catch (IOException e5) {
                    e = e5;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (IOException e6) {
            com.kwad.sdk.core.d.b.printStackTraceOnly(e6);
        }
    }

    public static void a(File file, CharSequence charSequence) {
        a(file, charSequence, Charset.defaultCharset(), false);
    }

    private static void a(File file, CharSequence charSequence, Charset charset, boolean z2) {
        a(file, charSequence == null ? null : charSequence.toString(), charset, z2);
    }

    public static void a(File file, CharSequence charSequence, boolean z2) {
        a(file, charSequence, Charset.defaultCharset(), true);
    }

    private static void a(File file, String str, Charset charset, boolean z2) {
        FileOutputStream fileOutputStreamA = null;
        try {
            fileOutputStreamA = p.a(file, z2);
            h.a(str, fileOutputStreamA, charset);
            a(fileOutputStreamA);
        } catch (Exception e2) {
            com.kwad.sdk.core.d.b.printStackTraceOnly(e2);
        } finally {
            b.closeQuietly(fileOutputStreamA);
        }
    }

    private static void a(Throwable th, ExceptionMessage exceptionMessage) {
        if (i(th) && exceptionMessage.mCrashType.equals(exceptionMessage.getTypeCommon())) {
            exceptionMessage.mCrashType = exceptionMessage.getTypeHeapOOM();
        }
    }

    private static boolean a(FileOutputStream fileOutputStream) {
        if (fileOutputStream == null) {
            return true;
        }
        try {
            fileOutputStream.getFD().sync();
            return true;
        } catch (IOException e2) {
            com.kwad.sdk.core.d.b.printStackTraceOnly(e2);
            return false;
        }
    }

    private static String b(StackTraceElement[] stackTraceElementArr) {
        return a(stackTraceElementArr, 0);
    }

    private static void b(@NonNull ExceptionMessage exceptionMessage, @Nullable Context context) {
        String absolutePath;
        String packageName;
        if (context == null) {
            return;
        }
        File parentFile = context.getCacheDir().getParentFile().getParentFile().getParentFile();
        try {
            absolutePath = parentFile.getCanonicalPath();
        } catch (IOException e2) {
            com.kwad.sdk.core.d.b.printStackTraceOnly(e2);
            absolutePath = parentFile.getAbsolutePath();
        }
        if (com.kwad.sdk.crash.d.aqv.matcher(absolutePath).matches() || com.kwad.sdk.crash.d.aqw.matcher(absolutePath).matches()) {
            packageName = context.getPackageName();
        } else {
            Matcher matcher = com.kwad.sdk.crash.d.aqx.matcher(absolutePath);
            Matcher matcher2 = com.kwad.sdk.crash.d.aqy.matcher(absolutePath);
            if (matcher.matches()) {
                packageName = matcher.group(1);
            } else {
                if (!matcher2.matches()) {
                    exceptionMessage.mVirtualApp = absolutePath;
                    return;
                }
                packageName = matcher2.group(1);
            }
        }
        exceptionMessage.mVirtualApp = packageName;
    }

    public static void b(File file, File file2) throws Throwable {
        BufferedReader bufferedReader;
        try {
            p.K(file);
            p.K(file2);
            BufferedWriter bufferedWriter = null;
            try {
                try {
                    bufferedReader = new BufferedReader(new FileReader(file));
                    try {
                        BufferedWriter bufferedWriter2 = new BufferedWriter(new FileWriter(file2, true));
                        while (true) {
                            try {
                                String line = bufferedReader.readLine();
                                if (line == null) {
                                    break;
                                }
                                bufferedWriter2.write(line);
                                bufferedWriter2.newLine();
                            } catch (FileNotFoundException e2) {
                                e = e2;
                                bufferedWriter = bufferedWriter2;
                                com.kwad.sdk.core.d.b.printStackTraceOnly(e);
                                b.closeQuietly(bufferedWriter);
                            } catch (IOException e3) {
                                e = e3;
                                bufferedWriter = bufferedWriter2;
                                com.kwad.sdk.core.d.b.printStackTraceOnly(e);
                                b.closeQuietly(bufferedWriter);
                            } catch (Throwable th) {
                                th = th;
                                bufferedWriter = bufferedWriter2;
                                b.closeQuietly(bufferedWriter);
                                b.closeQuietly(bufferedReader);
                                throw th;
                            }
                        }
                        b.closeQuietly(bufferedWriter2);
                    } catch (FileNotFoundException e4) {
                        e = e4;
                    } catch (IOException e5) {
                        e = e5;
                    }
                } catch (FileNotFoundException e6) {
                    e = e6;
                    bufferedReader = null;
                } catch (IOException e7) {
                    e = e7;
                    bufferedReader = null;
                } catch (Throwable th2) {
                    th = th2;
                    bufferedReader = null;
                }
                b.closeQuietly(bufferedReader);
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (IOException e8) {
            com.kwad.sdk.core.d.b.printStackTraceOnly(e8);
        }
    }

    private static void b(@NonNull Throwable th, @NonNull ExceptionMessage exceptionMessage) throws Throwable {
        String strJ = j(th);
        if (th instanceof StackOverflowError) {
            strJ = dH(strJ);
        }
        exceptionMessage.mCrashDetail = strJ.replaceAll("[\n\t]", "#");
    }

    public static void b(@Nullable Throwable th, @NonNull ExceptionMessage exceptionMessage, @Nullable Context context) throws Throwable {
        if (th != null) {
            b(th, exceptionMessage);
        }
        a(exceptionMessage, context);
        MemoryInfo memoryInfo = new MemoryInfo();
        a(exceptionMessage, memoryInfo, context);
        a(exceptionMessage, new DiskInfo());
        if (exceptionMessage instanceof NativeExceptionMessage) {
            a(exceptionMessage, memoryInfo);
        } else if (exceptionMessage instanceof JavaExceptionMessage) {
            a(th, exceptionMessage);
        }
    }

    private static String bA(Context context) {
        StringBuilder sb = new StringBuilder();
        try {
            sb.append("BuildConfig Version Name: " + com.kwad.sdk.crash.e.zJ().getSdkVersion() + "\n");
            sb.append("PackageInfo CodePath: " + context.getPackageCodePath() + "\n");
            sb.append("PackageInfo ResPath: " + context.getPackageResourcePath() + "\n");
            sb.append("DexPath: " + bB(context) + "\n");
        } catch (Exception e2) {
            com.kwad.sdk.core.d.b.printStackTraceOnly(e2);
        }
        return sb.toString();
    }

    private static String bB(Context context) {
        StringBuilder sb = new StringBuilder();
        ClassLoader classLoader = context.getClassLoader();
        if (classLoader != null) {
            String string = classLoader.toString();
            StringBuilder sb2 = new StringBuilder("ClassLoader ");
            int i2 = 0;
            sb2.append(0);
            sb2.append(" : ");
            sb2.append(string);
            while (true) {
                sb.append(sb2.toString());
                if (classLoader.getParent() == null) {
                    break;
                }
                classLoader = classLoader.getParent();
                i2++;
                sb2 = new StringBuilder("\nClassLoader ");
                sb2.append(i2);
                sb2.append(" : ");
                sb2.append(classLoader.toString());
            }
            if (string != null) {
                String[] strArrSplit = string.split("\"");
                if (strArrSplit.length >= 2) {
                    sb.append("\n====path: " + strArrSplit[1] + ", length: " + dG(strArrSplit[1]));
                }
            }
        }
        return sb.toString();
    }

    private static String bz(Context context) {
        InputStream inputStreamOpen = null;
        try {
            inputStreamOpen = context.getResources().getAssets().open("apk.json");
            return new JSONObject(h.d(inputStreamOpen)).getString("task_id");
        } catch (IOException e2) {
            com.kwad.sdk.core.d.b.printStackTraceOnly(e2);
            return "";
        } catch (JSONException e3) {
            com.kwad.sdk.core.d.b.printStackTraceOnly(e3);
            return "";
        } catch (Throwable th) {
            com.kwad.sdk.core.d.b.printStackTraceOnly(th);
            return "";
        } finally {
            b.closeQuietly(inputStreamOpen);
        }
    }

    public static String dE(String str) {
        return str.contains(".") ? str.substring(0, str.lastIndexOf(46)) : str;
    }

    public static String dF(String str) {
        return (str.contains(ad.f20405r) && str.contains(ad.f20406s)) ? str.substring(str.lastIndexOf(40) + 1, str.lastIndexOf(41)) : str;
    }

    private static long dG(String str) {
        try {
            File file = new File(str);
            if (file.exists()) {
                return file.length();
            }
            return -1L;
        } catch (Exception unused) {
            return -1L;
        }
    }

    private static String dH(String str) {
        HashSet hashSet = new HashSet();
        for (String str2 : str.split("\n")) {
            hashSet.add(str2);
        }
        ArrayList arrayList = new ArrayList(hashSet);
        StringBuilder sb = new StringBuilder();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            sb.append((String) it.next());
            sb.append("\n");
        }
        return sb.substring(0);
    }

    private static void e(@NonNull ExceptionMessage exceptionMessage) {
        exceptionMessage.mVirtualApp = com.kwad.sdk.crash.e.zJ().zM();
        exceptionMessage.mVersionCode = com.kwad.sdk.crash.e.zJ().getSdkVersion();
    }

    public static int getIndex(String str) {
        if (str.contains("-")) {
            return Integer.parseInt(str.substring(str.lastIndexOf(45)));
        }
        return -1;
    }

    private static boolean i(@Nullable Throwable th) {
        if (th == null) {
            return false;
        }
        while (th.getCause() != null) {
            th = th.getCause();
        }
        return th instanceof OutOfMemoryError;
    }

    public static String j(Throwable th) throws Throwable {
        StringWriter stringWriter;
        String string = th.toString();
        StringWriter stringWriter2 = null;
        try {
            try {
                stringWriter = new StringWriter();
                try {
                    f.a(th, new PrintWriter(stringWriter));
                    string = stringWriter.toString();
                    b.closeQuietly(stringWriter);
                } catch (Exception e2) {
                    e = e2;
                    stringWriter2 = stringWriter;
                    com.kwad.sdk.core.d.b.printStackTraceOnly(e);
                    b.closeQuietly(stringWriter2);
                } catch (Throwable th2) {
                    th = th2;
                    b.closeQuietly(stringWriter);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                stringWriter = stringWriter2;
            }
        } catch (Exception e3) {
            e = e3;
        }
        return string;
    }

    public static void z(File file) throws Throwable {
        try {
            d.a(SystemUtil.cd(21) ? new String[]{"logcat", "-v", "threadtime", "-b", "main", "-b", "system", "-b", com.umeng.analytics.pro.d.ar, "-b", "crash", "-d", "-f", file.getPath()} : new String[]{"logcat", "-v", "threadtime", "-b", "main", "-b", "system", "-b", com.umeng.analytics.pro.d.ar, "-d", "-f", file.getPath()}, 0);
        } catch (IOException e2) {
            com.kwad.sdk.core.d.b.printStackTraceOnly(e2);
        }
    }
}
