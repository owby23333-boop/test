package com.bytedance.adsdk.lottie.gc;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: loaded from: classes2.dex */
public abstract class z extends ValueAnimator {
    private final Set<ValueAnimator.AnimatorUpdateListener> z = new CopyOnWriteArraySet();
    private final Set<Animator.AnimatorListener> g = new CopyOnWriteArraySet();
    private final Set<Animator.AnimatorPauseListener> dl = new CopyOnWriteArraySet();

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public long getStartDelay() {
        throw new UnsupportedOperationException("LottieAnimator does not support getStartDelay.");
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public void setStartDelay(long j) {
        throw new UnsupportedOperationException("LottieAnimator does not support setStartDelay.");
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public ValueAnimator setDuration(long j) {
        throw new UnsupportedOperationException("LottieAnimator does not support setDuration.");
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public void setInterpolator(TimeInterpolator timeInterpolator) {
        throw new UnsupportedOperationException("LottieAnimator does not support setInterpolator.");
    }

    @Override // android.animation.ValueAnimator
    public void addUpdateListener(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.z.add(animatorUpdateListener);
    }

    @Override // android.animation.ValueAnimator
    public void removeUpdateListener(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.z.remove(animatorUpdateListener);
    }

    @Override // android.animation.ValueAnimator
    public void removeAllUpdateListeners() {
        this.z.clear();
    }

    @Override // android.animation.Animator
    public void addListener(Animator.AnimatorListener animatorListener) {
        this.g.add(animatorListener);
    }

    @Override // android.animation.Animator
    public void removeListener(Animator.AnimatorListener animatorListener) {
        this.g.remove(animatorListener);
    }

    @Override // android.animation.Animator
    public void removeAllListeners() {
        this.g.clear();
    }

    void z(boolean z) {
        Iterator<Animator.AnimatorListener> it = this.g.iterator();
        while (it.hasNext()) {
            it.next().onAnimationStart(this, z);
        }
    }

    @Override // android.animation.Animator
    public void addPauseListener(Animator.AnimatorPauseListener animatorPauseListener) {
        this.dl.add(animatorPauseListener);
    }

    @Override // android.animation.Animator
    public void removePauseListener(Animator.AnimatorPauseListener animatorPauseListener) {
        this.dl.remove(animatorPauseListener);
    }

    void z() {
        Iterator<Animator.AnimatorListener> it = this.g.iterator();
        while (it.hasNext()) {
            it.next().onAnimationRepeat(this);
        }
    }

    void g(boolean z) {
        Iterator<Animator.AnimatorListener> it = this.g.iterator();
        while (it.hasNext()) {
            it.next().onAnimationEnd(this, z);
        }
    }

    void g() {
        Iterator<Animator.AnimatorListener> it = this.g.iterator();
        while (it.hasNext()) {
            it.next().onAnimationCancel(this);
        }
    }

    void dl() {
        Iterator<ValueAnimator.AnimatorUpdateListener> it = this.z.iterator();
        while (it.hasNext()) {
            it.next().onAnimationUpdate(this);
        }
    }

    void a() {
        Iterator<Animator.AnimatorPauseListener> it = this.dl.iterator();
        while (it.hasNext()) {
            it.next().onAnimationPause(this);
        }
    }

    void gc() {
        Iterator<Animator.AnimatorPauseListener> it = this.dl.iterator();
        while (it.hasNext()) {
            it.next().onAnimationResume(this);
        }
    }
}
