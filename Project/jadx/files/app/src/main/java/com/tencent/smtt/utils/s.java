package com.tencent.smtt.utils;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.StatFs;
import android.text.TextUtils;
import android.util.Log;
import anet.channel.strategy.dispatch.DispatchConstants;
import com.ss.android.socialbase.downloader.constants.DownloadErrorCode;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.smtt.sdk.TbsConfig;
import com.tencent.smtt.sdk.TbsPrivacyAccess;
import com.tencent.smtt.sdk.TbsShareManager;
import com.tencent.smtt.sdk.c;
import com.umeng.message.proguard.ad;
import java.io.File;

/* JADX INFO: loaded from: classes3.dex */
public class s {
    private static File a = null;
    private static String b = "";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static String f19298c = "";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static int f19299d = -1;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static String f19300e = "";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static String f19301f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static int f19302g = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static String f19303h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static boolean f19304i = false;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static boolean f19305j = false;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static String f19306k = "unknown";

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static int f19307l = -1;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static int f19308m = -1;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static int f19309n = -1;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static int f19310o = -1;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static int f19311p = -1;

    public static long a() {
        StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        return ((long) statFs.getBlockSize()) * ((long) statFs.getAvailableBlocks());
    }

    public static void a(Context context, Bundle bundle) {
        try {
            SharedPreferences.Editor editorEdit = context.getSharedPreferences("sai", 0).edit();
            if (bundle.containsKey(QbSdk.KEY_THIRD_PARTY_TURING)) {
                boolean z2 = bundle.getBoolean(QbSdk.KEY_THIRD_PARTY_TURING);
                editorEdit.putBoolean("itge", z2);
                TbsLog.e("TbsUtils", "setEnableForThirdParty key is itge value is " + z2);
            }
            editorEdit.commit();
        } catch (Throwable unused) {
        }
    }

    public static void a(Context context, String str, String str2) {
        String str3;
        try {
            if (TbsShareManager.isThirdPartyApp(context) && g(context)) {
                String str4 = "thirdapp_" + str;
                if (TextUtils.isEmpty(str2)) {
                    str3 = "";
                } else {
                    str3 = str2 + "_";
                }
                StringBuilder sb = new StringBuilder();
                sb.append(str3);
                sb.append("mycpuis");
                sb.append(b.c() ? 64 : 32);
                String str5 = (sb.toString() + "_64scoreis" + TbsShareManager.getTbsStableCoreVersion(context, 64)) + "_32scoreis" + TbsShareManager.getTbsStableCoreVersion(context, 32);
                com.tencent.smtt.sdk.stat.b.a(context, str4, str5);
                TbsLog.i("uploadThirdAppCoreUpdate", "action is " + str4 + " p1 is " + str5);
            }
        } catch (Throwable th) {
            TbsLog.i("uploadThirdAppCoreUpdate", "stack is  " + Log.getStackTraceString(th));
        }
    }

    public static void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (!TextUtils.isEmpty(b)) {
            str = b + DispatchConstants.SIGN_SPLIT_SYMBOL + str;
        }
        b = str;
    }

    @TargetApi(9)
    public static boolean a(Context context) {
        File tbsFolderDir;
        if (context == null) {
            return false;
        }
        if (a != null) {
            return true;
        }
        try {
            if (context.getApplicationInfo().processName.contains("com.tencent.mm") && (tbsFolderDir = QbSdk.getTbsFolderDir(context)) != null && tbsFolderDir.isDirectory()) {
                File file = new File(tbsFolderDir, "share");
                if (!file.isDirectory() && !file.mkdir()) {
                    return false;
                }
                a = file;
                file.setExecutable(true, false);
                return true;
            }
            return false;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public static void b() {
        b = "";
    }

    public static void b(String str) {
        f19300e = str;
    }

    public static boolean b(Context context) {
        boolean z2 = false;
        try {
            if (TbsShareManager.isThirdPartyApp(context)) {
                TbsLog.i("TbsUtils", "isStableCoreForHostEnable app is thirdapp return is false ");
                return false;
            }
        } catch (Throwable th) {
            TbsLog.i("TbsUtils", "stack is " + Log.getStackTraceString(th));
        }
        try {
            final Context applicationContext = context.getApplicationContext();
            z2 = applicationContext.getSharedPreferences("sai", 0).getBoolean("scfh", true);
            TbsLog.i("TbsUtils", "isStableCoreForHostEnable is " + z2);
            com.tencent.smtt.sdk.c cVarA = com.tencent.smtt.sdk.c.a();
            cVarA.a(context, (Integer) 1003, new c.a() { // from class: com.tencent.smtt.utils.s.1
                @Override // com.tencent.smtt.sdk.c.a
                public void a(String str) {
                    SharedPreferences.Editor editorEdit = applicationContext.getSharedPreferences("sai", 0).edit();
                    editorEdit.putBoolean("scfh", true);
                    editorEdit.commit();
                    TbsLog.e("TbsUtils", "Execute command [1003](" + str + ad.f20406s);
                }
            });
            cVarA.a(context, (Integer) 1009, new c.a() { // from class: com.tencent.smtt.utils.s.7
                @Override // com.tencent.smtt.sdk.c.a
                public void a(String str) {
                    SharedPreferences.Editor editorEdit = applicationContext.getSharedPreferences("sai", 0).edit();
                    editorEdit.putBoolean("scfh", false);
                    editorEdit.commit();
                    TbsLog.e("TbsUtils", "Execute command [1009](" + str + ad.f20406s);
                }
            });
            return z2;
        } catch (Throwable th2) {
            TbsLog.i("TbsUtils", "stack is " + Log.getStackTraceString(th2));
            return z2;
        }
    }

    public static String c(Context context) {
        SharedPreferences sharedPreferences;
        if (!TextUtils.isEmpty(f19298c)) {
            return f19298c;
        }
        try {
            sharedPreferences = context.getSharedPreferences("sai", 0);
            f19298c = sharedPreferences.getString("bmo", "");
        } catch (Throwable th) {
            TbsLog.i("TbsUtils", "stack is " + Log.getStackTraceString(th));
        }
        if (!TextUtils.isEmpty(f19298c)) {
            return f19298c;
        }
        f19298c = TbsPrivacyAccess.getConfigurePrivacy(context, TbsPrivacyAccess.ConfigurablePrivacy.MODEL, "");
        TbsLog.i("TbsUtils", "getBuildModel from sp is " + f19298c);
        if (!TextUtils.isEmpty(f19298c)) {
            return f19298c;
        }
        if (TextUtils.isEmpty(f19298c) && !context.getApplicationInfo().packageName.contains(TbsConfig.APP_QQ)) {
            f19298c = Build.MODEL;
        }
        TbsLog.i("TbsUtils", "getBuildModel is " + f19298c);
        if (!TextUtils.isEmpty(f19298c)) {
            TbsPrivacyAccess.configurePrivacy(context, TbsPrivacyAccess.ConfigurablePrivacy.MODEL, f19298c);
            SharedPreferences.Editor editorEdit = sharedPreferences.edit();
            editorEdit.putString("bmo", f19298c);
            editorEdit.commit();
        }
        return f19298c;
    }

    public static boolean d(Context context) {
        boolean z2 = false;
        try {
            final Context applicationContext = context.getApplicationContext();
            z2 = applicationContext.getSharedPreferences("sai", 0).getBoolean("rrff", false);
            TbsLog.i("TbsUtils", "isReadResponseFromFileEnable is " + z2);
            com.tencent.smtt.sdk.c.a().a(context, (Integer) 1006, new c.a() { // from class: com.tencent.smtt.utils.s.8
                @Override // com.tencent.smtt.sdk.c.a
                public void a(String str) {
                    SharedPreferences.Editor editorEdit = applicationContext.getSharedPreferences("sai", 0).edit();
                    editorEdit.putBoolean("rrff", true);
                    editorEdit.commit();
                    TbsLog.e("TbsUtils", "Execute command [1006](" + str + ad.f20406s);
                }
            });
            return z2;
        } catch (Throwable th) {
            TbsLog.i("TbsUtils", "stack is " + Log.getStackTraceString(th));
            return z2;
        }
    }

    public static boolean e(Context context) {
        boolean z2 = false;
        try {
            final Context applicationContext = context.getApplicationContext();
            z2 = applicationContext.getSharedPreferences("sai", 0).getBoolean("fwdn", false);
            TbsLog.i("TbsUtils", "isReadResponseFromFileEnable is " + z2);
            com.tencent.smtt.sdk.c cVarA = com.tencent.smtt.sdk.c.a();
            cVarA.a(context, (Integer) 1007, new c.a() { // from class: com.tencent.smtt.utils.s.9
                @Override // com.tencent.smtt.sdk.c.a
                public void a(String str) {
                    SharedPreferences.Editor editorEdit = applicationContext.getSharedPreferences("sai", 0).edit();
                    editorEdit.putBoolean("fwdn", true);
                    editorEdit.commit();
                    TbsLog.e("TbsUtils", "Execute command 1007(" + str + ad.f20406s);
                }
            });
            cVarA.a(context, (Integer) 1008, new c.a() { // from class: com.tencent.smtt.utils.s.10
                @Override // com.tencent.smtt.sdk.c.a
                public void a(String str) {
                    SharedPreferences.Editor editorEdit = applicationContext.getSharedPreferences("sai", 0).edit();
                    editorEdit.putBoolean("fwdn", false);
                    editorEdit.commit();
                    TbsLog.e("TbsUtils", "Execute command 1008(" + str + ad.f20406s);
                }
            });
            return z2;
        } catch (Throwable th) {
            TbsLog.i("TbsUtils", "stack is " + Log.getStackTraceString(th));
            return z2;
        }
    }

    public static boolean f(Context context) {
        boolean z2 = true;
        try {
            final Context applicationContext = context.getApplicationContext();
            z2 = applicationContext.getSharedPreferences("sai", 0).getBoolean("cbau", true);
            TbsLog.i("TbsUtils", "isClearBackupEnable is " + z2);
            com.tencent.smtt.sdk.c cVarA = com.tencent.smtt.sdk.c.a();
            cVarA.a(context, (Integer) 1013, new c.a() { // from class: com.tencent.smtt.utils.s.11
                @Override // com.tencent.smtt.sdk.c.a
                public void a(String str) {
                    SharedPreferences.Editor editorEdit = applicationContext.getSharedPreferences("sai", 0).edit();
                    editorEdit.putBoolean("cbau", true);
                    editorEdit.commit();
                    TbsLog.e("TbsUtils", "Execute command [1013](" + str + ad.f20406s);
                }
            });
            cVarA.a(context, (Integer) 1014, new c.a() { // from class: com.tencent.smtt.utils.s.12
                @Override // com.tencent.smtt.sdk.c.a
                public void a(String str) {
                    SharedPreferences.Editor editorEdit = applicationContext.getSharedPreferences("sai", 0).edit();
                    editorEdit.putBoolean("cbau", false);
                    editorEdit.commit();
                    TbsLog.e("TbsUtils", "Execute command [1014](" + str + ad.f20406s);
                }
            });
            return z2;
        } catch (Throwable th) {
            TbsLog.i("TbsUtils", "stack is " + Log.getStackTraceString(th));
            return z2;
        }
    }

    public static boolean g(Context context) {
        boolean z2 = false;
        try {
            final Context applicationContext = context.getApplicationContext();
            z2 = applicationContext.getSharedPreferences("sai", 0).getBoolean("utcu", false);
            TbsLog.i("TbsUtils", "isUploadThirdAppCoreUpdateEnable is " + z2);
            com.tencent.smtt.sdk.c cVarA = com.tencent.smtt.sdk.c.a();
            cVarA.a(context, (Integer) 1019, new c.a() { // from class: com.tencent.smtt.utils.s.2
                @Override // com.tencent.smtt.sdk.c.a
                public void a(String str) {
                    SharedPreferences.Editor editorEdit = applicationContext.getSharedPreferences("sai", 0).edit();
                    editorEdit.putBoolean("utcu", true);
                    editorEdit.commit();
                    TbsLog.e("TbsUtils", "Execute command [1019](" + str + ad.f20406s);
                }
            });
            cVarA.a(context, (Integer) 1020, new c.a() { // from class: com.tencent.smtt.utils.s.3
                @Override // com.tencent.smtt.sdk.c.a
                public void a(String str) {
                    SharedPreferences.Editor editorEdit = applicationContext.getSharedPreferences("sai", 0).edit();
                    editorEdit.putBoolean("utcu", false);
                    editorEdit.commit();
                    TbsLog.e("TbsUtils", "Execute command [1020](" + str + ad.f20406s);
                }
            });
            return z2;
        } catch (Throwable th) {
            TbsLog.i("TbsUtils", "stack is " + Log.getStackTraceString(th));
            return z2;
        }
    }

    public static boolean h(Context context) {
        boolean z2 = true;
        try {
            final Context applicationContext = context.getApplicationContext();
            z2 = applicationContext.getSharedPreferences("sai", 0).getBoolean("itge", true);
            TbsLog.i("TbsUtils", "isTuringEnable is " + z2);
            com.tencent.smtt.sdk.c cVarA = com.tencent.smtt.sdk.c.a();
            cVarA.a(context, (Integer) 1021, new c.a() { // from class: com.tencent.smtt.utils.s.4
                @Override // com.tencent.smtt.sdk.c.a
                public void a(String str) {
                    SharedPreferences.Editor editorEdit = applicationContext.getSharedPreferences("sai", 0).edit();
                    editorEdit.putBoolean("itge", true);
                    editorEdit.commit();
                    TbsLog.e("TbsUtils", "Execute command [1021](" + str + ad.f20406s);
                }
            });
            cVarA.a(context, Integer.valueOf(DownloadErrorCode.ERROR_NO_CONNECTION), new c.a() { // from class: com.tencent.smtt.utils.s.5
                @Override // com.tencent.smtt.sdk.c.a
                public void a(String str) {
                    SharedPreferences.Editor editorEdit = applicationContext.getSharedPreferences("sai", 0).edit();
                    editorEdit.putBoolean("itge", false);
                    editorEdit.commit();
                    TbsLog.e("TbsUtils", "Execute command [1022](" + str + ad.f20406s);
                }
            });
            return z2;
        } catch (Throwable th) {
            TbsLog.i("TbsUtils", "stack is " + Log.getStackTraceString(th));
            return z2;
        }
    }

    public static String i(Context context) {
        String string = "removenone";
        try {
            final Context applicationContext = context.getApplicationContext();
            string = context.getSharedPreferences("sai", 0).getString("grpis", "removenone");
            com.tencent.smtt.sdk.c.a().a(context, Integer.valueOf(DownloadErrorCode.ERROR_CUR_NOT_EQUALS_TOTAL), new c.a() { // from class: com.tencent.smtt.utils.s.6
                @Override // com.tencent.smtt.sdk.c.a
                public void a(String str) {
                    TbsLog.i("TbsUtils", "getRmPrivacyItemState callback is " + str);
                    SharedPreferences.Editor editorEdit = applicationContext.getSharedPreferences("sai", 0).edit();
                    editorEdit.putString("grpis", str);
                    editorEdit.commit();
                }
            });
        } catch (Throwable th) {
            TbsLog.i("TbsUtils", "stack is " + Log.getStackTraceString(th));
        }
        TbsLog.i("TbsUtils", "getRmPrivacyItemState result is " + string);
        return string;
    }
}
