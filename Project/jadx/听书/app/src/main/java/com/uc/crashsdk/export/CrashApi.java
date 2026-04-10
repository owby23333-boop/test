package com.uc.crashsdk.export;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import android.webkit.ValueCallback;
import androidx.media3.common.C;
import com.uc.crashsdk.JNIBridge;
import com.uc.crashsdk.a.a;
import com.uc.crashsdk.a.h;
import com.uc.crashsdk.b;
import com.uc.crashsdk.d;
import com.uc.crashsdk.e;
import com.uc.crashsdk.g;
import com.umeng.umcrash.UMCrash;
import java.util.Iterator;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: ProGuard */
/* JADX INFO: loaded from: classes4.dex */
public class CrashApi {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static CrashApi f2143a = null;
    private static boolean c = true;
    private static boolean d;
    private boolean b;

    public static synchronized CrashApi createInstance(Context context, CustomInfo customInfo, VersionInfo versionInfo, ICrashClient iCrashClient, boolean z, boolean z2, boolean z3) {
        if (f2143a == null) {
            f2143a = new CrashApi(context, customInfo, versionInfo, iCrashClient, z, z2, z3);
        }
        return f2143a;
    }

    public static CrashApi createInstanceEx(Context context, String str, boolean z) {
        return createInstanceEx(context, str, z, null);
    }

    public static CrashApi createInstanceEx(Context context, String str, boolean z, Bundle bundle) {
        return createInstanceEx(context, str, z, bundle, null);
    }

    public static CrashApi createInstanceEx(Context context, String str, boolean z, Bundle bundle, ICrashClient iCrashClient) {
        CrashApi crashApi = f2143a;
        if (crashApi != null) {
            return crashApi;
        }
        if (bundle == null) {
            bundle = new Bundle();
        }
        c = bundle.getBoolean("useApplicationContext", true);
        Context contextA = a(context);
        b(contextA);
        CustomInfo customInfo = new CustomInfo(str);
        customInfo.mEnableStatReport = false;
        customInfo.mZipLog = true;
        customInfo.mPrintStackInfos = z;
        bundle.putString("crver", "2.0");
        CustomInfo customInfoA = g.a(customInfo, bundle);
        VersionInfo versionInfoA = g.a(bundle);
        boolean z2 = bundle.getBoolean(UMCrash.KEY_ENABLE_CRASH_JAVA, true);
        boolean z3 = bundle.getBoolean(UMCrash.KEY_ENABLE_CRASH_NATIVE, true);
        boolean z4 = bundle.getBoolean(UMCrash.KEY_ENABLE_CRASH_UNEXP, b.F());
        boolean z5 = bundle.getBoolean(UMCrash.KEY_ENABLE_ANR, true);
        CrashApi crashApiCreateInstance = createInstance(contextA, customInfoA, versionInfoA, iCrashClient, z2, z3, z4);
        crashApiCreateInstance.disableLog(C.ENCODING_PCM_32BIT);
        b.a(z5);
        if (z3 || z4) {
            if (e.e("libcrashsdk.so")) {
                crashApiCreateInstance.crashSoLoaded();
            } else {
                a.d("crashsdk", "load libcrashsdk.so failed!");
            }
        }
        int i = bundle.getInt("uploadLogDelaySeconds", 15);
        if (i >= 0 && b.F()) {
            e.b(i);
        }
        return crashApiCreateInstance;
    }

    public boolean registerCallback(int i, ValueCallback<Bundle> valueCallback) {
        valueCallback.getClass();
        if (i == 1) {
            return d.a(valueCallback);
        }
        if (i == 2) {
            return d.c(valueCallback);
        }
        if (i == 3) {
            return d.d(valueCallback);
        }
        if (i == 4) {
            return d.b(valueCallback);
        }
        throw new IllegalArgumentException("Unknown event type: " + i);
    }

    public int updateCustomInfo(CustomInfo customInfo) {
        customInfo.getClass();
        return g.b(customInfo);
    }

    public int updateCustomInfo(Bundle bundle) {
        bundle.getClass();
        return updateCustomInfo(g.a((CustomInfo) null, bundle));
    }

    public static CrashApi getInstance() {
        return f2143a;
    }

    public void crashSoLoaded() {
        if (a("crashSoLoaded")) {
            return;
        }
        b.f = true;
        b();
        synchronized (b.e) {
            if (b.h && b.f && !b.c) {
                if (!b.d) {
                    c();
                    g.d();
                }
                e.x();
                b.c = true;
            }
        }
        com.uc.crashsdk.a.n();
        e.m();
    }

    public void updateVersionInfo(VersionInfo versionInfo) {
        versionInfo.getClass();
        g.a(versionInfo);
    }

    public void updateVersionInfo(Bundle bundle) {
        bundle.getClass();
        updateVersionInfo(g.a(bundle));
    }

    public void disableLog(int i) {
        synchronized (b.e) {
            b.b(i);
            if (LogType.isForJava(i) && b.f2137a) {
                e.t();
                b.f2137a = false;
            }
            if (LogType.isForNative(i)) {
                if (b.b) {
                    JNIBridge.cmd(9);
                    b.b = false;
                } else {
                    b.g = false;
                }
            }
            if (LogType.isForANR(i)) {
                b.a(false);
            }
            if (LogType.isForUnexp(i)) {
                if (b.c) {
                    if (e.z()) {
                        b.c = false;
                    }
                } else {
                    b.h = false;
                }
            }
        }
    }

    public boolean addStatInfo(String str, String str2) {
        if (a("addStatInfo")) {
            return false;
        }
        if (com.uc.crashsdk.a.g.a(str)) {
            throw null;
        }
        if (str.length() > 24) {
            throw new IllegalArgumentException("key is too long!");
        }
        if (str2 != null && str2.length() > 512) {
            str2 = str2.substring(0, 512);
        }
        return h.a(str, str2);
    }

    public String getCrashLogUploadUrl() {
        if (a("getCrashLogUploadUrl")) {
            return null;
        }
        return e.k();
    }

    public int getLastExitType() {
        if (a("getLastExitType")) {
            return 1;
        }
        return b.I();
    }

    public int getLastExitTypeEx() {
        if (a("getLastExitTypeEx")) {
            return 1;
        }
        return b.J();
    }

    public int getUnexpReason() {
        if (a("getUnexpReason")) {
            return 100;
        }
        return e.w();
    }

    public int reportCrashStats(boolean z) {
        if (a("reportCrashStats")) {
            return 0;
        }
        if (g.O()) {
            a.a("CrashApi::reportCrashStats. currentProcessOnly: " + z);
        }
        e.d(z);
        return e.e(z);
    }

    public int resetCrashStats(boolean z) {
        if (a("resetCrashStats")) {
            return 0;
        }
        if (g.O()) {
            a.a("CrashApi::resetCrashStats. currentProcessOnly: " + z);
        }
        return e.f(z);
    }

    public void onExit() {
        b.w();
    }

    public void setNewInstall() {
        if (a("setNewInstall")) {
            return;
        }
        b.v();
    }

    public void setForeground(boolean z) {
        b.b(z);
    }

    public void uploadCrashLogs() {
        if (a("uploadCrashLogs")) {
            return;
        }
        e.a(false, true);
    }

    public int registerThread(int i, String str) {
        return com.uc.crashsdk.a.a(i, str);
    }

    public boolean generateCustomLog(CustomLogInfo customLogInfo) {
        StringBuilder sb;
        customLogInfo.getClass();
        if (customLogInfo.mData == null || customLogInfo.mLogType == null) {
            throw new NullPointerException("mData or mLogType is null!");
        }
        if (customLogInfo.mLogType.contains("_") || customLogInfo.mLogType.contains(" ")) {
            throw new IllegalArgumentException("mLogType can not contain char '_' and ' '");
        }
        if (customLogInfo.mDumpTids == null || customLogInfo.mDumpTids.size() <= 0) {
            sb = null;
        } else {
            sb = new StringBuilder();
            Iterator<Integer> it = customLogInfo.mDumpTids.iterator();
            while (it.hasNext()) {
                sb.append(it.next().intValue());
                sb.append(" ");
            }
        }
        long j = customLogInfo.mAddHeader ? 1L : 0L;
        if (customLogInfo.mAddFooter) {
            j |= 2;
        }
        if (customLogInfo.mAddLogcat) {
            j |= 4;
        }
        if (customLogInfo.mAddThreadsDump) {
            j |= 8;
        }
        if (customLogInfo.mAddBuildId) {
            j |= 16;
        }
        if (customLogInfo.mUploadNow) {
            j |= 32;
        }
        return e.a(customLogInfo.mData, customLogInfo.mLogType, j, customLogInfo.mDumpFiles, customLogInfo.mCallbacks, customLogInfo.mCachedInfos, sb != null ? sb.toString() : null);
    }

    public boolean generateCustomLog(StringBuffer stringBuffer, String str, Bundle bundle) {
        CustomLogInfo customLogInfo = new CustomLogInfo(stringBuffer, str);
        if (bundle != null) {
            customLogInfo.mAddHeader = bundle.getBoolean("mAddHeader", customLogInfo.mAddHeader);
            customLogInfo.mAddFooter = bundle.getBoolean("mAddFooter", customLogInfo.mAddFooter);
            customLogInfo.mAddLogcat = bundle.getBoolean("mAddLogcat", customLogInfo.mAddLogcat);
            customLogInfo.mUploadNow = bundle.getBoolean("mUploadNow", customLogInfo.mUploadNow);
            customLogInfo.mAddThreadsDump = bundle.getBoolean("mAddThreadsDump", customLogInfo.mAddThreadsDump);
            customLogInfo.mAddBuildId = bundle.getBoolean("mAddBuildId", customLogInfo.mAddBuildId);
            customLogInfo.mDumpFiles = bundle.getStringArrayList("mDumpFiles");
            customLogInfo.mCallbacks = bundle.getStringArrayList("mCallbacks");
            customLogInfo.mCachedInfos = bundle.getStringArrayList("mCachedInfos");
            customLogInfo.mDumpTids = bundle.getIntegerArrayList("mDumpTids");
        }
        return generateCustomLog(customLogInfo);
    }

    public void addHeaderInfo(String str, String str2) {
        str.getClass();
        com.uc.crashsdk.a.a(str, str2);
    }

    public int createCachedInfo(String str, int i, int i2) {
        str.getClass();
        if (i <= 0) {
            throw new IllegalArgumentException("capacity must > 0!");
        }
        if ((1048849 & i2) == 0) {
            return 0;
        }
        return com.uc.crashsdk.a.a(str, i, i2);
    }

    public int addCachedInfo(String str, String str2) {
        if (str == null || str2 == null) {
            throw null;
        }
        return com.uc.crashsdk.a.b(str, str2);
    }

    public int registerInfoCallback(String str, int i) {
        str.getClass();
        if ((1048849 & i) == 0) {
            return 0;
        }
        return com.uc.crashsdk.a.a(str, i, null, 0L, 0);
    }

    public int registerInfoCallback(String str, int i, Callable<String> callable) {
        if (str == null || callable == null) {
            throw null;
        }
        if ((1048849 & i) == 0) {
            return 0;
        }
        return com.uc.crashsdk.a.a(str, i, callable, 0L, 0);
    }

    public int addDumpFile(DumpFileInfo dumpFileInfo) {
        dumpFileInfo.getClass();
        if (dumpFileInfo.mCategory == null || dumpFileInfo.mFileTobeDump == null) {
            throw null;
        }
        if ((dumpFileInfo.mLogType & 1048849) == 0) {
            return 0;
        }
        return com.uc.crashsdk.a.a(dumpFileInfo.mCategory, dumpFileInfo.mFileTobeDump, dumpFileInfo.mIsEncrypted, dumpFileInfo.mWriteCategory, dumpFileInfo.mLogType, dumpFileInfo.mDeleteAfterDump);
    }

    public int addDumpFile(String str, String str2, int i, Bundle bundle) {
        DumpFileInfo dumpFileInfo = new DumpFileInfo(str, str2, i);
        if (bundle != null) {
            dumpFileInfo.mIsEncrypted = bundle.getBoolean("mIsEncrypted", dumpFileInfo.mIsEncrypted);
            dumpFileInfo.mWriteCategory = bundle.getBoolean("mWriteCategory", dumpFileInfo.mWriteCategory);
            dumpFileInfo.mDeleteAfterDump = bundle.getBoolean("mDeleteAfterDump", dumpFileInfo.mDeleteAfterDump);
        }
        return addDumpFile(dumpFileInfo);
    }

    public Throwable getUncaughtException() {
        return e.v();
    }

    public boolean updateUnexpInfo() {
        if (a("updateUnexpInfo")) {
            return false;
        }
        return com.uc.crashsdk.a.a(true);
    }

    public ParcelFileDescriptor getHostFd() {
        return e.E();
    }

    public boolean setHostFd(ParcelFileDescriptor parcelFileDescriptor) {
        return e.a(parcelFileDescriptor);
    }

    public ParcelFileDescriptor getIsolatedHostFd() {
        return e.E();
    }

    public boolean setIsolatedHostFd(ParcelFileDescriptor parcelFileDescriptor) {
        return e.a(parcelFileDescriptor);
    }

    public boolean generateTraces(String str, long j) {
        if (a("generateTraces")) {
            return false;
        }
        if (b.d) {
            return JNIBridge.nativeCmd(12, j, str, null) == 1;
        }
        a.d("crashsdk", "Crash so is not loaded!");
        return false;
    }

    private CrashApi(Context context, CustomInfo customInfo, VersionInfo versionInfo, ICrashClient iCrashClient, boolean z, boolean z2, boolean z3) {
        this.b = false;
        Context contextA = a(context);
        b(contextA);
        b.g = z2;
        b.h = z3;
        if (b.L()) {
            b(contextA);
            a(contextA, customInfo, versionInfo, iCrashClient);
            if (z) {
                a();
            }
            if (b.g && e.e("libcrashsdk.so")) {
                b.f = true;
                b();
                return;
            }
            return;
        }
        if (customInfo == null || versionInfo == null) {
            a.d("crashsdk", "VersionInfo and CustomInfo can not be null!");
            throw null;
        }
        g.a(customInfo);
        try {
            a(contextA, customInfo, versionInfo, iCrashClient);
        } catch (Throwable th) {
            a(th);
        }
        if (z) {
            try {
                a();
            } catch (Throwable th2) {
                a(th2);
            }
        }
        try {
            b.M();
            h.a();
            com.uc.crashsdk.a.d.a();
            com.uc.crashsdk.a.g.j();
        } catch (Throwable th3) {
            com.uc.crashsdk.a.g.a(th3);
        }
        try {
            if (!b.a(contextA)) {
                a.d("crashsdk", "registerLifecycleCallbacks failed!");
            }
        } catch (Throwable th4) {
            com.uc.crashsdk.a.g.a(th4);
        }
        try {
            com.uc.crashsdk.a.n();
            try {
                e.A();
            } catch (Throwable th5) {
                com.uc.crashsdk.a.g.b(th5);
            }
            e.B();
        } catch (Throwable th6) {
            com.uc.crashsdk.a.g.a(th6);
        }
        try {
            if (g.r() && b.F() && !this.b) {
                e.G();
                this.b = true;
            }
        } catch (Throwable th7) {
            com.uc.crashsdk.a.g.b(th7);
        }
    }

    private static void a() {
        if (b.f2137a) {
            a.b("Has enabled java log!");
            return;
        }
        e.s();
        e.o();
        b.f2137a = true;
    }

    private static void b() {
        synchronized (b.e) {
            if (b.g && b.f) {
                if (b.b) {
                    a.b("Has enabled native log!");
                    return;
                }
                c();
                e.D();
                b.b = true;
                JNIBridge.cmd(6);
                g.d();
            }
        }
    }

    private static void a(Context context, CustomInfo customInfo, VersionInfo versionInfo, ICrashClient iCrashClient) {
        d.a(iCrashClient);
        g.a(customInfo, versionInfo);
        if (b.L()) {
            return;
        }
        e.p();
        e.a(context);
        e.b(context);
    }

    private static Context a(Context context) {
        if (context == null) {
            a.d("crashsdk", "context can not be null!");
            throw null;
        }
        if (!c || (context instanceof Application) || ((context = context.getApplicationContext()) != null && (context instanceof Application))) {
            return context;
        }
        a.d("crashsdk", "Can not get Application context from given context!");
        throw new IllegalArgumentException("Can not get Application context from given context!");
    }

    private static void b(Context context) {
        try {
            if (d) {
                return;
            }
            com.uc.crashsdk.a.g.a(context);
            com.uc.crashsdk.a.f2128a = context.getPackageName();
            d = true;
        } catch (Throwable th) {
            a(th);
        }
    }

    private static void c() {
        if (b.d) {
            return;
        }
        g.b();
        JNIBridge.cmd(5);
        g.c();
        b.d = true;
    }

    private static void a(Throwable th) {
        new e().a(Thread.currentThread(), th, true);
    }

    private static boolean a(String str) {
        if (!b.L()) {
            return false;
        }
        a.d("crashsdk", "Can not call '" + str + "' in isolated process!");
        return true;
    }
}
