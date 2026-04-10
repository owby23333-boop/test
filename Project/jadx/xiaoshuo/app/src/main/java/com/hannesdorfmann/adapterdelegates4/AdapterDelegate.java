package com.hannesdorfmann.adapterdelegates4;

import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

/* JADX INFO: loaded from: classes7.dex */
public abstract class AdapterDelegate<T> {
    public abstract boolean isForViewType(@NonNull T t, int i);

    public abstract void onBindViewHolder(@NonNull T t, int i, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull List<Object> list);

    @NonNull
    public abstract RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup);

    public boolean onFailedToRecycleView(@NonNull RecyclerView.ViewHolder viewHolder) {
        return false;
    }

    public void onViewAttachedToWindow(@NonNull RecyclerView.ViewHolder viewHolder) {
    }

    public void onViewDetachedFromWindow(@NonNull RecyclerView.ViewHolder viewHolder) {
    }

    public void onViewRecycled(@NonNull RecyclerView.ViewHolder viewHolder) {
    }
}
