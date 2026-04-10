package com.ss.android.downloadlib.utils;

import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.text.TextUtils;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import com.ss.android.ttmd5.TTMd5;
import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/* JADX INFO: loaded from: classes3.dex */
public class mb {

    /* JADX INFO: renamed from: com.ss.android.downloadlib.utils.mb$mb, reason: collision with other inner class name */
    private static class C0519mb implements InvocationHandler {
        private Object mb;

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            try {
                if ("startActivity".contains(method.getName())) {
                    mb.mb(objArr);
                }
            } catch (Throwable unused) {
            }
            return method.invoke(this.mb, objArr);
        }

        private C0519mb(Object obj) {
            this.mb = obj;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b() {
        Class<?> cls;
        try {
            Field declaredField = Build.VERSION.SDK_INT < 26 ? Class.forName("android.app.ActivityManagerNative").getDeclaredField("gDefault") : Class.forName("android.app.ActivityManager").getDeclaredField("IActivityManagerSingleton");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(null);
            Field declaredField2 = Class.forName("android.util.Singleton").getDeclaredField("mInstance");
            declaredField2.setAccessible(true);
            Object obj2 = declaredField2.get(obj);
            if (obj2 == null || (cls = Class.forName("android.app.IActivityManager")) == null) {
                return;
            }
            declaredField2.set(obj, Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), new Class[]{cls}, new C0519mb(obj2)));
        } catch (Throwable unused) {
        }
    }

    public static String mb(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return TTMd5.ttmd5(new File(str));
    }

    public static String ox(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            ApplicationInfo applicationInfo = com.ss.android.downloadlib.addownload.x.getContext().getPackageManager().getApplicationInfo(str, 0);
            if (applicationInfo != null) {
                return applicationInfo.sourceDir;
            }
        } catch (Exception unused) {
        }
        return null;
    }

    public static int mb(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return 5;
        }
        return TTMd5.checkMd5(str, new File(str2));
    }

    public static void mb() {
        if (com.ss.android.downloadlib.addownload.x.lz().optInt("hook", 0) != 1) {
            return;
        }
        com.ss.android.downloadlib.hj.mb().mb(new Runnable() { // from class: com.ss.android.downloadlib.utils.mb.1
            @Override // java.lang.Runnable
            public void run() {
                com.ss.android.socialbase.appdownloader.u.hj.ko();
                mb.b();
            }
        }, 10000L);
    }

    public static void mb(Object[] objArr) {
        if (com.ss.android.downloadlib.addownload.x.lz().optInt("hook", 0) == 1 && (objArr[1] instanceof String) && (objArr[2] instanceof Intent)) {
            Intent intent = (Intent) objArr[2];
            if ("android.intent.action.VIEW".equals(intent.getAction()) && DownloadConstants.MIME_APK.equals(intent.getType())) {
                if (com.ss.android.socialbase.appdownloader.u.hj.b()) {
                    String strOptString = com.ss.android.downloadlib.addownload.x.lz().optString("hook_vivo_arg", "com.android.settings");
                    if ("null".equals(strOptString)) {
                        return;
                    }
                    objArr[1] = strOptString;
                    return;
                }
                if (com.ss.android.socialbase.appdownloader.u.hj.hj()) {
                    String strOptString2 = com.ss.android.downloadlib.addownload.x.lz().optString("hook_kllk_arg1", "com." + DownloadConstants.LOWER_OPPO + ".market");
                    if (!"null".equals(strOptString2)) {
                        objArr[1] = strOptString2;
                    }
                    String strOptString3 = com.ss.android.downloadlib.addownload.x.lz().optString("hook_kllk_arg2", "com.android.browser");
                    String strOptString4 = com.ss.android.downloadlib.addownload.x.lz().optString("hook_kllk_arg3", "m.store." + DownloadConstants.LOWER_OPPO + "mobile.com");
                    StringBuilder sb = new StringBuilder();
                    sb.append(DownloadConstants.LOWER_OPPO);
                    sb.append("_extra_pkg_name");
                    intent.putExtra(sb.toString(), strOptString3);
                    intent.putExtra("refererHost", strOptString4);
                    if (com.ss.android.downloadlib.addownload.x.lz().optInt("hook_kllk_arg4", 0) == 1) {
                        Intent intent2 = new Intent();
                        intent2.putExtra(DownloadConstants.LOWER_OPPO + "_extra_pkg_name", strOptString3);
                        intent2.putExtra("refererHost", strOptString4);
                        intent.putExtra("android.intent.extra.INTENT", intent2);
                        return;
                    }
                    return;
                }
                if (com.ss.android.socialbase.appdownloader.u.hj.mb()) {
                    String strOptString5 = com.ss.android.downloadlib.addownload.x.lz().optString("hook_huawei_arg1", "com.huawei.appmarket");
                    if (!"null".equals(strOptString5)) {
                        objArr[1] = strOptString5;
                    }
                    intent.putExtra("caller_package", com.ss.android.downloadlib.addownload.x.lz().optString("hook_huawei_arg2", "com.huawei.appmarket"));
                }
            }
        }
    }
}
