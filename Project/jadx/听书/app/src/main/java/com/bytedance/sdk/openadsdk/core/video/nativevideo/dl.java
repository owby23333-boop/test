package com.bytedance.sdk.openadsdk.core.video.nativevideo;

import android.content.Context;
import android.view.ViewGroup;
import com.bytedance.sdk.openadsdk.core.iq.na;

/* JADX INFO: loaded from: classes3.dex */
public class dl extends a {
    public dl(Context context, ViewGroup viewGroup, na naVar, String str, boolean z, boolean z2, boolean z3) {
        super(context, viewGroup, naVar, str, z, z2, z3);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.a
    public void z(int i, int i2) {
        super.z(i, i2);
        if (this.gc == null || i <= 0 || i2 <= 0) {
            return;
        }
        this.gc.dl(i, i2);
        this.gc.z(i, i2);
        g(-1, -1);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.a
    protected com.bykv.vk.openvk.component.video.api.renderview.g zw() {
        if (this.gc != null) {
            return this.gc.p();
        }
        return null;
    }
}
