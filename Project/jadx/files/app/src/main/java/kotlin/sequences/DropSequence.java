package kotlin.sequences;

import androidx.exifinterface.media.ExifInterface;
import java.util.Iterator;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: kotlin.n.a, reason: from Kotlin metadata */
/* JADX INFO: compiled from: Sequences.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010(\n\u0002\b\u0002\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u001b\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\t\u001a\u00020\u0006H\u0016J\u000f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u000bH\u0096\u0002J\u0016\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\t\u001a\u00020\u0006H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lkotlin/sequences/DropSequence;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/sequences/Sequence;", "Lkotlin/sequences/DropTakeSequence;", "sequence", "count", "", "(Lkotlin/sequences/Sequence;I)V", "drop", "n", "iterator", "", "take", "kotlin-stdlib"}, k = 1, mv = {1, 4, 0})
public final class DropSequence<T> implements c<T>, b<T> {
    private final c<T> a;
    private final int b;

    /* JADX INFO: renamed from: kotlin.n.a$a */
    /* JADX INFO: compiled from: Sequences.kt */
    public static final class a implements Iterator<T>, kotlin.jvm.internal.o.a {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        @NotNull
        private final Iterator<T> f20978s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        private int f20979t;

        a(DropSequence dropSequence) {
            this.f20978s = dropSequence.a.iterator();
            this.f20979t = dropSequence.b;
        }

        private final void a() {
            while (this.f20979t > 0 && this.f20978s.hasNext()) {
                this.f20978s.next();
                this.f20979t--;
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            a();
            return this.f20978s.hasNext();
        }

        @Override // java.util.Iterator
        public T next() {
            a();
            return this.f20978s.next();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public DropSequence(@NotNull c<? extends T> cVar, int i2) {
        this.a = cVar;
        this.b = i2;
        if (this.b >= 0) {
            return;
        }
        throw new IllegalArgumentException(("count must be non-negative, but was " + this.b + '.').toString());
    }

    @Override // kotlin.sequences.c
    @NotNull
    public Iterator<T> iterator() {
        return new a(this);
    }

    @Override // kotlin.sequences.b
    @NotNull
    public c<T> a(int i2) {
        int i3 = this.b + i2;
        return i3 < 0 ? new DropSequence(this, i2) : new DropSequence(this.a, i3);
    }
}
