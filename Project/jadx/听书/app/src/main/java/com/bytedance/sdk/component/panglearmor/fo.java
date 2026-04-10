package com.bytedance.sdk.component.panglearmor;

import android.util.Base64;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes2.dex */
public class fo {
    private static AtomicInteger dl = new AtomicInteger(0);
    private static volatile boolean g;
    private static volatile fo z;

    private fo() {
    }

    public static fo z() {
        if (z == null) {
            synchronized (fo.class) {
                if (z == null) {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    try {
                        com.bytedance.sdk.openadsdk.hh.m.z("panglearmor");
                        g = true;
                        dl.set(1);
                    } catch (Throwable unused) {
                        g = false;
                        dl.set(2);
                    }
                    z = new fo();
                    long jCurrentTimeMillis2 = System.currentTimeMillis();
                    gz gzVarE = m.e();
                    if (gzVarE != null) {
                        gzVarE.z(jCurrentTimeMillis2 - jCurrentTimeMillis, g);
                    }
                }
            }
        }
        return z;
    }

    public static boolean g() {
        return g;
    }

    public static int dl() {
        return dl.get();
    }

    public byte[] z(byte[] bArr) {
        if (bArr != null && bArr.length != 0 && g) {
            try {
                return SoftDecTool.bc(1010, bArr);
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    public byte[] g(byte[] bArr) {
        if (bArr != null && bArr.length != 0 && g) {
            try {
                return SoftDecTool.bc(1011, bArr);
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    public String z(String str) {
        if (str == null || str.length() == 0 || !g) {
            return null;
        }
        try {
            byte[] bArrG = g(Base64.decode(str, 0));
            if (bArrG != null) {
                return new String(bArrG);
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }
}
