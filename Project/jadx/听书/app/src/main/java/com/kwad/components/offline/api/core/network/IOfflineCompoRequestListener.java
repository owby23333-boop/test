package com.kwad.components.offline.api.core.network;

import com.kwad.components.offline.api.core.network.IOfflineCompoRequest;
import com.kwad.components.offline.api.core.network.model.BaseOfflineCompoResultData;

/* JADX INFO: loaded from: classes4.dex */
public interface IOfflineCompoRequestListener<R extends IOfflineCompoRequest, T extends BaseOfflineCompoResultData> {
    void onError(R r, int i, String str);

    void onStartRequest(R r);

    void onSuccess(R r, T t);
}
