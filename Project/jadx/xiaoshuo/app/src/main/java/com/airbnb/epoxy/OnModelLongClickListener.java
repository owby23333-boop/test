package com.airbnb.epoxy;

import android.view.View;
import com.airbnb.epoxy.EpoxyModel;

/* JADX INFO: loaded from: classes.dex */
public interface OnModelLongClickListener<T extends EpoxyModel<?>, V> {
    boolean onLongClick(T t, V v, View view, int i);
}
