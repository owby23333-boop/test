package com.lxj.xpopup.core;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ArgbEvaluator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import androidx.transition.ChangeBounds;
import androidx.transition.ChangeImageTransform;
import androidx.transition.ChangeTransform;
import androidx.transition.Transition;
import androidx.transition.TransitionListenerAdapter;
import androidx.transition.TransitionManager;
import androidx.transition.TransitionSet;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.lxj.xpopup.R$id;
import com.lxj.xpopup.R$layout;
import com.lxj.xpopup.c.g;
import com.lxj.xpopup.c.i;
import com.lxj.xpopup.enums.PopupStatus;
import com.lxj.xpopup.photoview.PhotoView;
import com.lxj.xpopup.util.XPermission;
import com.lxj.xpopup.widget.BlankView;
import com.lxj.xpopup.widget.HackyViewPager;
import com.lxj.xpopup.widget.PhotoViewContainer;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class ImageViewerPopupView extends BasePopupView implements com.lxj.xpopup.c.d, View.OnClickListener {
    protected FrameLayout N;
    protected PhotoViewContainer O;
    protected BlankView P;
    protected TextView Q;
    protected TextView R;
    protected HackyViewPager S;
    protected ArgbEvaluator T;
    protected List<Object> U;
    protected i V;
    protected g W;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    protected int f17384a0;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    protected Rect f17385b0;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    protected ImageView f17386c0;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    protected PhotoView f17387d0;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    protected boolean f17388e0;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    protected int f17389f0;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    protected int f17390g0;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    protected int f17391h0;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    protected boolean f17392i0;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    protected boolean f17393j0;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    protected boolean f17394k0;

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    protected View f17395l0;

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    protected int f17396m0;

    class a implements Runnable {

        /* JADX INFO: renamed from: com.lxj.xpopup.core.ImageViewerPopupView$a$a, reason: collision with other inner class name */
        class C0495a extends TransitionListenerAdapter {
            C0495a() {
            }

            @Override // androidx.transition.TransitionListenerAdapter, androidx.transition.Transition.TransitionListener
            public void onTransitionEnd(@NonNull Transition transition) {
                ImageViewerPopupView.this.S.setVisibility(0);
                ImageViewerPopupView.this.f17387d0.setVisibility(4);
                ImageViewerPopupView.this.z();
                ImageViewerPopupView.this.O.isReleasing = false;
            }
        }

        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            TransitionManager.beginDelayedTransition((ViewGroup) ImageViewerPopupView.this.f17387d0.getParent(), new TransitionSet().setDuration(ImageViewerPopupView.this.getAnimationDuration()).addTransition(new ChangeBounds()).addTransition(new ChangeTransform()).addTransition(new ChangeImageTransform()).setInterpolator((TimeInterpolator) new FastOutSlowInInterpolator()).addListener((Transition.TransitionListener) new C0495a()));
            ImageViewerPopupView.this.f17387d0.setTranslationY(0.0f);
            ImageViewerPopupView.this.f17387d0.setTranslationX(0.0f);
            ImageViewerPopupView.this.f17387d0.setScaleType(ImageView.ScaleType.FIT_CENTER);
            ImageViewerPopupView imageViewerPopupView = ImageViewerPopupView.this;
            com.lxj.xpopup.util.b.a(imageViewerPopupView.f17387d0, imageViewerPopupView.O.getWidth(), ImageViewerPopupView.this.O.getHeight());
            ImageViewerPopupView imageViewerPopupView2 = ImageViewerPopupView.this;
            imageViewerPopupView2.b(imageViewerPopupView2.f17396m0);
            View view = ImageViewerPopupView.this.f17395l0;
            if (view != null) {
                view.animate().alpha(1.0f).setDuration(ImageViewerPopupView.this.getAnimationDuration()).start();
            }
        }
    }

    class b implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        final /* synthetic */ int f17399s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        final /* synthetic */ int f17400t;

        b(int i2, int i3) {
            this.f17399s = i2;
            this.f17400t = i3;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            ImageViewerPopupView imageViewerPopupView = ImageViewerPopupView.this;
            imageViewerPopupView.O.setBackgroundColor(((Integer) imageViewerPopupView.T.evaluate(valueAnimator.getAnimatedFraction(), Integer.valueOf(this.f17399s), Integer.valueOf(this.f17400t))).intValue());
        }
    }

    class c implements Runnable {

        class a extends TransitionListenerAdapter {
            a() {
            }

            @Override // androidx.transition.TransitionListenerAdapter, androidx.transition.Transition.TransitionListener
            public void onTransitionEnd(@NonNull Transition transition) {
                ImageViewerPopupView.this.S.setVisibility(4);
                ImageViewerPopupView.this.f17387d0.setVisibility(0);
                ImageViewerPopupView.this.S.setScaleX(1.0f);
                ImageViewerPopupView.this.S.setScaleY(1.0f);
                ImageViewerPopupView.this.f17387d0.setScaleX(1.0f);
                ImageViewerPopupView.this.f17387d0.setScaleY(1.0f);
                ImageViewerPopupView.this.P.setVisibility(4);
            }
        }

        class b extends AnimatorListenerAdapter {
            b() {
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                View view = ImageViewerPopupView.this.f17395l0;
                if (view != null) {
                    view.setVisibility(4);
                }
            }
        }

        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            TransitionManager.beginDelayedTransition((ViewGroup) ImageViewerPopupView.this.f17387d0.getParent(), new TransitionSet().setDuration(ImageViewerPopupView.this.getAnimationDuration()).addTransition(new ChangeBounds()).addTransition(new ChangeTransform()).addTransition(new ChangeImageTransform()).setInterpolator((TimeInterpolator) new FastOutSlowInInterpolator()).addListener((Transition.TransitionListener) new a()));
            ImageViewerPopupView.this.f17387d0.setScaleX(1.0f);
            ImageViewerPopupView.this.f17387d0.setScaleY(1.0f);
            ImageViewerPopupView.this.f17387d0.setTranslationY(r0.f17385b0.top);
            ImageViewerPopupView.this.f17387d0.setTranslationX(r0.f17385b0.left);
            ImageViewerPopupView imageViewerPopupView = ImageViewerPopupView.this;
            imageViewerPopupView.f17387d0.setScaleType(imageViewerPopupView.f17386c0.getScaleType());
            ImageViewerPopupView imageViewerPopupView2 = ImageViewerPopupView.this;
            com.lxj.xpopup.util.b.a(imageViewerPopupView2.f17387d0, imageViewerPopupView2.f17385b0.width(), ImageViewerPopupView.this.f17385b0.height());
            ImageViewerPopupView.this.b(0);
            View view = ImageViewerPopupView.this.f17395l0;
            if (view != null) {
                view.animate().alpha(0.0f).setDuration(ImageViewerPopupView.this.getAnimationDuration()).setListener(new b()).start();
            }
        }
    }

    class d implements XPermission.d {
        d() {
        }

        @Override // com.lxj.xpopup.util.XPermission.d
        public void a() {
        }

        @Override // com.lxj.xpopup.util.XPermission.d
        public void onGranted() {
            Context context = ImageViewerPopupView.this.getContext();
            ImageViewerPopupView imageViewerPopupView = ImageViewerPopupView.this;
            com.lxj.xpopup.util.b.a(context, imageViewerPopupView.V, imageViewerPopupView.U.get(imageViewerPopupView.getRealPosition()));
        }
    }

    public class e extends PagerAdapter implements ViewPager.OnPageChangeListener {
        public e() {
        }

        private FrameLayout a(Context context) {
            FrameLayout frameLayout = new FrameLayout(context);
            frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            return frameLayout;
        }

        private ProgressBar b(Context context) {
            ProgressBar progressBar = new ProgressBar(context);
            progressBar.setIndeterminate(true);
            int iA = com.lxj.xpopup.util.b.a(ImageViewerPopupView.this.N.getContext(), 40.0f);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(iA, iA);
            layoutParams.gravity = 17;
            progressBar.setLayoutParams(layoutParams);
            progressBar.setVisibility(8);
            return progressBar;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void destroyItem(@NonNull ViewGroup viewGroup, int i2, @NonNull Object obj) {
            viewGroup.removeView((View) obj);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            ImageViewerPopupView imageViewerPopupView = ImageViewerPopupView.this;
            if (imageViewerPopupView.f17394k0) {
                return 100000;
            }
            return imageViewerPopupView.U.size();
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        @NonNull
        public Object instantiateItem(@NonNull ViewGroup viewGroup, int i2) {
            ImageViewerPopupView imageViewerPopupView = ImageViewerPopupView.this;
            if (imageViewerPopupView.f17394k0) {
                i2 %= imageViewerPopupView.U.size();
            }
            int i3 = i2;
            FrameLayout frameLayoutA = a(viewGroup.getContext());
            ProgressBar progressBarB = b(viewGroup.getContext());
            ImageViewerPopupView imageViewerPopupView2 = ImageViewerPopupView.this;
            i iVar = imageViewerPopupView2.V;
            Object obj = imageViewerPopupView2.U.get(i3);
            ImageViewerPopupView imageViewerPopupView3 = ImageViewerPopupView.this;
            frameLayoutA.addView(iVar.a(i3, obj, imageViewerPopupView3, imageViewerPopupView3.f17387d0, progressBarB), new FrameLayout.LayoutParams(-1, -1));
            frameLayoutA.addView(progressBarB);
            viewGroup.addView(frameLayoutA);
            return frameLayoutA;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public boolean isViewFromObject(@NonNull View view, @NonNull Object obj) {
            return obj == view;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i2) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i2, float f2, int i3) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i2) {
            ImageViewerPopupView imageViewerPopupView = ImageViewerPopupView.this;
            imageViewerPopupView.f17384a0 = i2;
            imageViewerPopupView.z();
            ImageViewerPopupView imageViewerPopupView2 = ImageViewerPopupView.this;
            g gVar = imageViewerPopupView2.W;
            if (gVar != null) {
                gVar.a(imageViewerPopupView2, imageViewerPopupView2.getRealPosition());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i2) {
        int color = ((ColorDrawable) this.O.getBackground()).getColor();
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        valueAnimatorOfFloat.addUpdateListener(new b(color, i2));
        valueAnimatorOfFloat.setDuration(getAnimationDuration()).setInterpolator(new LinearInterpolator());
        valueAnimatorOfFloat.start();
    }

    private void x() {
        if (this.f17386c0 == null) {
            return;
        }
        if (this.f17387d0 == null) {
            this.f17387d0 = new PhotoView(getContext());
            this.f17387d0.setEnabled(false);
            this.O.addView(this.f17387d0);
            this.f17387d0.setScaleType(this.f17386c0.getScaleType());
            this.f17387d0.setTranslationX(this.f17385b0.left);
            this.f17387d0.setTranslationY(this.f17385b0.top);
            com.lxj.xpopup.util.b.a(this.f17387d0, this.f17385b0.width(), this.f17385b0.height());
        }
        int realPosition = getRealPosition();
        this.f17387d0.setTag(Integer.valueOf(realPosition));
        ImageView imageView = this.f17386c0;
        if (imageView != null && imageView.getDrawable() != null) {
            try {
                this.f17387d0.setImageDrawable(this.f17386c0.getDrawable().getConstantState().newDrawable());
            } catch (Exception unused) {
            }
        }
        y();
        i iVar = this.V;
        if (iVar != null) {
            iVar.a(this.U.get(realPosition), this.f17387d0);
        }
    }

    private void y() {
        this.P.setVisibility(this.f17388e0 ? 0 : 4);
        if (this.f17388e0) {
            int i2 = this.f17389f0;
            if (i2 != -1) {
                this.P.color = i2;
            }
            int i3 = this.f17391h0;
            if (i3 != -1) {
                this.P.radius = i3;
            }
            int i4 = this.f17390g0;
            if (i4 != -1) {
                this.P.strokeColor = i4;
            }
            com.lxj.xpopup.util.b.a(this.P, this.f17385b0.width(), this.f17385b0.height());
            this.P.setTranslationX(this.f17385b0.left);
            this.P.setTranslationY(this.f17385b0.top);
            this.P.invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z() {
        if (this.U.size() > 1) {
            int realPosition = getRealPosition();
            this.Q.setText((realPosition + 1) + "/" + this.U.size());
        }
        if (this.f17392i0) {
            this.R.setVisibility(0);
        }
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    public void f() {
        super.f();
        HackyViewPager hackyViewPager = this.S;
        hackyViewPager.removeOnPageChangeListener((e) hackyViewPager.getAdapter());
        this.V = null;
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    public void g() {
        if (this.f17366x != PopupStatus.Show) {
            return;
        }
        this.f17366x = PopupStatus.Dismissing;
        k();
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    protected int getInnerLayoutId() {
        return R$layout._xpopup_image_viewer_popup_view;
    }

    protected int getRealPosition() {
        return this.f17394k0 ? this.f17384a0 % this.U.size() : this.f17384a0;
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    public void k() {
        if (this.f17386c0 == null) {
            this.O.setBackgroundColor(0);
            i();
            this.S.setVisibility(4);
            this.P.setVisibility(4);
            return;
        }
        this.Q.setVisibility(4);
        this.R.setVisibility(4);
        this.S.setVisibility(4);
        this.O.isReleasing = true;
        this.f17387d0.setVisibility(0);
        i();
        this.f17387d0.post(new c());
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    public void l() {
        if (this.f17386c0 == null) {
            this.O.setBackgroundColor(this.f17396m0);
            this.S.setVisibility(0);
            z();
            this.O.isReleasing = false;
            j();
            return;
        }
        this.O.isReleasing = true;
        View view = this.f17395l0;
        if (view != null) {
            view.setVisibility(0);
        }
        this.f17387d0.setVisibility(0);
        j();
        this.f17387d0.post(new a());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.R) {
            w();
        }
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    protected void q() {
        super.q();
        this.Q = (TextView) findViewById(R$id.tv_pager_indicator);
        this.R = (TextView) findViewById(R$id.tv_save);
        this.P = (BlankView) findViewById(R$id.placeholderView);
        this.O = (PhotoViewContainer) findViewById(R$id.photoViewContainer);
        this.O.setOnDragChangeListener(this);
        this.S = (HackyViewPager) findViewById(R$id.pager);
        e eVar = new e();
        this.S.setAdapter(eVar);
        this.S.setCurrentItem(this.f17384a0);
        this.S.setVisibility(4);
        x();
        this.S.setOffscreenPageLimit(2);
        this.S.addOnPageChangeListener(eVar);
        if (!this.f17393j0) {
            this.Q.setVisibility(8);
        }
        if (this.f17392i0) {
            this.R.setOnClickListener(this);
        } else {
            this.R.setVisibility(8);
        }
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    protected void s() {
        super.s();
        this.f17386c0 = null;
        this.W = null;
    }

    protected void w() {
        XPermission xPermissionA = XPermission.a(getContext(), "STORAGE");
        xPermissionA.a(new d());
        xPermissionA.e();
    }

    @Override // com.lxj.xpopup.c.d
    public void a() {
        g();
    }

    @Override // com.lxj.xpopup.c.d
    public void a(int i2, float f2, float f3) {
        float f4 = 1.0f - f3;
        this.Q.setAlpha(f4);
        View view = this.f17395l0;
        if (view != null) {
            view.setAlpha(f4);
        }
        if (this.f17392i0) {
            this.R.setAlpha(f4);
        }
        this.O.setBackgroundColor(((Integer) this.T.evaluate(f3 * 0.8f, Integer.valueOf(this.f17396m0), 0)).intValue());
    }
}
