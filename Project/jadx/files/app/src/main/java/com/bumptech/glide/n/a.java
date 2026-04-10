package com.bumptech.glide.n;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: EncoderRegistry.java */
/* JADX INFO: loaded from: classes2.dex */
public class a {
    private final List<C0276a<?>> a = new ArrayList();

    /* JADX INFO: renamed from: com.bumptech.glide.n.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: EncoderRegistry.java */
    private static final class C0276a<T> {
        private final Class<T> a;
        final com.bumptech.glide.load.a<T> b;

        C0276a(@NonNull Class<T> cls, @NonNull com.bumptech.glide.load.a<T> aVar) {
            this.a = cls;
            this.b = aVar;
        }

        boolean a(@NonNull Class<?> cls) {
            return this.a.isAssignableFrom(cls);
        }
    }

    @Nullable
    public synchronized <T> com.bumptech.glide.load.a<T> a(@NonNull Class<T> cls) {
        for (C0276a<?> c0276a : this.a) {
            if (c0276a.a(cls)) {
                return (com.bumptech.glide.load.a<T>) c0276a.b;
            }
        }
        return null;
    }

    public synchronized <T> void a(@NonNull Class<T> cls, @NonNull com.bumptech.glide.load.a<T> aVar) {
        this.a.add(new C0276a<>(cls, aVar));
    }
}
