package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.sdk.component.adexpress.dynamic.dl.gz;
import com.bytedance.sdk.component.utils.tb;

/* JADX INFO: loaded from: classes3.dex */
public class DynamicSkipCountDownBtn extends DynamicButton implements com.bytedance.sdk.component.adexpress.dynamic.dl {
    private int g;
    private int tb;
    private int[] z;

    public DynamicSkipCountDownBtn(Context context, DynamicRootView dynamicRootView, gz gzVar) {
        super(context, dynamicRootView, gzVar);
        dynamicRootView.setTimeOutListener(this);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicButton, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidgetImp, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.a
    public boolean gz() {
        super.gz();
        ((TextView) this.pf).setText("");
        return true;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget
    public void gc() {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.e, this.gz);
        layoutParams.gravity = 8388629;
        layoutParams.setMarginStart(layoutParams.leftMargin);
        layoutParams.setMarginEnd(layoutParams.rightMargin);
        setLayoutParams(layoutParams);
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (TextUtils.isEmpty(((TextView) this.pf).getText())) {
            setMeasuredDimension(0, this.gz);
        } else {
            setMeasuredDimension(this.e, this.gz);
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dl
    public void z(CharSequence charSequence, boolean z, int i, boolean z2) {
        String strZ = tb.z(com.bytedance.sdk.component.adexpress.a.getContext(), "tt_reward_screen_skip_tx");
        if (i == 0) {
            this.pf.setVisibility(0);
            ((TextView) this.pf).setText("| ".concat(String.valueOf(strZ)));
            this.pf.measure(-2, -2);
            this.z = new int[]{this.pf.getMeasuredWidth() + 1, this.pf.getMeasuredHeight()};
            View view = this.pf;
            int[] iArr = this.z;
            view.setLayoutParams(new FrameLayout.LayoutParams(iArr[0], iArr[1]));
            ((TextView) this.pf).setGravity(17);
            ((TextView) this.pf).setIncludeFontPadding(false);
            fo();
            this.pf.setPadding(this.wp.dl(), this.g, this.wp.a(), this.tb);
        }
        requestLayout();
    }

    private void fo() {
        int iZ = (int) com.bytedance.sdk.component.adexpress.a.gz.z(this.kb, this.wp.gc());
        this.g = ((this.gz - iZ) / 2) - this.wp.z();
        this.tb = 0;
    }
}
