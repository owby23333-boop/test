package kotlin.collections;

import java.util.Collection;
import java.util.Iterator;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: Collections.kt */
/* JADX INFO: loaded from: classes3.dex */
final class b<T> implements Collection<T>, kotlin.jvm.internal.o.a {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    @NotNull
    private final T[] f20950s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final boolean f20951t;

    public b(@NotNull T[] tArr, boolean z2) {
        this.f20950s = tArr;
        this.f20951t = z2;
    }

    public int a() {
        return this.f20950s.length;
    }

    @Override // java.util.Collection
    public boolean add(T t2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean addAll(Collection<? extends T> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean contains(Object obj) {
        return g.a(this.f20950s, obj);
    }

    @Override // java.util.Collection
    public boolean containsAll(@NotNull Collection<? extends Object> collection) {
        if (collection.isEmpty()) {
            return true;
        }
        Iterator<T> it = collection.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        return this.f20950s.length == 0;
    }

    @Override // java.util.Collection, java.lang.Iterable
    @NotNull
    public Iterator<T> iterator() {
        return kotlin.jvm.internal.b.a(this.f20950s);
    }

    @Override // java.util.Collection
    public boolean remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean removeAll(Collection<? extends Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean retainAll(Collection<? extends Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final /* bridge */ int size() {
        return a();
    }

    @Override // java.util.Collection
    @NotNull
    public final Object[] toArray() {
        return j.a(this.f20950s, this.f20951t);
    }

    @Override // java.util.Collection
    public <T> T[] toArray(T[] tArr) {
        return (T[]) kotlin.jvm.internal.e.a(this, tArr);
    }
}
