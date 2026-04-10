package com.uc.crashsdk;

import android.os.Build;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.media3.extractor.metadata.dvbsi.AppInfoTableDecoder;
import com.bykv.vk.component.ttvideo.TTVideoEngine;
import com.kuaishou.weapon.p0.bi;
import com.uc.crashsdk.a.h;
import com.uc.crashsdk.export.CustomInfo;
import com.uc.crashsdk.export.VersionInfo;
import com.umeng.commonsdk.statistics.UMErrorCode;
import java.io.File;
import java.lang.reflect.Field;
import java.util.zip.ZipFile;

/* JADX INFO: compiled from: ProGuard */
/* JADX INFO: loaded from: classes4.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static RuntimeException f2145a = null;
    public static RuntimeException b = null;
    static final /* synthetic */ boolean c = true;
    private static CustomInfo d;
    private static VersionInfo e;
    private static String g;
    private static String h;
    private static String i;
    private static String j;
    private static final Object f = new Object();
    private static final Object k = new Object();

    public static void a(CustomInfo customInfo, VersionInfo versionInfo) {
        CustomInfo customInfo2 = new CustomInfo(customInfo);
        d = customInfo2;
        c(customInfo2);
        if (!d.mZipLog) {
            f2145a = new RuntimeException("initialize set mZipLog to false, info.mZipLog: " + customInfo.mZipLog);
        }
        if (d.mEncryptLog) {
            b = new RuntimeException("initialize set mEncryptLog to true, info.mEncryptLog: " + customInfo.mEncryptLog);
        }
        e = new VersionInfo(versionInfo);
        if (b.L()) {
            return;
        }
        try {
            a();
        } catch (Throwable th) {
            com.uc.crashsdk.a.g.a(th);
        }
    }

    private static void c(CustomInfo customInfo) {
        if (customInfo.mZippedLogExtension == null) {
            customInfo.mZippedLogExtension = "";
        }
        if (customInfo.mZippedLogExtension.equals(bi.k)) {
            throw new IllegalArgumentException("mZippedLogExtension can not be '.tmp'!");
        }
        if (customInfo.mOmitJavaCrash) {
            customInfo.mCallJavaDefaultHandler = false;
        }
        if (customInfo.mOmitNativeCrash) {
            customInfo.mCallNativeDefaultHandler = false;
        }
        long jB = e.b();
        if (jB >= 1) {
            customInfo.mMaxBuiltinLogFilesCount = 200;
            customInfo.mMaxCustomLogFilesCount = 100;
            customInfo.mMaxUploadBytesPerDay = 268435456L;
            customInfo.mMaxUploadBuiltinLogCountPerDay = 2000;
            customInfo.mMaxUploadCustomLogCountPerDay = 2000;
            customInfo.mMaxCustomLogCountPerTypePerDay = 100;
            customInfo.mMaxAnrLogCountPerProcess = 100;
            customInfo.mAnrTraceStrategy = 2;
            if (jB >= 2) {
                customInfo.mSyncUploadSetupCrashLogs = true;
                customInfo.mSyncUploadLogs = true;
                if (jB >= 3) {
                    customInfo.mBackupLogs = true;
                    customInfo.mPrintStackInfos = true;
                    customInfo.mDebug = true;
                }
            }
        }
    }

    public static void a(CustomInfo customInfo) {
        boolean z = c;
        if (!z && customInfo.mTagFilesFolderName == null) {
            throw new AssertionError();
        }
        if (!z && customInfo.mCrashLogsFolderName == null) {
            throw new AssertionError();
        }
        if (customInfo.mTagFilesFolderName.equals(customInfo.mCrashLogsFolderName)) {
            throw new IllegalArgumentException("mTagFilesFolderName and mCrashLogsFolderName can not be set to the same!");
        }
    }

    public static void a(VersionInfo versionInfo) {
        synchronized (f) {
            e = new VersionInfo(versionInfo);
            e.c();
            if (b.d) {
                JNIBridge.set(109, T());
                JNIBridge.set(110, U());
                JNIBridge.set(111, V());
                JNIBridge.set(112, "211215141717");
                JNIBridge.cmd(2);
            }
        }
    }

    static void a() {
        b.y();
        b.x();
        if (d.mBackupLogs) {
            File file = new File(Y());
            if (file.exists()) {
                return;
            }
            file.mkdirs();
        }
    }

    public static void b() {
        JNIBridge.set(103, com.uc.crashsdk.a.g.b());
        JNIBridge.set(104, d.mTagFilesFolderName);
        JNIBridge.set(105, d.mCrashLogsFolderName);
        JNIBridge.set(106, Y());
        JNIBridge.set(107, e.h());
        JNIBridge.set(AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR, b.a());
        JNIBridge.set(109, T());
        JNIBridge.set(110, U());
        JNIBridge.set(111, V());
        JNIBridge.set(112, "211215141717");
        JNIBridge.set(AppInfoTableDecoder.APPLICATION_INFORMATION_TABLE_ID, Build.MODEL);
        JNIBridge.set(117, Build.VERSION.RELEASE);
        JNIBridge.set(TTVideoEngine.PLAYER_BUFFERING_DATA_OF_MILLISECONDS, e.q());
        JNIBridge.set(5, d.mCallNativeDefaultHandler);
        JNIBridge.set(6, d.mDumpUserSolibBuildId);
        JNIBridge.set(7, d.mReservedNativeMemoryBytes);
        JNIBridge.set(100, d.mNativeCrashLogFileName);
        JNIBridge.set(101, d.mUnexpCrashLogFileName);
        JNIBridge.set(35, d.mEnableMemoryGroup);
        JNIBridge.set(36, d.mEnableLibcMallocDetail);
        JNIBridge.set(131, d.mLibcMallocDetailConfig);
        JNIBridge.set(102, d.mAppId);
        JNIBridge.set(38, d.mCrashRateUploadUrl);
        JNIBridge.set(39, d.mCrashSDKAuthUrl);
    }

    public static void c() {
        JNIBridge.set(11, P());
        JNIBridge.set(12, d.mBackupLogs);
        JNIBridge.set(13, d.mCrashRestartInterval);
        JNIBridge.set(14, d.mMaxBuiltinLogFilesCount);
        JNIBridge.set(15, d.mMaxNativeLogcatLineCount);
        JNIBridge.set(16, d.mMaxUnexpLogcatLineCount);
        JNIBridge.set(31, d.mMaxAnrLogcatLineCount);
        JNIBridge.set(18, O());
        JNIBridge.set(20, Build.VERSION.SDK_INT);
        JNIBridge.set(21, d.mOmitNativeCrash);
        JNIBridge.set(32, d.mMaxAnrLogCountPerProcess);
        JNIBridge.set(8, d.mDisableSignals);
        JNIBridge.set(9, d.mDisableBackgroundSignals);
        JNIBridge.nativeSet(3, d.mZipLog ? 1L : 0L, d.mZippedLogExtension, null);
        JNIBridge.set(4, d.mLogMaxBytesLimit);
        JNIBridge.set(119, Build.FINGERPRINT);
    }

    public static void d() {
        JNIBridge.set(23, d.mIsInternational);
        if (b.H()) {
            JNIBridge.set(34, true);
        }
        if (e.i()) {
            JNIBridge.set(1, true);
        }
        JNIBridge.set(10, d.mFdDumpMinLimit);
        JNIBridge.nativeCmd(3, d.mReservedNativeFileHandleCount, null, null);
        JNIBridge.nativeSetForeground(b.B());
        JNIBridge.set(2, b.F());
        a.e();
        a.g();
        a.i();
        a.k();
        JNIBridge.set(113, a.f2128a);
        JNIBridge.cmd(1);
        JNIBridge.set(22, d.mThreadsDumpMinLimit);
        JNIBridge.set(UMErrorCode.E_UM_BE_ERROR_WORK_MODE, a.a());
        JNIBridge.set(33, a.c());
        ae();
        b.K();
        b.D();
        com.uc.crashsdk.a.g.k();
    }

    public static String e() {
        return d.mAppId;
    }

    static boolean f() {
        if (com.uc.crashsdk.a.g.b(d.mJavaCrashLogFileName) || com.uc.crashsdk.a.g.b(d.mNativeCrashLogFileName)) {
            return true;
        }
        return com.uc.crashsdk.a.g.b(d.mUnexpCrashLogFileName);
    }

    static String g() {
        return d.mJavaCrashLogFileName;
    }

    static int h() {
        return d.mCrashRestartInterval;
    }

    static boolean i() {
        return d.mCallJavaDefaultHandler;
    }

    static boolean j() {
        return d.mDumpHprofDataForJavaOOM;
    }

    static boolean k() {
        return d.mRenameFileToDefaultName;
    }

    static int l() {
        return d.mMaxBuiltinLogFilesCount;
    }

    static int m() {
        return d.mMaxCustomLogFilesCount;
    }

    static int n() {
        return d.mMaxJavaLogcatLineCount;
    }

    static int o() {
        return d.mUnexpDelayMillSeconds;
    }

    static int p() {
        return d.mUnexpSubTypes;
    }

    static boolean q() {
        return d.mBackupLogs;
    }

    public static boolean r() {
        return d.mSyncUploadSetupCrashLogs;
    }

    static boolean s() {
        return d.mSyncUploadLogs;
    }

    static boolean t() {
        return d.mOmitJavaCrash;
    }

    static boolean u() {
        return d.mAutoDeleteOldVersionStats;
    }

    static boolean v() {
        return d.mZipLog;
    }

    static String w() {
        return d.mZippedLogExtension;
    }

    static boolean x() {
        return d.mEncryptLog;
    }

    public static String y() {
        return d.mCrashLogUploadUrl;
    }

    public static String z() {
        return d.mCrashRateUploadUrl;
    }

    static int A() {
        return d.mLogMaxBytesLimit;
    }

    static int B() {
        return d.mLogMaxUploadBytesLimit;
    }

    static long C() {
        return d.mMaxUploadBytesPerDay;
    }

    static int D() {
        return d.mMaxUploadBuiltinLogCountPerDay;
    }

    static int E() {
        return d.mMaxUploadCustomLogCountPerDay;
    }

    static int F() {
        return d.mMaxCustomLogCountPerTypePerDay;
    }

    static int G() {
        return d.mInfoUpdateInterval;
    }

    static int H() {
        return d.mInfoSaveFrequency;
    }

    static int I() {
        return d.mReservedJavaFileHandleCount;
    }

    static int J() {
        return d.mFdDumpMinLimit;
    }

    static int K() {
        return d.mThreadsDumpMinLimit;
    }

    static boolean L() {
        return d.mAutoDetectLifeCycle;
    }

    static boolean M() {
        return d.mMonitorBattery;
    }

    static int N() {
        return d.mAnrTraceStrategy;
    }

    public static boolean O() {
        CustomInfo customInfo = d;
        return customInfo == null || customInfo.mDebug;
    }

    static boolean P() {
        CustomInfo customInfo = d;
        return customInfo == null || customInfo.mPrintStackInfos;
    }

    public static boolean Q() {
        return d.mEnableStatReport;
    }

    public static boolean R() {
        return d.mIsInternational;
    }

    public static boolean S() {
        return d.mAddPvForNewDay;
    }

    public static String T() {
        if (com.uc.crashsdk.a.g.a(e.mVersion)) {
            return a.a();
        }
        return a(e.mVersion);
    }

    public static String U() {
        return com.uc.crashsdk.a.g.a(e.mSubVersion) ? "release" : e.mSubVersion;
    }

    public static String V() {
        if (com.uc.crashsdk.a.g.a(e.mBuildId)) {
            return ad();
        }
        return a(e.mBuildId);
    }

    private static String a(String str) {
        return (str == null || !str.contains("_")) ? str : str.replaceAll("_", "-");
    }

    private static String ad() {
        ZipFile zipFile;
        Throwable th;
        String str = g;
        if (str != null) {
            return str;
        }
        try {
            try {
                zipFile = new ZipFile(com.uc.crashsdk.a.g.c());
            } catch (Throwable th2) {
                zipFile = null;
                th = th2;
            }
        } catch (Throwable unused) {
        }
        try {
            g = Long.toHexString(zipFile.getEntry("classes.dex").getCrc());
            com.uc.crashsdk.a.a.a("crashsdk", "version unique build id: " + g);
            zipFile.close();
        } catch (Throwable th3) {
            th = th3;
            try {
                g = "";
                com.uc.crashsdk.a.g.a(th);
                if (zipFile != null) {
                    zipFile.close();
                }
                return g;
            } catch (Throwable th4) {
                if (zipFile != null) {
                    try {
                        zipFile.close();
                    } catch (Throwable unused2) {
                    }
                }
                throw th4;
            }
        }
        return g;
    }

    public static String W() {
        if (h == null) {
            h = com.uc.crashsdk.a.g.b() + File.separatorChar + d.mTagFilesFolderName + File.separatorChar;
        }
        return h;
    }

    static String X() {
        if (i == null) {
            i = com.uc.crashsdk.a.g.b() + File.separatorChar + d.mCrashLogsFolderName + File.separatorChar;
        }
        return i;
    }

    static String Y() {
        if (j == null) {
            if (!com.uc.crashsdk.a.g.a(d.mLogsBackupPathName)) {
                String strTrim = d.mLogsBackupPathName.trim();
                if (!strTrim.endsWith(File.separator)) {
                    strTrim = strTrim + File.separator;
                }
                j = strTrim;
            } else {
                j = (com.uc.crashsdk.a.g.b() + File.separatorChar + "msdb" + File.separatorChar) + File.separatorChar + d.mCrashLogsFolderName + File.separatorChar;
            }
        }
        return j;
    }

    public static CustomInfo a(CustomInfo customInfo, Bundle bundle) {
        if (customInfo == null) {
            if (d == null) {
                customInfo = new CustomInfo();
            } else {
                customInfo = new CustomInfo(d);
            }
        }
        Field[] fields = customInfo.getClass().getFields();
        for (String str : bundle.keySet()) {
            for (Field field : fields) {
                if (field.getName().equals(str)) {
                    Object obj = bundle.get(str);
                    try {
                        field.set(customInfo, obj);
                    } catch (Exception e2) {
                        com.uc.crashsdk.a.g.a(e2);
                        throw new IllegalArgumentException("Field " + str + " must be a " + field.getType().getName() + ", but give a " + (obj != null ? obj.getClass().getName() : "(null)"));
                    }
                }
            }
        }
        return customInfo;
    }

    public static VersionInfo a(Bundle bundle) {
        VersionInfo versionInfo;
        if (e == null) {
            versionInfo = new VersionInfo();
        } else {
            versionInfo = new VersionInfo(e);
        }
        String string = bundle.getString("mVersion");
        if (!com.uc.crashsdk.a.g.a(string)) {
            versionInfo.mVersion = string;
        }
        String string2 = bundle.getString("mSubVersion");
        if (!com.uc.crashsdk.a.g.a(string2)) {
            versionInfo.mSubVersion = string2;
        }
        String string3 = bundle.getString("mBuildId");
        if (!com.uc.crashsdk.a.g.a(string3)) {
            versionInfo.mBuildId = string3;
        }
        String string4 = bundle.getString("crver");
        if (!com.uc.crashsdk.a.g.a(string4)) {
            a.b = string4;
            ae();
        }
        return versionInfo;
    }

    private static void ae() {
        if (b.d) {
            JNIBridge.nativeSet(24, 1L, a.b, null);
        }
    }

    private static boolean a(String str, String str2) {
        if (str == str2) {
            return true;
        }
        if (str == null || str2 == null) {
            return false;
        }
        return str.equals(str2);
    }

    public static int b(CustomInfo customInfo) {
        int i2;
        int i3;
        boolean z;
        synchronized (k) {
            i2 = 0;
            if (customInfo != null) {
                c(customInfo);
                if (d == null) {
                    d = new CustomInfo();
                }
                CustomInfo customInfo2 = d;
                boolean z2 = true;
                if (a(customInfo.mAppId, customInfo2.mAppId)) {
                    i3 = 0;
                } else {
                    customInfo2.mAppId = customInfo.mAppId;
                    if (b.d) {
                        JNIBridge.set(102, customInfo2.mAppId);
                    }
                    i3 = 1;
                }
                int i4 = i3;
                if (!a(customInfo.mJavaCrashLogFileName, customInfo2.mJavaCrashLogFileName)) {
                    customInfo2.mJavaCrashLogFileName = customInfo.mJavaCrashLogFileName;
                    i3++;
                }
                if (!a(customInfo.mNativeCrashLogFileName, customInfo2.mNativeCrashLogFileName)) {
                    customInfo2.mNativeCrashLogFileName = customInfo.mNativeCrashLogFileName;
                    if (b.d) {
                        JNIBridge.set(100, customInfo2.mNativeCrashLogFileName);
                    }
                    i3++;
                    i4 = 1;
                }
                if (!a(customInfo.mUnexpCrashLogFileName, customInfo2.mUnexpCrashLogFileName)) {
                    customInfo2.mUnexpCrashLogFileName = customInfo.mUnexpCrashLogFileName;
                    if (b.d) {
                        JNIBridge.set(101, customInfo2.mUnexpCrashLogFileName);
                    }
                    i3++;
                    i4 = 1;
                }
                if (i4 != 0) {
                    e.c();
                    if (b.d) {
                        JNIBridge.cmd(2);
                    }
                }
                if (customInfo2.mPrintStackInfos != customInfo.mPrintStackInfos) {
                    customInfo2.mPrintStackInfos = customInfo.mPrintStackInfos;
                    if (b.d) {
                        JNIBridge.set(11, customInfo2.mPrintStackInfos);
                    }
                    i3++;
                }
                if (customInfo2.mDebug != customInfo.mDebug) {
                    customInfo2.mDebug = customInfo.mDebug;
                    if (b.d) {
                        JNIBridge.set(18, customInfo2.mDebug);
                    }
                    i3++;
                }
                if (customInfo2.mBackupLogs != customInfo.mBackupLogs) {
                    customInfo2.mBackupLogs = customInfo.mBackupLogs;
                    if (b.d) {
                        JNIBridge.set(12, customInfo2.mBackupLogs);
                    }
                    i3++;
                }
                if (customInfo2.mOmitNativeCrash != customInfo.mOmitNativeCrash) {
                    customInfo2.mOmitNativeCrash = customInfo.mOmitNativeCrash;
                    if (b.d) {
                        JNIBridge.set(21, customInfo2.mOmitNativeCrash);
                    }
                    i3++;
                }
                if (customInfo2.mCrashRestartInterval != customInfo.mCrashRestartInterval) {
                    customInfo2.mCrashRestartInterval = customInfo.mCrashRestartInterval;
                    if (b.d) {
                        JNIBridge.set(13, customInfo2.mCrashRestartInterval);
                    }
                    if (customInfo2.mCrashRestartInterval >= 0) {
                        b.M();
                    }
                    i3++;
                }
                if (customInfo2.mMaxBuiltinLogFilesCount != customInfo.mMaxBuiltinLogFilesCount) {
                    customInfo2.mMaxBuiltinLogFilesCount = customInfo.mMaxBuiltinLogFilesCount;
                    if (b.d) {
                        JNIBridge.set(14, customInfo2.mMaxBuiltinLogFilesCount);
                    }
                    i3++;
                }
                if (customInfo2.mMaxNativeLogcatLineCount != customInfo.mMaxNativeLogcatLineCount) {
                    customInfo2.mMaxNativeLogcatLineCount = customInfo.mMaxNativeLogcatLineCount;
                    if (b.d) {
                        JNIBridge.set(15, customInfo2.mMaxNativeLogcatLineCount);
                    }
                    i3++;
                }
                if (customInfo2.mMaxJavaLogcatLineCount != customInfo.mMaxJavaLogcatLineCount) {
                    customInfo2.mMaxJavaLogcatLineCount = customInfo.mMaxJavaLogcatLineCount;
                    i3++;
                }
                if (customInfo2.mMaxUnexpLogcatLineCount != customInfo.mMaxUnexpLogcatLineCount) {
                    customInfo2.mMaxUnexpLogcatLineCount = customInfo.mMaxUnexpLogcatLineCount;
                    if (b.d) {
                        JNIBridge.set(16, customInfo2.mMaxUnexpLogcatLineCount);
                    }
                    i3++;
                }
                if (customInfo2.mMaxAnrLogcatLineCount != customInfo.mMaxAnrLogcatLineCount) {
                    customInfo2.mMaxAnrLogcatLineCount = customInfo.mMaxAnrLogcatLineCount;
                    if (b.d) {
                        JNIBridge.set(31, customInfo2.mMaxAnrLogcatLineCount);
                    }
                    i3++;
                }
                if (customInfo2.mZipLog != customInfo.mZipLog) {
                    customInfo2.mZipLog = customInfo.mZipLog;
                    if (!customInfo2.mZipLog) {
                        com.uc.crashsdk.a.a.d("DEBUG", "updateCustomInfoImpl set mZipLog to false");
                        f2145a = new RuntimeException("updateCustomInfoImpl set mZipLog to false");
                    }
                    i3++;
                    z = true;
                } else {
                    z = false;
                }
                if (a(customInfo.mZippedLogExtension, customInfo2.mZippedLogExtension)) {
                    z2 = z;
                } else {
                    customInfo2.mZippedLogExtension = customInfo.mZippedLogExtension;
                    i3++;
                }
                if (z2 && b.d) {
                    JNIBridge.nativeSet(3, customInfo2.mZipLog ? 1L : 0L, customInfo2.mZippedLogExtension, null);
                }
                if (customInfo2.mLogMaxBytesLimit != customInfo.mLogMaxBytesLimit) {
                    customInfo2.mLogMaxBytesLimit = customInfo.mLogMaxBytesLimit;
                    if (b.d) {
                        JNIBridge.set(4, customInfo2.mLogMaxBytesLimit);
                    }
                    i3++;
                }
                if (customInfo2.mEncryptLog != customInfo.mEncryptLog) {
                    customInfo2.mEncryptLog = customInfo.mEncryptLog;
                    if (customInfo2.mEncryptLog) {
                        com.uc.crashsdk.a.a.d("DEBUG", "updateCustomInfoImpl set mEncryptLog to true");
                        b = new RuntimeException("updateCustomInfoImpl set mEncryptLog to true");
                    }
                    i3++;
                }
                if (customInfo2.mSyncUploadSetupCrashLogs != customInfo.mSyncUploadSetupCrashLogs) {
                    customInfo2.mSyncUploadSetupCrashLogs = customInfo.mSyncUploadSetupCrashLogs;
                    i3++;
                }
                if (customInfo2.mSyncUploadLogs != customInfo.mSyncUploadLogs) {
                    customInfo2.mSyncUploadLogs = customInfo.mSyncUploadLogs;
                    i3++;
                }
                if (customInfo2.mMaxCustomLogFilesCount != customInfo.mMaxCustomLogFilesCount) {
                    customInfo2.mMaxCustomLogFilesCount = customInfo.mMaxCustomLogFilesCount;
                    i3++;
                }
                if (customInfo2.mOmitJavaCrash != customInfo.mOmitJavaCrash) {
                    customInfo2.mOmitJavaCrash = customInfo.mOmitJavaCrash;
                    i3++;
                }
                if (customInfo2.mLogMaxUploadBytesLimit != customInfo.mLogMaxUploadBytesLimit) {
                    customInfo2.mLogMaxUploadBytesLimit = customInfo.mLogMaxUploadBytesLimit;
                    i3++;
                }
                if (customInfo2.mMaxUploadBytesPerDay != customInfo.mMaxUploadBytesPerDay) {
                    customInfo2.mMaxUploadBytesPerDay = customInfo.mMaxUploadBytesPerDay;
                    i3++;
                }
                if (customInfo2.mMaxUploadBuiltinLogCountPerDay != customInfo.mMaxUploadBuiltinLogCountPerDay) {
                    customInfo2.mMaxUploadBuiltinLogCountPerDay = customInfo.mMaxUploadBuiltinLogCountPerDay;
                    i3++;
                }
                if (customInfo2.mMaxUploadCustomLogCountPerDay != customInfo.mMaxUploadCustomLogCountPerDay) {
                    customInfo2.mMaxUploadCustomLogCountPerDay = customInfo.mMaxUploadCustomLogCountPerDay;
                    i3++;
                }
                if (customInfo2.mMaxCustomLogCountPerTypePerDay != customInfo.mMaxCustomLogCountPerTypePerDay) {
                    customInfo2.mMaxCustomLogCountPerTypePerDay = customInfo.mMaxCustomLogCountPerTypePerDay;
                    i3++;
                }
                if (customInfo2.mMaxAnrLogCountPerProcess != customInfo.mMaxAnrLogCountPerProcess) {
                    customInfo2.mMaxAnrLogCountPerProcess = customInfo.mMaxAnrLogCountPerProcess;
                    if (b.d) {
                        JNIBridge.set(32, d.mMaxAnrLogCountPerProcess);
                    }
                    i3++;
                }
                if (customInfo2.mCallJavaDefaultHandler != customInfo.mCallJavaDefaultHandler) {
                    customInfo2.mCallJavaDefaultHandler = customInfo.mCallJavaDefaultHandler;
                    i3++;
                }
                if (customInfo2.mCallNativeDefaultHandler != customInfo.mCallNativeDefaultHandler) {
                    customInfo2.mCallNativeDefaultHandler = customInfo.mCallNativeDefaultHandler;
                    i3++;
                    if (b.d) {
                        JNIBridge.set(5, d.mCallNativeDefaultHandler);
                    }
                }
                if (customInfo2.mDumpUserSolibBuildId != customInfo.mDumpUserSolibBuildId) {
                    customInfo2.mDumpUserSolibBuildId = customInfo.mDumpUserSolibBuildId;
                    i3++;
                    if (b.d) {
                        JNIBridge.set(6, d.mDumpUserSolibBuildId);
                    }
                }
                if (customInfo2.mDumpHprofDataForJavaOOM != customInfo.mDumpHprofDataForJavaOOM) {
                    customInfo2.mDumpHprofDataForJavaOOM = customInfo.mDumpHprofDataForJavaOOM;
                    i3++;
                }
                if (customInfo2.mRenameFileToDefaultName != customInfo.mRenameFileToDefaultName) {
                    customInfo2.mRenameFileToDefaultName = customInfo.mRenameFileToDefaultName;
                    i3++;
                }
                if (customInfo2.mAutoDeleteOldVersionStats != customInfo.mAutoDeleteOldVersionStats) {
                    customInfo2.mAutoDeleteOldVersionStats = customInfo.mAutoDeleteOldVersionStats;
                    i3++;
                }
                if (customInfo2.mFdDumpMinLimit != customInfo.mFdDumpMinLimit) {
                    customInfo2.mFdDumpMinLimit = customInfo.mFdDumpMinLimit;
                    if (b.d) {
                        JNIBridge.set(10, customInfo2.mFdDumpMinLimit);
                    }
                    i3++;
                }
                if (customInfo2.mThreadsDumpMinLimit != customInfo.mThreadsDumpMinLimit) {
                    customInfo2.mThreadsDumpMinLimit = customInfo.mThreadsDumpMinLimit;
                    if (b.d) {
                        JNIBridge.set(22, customInfo2.mThreadsDumpMinLimit);
                    }
                    i3++;
                }
                if (customInfo2.mInfoUpdateInterval != customInfo.mInfoUpdateInterval) {
                    if (customInfo2.mInfoUpdateInterval <= 0 && customInfo.mInfoUpdateInterval > 0) {
                        a.a(false);
                    }
                    customInfo2.mInfoUpdateInterval = customInfo.mInfoUpdateInterval;
                    i3++;
                }
                if (customInfo2.mInfoSaveFrequency != customInfo.mInfoSaveFrequency) {
                    customInfo2.mInfoSaveFrequency = customInfo.mInfoSaveFrequency;
                    i3++;
                }
                if (customInfo2.mDisableBackgroundSignals != customInfo.mDisableBackgroundSignals) {
                    customInfo2.mDisableBackgroundSignals = customInfo.mDisableBackgroundSignals;
                    if (b.d) {
                        JNIBridge.set(9, customInfo2.mDisableBackgroundSignals);
                    }
                    i3++;
                }
                if (customInfo2.mEnableStatReport != customInfo.mEnableStatReport) {
                    customInfo2.mEnableStatReport = customInfo.mEnableStatReport;
                    if (customInfo2.mEnableStatReport) {
                        e.B();
                    }
                    i3++;
                }
                if (customInfo2.mEnableCrpStat != customInfo.mEnableCrpStat) {
                    customInfo2.mEnableCrpStat = customInfo.mEnableCrpStat;
                    i3++;
                }
                if (customInfo2.mEnableStatToWPKDirect != customInfo.mEnableStatToWPKDirect) {
                    customInfo2.mEnableStatToWPKDirect = customInfo.mEnableStatToWPKDirect;
                    i3++;
                }
                if (customInfo2.mIsInternational != customInfo.mIsInternational) {
                    customInfo2.mIsInternational = customInfo.mIsInternational;
                    if (b.d) {
                        JNIBridge.set(23, customInfo2.mIsInternational);
                    }
                    e.l();
                    com.uc.crashsdk.a.d.c();
                    h.k();
                    i3++;
                }
                if (customInfo2.mAutoDetectLifeCycle != customInfo.mAutoDetectLifeCycle) {
                    customInfo2.mAutoDetectLifeCycle = customInfo.mAutoDetectLifeCycle;
                    if (customInfo2.mAutoDetectLifeCycle) {
                        b.C();
                    }
                    i3++;
                }
                if (customInfo2.mMonitorBattery != customInfo.mMonitorBattery) {
                    customInfo2.mMonitorBattery = customInfo.mMonitorBattery;
                    e.c(b.B());
                    i3++;
                }
                if (customInfo2.mUnexpSubTypes != customInfo.mUnexpSubTypes) {
                    customInfo2.mUnexpSubTypes = customInfo.mUnexpSubTypes;
                    i3++;
                }
                if (customInfo2.mEnableMemoryGroup != customInfo.mEnableMemoryGroup) {
                    customInfo2.mEnableMemoryGroup = customInfo.mEnableMemoryGroup;
                    if (b.d) {
                        JNIBridge.set(35, customInfo2.mEnableMemoryGroup);
                    }
                    i3++;
                }
                if (customInfo2.mEnableLibcMallocDetail != customInfo.mEnableLibcMallocDetail) {
                    customInfo2.mEnableLibcMallocDetail = customInfo.mEnableLibcMallocDetail;
                    if (b.d) {
                        JNIBridge.set(36, customInfo2.mEnableLibcMallocDetail);
                    }
                    i3++;
                }
                if (customInfo2.mLibcMallocDetailConfig != customInfo.mLibcMallocDetailConfig) {
                    customInfo2.mLibcMallocDetailConfig = customInfo.mLibcMallocDetailConfig;
                    if (b.d) {
                        JNIBridge.set(131, customInfo2.mLibcMallocDetailConfig);
                    }
                    i3++;
                }
                if (!a(customInfo.mUserId, customInfo2.mUserId)) {
                    customInfo2.mUserId = customInfo.mUserId;
                    i3++;
                }
                if (!a(customInfo.mChannel, customInfo2.mChannel)) {
                    customInfo2.mChannel = customInfo.mChannel;
                    i3++;
                }
                if (!a(customInfo2.mCrashLogUploadUrl, customInfo.mCrashLogUploadUrl)) {
                    customInfo2.mCrashLogUploadUrl = customInfo.mCrashLogUploadUrl;
                    i3++;
                }
                if (!a(customInfo2.mCrashRateUploadUrl, customInfo.mCrashRateUploadUrl)) {
                    customInfo2.mCrashRateUploadUrl = customInfo.mCrashRateUploadUrl;
                    i3++;
                    if (b.d) {
                        JNIBridge.set(38, customInfo2.mCrashRateUploadUrl);
                    }
                }
                if (!a(customInfo2.mCrashSDKAuthUrl, customInfo.mCrashSDKAuthUrl)) {
                    customInfo2.mCrashSDKAuthUrl = customInfo.mCrashSDKAuthUrl;
                    i3++;
                    if (b.d) {
                        JNIBridge.set(39, customInfo2.mCrashSDKAuthUrl);
                    }
                }
                i2 = i3;
            }
        }
        return i2;
    }

    public static boolean Z() {
        return d.mEnableCrpStat;
    }

    public static boolean aa() {
        return d.mEnableStatToWPKDirect;
    }

    public static String ab() {
        return d.mUserId;
    }

    public static String ac() {
        return d.mChannel;
    }
}
