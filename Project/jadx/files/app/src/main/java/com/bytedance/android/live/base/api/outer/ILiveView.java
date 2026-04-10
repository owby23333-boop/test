package com.bytedance.android.live.base.api.outer;

import android.view.View;

/* JADX INFO: loaded from: classes2.dex */
public interface ILiveView {
    View getView();

    void openLive();

    void release();

    void setLiveStatusListener(ILiveStatusListener iLiveStatusListener);

    void setMute(boolean z2);

    void show();

    void stream();
}
