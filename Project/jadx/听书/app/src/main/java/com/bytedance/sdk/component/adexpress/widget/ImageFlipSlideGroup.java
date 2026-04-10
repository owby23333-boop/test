package com.bytedance.sdk.component.adexpress.widget;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Point;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicImageFlipSlide;
import com.bytedance.sdk.component.utils.h;
import com.bytedance.sdk.component.utils.tb;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class ImageFlipSlideGroup extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    float f601a;
    ImageView dl;
    boolean e;
    private String fo;
    BookPageView g;
    ObjectAnimator gc;
    private ImageFlipSlide gz;
    private List<String> i;
    private String kb;
    boolean m;
    private String uy;
    private String wp;
    FrameLayout z;

    public ImageFlipSlideGroup(Context context, boolean z) {
        super(context);
        this.f601a = 0.0f;
        this.e = z;
        a();
        setVisibility(4);
        post(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.widget.ImageFlipSlideGroup.1
            @Override // java.lang.Runnable
            public void run() {
                ImageFlipSlideGroup.this.setVisibility(0);
            }
        });
    }

    public float getRatio() {
        return this.f601a;
    }

    public void setRatio(float f) {
        this.f601a = f;
        post(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.widget.ImageFlipSlideGroup.2
            @Override // java.lang.Runnable
            public void run() {
                if (ImageFlipSlideGroup.this.e) {
                    ImageFlipSlideGroup.this.gz.z(ImageFlipSlideGroup.this.f601a);
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) ImageFlipSlideGroup.this.z.getLayoutParams();
                    layoutParams.leftMargin = (int) (((1.0f - ImageFlipSlideGroup.this.f601a) - 0.5f) * ImageFlipSlideGroup.this.getWidth() * 2);
                    layoutParams.width = -1;
                    layoutParams.height = -1;
                    ImageFlipSlideGroup.this.z.setLayoutParams(layoutParams);
                    return;
                }
                Point point = new Point();
                point.x = ((int) (ImageFlipSlideGroup.this.getWidth() - (ImageFlipSlideGroup.this.getWidth() * ImageFlipSlideGroup.this.f601a))) - 100;
                point.y = ((int) (ImageFlipSlideGroup.this.getHeight() - (ImageFlipSlideGroup.this.getWidth() * ImageFlipSlideGroup.this.f601a))) - 100;
                if (ImageFlipSlideGroup.this.f601a > 0.3f) {
                    point.x = (int) (((double) point.x) - (((double) (ImageFlipSlideGroup.this.getWidth() * 2)) * (((double) ImageFlipSlideGroup.this.f601a) - 0.3d)));
                    point.y = (int) (((double) point.y) + (((double) (ImageFlipSlideGroup.this.getHeight() / 2)) * (((double) ImageFlipSlideGroup.this.f601a) - 0.3d)));
                }
                ImageFlipSlideGroup.this.g.z(point);
                ImageFlipSlideGroup.this.g.setAlpha(1.0f - (ImageFlipSlideGroup.this.f601a - 0.3f));
                ImageFlipSlideGroup.this.gz.z(ImageFlipSlideGroup.this.g.getFilterAreaPath());
            }
        });
    }

    public void z(final DynamicImageFlipSlide.z zVar) {
        if (this.m) {
            if (zVar != null) {
                zVar.z();
                return;
            }
            return;
        }
        this.m = true;
        this.gc.cancel();
        if (this.dl != null) {
            AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
            alphaAnimation.setDuration(300L);
            alphaAnimation.setFillAfter(true);
            this.dl.setAnimation(alphaAnimation);
            alphaAnimation.start();
        }
        float[] fArr = new float[2];
        fArr[0] = this.f601a;
        fArr[1] = this.e ? 1.1f : 1.3f;
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this, "ratio", fArr);
        objectAnimatorOfFloat.setDuration(500L);
        objectAnimatorOfFloat.addListener(new Animator.AnimatorListener() { // from class: com.bytedance.sdk.component.adexpress.widget.ImageFlipSlideGroup.3
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
                ImageFlipSlideGroup.this.z.setVisibility(8);
                DynamicImageFlipSlide.z zVar2 = zVar;
                if (zVar2 != null) {
                    zVar2.z();
                }
            }
        });
        objectAnimatorOfFloat.start();
    }

    private void a() {
        ImageFlipSlide imageFlipSlide = new ImageFlipSlide(getContext(), this.e);
        this.gz = imageFlipSlide;
        addView(imageFlipSlide);
        FrameLayout frameLayout = new FrameLayout(getContext());
        this.z = frameLayout;
        addView(frameLayout);
        if (this.e) {
            View view = new View(getContext());
            view.setBackgroundColor(-1);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(h.z(getContext(), 2.0f), -1);
            layoutParams.gravity = 17;
            this.z.addView(view, layoutParams);
            ImageView imageView = new ImageView(getContext());
            imageView.setImageResource(tb.gc(getContext(), "tt_im_fs_handle"));
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(h.z(getContext(), 44.0f), h.z(getContext(), 44.0f));
            layoutParams2.gravity = 17;
            this.z.addView(imageView, layoutParams2);
            ImageView imageView2 = new ImageView(getContext());
            this.dl = imageView2;
            imageView2.setImageResource(tb.gc(getContext(), "tt_im_fs_tip"));
            FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(h.z(getContext(), 196.0f), h.z(getContext(), 300.0f));
            layoutParams3.gravity = 17;
            layoutParams3.topMargin = h.z(getContext(), 6.0f);
            this.z.addView(this.dl, layoutParams3);
            return;
        }
        BookPageView bookPageView = new BookPageView(getContext());
        this.g = bookPageView;
        this.z.addView(bookPageView);
    }

    public void z() {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this, "ratio", 0.15f, 0.25f);
        this.gc = objectAnimatorOfFloat;
        objectAnimatorOfFloat.setDuration(700L);
        this.gc.setInterpolator(new LinearInterpolator());
        this.gc.setRepeatCount(-1);
        this.gc.setRepeatMode(2);
        this.gc.start();
    }

    public void g() {
        ObjectAnimator objectAnimator = this.gc;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
    }

    public void z(String str, String str2) {
        this.fo = str;
        this.kb = str2;
    }

    public void g(String str, String str2) {
        this.uy = str;
        this.wp = str2;
    }

    public void setFilterColors(List<String> list) {
        this.i = list;
    }

    public void dl() {
        if (!TextUtils.isEmpty(this.uy)) {
            this.gz.z(this.uy, this.wp, (List<String>) null);
        } else {
            this.gz.z(this.fo, this.kb, this.i);
        }
    }
}
