package com.kwad.sdk.utils;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import anet.channel.strategy.dispatch.DispatchConstants;
import com.kwad.sdk.service.ServiceProvider;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class InstalledAppInfoManager {

    public static class AppPackageInfo implements Serializable {
        private static final long serialVersionUID = -324393456884895874L;
        public String appName;
        public long firstInstallTime;
        public boolean isSystemApp;
        public long lastUpdateTime;
        public String packageName;
        public int reportMethod;
        public String versionName;
    }

    public static AppPackageInfo a(@NonNull PackageInfo packageInfo, @Nullable PackageManager packageManager) {
        ApplicationInfo applicationInfo;
        AppPackageInfo appPackageInfo = new AppPackageInfo();
        appPackageInfo.packageName = packageInfo.packageName;
        ApplicationInfo applicationInfo2 = packageInfo.applicationInfo;
        if (applicationInfo2 != null) {
            appPackageInfo.isSystemApp = a(applicationInfo2) || b(packageInfo.applicationInfo);
        }
        appPackageInfo.versionName = packageInfo.versionName;
        appPackageInfo.firstInstallTime = packageInfo.firstInstallTime;
        appPackageInfo.lastUpdateTime = packageInfo.lastUpdateTime;
        if (packageManager != null && (applicationInfo = packageInfo.applicationInfo) != null) {
            try {
                appPackageInfo.appName = applicationInfo.loadLabel(packageManager).toString();
            } catch (Throwable th) {
                com.kwad.sdk.core.d.b.printStackTraceOnly(th);
            }
        }
        return appPackageInfo;
    }

    public static JSONObject a(AppPackageInfo appPackageInfo) {
        JSONObject jSONObject = new JSONObject();
        s.putValue(jSONObject, "pkgName", appPackageInfo.packageName);
        s.putValue(jSONObject, "system_app", appPackageInfo.isSystemApp ? 1 : 0);
        s.putValue(jSONObject, "appVersion", appPackageInfo.versionName);
        s.putValue(jSONObject, "firstInstallTime", appPackageInfo.firstInstallTime);
        s.putValue(jSONObject, "lastUpdateTime", appPackageInfo.lastUpdateTime);
        s.putValue(jSONObject, "reportMethod", appPackageInfo.reportMethod);
        s.putValue(jSONObject, DispatchConstants.APP_NAME, appPackageInfo.appName);
        return jSONObject;
    }

    private static boolean a(ApplicationInfo applicationInfo) {
        return (applicationInfo.flags & 1) != 0;
    }

    private static boolean b(ApplicationInfo applicationInfo) {
        return (applicationInfo.flags & 128) != 0;
    }

    @NonNull
    public static JSONArray bY(Context context) {
        return e(bZ(context));
    }

    @NonNull
    public static Map<String, AppPackageInfo> bZ(Context context) {
        HashMap map = new HashMap();
        if (context == null) {
            return map;
        }
        PackageManager packageManager = context.getPackageManager();
        if (as.Ec()) {
            if (as.Ed() != null) {
                Iterator<String> it = as.Ed().iterator();
                while (it.hasNext()) {
                    try {
                        PackageInfo packageInfo = packageManager.getPackageInfo(it.next(), 0);
                        if (packageInfo != null) {
                            AppPackageInfo appPackageInfoA = a(packageInfo, packageManager);
                            appPackageInfoA.reportMethod = 3;
                            map.put(appPackageInfoA.packageName, appPackageInfoA);
                        }
                    } catch (Throwable unused) {
                    }
                }
            }
            return map;
        }
        com.kwad.sdk.service.kwai.f fVar = (com.kwad.sdk.service.kwai.f) ServiceProvider.get(com.kwad.sdk.service.kwai.f.class);
        if (fVar != null && !fVar.D(16L)) {
            try {
                List<String> listDq = bc.dq(context);
                Intent intent = new Intent("android.intent.action.MAIN", (Uri) null);
                intent.addCategory("android.intent.category.LAUNCHER");
                for (ResolveInfo resolveInfo : context.getPackageManager().queryIntentActivities(intent, 32)) {
                    if (resolveInfo != null && resolveInfo.activityInfo != null && !TextUtils.isEmpty(resolveInfo.activityInfo.packageName)) {
                        String str = resolveInfo.activityInfo.packageName;
                        if (listDq != null && !listDq.isEmpty()) {
                            listDq.remove(str);
                        }
                        PackageInfo packageInfo2 = packageManager.getPackageInfo(str, 0);
                        if (packageInfo2 != null) {
                            AppPackageInfo appPackageInfoA2 = a(packageInfo2, packageManager);
                            appPackageInfoA2.reportMethod = 1;
                            map.put(appPackageInfoA2.packageName, appPackageInfoA2);
                        }
                    }
                }
                if (listDq != null && !listDq.isEmpty()) {
                    Iterator<String> it2 = listDq.iterator();
                    while (it2.hasNext()) {
                        try {
                            PackageInfo packageInfo3 = packageManager.getPackageInfo(it2.next(), 0);
                            if (packageInfo3 != null) {
                                AppPackageInfo appPackageInfoA3 = a(packageInfo3, packageManager);
                                appPackageInfoA3.reportMethod = 2;
                                map.put(appPackageInfoA3.packageName, appPackageInfoA3);
                            }
                        } catch (Throwable unused2) {
                        }
                    }
                }
            } catch (Exception unused3) {
            }
            map.putAll(d(context, fVar.sS()));
        }
        return map;
    }

    @NonNull
    public static JSONArray[] c(Context context, List<String> list) {
        JSONArray[] jSONArrayArr = new JSONArray[2];
        com.kwad.sdk.service.kwai.f fVar = (com.kwad.sdk.service.kwai.f) ServiceProvider.get(com.kwad.sdk.service.kwai.f.class);
        if (context == null || list == null || list.isEmpty() || fVar == null || fVar.D(16L)) {
            return jSONArrayArr;
        }
        HashMap map = new HashMap();
        HashMap map2 = new HashMap();
        for (String str : list) {
            try {
                PackageManager packageManager = context.getPackageManager();
                PackageInfo packageInfo = packageManager.getPackageInfo(str, 0);
                if (packageInfo != null) {
                    AppPackageInfo appPackageInfoA = a(packageInfo, packageManager);
                    map.put(appPackageInfoA.packageName, appPackageInfoA);
                } else {
                    AppPackageInfo appPackageInfo = new AppPackageInfo();
                    appPackageInfo.packageName = str;
                    map2.put(appPackageInfo.packageName, appPackageInfo);
                }
            } catch (Exception unused) {
                AppPackageInfo appPackageInfo2 = new AppPackageInfo();
                appPackageInfo2.packageName = str;
                map2.put(appPackageInfo2.packageName, appPackageInfo2);
            }
        }
        jSONArrayArr[0] = e(map);
        jSONArrayArr[1] = e(map2);
        return jSONArrayArr;
    }

    @NonNull
    private static Map<String, AppPackageInfo> d(Context context, List<String> list) {
        HashMap map = new HashMap();
        if (context != null && list != null) {
            for (String str : list) {
                try {
                    PackageManager packageManager = context.getPackageManager();
                    PackageInfo packageInfo = packageManager.getPackageInfo(str, 0);
                    if (packageInfo != null) {
                        AppPackageInfo appPackageInfoA = a(packageInfo, packageManager);
                        map.put(appPackageInfoA.packageName, appPackageInfoA);
                    }
                } catch (Exception unused) {
                }
            }
        }
        return map;
    }

    @NonNull
    public static JSONArray e(@NonNull Map<String, AppPackageInfo> map) {
        JSONArray jSONArray = new JSONArray();
        try {
            Iterator<String> it = map.keySet().iterator();
            while (it.hasNext()) {
                AppPackageInfo appPackageInfo = map.get(it.next());
                if (appPackageInfo != null && !TextUtils.isEmpty(appPackageInfo.packageName)) {
                    s.putValue(jSONArray, a(appPackageInfo));
                }
            }
        } catch (Exception e2) {
            com.kwad.sdk.core.d.b.printStackTraceOnly(e2);
        }
        return jSONArray;
    }
}
