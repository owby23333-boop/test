package com.kwad.sdk.commercial.h;

import android.content.Context;
import com.kwad.sdk.core.c.b;
import com.kwad.sdk.core.c.d;
import com.kwad.sdk.core.d.c;
import com.kwad.sdk.i.g;
import com.kwad.sdk.i.h;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.a.f;
import com.kwad.sdk.utils.bd;
import com.kwad.sdk.utils.bg;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes4.dex */
public final class a implements com.kwad.sdk.core.d.a.a {
    private final AtomicBoolean mHasInit;

    @Override // com.kwad.sdk.core.d.a.a
    public final void printStackTraceOnly(Throwable th) {
    }

    /* synthetic */ a(byte b) {
        this();
    }

    private a() {
        this.mHasInit = new AtomicBoolean(false);
    }

    /* JADX INFO: renamed from: com.kwad.sdk.commercial.h.a$a, reason: collision with other inner class name */
    static final class C0389a {
        private static final a awo = new a(0);
    }

    public static a Ea() {
        return C0389a.awo;
    }

    public static void register() {
        c.a(Ea());
    }

    public final void cS(String str) {
        try {
            if (this.mHasInit.get()) {
                return;
            }
            Context contextPp = ServiceProvider.Pp();
            final f fVar = (f) ServiceProvider.get(f.class);
            h.Nd().a(str, g.MY().gb(ServiceProvider.getSDKConfig().appId).gc(ServiceProvider.getSdkVersion()).gd(bd.getOaid()).gg(bd.m618do(contextPp)).ge(bd.getDeviceId()).gf(bd.dp(contextPp)).m(fVar.Bs()).bL(com.kwad.sdk.components.g.encryptDisable()).gh(fVar.Br()).h(fVar.Bu()).n(fVar.Bt()), new com.kwad.sdk.i.f() { // from class: com.kwad.sdk.commercial.h.a.1
                @Override // com.kwad.sdk.i.f
                public final String as(String str2) {
                    return fVar.as(str2);
                }

                @Override // com.kwad.sdk.i.f
                public final void a(String str2, Map<String, String> map, String str3) {
                    fVar.a(str2, map, str3);
                }
            });
            b.Ho();
            b.a(new d() { // from class: com.kwad.sdk.commercial.h.a.2
                @Override // com.kwad.sdk.core.c.d, com.kwad.sdk.core.c.c
                public final void onBackToForeground() {
                    super.onBackToForeground();
                    com.kwad.sdk.utils.h.schedule(new bg() { // from class: com.kwad.sdk.commercial.h.a.2.1
                        @Override // com.kwad.sdk.utils.bg
                        public final void doTask() {
                            h.Nd().Ne();
                        }
                    }, 3L, TimeUnit.SECONDS);
                }

                @Override // com.kwad.sdk.core.c.d, com.kwad.sdk.core.c.c
                public final void onBackToBackground() {
                    super.onBackToBackground();
                }
            });
            this.mHasInit.set(true);
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    @Override // com.kwad.sdk.core.d.a.a
    public final void v(String str, String str2) {
        h.Nd().f("v", str, str2);
    }

    @Override // com.kwad.sdk.core.d.a.a
    public final void v(String str, String str2, boolean z) {
        h.Nd().f("v", str, str2);
    }

    @Override // com.kwad.sdk.core.d.a.a
    public final void d(String str, String str2) {
        h.Nd().f("d", str, str2);
    }

    @Override // com.kwad.sdk.core.d.a.a
    public final void i(String str, String str2) {
        h.Nd().f("i", str, str2);
    }

    @Override // com.kwad.sdk.core.d.a.a
    public final void w(String str, String str2) {
        h.Nd().f("w", str, str2);
    }

    @Override // com.kwad.sdk.core.d.a.a
    public final void w(String str, String str2, boolean z) {
        h.Nd().f("w", str, str2);
    }

    @Override // com.kwad.sdk.core.d.a.a
    public final void e(String str, String str2) {
        h.Nd().f("e", str, str2);
    }
}
