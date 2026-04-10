package com.kwad.sdk.export.proxy;

/* JADX INFO: loaded from: classes4.dex */
public interface AdHttpResponseListener {
    boolean onReadProgress(long j, long j2);

    void onResponseEnd();

    void onResponseStart();
}
