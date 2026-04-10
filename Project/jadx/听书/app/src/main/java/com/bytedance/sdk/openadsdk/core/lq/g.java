package com.bytedance.sdk.openadsdk.core.lq;

import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes2.dex */
public class g {
    private ConcurrentHashMap<String, Object> z = new ConcurrentHashMap<>();

    public void z(String str, String str2) {
        if (str == null || str2 == null) {
            return;
        }
        this.z.put(str, str2);
    }

    public String z(String str) {
        return g(str, "");
    }

    private String g(String str, String str2) {
        return (str == null || !this.z.containsKey(str)) ? str2 : (String) this.z.get(str);
    }

    public void z(String str, int i) {
        if (str != null) {
            this.z.put(str, Integer.valueOf(i));
        }
    }

    public int g(String str) {
        return g(str, 0);
    }

    private int g(String str, int i) {
        return (str == null || !this.z.containsKey(str)) ? i : ((Integer) this.z.get(str)).intValue();
    }
}
