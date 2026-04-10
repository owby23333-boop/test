package com.amgcyo.cuttadon.view.otherview;

import android.content.Context;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: classes.dex */
public class AutoLinearLayoutManager extends LinearLayoutManager {
    public AutoLinearLayoutManager(Context context) {
        super(context);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
        try {
            super.onLayoutChildren(recycler, state);
        } catch (IndexOutOfBoundsException e2) {
            e2.printStackTrace();
        }
    }
}
