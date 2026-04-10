package com.bytedance.sdk.openadsdk.m.g;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes2.dex */
public class z {
    private int g = 0;
    public Map<Integer, Long> z = new ConcurrentHashMap();

    public void z() {
        this.g = 0;
        try {
            this.z.clear();
        } catch (Exception unused) {
        }
    }

    public boolean z(int i) {
        return (this.g & i) == i;
    }

    public Long g(int i) {
        try {
            if (z(i)) {
                return this.z.get(Integer.valueOf(i));
            }
        } catch (Exception unused) {
        }
        return -1L;
    }

    public void dl(int i) {
        if (z(i)) {
            return;
        }
        this.g |= i;
        try {
            this.z.put(Integer.valueOf(i), Long.valueOf(System.currentTimeMillis()));
        } catch (Exception unused) {
        }
    }

    public boolean a(int i) {
        return i == this.g;
    }
}
