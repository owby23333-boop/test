package com.repack.bun.supplier;

import androidx.annotation.Keep;

/* JADX INFO: loaded from: classes3.dex */
@Keep
public interface IdSupplier {
    @Keep
    String getAAID();

    @Keep
    String getOAID();

    @Keep
    String getVAID();

    @Keep
    boolean isSupported();
}
