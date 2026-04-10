package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.sdk.component.adexpress.dynamic.dl.gz;
import com.bytedance.sdk.component.utils.tb;

/* JADX INFO: loaded from: classes2.dex */
public class DynamicDislikeFeedBack extends DynamicBaseWidgetImp {
    public DynamicDislikeFeedBack(Context context, DynamicRootView dynamicRootView, gz gzVar) {
        super(context, dynamicRootView, gzVar);
        if (com.bytedance.sdk.component.adexpress.a.z()) {
            this.pf = new ImageView(context);
            ((ImageView) this.pf).setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.e = this.gz;
        } else {
            this.pf = new TextView(context);
        }
        this.pf.setTag(3);
        addView(this.pf, getWidgetLayoutParams());
        dynamicRootView.setDislikeView(this.pf);
        if (dynamicRootView.getRenderRequest() != null) {
            if (dynamicRootView.getRenderRequest().kb() && dynamicRootView.getRenderRequest().l()) {
                return;
            }
            this.pf.setVisibility(8);
            setVisibility(8);
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidgetImp, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.a
    public boolean gz() {
        super.gz();
        if (com.bytedance.sdk.component.adexpress.a.z()) {
            Drawable drawableZ = com.bytedance.sdk.component.adexpress.a.a.z(getContext(), this.wp);
            if (drawableZ != null) {
                ((ImageView) this.pf).setBackground(drawableZ);
            }
            ((ImageView) this.pf).setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            int iGc = tb.gc(getContext(), "tt_reward_full_feedback");
            if (iGc > 0) {
                ((ImageView) this.pf).setImageResource(iGc);
            }
            return true;
        }
        ((TextView) this.pf).setText(getText());
        this.pf.setTextAlignment(this.wp.gz());
        ((TextView) this.pf).setTextColor(this.wp.e());
        ((TextView) this.pf).setTextSize(this.wp.gc());
        this.pf.setBackground(getBackgroundDrawable());
        if (!this.wp.iq()) {
            ((TextView) this.pf).setMaxLines(1);
            ((TextView) this.pf).setGravity(17);
            ((TextView) this.pf).setEllipsize(TextUtils.TruncateAt.END);
        } else {
            int iZw = this.wp.zw();
            if (iZw > 0) {
                ((TextView) this.pf).setLines(iZw);
                ((TextView) this.pf).setEllipsize(TextUtils.TruncateAt.END);
            }
        }
        this.pf.setPadding((int) com.bytedance.sdk.component.adexpress.a.gz.z(com.bytedance.sdk.component.adexpress.a.getContext(), this.wp.dl()), (int) com.bytedance.sdk.component.adexpress.a.gz.z(com.bytedance.sdk.component.adexpress.a.getContext(), this.wp.g()), (int) com.bytedance.sdk.component.adexpress.a.gz.z(com.bytedance.sdk.component.adexpress.a.getContext(), this.wp.a()), (int) com.bytedance.sdk.component.adexpress.a.gz.z(com.bytedance.sdk.component.adexpress.a.getContext(), this.wp.z()));
        ((TextView) this.pf).setGravity(17);
        return true;
    }

    public String getText() {
        return tb.z(com.bytedance.sdk.component.adexpress.a.getContext(), "tt_reward_feedback");
    }
}
