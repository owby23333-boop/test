package com.tencent.smtt.sdk;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import anet.channel.util.ErrorConstant;
import com.tencent.smtt.utils.FileUtil;
import com.tencent.smtt.utils.TbsLog;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/* JADX INFO: loaded from: classes3.dex */
public class TbsShareManager {
    private static Context a = null;
    private static boolean b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static String f18933c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static String f18934d = "";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static String f18935e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static int f18936f = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static String f18937g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static boolean f18938h = false;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static boolean f18939i = false;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static boolean f18940j = false;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static String f18941k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static boolean f18942l = false;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static boolean f18943m = false;
    public static boolean mHasQueryed = false;

    private static int a(Context context, String str, int i2) {
        File file;
        try {
            file = new File(new File(FileUtil.a(getPackageContext(context, str, false), i2)), TbsDownloader.getBackupFileName(false));
        } catch (Throwable unused) {
            TbsLog.i("TbsShareManager", "getSDCoreVersion exception,pkg=" + str + ", SDCardStatus: " + com.tencent.smtt.utils.b.l(context));
        }
        if (file.exists() && file.canRead()) {
            return com.tencent.smtt.utils.a.b(file);
        }
        TbsLog.i("TbsShareManager", "getSDCoreVersion,file not exist" + file);
        return 0;
    }

    static String a(Context context) {
        try {
            b(context);
            if (f18935e != null && !TextUtils.isEmpty(f18935e)) {
                return f18935e + File.separator + "res.apk";
            }
            return null;
        } catch (Throwable th) {
            String str = "getTbsResourcesPath exception: " + Log.getStackTraceString(th);
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:69:0x0118 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void b(android.content.Context r7) {
        /*
            Method dump skipped, instruction units count: 305
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.sdk.TbsShareManager.b(android.content.Context):void");
    }

    @Deprecated
    public static int findCoreForThirdPartyApp(Context context) {
        return -1;
    }

    public static boolean forceLoadX5FromTBSDemo(Context context) {
        int sharedTbsCoreVersion;
        if (context == null || o.a().a(context, (File[]) null) || (sharedTbsCoreVersion = getSharedTbsCoreVersion(context, TbsConfig.APP_DEMO)) <= 0) {
            return false;
        }
        writeProperties(context, Integer.toString(sharedTbsCoreVersion), TbsConfig.APP_DEMO, o.a().p(getPackageContext(context, TbsConfig.APP_DEMO, true)).getAbsolutePath(), "1");
        return true;
    }

    public static File getBackupCoreFile(Context context, String str) {
        return getSDCoreFile(context, str, 3);
    }

    public static int getBackupCoreVersion(Context context, String str) {
        return a(context, str, 3);
    }

    public static File getBackupDecoupleCoreFile(Context context, String str) {
        try {
            File file = new File(new File(FileUtil.a(getPackageContext(context, str, false), 4)), TbsDownloader.getBackupFileName(true));
            if (file.exists()) {
                return file;
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static int getBackupDecoupleCoreVersion(Context context, String str) {
        try {
            File file = new File(new File(FileUtil.a(getPackageContext(context, str, false), 4)), TbsDownloader.getBackupFileName(true));
            if (file.exists() && file.canRead()) {
                return com.tencent.smtt.utils.a.b(file);
            }
        } catch (Throwable unused) {
            TbsLog.i("TbsShareManager", "getBackupDecoupleCoreVersion exception,pkg=" + str + ",package not found.");
        }
        return 0;
    }

    public static boolean getCoreDisabled() {
        return f18938h;
    }

    public static boolean getCoreFormOwn() {
        return f18942l;
    }

    @Deprecated
    public static String[] getCoreProviderAppList() {
        return new String[0];
    }

    public static int getCoreShareDecoupleCoreVersion(Context context, String str) {
        Context packageContext = getPackageContext(context, str, true);
        if (packageContext != null) {
            return o.a().g(packageContext);
        }
        return 0;
    }

    public static String getHostCorePathAppDefined() {
        return f18933c;
    }

    public static Context getPackageContext(Context context, String str, boolean z2) {
        if (context != null && context.getPackageName().equals(str)) {
            return context;
        }
        if (context == null) {
            TbsLog.e("TbsShareManager", "getPackageContext appContext is null!!");
            return null;
        }
        if (z2) {
            try {
                if (!context.getPackageName().equals(str) && (TbsPVConfig.getInstance(context).isEnableNoCoreGray() || Build.VERSION.SDK_INT >= 29)) {
                    return null;
                }
            } catch (Throwable unused) {
                return null;
            }
        }
        return context.createPackageContext(str, 2);
    }

    public static File getSDCoreFile(Context context, String str, int i2) {
        try {
            File file = new File(new File(FileUtil.a(getPackageContext(context, str, false), i2)), TbsDownloader.getBackupFileName(false));
            if (!file.exists()) {
                return null;
            }
            if (file.canRead()) {
                return file;
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static int getSharedTbsCoreVersion(Context context, String str) {
        Context packageContext = getPackageContext(context, str, true);
        if (packageContext != null) {
            return o.a().h(packageContext);
        }
        return 0;
    }

    public static File getStableCoreFile(Context context, String str) {
        return getSDCoreFile(context, str, 4);
    }

    public static int getStableCoreVersion(Context context, String str) {
        return a(context, str, 4);
    }

    public static String getStableCoreZeroReason() {
        return f18934d;
    }

    public static File getTbsShareFile(Context context, String str) {
        File fileQ = o.a().q(context);
        if (fileQ == null) {
            return null;
        }
        File file = new File(fileQ, str);
        if (file.exists()) {
            return file;
        }
        try {
            file.createNewFile();
            return file;
        } catch (IOException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    @Deprecated
    public static int getTbsStableCoreVersion(Context context, int i2) {
        try {
        } catch (Throwable th) {
            TbsLog.i(TbsDownloader.LOGTAG, "getTbsStableCoreVersion stack is " + Log.getStackTraceString(th));
            f18934d = Log.getStackTraceString(th);
        }
        if (!context.getApplicationInfo().packageName.contains("com.tencent.mm")) {
            return 0;
        }
        Context packageContext = getPackageContext(context, "com.tencent.mm", false);
        File file = new File(packageContext == null ? new File(FileUtil.a(context, "com.tencent.mm", 4, true)) : new File(FileUtil.a(packageContext, 4)), TbsDownloader.getBackupFileName(false, i2));
        TbsLog.i(TbsDownloader.LOGTAG, "getTbsStableCoreVersion, coreStable is " + file.getAbsolutePath());
        f18934d = "none";
        if (file.exists() && file.canRead()) {
            int iB = com.tencent.smtt.utils.a.b(file);
            return iB <= 0 ? com.tencent.smtt.utils.a.a(context, file, i2) : iB;
        }
        TbsLog.i(TbsDownloader.LOGTAG, "getTbsStableCoreVersion,core stable not exist" + file);
        f18934d = file.getAbsolutePath() + " exist is " + file.exists() + " canRead is " + file.canRead();
        return 0;
    }

    public static boolean isThirdPartyApp(Context context) {
        try {
        } catch (Throwable th) {
            TbsLog.i(th);
        }
        if (a != null && a.equals(context.getApplicationContext())) {
            return b;
        }
        a = context.getApplicationContext();
        String packageName = a.getPackageName();
        for (String str : new String[]{TbsConfig.APP_DEMO, "com.tencent.mm", TbsConfig.APP_QQ, TbsConfig.APP_QZONE, "com.tencent.qqlite"}) {
            if (packageName.equals(str)) {
                b = false;
                return false;
            }
        }
        b = true;
        return true;
    }

    public static void setHostCorePathAppDefined(String str) {
        f18933c = str;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:41:0x00dd -> B:59:0x00e0). Please report as a decompilation issue!!! */
    public static void writeProperties(Context context, String str, String str2, String str3, String str4) {
        BufferedInputStream bufferedInputStream;
        File tbsShareFile;
        Properties properties;
        int i2;
        BufferedOutputStream bufferedOutputStream;
        TbsLog.i("TbsShareManager", "writeProperties coreVersion is " + str + " corePackageName is " + str2 + " corePath is " + str3);
        StringBuilder sb = new StringBuilder();
        sb.append("writeProperties -- stack: ");
        sb.append(Log.getStackTraceString(new Throwable("#")));
        TbsLog.i("TbsShareManager", sb.toString());
        BufferedOutputStream bufferedOutputStream2 = null;
        try {
            try {
                tbsShareFile = getTbsShareFile(context, "core_info");
            } catch (Throwable th) {
                th = th;
                bufferedInputStream = null;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        if (tbsShareFile == null) {
            TbsDownloadConfig.getInstance(a).setDownloadInterruptCode(ErrorConstant.ERROR_UNKNOWN_HOST_EXCEPTION);
            return;
        }
        bufferedInputStream = new BufferedInputStream(new FileInputStream(tbsShareFile));
        try {
            properties = new Properties();
            properties.load(bufferedInputStream);
            try {
                i2 = Integer.parseInt(str);
            } catch (Exception unused) {
                i2 = 0;
            }
            if (i2 != 0) {
                properties.setProperty("core_version", str);
                properties.setProperty("core_disabled", String.valueOf(false));
                properties.setProperty("core_packagename", str2);
                properties.setProperty("core_path", str3);
                properties.setProperty("app_version", str4);
            } else {
                properties.setProperty("core_disabled", String.valueOf(true));
            }
            bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(tbsShareFile));
        } catch (Throwable th2) {
            th = th2;
        }
        try {
            properties.store(bufferedOutputStream, (String) null);
            f18943m = false;
            TbsDownloadConfig.getInstance(a).setDownloadInterruptCode(ErrorConstant.ERROR_CONNECT_EXCEPTION);
            try {
                bufferedInputStream.close();
            } catch (Exception e3) {
                e3.printStackTrace();
            }
            bufferedOutputStream.close();
        } catch (Throwable th3) {
            bufferedOutputStream2 = bufferedOutputStream;
            th = th3;
            try {
                th.printStackTrace();
                if (bufferedInputStream != null) {
                    try {
                        bufferedInputStream.close();
                    } catch (Exception e4) {
                        e4.printStackTrace();
                    }
                }
                if (bufferedOutputStream2 == null) {
                } else {
                    bufferedOutputStream2.close();
                }
            } finally {
            }
        }
    }
}
