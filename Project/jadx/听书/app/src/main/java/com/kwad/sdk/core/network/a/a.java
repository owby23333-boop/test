package com.kwad.sdk.core.network.a;

import android.util.Log;
import com.kwad.sdk.export.proxy.AdHttpProxy;
import com.kwad.sdk.export.proxy.AdHttpResponseListener;
import com.kwad.sdk.g;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.a.h;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes4.dex */
public final class a {
    private static AdHttpProxy aFm;

    /* JADX INFO: renamed from: com.kwad.sdk.core.network.a.a$a, reason: collision with other inner class name */
    public static class C0405a {
        public String msg;
    }

    private static boolean HC() {
        h hVar = (h) ServiceProvider.get(h.class);
        if (hVar != null) {
            return hVar.BL();
        }
        return false;
    }

    public static boolean a(String str, OutputStream outputStream, C0405a c0405a, long j, boolean z, AdHttpResponseListener adHttpResponseListener) {
        AdHttpProxy aVar;
        boolean zHC = HC();
        AdHttpProxy adHttpProxy = aFm;
        if (adHttpProxy == null) {
            com.kwad.sdk.core.d.c.d("VideoCacheHelper", "isAdCacheEnable:" + zHC);
            if (zHC) {
                aVar = g.AI();
            } else {
                aVar = new com.kwad.sdk.core.network.c.a();
            }
            adHttpProxy = aVar;
            aFm = adHttpProxy;
        }
        AdHttpProxy adHttpProxy2 = adHttpProxy;
        if (com.kwad.framework.b.a.oz.booleanValue()) {
            if (adHttpProxy2 instanceof com.kwad.sdk.core.network.c.b) {
                com.kwad.sdk.core.d.c.d("VideoCacheHelper", "okHttp");
            } else {
                com.kwad.sdk.core.d.c.d("VideoCacheHelper", "Http");
            }
        }
        try {
            com.kwad.sdk.core.d.c.d("VideoCacheHelper", "downloadUrlToStream success size:" + j + " url:" + str);
            adHttpProxy2.downloadUrlToStream(str, outputStream, j, z, adHttpResponseListener);
            return true;
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.d("VideoCacheHelper", Log.getStackTraceString(e));
            c0405a.msg = e.getMessage();
            return false;
        }
    }
}
