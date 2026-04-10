package com.anythink.basead.d;

import android.content.Context;
import android.view.ViewGroup;
import com.anythink.basead.d.b;
import com.anythink.basead.ui.AsseblemSplashAdView;
import com.anythink.basead.ui.BaseSdkSplashAdView;
import com.anythink.basead.ui.BaseSplashAdView;
import com.anythink.basead.ui.MraidSplashAdView;
import com.anythink.basead.ui.SinglePictureSplashAdView;
import com.anythink.core.common.b.n;
import com.anythink.core.common.e.j;
import com.anythink.core.common.k.u;

/* JADX INFO: loaded from: classes.dex */
public final class g extends b {
    BaseSplashAdView a;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    boolean f6010k;

    public g(Context context, b.a aVar, j jVar) {
        super(context, aVar, jVar);
    }

    public final void a() {
        this.f6010k = true;
    }

    @Override // com.anythink.basead.d.b
    public final void b() {
        BaseSplashAdView baseSplashAdView = this.a;
        if (baseSplashAdView != null) {
            baseSplashAdView.destroy();
            this.a = null;
        }
        com.anythink.core.common.a.g gVar = this.f5983f;
        if (gVar == null || !(gVar instanceof com.anythink.expressad.splash.d.c)) {
            return;
        }
        ((com.anythink.expressad.splash.d.c) gVar).g();
    }

    public final boolean e() {
        return this.f5983f == null;
    }

    public final void a(final ViewGroup viewGroup) {
        if (super.c()) {
            u.a(false);
            n.a().a(new Runnable() { // from class: com.anythink.basead.d.g.1
                @Override // java.lang.Runnable
                public final void run() {
                    g gVar = g.this;
                    com.anythink.core.common.a.g gVar2 = gVar.f5983f;
                    if (gVar2 instanceof com.anythink.expressad.splash.d.c) {
                        ((com.anythink.expressad.splash.d.c) gVar2).a(new com.anythink.expressad.out.e() { // from class: com.anythink.basead.d.g.1.1
                            @Override // com.anythink.expressad.out.e
                            public final void a() {
                                com.anythink.basead.e.a aVar = g.this.f5985h;
                                if (aVar != null) {
                                    aVar.onAdShow();
                                }
                            }

                            @Override // com.anythink.expressad.out.e
                            public final void b() {
                                com.anythink.basead.e.a aVar = g.this.f5985h;
                                if (aVar != null) {
                                    aVar.onAdClosed();
                                }
                            }

                            @Override // com.anythink.expressad.out.e
                            public final void c() {
                            }

                            @Override // com.anythink.expressad.out.e
                            public final void d() {
                            }

                            @Override // com.anythink.expressad.out.e
                            public final void e() {
                            }

                            @Override // com.anythink.expressad.out.e
                            public final void a(String str) {
                                com.anythink.basead.e.a aVar = g.this.f5985h;
                                if (aVar != null) {
                                    aVar.onShowFailed(com.anythink.basead.c.f.a(com.anythink.basead.c.f.f5907k, str));
                                }
                            }

                            @Override // com.anythink.expressad.out.e
                            public final void a(com.anythink.expressad.foundation.d.c cVar) {
                                com.anythink.basead.a.c cVar2 = g.this.f5984g;
                                if (cVar2 != null) {
                                    com.anythink.basead.d.a.b.a(cVar2.b(), cVar);
                                    com.anythink.basead.c.i iVar = new com.anythink.basead.c.i(g.this.f5980c.f7303d, "");
                                    iVar.f5935g = new com.anythink.basead.c.a();
                                    g.this.f5984g.a(iVar);
                                }
                            }
                        });
                        ((com.anythink.expressad.splash.d.c) g.this.f5983f).a(viewGroup);
                        return;
                    }
                    if (gVar.f5982e.g()) {
                        g gVar3 = g.this;
                        Context context = viewGroup.getContext();
                        g gVar4 = g.this;
                        gVar3.a = new MraidSplashAdView(context, gVar4.f5980c, gVar4.f5982e, gVar4.f5985h);
                    } else {
                        g gVar5 = g.this;
                        if (BaseSdkSplashAdView.isSinglePicture(gVar5.f5982e, gVar5.f5980c.f7312m)) {
                            g gVar6 = g.this;
                            Context context2 = viewGroup.getContext();
                            g gVar7 = g.this;
                            gVar6.a = new SinglePictureSplashAdView(context2, gVar7.f5980c, gVar7.f5982e, gVar7.f5985h);
                        } else {
                            g gVar8 = g.this;
                            Context context3 = viewGroup.getContext();
                            g gVar9 = g.this;
                            gVar8.a = new AsseblemSplashAdView(context3, gVar9.f5980c, gVar9.f5982e, gVar9.f5985h);
                        }
                    }
                    g gVar10 = g.this;
                    gVar10.a.setDontCountDown(gVar10.f6010k);
                    viewGroup.addView(g.this.a);
                }
            });
        }
    }
}
