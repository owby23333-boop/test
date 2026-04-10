package kotlin.ranges;

import com.anythink.expressad.foundation.d.c;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.f;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: kotlin.m.b, reason: from Kotlin metadata */
/* JADX INFO: compiled from: Progressions.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u001c\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0016\u0018\u0000 \u00172\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0017B\u001f\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0002\u0010\u0006J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0096\u0002J\b\u0010\u0011\u001a\u00020\u0002H\u0016J\b\u0010\u0012\u001a\u00020\u000eH\u0016J\t\u0010\u0013\u001a\u00020\u0014H\u0096\u0002J\b\u0010\u0015\u001a\u00020\u0016H\u0016R\u0011\u0010\u0007\u001a\u00020\u0002¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u0002¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0002¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0018"}, d2 = {"Lkotlin/ranges/IntProgression;", "", "", c.bT, "endInclusive", "step", "(III)V", "first", "getFirst", "()I", "last", "getLast", "getStep", "equals", "", "other", "", TTDownloadField.TT_HASHCODE, "isEmpty", "iterator", "Lkotlin/collections/IntIterator;", "toString", "", "Companion", "kotlin-stdlib"}, k = 1, mv = {1, 4, 0})
public class IntProgression implements Iterable<Integer>, kotlin.jvm.internal.o.a {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final a f20968v = new a(null);

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final int f20969s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final int f20970t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private final int f20971u;

    /* JADX INFO: renamed from: kotlin.m.b$a */
    /* JADX INFO: compiled from: Progressions.kt */
    public static final class a {
        private a() {
        }

        @NotNull
        public final IntProgression a(int i2, int i3, int i4) {
            return new IntProgression(i2, i3, i4);
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    public IntProgression(int i2, int i3, int i4) {
        if (i4 == 0) {
            throw new IllegalArgumentException("Step must be non-zero.");
        }
        if (i4 == Integer.MIN_VALUE) {
            throw new IllegalArgumentException("Step must be greater than Int.MIN_VALUE to avoid overflow on negation.");
        }
        this.f20969s = i2;
        this.f20970t = kotlin.internal.c.b(i2, i3, i4);
        this.f20971u = i4;
    }

    /* JADX INFO: renamed from: a, reason: from getter */
    public final int getF20971u() {
        return this.f20971u;
    }

    public boolean equals(@Nullable Object other) {
        if (other instanceof IntProgression) {
            if (!isEmpty() || !((IntProgression) other).isEmpty()) {
                IntProgression intProgression = (IntProgression) other;
                if (this.f20969s != intProgression.f20969s || this.f20970t != intProgression.f20970t || this.f20971u != intProgression.f20971u) {
                }
            }
            return true;
        }
        return false;
    }

    /* JADX INFO: renamed from: getFirst, reason: from getter */
    public final int getF20969s() {
        return this.f20969s;
    }

    /* JADX INFO: renamed from: getLast, reason: from getter */
    public final int getF20970t() {
        return this.f20970t;
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (((this.f20969s * 31) + this.f20970t) * 31) + this.f20971u;
    }

    public boolean isEmpty() {
        if (this.f20971u > 0) {
            if (this.f20969s > this.f20970t) {
                return true;
            }
        } else if (this.f20969s < this.f20970t) {
            return true;
        }
        return false;
    }

    @NotNull
    public String toString() {
        StringBuilder sb;
        int i2;
        if (this.f20971u > 0) {
            sb = new StringBuilder();
            sb.append(this.f20969s);
            sb.append("..");
            sb.append(this.f20970t);
            sb.append(" step ");
            i2 = this.f20971u;
        } else {
            sb = new StringBuilder();
            sb.append(this.f20969s);
            sb.append(" downTo ");
            sb.append(this.f20970t);
            sb.append(" step ");
            i2 = -this.f20971u;
        }
        sb.append(i2);
        return sb.toString();
    }

    @Override // java.lang.Iterable
    @NotNull
    public Iterator<Integer> iterator() {
        return new c(this.f20969s, this.f20970t, this.f20971u);
    }
}
