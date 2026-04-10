package com.chad.library.adapter.base.diff;

import androidx.annotation.NonNull;
import java.util.List;

/* JADX INFO: loaded from: classes10.dex */
public interface ListChangeListener<T> {
    void onCurrentListChanged(@NonNull List<T> list, @NonNull List<T> list2);
}
