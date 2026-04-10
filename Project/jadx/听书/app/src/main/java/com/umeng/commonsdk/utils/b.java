package com.umeng.commonsdk.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import com.umeng.commonsdk.debug.UMRTLog;
import java.util.HashMap;

/* JADX INFO: compiled from: PkgInfoUtil.java */
/* JADX INFO: loaded from: classes4.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static HashMap<String, PackageInfo> f2368a = new HashMap<>();
    private static Object b = new Object();

    private b() {
    }

    /* JADX INFO: compiled from: PkgInfoUtil.java */
    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final b f2369a = new b();

        private a() {
        }
    }

    public static b a() {
        return a.f2369a;
    }

    public PackageInfo a(Context context, String str, int i) {
        PackageInfo packageInfo;
        synchronized (b) {
            if (f2368a.containsKey(str)) {
                UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> pkg： " + str + ", pkgInfo缓存命中，直接返回");
                packageInfo = f2368a.get(str);
            } else {
                try {
                    packageInfo = context.getPackageManager().getPackageInfo(str, i);
                    UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> pkg： " + str + ", 获取pkgInfo并缓存");
                    f2368a.put(str, packageInfo);
                } catch (PackageManager.NameNotFoundException unused) {
                    f2368a.put(str, null);
                    UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> pkg: " + str + "，目标包未安装。");
                    packageInfo = null;
                }
            }
        }
        return packageInfo;
    }
}
