package com.kwad.sdk.api.loader;

import android.content.Context;
import android.text.TextUtils;
import com.kwad.sdk.api.core.IKsAdSDK;
import com.kwad.sdk.api.loader.m;
import com.umeng.analytics.pro.am;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
public final class u {
    private static final AtomicBoolean aat = new AtomicBoolean();

    public static void a(final Context context, final IKsAdSDK iKsAdSDK) {
        if (com.kwad.sdk.api.c.tw() || aat.get() || context == null || iKsAdSDK == null) {
            return;
        }
        aat.set(true);
        com.kwad.sdk.api.kwai.a.submit(new Runnable() { // from class: com.kwad.sdk.api.loader.u.1
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    if (Math.abs(System.currentTimeMillis() - t.t(context, "lastUpdateTime")) < t.t(context, am.aU) * 1000) {
                        return;
                    }
                    m.tH().a(new v() { // from class: com.kwad.sdk.api.loader.u.1.1
                        @Override // com.kwad.sdk.api.loader.v
                        public final Context getContext() {
                            return context;
                        }

                        @Override // com.kwad.sdk.api.loader.v
                        public final String tK() {
                            return u.tJ();
                        }

                        @Override // com.kwad.sdk.api.loader.v
                        public final IKsAdSDK tL() {
                            return iKsAdSDK;
                        }
                    }, new m.c<Boolean>() { // from class: com.kwad.sdk.api.loader.u.1.2
                        private static void a(Boolean bool) {
                            new StringBuilder("onNewResult: ").append(bool);
                        }

                        @Override // com.kwad.sdk.api.loader.m.c
                        public final /* synthetic */ void b(Boolean bool) {
                            a(bool);
                        }
                    });
                } catch (Throwable unused) {
                }
            }
        });
    }

    public static void aE(Context context) {
        g.h(context, "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String tJ() {
        String strAP = com.kwad.sdk.api.c.aP("https://open.e.kuaishou.com/rest/e/v3/open/sdk2");
        return !TextUtils.isEmpty(strAP) ? strAP : "https://open.e.kuaishou.com/rest/e/v3/open/sdk2";
    }
}
