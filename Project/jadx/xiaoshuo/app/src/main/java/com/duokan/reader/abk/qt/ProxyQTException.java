package com.duokan.reader.abk.qt;

import fm.qingting.qtsdk.QTException;

/* JADX INFO: loaded from: classes2.dex */
public class ProxyQTException extends QTException {
    public ProxyQTException(QTException qTException) {
        super(qTException.getMessage(), qTException.getErrorCode());
    }
}
