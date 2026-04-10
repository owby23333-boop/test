package com.bumptech.glide.load.j;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: ModelLoader.java */
/* JADX INFO: loaded from: classes2.dex */
public interface n<Model, Data> {

    /* JADX INFO: compiled from: ModelLoader.java */
    public static class a<Data> {
        public final com.bumptech.glide.load.c a;
        public final List<com.bumptech.glide.load.c> b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final com.bumptech.glide.load.data.d<Data> f13681c;

        public a(@NonNull com.bumptech.glide.load.c cVar, @NonNull com.bumptech.glide.load.data.d<Data> dVar) {
            this(cVar, Collections.emptyList(), dVar);
        }

        public a(@NonNull com.bumptech.glide.load.c cVar, @NonNull List<com.bumptech.glide.load.c> list, @NonNull com.bumptech.glide.load.data.d<Data> dVar) {
            com.bumptech.glide.util.k.a(cVar);
            this.a = cVar;
            com.bumptech.glide.util.k.a(list);
            this.b = list;
            com.bumptech.glide.util.k.a(dVar);
            this.f13681c = dVar;
        }
    }

    @Nullable
    a<Data> a(@NonNull Model model, int i2, int i3, @NonNull com.bumptech.glide.load.f fVar);

    boolean a(@NonNull Model model);
}
