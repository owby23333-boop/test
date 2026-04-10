package com.kwad.components.core.webview.jshandler;

import androidx.annotation.NonNull;
import com.kwad.components.core.webview.jshandler.ah;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class v implements com.kwad.sdk.core.webview.b.a {
    private List<c> mHolders = new ArrayList();

    static class a extends com.kwad.sdk.core.download.kwai.a {
        private c TA;

        public a(c cVar) {
            this.TA = cVar;
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onDownloadFailed() {
            v.a(this.TA, 1, 0.0f);
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onDownloadFinished() {
            v.a(this.TA, 5, 1.0f);
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onIdle() {
            v.a(this.TA, 1, 0.0f);
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onInstalled() {
            v.a(this.TA, 6, 1.0f);
        }

        @Override // com.kwad.sdk.core.download.kwai.a
        public final void onPaused(int i2) {
            v.a(this.TA, 3, (i2 * 1.0f) / 100.0f);
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onProgressUpdate(int i2) {
            v.a(this.TA, 2, (i2 * 1.0f) / 100.0f);
        }
    }

    public static class b extends com.kwad.sdk.core.response.kwai.a {
        public long creativeId = -1;
    }

    static class c {
        private com.kwad.components.core.d.b.c TB;
        private a TC;
        private AdTemplate mAdTemplate;
        private com.kwad.sdk.core.webview.b.c nK;

        public c(com.kwad.components.core.d.b.c cVar, AdTemplate adTemplate) {
            this.TB = cVar;
            this.mAdTemplate = adTemplate;
        }

        public final void a(a aVar) {
            this.TB.b(aVar);
            this.TC = aVar;
        }

        public final void destroy() {
            a aVar;
            com.kwad.components.core.d.b.c cVar = this.TB;
            if (cVar == null || (aVar = this.TC) == null) {
                return;
            }
            cVar.c(aVar);
        }

        public final long rn() {
            AdTemplate adTemplate = this.mAdTemplate;
            if (adTemplate == null) {
                return -1L;
            }
            return com.kwad.sdk.core.response.a.d.ck(adTemplate);
        }
    }

    public v(List<AdTemplate> list, List<com.kwad.components.core.d.b.c> list2) {
        if (list == null || list2 == null) {
            return;
        }
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.mHolders.add(new c(list2.get(i2), list.get(i2)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(c cVar, int i2, float f2) {
        if (cVar == null || cVar.nK == null) {
            return;
        }
        com.kwad.sdk.core.d.b.d("MultiProgressListener", "notifyDownloadProgress: " + cVar.nK + f2);
        com.kwad.sdk.core.webview.b.c cVar2 = cVar.nK;
        ah.a aVar = new ah.a();
        aVar.TX = f2;
        aVar.status = i2;
        aVar.creativeId = cVar.rn();
        aVar.totalBytes = com.kwad.sdk.core.response.a.d.cb(cVar.mAdTemplate).totalBytes;
        cVar2.a(aVar);
    }

    private c x(long j2) {
        if (j2 == -1) {
            return null;
        }
        for (c cVar : this.mHolders) {
            if (cVar.rn() == j2) {
                return cVar;
            }
        }
        return null;
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.b.c cVar) {
        if (str != null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                b bVar = new b();
                bVar.parseJson(jSONObject);
                c cVarX = x(bVar.creativeId);
                if (cVarX != null) {
                    cVarX.nK = cVar;
                    cVarX.a(new a(cVarX));
                }
            } catch (Exception unused) {
            }
        }
    }

    @Override // com.kwad.sdk.core.webview.b.a
    @NonNull
    public final String getKey() {
        return "registerMultiProgressListener";
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void onDestroy() {
        Iterator<c> it = this.mHolders.iterator();
        while (it.hasNext()) {
            it.next().destroy();
        }
    }
}
