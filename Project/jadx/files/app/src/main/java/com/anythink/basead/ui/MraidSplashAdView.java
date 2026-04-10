package com.anythink.basead.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import com.anythink.basead.ui.MraidContainerView;
import com.anythink.core.common.e.i;
import com.anythink.core.common.e.j;
import com.anythink.core.common.k.h;

/* JADX INFO: loaded from: classes2.dex */
public class MraidSplashAdView extends BaseSplashAdView {
    MraidContainerView a;

    /* JADX INFO: renamed from: com.anythink.basead.ui.MraidSplashAdView$2, reason: invalid class name */
    final class AnonymousClass2 implements Runnable {
        AnonymousClass2() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            MraidSplashAdView mraidSplashAdView = MraidSplashAdView.this;
            if (mraidSplashAdView.F == null) {
                return;
            }
            MraidSplashAdView.super.h();
        }
    }

    public MraidSplashAdView(Context context) {
        super(context);
    }

    private void c() {
        if (this.f6115d.g() && this.a == null) {
            return;
        }
        super.a(this.f6114c.f7312m.R() < 0 ? 100 : this.f6114c.f7312m.R(), new AnonymousClass2());
    }

    @Override // com.anythink.basead.ui.BaseSplashAdView, com.anythink.basead.ui.BaseAdView
    public void destroy() {
        super.destroy();
        MraidContainerView mraidContainerView = this.a;
        if (mraidContainerView != null) {
            mraidContainerView.release();
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z2) {
        super.onWindowFocusChanged(z2);
        MraidContainerView mraidContainerView = this.a;
        if (mraidContainerView != null) {
            mraidContainerView.fireMraidIsViewable(z2);
        }
    }

    @Override // com.anythink.basead.ui.BaseSplashAdView
    protected final void p() {
        int size = this.f6129r.size();
        for (int i2 = 0; i2 < size; i2++) {
            View view = this.f6129r.get(i2);
            if (view != null) {
                view.setOnClickListener(this.K);
            }
        }
    }

    /* JADX INFO: renamed from: com.anythink.basead.ui.MraidSplashAdView$1, reason: invalid class name */
    final class AnonymousClass1 implements MraidContainerView.a {
        AnonymousClass1() {
        }

        @Override // com.anythink.basead.ui.MraidContainerView.a
        public final void a(String str) {
            MraidSplashAdView.this.f6115d.v(str);
            MraidSplashAdView.this.b(1);
        }

        @Override // com.anythink.basead.ui.MraidContainerView.a
        public final void b() {
            MraidSplashAdView.this.q();
            MraidSplashAdView.this.r();
            MraidSplashAdView.this.p();
        }

        @Override // com.anythink.basead.ui.MraidContainerView.a
        public final void a() {
            try {
                MraidSplashAdView.a(MraidSplashAdView.this);
            } catch (Throwable unused) {
            }
        }
    }

    public MraidSplashAdView(Context context, j jVar, i iVar, com.anythink.basead.e.a aVar) {
        super(context, jVar, iVar, aVar);
    }

    private void b() {
        this.a = new MraidContainerView(getContext(), this.f6115d, this.f6114c, new AnonymousClass1());
        this.a.setNeedRegisterVolumeChangeReceiver(true);
        this.a.init();
        FrameLayout frameLayout = (FrameLayout) findViewById(h.a(getContext(), "myoffer_splash_web", "id"));
        if (frameLayout != null) {
            frameLayout.addView(this.a, new FrameLayout.LayoutParams(-1, -1));
        }
    }

    @Override // com.anythink.basead.ui.BaseAdView
    protected final void a() {
        LayoutInflater.from(getContext()).inflate(h.a(getContext(), "myoffer_web_splash_ad_layout", "layout"), this);
        this.a = new MraidContainerView(getContext(), this.f6115d, this.f6114c, new AnonymousClass1());
        this.a.setNeedRegisterVolumeChangeReceiver(true);
        this.a.init();
        FrameLayout frameLayout = (FrameLayout) findViewById(h.a(getContext(), "myoffer_splash_web", "id"));
        if (frameLayout != null) {
            frameLayout.addView(this.a, new FrameLayout.LayoutParams(-1, -1));
        }
    }

    static /* synthetic */ void a(MraidSplashAdView mraidSplashAdView) {
        if (mraidSplashAdView.f6115d.g() && mraidSplashAdView.a == null) {
            return;
        }
        super.a(mraidSplashAdView.f6114c.f7312m.R() < 0 ? 100 : mraidSplashAdView.f6114c.f7312m.R(), mraidSplashAdView.new AnonymousClass2());
    }
}
