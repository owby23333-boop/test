package com.bytedance.sdk.openadsdk.core.bf.e.e;

import com.bytedance.sdk.openadsdk.TTNativeAd;
import com.bytedance.sdk.openadsdk.core.a.a;
import com.bytedance.sdk.openadsdk.core.a.s;
import com.bytedance.sdk.openadsdk.core.rt;
import java.util.Map;

/* JADX INFO: loaded from: classes10.dex */
public class v extends bf {
    protected boolean p = false;

    @Override // com.bytedance.sdk.openadsdk.core.bf.e.e.bf
    public boolean d(Map<String, Object> map) {
        String str;
        boolean z;
        boolean z2;
        boolean z3;
        String strXu = this.ga.xu();
        if (this.ga.vn()) {
            if ((this.ga.t() instanceof TTNativeAd) || this.p) {
                map.put("is_need_report_click_button", Boolean.TRUE);
            }
            boolean zP = this.ga.p();
            rt.e(true);
            str = strXu;
            z = zP;
            z3 = false;
            z2 = false;
        } else {
            boolean zD = s.d(this.e);
            ga gaVar = this.ga;
            String strXu2 = zD ? gaVar.xu() : a.e(gaVar.m());
            this.ga.e(strXu2);
            this.ga.d(zD);
            str = strXu2;
            z = true;
            z2 = true;
            z3 = zD;
        }
        this.vn.e(this.e, map);
        return !this.vn.e(map, z3, str, z, z2, false);
    }

    public void vn(boolean z) {
        this.p = z;
    }
}
