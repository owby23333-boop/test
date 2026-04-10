package com.bytedance.sdk.component.adexpress.widget;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Color;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.sdk.component.adexpress.a.fo;
import com.bytedance.sdk.component.adexpress.a.gz;
import com.bytedance.sdk.component.utils.h;

/* JADX INFO: loaded from: classes2.dex */
public class CircleLongPressView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private TextView f591a;
    private ImageView dl;
    private ImageView g;
    private RingProgressView gc;
    private AnimatorSet m;
    private Context z;

    public CircleLongPressView(Context context) {
        super(context);
        this.m = new AnimatorSet();
        this.z = context;
        gc();
        m();
    }

    private void gc() {
        FrameLayout frameLayout = new FrameLayout(this.z);
        this.gc = new RingProgressView(this.z);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) gz.z(this.z, 95.0f), (int) gz.z(this.z, 95.0f));
        layoutParams.gravity = 17;
        frameLayout.addView(this.gc, layoutParams);
        this.g = new ImageView(this.z);
        int iZ = h.z(this.z, 60.0f);
        this.g.setImageDrawable(fo.z(1, null, null, new int[]{iZ, iZ}, Integer.valueOf(h.z(this.z, 1.0f)), Integer.valueOf(Color.parseColor("#80FFFFFF"))));
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams((int) gz.z(this.z, 75.0f), (int) gz.z(this.z, 75.0f));
        layoutParams2.gravity = 17;
        frameLayout.addView(this.g, layoutParams2);
        this.dl = new ImageView(this.z);
        int iZ2 = h.z(this.z, 50.0f);
        this.dl.setImageDrawable(fo.z(1, Integer.valueOf(Color.parseColor("#80FFFFFF")), null, new int[]{iZ2, iZ2}, null, null));
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams((int) gz.z(this.z, 63.0f), (int) gz.z(this.z, 63.0f));
        layoutParams3.gravity = 17;
        frameLayout.addView(this.dl, layoutParams3);
        addView(frameLayout);
        TextView textView = new TextView(this.z);
        this.f591a = textView;
        textView.setTextColor(-1);
        this.f591a.setMaxLines(1);
        FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams4.gravity = 81;
        addView(this.f591a, layoutParams4);
    }

    private void m() {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.dl, "scaleX", 1.0f, 0.9f);
        objectAnimatorOfFloat.setRepeatCount(-1);
        objectAnimatorOfFloat.setInterpolator(new AccelerateDecelerateInterpolator());
        objectAnimatorOfFloat.setRepeatMode(2);
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.dl, "scaleY", 1.0f, 0.9f);
        objectAnimatorOfFloat2.setRepeatCount(-1);
        objectAnimatorOfFloat2.setRepeatMode(2);
        objectAnimatorOfFloat2.setInterpolator(new AccelerateDecelerateInterpolator());
        this.m.setDuration(800L);
        this.m.playTogether(objectAnimatorOfFloat, objectAnimatorOfFloat2);
    }

    public void setGuideText(String str) {
        this.f591a.setText(str);
    }

    public void z() {
        this.m.start();
    }

    public void g() {
        this.m.cancel();
    }

    public void dl() {
        this.gc.z();
    }

    public void a() {
        this.gc.g();
        this.gc.dl();
    }
}
