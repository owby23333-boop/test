package com.anythink.basead.d;

import android.app.Activity;
import android.content.Context;
import com.anythink.basead.d.b;
import com.anythink.basead.e.b;
import com.anythink.basead.ui.BaseAdActivity;
import com.anythink.core.common.e.j;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class f extends b {
    public static final String a = "f";

    public f(Context context, b.a aVar, j jVar) {
        super(context, aVar, jVar);
    }

    public final void a(Activity activity, Map<String, Object> map) {
        try {
            if (!c()) {
                if (this.f5985h != null) {
                    this.f5985h.onShowFailed(com.anythink.basead.c.f.a(com.anythink.basead.c.f.f5905i, com.anythink.basead.c.f.f5920x));
                }
                this.f5982e = null;
                return;
            }
            final String string = map.get("extra_scenario").toString();
            int iIntValue = ((Integer) map.get(com.anythink.basead.f.c.f6032j)).intValue();
            final String strA = a(this.f5982e);
            if (this.f5983f instanceof com.anythink.expressad.reward.b.a) {
                ((com.anythink.expressad.reward.b.a) this.f5983f).a(new com.anythink.expressad.videocommon.d.a() { // from class: com.anythink.basead.d.f.1
                    @Override // com.anythink.expressad.videocommon.d.a
                    public final void a() {
                    }

                    @Override // com.anythink.expressad.videocommon.d.a
                    public final void a(String str) {
                    }

                    @Override // com.anythink.expressad.videocommon.d.a
                    public final void a(boolean z2, String str, float f2) {
                        com.anythink.basead.e.a aVar;
                        if (z2 && (aVar = f.this.f5985h) != null && (aVar instanceof com.anythink.basead.e.g)) {
                            ((com.anythink.basead.e.g) aVar).onRewarded();
                        }
                        com.anythink.basead.e.a aVar2 = f.this.f5985h;
                        if (aVar2 != null) {
                            aVar2.onAdClosed();
                        }
                        com.anythink.basead.a.c cVar = f.this.f5984g;
                        if (cVar != null) {
                            cVar.d();
                        }
                    }

                    @Override // com.anythink.expressad.videocommon.d.a
                    public final void b() {
                    }

                    @Override // com.anythink.expressad.videocommon.d.a
                    public final void b(String str) {
                        com.anythink.basead.e.a aVar = f.this.f5985h;
                        if (aVar != null) {
                            aVar.onShowFailed(com.anythink.basead.c.f.a(com.anythink.basead.c.f.f5907k, str));
                        }
                        f.this.f5982e = null;
                    }

                    @Override // com.anythink.expressad.videocommon.d.a
                    public final void c() {
                        com.anythink.basead.e.a aVar = f.this.f5985h;
                        if (aVar != null) {
                            aVar.onAdShow();
                        }
                        com.anythink.basead.e.a aVar2 = f.this.f5985h;
                        if (aVar2 != null && (aVar2 instanceof com.anythink.basead.e.g)) {
                            ((com.anythink.basead.e.g) aVar2).onVideoAdPlayStart();
                        }
                        f.this.f5982e = null;
                    }

                    @Override // com.anythink.expressad.videocommon.d.a
                    public final void d() {
                        com.anythink.basead.e.a aVar = f.this.f5985h;
                        if (aVar == null || !(aVar instanceof com.anythink.basead.e.g)) {
                            return;
                        }
                        ((com.anythink.basead.e.g) aVar).onVideoAdPlayEnd();
                    }

                    @Override // com.anythink.expressad.videocommon.d.a
                    public final void e() {
                    }

                    @Override // com.anythink.expressad.videocommon.d.a
                    public final void f() {
                    }

                    @Override // com.anythink.expressad.videocommon.d.a
                    public final void a(final com.anythink.expressad.foundation.d.c cVar) {
                        com.anythink.core.common.k.b.a.a().a(new Runnable() { // from class: com.anythink.basead.d.f.1.1
                            @Override // java.lang.Runnable
                            public final void run() {
                                AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                                f.this.a(cVar, string);
                            }
                        });
                    }
                });
                ((com.anythink.expressad.reward.b.a) this.f5983f).a(activity, "", "", "", this.f5980c);
                return;
            }
            com.anythink.basead.e.b.a().a(strA, new b.InterfaceC0141b() { // from class: com.anythink.basead.d.f.2
                @Override // com.anythink.basead.e.b.InterfaceC0141b
                public final void a() {
                    com.anythink.basead.e.a aVar = f.this.f5985h;
                    if (aVar != null) {
                        aVar.onAdShow();
                    }
                    f.this.f5982e = null;
                }

                @Override // com.anythink.basead.e.b.InterfaceC0141b
                public final void b() {
                    com.anythink.basead.e.a aVar = f.this.f5985h;
                    if (aVar == null || !(aVar instanceof com.anythink.basead.e.g)) {
                        return;
                    }
                    ((com.anythink.basead.e.g) aVar).onVideoAdPlayStart();
                }

                @Override // com.anythink.basead.e.b.InterfaceC0141b
                public final void c() {
                    com.anythink.basead.e.a aVar = f.this.f5985h;
                    if (aVar == null || !(aVar instanceof com.anythink.basead.e.g)) {
                        return;
                    }
                    ((com.anythink.basead.e.g) aVar).onVideoAdPlayEnd();
                }

                @Override // com.anythink.basead.e.b.InterfaceC0141b
                public final void d() {
                    com.anythink.basead.e.a aVar = f.this.f5985h;
                    if (aVar == null || !(aVar instanceof com.anythink.basead.e.g)) {
                        return;
                    }
                    ((com.anythink.basead.e.g) aVar).onRewarded();
                }

                @Override // com.anythink.basead.e.b.InterfaceC0141b
                public final void e() {
                    com.anythink.basead.e.a aVar = f.this.f5985h;
                    if (aVar != null) {
                        aVar.onAdClosed();
                    }
                    com.anythink.basead.e.b.a().b(strA);
                }

                @Override // com.anythink.basead.e.b.InterfaceC0141b
                public final void a(com.anythink.basead.c.e eVar) {
                    com.anythink.basead.e.a aVar = f.this.f5985h;
                    if (aVar != null) {
                        aVar.onShowFailed(eVar);
                    }
                    f.this.f5982e = null;
                }

                @Override // com.anythink.basead.e.b.InterfaceC0141b
                public final void a(int i2) {
                    com.anythink.basead.e.a aVar = f.this.f5985h;
                    if (aVar != null) {
                        aVar.onAdClick(i2);
                    }
                }

                @Override // com.anythink.basead.e.b.InterfaceC0141b
                public final void a(boolean z2) {
                    com.anythink.basead.e.a aVar = f.this.f5985h;
                    if (aVar != null) {
                        aVar.onDeeplinkCallback(z2);
                    }
                }
            });
            com.anythink.core.basead.b.a aVar = new com.anythink.core.basead.b.a();
            aVar.f6586c = this.f5982e;
            aVar.f6587d = strA;
            aVar.a = 1;
            aVar.f6591h = this.f5980c;
            aVar.f6588e = iIntValue;
            aVar.b = string;
            BaseAdActivity.a(activity, aVar);
        } catch (Exception e2) {
            e2.printStackTrace();
            com.anythink.basead.e.a aVar2 = this.f5985h;
            if (aVar2 != null) {
                aVar2.onShowFailed(com.anythink.basead.c.f.a("-9999", e2.getMessage()));
            }
            this.f5982e = null;
        }
    }

    @Override // com.anythink.basead.d.b
    public final void b() {
        super.b();
        this.f5985h = null;
    }
}
