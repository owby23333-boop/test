package com.bytedance.sdk.openadsdk.core.dislike;

import android.content.Context;
import com.bytedance.sdk.openadsdk.core.un.oq;
import com.bytedance.sdk.openadsdk.ls.dl.g.m;

/* JADX INFO: loaded from: classes2.dex */
public class g {
    private static com.bytedance.sdk.openadsdk.core.dislike.z.a g;
    private static com.bytedance.sdk.openadsdk.core.dislike.z.dl z;

    public static void z() {
        if (g == null) {
            g = new com.bytedance.sdk.openadsdk.core.dislike.z.a() { // from class: com.bytedance.sdk.openadsdk.core.dislike.g.1
                @Override // com.bytedance.sdk.openadsdk.core.dislike.z.a
                public int z(Context context, float f) {
                    return oq.dl(context, f);
                }
            };
        }
        if (z == null) {
            z = new com.bytedance.sdk.openadsdk.core.dislike.z.dl() { // from class: com.bytedance.sdk.openadsdk.core.dislike.g.2
                @Override // com.bytedance.sdk.openadsdk.core.dislike.z.dl
                public void z(com.bytedance.sdk.openadsdk.core.dislike.dl.g gVar, m mVar) {
                    com.bytedance.sdk.openadsdk.core.i.a.z(gVar, mVar);
                }

                @Override // com.bytedance.sdk.openadsdk.core.dislike.z.dl
                public void z(Context context, com.bytedance.sdk.openadsdk.core.dislike.dl.g gVar, String str) {
                    com.bytedance.sdk.openadsdk.core.i.a.z(gVar.dl(), gVar.a(), gVar.e(), str);
                }
            };
        }
        com.bytedance.sdk.openadsdk.core.dislike.z.z.z(z, g);
    }
}
