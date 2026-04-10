package com.bumptech.glide.n;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.h;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: ResourceEncoderRegistry.java */
/* JADX INFO: loaded from: classes2.dex */
public class f {
    private final List<a<?>> a = new ArrayList();

    /* JADX INFO: compiled from: ResourceEncoderRegistry.java */
    private static final class a<T> {
        private final Class<T> a;
        final h<T> b;

        a(@NonNull Class<T> cls, @NonNull h<T> hVar) {
            this.a = cls;
            this.b = hVar;
        }

        boolean a(@NonNull Class<?> cls) {
            return this.a.isAssignableFrom(cls);
        }
    }

    public synchronized <Z> void a(@NonNull Class<Z> cls, @NonNull h<Z> hVar) {
        this.a.add(new a<>(cls, hVar));
    }

    @Nullable
    public synchronized <Z> h<Z> a(@NonNull Class<Z> cls) {
        int size = this.a.size();
        for (int i2 = 0; i2 < size; i2++) {
            a<?> aVar = this.a.get(i2);
            if (aVar.a(cls)) {
                return (h<Z>) aVar.b;
            }
        }
        return null;
    }
}
