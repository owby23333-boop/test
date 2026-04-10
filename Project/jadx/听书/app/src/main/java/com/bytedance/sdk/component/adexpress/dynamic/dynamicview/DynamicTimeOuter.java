package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.content.Context;
import android.text.TextUtils;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.sdk.component.adexpress.a.e;
import com.bytedance.sdk.component.adexpress.dynamic.a.kb;
import com.bytedance.sdk.component.adexpress.dynamic.dl.gz;
import com.bytedance.sdk.component.utils.tb;

/* JADX INFO: loaded from: classes3.dex */
public class DynamicTimeOuter extends DynamicButton implements com.bytedance.sdk.component.adexpress.dynamic.dl {
    private boolean g;
    private boolean tb;
    private boolean z;

    public DynamicTimeOuter(Context context, DynamicRootView dynamicRootView, gz gzVar) {
        super(context, dynamicRootView, gzVar);
        dynamicRootView.setTimeOutListener(this);
        if ("timedown".equals(gzVar.uy().getType())) {
            dynamicRootView.setTimedown(this.gz);
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicButton, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidgetImp, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.a
    public boolean gz() {
        super.gz();
        if (e.g(this.v.getRenderRequest().m())) {
            setVisibility(8);
        }
        if ("timedown".equals(this.i.uy().getType())) {
            ((TextView) this.pf).setText(String.valueOf((int) Double.parseDouble(this.wp.uy())));
            return true;
        }
        ((TextView) this.pf).setText(((int) Double.parseDouble(this.wp.uy())) + "s");
        return true;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget
    public void gc() {
        if (TextUtils.equals("skip-with-countdowns-video-countdown", this.i.uy().getType()) || TextUtils.equals("skip-with-time-countdown", this.i.uy().getType())) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.e, this.gz);
            layoutParams.gravity = 8388627;
            if (com.bytedance.sdk.component.adexpress.a.z()) {
                layoutParams.leftMargin = this.fo;
            }
            layoutParams.setMarginStart(layoutParams.leftMargin);
            layoutParams.setMarginEnd(layoutParams.rightMargin);
            setLayoutParams(layoutParams);
            return;
        }
        super.gc();
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (TextUtils.isEmpty(((TextView) this.pf).getText())) {
            setMeasuredDimension(0, this.gz);
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dl
    public void z(CharSequence charSequence, boolean z, int i, boolean z2) {
        if (z2 || this.tb) {
            ((TextView) this.pf).setText("");
            setVisibility(8);
            return;
        }
        try {
            if (Integer.parseInt((String) charSequence) <= 0) {
                setVisibility(8);
                return;
            }
        } catch (Exception unused) {
        }
        setVisibility(0);
        if (!z && this.v.getRenderRequest().dl() && e.g(this.v.getRenderRequest().m())) {
            if (com.bytedance.sdk.component.adexpress.a.z()) {
                ((TextView) this.pf).setText(i + "s");
            } else {
                ((TextView) this.pf).setText(String.format(tb.z(com.bytedance.sdk.component.adexpress.a.getContext(), "tt_reward_full_skip"), Integer.valueOf(i)));
            }
            this.z = true;
            return;
        }
        if (com.bytedance.sdk.component.adexpress.a.z() && !"open_ad".equals(this.v.getRenderRequest().m()) && this.v.getRenderRequest().dl()) {
            this.tb = true;
            setVisibility(8);
            return;
        }
        if ("timedown".equals(this.i.uy().getType())) {
            ((TextView) this.pf).setText(charSequence);
            return;
        }
        ((TextView) this.pf).setText(((Object) charSequence) + "s");
        this.g = true;
        if (this.z) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) (kb.g(((TextView) this.pf).getText() != null ? r5.toString() : "", this.wp.gc(), true)[0] + com.bytedance.sdk.component.adexpress.a.gz.z(com.bytedance.sdk.component.adexpress.a.getContext(), this.wp.dl() + this.wp.a())), this.gz);
            layoutParams.gravity = 8388629;
            this.pf.setLayoutParams(layoutParams);
            this.z = false;
            requestLayout();
        }
    }
}
