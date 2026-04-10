package com.bigkoo.dkconvenientbanner.holder;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: classes.dex */
public abstract class Holder<T> extends RecyclerView.ViewHolder {
    public Holder(View view) {
        super(view);
        initView(view);
    }

    public abstract void initView(View view);

    public abstract void onViewRecycled();

    public abstract void updateUI(T t);
}
