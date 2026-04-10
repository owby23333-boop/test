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
public class z extends com.bytedance.adsdk.ugeno.gc.dl.g implements iq {
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

    public z(Context context) {
        super(context);
        this.kb = new com.bytedance.sdk.component.utils.iq(context, 1, uy.ls().gc());
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

    @Override // com.bytedance.adsdk.ugeno.gc.dl.g
    public boolean z(Object... objArr) {
        Map<String, Object> mapG;
        this.g.z(this);
        if (this.kb == null) {
            this.kb = new com.bytedance.sdk.component.utils.iq(this.uy, 1, uy.ls().gc());
        }
        v vVarTi = this.g.ti();
        if (vVarTi == null || (mapG = vVarTi.g()) == null) {
            return false;
        }
        Object obj = mapG.get("shake_value");
        if (obj instanceof Integer) {
            this.kb.z(((Integer) obj).floatValue());
        }
        Object obj2 = mapG.get("calculation_method");
        if (obj2 instanceof Integer) {
            this.kb.gc(((Integer) obj2).intValue());
        }
        Object obj3 = mapG.get("shake_interact_conf");
        if (obj3 instanceof JSONObject) {
            this.kb.dl((JSONObject) obj3);
        }
        Object obj4 = mapG.get("rotation_angle");
        if (obj4 instanceof Integer) {
            this.kb.g(((Integer) obj4).floatValue());
        }
        Object obj5 = mapG.get("twist_config");
        if (obj5 instanceof JSONObject) {
            this.kb.z((JSONObject) obj5);
        }
        Object obj6 = mapG.get("twist_interact_conf");
        if (obj6 instanceof JSONObject) {
            this.kb.g((JSONObject) obj6);
        }
        Object obj7 = mapG.get("calculation_method_twist");
        if (!(obj7 instanceof Integer)) {
            return false;
        }
        this.kb.m(((Integer) obj7).intValue());
        return false;
    }

    @Override // com.bytedance.adsdk.ugeno.dl.iq
    public void a() {
        if (this.kb == null || !this.g.fo().isShown()) {
            return;
        }
        this.kb.z(new iq.z() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.g.z.1
            @Override // com.bytedance.sdk.component.utils.iq.z
            public void z(int i) {
                if (z.this.z == null || i != 1) {
                    return;
                }
                z.this.z.z(z.this.g, z.this.m, z.this.dl.g());
            }
        });
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
