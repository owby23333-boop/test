package com.kwad.sdk.core.network;

import com.kwad.sdk.core.network.NormalResultData;
import com.kwad.sdk.core.network.n;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.bw;

/* JADX INFO: loaded from: classes4.dex */
public abstract class m<R extends n, T extends NormalResultData> extends a<R> {
    private static final String TAG = "NormalNetworking";
    private g<R, T> mListener = null;

    protected abstract T createResponseData();

    @Override // com.kwad.sdk.core.network.a
    protected void fetchImpl() {
        c cVar;
        R rCreateRequest = createRequest();
        try {
            String url = rCreateRequest.getUrl();
            if (rCreateRequest.getMethod().equals("POST")) {
                cVar = com.kwad.sdk.g.AI().doPost(url, rCreateRequest.getHeader(), rCreateRequest.getBody());
            } else {
                cVar = com.kwad.sdk.g.AI().doGet(url, rCreateRequest.getHeader());
            }
            if (cVar != null && cVar.code == 200) {
                com.kwad.sdk.core.d.c.d(TAG, "normal request success:" + cVar.code);
            } else {
                com.kwad.sdk.core.d.c.d(TAG, "normal request failed");
            }
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.printStackTrace(e);
            cVar = 0 == 0 ? new c() : null;
            cVar.code = -1;
            cVar.aEj = e;
        }
        onResponse((n) rCreateRequest, cVar);
    }

    public void request(g<R, T> gVar) {
        try {
            onRequest(gVar);
            fetch();
        } catch (Throwable th) {
            gVar.onError(null, e.aEv.errorCode, bw.s(th));
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    private void onRequest(g<R, T> gVar) {
        this.mListener = gVar;
    }

    @Override // com.kwad.sdk.core.network.a
    protected void cancel() {
        super.cancel();
        this.mListener = null;
    }

    protected void parseResponse(T t, c cVar) {
        t.parseResponse(cVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.core.network.a
    public void onResponse(R r, c cVar) {
        if (this.mListener == null) {
            return;
        }
        if (cVar.Hx()) {
            NormalResultData normalResultDataCreateResponseData = createResponseData();
            parseResponse(normalResultDataCreateResponseData, cVar);
            this.mListener.onSuccess(r, normalResultDataCreateResponseData);
            return;
        }
        this.mListener.onError(r, cVar.code, cVar.aEj != null ? cVar.aEj.getMessage() : "");
    }
}
