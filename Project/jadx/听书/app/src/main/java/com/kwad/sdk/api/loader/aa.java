package com.kwad.sdk.api.loader;

import android.content.Context;
import android.text.TextUtils;
import com.kwad.sdk.api.core.IKsAdSDK;
import com.kwad.sdk.api.loader.s;
import com.umeng.analytics.pro.an;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes4.dex */
public final class aa {
    private static final AtomicBoolean auM = new AtomicBoolean();

    public static void a(final Context context, final IKsAdSDK iKsAdSDK) {
        if (com.kwad.sdk.api.c.De()) {
            return;
        }
        AtomicBoolean atomicBoolean = auM;
        if (atomicBoolean.get() || context == null || iKsAdSDK == null) {
            return;
        }
        atomicBoolean.set(true);
        com.kwad.sdk.api.a.a.a(new com.kwad.sdk.api.a.b() { // from class: com.kwad.sdk.api.loader.aa.1
            @Override // com.kwad.sdk.api.a.b
            public final void doTask() {
                try {
                    if (Math.abs(System.currentTimeMillis() - b.o(context, "lastUpdateTime")) < b.o(context, an.aU) * 1000) {
                        return;
                    }
                    s.Ds().a(new ab() { // from class: com.kwad.sdk.api.loader.aa.1.1
                        @Override // com.kwad.sdk.api.loader.ab
                        public final Context getContext() {
                            return context;
                        }

                        @Override // com.kwad.sdk.api.loader.ab
                        public final String Du() {
                            return aa.Dt();
                        }

                        @Override // com.kwad.sdk.api.loader.ab
                        public final IKsAdSDK Dv() {
                            return iKsAdSDK;
                        }
                    }, new s.c<Boolean>() { // from class: com.kwad.sdk.api.loader.aa.1.2
                        @Override // com.kwad.sdk.api.loader.s.c
                        public final /* synthetic */ void j(Boolean bool) {
                            c(bool);
                        }

                        private static void c(Boolean bool) {
                            new StringBuilder("onNewResult: ").append(bool);
                        }
                    });
                } catch (Throwable unused) {
                }
            }
        });
    }

    public static void be(Context context) {
        i.p(context, "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String Dt() {
        String strCm = com.kwad.sdk.api.c.cm("https://open.e.kuaishou.com/rest/e/v3/open/sdk2");
        return !TextUtils.isEmpty(strCm) ? strCm : "https://open.e.kuaishou.com/rest/e/v3/open/sdk2";
    }
}
