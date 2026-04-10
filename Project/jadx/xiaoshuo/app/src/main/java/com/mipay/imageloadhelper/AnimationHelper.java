package com.mipay.imageloadhelper;

import android.graphics.Bitmap;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;

/* JADX INFO: loaded from: classes17.dex */
public class AnimationHelper {
    public static void crossFade(ImageView imageView, Bitmap bitmap) {
        crossFade(imageView, bitmap, 500L);
    }

    public static void crossFade(final ImageView imageView, Bitmap bitmap, long j) {
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setInterpolator(new AccelerateDecelerateInterpolator());
        alphaAnimation.setDuration(j);
        alphaAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.mipay.imageloadhelper.AnimationHelper.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                imageView.setVisibility(0);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }
        });
        imageView.setImageBitmap(bitmap);
        imageView.startAnimation(alphaAnimation);
    }
}
