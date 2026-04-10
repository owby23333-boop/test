package com.repack.bun.supplier;

import androidx.annotation.Keep;

/* JADX INFO: loaded from: classes3.dex */
public interface InnerIdSupplier extends IdSupplier {
    void a(SupplierListener supplierListener);

    /* JADX INFO: renamed from: do */
    boolean mo6do();

    @Keep
    String getUDID();

    @Keep
    void shutDown();
}
