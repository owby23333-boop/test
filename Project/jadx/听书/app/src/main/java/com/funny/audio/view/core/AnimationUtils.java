package com.funny.audio.view.core;

import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;

/* JADX INFO: loaded from: classes3.dex */
public class AnimationUtils {
    public static final long DEFAULT_ANIMATION_DURATION = 400;
    static int DefualtAnimationTime = 300;

    public interface AnimationCallback {
        void onAnimationEnd(Animation animation);

        void onAnimationRepeat(Animation animation);

        void onAnimationStart(Animation animation);
    }

    public static void rotate(View view, long duration) {
        if (view == null) {
            return;
        }
        RotateAnimation rotateAnimationByCenter = getRotateAnimationByCenter(duration);
        rotateAnimationByCenter.setRepeatMode(2);
        view.startAnimation(rotateAnimationByCenter);
    }

    public static void shakeSlight(View view) {
        shake(view, 1.0f, 1.0f, 5.0f, 500L);
    }

    public static void shake(View view, float scaleSmall, float scaleLarge, float shakeDegrees, long duration) {
        if (view == null) {
            return;
        }
        ScaleAnimation scaleAnimation = new ScaleAnimation(scaleSmall, scaleLarge, scaleSmall, scaleLarge);
        RotateAnimation rotateAnimation = new RotateAnimation(-shakeDegrees, shakeDegrees, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setDuration(duration);
        rotateAnimation.setDuration(duration / 10);
        rotateAnimation.setRepeatMode(2);
        rotateAnimation.setRepeatCount(10);
        AnimationSet animationSet = new AnimationSet(false);
        animationSet.addAnimation(scaleAnimation);
        animationSet.addAnimation(rotateAnimation);
        view.startAnimation(animationSet);
    }

    public static void showSlideUp(final View view, AnimationCallback callback) {
        if (view.getVisibility() == 0) {
            return;
        }
        view.setVisibility(0);
        int height = view.getHeight();
        view.clearAnimation();
        TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, height, 0.0f);
        translateAnimation.setDuration(DefualtAnimationTime);
        translateAnimation.setFillAfter(true);
        translateAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.funny.audio.view.core.AnimationUtils.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                view.setVisibility(0);
            }
        });
        view.startAnimation(translateAnimation);
    }

    public static void hideSlideDown(final View view, AnimationCallback callback) {
        int visibility = view.getVisibility();
        if (visibility == 8 || visibility == 4) {
            return;
        }
        int height = view.getHeight();
        view.clearAnimation();
        TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, 0.0f, height);
        translateAnimation.setDuration(DefualtAnimationTime);
        translateAnimation.setFillAfter(true);
        translateAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.funny.audio.view.core.AnimationUtils.2
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                view.clearAnimation();
                view.setVisibility(8);
            }
        });
        view.startAnimation(translateAnimation);
    }

    public static void showSlideDown(final View view, final AnimationCallback callback) {
        if (view.getVisibility() == 0) {
            return;
        }
        view.setVisibility(0);
        int height = view.getHeight();
        view.clearAnimation();
        TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, height * (-1), 0.0f);
        translateAnimation.setDuration(DefualtAnimationTime);
        translateAnimation.setFillAfter(true);
        translateAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.funny.audio.view.core.AnimationUtils.3
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                AnimationCallback animationCallback = callback;
                if (animationCallback != null) {
                    animationCallback.onAnimationStart(animation);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                view.setVisibility(0);
                AnimationCallback animationCallback = callback;
                if (animationCallback != null) {
                    animationCallback.onAnimationEnd(animation);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
                AnimationCallback animationCallback = callback;
                if (animationCallback != null) {
                    animationCallback.onAnimationRepeat(animation);
                }
            }
        });
        view.startAnimation(translateAnimation);
    }

    public static void fadeOut(View view, Long delayTime) {
        if (view.getVisibility() != 0) {
            return;
        }
        view.setEnabled(false);
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setDuration(delayTime.longValue());
        view.startAnimation(alphaAnimation);
        view.setVisibility(4);
    }

    public static void fadeIn(View view, Long delayTime) {
        if (view.getVisibility() == 0) {
            return;
        }
        view.setEnabled(false);
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(delayTime.longValue());
        view.startAnimation(alphaAnimation);
        view.setVisibility(0);
    }

    public static void hideSlideUp(final View view, final AnimationCallback callback) {
        int visibility = view.getVisibility();
        if (visibility == 8 || visibility == 4) {
            return;
        }
        int height = view.getHeight();
        view.clearAnimation();
        TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, 0.0f, height * (-1));
        translateAnimation.setDuration(DefualtAnimationTime);
        translateAnimation.setFillAfter(true);
        translateAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.funny.audio.view.core.AnimationUtils.4
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                AnimationCallback animationCallback = callback;
                if (animationCallback != null) {
                    animationCallback.onAnimationStart(animation);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                view.setVisibility(8);
                view.clearAnimation();
                AnimationCallback animationCallback = callback;
                if (animationCallback != null) {
                    animationCallback.onAnimationEnd(animation);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
                AnimationCallback animationCallback = callback;
                if (animationCallback != null) {
                    animationCallback.onAnimationRepeat(animation);
                }
            }
        });
        view.startAnimation(translateAnimation);
    }

    public static RotateAnimation getRotateAnimation(float fromDegrees, float toDegrees, int pivotXType, float pivotXValue, int pivotYType, float pivotYValue, long durationMillis, Animation.AnimationListener animationListener) {
        RotateAnimation rotateAnimation = new RotateAnimation(fromDegrees, toDegrees, pivotXType, pivotXValue, pivotYType, pivotYValue);
        rotateAnimation.setDuration(durationMillis);
        if (animationListener != null) {
            rotateAnimation.setAnimationListener(animationListener);
        }
        return rotateAnimation;
    }

    public static RotateAnimation getRotateAnimationByCenter(long durationMillis, Animation.AnimationListener animationListener) {
        return getRotateAnimation(0.0f, 359.0f, 1, 0.5f, 1, 0.5f, durationMillis, animationListener);
    }

    public static RotateAnimation getRotateAnimationByCenter(long duration) {
        return getRotateAnimationByCenter(duration, null);
    }

    public static RotateAnimation getRotateAnimationByCenter(Animation.AnimationListener animationListener) {
        return getRotateAnimationByCenter(400L, animationListener);
    }

    public static RotateAnimation getRotateAnimationByCenter() {
        return getRotateAnimationByCenter(400L, null);
    }

    public static AlphaAnimation getAlphaAnimation(float fromAlpha, float toAlpha, long durationMillis, Animation.AnimationListener animationListener) {
        AlphaAnimation alphaAnimation = new AlphaAnimation(fromAlpha, toAlpha);
        alphaAnimation.setDuration(durationMillis);
        if (animationListener != null) {
            alphaAnimation.setAnimationListener(animationListener);
        }
        return alphaAnimation;
    }

    public static AlphaAnimation getAlphaAnimation(float fromAlpha, float toAlpha, long durationMillis) {
        return getAlphaAnimation(fromAlpha, toAlpha, durationMillis, null);
    }

    public static AlphaAnimation getAlphaAnimation(float fromAlpha, float toAlpha, Animation.AnimationListener animationListener) {
        return getAlphaAnimation(fromAlpha, toAlpha, 400L, animationListener);
    }

    public static AlphaAnimation getAlphaAnimation(float fromAlpha, float toAlpha) {
        return getAlphaAnimation(fromAlpha, toAlpha, 400L, null);
    }

    public static AlphaAnimation getHiddenAlphaAnimation(long durationMillis, Animation.AnimationListener animationListener) {
        return getAlphaAnimation(1.0f, 0.0f, durationMillis, animationListener);
    }

    public static AlphaAnimation getHiddenAlphaAnimation(long durationMillis) {
        return getHiddenAlphaAnimation(durationMillis, null);
    }

    public static AlphaAnimation getHiddenAlphaAnimation(Animation.AnimationListener animationListener) {
        return getHiddenAlphaAnimation(400L, animationListener);
    }

    public static AlphaAnimation getHiddenAlphaAnimation() {
        return getHiddenAlphaAnimation(400L, null);
    }

    public static AlphaAnimation getShowAlphaAnimation(long durationMillis, Animation.AnimationListener animationListener) {
        return getAlphaAnimation(0.0f, 1.0f, durationMillis, animationListener);
    }

    public static AlphaAnimation getShowAlphaAnimation(long durationMillis) {
        return getAlphaAnimation(0.0f, 1.0f, durationMillis, null);
    }

    public static AlphaAnimation getShowAlphaAnimation(Animation.AnimationListener animationListener) {
        return getAlphaAnimation(0.0f, 1.0f, 400L, animationListener);
    }

    public static AlphaAnimation getShowAlphaAnimation() {
        return getAlphaAnimation(0.0f, 1.0f, 400L, null);
    }

    public static ScaleAnimation getLessenScaleAnimation(long durationMillis, Animation.AnimationListener animationListener) {
        ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 0.0f, 1.0f, 0.0f, 1.0f, 1.0f);
        scaleAnimation.setDuration(durationMillis);
        scaleAnimation.setAnimationListener(animationListener);
        return scaleAnimation;
    }

    public static ScaleAnimation getLessenScaleAnimation(long durationMillis) {
        return getLessenScaleAnimation(durationMillis, null);
    }

    public static ScaleAnimation getLessenScaleAnimation(Animation.AnimationListener animationListener) {
        return getLessenScaleAnimation(400L, animationListener);
    }

    public static ScaleAnimation getAmplificationAnimation(long durationMillis, Animation.AnimationListener animationListener) {
        ScaleAnimation scaleAnimation = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 1.0f, 1.0f);
        scaleAnimation.setDuration(durationMillis);
        scaleAnimation.setAnimationListener(animationListener);
        return scaleAnimation;
    }

    public static ScaleAnimation getAmplificationAnimation(long durationMillis) {
        return getAmplificationAnimation(durationMillis, null);
    }

    public static ScaleAnimation getAmplificationAnimation(Animation.AnimationListener animationListener) {
        return getAmplificationAnimation(400L, animationListener);
    }
}
