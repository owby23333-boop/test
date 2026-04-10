package com.bytedance.msdk.gz;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes2.dex */
public class tb {
    private static Map<Integer, Integer> z = new ConcurrentHashMap();

    public static Integer z(int i) {
        Integer num = z.get(Integer.valueOf(i));
        if (num != null) {
            return num;
        }
        Integer numValueOf = Integer.valueOf(i);
        z.put(Integer.valueOf(i), numValueOf);
        return numValueOf;
    }
}
