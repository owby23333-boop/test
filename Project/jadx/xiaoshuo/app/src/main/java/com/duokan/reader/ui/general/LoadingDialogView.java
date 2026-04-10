package com.duokan.reader.ui.general;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.yuewen.e84;
import com.yuewen.rt2;

/* JADX INFO: loaded from: classes5.dex */
public class LoadingDialogView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f5484a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ImageView f5485b;
    public Animation c;

    public LoadingDialogView(Context context) {
        this(context, null);
    }

    public void a() {
        this.f5485b.clearAnimation();
        b();
    }

    public final void b() {
        if (this.f5485b != null) {
            if (this.c == null) {
                RotateAnimation rotateAnimation = new RotateAnimation(0.0f, 360.0f, 1, 0.5f, 1, 0.5f);
                this.c = rotateAnimation;
                rotateAnimation.setFillAfter(true);
                this.c.setDuration(500L);
                this.c.setRepeatCount(Integer.MAX_VALUE);
                this.c.setInterpolator(new LinearInterpolator());
            }
            if (this.f5484a.getVisibility() == 0 && e84.T(this.f5484a) == 0) {
                this.f5485b.setAnimation(this.c);
            } else {
                this.f5485b.clearAnimation();
                this.c = null;
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ImageView imageView = this.f5485b;
        if (imageView == null || !(imageView.getDrawable() instanceof AnimationDrawable)) {
            return;
        }
        ((AnimationDrawable) this.f5485b.getDrawable()).stop();
    }

    @Override // android.view.View
    public void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        b();
    }

    public LoadingDialogView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.c = null;
        View viewInflate = LayoutInflater.from(getContext()).inflate(rt2.n.M0, (ViewGroup) this, false);
        this.f5484a = viewInflate;
        viewInflate.setVisibility(4);
        addView(viewInflate);
        this.f5485b = (ImageView) viewInflate.findViewById(rt2.k.d4);
        a();
    }
}
