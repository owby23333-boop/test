package com.bytedance.sdk.component.adexpress.widget;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.sdk.component.utils.dt;

/* JADX INFO: loaded from: classes.dex */
public class ClickSlideUpView2 extends SlideUpView {
    private ImageView bf;
    private ImageView d;
    private TextView e;
    private int ga;
    private ImageView tg;
    private AnimatorSet vn;

    public ClickSlideUpView2(Context context) {
        super(context);
        this.vn = new AnimatorSet();
        bf(context);
    }

    private void bf(Context context) {
        View.inflate(context, dt.vn(context, "tt_dynamic_click_slideup2"), this);
        this.bf = (ImageView) findViewById(dt.ga(context, "tt_iv_up1"));
        this.d = (ImageView) findViewById(dt.ga(context, "tt_iv_up2"));
        this.tg = (ImageView) findViewById(dt.ga(context, "tt_iv_up3"));
        this.e = (TextView) findViewById(dt.ga(context, "tt_tv_but_text"));
    }

    private void tg() {
        ObjectAnimator objectAnimatorOfInt = ObjectAnimator.ofInt(this, "alphaColor", 0, 60);
        objectAnimatorOfInt.setInterpolator(new LinearInterpolator());
        objectAnimatorOfInt.setDuration(2000L);
        objectAnimatorOfInt.setRepeatCount(-1);
        objectAnimatorOfInt.start();
    }

    @Override // com.bytedance.sdk.component.adexpress.widget.SlideUpView
    public void e(Context context) {
    }

    public float getAlphaColor() {
        return this.ga;
    }

    public void setAlphaColor(int i) {
        if (i < 0 || i > 60) {
            return;
        }
        int i2 = i + 195;
        this.tg.setColorFilter(Color.rgb(i2, i2, i2), PorterDuff.Mode.SRC_IN);
        int i3 = ((i + 20) % 60) + 195;
        this.d.setColorFilter(Color.rgb(i3, i3, i3), PorterDuff.Mode.SRC_IN);
        int i4 = ((i + 40) % 60) + 195;
        this.bf.setColorFilter(Color.rgb(i4, i4, i4), PorterDuff.Mode.SRC_IN);
    }

    public void setButtonText(String str) {
        if (this.e == null || TextUtils.isEmpty(str)) {
            return;
        }
        this.e.setText(str);
    }

    @Override // com.bytedance.sdk.component.adexpress.widget.SlideUpView
    public void e() {
        tg();
    }

    @Override // com.bytedance.sdk.component.adexpress.widget.SlideUpView
    public void bf() {
        this.vn.cancel();
    }
}
