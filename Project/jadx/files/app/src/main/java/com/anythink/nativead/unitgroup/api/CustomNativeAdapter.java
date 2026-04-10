package com.anythink.nativead.unitgroup.api;

import com.anythink.core.api.ATBaseAdAdapter;

/* JADX INFO: loaded from: classes2.dex */
public abstract class CustomNativeAdapter extends ATBaseAdAdapter {
    protected int mRequestNum = 1;

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public final boolean isAdReady() {
        return false;
    }

    public void setRequestNum(int i2) {
        if (i2 > 0) {
            this.mRequestNum = i2;
        }
    }
}
