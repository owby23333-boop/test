package com.github.gzuliyujiang.oaid.impl;

import com.github.gzuliyujiang.oaid.IGetter;
import com.github.gzuliyujiang.oaid.IOAID;
import com.github.gzuliyujiang.oaid.OAIDException;

/* JADX INFO: loaded from: classes3.dex */
class DefaultImpl implements IOAID {
    @Override // com.github.gzuliyujiang.oaid.IOAID
    public boolean supported() {
        return false;
    }

    DefaultImpl() {
    }

    @Override // com.github.gzuliyujiang.oaid.IOAID
    public void doGet(final IGetter getter) {
        if (getter == null) {
            return;
        }
        getter.onOAIDGetError(new OAIDException("Unsupported"));
    }
}
