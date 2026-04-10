package com.kwad.sdk.ranger;

import okhttp3.EventListener;

/* JADX INFO: loaded from: classes3.dex */
public final class b implements EventListener.Factory {
    EventListener axi;
    a axj;

    public interface a {
    }

    public b(Object obj, a aVar) {
        this.axi = (EventListener) obj;
        this.axj = aVar;
    }
}
