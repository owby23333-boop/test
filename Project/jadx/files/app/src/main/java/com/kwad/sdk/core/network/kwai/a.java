package com.kwad.sdk.core.network.kwai;

import android.util.Log;
import com.kwad.sdk.export.proxy.AdHttpProxy;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.kwai.f;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes3.dex */
public final class a {
    private static AdHttpProxy agK;

    /* JADX INFO: renamed from: com.kwad.sdk.core.network.kwai.a$a, reason: collision with other inner class name */
    public static class C0442a {
        public String msg;
    }

    public static boolean a(String str, OutputStream outputStream, C0442a c0442a, int i2) {
        boolean zWv = wv();
        AdHttpProxy adHttpProxySq = agK;
        if (adHttpProxySq == null) {
            com.kwad.sdk.core.d.b.d("VideoCacheHelper", "isAdCacheEnable:" + zWv);
            adHttpProxySq = zWv ? com.kwad.sdk.b.sq() : new com.kwad.sdk.core.network.b.a();
            agK = adHttpProxySq;
        }
        if (com.kwad.b.a.a.bI.booleanValue()) {
            com.kwad.sdk.core.d.b.d("VideoCacheHelper", adHttpProxySq instanceof com.kwad.sdk.core.network.b.b ? "okHttp" : "Http");
        }
        try {
            com.kwad.sdk.core.d.b.d("VideoCacheHelper", "downloadUrlToStream success size:" + i2 + " url:" + str);
            adHttpProxySq.downloadUrlToStream(str, outputStream, i2);
            return true;
        } catch (Exception e2) {
            com.kwad.sdk.core.d.b.d("VideoCacheHelper", Log.getStackTraceString(e2));
            c0442a.msg = e2.getMessage();
            return false;
        }
    }

    private static boolean wv() {
        f fVar = (f) ServiceProvider.get(f.class);
        if (fVar != null) {
            return fVar.tc();
        }
        return false;
    }
}
