package com.bytedance.android.live.base.api.outer;

/* JADX INFO: loaded from: classes2.dex */
public interface ILiveStatusListener {
    void onError(String str);

    void onFirstFrame();

    void onLiveStatusChange(boolean z2);

    void onPrepare();

    void onVideoSizeChanged(int i2, int i3);
}
