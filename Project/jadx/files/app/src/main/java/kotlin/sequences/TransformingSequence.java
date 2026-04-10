package kotlin.sequences;

import androidx.exifinterface.media.ExifInterface;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.b.l;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: kotlin.n.j, reason: from Kotlin metadata */
/* JADX INFO: compiled from: Sequences.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010(\n\u0002\b\u0002\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\b\u0012\u0004\u0012\u0002H\u00020\u0003B'\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006¢\u0006\u0002\u0010\u0007J3\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\t0\u0003\"\u0004\b\u0002\u0010\t2\u0018\u0010\n\u001a\u0014\u0012\u0004\u0012\u00028\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\t0\u000b0\u0006H\u0000¢\u0006\u0002\b\fJ\u000f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00010\u000bH\u0096\u0002R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lkotlin/sequences/TransformingSequence;", ExifInterface.GPS_DIRECTION_TRUE, "R", "Lkotlin/sequences/Sequence;", "sequence", "transformer", "Lkotlin/Function1;", "(Lkotlin/sequences/Sequence;Lkotlin/jvm/functions/Function1;)V", "flatten", ExifInterface.LONGITUDE_EAST, "iterator", "", "flatten$kotlin_stdlib", "kotlin-stdlib"}, k = 1, mv = {1, 4, 0})
public final class TransformingSequence<T, R> implements c<R> {
    private final c<T> a;
    private final l<T, R> b;

    /* JADX INFO: renamed from: kotlin.n.j$a */
    /* JADX INFO: compiled from: Sequences.kt */
    public static final class a implements Iterator<R>, kotlin.jvm.internal.o.a {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        @NotNull
        private final Iterator<T> f20981s;

        a() {
            this.f20981s = TransformingSequence.this.a.iterator();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f20981s.hasNext();
        }

        @Override // java.util.Iterator
        public R next() {
            return (R) TransformingSequence.this.b.invoke(this.f20981s.next());
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public TransformingSequence(@NotNull c<? extends T> cVar, @NotNull l<? super T, ? extends R> lVar) {
        this.a = cVar;
        this.b = lVar;
    }

    @Override // kotlin.sequences.c
    @NotNull
    public Iterator<R> iterator() {
        return new a();
    }
}
