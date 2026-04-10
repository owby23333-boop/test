package com.airbnb.epoxy;

import android.widget.CompoundButton;
import com.airbnb.epoxy.EpoxyModel;

/* JADX INFO: loaded from: classes.dex */
public interface OnModelCheckedChangeListener<T extends EpoxyModel<?>, V> {
    void onChecked(T t, V v, CompoundButton compoundButton, boolean z, int i);
}
