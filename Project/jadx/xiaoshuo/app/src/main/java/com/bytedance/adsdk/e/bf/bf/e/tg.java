package com.bytedance.adsdk.e.bf.bf.e;

import com.alibaba.fastjson.parser.JSONLexer;
import java.util.Deque;

/* JADX INFO: loaded from: classes.dex */
public abstract class tg {
    public int bf(int i, String str) {
        while (com.bytedance.adsdk.e.bf.tg.e.e(e(i, str))) {
            i++;
        }
        return i;
    }

    public char e(int i, String str) {
        return i >= str.length() ? JSONLexer.EOI : str.charAt(i);
    }

    public abstract int e(String str, int i, Deque<com.bytedance.adsdk.e.bf.e.e> deque, com.bytedance.adsdk.e.bf.bf.e eVar);

    public int getIdentifier(int i, String str) {
        int i2 = 0;
        while (true) {
            int i3 = i2 + i;
            char cE = e(i3, str);
            if (!com.bytedance.adsdk.e.bf.tg.e.bf(cE) && !com.bytedance.adsdk.e.bf.tg.e.d(cE)) {
                return i3;
            }
            i2++;
        }
    }
}
