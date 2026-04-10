package com.bytedance.adsdk.g.g.dl.z;

import com.bytedance.adsdk.g.g.g.z.pf;
import java.util.Deque;

/* JADX INFO: loaded from: classes2.dex */
public class e extends m {
    private boolean z(String str, int i, Deque<com.bytedance.adsdk.g.g.g.z> deque) {
        if ('-' == z(i, str)) {
            if (deque.peek() != null && !com.bytedance.adsdk.g.g.a.dl.z(deque.peek().z())) {
                return false;
            }
            if (com.bytedance.adsdk.g.g.gc.z.dl(z(i + 1, str))) {
                return true;
            }
            throw new IllegalArgumentException("Unrecognized - symbol, not a negative number or operator, problem range:" + str.substring(0, i));
        }
        return com.bytedance.adsdk.g.g.gc.z.dl(z(i, str));
    }

    @Override // com.bytedance.adsdk.g.g.dl.z.m
    public int z(String str, int i, Deque<com.bytedance.adsdk.g.g.g.z> deque, com.bytedance.adsdk.g.g.dl.z zVar) {
        char cZ;
        if (!z(str, i, deque)) {
            return zVar.z(str, i, deque);
        }
        int i2 = z(i, str) == '-' ? i + 1 : i;
        boolean z = false;
        while (true) {
            cZ = z(i2, str);
            if (!com.bytedance.adsdk.g.g.gc.z.dl(cZ) && (z || cZ != '.')) {
                break;
            }
            i2++;
            if (cZ == '.') {
                z = true;
            }
        }
        if (cZ == '.') {
            throw new IllegalArgumentException("Illegal negative number format, problem interval:" + str.substring(i, i2));
        }
        deque.push(new pf(str.substring(i, i2)));
        return i2;
    }
}
