package com.hannesdorfmann.adapterdelegates4;

import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes7.dex */
public abstract class AbsFallbackAdapterDelegate<T> extends AdapterDelegate<T> {
    @Override // com.hannesdorfmann.adapterdelegates4.AdapterDelegate
    public final boolean isForViewType(@NonNull Object obj, int i) {
        return true;
    }
}
