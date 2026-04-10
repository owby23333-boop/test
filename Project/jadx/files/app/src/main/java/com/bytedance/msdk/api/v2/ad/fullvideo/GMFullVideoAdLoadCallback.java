package com.bytedance.msdk.api.v2.ad.fullvideo;

import androidx.annotation.NonNull;
import com.bytedance.msdk.api.AdError;

/* JADX INFO: loaded from: classes2.dex */
public interface GMFullVideoAdLoadCallback {
    void onFullVideoAdLoad();

    void onFullVideoCached();

    void onFullVideoLoadFail(@NonNull AdError adError);
}
