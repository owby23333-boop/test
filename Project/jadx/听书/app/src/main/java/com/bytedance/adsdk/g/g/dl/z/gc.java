package com.bytedance.adsdk.g.g.dl.z;

import java.util.Deque;

/* JADX INFO: loaded from: classes2.dex */
public class gc extends m {
    @Override // com.bytedance.adsdk.g.g.dl.z.m
    public int z(String str, int i, Deque<com.bytedance.adsdk.g.g.g.z> deque, com.bytedance.adsdk.g.g.dl.z zVar) {
        char cZ;
        int i2 = i;
        while (true) {
            cZ = z(i2, str);
            if (!com.bytedance.adsdk.g.g.gc.z.g(cZ) && !com.bytedance.adsdk.g.g.gc.z.dl(cZ)) {
                break;
            }
            i2++;
        }
        if (cZ != '(') {
            return zVar.z(str, i, deque);
        }
        deque.push(new com.bytedance.adsdk.g.g.g.z.uy(str.substring(i, i2)));
        return i2 + 1;
    }
}
