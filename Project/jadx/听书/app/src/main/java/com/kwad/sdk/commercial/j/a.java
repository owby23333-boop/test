package com.kwad.sdk.commercial.j;

import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.kwad.components.offline.api.core.api.ILoggerReporter;
import com.kwad.sdk.commercial.c;
import com.kwad.sdk.commercial.d;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.a.h;
import com.kwad.sdk.utils.aa;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public final class a {
    private static C0390a awv;

    /* JADX INFO: renamed from: com.kwad.sdk.commercial.j.a$a, reason: collision with other inner class name */
    public static class C0390a extends com.kwad.sdk.core.response.a.a {
        public List<String> aww;
    }

    private static void a(AdTemplate adTemplate, b bVar) {
        a(adTemplate, false, bVar);
    }

    private static void a(AdTemplate adTemplate, boolean z, b bVar) {
        if (da(bVar.awp)) {
            return;
        }
        com.kwad.sdk.commercial.b.d(c.DS().cF(z ? ILoggerReporter.Category.ERROR_LOG : ILoggerReporter.Category.APM_LOG).i(z ? 1.0d : 0.001d).b(d.be(adTemplate)).O("ad_sdk_track_performance", NotificationCompat.CATEGORY_STATUS).z(bVar));
    }

    public static void n(AdTemplate adTemplate, int i, String str) {
        try {
            a(adTemplate, b.Eg().cG(4).cH(i).db(str).setAdTemplate(adTemplate));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void a(AdTemplate adTemplate, String str, String str2, String str3, String str4) {
        try {
            com.kwad.sdk.commercial.b.d(c.DS().cF(ILoggerReporter.Category.ERROR_LOG).i(1.0d).b(d.be(adTemplate)).O("ad_sdk_macro_check_performance", "error_name").z(com.kwad.sdk.commercial.i.a.Ec().cT(str).cV(str2).cW(str3).cU(str4).setAdTemplate(adTemplate)));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void o(AdTemplate adTemplate, int i, String str) {
        try {
            a(adTemplate, b.Eg().cG(1).cH(i).db(str).setAdTemplate(adTemplate));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void a(AdTemplate adTemplate, int i, String str, int i2, int i3) {
        try {
            a(adTemplate, b.Eg().cG(2).cH(i).db(str).cI(i3).setErrorCode(i2).setAdTemplate(adTemplate));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void a(AdTemplate adTemplate, int i, String str, String str2, int i2, String str3, int i3) {
        try {
            a(adTemplate, true, b.Eg().cG(3).cH(i).db(str).dc(str2).setErrorCode(i2).setErrorMsg(str3).cI(i3).setAdTemplate(adTemplate));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    private static boolean da(String str) {
        C0390a c0390aEd;
        List<String> list;
        if (TextUtils.isEmpty(str) || (c0390aEd = Ed()) == null || (list = c0390aEd.aww) == null) {
            return false;
        }
        for (String str2 : list) {
            if (!TextUtils.isEmpty(str2) && str.contains(str2)) {
                return true;
            }
        }
        return false;
    }

    private static C0390a Ed() {
        String strBS = ((h) ServiceProvider.get(h.class)).BS();
        if (!TextUtils.isEmpty(strBS)) {
            awv = (C0390a) aa.b(strBS, new com.kwad.sdk.core.c<C0390a>() { // from class: com.kwad.sdk.commercial.j.a.1
                @Override // com.kwad.sdk.core.c
                public final /* synthetic */ com.kwad.sdk.core.b Ef() {
                    return Ee();
                }

                private static C0390a Ee() {
                    return new C0390a();
                }
            });
        }
        return awv;
    }
}
