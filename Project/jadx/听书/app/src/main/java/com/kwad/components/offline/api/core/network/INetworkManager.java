package com.kwad.components.offline.api.core.network;

import android.content.Context;

/* JADX INFO: loaded from: classes3.dex */
public interface INetworkManager {
    void addNetworkChangeListener(Context context, INetworkChangeListener iNetworkChangeListener);

    int getNetworkType(Context context);

    void removeNetworkChangeListener(Context context, INetworkChangeListener iNetworkChangeListener);
}
