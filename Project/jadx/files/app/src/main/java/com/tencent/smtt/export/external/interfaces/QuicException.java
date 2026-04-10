package com.tencent.smtt.export.external.interfaces;

/* JADX INFO: loaded from: classes3.dex */
public abstract class QuicException extends NetworkException {
    protected QuicException(String str, Throwable th) {
        super(str, th);
    }

    public abstract int getQuicDetailedErrorCode();
}
