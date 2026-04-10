package com.bytedance.sdk.component.adexpress.widget;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.bytedance.sdk.component.adexpress.dynamic.dl.uy;
import com.bytedance.sdk.component.utils.tb;
import com.bytedance.sdk.component.utils.wp;

/* JADX INFO: loaded from: classes2.dex */
public class ShakeClickView extends ShakeAnimationView {
    private TextView g;

    public ShakeClickView(Context context, View view, uy uyVar, boolean z, int i) {
        super(context, view, uyVar, z, i);
    }

    @Override // com.bytedance.sdk.component.adexpress.widget.ShakeAnimationView
    protected void z(Context context, View view) {
        addView(view);
        this.g = (TextView) findViewById(2097610747);
    }

    @Override // com.bytedance.sdk.component.adexpress.widget.ShakeAnimationView
    public void setShakeText(String str) {
        if (this.g == null) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            try {
                this.g.setText(tb.g(this.g.getContext(), "tt_splash_default_click_shake"));
                return;
            } catch (Exception e) {
                wp.a("shakeClickView", e.getMessage());
                return;
            }
        }
        this.g.setText(str);
    }
}
