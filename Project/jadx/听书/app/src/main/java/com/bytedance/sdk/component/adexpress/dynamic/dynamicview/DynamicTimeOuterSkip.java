package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.content.Context;
import android.text.TextUtils;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.sdk.component.adexpress.dynamic.dl.gz;
import com.bytedance.sdk.component.utils.tb;

/* JADX INFO: loaded from: classes3.dex */
public class DynamicTimeOuterSkip extends DynamicButton implements com.bytedance.sdk.component.adexpress.dynamic.dl {
    private boolean z;

    public DynamicTimeOuterSkip(Context context, DynamicRootView dynamicRootView, gz gzVar) {
        super(context, dynamicRootView, gzVar);
        dynamicRootView.setTimeOutListener(this);
        if (dynamicRootView.getRenderRequest() != null) {
            this.z = dynamicRootView.getRenderRequest().ls();
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicButton, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidgetImp, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.a
    public boolean gz() {
        super.gz();
        if (!TextUtils.equals(this.i.uy().getType(), "skip-with-time-skip-btn")) {
            return true;
        }
        ((TextView) this.pf).setText("");
        return true;
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
        if (TextUtils.equals("skip-with-time-skip-btn", this.i.uy().getType())) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.e, this.gz);
            layoutParams.gravity = 8388629;
            setLayoutParams(layoutParams);
            this.pf.setTextAlignment(1);
            ((TextView) this.pf).setGravity(17);
        } else {
            super.gc();
        }
        if (!"skip-with-time-skip-btn".equals(this.i.uy().getType())) {
            this.pf.setTextAlignment(1);
            ((TextView) this.pf).setGravity(17);
        }
        setVisibility(8);
    }

    private String z(boolean z) {
        String strZ = tb.z(com.bytedance.sdk.component.adexpress.a.getContext(), "tt_reward_screen_skip_tx");
        if (!"skip-with-time-skip-btn".equals(this.i.uy().getType())) {
            return strZ;
        }
        if (com.bytedance.sdk.component.adexpress.a.z() && this.z) {
            strZ = "X";
        }
        return z ? strZ : "| ".concat(String.valueOf(strZ));
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dl
    public void z(CharSequence charSequence, boolean z, int i, boolean z2) {
        int i2 = 0;
        if (z) {
            ((TextView) this.pf).setText(z(z2));
        } else {
            if (z2) {
                ((TextView) this.pf).setText(z(z2));
            }
            if (!z2) {
                i2 = 8;
            }
        }
        setVisibility(i2);
    }
}
