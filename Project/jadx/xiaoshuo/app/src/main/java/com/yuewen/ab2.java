package com.yuewen;

import java.text.DecimalFormat;

/* JADX INFO: loaded from: classes12.dex */
public class ab2 {
    public static String a(int i) {
        if (i < 0) {
            i = 0;
        }
        String str = i + "";
        if (i <= 9999) {
            return str;
        }
        return new DecimalFormat("###.0").format(i / 10000.0f) + "万";
    }

    public static String b(String str) {
        int i;
        try {
            i = Integer.parseInt(str);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            i = 0;
        }
        return a(i);
    }
}
