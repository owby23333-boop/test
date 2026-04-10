package com.amgcyo.cuttadon.h.d.e;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.amgcyo.cuttadon.utils.otherutils.u0;
import com.bytedance.msdk.api.v2.ad.splash.GMSplashAd;
import com.bytedance.msdk.api.v2.ad.splash.GMSplashCardListener;
import java.lang.ref.SoftReference;
import java.util.Objects;

/* JADX INFO: compiled from: SplashCardManager.java */
/* JADX INFO: loaded from: classes.dex */
public class l {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static volatile l f3925g;
    private SoftReference<GMSplashAd> a;
    private View b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private ViewGroup f3926c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f3927d = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private b f3928e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private SoftReference<a> f3929f;

    /* JADX INFO: compiled from: SplashCardManager.java */
    public interface a {
        void a();

        void onSplashCardClick();

        void onSplashCardClose();

        void onSplashClickEyeClick();
    }

    /* JADX INFO: compiled from: SplashCardManager.java */
    private static class b implements GMSplashCardListener {
        private final SoftReference<Activity> a;
        private SoftReference<View> b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final SoftReference<a> f3930c;

        public b(Activity activity, GMSplashAd gMSplashAd, a aVar) {
            this.a = new SoftReference<>(activity);
            new SoftReference(gMSplashAd);
            this.f3930c = new SoftReference<>(aVar);
        }

        public void a(View view) {
            this.b = new SoftReference<>(view);
        }

        @Override // com.bytedance.msdk.api.v2.ad.splash.GMSplashCardListener
        public Activity getActivity() {
            return this.a.get();
        }

        @Override // com.bytedance.msdk.api.v2.ad.splash.GMSplashCardListener
        public void onSplashCardClick() {
            l.c().e();
        }

        @Override // com.bytedance.msdk.api.v2.ad.splash.GMSplashCardListener
        public void onSplashClickEyeClick() {
            l.c().f();
        }

        @Override // com.bytedance.msdk.api.v2.ad.splash.GMSplashCardListener
        public void onSplashClickEyeClose() {
            Objects.requireNonNull(l.c());
            SoftReference<View> softReference = this.b;
            if (softReference != null && softReference.get() != null) {
                this.b.get().setVisibility(8);
                u0.a(this.b.get());
            }
            if (this.f3930c.get() != null) {
                this.f3930c.get().onSplashCardClose();
            }
            l.c().b();
        }

        @Override // com.bytedance.msdk.api.v2.ad.splash.GMSplashCardListener
        public void onSplashEyeReady() {
            if (l.c().a()) {
                l.c().a(this.a.get());
            }
        }

        @Override // com.bytedance.msdk.api.v2.ad.splash.GMSplashCardListener
        public void setSupportSplashClickEye(boolean z2) {
            l.c().a(z2);
        }
    }

    private GMSplashAd d() {
        SoftReference<GMSplashAd> softReference = this.a;
        if (softReference != null) {
            return softReference.get();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        SoftReference<a> softReference = this.f3929f;
        if (softReference == null || softReference.get() == null) {
            return;
        }
        this.f3929f.get().onSplashCardClick();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        SoftReference<a> softReference = this.f3929f;
        if (softReference == null || softReference.get() == null) {
            return;
        }
        this.f3929f.get().onSplashClickEyeClick();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        this.a = null;
        this.b = null;
        this.f3926c = null;
    }

    public static l c() {
        if (f3925g == null) {
            synchronized (l.class) {
                if (f3925g == null) {
                    f3925g = new l();
                }
            }
        }
        return f3925g;
    }

    public void a(Activity activity, GMSplashAd gMSplashAd, View view, a aVar) {
        this.f3927d = false;
        this.f3926c = null;
        if (activity == null || gMSplashAd == null || view == null) {
            return;
        }
        this.a = new SoftReference<>(gMSplashAd);
        this.b = view;
        this.f3929f = new SoftReference<>(aVar);
        this.f3928e = new b(activity, gMSplashAd, this.f3929f.get());
        gMSplashAd.setSplashCardListener(this.f3928e);
    }

    private ViewGroup b(View view, ViewGroup viewGroup, Activity activity) {
        SoftReference<a> softReference = this.f3929f;
        if (softReference != null && softReference.get() != null) {
            this.f3929f.get().a();
        }
        u0.a(view);
        FrameLayout frameLayout = new FrameLayout(view.getContext());
        frameLayout.addView(view, -1, -1);
        viewGroup.addView(frameLayout, -1, -1);
        a(viewGroup, activity);
        return frameLayout;
    }

    private void a(ViewGroup viewGroup, Activity activity) {
        GMSplashAd gMSplashAdD = c().d();
        if (gMSplashAdD != null) {
            if (TextUtils.equals(gMSplashAdD.getShowEcpm().getAdNetworkPlatformName(), "pangle")) {
                gMSplashAdD.showSplashCardView(viewGroup, activity);
            } else {
                gMSplashAdD.splashMinWindowAnimationFinish();
            }
        }
    }

    private void a(View view, ViewGroup viewGroup, Activity activity) {
        this.f3926c = b(view, viewGroup, activity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z2) {
        this.f3927d = z2;
    }

    public boolean a() {
        return this.f3927d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Activity activity) {
        View view;
        if (!a() || activity == null || this.a == null || (view = this.b) == null) {
            return;
        }
        a(view, (ViewGroup) activity.getWindow().getDecorView(), activity);
        b bVar = this.f3928e;
        if (bVar != null) {
            bVar.a(this.f3926c);
        }
    }
}
