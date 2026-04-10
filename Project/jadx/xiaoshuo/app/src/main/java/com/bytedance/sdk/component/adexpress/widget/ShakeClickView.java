package com.bytedance.sdk.component.adexpress.widget;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.bytedance.sdk.component.utils.dt;
import com.bytedance.sdk.component.utils.wu;

/* JADX INFO: loaded from: classes.dex */
public class ShakeClickView extends ShakeAnimationView {
    private TextView e;

    public ShakeClickView(Context context, int i, int i2, int i3, int i4) {
        super(context, i, i2, i3, i4);
    }

    @Override // com.bytedance.sdk.component.adexpress.widget.ShakeAnimationView
    public void e(Context context, int i) {
        View.inflate(context, i, this);
        this.e = (TextView) findViewById(dt.ga(context, "tt_tv_shake_text"));
    }

    @Override // com.bytedance.sdk.component.adexpress.widget.ShakeAnimationView
    public void setShakeText(String str) {
        if (this.e == null) {
            return;
        }
        if (!TextUtils.isEmpty(str)) {
            this.e.setText(str);
            return;
        }
        try {
            this.e.setText(dt.bf(this.e.getContext(), "tt_splash_default_click_shake"));
        } catch (Exception e) {
            wu.vn("shakeClickView", e.getMessage());
        }
    }
}
