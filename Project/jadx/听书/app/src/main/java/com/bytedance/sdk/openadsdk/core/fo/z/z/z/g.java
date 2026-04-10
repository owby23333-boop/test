package com.bytedance.sdk.openadsdk.core.fo.z.z.z;

import android.content.Context;
import com.bytedance.sdk.openadsdk.core.g.z.g.dl;
import com.bytedance.sdk.openadsdk.core.iq.na;
import com.bytedance.sdk.openadsdk.core.ugeno.uy;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class g implements com.bytedance.sdk.openadsdk.core.fo.z.z.z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.core.fo.z.z.z f1059a;
    private String dl;
    private na g;
    private com.bytedance.sdk.component.kb.z.z gc;
    private Map<String, Object> m;
    private Context z;

    public g(com.bytedance.sdk.openadsdk.core.fo.z.z.z zVar, Context context, na naVar, String str, Map<String, Object> map, com.bytedance.sdk.component.kb.z.z zVar2) {
        this.f1059a = zVar;
        this.z = context;
        this.g = naVar;
        this.dl = str;
        this.gc = zVar2;
        this.m = map;
    }

    @Override // com.bytedance.sdk.openadsdk.core.fo.z.z.z
    public boolean z(final Map<String, Object> map) {
        if (!com.bytedance.sdk.openadsdk.core.g.z.g.dl.z(this.g, false)) {
            com.bytedance.sdk.openadsdk.core.fo.z.z.z zVar = this.f1059a;
            return zVar != null && zVar.z(map);
        }
        if (uy.gc(this.g)) {
            com.bytedance.sdk.openadsdk.core.fo.z.z.z zVar2 = this.f1059a;
            return zVar2 != null && zVar2.z(map);
        }
        if (uy.a(this.g)) {
            com.bytedance.sdk.openadsdk.core.fo.z.z.z zVar3 = this.f1059a;
            return zVar3 != null && zVar3.z(map);
        }
        new com.bytedance.sdk.openadsdk.core.g.z.g.dl(this.g, this.z).z(this.dl).z(new dl.z() { // from class: com.bytedance.sdk.openadsdk.core.fo.z.z.z.g.1
            @Override // com.bytedance.sdk.openadsdk.core.g.z.g.dl.z
            public void z() {
                if (g.this.f1059a.z(map)) {
                    return;
                }
                g.this.gc.g(g.this.m);
            }
        });
        return true;
    }
}
