package com.bytedance.sdk.component.adexpress.widget;

import android.content.Context;
import android.text.TextUtils;
import android.widget.RelativeLayout;
import com.bytedance.sdk.component.adexpress.dynamic.dl.uy;

/* JADX INFO: loaded from: classes2.dex */
public class ClickSlideUpShakeView extends SlideUpView {
    private ShakeClickView z;

    public ClickSlideUpShakeView(Context context, uy uyVar, boolean z, int i) {
        super(context);
        z(context, uyVar, z, i);
    }

    private void z(Context context, uy uyVar, boolean z, int i) {
        ShakeClickView shakeClickView = new ShakeClickView(context, com.bytedance.sdk.component.adexpress.dl.z.dl(context), uyVar, z, i);
        this.z = shakeClickView;
        addView(shakeClickView);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(14);
        layoutParams.addRule(12);
        this.z.setLayoutParams(layoutParams);
    }

    public ShakeClickView getShakeView() {
        return this.z;
    }

    public void setShakeText(String str) {
        if (this.z == null) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            this.z.setShakeText("");
        } else {
            this.z.setShakeText(str);
        }
    }
}
