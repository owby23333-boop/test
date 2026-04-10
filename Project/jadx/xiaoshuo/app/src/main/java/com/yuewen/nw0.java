package com.yuewen;

import com.google.zxing.common.StringUtils;

/* JADX INFO: loaded from: classes3.dex */
public class nw0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f15095a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f15096b = 1;
    public static final int c = 2;
    public static final int d = 3;
    public static final int e = 4;
    public static final int f = 5;
    public static final int g = 6;
    public static final int h = 7;
    public static final int i = 8;
    public static final int j = 9;
    public static final int k = 10;
    public static final int l = 11;
    public static final int m = 12;
    public static final int n = 13;
    public static final int o = 14;
    public static final int p = 15;
    public static final int q = 16;
    public static final int r = 17;
    public static final int s = 18;
    public static final int t = 19;
    public static final int u = 20;
    public static final int v = 21;
    public static String[] w = null;
    public static final String x = "Unknown";
    public static nw0 y;

    public nw0() {
        w = new String[]{StringUtils.GB2312, "GBK", "GB18030", "ASCII", "BIG5", "EUC-TW", "UTF-8", "UTF-16BE", "UTF-16LE", "ISO2022CN", "ISO2022CN_CNS", "ISO2022CN_GB", "EUC_KR", "MS949", "ISO2022KR", "Johab", StringUtils.SHIFT_JIS, "EUC_JP", "ISO2022JP", "ASCII", "ISO8859_1"};
    }

    public static nw0 c() {
        if (y == null) {
            y = new nw0();
        }
        return y;
    }

    public int a(String str) {
        for (int i2 = 0; i2 < 21; i2++) {
            if (d(str, i2)) {
                return i2;
            }
        }
        return -1;
    }

    public String b(int i2) {
        if (i2 < 0) {
            return x;
        }
        String[] strArr = w;
        return i2 >= strArr.length ? x : strArr[i2];
    }

    public final boolean d(String str, int i2) {
        return str.equals(w[i2]);
    }
}
