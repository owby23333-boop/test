package com.bytedance.sdk.component.adexpress.dynamic.animation.z;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidgetImp;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a implements com.bytedance.sdk.component.adexpress.dynamic.dynamicview.gc {
    public View dl;
    com.bytedance.sdk.component.adexpress.dynamic.dl.z g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Set<ScheduledFuture<?>> f548a = new HashSet();
    public List<ObjectAnimator> z = z();

    abstract List<ObjectAnimator> z();

    public a(View view, com.bytedance.sdk.component.adexpress.dynamic.dl.z zVar) {
        this.dl = view;
        this.g = zVar;
    }

    public void dl() {
        List<ObjectAnimator> list = this.z;
        if (list == null) {
            return;
        }
        for (final ObjectAnimator objectAnimator : list) {
            objectAnimator.start();
            if (this.g.p() > 0.0d) {
                objectAnimator.addListener(new Animator.AnimatorListener() { // from class: com.bytedance.sdk.component.adexpress.dynamic.animation.z.a.1
                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationRepeat(Animator animator) {
                        objectAnimator.pause();
                        z zVar = a.this.new z(objectAnimator);
                        ScheduledFuture<?> scheduledFutureZ = com.bytedance.sdk.component.adexpress.a.gc.z(zVar, (long) (a.this.g.p() * 1000.0d), TimeUnit.MILLISECONDS);
                        zVar.z(scheduledFutureZ);
                        a.this.f548a.add(scheduledFutureZ);
                    }
                });
            }
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.gc
    public void g() {
        List<ObjectAnimator> list = this.z;
        if (list == null) {
            return;
        }
        for (ObjectAnimator objectAnimator : list) {
            objectAnimator.cancel();
            objectAnimator.removeAllUpdateListeners();
        }
        Iterator<ScheduledFuture<?>> it = this.f548a.iterator();
        while (it.hasNext()) {
            it.next().cancel(true);
        }
    }

    ObjectAnimator z(final ObjectAnimator objectAnimator) {
        objectAnimator.setStartDelay((long) (this.g.v() * 1000.0d));
        if (this.g.pf() > 0) {
            objectAnimator.setRepeatCount(this.g.pf() - 1);
        } else {
            objectAnimator.setRepeatCount(-1);
        }
        if (!"normal".equals(this.g.ls())) {
            if ("alternate".equals(this.g.ls()) || "alternate-reverse".equals(this.g.ls())) {
                objectAnimator.setRepeatMode(2);
            } else {
                objectAnimator.setRepeatMode(1);
            }
        }
        if ("ease-in-out".equals(this.g.i())) {
            objectAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
        } else if ("ease-in".equals(this.g.ls())) {
            objectAnimator.setInterpolator(new AccelerateInterpolator());
        } else if ("ease-out".equals(this.g.ls())) {
            objectAnimator.setInterpolator(new DecelerateInterpolator());
        } else {
            objectAnimator.setInterpolator(new LinearInterpolator());
        }
        objectAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.bytedance.sdk.component.adexpress.dynamic.animation.z.a.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.getCurrentPlayTime() > 0) {
                    a.this.dl.setVisibility(0);
                    if (a.this.dl.getParent() instanceof DynamicBaseWidgetImp) {
                        ((View) a.this.dl.getParent()).setVisibility(0);
                    }
                    objectAnimator.removeAllUpdateListeners();
                }
            }
        });
        return objectAnimator;
    }

    public class z implements Runnable {
        ScheduledFuture<?> g;
        ObjectAnimator z;

        z(ObjectAnimator objectAnimator) {
            this.z = objectAnimator;
        }

        public void z(ScheduledFuture<?> scheduledFuture) {
            this.g = scheduledFuture;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (com.bytedance.sdk.component.adexpress.z.z.z.z().dl() != null) {
                com.bytedance.sdk.component.adexpress.z.z.z.z().dl().g().post(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.dynamic.animation.z.a.z.1
                    @Override // java.lang.Runnable
                    public void run() {
                        z.this.z.resume();
                    }
                });
                if (this.g != null) {
                    a.this.f548a.remove(this.g);
                }
            }
        }
    }
}
