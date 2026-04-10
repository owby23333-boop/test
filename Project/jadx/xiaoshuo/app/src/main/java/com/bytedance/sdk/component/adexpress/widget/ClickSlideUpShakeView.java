package com.bytedance.sdk.component.adexpress.widget;

import android.content.Context;
import android.text.TextUtils;
import android.widget.RelativeLayout;
import com.bytedance.sdk.component.utils.dt;

/* JADX INFO: loaded from: classes.dex */
public class ClickSlideUpShakeView extends SlideUpView {
    private ShakeClickView e;

    public ClickSlideUpShakeView(Context context, int i, int i2, int i3) {
        super(context);
        e(context, i, i2, i3);
    }

    private void e(Context context, int i, int i2, int i3) {
        ShakeClickView shakeClickView = new ShakeClickView(context, dt.vn(context, "tt_dynamic_hand_shake"), i, i2, i3);
        this.e = shakeClickView;
        addView(shakeClickView);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(14);
        layoutParams.addRule(12);
        this.e.setLayoutParams(layoutParams);
    }

    public ShakeClickView getShakeView() {
        return this.e;
    }

    public void setShakeText(String str) {
        if (this.e == null) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            this.e.setShakeText("");
        } else {
            this.e.setShakeText(str);
        }
    }
}
