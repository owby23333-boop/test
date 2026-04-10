package com.bytedance.adsdk.lottie.vn;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: loaded from: classes.dex */
public abstract class e extends ValueAnimator {
    private final Set<ValueAnimator.AnimatorUpdateListener> e = new CopyOnWriteArraySet();
    private final Set<Animator.AnimatorListener> bf = new CopyOnWriteArraySet();
    private final Set<Animator.AnimatorPauseListener> d = new CopyOnWriteArraySet();

    @Override // android.animation.Animator
    public void addListener(Animator.AnimatorListener animatorListener) {
        this.bf.add(animatorListener);
    }

    @Override // android.animation.Animator
    public void addPauseListener(Animator.AnimatorPauseListener animatorPauseListener) {
        this.d.add(animatorPauseListener);
    }

    @Override // android.animation.ValueAnimator
    public void addUpdateListener(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.e.add(animatorUpdateListener);
    }

    void bf(boolean z) {
        Iterator<Animator.AnimatorListener> it = this.bf.iterator();
        while (it.hasNext()) {
            it.next().onAnimationEnd(this, z);
        }
    }

    void d() {
        Iterator<ValueAnimator.AnimatorUpdateListener> it = this.e.iterator();
        while (it.hasNext()) {
            it.next().onAnimationUpdate(this);
        }
    }

    void e(boolean z) {
        Iterator<Animator.AnimatorListener> it = this.bf.iterator();
        while (it.hasNext()) {
            it.next().onAnimationStart(this, z);
        }
    }

    void ga() {
        Iterator<Animator.AnimatorPauseListener> it = this.d.iterator();
        while (it.hasNext()) {
            it.next().onAnimationResume(this);
        }
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public long getStartDelay() {
        throw new UnsupportedOperationException("LottieAnimator does not support getStartDelay.");
    }

    @Override // android.animation.Animator
    public void removeAllListeners() {
        this.bf.clear();
    }

    @Override // android.animation.ValueAnimator
    public void removeAllUpdateListeners() {
        this.e.clear();
    }

    @Override // android.animation.Animator
    public void removeListener(Animator.AnimatorListener animatorListener) {
        this.bf.remove(animatorListener);
    }

    @Override // android.animation.Animator
    public void removePauseListener(Animator.AnimatorPauseListener animatorPauseListener) {
        this.d.remove(animatorPauseListener);
    }

    @Override // android.animation.ValueAnimator
    public void removeUpdateListener(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.e.remove(animatorUpdateListener);
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public void setInterpolator(TimeInterpolator timeInterpolator) {
        throw new UnsupportedOperationException("LottieAnimator does not support setInterpolator.");
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public void setStartDelay(long j) {
        throw new UnsupportedOperationException("LottieAnimator does not support setStartDelay.");
    }

    void tg() {
        Iterator<Animator.AnimatorPauseListener> it = this.d.iterator();
        while (it.hasNext()) {
            it.next().onAnimationPause(this);
        }
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public ValueAnimator setDuration(long j) {
        throw new UnsupportedOperationException("LottieAnimator does not support setDuration.");
    }

    void bf() {
        Iterator<Animator.AnimatorListener> it = this.bf.iterator();
        while (it.hasNext()) {
            it.next().onAnimationCancel(this);
        }
    }

    void e() {
        Iterator<Animator.AnimatorListener> it = this.bf.iterator();
        while (it.hasNext()) {
            it.next().onAnimationRepeat(this);
        }
    }
}
