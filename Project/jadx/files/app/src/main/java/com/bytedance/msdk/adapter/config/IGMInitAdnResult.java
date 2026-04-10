package com.bytedance.msdk.adapter.config;

import androidx.annotation.NonNull;
import com.bytedance.msdk.api.AdError;

/* JADX INFO: loaded from: classes2.dex */
public interface IGMInitAdnResult {
    void fail(@NonNull AdError adError);

    void success();
}
