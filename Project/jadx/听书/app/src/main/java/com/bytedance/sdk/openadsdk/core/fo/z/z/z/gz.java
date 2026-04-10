package com.bytedance.sdk.openadsdk.core.fo.z.z.z;

import android.content.Context;
import com.bytedance.sdk.openadsdk.core.g.z.g.gc;
import com.bytedance.sdk.openadsdk.core.iq.ja;
import com.bytedance.sdk.openadsdk.core.iq.na;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class gz implements com.bytedance.sdk.openadsdk.core.fo.z.z.z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f1061a;
    private Context dl;
    private Map<String, Object> e;
    private int fo;
    private na g;
    private String gc;
    private com.bytedance.sdk.component.kb.z.z gz;
    private ja m;
    private com.bytedance.sdk.openadsdk.core.fo.z.z.z z;

    public gz(ja jaVar, Context context, boolean z, String str, Map<String, Object> map, com.bytedance.sdk.component.kb.z.z zVar, int i) {
        this.m = jaVar;
        this.dl = context;
        this.f1061a = z;
        this.gc = str;
        this.e = map;
        this.gz = zVar;
        this.fo = i;
    }

    public void z(na naVar) {
        this.g = naVar;
    }

    @Override // com.bytedance.sdk.openadsdk.core.fo.z.z.z
    public boolean z(final Map<String, Object> map) {
        boolean z = !com.bytedance.sdk.openadsdk.core.g.z.g.gc.z() ? new com.bytedance.sdk.openadsdk.core.g.z.g.gc(this.g, this.dl).z(this.gc).z(this.fo).g(this.f1061a).z(new gc.z() { // from class: com.bytedance.sdk.openadsdk.core.fo.z.z.z.gz.1
            @Override // com.bytedance.sdk.openadsdk.core.g.z.g.gc.z
            public void z() {
            }

            @Override // com.bytedance.sdk.openadsdk.core.g.z.g.gc.z
            public void g() {
                if (gz.this.z != null ? gz.this.z.z(map) : false) {
                    return;
                }
                gz.this.gz.g(gz.this.e);
            }
        }) : false;
        com.bytedance.sdk.openadsdk.core.g.z.g.gc.z(false);
        if (z) {
            return true;
        }
        com.bytedance.sdk.openadsdk.core.fo.z.z.z zVar = this.z;
        return zVar != null && zVar.z(map);
    }
}
