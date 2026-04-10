package com.bytedance.sdk.openadsdk.core.component.reward.z;

import com.bytedance.sdk.openadsdk.core.iq.gz;
import com.bytedance.sdk.openadsdk.core.zw;

/* JADX INFO: loaded from: classes2.dex */
public class gc {
    private static final com.bytedance.sdk.openadsdk.core.gc.dl.z z = new com.bytedance.sdk.openadsdk.core.gc.dl.g(7);
    private static final com.bytedance.sdk.openadsdk.core.gc.dl.z g = new com.bytedance.sdk.openadsdk.core.gc.dl.g(8);
    private static final com.bytedance.sdk.openadsdk.core.gc.dl.z dl = new com.bytedance.sdk.openadsdk.core.gc.dl.gc(7);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final com.bytedance.sdk.openadsdk.core.gc.dl.z f983a = new com.bytedance.sdk.openadsdk.core.gc.dl.gc(8);
    private static final com.bytedance.sdk.openadsdk.core.gc.dl.z gc = new com.bytedance.sdk.openadsdk.core.gc.dl.a(7);
    private static final com.bytedance.sdk.openadsdk.core.gc.dl.z m = new com.bytedance.sdk.openadsdk.core.gc.dl.a(8);
    private static final com.bytedance.sdk.openadsdk.core.gc.dl.z e = new com.bytedance.sdk.openadsdk.core.gc.dl.dl(7);
    private static final com.bytedance.sdk.openadsdk.core.gc.dl.z gz = new com.bytedance.sdk.openadsdk.core.gc.dl.dl(8);

    public static int z(boolean z2) {
        gz.g gVarZ = com.bytedance.sdk.openadsdk.core.iq.gz.z(z2 ? 7 : 8);
        if (!gVarZ.e() || !zw.g().cn()) {
            return -1;
        }
        int iA = gVarZ.a();
        if (iA < 0 || iA == 2 || iA > 4) {
            return 1;
        }
        return iA;
    }

    public static com.bytedance.sdk.openadsdk.core.gc.dl.z z(boolean z2, boolean z3) {
        if (z3) {
            return z2 ? e : gz;
        }
        int iZ = z(z2);
        return iZ != -1 ? iZ != 0 ? iZ != 3 ? z2 ? dl : f983a : z2 ? gc : m : z2 ? z : g : z2 ? e : gz;
    }
}
