package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.bytedance.sdk.component.adexpress.dynamic.dl.gz;
import com.bytedance.sdk.component.utils.tb;

/* JADX INFO: loaded from: classes3.dex */
public class DynamicTimeOuterRewardFullSkip extends DynamicBaseWidgetImp implements com.bytedance.sdk.component.adexpress.dynamic.dl {
    private boolean z;

    public DynamicTimeOuterRewardFullSkip(Context context, DynamicRootView dynamicRootView, gz gzVar) {
        super(context, dynamicRootView, gzVar);
        if (dynamicRootView.getRenderRequest() != null) {
            this.z = dynamicRootView.getRenderRequest().ls();
        }
        this.e = this.gz;
        this.pf = new ImageView(context);
        this.pf.setTag(Integer.valueOf(getClickArea()));
        addView(this.pf, getWidgetLayoutParams());
        dynamicRootView.setTimeOutListener(this);
        if (dynamicRootView.getRenderRequest() == null || dynamicRootView.getRenderRequest().l()) {
            return;
        }
        this.pf.setVisibility(8);
        setVisibility(8);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidgetImp, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.a
    public boolean gz() {
        Drawable drawableDl;
        super.gz();
        ((ImageView) this.pf).setScaleType(ImageView.ScaleType.CENTER_CROP);
        Drawable drawableZ = com.bytedance.sdk.component.adexpress.a.a.z(getContext(), this.wp);
        if (drawableZ != null) {
            ((ImageView) this.pf).setBackground(drawableZ);
        }
        if (this.z) {
            drawableDl = tb.dl(getContext(), "tt_close_btn");
        } else {
            drawableDl = tb.dl(getContext(), "tt_skip_btn");
            if (drawableDl != null) {
                drawableDl.setAutoMirrored(true);
            }
        }
        if (drawableDl != null) {
            ((ImageView) this.pf).setImageDrawable(drawableDl);
        }
        setVisibility(8);
        return true;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dl
    public void z(CharSequence charSequence, boolean z, int i, boolean z2) {
        int i2 = 0;
        if (!z && !z2) {
            i2 = 8;
        }
        setVisibility(i2);
    }
}
