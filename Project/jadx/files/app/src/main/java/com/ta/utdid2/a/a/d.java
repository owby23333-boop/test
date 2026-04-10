package com.ta.utdid2.a.a;

import android.content.Context;
import android.text.TextUtils;
import java.util.Random;

/* JADX INFO: loaded from: classes3.dex */
public class d {
    public static String a() {
        int iCurrentTimeMillis = (int) (System.currentTimeMillis() / 1000);
        int iNanoTime = (int) System.nanoTime();
        int iNextInt = new Random().nextInt();
        int iNextInt2 = new Random().nextInt();
        byte[] bytes = c.getBytes(iCurrentTimeMillis);
        byte[] bytes2 = c.getBytes(iNanoTime);
        byte[] bytes3 = c.getBytes(iNextInt);
        byte[] bytes4 = c.getBytes(iNextInt2);
        byte[] bArr = new byte[16];
        System.arraycopy(bytes, 0, bArr, 0, 4);
        System.arraycopy(bytes2, 0, bArr, 4, 4);
        System.arraycopy(bytes3, 0, bArr, 8, 4);
        System.arraycopy(bytes4, 0, bArr, 12, 4);
        return b.encodeToString(bArr, 2);
    }

    private static String b() {
        String str = g.get("ro.aliyun.clouduuid", "");
        if (TextUtils.isEmpty(str)) {
            str = g.get("ro.sys.aliyun.clouduuid", "");
        }
        return TextUtils.isEmpty(str) ? c() : str;
    }

    public static String b(Context context) {
        return "";
    }

    private static String c() {
        try {
            return (String) Class.forName("com.yunos.baseservice.clouduuid.CloudUUID").getMethod("getCloudUUID", new Class[0]).invoke(null, new Object[0]);
        } catch (Exception unused) {
            return "";
        }
    }

    public static String a(Context context) {
        String strB = f.m175a((String) null) ? b() : null;
        return f.m175a(strB) ? a() : strB;
    }
}
