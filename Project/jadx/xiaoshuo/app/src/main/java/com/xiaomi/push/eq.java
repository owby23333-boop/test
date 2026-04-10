package com.xiaomi.push;

import android.content.Context;
import android.os.Build;

/* JADX INFO: loaded from: classes8.dex */
public class eq {
    public static byte[] a(String str, byte[] bArr) {
        byte[] bArrM233a = bl.m233a(str);
        try {
            a(bArrM233a);
            return h.a(bArrM233a, bArr);
        } catch (Exception unused) {
            return null;
        }
    }

    public static byte[] b(String str, byte[] bArr) {
        byte[] bArrM233a = bl.m233a(str);
        try {
            a(bArrM233a);
            return h.b(bArrM233a, bArr);
        } catch (Exception unused) {
            return null;
        }
    }

    private static void a(byte[] bArr) {
        if (bArr.length >= 2) {
            bArr[0] = 99;
            bArr[1] = 100;
        }
    }

    public static boolean a(Context context, String str, long j) {
        if (com.xiaomi.push.service.ba.a(context).a(ig.DCJobMutualSwitch.a(), false)) {
            return (Build.VERSION.SDK_INT < 29 || context.getApplicationInfo().targetSdkVersion < 29) && !ae.a(context, str, j);
        }
        return false;
    }
}
