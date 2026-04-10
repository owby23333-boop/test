package com.bytedance.msdk.dl.dl.g.z.g;

import android.content.Context;
import com.bytedance.sdk.openadsdk.core.lq;
import com.bytedance.sdk.openadsdk.ls.dl.dl.g;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class uy extends g {
    private com.bytedance.msdk.dl.m.g.g dl;
    private com.bytedance.msdk.api.z.g g;

    public uy(com.bytedance.msdk.dl.z.g gVar) {
        super(gVar);
    }

    @Override // com.bytedance.msdk.dl.dl.g.z.g
    public void g(Context context, com.bytedance.msdk.dl.m.g.g gVar, com.bytedance.msdk.api.z.g gVar2, Map<String, Object> map) {
        lq lqVarZ;
        this.g = gVar2;
        this.dl = gVar;
        if (gVar2 == null) {
            z(new com.bytedance.msdk.api.z("load ad fail adSlot is null"));
            return;
        }
        if (map == null || (lqVarZ = z(context.getApplicationContext())) == null) {
            return;
        }
        g.z zVarZ = com.bytedance.msdk.z.dl.g.z(this.g, this.dl, false);
        int iUf = this.g.uf();
        int iSy = this.g.sy();
        if (iUf > 0 && iSy > 0) {
            zVarZ.z(iUf).g(iSy);
        }
        Object obj = map.get("tt_ad_origin_type");
        if (obj != null) {
            int iIntValue = ((Integer) obj).intValue();
            if (iIntValue == 1) {
                z(lqVarZ, zVarZ);
            } else if (iIntValue == 2) {
                g(lqVarZ, zVarZ);
            } else if (iIntValue == 3) {
                z(new com.bytedance.msdk.api.z("渲染类型错误"));
            }
        }
    }

    private void z(lq lqVar, g.z zVar) {
        if (this.g.pf() > 0.0f) {
            zVar.z(this.g.v()).g(this.g.pf());
        } else {
            zVar.z(this.g.v()).g(0.0f);
        }
        new fo().z(this.dl.z(), lqVar, zVar.z(), this);
    }

    private void g(lq lqVar, g.z zVar) {
        com.bytedance.msdk.z.gc.dl.g("TTMediationSDK", "PangleNativeLoader_loadNativeAd_renderControl:" + this.g.ls());
        zVar.dl(this.g.ls());
        new gz().z(this.dl.z(), lqVar, zVar.z(), this);
    }
}
