package com.xiaomi.push;

import android.net.NetworkInfo;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes8.dex */
public class bi {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final NetworkInfo f7824a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private final ConcurrentHashMap<String, Object> f170a = new ConcurrentHashMap<>();

    public bi(NetworkInfo networkInfo) {
        this.f7824a = networkInfo;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00b9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private <T> T a(java.lang.String r3) {
        /*
            Method dump skipped, instruction units count: 422
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.bi.a(java.lang.String):java.lang.Object");
    }

    public int b() {
        return ((Integer) a("getSubtype")).intValue();
    }

    public String c() {
        return (String) a("getExtraInfo");
    }

    public String toString() {
        return (String) a("toString");
    }

    /* JADX INFO: renamed from: b, reason: collision with other method in class */
    public String m228b() {
        return (String) a("getSubtypeName");
    }

    public int a() {
        return ((Integer) a("getType")).intValue();
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public String m226a() {
        return (String) a("getTypeName");
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m227a() {
        return ((Boolean) a("isConnected")).booleanValue();
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public NetworkInfo.State m225a() {
        return (NetworkInfo.State) a("getState");
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public NetworkInfo.DetailedState m224a() {
        return (NetworkInfo.DetailedState) a("getDetailedState");
    }
}
