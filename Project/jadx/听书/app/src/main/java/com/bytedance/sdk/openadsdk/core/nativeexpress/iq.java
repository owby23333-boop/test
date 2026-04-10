package com.bytedance.sdk.openadsdk.core.nativeexpress;

import android.content.Context;
import com.bytedance.sdk.openadsdk.core.iq.na;

/* JADX INFO: loaded from: classes3.dex */
public class iq extends zw {
    public iq(Context context, na naVar, com.bytedance.sdk.openadsdk.ls.dl.dl.g gVar) {
        super(context, naVar, gVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.zw, com.bytedance.sdk.openadsdk.core.nativeexpress.q
    public void z(Context context, na naVar, com.bytedance.sdk.openadsdk.ls.dl.dl.g gVar) {
        this.f1284a = "draw_ad";
        this.z = new NativeExpressDrawVideoView(context, naVar, gVar, "draw_ad");
        z(this.z, this.dl);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.g, com.bytedance.sdk.openadsdk.ls.dl.g.v
    public void z(boolean z) {
        if (this.z != null) {
            ((NativeExpressVideoView) this.z).setCanInterruptVideoPlay(z);
        }
    }
}
