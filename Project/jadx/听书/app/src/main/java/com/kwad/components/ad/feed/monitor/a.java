package com.kwad.components.ad.feed.monitor;

import android.text.TextUtils;
import android.util.Pair;
import com.kwad.sdk.core.network.a.a;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.videocache.f;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.w;
import java.io.File;

/* JADX INFO: loaded from: classes3.dex */
public final class a {
    public static Pair<Integer, String> m(AdTemplate adTemplate) {
        String strK = com.kwad.sdk.core.response.b.a.K(e.el(adTemplate));
        if (TextUtils.isEmpty(strK)) {
            return new Pair<>(2, "empty videoUrl");
        }
        int iBQ = com.kwad.sdk.core.config.e.BQ();
        int i = 1;
        String str = "";
        if (iBQ < 0) {
            File fileCf = com.kwad.sdk.core.diskcache.b.a.GP().cf(strK);
            if (!w.O(fileCf)) {
                a.C0405a c0405a = new a.C0405a();
                int i2 = com.kwad.sdk.core.diskcache.b.a.GP().a(strK, c0405a) ? 1 : 2;
                str = c0405a.msg;
                i = i2;
            }
            adTemplate.setDownloadSize(fileCf != null ? fileCf.length() : 0L);
        } else if (iBQ > 0) {
            a.C0405a c0405a2 = new a.C0405a();
            f fVarBR = com.kwad.sdk.core.videocache.c.a.bR(ServiceProvider.getContext());
            if (!fVarBR.eL(strK)) {
                i = fVarBR.a(strK, (long) (iBQ * 1024), c0405a2, null) ? 1 : 2;
            }
            str = c0405a2.msg;
            adTemplate.setDownloadSize(iBQ * 1024);
        } else {
            adTemplate.setDownloadSize(0L);
        }
        return new Pair<>(Integer.valueOf(i), str);
    }
}
