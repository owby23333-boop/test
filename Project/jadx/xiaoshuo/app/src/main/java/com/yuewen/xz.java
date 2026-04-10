package com.yuewen;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: classes13.dex */
public abstract class xz<Data> extends RecyclerView.ViewHolder {
    public xz(@NonNull ViewGroup parent, int layoutId) {
        super(LayoutInflater.from(parent.getContext()).inflate(layoutId, parent, false));
        j();
    }

    public abstract void i(Data data);

    public abstract void j();
}
