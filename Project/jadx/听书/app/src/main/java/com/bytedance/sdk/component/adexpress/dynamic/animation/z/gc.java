package com.bytedance.sdk.component.adexpress.dynamic.animation.z;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.animation.BounceInterpolator;
import android.view.animation.LinearInterpolator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class gc extends a {
    public gc(View view, com.bytedance.sdk.component.adexpress.dynamic.dl.z zVar) {
        super(view, zVar);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:17:0x003d  */
    @Override // com.bytedance.sdk.component.adexpress.dynamic.animation.z.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    java.util.List<android.animation.ObjectAnimator> z() {
        /*
            r5 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            com.bytedance.sdk.component.adexpress.dynamic.dl.z r1 = r5.g
            java.lang.String r1 = r1.q()
            int r2 = r1.hashCode()
            r3 = 2
            r4 = 1
            switch(r2) {
                case 3029889: goto L33;
                case 3387192: goto L29;
                case 483313230: goto L1f;
                case 1356771568: goto L15;
                default: goto L14;
            }
        L14:
            goto L3d
        L15:
            java.lang.String r2 = "backwards"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L3d
            r1 = r3
            goto L3e
        L1f:
            java.lang.String r2 = "forwards"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L3d
            r1 = r4
            goto L3e
        L29:
            java.lang.String r2 = "none"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L3d
            r1 = 3
            goto L3e
        L33:
            java.lang.String r2 = "both"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L3d
            r1 = 0
            goto L3e
        L3d:
            r1 = -1
        L3e:
            if (r1 == 0) goto L50
            if (r1 == r4) goto L4c
            if (r1 == r3) goto L48
            r5.dl(r0)
            goto L53
        L48:
            r5.g(r0)
            goto L53
        L4c:
            r5.a(r0)
            goto L53
        L50:
            r5.z(r0)
        L53:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.adexpress.dynamic.animation.z.gc.z():java.util.List");
    }

    private void z(List<ObjectAnimator> list) {
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.dl, "translationY", 0.0f, -com.bytedance.sdk.component.adexpress.a.gz.z(com.bytedance.sdk.component.adexpress.a.getContext(), this.g.tb())).setDuration(((int) (this.g.uy() * 1000.0d)) / 2);
        duration.setInterpolator(new LinearInterpolator());
        duration.setRepeatMode(2);
        this.g.m(this.g.pf() * 2);
        list.add(z(duration));
    }

    private void g(List<ObjectAnimator> list) {
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.dl, "translationY", 0.0f, -com.bytedance.sdk.component.adexpress.a.gz.z(com.bytedance.sdk.component.adexpress.a.getContext(), this.g.tb())).setDuration((int) (this.g.uy() * 1000.0d));
        duration.setInterpolator(new BounceInterpolator());
        duration.addListener(new Animator.AnimatorListener() { // from class: com.bytedance.sdk.component.adexpress.dynamic.animation.z.gc.1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                gc.this.dl.setTranslationY(0.0f);
            }
        });
        list.add(z(duration));
    }

    private void dl(List<ObjectAnimator> list) {
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.dl, "translationY", 0.0f, -com.bytedance.sdk.component.adexpress.a.gz.z(com.bytedance.sdk.component.adexpress.a.getContext(), this.g.tb())).setDuration((int) (this.g.uy() * 1000.0d));
        duration.setInterpolator(new BounceInterpolator());
        duration.addListener(new Animator.AnimatorListener() { // from class: com.bytedance.sdk.component.adexpress.dynamic.animation.z.gc.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                gc.this.dl.setTranslationY(0.0f);
            }
        });
        list.add(z(duration));
    }

    private void a(List<ObjectAnimator> list) {
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.dl, "translationY", 0.0f, -com.bytedance.sdk.component.adexpress.a.gz.z(com.bytedance.sdk.component.adexpress.a.getContext(), this.g.tb())).setDuration((int) (this.g.uy() * 1000.0d));
        duration.setInterpolator(new BounceInterpolator());
        list.add(z(duration));
    }
}
