package me.drakeet.multitype;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import java.util.List;

/* JADX INFO: compiled from: ItemViewBinder.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class b<T, VH extends RecyclerView.ViewHolder> {
    d a;

    protected long a(@NonNull T t2) {
        return -1L;
    }

    @NonNull
    protected abstract VH a(@NonNull LayoutInflater layoutInflater, @NonNull ViewGroup viewGroup);

    protected abstract void a(@NonNull VH vh, @NonNull T t2);

    protected void a(@NonNull VH vh, @NonNull T t2, @NonNull List<Object> list) {
        a(vh, t2);
    }

    protected boolean a(@NonNull VH vh) {
        return false;
    }

    protected void b(@NonNull VH vh) {
    }

    protected void c(@NonNull VH vh) {
    }

    protected void d(@NonNull VH vh) {
    }
}
