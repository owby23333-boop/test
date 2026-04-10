package com.bytedance.adsdk.g.g.dl.z;

import com.bytedance.adsdk.g.g.g.z.ls;
import java.util.Deque;

/* JADX INFO: loaded from: classes2.dex */
public class gz extends m {
    @Override // com.bytedance.adsdk.g.g.dl.z.m
    public int z(String str, int i, Deque<com.bytedance.adsdk.g.g.g.z> deque, com.bytedance.adsdk.g.g.dl.z zVar) {
        if (!com.bytedance.adsdk.g.g.gc.z.a(z(i, str))) {
            return zVar.z(str, i, deque);
        }
        int i2 = i + 1;
        String str2 = new String(new char[]{z(i, str), z(i2, str)});
        if (com.bytedance.adsdk.g.g.a.dl.z(str2) != null) {
            deque.push(new ls(com.bytedance.adsdk.g.g.a.dl.z(str2)));
            return i + 2;
        }
        String strValueOf = String.valueOf(z(i, str));
        if (com.bytedance.adsdk.g.g.a.dl.z(strValueOf) != null) {
            deque.push(new ls(com.bytedance.adsdk.g.g.a.dl.z(strValueOf)));
            return i2;
        }
        throw new IllegalArgumentException("Unrecognized:" + strValueOf + "examine:" + str.substring(0, i));
    }
}
