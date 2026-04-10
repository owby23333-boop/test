package com.amgcyo.cuttadon.h.d.e;

import android.animation.Animator;
import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.OvershootInterpolator;
import android.widget.FrameLayout;
import com.amgcyo.cuttadon.app.MkApplication;
import com.bytedance.msdk.api.AdError;
import com.bytedance.msdk.api.UIUtils;
import com.bytedance.msdk.api.v2.ad.splash.GMSplashAd;
import com.bytedance.msdk.api.v2.ad.splash.GMSplashAdListener;
import java.lang.ref.SoftReference;

/* JADX INFO: compiled from: SplashMinWindowManager.java */
/* JADX INFO: loaded from: classes.dex */
public class m {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static volatile m f3931n;
    private int a;
    private int b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f3932c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f3933d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f3934e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f3935f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private SoftReference<GMSplashAd> f3936g;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f3938i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f3939j;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int[] f3937h = new int[2];

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f3940k = false;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private Rect f3941l = new Rect();

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    GMSplashAdListener f3942m = new b(this);

    /* JADX INFO: compiled from: SplashMinWindowManager.java */
    class a implements Animator.AnimatorListener {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        final /* synthetic */ c f3943s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        final /* synthetic */ View f3944t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        final /* synthetic */ ViewGroup f3945u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        final /* synthetic */ float f3946v;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        final /* synthetic */ int[] f3947w;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        final /* synthetic */ float f3948x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        final /* synthetic */ FrameLayout f3949y;

        a(c cVar, View view, ViewGroup viewGroup, float f2, int[] iArr, float f3, FrameLayout frameLayout) {
            this.f3943s = cVar;
            this.f3944t = view;
            this.f3945u = viewGroup;
            this.f3946v = f2;
            this.f3947w = iArr;
            this.f3948x = f3;
            this.f3949y = frameLayout;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            UIUtils.removeFromParent(this.f3944t);
            this.f3944t.setScaleX(1.0f);
            this.f3944t.setScaleY(1.0f);
            this.f3944t.setX(0.0f);
            this.f3944t.setY(0.0f);
            this.f3945u.getLocationOnScreen(new int[2]);
            float f2 = this.f3946v - r5[0];
            int[] iArr = this.f3947w;
            float f3 = (this.f3948x - r5[1]) + iArr[1];
            this.f3949y.addView(this.f3944t, -1, -1);
            this.f3945u.addView(this.f3949y, new FrameLayout.LayoutParams(m.this.a, m.this.b));
            this.f3949y.setTranslationX(f2 + iArr[0]);
            this.f3949y.setTranslationY(f3);
            c cVar = this.f3943s;
            if (cVar != null) {
                cVar.a();
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            c cVar = this.f3943s;
            if (cVar != null) {
                cVar.a(m.this.f3935f);
            }
        }
    }

    /* JADX INFO: compiled from: SplashMinWindowManager.java */
    class b implements GMSplashAdListener {
        b(m mVar) {
        }

        @Override // com.bytedance.msdk.api.v2.ad.splash.GMSplashAdListener
        public void onAdClicked() {
        }

        @Override // com.bytedance.msdk.api.v2.ad.splash.GMSplashAdListener
        public void onAdDismiss() {
        }

        @Override // com.bytedance.msdk.api.v2.ad.splash.GMSplashAdListener
        public void onAdShow() {
        }

        @Override // com.bytedance.msdk.api.v2.ad.splash.GMSplashAdListener
        public void onAdShowFail(AdError adError) {
        }

        @Override // com.bytedance.msdk.api.v2.ad.splash.GMSplashAdListener
        public void onAdSkip() {
        }
    }

    /* JADX INFO: compiled from: SplashMinWindowManager.java */
    public interface c {
        void a();

        void a(int i2);
    }

    private m() {
        MkApplication appContext = MkApplication.getAppContext();
        a(appContext);
        this.f3932c = UIUtils.dip2px(appContext, 16.0f);
        this.f3933d = UIUtils.dip2px(appContext, 100.0f);
        this.f3934e = 1;
        this.f3935f = 300;
    }

    private void a(Context context) {
        int iMin = Math.min(UIUtils.getScreenHeight(context), UIUtils.getScreenWidth(context));
        SoftReference<GMSplashAd> softReference = this.f3936g;
        GMSplashAd gMSplashAd = softReference != null ? softReference.get() : null;
        if (gMSplashAd == null || gMSplashAd.getMinWindowSize() == null || gMSplashAd.getMinWindowSize().length < 2) {
            this.a = Math.round(iMin * 0.3f);
            this.b = Math.round((this.a * 16) / 9);
        } else {
            this.a = UIUtils.dip2px(context, gMSplashAd.getMinWindowSize()[0]);
            this.b = UIUtils.dip2px(context, gMSplashAd.getMinWindowSize()[1]);
        }
        Rect rect = this.f3941l;
        rect.right = iMin - this.f3932c;
        rect.left = rect.right - this.a;
        rect.bottom = UIUtils.getScreenHeight(context) - this.f3933d;
        Rect rect2 = this.f3941l;
        rect2.top = rect2.bottom - this.b;
    }

    private ViewGroup b(GMSplashAd gMSplashAd, View view, ViewGroup viewGroup, ViewGroup viewGroup2, c cVar) {
        if (gMSplashAd == null || view == null || viewGroup2 == null) {
            return null;
        }
        int[] minWindowSize = gMSplashAd.getMinWindowSize();
        if (minWindowSize != null && minWindowSize.length >= 2) {
            this.a = UIUtils.dip2px(MkApplication.getAppContext(), minWindowSize[0]);
            this.b = UIUtils.dip2px(MkApplication.getAppContext(), minWindowSize[1]);
        }
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        Context context = viewGroup2.getContext();
        int width = view.getWidth();
        int height = view.getHeight();
        int width2 = viewGroup.getWidth();
        int height2 = viewGroup.getHeight();
        if (width2 == 0) {
            width2 = this.f3938i;
        }
        if (height2 == 0) {
            height2 = this.f3939j;
        }
        int i2 = this.a;
        float f2 = i2 / width;
        float f3 = this.b / height;
        float f4 = this.f3934e == 0 ? this.f3932c : (width2 - this.f3932c) - i2;
        float f5 = (height2 - this.f3933d) - this.b;
        UIUtils.removeFromParent(view);
        viewGroup.addView(view, new FrameLayout.LayoutParams(width, height));
        FrameLayout frameLayout = new FrameLayout(context);
        view.setPivotX(0.0f);
        view.setPivotY(0.0f);
        view.animate().scaleX(f2).scaleY(f3).x(f4).y(f5).setInterpolator(new OvershootInterpolator(0.0f)).setDuration(this.f3935f).setListener(new a(cVar, view, viewGroup2, f4, iArr, f5, frameLayout));
        return frameLayout;
    }

    public static m c() {
        if (f3931n == null) {
            synchronized (m.class) {
                if (f3931n == null) {
                    f3931n = new m();
                }
            }
        }
        return f3931n;
    }

    public void a(GMSplashAd gMSplashAd, View view, View view2) {
        this.f3936g = new SoftReference<>(gMSplashAd);
        new SoftReference(view);
        view.getLocationOnScreen(this.f3937h);
        this.f3938i = view2.getWidth();
        this.f3939j = view2.getHeight();
        a(MkApplication.getAppContext());
    }

    public void a() {
        this.f3936g = null;
    }

    public ViewGroup a(GMSplashAd gMSplashAd, View view, ViewGroup viewGroup, ViewGroup viewGroup2, c cVar) {
        if (gMSplashAd == null || view == null || viewGroup2 == null || gMSplashAd.showWindowDirect(this.f3941l, this.f3942m)) {
            return null;
        }
        return b(gMSplashAd, view, viewGroup, viewGroup2, cVar);
    }

    public void a(boolean z2) {
        this.f3940k = z2;
    }

    public boolean b() {
        return this.f3940k;
    }
}
