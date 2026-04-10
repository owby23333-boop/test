package com.bytedance.sdk.component.adexpress.dynamic.animation.e;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidgetImp;
import com.yuewen.w51;
import com.yuewen.x30;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public abstract class tg implements com.bytedance.sdk.component.adexpress.dynamic.dynamicview.tg {
    com.bytedance.sdk.component.adexpress.dynamic.d.e bf;
    public View d;
    private Set<ScheduledFuture<?>> tg = new HashSet();
    public List<ObjectAnimator> e = e();

    public class e implements Runnable {
        ScheduledFuture<?> bf;
        ObjectAnimator e;

        public e(ObjectAnimator objectAnimator) {
            this.e = objectAnimator;
        }

        public void e(ScheduledFuture<?> scheduledFuture) {
            this.bf = scheduledFuture;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (com.bytedance.sdk.component.adexpress.e.e.e.e().d() != null) {
                com.bytedance.sdk.component.adexpress.e.e.e.e().d().bf().post(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.dynamic.animation.e.tg.e.1
                    @Override // java.lang.Runnable
                    public void run() {
                        e.this.e.resume();
                    }
                });
                if (this.bf != null) {
                    tg.this.tg.remove(this.bf);
                }
            }
        }
    }

    public tg(View view, com.bytedance.sdk.component.adexpress.dynamic.d.e eVar) {
        this.d = view;
        this.bf = eVar;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.tg
    public void bf() {
        List<ObjectAnimator> list = this.e;
        if (list == null) {
            return;
        }
        for (ObjectAnimator objectAnimator : list) {
            objectAnimator.cancel();
            objectAnimator.removeAllUpdateListeners();
        }
        Iterator<ScheduledFuture<?>> it = this.tg.iterator();
        while (it.hasNext()) {
            it.next().cancel(true);
        }
    }

    public void d() {
        List<ObjectAnimator> list = this.e;
        if (list == null) {
            return;
        }
        for (final ObjectAnimator objectAnimator : list) {
            objectAnimator.start();
            if (this.bf.l() > w51.l) {
                objectAnimator.addListener(new Animator.AnimatorListener() { // from class: com.bytedance.sdk.component.adexpress.dynamic.animation.e.tg.1
                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationRepeat(Animator animator) {
                        objectAnimator.pause();
                        e eVar = tg.this.new e(objectAnimator);
                        ScheduledFuture<?> scheduledFutureSchedule = com.bytedance.sdk.component.zk.ga.tg().schedule(eVar, (long) (tg.this.bf.l() * 1000.0d), TimeUnit.MILLISECONDS);
                        eVar.e(scheduledFutureSchedule);
                        tg.this.tg.add(scheduledFutureSchedule);
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                    }
                });
            }
        }
    }

    public abstract List<ObjectAnimator> e();

    public ObjectAnimator e(final ObjectAnimator objectAnimator) {
        objectAnimator.setStartDelay((long) (this.bf.t() * 1000.0d));
        if (this.bf.s() > 0) {
            objectAnimator.setRepeatCount(this.bf.s() - 1);
        } else {
            objectAnimator.setRepeatCount(-1);
        }
        if (!x30.z.equals(this.bf.w())) {
            if ("reverse".equals(this.bf.w()) || "alternate".equals(this.bf.w())) {
                objectAnimator.setRepeatMode(2);
            } else {
                objectAnimator.setRepeatMode(1);
            }
        }
        if ("ease-in-out".equals(this.bf.bh())) {
            objectAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
        } else if ("ease-in".equals(this.bf.w())) {
            objectAnimator.setInterpolator(new AccelerateInterpolator());
        } else if ("ease-out".equals(this.bf.w())) {
            objectAnimator.setInterpolator(new DecelerateInterpolator());
        } else {
            objectAnimator.setInterpolator(new LinearInterpolator());
        }
        objectAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.bytedance.sdk.component.adexpress.dynamic.animation.e.tg.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.getCurrentPlayTime() > 0) {
                    tg.this.d.setVisibility(0);
                    if (tg.this.d.getParent() instanceof DynamicBaseWidgetImp) {
                        ((View) tg.this.d.getParent()).setVisibility(0);
                    }
                    objectAnimator.removeAllUpdateListeners();
                }
            }
        });
        return objectAnimator;
    }
}
