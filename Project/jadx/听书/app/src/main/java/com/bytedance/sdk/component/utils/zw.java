package com.bytedance.sdk.component.utils;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes2.dex */
public abstract class zw {
    private final ConcurrentHashMap<Integer, ConcurrentHashMap<Integer, Runnable>> z = new ConcurrentHashMap<>();

    public abstract boolean z(int i);

    public void z(int i, int i2, Runnable runnable) {
        if (i <= 0 || i2 <= 0) {
            return;
        }
        ConcurrentHashMap<Integer, Runnable> concurrentHashMap = this.z.get(Integer.valueOf(i));
        if (concurrentHashMap == null) {
            concurrentHashMap = new ConcurrentHashMap<>();
            this.z.put(Integer.valueOf(i), concurrentHashMap);
        }
        concurrentHashMap.put(Integer.valueOf(i2), runnable);
    }

    public void z(int i, int i2) {
        ConcurrentHashMap<Integer, Runnable> concurrentHashMap;
        if (i <= 0 || i2 <= 0 || (concurrentHashMap = this.z.get(Integer.valueOf(i))) == null) {
            return;
        }
        concurrentHashMap.remove(Integer.valueOf(i2));
    }

    public void g(int i) {
        this.z.remove(Integer.valueOf(i));
    }

    public void dl(int i) {
        Runnable value;
        ConcurrentHashMap<Integer, Runnable> concurrentHashMapRemove = this.z.remove(Integer.valueOf(i));
        if (concurrentHashMapRemove != null) {
            for (Map.Entry<Integer, Runnable> entry : concurrentHashMapRemove.entrySet()) {
                if (entry != null && (value = entry.getValue()) != null) {
                    value.run();
                }
            }
        }
    }
}
