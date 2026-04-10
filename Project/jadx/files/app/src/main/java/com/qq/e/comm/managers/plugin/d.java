package com.qq.e.comm.managers.plugin;

/* JADX INFO: loaded from: classes3.dex */
class d {
    private static final String[] a = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", com.anythink.core.c.e.a, "f"};

    public static String a(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i2 : bArr) {
            if (i2 < 0) {
                i2 += 256;
            }
            stringBuffer.append(a[i2 / 16] + a[i2 % 16]);
        }
        return stringBuffer.toString();
    }
}
