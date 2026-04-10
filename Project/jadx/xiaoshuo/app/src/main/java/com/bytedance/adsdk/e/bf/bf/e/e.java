package com.bytedance.adsdk.e.bf.bf.e;

import com.bytedance.adsdk.e.bf.e.e.k;
import java.util.Deque;

/* JADX INFO: loaded from: classes.dex */
public class e extends tg {
    @Override // com.bytedance.adsdk.e.bf.bf.e.tg
    public int e(String str, int i, Deque<com.bytedance.adsdk.e.bf.e.e> deque, com.bytedance.adsdk.e.bf.bf.e eVar) {
        if ('\'' != e(i, str)) {
            return eVar.e(str, i, deque);
        }
        int i2 = i + 1;
        int length = str.length();
        int i3 = i2;
        while (i3 < length && e(i3, str) != '\'') {
            i3++;
        }
        if (e(i3, str) != '\'') {
            throw new com.bytedance.adsdk.e.e.e("字符串表达式没有被'包围", str.substring(i2 - 1));
        }
        deque.push(new k(str.substring(i2, i3)));
        return i3 + 1;
    }
}
