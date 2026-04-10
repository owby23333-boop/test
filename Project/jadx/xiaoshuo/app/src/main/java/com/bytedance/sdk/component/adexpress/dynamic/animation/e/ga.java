package com.bytedance.sdk.component.adexpress.dynamic.animation.e;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.animation.BounceInterpolator;
import android.view.animation.LinearInterpolator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class ga extends tg {
    public ga(View view, com.bytedance.sdk.component.adexpress.dynamic.d.e eVar) {
        super(view, eVar);
    }

    private void bf(List<ObjectAnimator> list) {
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.d, "translationY", 0.0f, -com.bytedance.sdk.component.adexpress.d.bf.e(com.bytedance.sdk.component.adexpress.tg.getContext(), this.bf.dt())).setDuration((int) (this.bf.m() * 1000.0d));
        duration.setInterpolator(new BounceInterpolator());
        duration.addListener(new Animator.AnimatorListener() { // from class: com.bytedance.sdk.component.adexpress.dynamic.animation.e.ga.1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                ga.this.d.setTranslationY(0.0f);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }
        });
        list.add(e(duration));
    }

    private void d(List<ObjectAnimator> list) {
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.d, "translationY", 0.0f, -com.bytedance.sdk.component.adexpress.d.bf.e(com.bytedance.sdk.component.adexpress.tg.getContext(), this.bf.dt())).setDuration((int) (this.bf.m() * 1000.0d));
        duration.setInterpolator(new BounceInterpolator());
        duration.addListener(new Animator.AnimatorListener() { // from class: com.bytedance.sdk.component.adexpress.dynamic.animation.e.ga.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                ga.this.d.setTranslationY(0.0f);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }
        });
        list.add(e(duration));
    }

    private void tg(List<ObjectAnimator> list) {
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.d, "translationY", 0.0f, -com.bytedance.sdk.component.adexpress.d.bf.e(com.bytedance.sdk.component.adexpress.tg.getContext(), this.bf.dt())).setDuration((int) (this.bf.m() * 1000.0d));
        duration.setInterpolator(new BounceInterpolator());
        list.add(e(duration));
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:17:0x003d  */
    @Override // com.bytedance.sdk.component.adexpress.dynamic.animation.e.tg
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.util.List<android.animation.ObjectAnimator> e() {
        /*
            r5 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            com.bytedance.sdk.component.adexpress.dynamic.d.e r1 = r5.bf
            java.lang.String r1 = r1.pe()
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
            r5.d(r0)
            goto L53
        L48:
            r5.bf(r0)
            goto L53
        L4c:
            r5.tg(r0)
            goto L53
        L50:
            r5.e(r0)
        L53:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.adexpress.dynamic.animation.e.ga.e():java.util.List");
    }

    private void e(List<ObjectAnimator> list) {
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.d, "translationY", 0.0f, -com.bytedance.sdk.component.adexpress.d.bf.e(com.bytedance.sdk.component.adexpress.tg.getContext(), this.bf.dt())).setDuration(((int) (this.bf.m() * 1000.0d)) / 2);
        duration.setInterpolator(new LinearInterpolator());
        duration.setRepeatMode(2);
        com.bytedance.sdk.component.adexpress.dynamic.d.e eVar = this.bf;
        eVar.vn(eVar.s() * 2);
        list.add(e(duration));
    }
}
