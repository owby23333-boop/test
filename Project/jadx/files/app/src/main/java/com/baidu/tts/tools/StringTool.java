package com.baidu.tts.tools;

import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class StringTool {
    public static String addDivider(List<String> list, String str) {
        StringBuilder sb = new StringBuilder();
        Iterator<String> it = list.iterator();
        if (it.hasNext()) {
            sb.append(it.next());
        }
        while (it.hasNext()) {
            String next = it.next();
            sb.append(str);
            sb.append(next);
        }
        return sb.toString();
    }

    public static boolean isAllNumber(String str) {
        if (str != null) {
            return str.matches("^[0-9]{1,20}$");
        }
        return false;
    }

    public static boolean isEmpty(String str) {
        return str == null || str.trim().length() <= 0;
    }

    public static boolean isEqual(String str, String str2) {
        return str == null ? str2 == null : str.equals(str2);
    }

    public static String addDivider(int[] iArr, String str) {
        if (iArr == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(iArr[0]);
        for (int i2 = 1; i2 < iArr.length; i2++) {
            sb.append(str);
            sb.append(iArr[i2]);
        }
        return sb.toString();
    }
}
