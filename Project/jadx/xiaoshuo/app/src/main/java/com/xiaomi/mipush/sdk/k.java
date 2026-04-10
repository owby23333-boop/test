package com.xiaomi.mipush.sdk;

import com.xiaomi.push.ig;
import java.util.HashMap;

/* JADX INFO: loaded from: classes8.dex */
public class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static HashMap<d, a> f7440a = new HashMap<>();

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f7441a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f7442b;

        public a(String str, String str2) {
            this.f7441a = str;
            this.f7442b = str2;
        }
    }

    static {
        a(d.ASSEMBLE_PUSH_HUAWEI, new a("com.xiaomi.assemble.control.HmsPushManager", "newInstance"));
        a(d.ASSEMBLE_PUSH_FCM, new a("com.xiaomi.assemble.control.FCMPushManager", "newInstance"));
        a(d.ASSEMBLE_PUSH_COS, new a("com.xiaomi.assemble.control.COSPushManager", "newInstance"));
        a(d.ASSEMBLE_PUSH_FTOS, new a("com.xiaomi.assemble.control.FTOSPushManager", "newInstance"));
    }

    private static void a(d dVar, a aVar) {
        if (aVar != null) {
            f7440a.put(dVar, aVar);
        }
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static a m182a(d dVar) {
        return f7440a.get(dVar);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static ig m183a(d dVar) {
        return ig.AggregatePushSwitch;
    }

    public static aq a(d dVar) {
        int i = l.f7443a[dVar.ordinal()];
        if (i == 1) {
            return aq.UPLOAD_HUAWEI_TOKEN;
        }
        if (i == 2) {
            return aq.UPLOAD_FCM_TOKEN;
        }
        if (i == 3) {
            return aq.UPLOAD_COS_TOKEN;
        }
        if (i != 4) {
            return null;
        }
        return aq.UPLOAD_FTOS_TOKEN;
    }
}
