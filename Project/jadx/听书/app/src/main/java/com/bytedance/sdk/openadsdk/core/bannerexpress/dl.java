package com.bytedance.sdk.openadsdk.core.bannerexpress;

import android.content.Context;
import com.bytedance.sdk.openadsdk.core.iq.na;

/* JADX INFO: loaded from: classes3.dex */
public class dl extends g {
    public dl(Context context, na naVar, com.bytedance.sdk.openadsdk.ls.dl.dl.g gVar) {
        super(context, naVar, gVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.bannerexpress.g
    protected void z(Context context, na naVar, com.bytedance.sdk.openadsdk.ls.dl.dl.g gVar) {
        if (context == null) {
            return;
        }
        this.z = new BannerExpressVideoView(context, naVar, gVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.g, com.bytedance.sdk.openadsdk.ls.dl.g.v
    public void z(com.bytedance.sdk.openadsdk.uf.z.g.z.dl dlVar) {
        if (this.z != null) {
            this.z.setVideoAdListener(dlVar);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.g
    public com.bytedance.sdk.openadsdk.core.multipro.g.z kb() {
        if (this.e != null && this.e.get() != null) {
            return this.e.get().getVideoModel();
        }
        if (this.z != null) {
            return ((BannerExpressVideoView) this.z).getVideoModel();
        }
        return null;
    }
}
