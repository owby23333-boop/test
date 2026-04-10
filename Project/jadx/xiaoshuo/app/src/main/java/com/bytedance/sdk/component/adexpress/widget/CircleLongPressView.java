package com.bytedance.sdk.component.adexpress.widget;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.sdk.component.adexpress.d.bf;
import com.bytedance.sdk.component.utils.dt;

/* JADX INFO: loaded from: classes.dex */
public class CircleLongPressView extends FrameLayout {
    private ImageView bf;
    private ImageView d;
    private Context e;
    private RingProgressView ga;
    private TextView tg;
    private AnimatorSet vn;

    public CircleLongPressView(Context context) {
        super(context);
        this.vn = new AnimatorSet();
        this.e = context;
        ga();
        vn();
    }

    private void ga() {
        FrameLayout frameLayout = new FrameLayout(this.e);
        this.ga = new RingProgressView(this.e);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) bf.e(this.e, 95.0f), (int) bf.e(this.e, 95.0f));
        layoutParams.gravity = 17;
        frameLayout.addView(this.ga, layoutParams);
        ImageView imageView = new ImageView(this.e);
        this.bf = imageView;
        imageView.setImageResource(dt.tg(this.e, "tt_interact_circle"));
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams((int) bf.e(this.e, 75.0f), (int) bf.e(this.e, 75.0f));
        layoutParams2.gravity = 17;
        frameLayout.addView(this.bf, layoutParams2);
        ImageView imageView2 = new ImageView(this.e);
        this.d = imageView2;
        imageView2.setImageResource(dt.tg(this.e, "tt_interact_oval"));
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams((int) bf.e(this.e, 63.0f), (int) bf.e(this.e, 63.0f));
        layoutParams3.gravity = 17;
        frameLayout.addView(this.d, layoutParams3);
        addView(frameLayout);
        TextView textView = new TextView(this.e);
        this.tg = textView;
        textView.setTextColor(-1);
        this.tg.setMaxLines(1);
        FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams4.gravity = 81;
        addView(this.tg, layoutParams4);
    }

    private void vn() {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.d, "scaleX", 1.0f, 0.9f);
        objectAnimatorOfFloat.setRepeatCount(-1);
        objectAnimatorOfFloat.setInterpolator(new AccelerateDecelerateInterpolator());
        objectAnimatorOfFloat.setRepeatMode(2);
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.d, "scaleY", 1.0f, 0.9f);
        objectAnimatorOfFloat2.setRepeatCount(-1);
        objectAnimatorOfFloat2.setRepeatMode(2);
        objectAnimatorOfFloat2.setInterpolator(new AccelerateDecelerateInterpolator());
        this.vn.setDuration(800L);
        this.vn.playTogether(objectAnimatorOfFloat, objectAnimatorOfFloat2);
    }

    public void bf() {
        this.vn.cancel();
    }

    public void d() {
        this.ga.e();
    }

    public void e() {
        this.vn.start();
    }

    public void setGuideText(String str) {
        this.tg.setText(str);
    }

    public void tg() {
        this.ga.bf();
        this.ga.d();
    }
}
