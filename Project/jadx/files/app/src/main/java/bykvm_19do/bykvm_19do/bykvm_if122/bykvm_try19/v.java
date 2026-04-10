package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public class v {
    private static Map<Integer, Integer> a = new ConcurrentHashMap();

    public static Integer a(int i2) {
        Integer num = a.get(Integer.valueOf(i2));
        if (num != null) {
            return num;
        }
        Integer numValueOf = Integer.valueOf(i2);
        a.put(Integer.valueOf(i2), numValueOf);
        return numValueOf;
    }
}
