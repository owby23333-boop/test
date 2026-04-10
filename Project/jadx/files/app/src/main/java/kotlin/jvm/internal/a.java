package kotlin.jvm.internal;

import java.util.Iterator;
import java.util.NoSuchElementException;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: ArrayIterator.kt */
/* JADX INFO: loaded from: classes3.dex */
final class a<T> implements Iterator<T>, kotlin.jvm.internal.o.a {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private int f20958s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    @NotNull
    private final T[] f20959t;

    public a(@NotNull T[] tArr) {
        this.f20959t = tArr;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f20958s < this.f20959t.length;
    }

    @Override // java.util.Iterator
    public T next() {
        try {
            T[] tArr = this.f20959t;
            int i2 = this.f20958s;
            this.f20958s = i2 + 1;
            return tArr[i2];
        } catch (ArrayIndexOutOfBoundsException e2) {
            this.f20958s--;
            throw new NoSuchElementException(e2.getMessage());
        }
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
