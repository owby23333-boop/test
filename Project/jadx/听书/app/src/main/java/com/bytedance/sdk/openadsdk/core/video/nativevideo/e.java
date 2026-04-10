package com.bytedance.sdk.openadsdk.core.video.nativevideo;

import com.bytedance.sdk.component.utils.wp;

/* JADX INFO: loaded from: classes2.dex */
public class e {
    private m z;

    public e(m mVar) {
        this.z = mVar;
    }

    public boolean z() {
        boolean z = this.z.hh != null ? this.z.hh.z() : false;
        wp.z("ClickCreativeListener", "isVisible=" + z + ",mPlayBtn.getVisibility() == VISIBLE->" + (this.z.dl.getVisibility() == 0));
        return z || this.z.dl.getVisibility() == 0;
    }

    public boolean g() {
        if (com.bytedance.sdk.openadsdk.core.video.dl.z.z(this.z.uf)) {
            return true;
        }
        return (this.z.gz != null && this.z.gz.getVisibility() == 0) || (this.z.uy != null && this.z.uy.getVisibility() == 0) || ((this.z.kb != null && this.z.kb.getVisibility() == 0) || (this.z.wp != null && this.z.wp.getVisibility() == 0));
    }
}
