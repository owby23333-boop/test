package com.bytedance.sdk.openadsdk.core.component.reward.swiper;

import com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity;
import com.bytedance.sdk.openadsdk.core.component.reward.draw.g;
import com.bytedance.sdk.openadsdk.core.i.a;
import com.bytedance.sdk.openadsdk.core.iq.hh;
import com.bytedance.sdk.openadsdk.core.iq.na;
import com.bytedance.sdk.openadsdk.core.iq.tf;
import com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView;
import com.bytedance.sdk.openadsdk.core.nativeexpress.io;
import com.bytedance.sdk.openadsdk.core.un.un;
import com.bytedance.sdk.openadsdk.hh.uy;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class z extends g {
    private boolean m;

    public z(TTBaseVideoActivity tTBaseVideoActivity, na naVar, String str, boolean z, boolean z2) {
        super(tTBaseVideoActivity, naVar, str, z, z2);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.draw.g
    public void z(NativeExpressView nativeExpressView) {
        Map<String, Object> mapZ = this.z.z(this.g);
        if (nativeExpressView.getDynamicShowType() == 0) {
            io.z(mapZ, this.g, nativeExpressView);
        } else {
            mapZ.put("dynamic_show_type", Integer.valueOf(nativeExpressView.getDynamicShowType()));
        }
        hh hhVarDp = this.g.dp();
        Double dGp = null;
        if (hhVarDp != null) {
            mapZ.put("refresh_num", Integer.valueOf(hhVarDp.dl()));
            if (this.m) {
                dGp = this.z.gp();
            }
        }
        a.z(this.g, this.dl, mapZ, dGp);
        com.bytedance.sdk.openadsdk.core.l.z.z().a();
        un.z(this.g.gc());
    }

    public void dl(boolean z) {
        this.m = z;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.draw.g
    public com.bykv.vk.openvk.component.video.api.dl.a uy() {
        com.bykv.vk.openvk.component.video.api.dl.a aVarZ = tf.z(1, this.g);
        aVarZ.g(this.g.mj());
        aVarZ.g(100);
        aVarZ.dl(100);
        aVarZ.dl(this.g.vk());
        aVarZ.g(this.f946a);
        if (uy.z(this.g)) {
            aVarZ.z(true);
        }
        return aVarZ;
    }
}
