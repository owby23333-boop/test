package com.kwad.components.core.n;

import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import com.kwad.components.core.response.model.AdResultData;

/* JADX INFO: loaded from: classes3.dex */
public interface h<T extends AdResultData> {
    @WorkerThread
    void a(@NonNull T t2);

    @WorkerThread
    void onError(int i2, String str);
}
