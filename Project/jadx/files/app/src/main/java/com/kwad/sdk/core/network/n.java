package com.kwad.sdk.core.network;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.network.NormalResultData;
import com.kwad.sdk.core.network.o;

/* JADX INFO: loaded from: classes3.dex */
public abstract class n<R extends o, T extends NormalResultData> extends a<R> {
    private static final String TAG = "NormalNetworking";

    @Nullable
    private h<R, T> mListener = null;

    private void onRequest(@NonNull h<R, T> hVar) {
        this.mListener = hVar;
    }

    @Override // com.kwad.sdk.core.network.a
    protected void cancel() {
        super.cancel();
        this.mListener = null;
    }

    protected abstract T createResponseData();

    @Override // com.kwad.sdk.core.network.a
    protected void fetchImpl() {
        String str;
        R rCreateRequest = createRequest();
        c cVar = null;
        try {
            String url = rCreateRequest.getUrl();
            cVar = rCreateRequest.getMethod().equals("POST") ? com.kwad.sdk.b.sq().doPost(url, rCreateRequest.getHeader(), rCreateRequest.getBody()) : com.kwad.sdk.b.sq().doGet(url, rCreateRequest.getHeader());
            if (cVar == null || cVar.code != 200) {
                str = "normal request failed";
            } else {
                str = "normal request success:" + cVar.code;
            }
            com.kwad.sdk.core.d.b.d(TAG, str);
        } catch (Exception e2) {
            com.kwad.sdk.core.d.b.printStackTrace(e2);
            if (cVar == null) {
                cVar = new c();
            }
            cVar.code = -1;
            cVar.afJ = e2;
        }
        onResponse((o) rCreateRequest, cVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.core.network.a
    public void onResponse(R r2, c cVar) {
        if (this.mListener == null) {
            return;
        }
        if (cVar.wn()) {
            NormalResultData normalResultDataCreateResponseData = createResponseData();
            parseResponse(normalResultDataCreateResponseData, cVar);
            this.mListener.onSuccess(r2, normalResultDataCreateResponseData);
        } else {
            h<R, T> hVar = this.mListener;
            int i2 = cVar.code;
            Exception exc = cVar.afJ;
            hVar.onError(r2, i2, exc != null ? exc.getMessage() : "");
        }
    }

    protected void parseResponse(T t2, c cVar) {
        t2.parseResponse(cVar);
    }

    public void request(@NonNull h<R, T> hVar) {
        onRequest(hVar);
        fetch();
    }
}
