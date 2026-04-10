package com.bytedance.sdk.openadsdk.core.component.reward.business.insertad;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.bytedance.sdk.component.utils.tb;
import com.bytedance.sdk.openadsdk.core.un.oq;

/* JADX INFO: loaded from: classes2.dex */
public class SmallSlideView extends RelativeLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ObjectAnimator f933a;
    private ObjectAnimator dl;
    private final g g;
    private final View z;

    public SmallSlideView(Context context) {
        super(context);
        View zVar = new z(context);
        this.z = zVar;
        g gVar = new g(context);
        this.g = gVar;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(oq.dl(context, 10.0f), 0);
        layoutParams.setMargins(0, oq.dl(context, 8.0f), 0, oq.dl(context, 8.0f));
        layoutParams.addRule(14);
        layoutParams.addRule(12);
        addView(gVar, layoutParams);
        addView(zVar);
        setLayoutParams(new LinearLayout.LayoutParams(oq.dl(context, 80.0f), oq.dl(context, 80.0f)));
    }

    public void z() {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.z, "translationY", oq.dl(getContext(), 30.0f), oq.dl(getContext(), -20.0f));
        this.dl = objectAnimatorOfFloat;
        objectAnimatorOfFloat.setDuration(800L);
        this.dl.setRepeatCount(1);
        this.dl.setRepeatMode(1);
        this.dl.start();
        ObjectAnimator objectAnimatorOfInt = ObjectAnimator.ofInt(this.g, "newHeight", oq.dl(getContext(), 0.0f), oq.dl(getContext(), 48.0f));
        this.f933a = objectAnimatorOfInt;
        objectAnimatorOfInt.setDuration(800L);
        this.f933a.setRepeatCount(1);
        this.f933a.setRepeatMode(1);
        this.f933a.start();
    }

    public void g() {
        ObjectAnimator objectAnimator = this.dl;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
        ObjectAnimator objectAnimator2 = this.f933a;
        if (objectAnimator2 != null) {
            objectAnimator2.cancel();
        }
    }

    private static class z extends FrameLayout {
        public z(Context context) {
            super(context);
            ImageView imageView = new ImageView(context);
            tb.z(context, "tt_splash_slide_up_finger", imageView);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.leftMargin = oq.dl(context, 38.0f);
            layoutParams.bottomMargin = oq.dl(context, 10.0f);
            ImageView imageView2 = new ImageView(context);
            tb.z(context, "tt_splash_slide_up_circle", imageView2);
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -1);
            int iDl = oq.dl(context, 30.0f);
            layoutParams2.setMargins(iDl, iDl, iDl, iDl);
            addView(imageView2, layoutParams2);
            addView(imageView, layoutParams);
        }
    }

    private static class g extends FrameLayout {
        public g(Context context) {
            super(context);
            ImageView imageView = new ImageView(context);
            tb.z(context, "tt_splash_slide_up_bg", (View) imageView);
            addView(imageView);
        }
    }
}
