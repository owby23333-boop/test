package com.bytedance.sdk.openadsdk.core.ugeno.component.skip;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.adsdk.ugeno.widget.text.UGTextView;

/* JADX INFO: loaded from: classes3.dex */
public class g extends com.bytedance.adsdk.ugeno.widget.text.g {
    public g(Context context) {
        super(context);
    }

    @Override // com.bytedance.adsdk.ugeno.widget.text.g, com.bytedance.adsdk.ugeno.g.dl
    public void g() {
        super.g();
        if (TextUtils.isEmpty(this.z)) {
            ((UGTextView) this.gc).setText("跳过");
        }
    }

    public void a(boolean z) {
        if (z) {
            g(0);
            z(true, true);
        } else {
            a(0);
            gc(0);
        }
    }
}
