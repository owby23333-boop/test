package com.bytedance.sdk.openadsdk.core.ugeno.g;

import android.content.Context;
import com.bytedance.adsdk.ugeno.dl.iq;
import com.bytedance.adsdk.ugeno.dl.q;
import com.bytedance.adsdk.ugeno.dl.v;
import com.bytedance.sdk.component.utils.iq;
import com.bytedance.sdk.openadsdk.core.uy;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class g extends com.bytedance.adsdk.ugeno.gc.dl.g implements iq {
    private com.bytedance.sdk.component.utils.iq kb;

    @Override // com.bytedance.adsdk.ugeno.dl.iq
    public void dl() {
    }

    @Override // com.bytedance.adsdk.ugeno.dl.iq
    public void g() {
    }

    @Override // com.bytedance.adsdk.ugeno.dl.iq
    public void z() {
    }

    @Override // com.bytedance.adsdk.ugeno.dl.iq
    public void z(q qVar) {
    }

    @Override // com.bytedance.adsdk.ugeno.dl.iq
    public void z(JSONObject jSONObject) {
    }

    public g(Context context) {
        super(context);
        this.kb = new com.bytedance.sdk.component.utils.iq(context, 2, uy.ls().gc());
    }

    @Override // com.bytedance.adsdk.ugeno.gc.dl.g
    public boolean z(Object... objArr) {
        this.g.z(this);
        if (this.kb == null) {
            this.kb = new com.bytedance.sdk.component.utils.iq(this.uy, 2, uy.ls().gc());
        }
        v vVarTi = this.g.ti();
        if (vVarTi == null) {
            return false;
        }
        Map<String, Object> mapG = vVarTi.g();
        if (mapG != null) {
            Object obj = mapG.get("rotation_angle");
            if (obj instanceof Integer) {
                this.kb.g(((Integer) obj).floatValue());
            }
            Object obj2 = mapG.get("calculation_method_twist");
            if (obj2 instanceof Integer) {
                this.kb.m(((Integer) obj2).intValue());
            }
            Object obj3 = mapG.get("twist_config");
            if (obj3 instanceof JSONObject) {
                this.kb.z((JSONObject) obj3);
            }
            Object obj4 = mapG.get("twist_interact_conf");
            if (obj4 instanceof JSONObject) {
                this.kb.g((JSONObject) obj4);
            }
        }
        this.kb.z(new iq.z() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.g.g.1
            @Override // com.bytedance.sdk.component.utils.iq.z
            public void z(int i) {
                if (g.this.z == null || i != 2) {
                    return;
                }
                g.this.z.z(g.this.g, g.this.m, g.this.dl.g());
            }
        });
        return false;
    }

    private int fo() {
        JSONObject jSONObjectZ;
        if (this.g == null) {
            return 0;
        }
        JSONObject jSONObjectUy = this.g.uy();
        if (jSONObjectUy != null) {
            return jSONObjectUy.optInt("meta_hashcode", 0);
        }
        v vVarTi = this.g.ti();
        if (vVarTi == null || (jSONObjectZ = vVarTi.z()) == null) {
            return 0;
        }
        return jSONObjectZ.optInt("meta_hashcode", 0);
    }

    @Override // com.bytedance.adsdk.ugeno.dl.iq
    public void a() {
        if (this.kb == null || !this.g.fo().isShown()) {
            return;
        }
        this.kb.z(fo());
    }

    @Override // com.bytedance.adsdk.ugeno.dl.iq
    public void gc() {
        com.bytedance.sdk.component.utils.iq iqVar = this.kb;
        if (iqVar != null) {
            iqVar.g(fo());
        }
    }

    @Override // com.bytedance.adsdk.ugeno.dl.iq
    public void z(boolean z) {
        com.bytedance.sdk.component.utils.iq iqVar = this.kb;
        if (iqVar != null) {
            if (z) {
                iqVar.z(fo());
            } else {
                iqVar.g(fo());
            }
        }
    }
}
