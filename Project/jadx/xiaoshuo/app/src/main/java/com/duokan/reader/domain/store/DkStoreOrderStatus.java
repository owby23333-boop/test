package com.duokan.reader.domain.store;

import java.io.Serializable;

/* JADX INFO: loaded from: classes3.dex */
public enum DkStoreOrderStatus implements Serializable {
    UNKOWN,
    UNPAID,
    PAID,
    CANCELLED,
    FROZEN,
    PRICE_CHANGED
}
