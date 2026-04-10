package kotlin.collections;

import java.util.Iterator;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: Iterators.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class u implements Iterator<Integer>, kotlin.jvm.internal.o.a {
    public abstract int a();

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.Iterator
    @NotNull
    public final Integer next() {
        return Integer.valueOf(a());
    }
}
