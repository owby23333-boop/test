package com.github.gzuliyujiang.oaid;

import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes7.dex */
public interface IGetter {
    void onOAIDGetComplete(@NonNull String str);

    void onOAIDGetError(@NonNull Throwable th);
}
