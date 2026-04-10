package com.ss.android.downloadlib.e;

import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.ILivePlayer;
import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/* JADX INFO: loaded from: classes4.dex */
public class z {
    public static String z(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return com.ss.android.dl.dl.z(new File(str));
    }

    public static int z(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return 5;
        }
        return com.ss.android.dl.dl.z(str, new File(str2));
    }

    public static String g(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            ApplicationInfo applicationInfo = com.ss.android.downloadlib.addownload.wp.getContext().getPackageManager().getApplicationInfo(str, 0);
            if (applicationInfo != null) {
                return applicationInfo.sourceDir;
            }
        } catch (Exception unused) {
        }
        return null;
    }

    public static void z() {
        if (com.ss.android.downloadlib.addownload.wp.fo().optInt("hook", 0) != 1) {
            return;
        }
        com.ss.android.downloadlib.gc.z().z(new Runnable() { // from class: com.ss.android.downloadlib.e.z.1
            @Override // java.lang.Runnable
            public void run() {
                com.ss.android.socialbase.appdownloader.m.gc.gz();
                z.dl();
            }
        }, ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void dl() {
        Class<?> cls;
        try {
            Field declaredField = Class.forName("android.app.ActivityManager").getDeclaredField("IActivityManagerSingleton");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(null);
            Field declaredField2 = Class.forName("android.util.Singleton").getDeclaredField("mInstance");
            declaredField2.setAccessible(true);
            Object obj2 = declaredField2.get(obj);
            if (obj2 == null || (cls = Class.forName("android.app.IActivityManager")) == null) {
                return;
            }
            declaredField2.set(obj, Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), new Class[]{cls}, new C0444z(obj2)));
        } catch (Throwable unused) {
        }
    }

    public static void z(Object[] objArr) {
        if (com.ss.android.downloadlib.addownload.wp.fo().optInt("hook", 0) == 1 && (objArr[1] instanceof String)) {
            Object obj = objArr[2];
            if (obj instanceof Intent) {
                Intent intent = (Intent) obj;
                if ("android.intent.action.VIEW".equals(intent.getAction()) && com.ss.android.socialbase.downloader.g.gc.z.equals(intent.getType())) {
                    if (com.ss.android.socialbase.appdownloader.m.gc.a()) {
                        String strOptString = com.ss.android.downloadlib.addownload.wp.fo().optString("hook_vivo_arg", "com.android.settings");
                        if ("null".equals(strOptString)) {
                            return;
                        }
                        objArr[1] = strOptString;
                        return;
                    }
                    if (com.ss.android.socialbase.appdownloader.m.gc.gc()) {
                        String strOptString2 = com.ss.android.downloadlib.addownload.wp.fo().optString("hook_kllk_arg1", "com." + com.ss.android.socialbase.downloader.g.gc.dl + ".market");
                        if (!"null".equals(strOptString2)) {
                            objArr[1] = strOptString2;
                        }
                        String strOptString3 = com.ss.android.downloadlib.addownload.wp.fo().optString("hook_kllk_arg2", "com.android.browser");
                        String strOptString4 = com.ss.android.downloadlib.addownload.wp.fo().optString("hook_kllk_arg3", "m.store." + com.ss.android.socialbase.downloader.g.gc.dl + "mobile.com");
                        intent.putExtra(com.ss.android.socialbase.downloader.g.gc.dl + "_extra_pkg_name", strOptString3);
                        intent.putExtra("refererHost", strOptString4);
                        if (com.ss.android.downloadlib.addownload.wp.fo().optInt("hook_kllk_arg4", 0) == 1) {
                            Intent intent2 = new Intent();
                            intent2.putExtra(com.ss.android.socialbase.downloader.g.gc.dl + "_extra_pkg_name", strOptString3);
                            intent2.putExtra("refererHost", strOptString4);
                            intent.putExtra("android.intent.extra.INTENT", intent2);
                            return;
                        }
                        return;
                    }
                    if (com.ss.android.socialbase.appdownloader.m.gc.z()) {
                        String strOptString5 = com.ss.android.downloadlib.addownload.wp.fo().optString("hook_huawei_arg1", "com.huawei.appmarket");
                        if (!"null".equals(strOptString5)) {
                            objArr[1] = strOptString5;
                        }
                        intent.putExtra("caller_package", com.ss.android.downloadlib.addownload.wp.fo().optString("hook_huawei_arg2", "com.huawei.appmarket"));
                    }
                }
            }
        }
    }

    /* JADX INFO: renamed from: com.ss.android.downloadlib.e.z$z, reason: collision with other inner class name */
    private static class C0444z implements InvocationHandler {
        private Object z;

        private C0444z(Object obj) {
            this.z = obj;
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            try {
                if ("startActivity".contains(method.getName())) {
                    z.z(objArr);
                }
            } catch (Throwable unused) {
            }
            return method.invoke(this.z, objArr);
        }
    }
}
