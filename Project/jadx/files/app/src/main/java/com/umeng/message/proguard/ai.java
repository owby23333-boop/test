package com.umeng.message.proguard;

import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: StringUtils.java */
/* JADX INFO: loaded from: classes3.dex */
public class ai {
    public static String a(String... strArr) {
        StringBuilder sb = new StringBuilder();
        for (String str : strArr) {
            sb.append(str);
            sb.append(",");
        }
        if (sb.length() > 0 && sb.charAt(sb.length() - 1) == ',') {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }

    public static String a(List<String> list) {
        StringBuilder sb = new StringBuilder();
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            sb.append(it.next());
            sb.append(",");
        }
        if (sb.length() > 0 && sb.charAt(sb.length() - 1) == ',') {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }
}
