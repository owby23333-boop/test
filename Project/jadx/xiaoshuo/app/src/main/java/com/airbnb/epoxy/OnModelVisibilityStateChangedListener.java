package com.airbnb.epoxy;

import com.airbnb.epoxy.EpoxyModel;

/* JADX INFO: loaded from: classes.dex */
public interface OnModelVisibilityStateChangedListener<T extends EpoxyModel<V>, V> {
    void onVisibilityStateChanged(T t, V v, int i);
}
