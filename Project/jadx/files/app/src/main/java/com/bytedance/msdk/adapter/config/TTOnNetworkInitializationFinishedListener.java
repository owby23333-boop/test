package com.bytedance.msdk.adapter.config;

import androidx.annotation.NonNull;
import com.bytedance.msdk.api.AdError;

/* JADX INFO: loaded from: classes2.dex */
public interface TTOnNetworkInitializationFinishedListener {
    void onNetworkInitializationFinished(@NonNull Class<? extends ITTAdapterConfiguration> cls, @NonNull AdError adError);
}
