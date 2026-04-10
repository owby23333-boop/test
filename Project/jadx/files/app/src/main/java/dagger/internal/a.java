package dagger.internal;

/* JADX INFO: compiled from: DoubleCheck.java */
/* JADX INFO: loaded from: classes3.dex */
public final class a<T> implements javax.inject.a<T>, dagger.a<T> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Object f20782c = new Object();
    private volatile javax.inject.a<T> a;
    private volatile Object b = f20782c;

    private a(javax.inject.a<T> aVar) {
        this.a = aVar;
    }

    public static Object a(Object obj, Object obj2) {
        if (!(obj != f20782c) || obj == obj2) {
            return obj2;
        }
        throw new IllegalStateException("Scoped provider was invoked recursively returning different results: " + obj + " & " + obj2 + ". This is likely due to a circular dependency.");
    }

    public static <P extends javax.inject.a<T>, T> javax.inject.a<T> b(P p2) {
        d.a(p2);
        return p2 instanceof a ? p2 : new a(p2);
    }

    @Override // javax.inject.a, dagger.a
    public T get() {
        T t2 = (T) this.b;
        if (t2 == f20782c) {
            synchronized (this) {
                t2 = (T) this.b;
                if (t2 == f20782c) {
                    t2 = this.a.get();
                    a(this.b, t2);
                    this.b = t2;
                    this.a = null;
                }
            }
        }
        return t2;
    }

    public static <P extends javax.inject.a<T>, T> dagger.a<T> a(P p2) {
        if (p2 instanceof dagger.a) {
            return (dagger.a) p2;
        }
        d.a(p2);
        return new a(p2);
    }
}
