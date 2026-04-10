package com.amgcyo.cuttadon.j.itemdecoration;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: Extentions.kt */
/* JADX INFO: loaded from: classes.dex */
public final class b {
    public static final int a(@NotNull RecyclerView recyclerView) {
        RecyclerView.Adapter adapter = recyclerView.getAdapter();
        if (adapter != null) {
            return adapter.getItemCount();
        }
        return 0;
    }

    public static final int b(@NotNull GridLayoutManager gridLayoutManager, int i2) {
        return gridLayoutManager.getSpanSizeLookup().getSpanSize(i2);
    }

    public static final int a(@NotNull RecyclerView recyclerView, int i2) {
        RecyclerView.Adapter adapter = recyclerView.getAdapter();
        if (adapter != null) {
            return adapter.getItemViewType(i2);
        }
        return -1;
    }

    public static final int a(@NotNull GridLayoutManager gridLayoutManager, int i2) {
        return gridLayoutManager.getSpanSizeLookup().getSpanIndex(i2, gridLayoutManager.getSpanCount());
    }
}
