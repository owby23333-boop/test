package com.yuewen;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public class xf2 {
    public static Map<String, Object> a(String str, Object obj) {
        HashMap map = new HashMap();
        map.put(str, obj);
        return map;
    }

    public static Map<String, Object> b(String... strArr) {
        HashMap map = new HashMap();
        int i = 0;
        while (i < strArr.length - 1) {
            String str = strArr[i];
            i++;
            map.put(str, strArr[i]);
        }
        return map;
    }
}
