package com.bytedance.adsdk.g.g.dl.z;

import java.util.Deque;

/* JADX INFO: loaded from: classes2.dex */
public abstract class m {
    public abstract int z(String str, int i, Deque<com.bytedance.adsdk.g.g.g.z> deque, com.bytedance.adsdk.g.g.dl.z zVar);

    protected char z(int i, String str) {
        if (i >= str.length()) {
            return (char) 26;
        }
        return str.charAt(i);
    }

    protected int g(int i, String str) {
        while (com.bytedance.adsdk.g.g.gc.z.z(z(i, str))) {
            i++;
        }
        return i;
    }

    protected int getIdentifier(int i, String str) {
        int i2 = 0;
        while (true) {
            int i3 = i2 + i;
            char cZ = z(i3, str);
            if (!com.bytedance.adsdk.g.g.gc.z.g(cZ) && !com.bytedance.adsdk.g.g.gc.z.dl(cZ)) {
                return i3;
            }
            i2++;
        }
    }
}
