package com.bytedance.sdk.component.adexpress.widget;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.CycleInterpolator;
import android.widget.TextView;
import com.bytedance.sdk.component.adexpress.d.bf;
import com.bytedance.sdk.component.utils.dt;

/* JADX INFO: loaded from: classes.dex */
public class ClickSlideUpView extends SlideUpView {
    private View bf;
    private AnimatorSet d;
    private TextView e;

    public ClickSlideUpView(Context context) {
        super(context);
        this.d = new AnimatorSet();
        bf(context);
    }

    private void bf(Context context) {
        this.bf = View.inflate(context, dt.vn(context, "tt_dynamic_click_slideup"), this);
        this.e = (TextView) findViewById(dt.ga(context, "tt_tv_but_text"));
    }

    private void tg() {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.bf, "translationY", 0.0f, bf.e(getContext(), -3.0f));
        objectAnimatorOfFloat.setInterpolator(new CycleInterpolator(1.0f));
        objectAnimatorOfFloat.setDuration(1000L);
        objectAnimatorOfFloat.setRepeatCount(-1);
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.bf, "alpha", 1.0f, 0.8f);
        objectAnimatorOfFloat2.setDuration(1000L);
        objectAnimatorOfFloat2.setInterpolator(new CycleInterpolator(1.0f));
        objectAnimatorOfFloat2.setRepeatCount(-1);
        this.d.playTogether(objectAnimatorOfFloat, objectAnimatorOfFloat2);
        this.d.setDuration(1000L);
        this.d.start();
    }

    @Override // com.bytedance.sdk.component.adexpress.widget.SlideUpView
    public void e(Context context) {
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
        this.d.cancel();
    }
}
