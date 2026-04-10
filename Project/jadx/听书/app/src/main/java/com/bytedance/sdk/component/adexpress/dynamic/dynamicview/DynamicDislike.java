package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.bytedance.sdk.component.adexpress.dynamic.dl.gz;
import com.bytedance.sdk.component.adexpress.widget.DislikeView;
import com.bytedance.sdk.component.utils.tb;

/* JADX INFO: loaded from: classes2.dex */
public class DynamicDislike extends DynamicBaseWidgetImp {
    public DynamicDislike(Context context, DynamicRootView dynamicRootView, gz gzVar) {
        super(context, dynamicRootView, gzVar);
        if (com.bytedance.sdk.component.adexpress.a.z()) {
            this.pf = new ImageView(context);
        } else {
            this.pf = new DislikeView(context);
        }
        this.pf.setTag(3);
        addView(this.pf, getWidgetLayoutParams());
        dynamicRootView.setDislikeView(this.pf);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidgetImp, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.a
    public boolean gz() {
        super.gz();
        if (com.bytedance.sdk.component.adexpress.a.z()) {
            Drawable drawableZ = com.bytedance.sdk.component.adexpress.a.a.z(getContext(), this.wp);
            if (drawableZ != null) {
                this.pf.setBackground(drawableZ);
            }
            int iGc = tb.gc(getContext(), "tt_close_btn");
            if (iGc > 0) {
                ((ImageView) this.pf).setImageResource(iGc);
            }
            ((ImageView) this.pf).setScaleType(ImageView.ScaleType.FIT_XY);
            return true;
        }
        int iZ = (int) com.bytedance.sdk.component.adexpress.a.gz.z(this.kb, this.wp.p());
        if (this.pf instanceof DislikeView) {
            ((DislikeView) this.pf).setRadius((int) com.bytedance.sdk.component.adexpress.a.gz.z(this.kb, this.wp.pf()));
            ((DislikeView) this.pf).setStrokeWidth(iZ);
            ((DislikeView) this.pf).setStrokeColor(this.wp.ls());
            ((DislikeView) this.pf).setBgColor(this.wp.l());
            ((DislikeView) this.pf).setDislikeColor(this.wp.e());
            ((DislikeView) this.pf).setDislikeWidth((int) com.bytedance.sdk.component.adexpress.a.gz.z(this.kb, 1.0f));
        }
        return true;
    }
}
