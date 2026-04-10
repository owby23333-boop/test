package com.kwad.components.offline.api.core.soloader;

/* JADX INFO: loaded from: classes3.dex */
public interface SoLoadListener {
    void onFailed(int i2, Throwable th);

    void onLoaded();

    void onPreUpdate();
}
