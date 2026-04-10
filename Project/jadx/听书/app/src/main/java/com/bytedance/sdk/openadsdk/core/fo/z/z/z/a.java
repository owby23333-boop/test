package com.bytedance.sdk.openadsdk.core.fo.z.z.z;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.iq.na;
import com.bytedance.sdk.openadsdk.core.un.eo;
import com.bytedance.sdk.openadsdk.core.un.lq;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class a extends z {
    public a(na naVar, Context context, String str, com.bytedance.sdk.openadsdk.core.kb.dl.dl.dl dlVar, String str2) {
        this.z = naVar;
        this.g = context;
        this.dl = str;
        this.f1063a = dlVar;
        this.gc = str2;
    }

    @Override // com.bytedance.sdk.openadsdk.core.fo.z.z.z.z
    public com.bytedance.sdk.openadsdk.core.kb.z.g a(final Map<String, Object> map) {
        final int iDl = z.dl(map);
        com.bytedance.sdk.openadsdk.core.kb.dl.g.g.z(this.dl, this.dl, eo.js(this.z), iDl);
        map.put("action_type_button", 2);
        if (this.z != null && !TextUtils.isEmpty(this.z.mj())) {
            map.put("id", Long.valueOf(Double.valueOf(this.z.mj()).longValue()));
        }
        if (!dl(iDl)) {
            z(map, true);
            return null;
        }
        com.bytedance.sdk.openadsdk.core.kb.z.g gVar = new com.bytedance.sdk.openadsdk.core.kb.z.g() { // from class: com.bytedance.sdk.openadsdk.core.fo.z.z.z.a.1
            @Override // com.ss.android.z.z.g.p
            public void z(boolean z) {
            }

            @Override // com.ss.android.z.z.g.p
            public void z() {
                if (map == null) {
                    return;
                }
                com.bytedance.sdk.openadsdk.core.kb.dl.g.g.z(0, iDl);
                a.this.f1063a.z(a.this.g(iDl));
                map.remove("downloadButtonClickListener");
                if (a.this.z((com.bytedance.sdk.openadsdk.core.iq.a) null, (com.bytedance.sdk.openadsdk.core.kb.z.g) null, map)) {
                    return;
                }
                a.this.z(map, true);
            }
        };
        com.bytedance.sdk.openadsdk.core.kb.dl.g.g.z(map, gVar);
        return gVar;
    }

    @Override // com.bytedance.sdk.openadsdk.core.fo.z.z.z.z
    public boolean dl(int i) {
        return this.fo != null && com.bytedance.sdk.openadsdk.core.kb.dl.g.g.z(this.fo, i) == 2;
    }

    @Override // com.bytedance.sdk.openadsdk.core.fo.z.z.z.z
    public void g(boolean z, int i) {
        com.bytedance.sdk.openadsdk.core.kb.dl.g.g.z(z, com.bytedance.sdk.openadsdk.core.kb.dl.g.g.z(this.z, this.m), i);
    }

    @Override // com.bytedance.sdk.openadsdk.core.fo.z.z.z.z
    public com.bytedance.sdk.openadsdk.core.kb.z.gc z(Map<String, Object> map, final lq<String, Object> lqVar) {
        final int iDl = z.dl(lqVar);
        return new com.bytedance.sdk.openadsdk.core.kb.z.gc() { // from class: com.bytedance.sdk.openadsdk.core.fo.z.z.z.a.2
            @Override // com.bytedance.sdk.openadsdk.core.kb.z.gc
            public void onItemClick() {
                if (!a.this.e && !a.this.z.fs()) {
                    com.bytedance.sdk.openadsdk.core.fo.z.z.g.z zVar = new com.bytedance.sdk.openadsdk.core.fo.z.z.g.z(a.this.z, a.this.g, a.this.dl, eo.g(a.this.dl));
                    zVar.dl(true);
                    zVar.z((Map<String, Object>) new HashMap());
                } else {
                    com.bytedance.sdk.openadsdk.core.kb.dl.g.g.g(1, iDl);
                    lqVar.remove("itemClickListener");
                    a.this.fo.apply(com.bytedance.sdk.openadsdk.ls.a.z().z(17).z(Void.class).z(0, lqVar).g());
                }
            }
        };
    }
}
