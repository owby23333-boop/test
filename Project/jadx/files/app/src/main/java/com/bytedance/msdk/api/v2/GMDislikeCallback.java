package com.bytedance.msdk.api.v2;

import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public interface GMDislikeCallback {
    void onCancel();

    void onRefuse();

    void onSelected(int i2, @Nullable String str);

    void onShow();
}
