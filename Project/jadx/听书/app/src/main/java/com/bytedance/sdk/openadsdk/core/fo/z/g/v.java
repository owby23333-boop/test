package com.bytedance.sdk.openadsdk.core.fo.z.g;

import android.content.Context;
import com.bytedance.sdk.openadsdk.core.iq.na;
import com.umeng.analytics.pro.d;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@com.bytedance.sdk.component.kb.g.g
public class v implements com.bytedance.sdk.component.kb.z.z.dl {

    @com.bytedance.sdk.component.kb.g.z(z = d.R)
    private Context g;

    @com.bytedance.sdk.component.kb.g.z(z = "material_meta")
    private na z;

    @Override // com.bytedance.sdk.component.kb.z.z.dl
    public boolean z(Map<String, Object> map, Map<String, Object> map2, com.bytedance.sdk.component.kb.z.z zVar) {
        Context context;
        na naVar = this.z;
        if (naVar == null || (context = this.g) == null) {
            zVar.g(map2);
            return true;
        }
        com.bytedance.sdk.openadsdk.core.un.m.z(context, naVar);
        zVar.z(map2);
        return true;
    }
}
