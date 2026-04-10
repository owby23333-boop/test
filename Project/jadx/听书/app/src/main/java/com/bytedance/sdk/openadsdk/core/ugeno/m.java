package com.bytedance.sdk.openadsdk.core.ugeno;

import android.content.Context;
import com.bytedance.adsdk.ugeno.dl.g.a;
import com.bytedance.sdk.component.utils.iq;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class m implements a.z {
    private com.bytedance.adsdk.ugeno.g.dl g;
    private iq z;

    public m(Context context, com.bytedance.adsdk.ugeno.g.dl dlVar) {
        this.z = new iq(context, 1, com.bytedance.sdk.openadsdk.core.uy.ls().gc());
        this.g = dlVar;
    }

    private int dl() {
        JSONObject jSONObjectUy;
        com.bytedance.adsdk.ugeno.g.dl dlVar = this.g;
        if (dlVar == null || (jSONObjectUy = dlVar.uy()) == null) {
            return 0;
        }
        return jSONObjectUy.optInt("meta_hashcode", 0);
    }

    @Override // com.bytedance.adsdk.ugeno.dl.g.a.z
    public void z() {
        iq iqVar = this.z;
        if (iqVar != null) {
            iqVar.z(dl());
        }
    }

    @Override // com.bytedance.adsdk.ugeno.dl.g.a.z
    public void g() {
        iq iqVar = this.z;
        if (iqVar != null) {
            iqVar.g(dl());
        }
    }

    @Override // com.bytedance.adsdk.ugeno.dl.g.a.z
    public void z(float f) {
        iq iqVar = this.z;
        if (iqVar != null) {
            iqVar.z(f);
        }
    }

    @Override // com.bytedance.adsdk.ugeno.dl.g.a.z
    public void z(final a.g gVar) {
        iq iqVar = this.z;
        if (iqVar != null) {
            iqVar.z(new iq.z() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.m.1
                @Override // com.bytedance.sdk.component.utils.iq.z
                public void z(int i) {
                    a.g gVar2 = gVar;
                    if (gVar2 != null) {
                        gVar2.z(i);
                    }
                }
            });
        }
    }
}
