package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.bytedance.sdk.component.adexpress.a.fo;
import com.bytedance.sdk.component.adexpress.dynamic.dl.gz;
import com.bytedance.sdk.component.utils.tb;

/* JADX INFO: loaded from: classes2.dex */
public class DynamicMutedView extends DynamicBaseWidgetImp implements com.bytedance.sdk.component.adexpress.dynamic.g {
    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget
    public boolean a() {
        return true;
    }

    public DynamicMutedView(Context context, DynamicRootView dynamicRootView, gz gzVar) {
        super(context, dynamicRootView, gzVar);
        this.pf = new ImageView(context);
        this.pf.setTag(5);
        addView(this.pf, getWidgetLayoutParams());
        dynamicRootView.setMuteListener(this);
        if (dynamicRootView.getRenderRequest() == null || dynamicRootView.getRenderRequest().l()) {
            return;
        }
        this.pf.setVisibility(8);
        setVisibility(8);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidgetImp, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.a
    public boolean gz() {
        super.gz();
        if (com.bytedance.sdk.component.adexpress.a.z()) {
            ((ImageView) this.pf).setScaleType(ImageView.ScaleType.FIT_CENTER);
        } else {
            ((ImageView) this.pf).setScaleType(ImageView.ScaleType.CENTER);
        }
        setSoundMute(this.v.g);
        if (com.bytedance.sdk.component.adexpress.a.z()) {
            Drawable drawableZ = com.bytedance.sdk.component.adexpress.a.a.z(getContext(), this.wp);
            if (drawableZ == null) {
                return true;
            }
            ((ImageView) this.pf).setBackground(drawableZ);
            return true;
        }
        ((ImageView) this.pf).setBackgroundDrawable(fo.z(0, Integer.valueOf(this.wp.l()), new int[]{this.gz / 2}, null, null, null));
        return true;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.g
    public void setSoundMute(boolean z) {
        int iGc;
        if (com.bytedance.sdk.component.adexpress.a.z()) {
            if (z) {
                iGc = tb.gc(getContext(), "tt_reward_full_mute");
            } else {
                iGc = tb.gc(getContext(), "tt_reward_full_unmute");
            }
        } else if (z) {
            iGc = tb.gc(getContext(), "tt_mute");
        } else {
            iGc = tb.gc(getContext(), "tt_unmute");
        }
        ((ImageView) this.pf).setImageResource(iGc);
        if (((ImageView) this.pf).getDrawable() != null) {
            ((ImageView) this.pf).getDrawable().setAutoMirrored(true);
        }
    }
}
