package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.content.Context;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.adexpress.dynamic.dl.gz;
import com.bytedance.sdk.component.adexpress.widget.TTRatingBar2;

/* JADX INFO: loaded from: classes2.dex */
public class DynamicStarView extends DynamicBaseWidgetImp {
    private int z;

    public DynamicStarView(Context context, DynamicRootView dynamicRootView, gz gzVar) {
        super(context, dynamicRootView, gzVar);
        this.z = 0;
        this.pf = new TTRatingBar2(context, null);
        this.pf.setTag(Integer.valueOf(getClickArea()));
        addView(this.pf, getWidgetLayoutParams());
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidgetImp
    protected FrameLayout.LayoutParams getWidgetLayoutParams() {
        int iZ = (int) ((com.bytedance.sdk.component.adexpress.a.gz.z(com.bytedance.sdk.component.adexpress.a.getContext(), this.wp.gc()) * 5.0f) + com.bytedance.sdk.component.adexpress.a.gz.z(com.bytedance.sdk.component.adexpress.a.getContext(), this.wp.dl() + com.bytedance.sdk.component.adexpress.a.gz.z(com.bytedance.sdk.component.adexpress.a.getContext(), this.wp.a())));
        if (this.e > iZ && 4 == this.wp.gz()) {
            this.z = (this.e - iZ) / 2;
        }
        this.e = iZ;
        return new FrameLayout.LayoutParams(this.e, this.gz);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget
    public void gc() {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.e, this.gz);
        layoutParams.topMargin = this.uy;
        layoutParams.leftMargin = this.fo + this.z;
        layoutParams.setMarginStart(layoutParams.leftMargin);
        layoutParams.setMarginEnd(layoutParams.rightMargin);
        setLayoutParams(layoutParams);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidgetImp, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.a
    public boolean gz() {
        super.gz();
        double dI = this.wp.i();
        if (com.bytedance.sdk.component.adexpress.a.z() && (dI < 0.0d || dI > 5.0d || (this.v != null && this.v.getRenderRequest() != null && this.v.getRenderRequest().i() != 4))) {
            this.pf.setVisibility(8);
            return true;
        }
        double d = (dI < 0.0d || dI > 5.0d) ? 5.0d : dI;
        this.pf.setVisibility(0);
        ((TTRatingBar2) this.pf).z(d, this.wp.e(), (int) this.wp.gc(), ((int) com.bytedance.sdk.component.adexpress.a.gz.z(this.kb, this.wp.g())) + ((int) com.bytedance.sdk.component.adexpress.a.gz.z(this.kb, this.wp.z())) + ((int) com.bytedance.sdk.component.adexpress.a.gz.z(this.kb, this.wp.gc())));
        return true;
    }
}
