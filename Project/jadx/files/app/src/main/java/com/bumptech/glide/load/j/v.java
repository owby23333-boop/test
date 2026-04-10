package com.bumptech.glide.load.j;

import androidx.annotation.NonNull;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.data.d;
import com.bumptech.glide.load.j.n;

/* JADX INFO: compiled from: UnitModelLoader.java */
/* JADX INFO: loaded from: classes2.dex */
public class v<Model> implements n<Model, Model> {
    private static final v<?> a = new v<>();

    /* JADX INFO: compiled from: UnitModelLoader.java */
    public static class a<Model> implements o<Model, Model> {
        private static final a<?> a = new a<>();

        @Deprecated
        public a() {
        }

        public static <T> a<T> b() {
            return (a<T>) a;
        }

        @Override // com.bumptech.glide.load.j.o
        @NonNull
        public n<Model, Model> a(r rVar) {
            return v.a();
        }

        @Override // com.bumptech.glide.load.j.o
        public void a() {
        }
    }

    /* JADX INFO: compiled from: UnitModelLoader.java */
    private static class b<Model> implements com.bumptech.glide.load.data.d<Model> {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        private final Model f13694s;

        b(Model model) {
            this.f13694s = model;
        }

        @Override // com.bumptech.glide.load.data.d
        public void a(@NonNull Priority priority, @NonNull d.a<? super Model> aVar) {
            aVar.a(this.f13694s);
        }

        @Override // com.bumptech.glide.load.data.d
        public void b() {
        }

        @Override // com.bumptech.glide.load.data.d
        public void cancel() {
        }

        @Override // com.bumptech.glide.load.data.d
        @NonNull
        public DataSource getDataSource() {
            return DataSource.LOCAL;
        }

        @Override // com.bumptech.glide.load.data.d
        @NonNull
        public Class<Model> a() {
            return (Class<Model>) this.f13694s.getClass();
        }
    }

    @Deprecated
    public v() {
    }

    public static <T> v<T> a() {
        return (v<T>) a;
    }

    @Override // com.bumptech.glide.load.j.n
    public boolean a(@NonNull Model model) {
        return true;
    }

    @Override // com.bumptech.glide.load.j.n
    public n.a<Model> a(@NonNull Model model, int i2, int i3, @NonNull com.bumptech.glide.load.f fVar) {
        return new n.a<>(new com.bumptech.glide.o.d(model), new b(model));
    }
}
