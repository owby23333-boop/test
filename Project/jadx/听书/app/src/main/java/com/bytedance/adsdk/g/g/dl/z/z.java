package com.bytedance.adsdk.g.g.dl.z;

import com.bytedance.adsdk.g.g.g.z.q;
import java.util.Deque;

/* JADX INFO: loaded from: classes2.dex */
public class z extends m {
    @Override // com.bytedance.adsdk.g.g.dl.z.m
    public int z(String str, int i, Deque<com.bytedance.adsdk.g.g.g.z> deque, com.bytedance.adsdk.g.g.dl.z zVar) {
        if (',' != z(i, str)) {
            return zVar.z(str, i, deque);
        }
        deque.push(new q(com.bytedance.adsdk.g.g.a.a.COMMA));
        return i + 1;
    }
}
