package com.yuewen;

import android.graphics.RectF;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.Transformation;

/* JADX INFO: loaded from: classes5.dex */
public class cd4 {

    public static class a extends AnimationSet {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Transformation f9604a;

        public a(Animation animation) {
            super(false);
            this.f9604a = new Transformation();
            addAnimation(animation);
            setFillAfter(true);
            setFillEnabled(true);
            setDuration(animation.getDuration());
        }

        public Transformation a() {
            return this.f9604a;
        }

        @Override // android.view.animation.AnimationSet, android.view.animation.Animation
        public boolean getTransformation(long j, Transformation transformation) {
            boolean transformation2 = super.getTransformation(j, transformation);
            this.f9604a = transformation;
            return transformation2;
        }
    }

    public static Transformation a(View view) {
        if (view.getAnimation() != null && (view.getAnimation() instanceof a)) {
            return ((a) view.getAnimation()).a();
        }
        return new Transformation();
    }

    public static RectF b(View view) {
        RectF rectF = new RectF(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        a(view).getMatrix().mapRect(rectF);
        return rectF;
    }

    public static void c(View view, Animation animation) {
        view.startAnimation(new a(animation));
        if (view.getAnimation() != null) {
            view.getAnimation().cancel();
        }
        if (animation.getDuration() == 0) {
            view.getAnimation().getTransformation(AnimationUtils.currentAnimationTimeMillis(), new Transformation());
        }
    }

    public static void d(View view) {
        view.clearAnimation();
    }
}
