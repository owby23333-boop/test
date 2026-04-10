package com.bytedance.adsdk.g.g.dl.z;

import com.bytedance.adsdk.g.g.g.z.iq;
import java.util.Deque;

/* JADX INFO: loaded from: classes2.dex */
public class dl extends m {
    @Override // com.bytedance.adsdk.g.g.dl.z.m
    public int z(String str, int i, Deque<com.bytedance.adsdk.g.g.g.z> deque, com.bytedance.adsdk.g.g.dl.z zVar) {
        char cZ = z(i, str);
        if (!com.bytedance.adsdk.g.g.gc.z.g(cZ) && cZ != '$') {
            return zVar.z(str, i, deque);
        }
        return z(str, i, deque);
    }

    private int z(String str, int i, Deque<com.bytedance.adsdk.g.g.g.z> deque) {
        int i2;
        int i3 = 0;
        while (true) {
            i2 = i3 + i;
            char cZ = z(i2, str);
            if (!com.bytedance.adsdk.g.g.gc.z.g(cZ) && !com.bytedance.adsdk.g.g.gc.z.dl(cZ) && '.' != cZ && '[' != cZ && ']' != cZ && '_' != cZ && '-' != cZ && '$' != cZ) {
                break;
            }
            i3++;
        }
        String strSubstring = str.substring(i, i2);
        if (com.bytedance.adsdk.g.g.a.z.z(strSubstring) != null) {
            deque.push(new com.bytedance.adsdk.g.g.g.z.e(strSubstring));
        } else {
            deque.push(new iq(strSubstring));
        }
        return i2;
    }
}
