package com.bytedance.adsdk.g.g.dl.z;

import com.bytedance.adsdk.g.g.g.z.tb;
import java.util.Deque;

/* JADX INFO: loaded from: classes2.dex */
public class g extends m {
    @Override // com.bytedance.adsdk.g.g.dl.z.m
    public int z(String str, int i, Deque<com.bytedance.adsdk.g.g.g.z> deque, com.bytedance.adsdk.g.g.dl.z zVar) {
        if ('\'' != z(i, str)) {
            return zVar.z(str, i, deque);
        }
        int i2 = i + 1;
        int length = str.length();
        int i3 = i2;
        while (i3 < length && z(i3, str) != '\'') {
            i3++;
        }
        if (z(i3, str) != '\'') {
            throw new com.bytedance.adsdk.g.z.z("String expression not surrounded by '", str.substring(i2 - 1));
        }
        deque.push(new tb(str.substring(i2, i3)));
        return i3 + 1;
    }
}
