package com.bumptech.glide.util;

/* JADX INFO: compiled from: GlideSuppliers.java */
/* JADX INFO: loaded from: classes2.dex */
public final class f {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: compiled from: GlideSuppliers.java */
    class a<T> implements b<T> {
        private volatile T a;
        final /* synthetic */ b b;

        a(b bVar) {
            this.b = bVar;
        }

        @Override // com.bumptech.glide.util.f.b
        public T get() {
            if (this.a == null) {
                synchronized (this) {
                    if (this.a == null) {
                        T t2 = (T) this.b.get();
                        k.a(t2);
                        this.a = t2;
                    }
                }
            }
            return this.a;
        }
    }

    /* JADX INFO: compiled from: GlideSuppliers.java */
    public interface b<T> {
        T get();
    }

    public static <T> b<T> a(b<T> bVar) {
        return new a(bVar);
    }
}
