package com.alibaba.sdk.android.utils;

import android.app.Application;
import android.text.TextUtils;
import com.alibaba.sdk.android.utils.crashdefend.SDKMessageCallback;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class AlicloudTrackerManager {
    private static AlicloudTrackerManager a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private c f48a = new c();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private com.alibaba.sdk.android.utils.crashdefend.b f49a;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Map<String, AlicloudTracker> f2239e;

    private AlicloudTrackerManager(Application application) {
        this.f49a = null;
        HashMap map = new HashMap(4);
        map.put("kVersion", "2.0.0");
        map.put("packageName", application.getPackageName());
        this.f48a.a(application, map);
        this.f2239e = new HashMap();
        this.f49a = com.alibaba.sdk.android.utils.crashdefend.b.a(application, this.f48a);
    }

    public static synchronized AlicloudTrackerManager getInstance(Application application) {
        if (application == null) {
            return null;
        }
        if (a == null) {
            a = new AlicloudTrackerManager(application);
        }
        return a;
    }

    public AlicloudTracker getTracker(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        String str3 = str + str2;
        if (this.f2239e.containsKey(str3)) {
            return this.f2239e.get(str3);
        }
        AlicloudTracker alicloudTracker = new AlicloudTracker(this.f48a, str, str2);
        this.f2239e.put(str3, alicloudTracker);
        return alicloudTracker;
    }

    public boolean registerCrashDefend(String str, String str2, int i2, int i3, SDKMessageCallback sDKMessageCallback) {
        if (this.f49a == null) {
            return false;
        }
        com.alibaba.sdk.android.utils.crashdefend.c cVar = new com.alibaba.sdk.android.utils.crashdefend.c();
        cVar.f56c = str;
        cVar.f57d = str2;
        cVar.b = i2;
        cVar.f2247c = i3;
        return this.f49a.m37a(cVar, sDKMessageCallback);
    }

    public void unregisterCrashDefend(String str, String str2) {
        this.f49a.d(str, str2);
    }
}
