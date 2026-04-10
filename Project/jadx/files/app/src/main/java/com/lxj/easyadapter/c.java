package com.lxj.easyadapter;

import android.util.SparseArray;
import kotlin.jvm.internal.i;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: ItemDelegateManager.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class c<T> {
    private SparseArray<b<T>> a = new SparseArray<>();

    public final int a() {
        return this.a.size();
    }

    @NotNull
    public final c<T> a(@NotNull b<T> bVar) {
        this.a.put(this.a.size(), bVar);
        return this;
    }

    public final int a(T t2, int i2) {
        for (int size = this.a.size() - 1; size >= 0; size--) {
            if (this.a.valueAt(size).a(t2, i2)) {
                return this.a.keyAt(size);
            }
        }
        throw new IllegalArgumentException("No ItemDelegate added that matches position=" + i2 + " in data source");
    }

    public final void a(@NotNull ViewHolder viewHolder, T t2, int i2) {
        int size = this.a.size();
        for (int i3 = 0; i3 < size; i3++) {
            b<T> bVarValueAt = this.a.valueAt(i3);
            if (bVarValueAt.a(t2, i2)) {
                bVarValueAt.a(viewHolder, t2, i2);
                return;
            }
        }
        throw new IllegalArgumentException("No ItemDelegateManager added that matches position=" + i2 + " in data source");
    }

    @NotNull
    public final b<T> a(int i2) {
        b<T> bVar = this.a.get(i2);
        if (bVar != null) {
            return bVar;
        }
        i.a();
        throw null;
    }
}
