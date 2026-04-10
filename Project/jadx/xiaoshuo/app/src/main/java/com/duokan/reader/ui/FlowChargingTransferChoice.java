package com.duokan.reader.ui;

import com.yuewen.rd2;

/* JADX INFO: loaded from: classes5.dex */
public enum FlowChargingTransferChoice {
    Default,
    Transfer,
    NoTransfer;

    public rd2<Boolean> wifiOnly() {
        return this == Default ? new rd2<>() : this == NoTransfer ? new rd2<>(Boolean.TRUE) : new rd2<>(Boolean.FALSE);
    }
}
