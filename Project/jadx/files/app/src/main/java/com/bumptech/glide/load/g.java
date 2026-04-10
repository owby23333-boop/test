package com.bumptech.glide.load;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.engine.s;
import java.io.IOException;

/* JADX INFO: compiled from: ResourceDecoder.java */
/* JADX INFO: loaded from: classes2.dex */
public interface g<T, Z> {
    @Nullable
    s<Z> a(@NonNull T t2, int i2, int i3, @NonNull f fVar) throws IOException;

    boolean a(@NonNull T t2, @NonNull f fVar) throws IOException;
}
