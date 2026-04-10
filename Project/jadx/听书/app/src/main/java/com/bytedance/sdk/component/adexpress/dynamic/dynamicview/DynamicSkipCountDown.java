package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.content.Context;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.sdk.component.adexpress.dynamic.dl.gz;
import com.bytedance.sdk.component.utils.tb;

/* JADX INFO: loaded from: classes3.dex */
public class DynamicSkipCountDown extends DynamicButton implements com.bytedance.sdk.component.adexpress.dynamic.dl {
    public DynamicSkipCountDown(Context context, DynamicRootView dynamicRootView, gz gzVar) {
        super(context, dynamicRootView, gzVar);
        dynamicRootView.setTimeOutListener(this);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicButton, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidgetImp
    protected FrameLayout.LayoutParams getWidgetLayoutParams() {
        return new FrameLayout.LayoutParams(-2, -2);
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (TextUtils.isEmpty(((TextView) this.pf).getText())) {
            setMeasuredDimension(0, this.gz);
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget
    public void gc() {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.e, this.gz);
        layoutParams.leftMargin = this.fo;
        layoutParams.gravity = 16;
        layoutParams.setMarginStart(layoutParams.leftMargin);
        layoutParams.setMarginEnd(layoutParams.rightMargin);
        setLayoutParams(layoutParams);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dl
    public void z(CharSequence charSequence, boolean z, int i, boolean z2) {
        if (i == 0) {
            if (getParent() != null) {
                ((ViewGroup) getParent()).removeView(this);
            }
        } else {
            ((TextView) this.pf).setText(" | " + String.format(tb.z(com.bytedance.sdk.component.adexpress.a.getContext(), "tt_reward_full_skip_count_down"), Integer.valueOf(i)));
        }
        requestLayout();
    }
}
