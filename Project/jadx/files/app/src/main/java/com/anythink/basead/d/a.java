package com.anythink.basead.d;

import android.content.Context;
import android.view.View;
import com.anythink.basead.d.b;
import com.anythink.basead.ui.BaseBannerAdView;
import com.anythink.basead.ui.MraidBannerAdView;
import com.anythink.basead.ui.SdkBannerAdView;
import com.anythink.core.common.e.j;
import com.anythink.expressad.out.TemplateBannerView;

/* JADX INFO: loaded from: classes.dex */
public final class a extends b {
    BaseBannerAdView a;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final String f5962k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private com.anythink.expressad.out.h f5963l;

    public a(Context context, b.a aVar, j jVar) {
        super(context, aVar, jVar);
        this.f5962k = a.class.getSimpleName();
        this.f5963l = new com.anythink.expressad.out.h() { // from class: com.anythink.basead.d.a.1
            @Override // com.anythink.expressad.out.h
            public final void a() {
            }

            @Override // com.anythink.expressad.out.h
            public final void a(final com.anythink.expressad.foundation.d.c cVar) {
                com.anythink.core.common.k.b.a.a().a(new Runnable() { // from class: com.anythink.basead.d.a.1.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        a.this.a(cVar, "");
                    }
                });
            }

            @Override // com.anythink.expressad.out.h
            public final void a(String str) {
            }

            @Override // com.anythink.expressad.out.h
            public final void b() {
                com.anythink.basead.e.a aVar2 = a.this.f5985h;
                if (aVar2 != null) {
                    aVar2.onAdShow();
                }
            }

            @Override // com.anythink.expressad.out.h
            public final void c() {
            }

            @Override // com.anythink.expressad.out.h
            public final void d() {
            }

            @Override // com.anythink.expressad.out.h
            public final void e() {
            }

            @Override // com.anythink.expressad.out.h
            public final void f() {
                com.anythink.basead.e.a aVar2 = a.this.f5985h;
                if (aVar2 != null) {
                    aVar2.onAdClosed();
                }
            }
        };
    }

    public final View a() {
        com.anythink.core.common.a.g gVar = this.f5983f;
        if ((gVar instanceof TemplateBannerView) && gVar != null) {
            ((TemplateBannerView) gVar).setBannerAdListener(this.f5963l);
            return (TemplateBannerView) this.f5983f;
        }
        if (this.a == null && super.c()) {
            if (this.f5982e.g()) {
                this.a = new MraidBannerAdView(this.b, this.f5980c, this.f5982e, this.f5985h);
            } else {
                this.a = new SdkBannerAdView(this.b, this.f5980c, this.f5982e, this.f5985h);
            }
        }
        return this.a;
    }

    @Override // com.anythink.basead.d.b
    public final void b() {
        super.b();
        com.anythink.core.common.a.g gVar = this.f5983f;
        if (gVar instanceof TemplateBannerView) {
            ((TemplateBannerView) gVar).release();
        }
        this.f5983f = null;
        this.f5985h = null;
    }
}
