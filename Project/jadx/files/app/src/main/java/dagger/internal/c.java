package dagger.internal;

/* JADX INFO: compiled from: InstanceFactory.java */
/* JADX INFO: loaded from: classes3.dex */
public final class c<T> implements b<T>, dagger.a<T> {
    private final T a;

    static {
        new c(null);
    }

    private c(T t2) {
        this.a = t2;
    }

    public static <T> b<T> a(T t2) {
        d.a(t2, "instance cannot be null");
        return new c(t2);
    }

    @Override // javax.inject.a, dagger.a
    public T get() {
        return this.a;
    }
}
