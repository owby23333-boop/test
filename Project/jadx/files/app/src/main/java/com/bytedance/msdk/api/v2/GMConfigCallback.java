package com.bytedance.msdk.api.v2;

import androidx.annotation.Nullable;
import com.bytedance.msdk.api.AdError;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public interface GMConfigCallback {
    void onConfigLoadFail(AdError adError);

    void onConfigLoaded(@Nullable List<String> list);
}
