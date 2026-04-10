package com.bytedance.adsdk.ugeno.widget.scroll;

import android.content.Context;
import android.widget.ScrollView;
import com.bytedance.adsdk.ugeno.g.z;
import com.bytedance.adsdk.ugeno.widget.frame.z;

/* JADX INFO: loaded from: classes2.dex */
public class z extends com.bytedance.adsdk.ugeno.g.z<ScrollView> {
    public z(Context context) {
        super(context);
    }

    @Override // com.bytedance.adsdk.ugeno.g.dl
    /* JADX INFO: renamed from: jq, reason: merged with bridge method [inline-methods] */
    public ScrollView z() {
        UGScrollView uGScrollView = new UGScrollView(this.g);
        uGScrollView.z(this);
        return uGScrollView;
    }

    @Override // com.bytedance.adsdk.ugeno.g.z
    public z.C0045z gz() {
        return new z.C0048z(this);
    }
}
