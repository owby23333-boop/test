package com.airbnb.epoxy;

import com.airbnb.epoxy.EpoxyModel;

/* JADX INFO: loaded from: classes.dex */
public interface OnModelUnboundListener<T extends EpoxyModel<?>, V> {
    void onModelUnbound(T t, V v);
}
