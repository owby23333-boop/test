package com.tencent.smtt.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.smtt.export.external.DexLoader;
import com.tencent.smtt.utils.TbsLog;
import java.io.File;
import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public class TbsExtensionFunctionManager {
    public static final String BUGLY_SWITCH_FILE_NAME = "bugly_switch.txt";
    public static final String COOKIE_SWITCH_FILE_NAME = "cookie_switch.txt";
    public static final String DISABLE_GET_APK_VERSION_SWITCH_FILE_NAME = "disable_get_apk_version_switch.txt";
    public static final String DISABLE_UNPREINIT = "disable_unpreinit.txt";
    public static final String DISABLE_USE_HOST_BACKUP_CORE = "disable_use_host_backup_core.txt";
    public static final String SP_KEY_COOKIE_DB_VERSION = "cookie_db_version";
    public static final String SP_NAME_FOR_COOKIE = "cookie_compatiable";
    public static final int SWITCH_BYTE_COOKIE = 1;
    public static final int SWITCH_BYTE_DISABLE_GET_APK_VERSION = 2;
    public static final int SWITCH_BYTE_DISABLE_UNPREINIT = 4;
    public static final int SWITCH_BYTE_DISABLE_USE_HOST_BACKUPCORE = 8;
    public static final String USEX5_FILE_NAME = "usex5.txt";
    private static TbsExtensionFunctionManager b;
    private boolean a;

    private TbsExtensionFunctionManager() {
    }

    public static TbsExtensionFunctionManager getInstance() {
        if (b == null) {
            synchronized (TbsExtensionFunctionManager.class) {
                if (b == null) {
                    b = new TbsExtensionFunctionManager();
                }
            }
        }
        return b;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0019  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized boolean canUseFunction(android.content.Context r2, java.lang.String r3) {
        /*
            r1 = this;
            monitor-enter(r1)
            java.io.File r0 = new java.io.File     // Catch: java.lang.Throwable -> L1b
            java.io.File r2 = r2.getFilesDir()     // Catch: java.lang.Throwable -> L1b
            r0.<init>(r2, r3)     // Catch: java.lang.Throwable -> L1b
            boolean r2 = r0.exists()     // Catch: java.lang.Throwable -> L1b
            if (r2 == 0) goto L19
            boolean r2 = r0.isFile()     // Catch: java.lang.Throwable -> L1b
            if (r2 == 0) goto L19
            r2 = 1
        L17:
            monitor-exit(r1)
            return r2
        L19:
            r2 = 0
            goto L17
        L1b:
            r2 = move-exception
            monitor-exit(r1)
            goto L1f
        L1e:
            throw r2
        L1f:
            goto L1e
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.sdk.TbsExtensionFunctionManager.canUseFunction(android.content.Context, java.lang.String):boolean");
    }

    public synchronized int getRomCookieDBVersion(Context context) {
        SharedPreferences sharedPreferences = Build.VERSION.SDK_INT >= 11 ? context.getSharedPreferences(SP_NAME_FOR_COOKIE, 4) : context.getSharedPreferences(SP_NAME_FOR_COOKIE, 0);
        if (sharedPreferences == null) {
            return -1;
        }
        return sharedPreferences.getInt(SP_KEY_COOKIE_DB_VERSION, -1);
    }

    public synchronized void initTbsBuglyIfNeed(Context context) {
        if (this.a) {
            return;
        }
        if (!canUseFunction(context, BUGLY_SWITCH_FILE_NAME)) {
            TbsLog.i("TbsExtensionFunMana", "bugly is forbiden!!");
            return;
        }
        File fileP = o.a().p(context);
        if (fileP == null) {
            TbsLog.i("TbsExtensionFunMana", "getTbsCoreShareDir is null");
            return;
        }
        if (fileP.listFiles() != null && fileP.listFiles().length > 0) {
            String absolutePath = fileP.getAbsolutePath();
            if (TextUtils.isEmpty(absolutePath)) {
                TbsLog.i("TbsExtensionFunMana", "bugly init ,corePath is null");
                return;
            }
            File fileP2 = o.a().p(context);
            if (fileP2 == null) {
                TbsLog.i("TbsExtensionFunMana", "bugly init ,optDir is null");
                return;
            }
            File file = new File(absolutePath, "tbs_bugly_dex.jar");
            try {
                com.tencent.smtt.utils.j.a(new DexLoader(file.getParent(), context, new String[]{file.getAbsolutePath()}, fileP2.getAbsolutePath(), QbSdk.getSettings()).loadClass("com.tencent.smtt.tbs.bugly.TBSBuglyManager"), "initBugly", (Class<?>[]) new Class[]{Context.class, String.class, String.class, String.class}, context, absolutePath, String.valueOf(WebView.getTbsSDKVersion(context)), String.valueOf(WebView.getTbsCoreVersion(context)));
                this.a = true;
                TbsLog.i("TbsExtensionFunMana", "initTbsBuglyIfNeed success!");
                return;
            } catch (Throwable th) {
                TbsLog.i("TbsExtensionFunMana", "bugly init ,try init bugly failed(need new core):" + Log.getStackTraceString(th));
                return;
            }
        }
        TbsLog.i("TbsExtensionFunMana", "getTbsCoreShareDir is empty!");
    }

    public synchronized boolean setFunctionEnable(Context context, String str, boolean z2) {
        if (context == null) {
            return false;
        }
        File file = new File(context.getFilesDir(), str);
        if (z2) {
            if (!file.exists()) {
                try {
                    if (file.createNewFile()) {
                        return true;
                    }
                } catch (IOException e2) {
                    TbsLog.e("TbsExtensionFunMana", "setFunctionEnable,createNewFile fail:" + str);
                    e2.printStackTrace();
                    return false;
                }
            }
        } else if (file.exists()) {
            if (file.delete()) {
                return true;
            }
            TbsLog.e("TbsExtensionFunMana", "setFunctionEnable,file.delete fail:" + str);
            return false;
        }
        return true;
    }
}
