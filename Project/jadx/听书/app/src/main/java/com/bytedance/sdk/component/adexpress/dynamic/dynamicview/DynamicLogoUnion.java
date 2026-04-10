package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.content.Context;
import android.graphics.PorterDuff;
import android.widget.ImageView;
import com.bytedance.sdk.component.adexpress.dynamic.dl.gz;
import com.bytedance.sdk.component.utils.tb;

/* JADX INFO: loaded from: classes2.dex */
public class DynamicLogoUnion extends DynamicBaseWidgetImp {
    public DynamicLogoUnion(Context context, DynamicRootView dynamicRootView, gz gzVar) {
        super(context, dynamicRootView, gzVar);
        this.pf = new ImageView(context);
        this.pf.setTag(Integer.valueOf(getClickArea()));
        if (com.bytedance.sdk.component.adexpress.a.z()) {
            this.gz = Math.max(dynamicRootView.getLogoUnionHeight(), this.gz);
        }
        addView(this.pf, getWidgetLayoutParams());
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidgetImp, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.a
    public boolean gz() {
        super.gz();
        if (com.bytedance.sdk.component.adexpress.a.z()) {
            ((ImageView) this.pf).setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        }
        ((ImageView) this.pf).setImageResource(tb.gc(getContext(), "tt_ad_logo"));
        ((ImageView) this.pf).setColorFilter(this.wp.e(), PorterDuff.Mode.SRC_IN);
        return true;
    }
}
