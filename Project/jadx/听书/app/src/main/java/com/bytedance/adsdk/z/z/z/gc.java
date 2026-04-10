package com.bytedance.adsdk.z.z.z;

import android.text.TextUtils;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
class gc {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f283a;
    int e;
    int gc;
    int m;

    void z(com.bytedance.adsdk.z.z.g.z zVar) throws IOException {
    }

    gc() {
    }

    static int z(String str) {
        if (TextUtils.isEmpty(str) || str.length() != 4) {
            return -1159790593;
        }
        return ((str.charAt(3) & 255) << 24) | (str.charAt(0) & 255) | ((str.charAt(1) & 255) << 8) | ((str.charAt(2) & 255) << 16);
    }

    void g(com.bytedance.adsdk.z.z.g.z zVar) throws IOException {
        int iA = zVar.a();
        z(zVar);
        int iA2 = iA - zVar.a();
        int i = this.f283a;
        if (iA2 > i) {
            throw new IOException("Out of chunk area");
        }
        if (iA2 < i) {
            zVar.z(i - iA2);
        }
    }
}
