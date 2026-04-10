package com.bytedance.sdk.component.utils;

import com.google.common.base.Ascii;
import com.kwad.sdk.api.model.AdnName;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.Collections;

/* JADX INFO: loaded from: classes2.dex */
public class fo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final byte[] f791a;
    private static final byte[] dl;
    private static final int e;
    private static final byte[] g;
    private static final byte[] gc;
    private static final byte[] m;
    private static final byte[] z;

    static {
        byte[] bArr = {-1, -40, -1};
        z = bArr;
        byte[] bArr2 = {-119, 80, 78, 71, 13, 10, Ascii.SUB, 10};
        g = bArr2;
        byte[] bArr3 = {0, 0, 1, 0};
        dl = bArr3;
        byte[] bArrZ = z("BM");
        f791a = bArrZ;
        gc = z("GIF87a");
        m = z("GIF89a");
        e = ((Integer) Collections.max(Arrays.asList(Integer.valueOf(bArr.length), Integer.valueOf(bArr2.length), Integer.valueOf(bArr3.length), Integer.valueOf(bArrZ.length), 6))).intValue();
    }

    public static int z() {
        return e;
    }

    public static final String z(byte[] bArr) {
        return g(bArr) ? "jpeg" : dl(bArr) ? "png" : a(bArr) ? "gif" : gc(bArr) ? "bmp" : m(bArr) ? "ico" : AdnName.OTHER;
    }

    private static boolean g(byte[] bArr) {
        int length = bArr.length;
        byte[] bArr2 = z;
        return length >= bArr2.length && z(bArr, bArr2);
    }

    private static boolean dl(byte[] bArr) {
        int length = bArr.length;
        byte[] bArr2 = g;
        return length >= bArr2.length && z(bArr, bArr2);
    }

    private static boolean a(byte[] bArr) {
        return (bArr.length >= 6 && z(bArr, gc)) || z(bArr, m);
    }

    private static boolean gc(byte[] bArr) {
        int length = bArr.length;
        byte[] bArr2 = f791a;
        return length >= bArr2.length && z(bArr, bArr2);
    }

    private static boolean m(byte[] bArr) {
        int length = bArr.length;
        byte[] bArr2 = dl;
        return length >= bArr2.length && z(bArr, bArr2);
    }

    private static boolean z(byte[] bArr, byte[] bArr2) {
        return z(bArr, bArr2, 0);
    }

    private static boolean z(byte[] bArr, byte[] bArr2, int i) {
        if (bArr2.length + i > bArr.length) {
            return false;
        }
        for (int i2 = 0; i2 < bArr2.length; i2++) {
            if (bArr[i + i2] != bArr2[i2]) {
                return false;
            }
        }
        return true;
    }

    private static byte[] z(String str) {
        try {
            return str.getBytes("ASCII");
        } catch (UnsupportedEncodingException e2) {
            throw new RuntimeException("ASCII not found!", e2);
        }
    }
}
