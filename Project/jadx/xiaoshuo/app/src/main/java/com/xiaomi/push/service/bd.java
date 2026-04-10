package com.xiaomi.push.service;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes8.dex */
public class bd {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static long f8235a = 0;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static String f971a = "";

    public static String a() {
        if (TextUtils.isEmpty(f971a)) {
            f971a = com.xiaomi.push.bo.a(4);
        }
        StringBuilder sb = new StringBuilder();
        sb.append(f971a);
        long j = f8235a;
        f8235a = 1 + j;
        sb.append(j);
        return sb.toString();
    }

    public static String b() {
        return com.xiaomi.push.bo.a(32);
    }

    public static String a(String str) {
        if (TextUtils.isEmpty(str) || str.length() < 32) {
            return str;
        }
        try {
            return "BlockId_" + str.substring(8);
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.d("Exception occurred when filtering registration packet id for log. " + e);
            return "UnexpectedId";
        }
    }
}
