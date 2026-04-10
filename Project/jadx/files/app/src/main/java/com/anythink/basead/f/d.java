package com.anythink.basead.f;

import android.app.Activity;
import android.content.Context;
import com.anythink.basead.e.b;
import com.anythink.basead.ui.BaseAdActivity;
import com.anythink.core.common.e.j;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class d extends c {
    public static final String a = "d";

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private com.anythink.basead.e.g f6038k;

    public d(Context context, j jVar, String str, boolean z2) {
        super(context, jVar, str, z2);
    }

    public final void a(com.anythink.basead.e.g gVar) {
        this.f6038k = gVar;
    }

    @Override // com.anythink.basead.f.a
    public final void a(Activity activity, Map<String, Object> map) {
        try {
            if (this.f6033c == null) {
                if (this.f6038k != null) {
                    this.f6038k.onShowFailed(com.anythink.basead.c.f.a(com.anythink.basead.c.f.f5905i, com.anythink.basead.c.f.B));
                    return;
                }
                return;
            }
            map.get(c.f6030h);
            String string = map.get("extra_scenario").toString();
            int iIntValue = ((Integer) map.get(c.f6032j)).intValue();
            final String str = this.f6034d.b + this.f6035e + System.currentTimeMillis();
            com.anythink.basead.e.b.a().a(str, new b.InterfaceC0141b() { // from class: com.anythink.basead.f.d.1
                @Override // com.anythink.basead.e.b.InterfaceC0141b
                public final void a() {
                    if (d.this.f6038k != null) {
                        d.this.f6038k.onAdShow();
                    }
                }

                @Override // com.anythink.basead.e.b.InterfaceC0141b
                public final void b() {
                    if (d.this.f6038k != null) {
                        d.this.f6038k.onVideoAdPlayStart();
                    }
                }

                @Override // com.anythink.basead.e.b.InterfaceC0141b
                public final void c() {
                    if (d.this.f6038k != null) {
                        d.this.f6038k.onVideoAdPlayEnd();
                    }
                }

                @Override // com.anythink.basead.e.b.InterfaceC0141b
                public final void d() {
                }

                @Override // com.anythink.basead.e.b.InterfaceC0141b
                public final void e() {
                    if (d.this.f6038k != null) {
                        d.this.f6038k.onAdClosed();
                    }
                    com.anythink.basead.e.b.a().b(str);
                }

                @Override // com.anythink.basead.e.b.InterfaceC0141b
                public final void a(com.anythink.basead.c.e eVar) {
                    new StringBuilder("onVideoShowFailed.......").append(eVar.c());
                    if (d.this.f6038k != null) {
                        d.this.f6038k.onShowFailed(eVar);
                    }
                }

                @Override // com.anythink.basead.e.b.InterfaceC0141b
                public final void a(int i2) {
                    if (d.this.f6038k != null) {
                        d.this.f6038k.onAdClick(i2);
                    }
                }

                @Override // com.anythink.basead.e.b.InterfaceC0141b
                public final void a(boolean z2) {
                    if (d.this.f6038k != null) {
                        d.this.f6038k.onDeeplinkCallback(z2);
                    }
                }
            });
            com.anythink.core.basead.b.a aVar = new com.anythink.core.basead.b.a();
            aVar.f6586c = this.f6037g;
            aVar.f6587d = str;
            aVar.a = 3;
            aVar.f6591h = this.f6034d;
            aVar.f6588e = iIntValue;
            aVar.b = string;
            BaseAdActivity.a(activity, aVar);
        } catch (Exception e2) {
            e2.printStackTrace();
            com.anythink.basead.e.g gVar = this.f6038k;
            if (gVar != null) {
                gVar.onShowFailed(com.anythink.basead.c.f.a("-9999", e2.getMessage()));
            }
        }
    }
}
