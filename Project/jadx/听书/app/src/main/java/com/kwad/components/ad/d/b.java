package com.kwad.components.ad.d;

import android.text.TextUtils;
import com.kwad.components.ad.reward.monitor.c;
import com.kwad.components.core.video.k;
import com.kwad.sdk.core.network.a.a;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.AdVideoPreCacheConfig;
import com.kwad.sdk.core.videocache.f;
import com.kwad.sdk.export.proxy.AdHttpResponseListener;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.w;
import java.io.File;

/* JADX INFO: loaded from: classes3.dex */
public final class b {
    public static boolean a(AdTemplate adTemplate, boolean z, final AdVideoPreCacheConfig adVideoPreCacheConfig, final a aVar) {
        String str;
        String strK = com.kwad.sdk.core.response.b.a.K(e.el(adTemplate));
        if (TextUtils.isEmpty(strK)) {
            return false;
        }
        final long adVideoPreCacheSize = ((long) adVideoPreCacheConfig.getAdVideoPreCacheSize()) * 1024;
        boolean zA = true;
        if (adVideoPreCacheSize > 0) {
            long j = adVideoPreCacheConfig.isContinueLoadingAll() ? -1L : adVideoPreCacheSize;
            a.C0405a c0405a = new a.C0405a();
            f fVarBR = com.kwad.sdk.core.videocache.c.a.bR(ServiceProvider.getContext());
            if (fVarBR.eK(strK)) {
                a(aVar);
            } else {
                zA = fVarBR.a(strK, j, c0405a, new AdHttpResponseListener() { // from class: com.kwad.components.ad.d.b.1
                    private boolean cg = false;

                    @Override // com.kwad.sdk.export.proxy.AdHttpResponseListener
                    public final void onResponseEnd() {
                    }

                    @Override // com.kwad.sdk.export.proxy.AdHttpResponseListener
                    public final void onResponseStart() {
                    }

                    @Override // com.kwad.sdk.export.proxy.AdHttpResponseListener
                    public final boolean onReadProgress(long j2, long j3) {
                        if ((j2 >= adVideoPreCacheSize || j2 >= j3) && !this.cg) {
                            this.cg = true;
                            b.a(aVar);
                            if (!adVideoPreCacheConfig.isContinueLoadingAll()) {
                                return true;
                            }
                        }
                        return false;
                    }
                });
            }
            str = c0405a.msg;
        } else {
            str = "";
            if (adVideoPreCacheSize < 0) {
                File fileCf = com.kwad.sdk.core.diskcache.b.a.GP().cf(strK);
                if (!w.O(fileCf)) {
                    a.C0405a c0405a2 = new a.C0405a();
                    boolean zA2 = com.kwad.sdk.core.diskcache.b.a.GP().a(strK, c0405a2);
                    str = c0405a2.msg;
                    zA = zA2;
                }
                adTemplate.setDownloadSize(fileCf != null ? fileCf.length() : 0L);
                if (zA) {
                    a(aVar);
                }
            } else {
                a(aVar);
            }
        }
        if (zA) {
            k.m(strK, adVideoPreCacheConfig.getAdVideoPreCacheSize());
        } else {
            c.a(z, adTemplate, str);
            com.kwad.components.ad.reward.monitor.b.a(z, adTemplate);
            a(aVar, str);
        }
        return zA;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(a aVar) {
        if (aVar == null) {
            return;
        }
        aVar.af();
    }

    private static void a(a aVar, String str) {
        if (aVar == null) {
            return;
        }
        aVar.ag();
    }
}
