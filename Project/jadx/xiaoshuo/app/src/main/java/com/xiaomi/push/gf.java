package com.xiaomi.push;

import android.util.Log;
import com.xiaomi.push.gi;

/* JADX INFO: loaded from: classes8.dex */
class gf {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final boolean f7997a = Log.isLoggable("BCompressed", 3);

    public static byte[] a(ge geVar, byte[] bArr) {
        try {
            byte[] bArrA = gi.a.a(bArr);
            if (f7997a) {
                com.xiaomi.channel.commonutils.logger.b.m107a("BCompressed", "decompress " + bArr.length + " to " + bArrA.length + " for " + geVar);
                if (geVar.f431a == 1) {
                    com.xiaomi.channel.commonutils.logger.b.m107a("BCompressed", "decompress not support upStream");
                }
            }
            return bArrA;
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.m107a("BCompressed", "decompress error " + e);
            return bArr;
        }
    }
}
