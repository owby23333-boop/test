package me.jessyan.art.mvp;

import android.content.Context;
import androidx.annotation.NonNull;

/* JADX INFO: compiled from: IRepositoryManager.java */
/* JADX INFO: loaded from: classes3.dex */
public interface d {
    @NonNull
    <T> T a(@NonNull Class<T> cls);

    @NonNull
    <T extends b> T b(@NonNull Class<T> cls);

    @NonNull
    Context getContext();
}
