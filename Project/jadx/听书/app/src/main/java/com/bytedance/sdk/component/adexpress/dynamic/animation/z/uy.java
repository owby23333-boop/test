package com.bytedance.sdk.component.adexpress.dynamic.animation.z;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.bykv.vk.component.ttvideo.player.MediaFormat;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class uy extends a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private z f549a;
    private float gc;
    private float m;

    public uy(View view, com.bytedance.sdk.component.adexpress.dynamic.dl.z zVar) {
        super(view, zVar);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.animation.z.a
    List<ObjectAnimator> z() {
        int i;
        String str;
        if ((this.dl instanceof ImageView) && (this.dl.getParent() instanceof DynamicBaseWidget)) {
            this.dl = (View) this.dl.getParent();
        }
        this.dl.setAlpha(0.0f);
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.dl, "alpha", 0.0f, 1.0f).setDuration((int) (this.g.uy() * 1000.0d));
        this.f549a = new z(this.dl);
        final int i2 = this.dl.getLayoutParams().height;
        this.gc = i2;
        this.m = this.dl.getLayoutParams().width;
        if (TtmlNode.LEFT.equals(this.g.z()) || TtmlNode.RIGHT.equals(this.g.z())) {
            i = (int) this.m;
            str = MediaFormat.KEY_WIDTH;
        } else {
            str = MediaFormat.KEY_HEIGHT;
            i = i2;
        }
        ObjectAnimator duration2 = ObjectAnimator.ofInt(this.f549a, str, 0, i).setDuration((int) (this.g.uy() * 1000.0d));
        ArrayList arrayList = new ArrayList();
        arrayList.add(z(duration));
        arrayList.add(z(duration2));
        ((ObjectAnimator) arrayList.get(0)).addListener(new Animator.AnimatorListener() { // from class: com.bytedance.sdk.component.adexpress.dynamic.animation.z.uy.1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator, boolean z2) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator, boolean z2) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                uy.this.f549a.z(i2);
            }
        });
        return arrayList;
    }

    private class z {
        private View g;

        public z(View view) {
            this.g = view;
        }

        public void z(int i) {
            if ("top".equals(uy.this.g.z())) {
                if (uy.this.dl instanceof ViewGroup) {
                    for (int i2 = 0; i2 < ((ViewGroup) uy.this.dl).getChildCount(); i2++) {
                        ((ViewGroup) uy.this.dl).getChildAt(i2).setTranslationY(i - uy.this.gc);
                    }
                }
                uy.this.dl.setTranslationY(uy.this.gc - i);
                return;
            }
            ViewGroup.LayoutParams layoutParams = this.g.getLayoutParams();
            layoutParams.height = i;
            this.g.setLayoutParams(layoutParams);
            this.g.requestLayout();
        }
    }
}
