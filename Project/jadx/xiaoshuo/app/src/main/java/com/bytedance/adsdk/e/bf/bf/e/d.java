package com.bytedance.adsdk.e.bf.bf.e;

import com.bytedance.adsdk.e.bf.e.e.dt;
import java.util.Deque;

/* JADX INFO: loaded from: classes.dex */
public class d extends tg {
    @Override // com.bytedance.adsdk.e.bf.bf.e.tg
    public int e(String str, int i, Deque<com.bytedance.adsdk.e.bf.e.e> deque, com.bytedance.adsdk.e.bf.bf.e eVar) {
        if ('(' != e(i, str)) {
            return eVar.e(str, i, deque);
        }
        deque.push(new dt(com.bytedance.adsdk.e.bf.d.d.LEFT_PAREN));
        return i + 1;
    }
}
