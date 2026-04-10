package com.ta.utdid2.a.a;

import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes3.dex */
public class f {
    private static final Pattern a = Pattern.compile("([\t\r\n])+");

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static boolean m175a(String str) {
        return str == null || str.length() <= 0;
    }

    public static int a(String str) {
        if (str.length() <= 0) {
            return 0;
        }
        int i2 = 0;
        for (char c2 : str.toCharArray()) {
            i2 = (i2 * 31) + c2;
        }
        return i2;
    }
}
