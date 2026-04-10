package com.repack.bun.supplier;

import androidx.annotation.Keep;

/* JADX INFO: loaded from: classes3.dex */
public interface IRemoteIdSupplier extends InnerIdSupplier {
    @Keep
    String getAAID(String str);

    @Keep
    String getVAID(String str);
}
