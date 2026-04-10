package com.bytedance.embedapplog;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public class g {
    private static final em e = new em();
    private static final Map<String, String> bf = new ConcurrentHashMap();

    public static String e(String str) {
        Map<String, String> map = bf;
        String str2 = map.get(str);
        if (str2 != null) {
            return str2;
        }
        String strE = e.e(str);
        if (strE != null) {
            map.put(str, strE);
        }
        return strE;
    }
}
